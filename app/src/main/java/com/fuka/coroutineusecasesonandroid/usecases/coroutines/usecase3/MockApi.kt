package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase3

import com.google.gson.Gson
import com.fuka.coroutineusecasesonandroid.mock.createMockApi
import com.fuka.coroutineusecasesonandroid.mock.mockVersionFeaturesAndroid10
import com.fuka.coroutineusecasesonandroid.mock.mockVersionFeaturesOreo
import com.fuka.coroutineusecasesonandroid.mock.mockVersionFeaturesPie
import com.fuka.coroutineusecasesonandroid.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/android-version-features/27",
            { Gson().toJson(mockVersionFeaturesOreo) },
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/28",
            { Gson().toJson(mockVersionFeaturesPie) },
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/29",
            { Gson().toJson(mockVersionFeaturesAndroid10) },
            200,
            1000
        )
)