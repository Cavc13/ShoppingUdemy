package com.udemy.shoppingudemy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udemy.shoppingudemy.domain.ShopItem
import com.udemy.shoppingudemy.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId = 0
    private val shopListLD = MutableLiveData<List<ShopItem>>()

//    init {
//        for (i in 0 until 1000) {
//            val item = ShopItem("Name $i", i, Random.nextBoolean())
//            addShopItem(item)
//        }
//    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
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
        updateList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toMutableList()
    }
}