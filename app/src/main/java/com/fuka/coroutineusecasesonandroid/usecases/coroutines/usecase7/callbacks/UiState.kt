package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase7.callbacks

import com.fuka.coroutineusecasesonandroid.mock.VersionFeatures

sealed class UiState {
    object Loading : UiState()
    data class Success(val versionFeatures: List<VersionFeatures>) : UiState()
    data class Error(val message: String) : UiState()
}