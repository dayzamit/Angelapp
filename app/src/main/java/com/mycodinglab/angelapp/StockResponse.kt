package com.mycodinglab.angelapp

import com.mycodinglab.angelapp.data.StockDetail

data class StockResponse(
    val stockList: List<StockDetail>,
    val status: String,
    val totalResults: Int
)