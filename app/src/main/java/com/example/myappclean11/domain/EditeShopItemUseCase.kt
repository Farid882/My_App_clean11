package com.example.myappclean11.domain

class EditeShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun editeShopItem(shopItem: ShopItem) {
        shopItemRepository.editeShopItem(shopItem)
    }
}