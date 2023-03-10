package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase2.callbacks

import com.fuka.coroutineusecasesonandroid.mock.AndroidVersion
import com.fuka.coroutineusecasesonandroid.mock.VersionFeatures
import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions
import retrofit2.Call
import retrofit2.mock.Calls
import java.io.IOException

class FakeFeaturesErrorApi : CallbackMockApi {

    override fun getRecentAndroidVersions(): Call<List<AndroidVersion>> {
        return Calls.response(mockAndroidVersions)
    }

    override fun getAndroidVersionFeatures(apiLevel: Int): Call<VersionFeatures> {
        return Calls.failure(IOException())
    }
}