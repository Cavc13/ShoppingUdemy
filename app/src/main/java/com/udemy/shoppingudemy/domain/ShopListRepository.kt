package com.udemy.shoppingudemy.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem (shopItem: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(itemShop: ShopItem)

    fun getShopList() : LiveData<List<ShopItem>>
}