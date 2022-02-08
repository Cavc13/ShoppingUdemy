package com.udemy.shoppingudemy.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    suspend fun deleteShopItem(shopItem: ShopItem)

    suspend fun editShopItem (shopItem: ShopItem)

    suspend fun getShopItem(id: Int): ShopItem

    suspend fun addShopItem(itemShop: ShopItem)

    fun getShopList() : LiveData<List<ShopItem>>
}