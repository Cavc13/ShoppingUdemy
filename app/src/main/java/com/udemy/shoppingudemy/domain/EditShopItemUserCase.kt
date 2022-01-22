package com.udemy.shoppingudemy.domain

class EditShopItemUserCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem (shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}