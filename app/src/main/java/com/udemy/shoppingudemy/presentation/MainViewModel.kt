package com.udemy.shoppingudemy.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.shoppingudemy.data.ShopListRepositoryImpl
import com.udemy.shoppingudemy.domain.DeleteShopItemUseCase
import com.udemy.shoppingudemy.domain.EditShopItemUseCase
import com.udemy.shoppingudemy.domain.GetShopListUseCase
import com.udemy.shoppingudemy.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase : GetShopListUseCase,
    private val deleteShopItemUseCase : DeleteShopItemUseCase,
    private val editShopItemUseCase : EditShopItemUseCase
) : ViewModel() {

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}