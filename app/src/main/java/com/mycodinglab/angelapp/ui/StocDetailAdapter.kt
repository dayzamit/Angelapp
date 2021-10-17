package com.mycodinglab.angelapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.mycodinglab.angelapp.databinding.RowStockIdBinding

import com.mycodinglab.angelapp.data.StockDetail
import com.mycodinglab.angelapp.ui.StocDetailAdapter.StocRecyclerViewHolder


class StocDetailAdapter :
    ListAdapter<StockDetail, StocRecyclerViewHolder>(object : DiffUtil.ItemCallback<StockDetail>() {
        override fun areItemsTheSame(oldItem: StockDetail, newItem: StockDetail): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: StockDetail, newItem: StockDetail): Boolean {
            return oldItem.securityId == newItem.securityId
                    && oldItem.securityName == newItem.securityName

        }

    }) {


    inner class StocRecyclerViewHolder(itemBinding: RowStockIdBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocRecyclerViewHolder {
        val binding =
            RowStockIdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StocRecyclerViewHolder, position: Int) {
        RowStockIdBinding.bind(holder.itemView).apply {
            val stockDetailObj = getItem(position)
            textViewStockName.text = stockDetailObj.securityId
            textViewStockNameDetails.text = stockDetailObj.securityName
        }
    }

}