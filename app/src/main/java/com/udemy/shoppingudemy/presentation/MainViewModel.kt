package com.udemy.shoppingudemy.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udemy.shoppingudemy.data.ShopListRepositoryImpl
import com.udemy.shoppingudemy.domain.DeleteShopItemUseCase
import com.udemy.shoppingudemy.domain.EditShopItemUseCase
import com.udemy.shoppingudemy.domain.GetShopListUseCase
import com.udemy.shoppingudemy.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem (shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}