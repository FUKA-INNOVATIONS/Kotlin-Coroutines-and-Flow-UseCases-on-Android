package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase2

import com.google.gson.Gson
import com.fuka.coroutineusecasesonandroid.mock.createMockApi
import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions
import com.fuka.coroutineusecasesonandroid.mock.mockVersionFeaturesAndroid10
import com.fuka.coroutineusecasesonandroid.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1500
        )
        .mock(
            "http://localhost/android-version-features/29",
            { Gson().toJson(mockVersionFeaturesAndroid10) },
            200,
            1500
        )
)