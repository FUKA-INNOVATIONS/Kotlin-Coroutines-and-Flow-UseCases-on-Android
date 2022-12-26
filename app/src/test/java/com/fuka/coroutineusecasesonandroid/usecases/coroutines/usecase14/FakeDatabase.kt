package com.fuka.coroutineusecasesonandroid.usecases.coroutines.usecase14

import com.fuka.coroutineusecasesonandroid.mock.mockAndroidVersions

class FakeDatabase : AndroidVersionDao {

    var insertedIntoDb = false

    override suspend fun getAndroidVersions(): List<AndroidVersionEntity> {
        return mockAndroidVersions.mapToEntityList()
    }

    override suspend fun insert(androidVersionEntity: AndroidVersionEntity) {
        insertedIntoDb = true
    }

    override suspend fun clear() {}

}