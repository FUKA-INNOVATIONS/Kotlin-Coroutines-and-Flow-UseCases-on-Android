package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase1

import com.fuka.coroutineusecasesonandroid.mock.AndroidVersion
import com.fuka.coroutineusecasesonandroid.mock.MockApi
import com.fuka.coroutineusecasesonandroid.mock.VersionFeatures
import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions
import com.fuka.coroutineusecasesonandroid.utils.EndpointShouldNotBeCalledException

class FakeSuccessApi : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}