package com.mycodinglab.coroutinelearnbyexample.data.api


import com.mycodinglab.angelapp.data.StockDetail
import retrofit2.Response

interface ApiHelper {

    suspend fun getStockList() : Response<List<StockDetail>>
}