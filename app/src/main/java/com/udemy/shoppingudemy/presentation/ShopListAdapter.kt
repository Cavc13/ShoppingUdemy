package com.udemy.shoppingudemy.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.udemy.shoppingudemy.R
import com.udemy.shoppingudemy.databinding.ItemShopDisabledBinding
import com.udemy.shoppingudemy.databinding.ItemShopEnabledBinding
import com.udemy.shoppingudemy.domain.ShopItem

class ShopListAdapter: ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    companion object {
        const val VIEW_ACTIVE = 111
        const val VIEW_NOT_ACTIVE = 222
        const val MAX_POOL_SIZE = 30
    }

    var onShopItemLongClickListener: ((ShopItem)-> Unit)? = null
    var onShopItemClickListener: ((ShopItem)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when(viewType) {
            VIEW_ACTIVE     -> R.layout.item_shop_enabled
            VIEW_NOT_ACTIVE -> R.layout.item_shop_disabled
            else -> { throw RuntimeException("Unknown view type: $viewType")}
        }

//        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
        return ShopItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        val binding = holder.binding
        binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        when(binding) {
            is ItemShopDisabledBinding -> {
                binding.shopItem = shopItem
            }
            is ItemShopEnabledBinding -> {
                binding.shopItem = shopItem
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) {
            VIEW_ACTIVE
        } else {
            VIEW_NOT_ACTIVE
        }
    }
}