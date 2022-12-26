package com.fuka.coroutineusecasesonandroid.usecases.flow.usecase2

import com.fuka.coroutineusecasesonandroid.usecases.flow.mock.Stock

sealed class UiState {
    object Loading : UiState()
    data class Success(val stockList: List<Stock>) : UiState()
    data class Error(val message: String) : UiState()
}