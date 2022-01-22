package com.udemy.shoppingudemy.domain

interface ShopListRepository {
    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem (shopItem: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(itemShop: ShopItem)

    fun getShopList() : List<ShopItem>
}