package com.udemy.shoppingudemy.domain

class AddShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun addShopItem(itemShop: ShopItem) {
        shopListRepository.addShopItem(itemShop)
    }
}