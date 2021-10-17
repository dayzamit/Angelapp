package com.mycodinglab.angelapp.Repository

import com.mycodinglab.coroutinelearnbyexample.data.api.ApiHelper
import javax.inject.Inject

class StockRepository @Inject constructor(private val apihelpr: ApiHelper) {

    suspend fun getTopStockList() =
        apihelpr.getStockList()


}