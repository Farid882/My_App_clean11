package com.example.myappclean11.presentation

import androidx.lifecycle.ViewModel
import com.example.myappclean11.data.ShopItemRepositoryImpl
import com.example.myappclean11.domain.DeleteShopItemUseCase
import com.example.myappclean11.domain.EditeShopItemUseCase
import com.example.myappclean11.domain.GetShopItemUseCase
import com.example.myappclean11.domain.GetShopListUseCase
import com.example.myappclean11.domain.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopItemRepositoryImpl
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editeShopItemUseCase = EditeShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeStateShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editeShopItemUseCase.editeShopItem(newItem)
    }
}