package com.example.myappclean11.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myappclean11.domain.ShopItem
import com.example.myappclean11.domain.ShopItemRepository

object ShopItemRepositoryImpl : ShopItemRepository {

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private var autoIncrement = 0

    init {
        for (i in 0 until 10){
            val item = ShopItem("$i", i,true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrement++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editeShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }?:throw IllegalArgumentException("shopItem not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
       return shopListLD
    }
    fun updateList(){
        shopListLD.value= shopList.toList()
    }
}