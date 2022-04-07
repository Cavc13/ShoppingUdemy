package com.udemy.shoppingudemy.presentation

import android.app.Application
import com.udemy.shoppingudemy.di.DaggerApplicationComponent

class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}