package com.udemy.shoppingudemy.domain

import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository,
) {
    suspend fun addShopItem(itemShop: ShopItem) {
        shopListRepository.addShopItem(itemShop)
    }
}