package com.udemy.shoppingudemy.di

import android.app.Application
import com.udemy.shoppingudemy.data.AppDatabase
import com.udemy.shoppingudemy.data.ShopListDao
import com.udemy.shoppingudemy.data.ShopListRepositoryImpl
import com.udemy.shoppingudemy.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideSHopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}