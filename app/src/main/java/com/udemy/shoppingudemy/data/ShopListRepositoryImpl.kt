package com.udemy.shoppingudemy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udemy.shoppingudemy.domain.ShopItem
import com.udemy.shoppingudemy.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val mapper: ShopListMapper,
    private val shopListDao: ShopListDao
): ShopListRepository {

    override suspend fun addShopItem(itemShop: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(itemShop))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun getShopItem(id: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(id)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        shopListDao.getShopList()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }
}