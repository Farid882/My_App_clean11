package com.example.myappclean11.domain

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopItemRepository.addShopItem(shopItem)
    }
}