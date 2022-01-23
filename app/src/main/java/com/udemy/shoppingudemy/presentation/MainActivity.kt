package com.udemy.shoppingudemy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.udemy.shoppingudemy.R
import com.udemy.shoppingudemy.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView(){
        adapter = ShopListAdapter()
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list).apply {
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_ACTIVE,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_NOT_ACTIVE,
                ShopListAdapter.MAX_POOL_SIZE
            )
        }
        rvShopList.adapter = adapter

    }

}