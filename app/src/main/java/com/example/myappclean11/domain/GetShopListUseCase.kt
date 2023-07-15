package com.example.myappclean11.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopItemRepository.getShopList()
    }
}