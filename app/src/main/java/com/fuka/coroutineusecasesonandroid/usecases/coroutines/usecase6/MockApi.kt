package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase6

import com.google.gson.Gson
import com.fuka.coroutineusecasesonandroid.mock.createMockApi
import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions
import com.fuka.coroutineusecasesonandroid.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1000
        )
)