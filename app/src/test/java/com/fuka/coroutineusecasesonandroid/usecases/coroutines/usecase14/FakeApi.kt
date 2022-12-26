package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase14

import com.fuka.coroutineusecasesonandroid.mock.AndroidVersion
import com.fuka.coroutineusecasesonandroid.mock.MockApi
import com.fuka.coroutineusecasesonandroid.mock.VersionFeatures
import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions
import com.fuka.coroutineusecasesonandroid.utils.EndpointShouldNotBeCalledException
import kotlinx.coroutines.delay

class FakeApi : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        delay(1)
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}