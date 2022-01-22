package com.udemy.shoppingudemy.data

import com.udemy.shoppingudemy.domain.ShopItem
import com.udemy.shoppingudemy.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun addShopItem(itemShop: ShopItem) {
        if (itemShop.id == ShopItem.UNDEFINED_ID) {
            itemShop.id = autoIncrementId++
        }
        shopList.add(itemShop)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}