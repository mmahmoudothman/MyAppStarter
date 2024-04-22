package com.ozman.myappstarter.domain.repos_interface

import com.ozman.myappstarter.domain.model.AppDomainModel
import kotlinx.coroutines.flow.Flow

interface AppRepositoryInt {
    suspend fun getEntityById(id: Int): AppDomainModel?
    fun getAllEntities(): Flow<List<AppDomainModel>>
    suspend fun insert(appDomainModel: AppDomainModel)
    suspend fun delete(appDomainModel: AppDomainModel)
}