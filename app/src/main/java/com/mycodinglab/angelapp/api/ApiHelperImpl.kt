package com.mycodinglab.coroutinelearnbyexample.data.api


import com.mycodinglab.angelapp.data.StockDetail
import retrofit2.Response
import javax.inject.Inject

 class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper{
    override suspend fun getStockList(): Response<List<StockDetail>> = apiService.getUsers()
}