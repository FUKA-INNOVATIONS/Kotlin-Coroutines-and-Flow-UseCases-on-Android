package com.fuka.coroutineusecasesonandroid.usecases.flow.usecase4

import android.content.Context
import com.google.gson.Gson
import com.fuka.coroutineusecasesonandroid.usecases.flow.mock.createFlowMockApi
import com.fuka.coroutineusecasesonandroid.usecases.flow.mock.fakeCurrentStockPrices
import com.fuka.coroutineusecasesonandroid.utils.MockNetworkInterceptor

fun mockApi(context: Context) =
    createFlowMockApi(
        MockNetworkInterceptor()
            .mock(
                path = "/current-stock-prices",
                body = { Gson().toJson(fakeCurrentStockPrices(context)) },
                status = 200,
                delayInMs = 1500,
            )
    )