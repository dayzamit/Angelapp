package com.mycodinglab.angelapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycodinglab.angelapp.Repository.StockRepository
import com.mycodinglab.angelapp.data.StockDetail

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val stockRepository: StockRepository) :
    ViewModel() {

    private val mutableStockLiveData = MutableLiveData<List<StockDetail>?>()

    fun fetchTopStock(

    ): LiveData<List<StockDetail>?> {


        viewModelScope.launch {
            val stockResponse = stockRepository.getTopStockList()

            val stockList = stockResponse.body()
            mutableStockLiveData.value = stockList
        }

        return mutableStockLiveData
    }

}