package com.example.myappclean11.domain

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopItemRepository.deleteShopItem(shopItem)
    }
}