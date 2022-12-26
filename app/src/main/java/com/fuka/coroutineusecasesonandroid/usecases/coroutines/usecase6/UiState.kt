package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase6

import com.fuka.coroutineusecasesonandroid.mock.AndroidVersion

sealed class UiState {
    object Loading : UiState()
    data class Success(val recentVersions: List<AndroidVersion>) : UiState()
    data class Error(val message: String) : UiState()
}