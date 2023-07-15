package com.example.myappclean11.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {
    fun addShopItem(shopItem:ShopItem)
    fun deleteShopItem(shopItem:ShopItem)
    fun editeShopItem(shopItem:ShopItem)
    fun getShopItem(shopItemId:Int):ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}