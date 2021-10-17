package com.mycodinglab.coroutinelearnbyexample.data.api

import com.mycodinglab.angelapp.data.StockDetail

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("he-public-data/stocks-descriptive59bdd75.json")
    suspend fun getUsers(): Response<List<StockDetail>>
}