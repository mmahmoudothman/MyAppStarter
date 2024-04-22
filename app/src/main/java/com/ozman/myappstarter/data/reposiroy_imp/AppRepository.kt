package com.ozman.myappstarter.data.reposiroy_imp

import com.ozman.myappstarter.data.data_source.local.AppDao
import com.ozman.myappstarter.data.data_source.local.AppEntityMapper
import com.ozman.myappstarter.data.data_source.reomte.RetrofitService
import com.ozman.myappstarter.domain.model.AppDomainModel
import com.ozman.myappstarter.domain.repos_interface.AppRepositoryInt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AppRepository(
    val appDao: AppDao,
    val retrofitService: RetrofitService,
    val entityMapper: AppEntityMapper
) : AppRepositoryInt {


    override fun getAllEntities(): Flow<List<AppDomainModel>> = flow {
        val response = appDao.getAllEntities()
        emit(entityMapper.fromEntityList(response.first()))
    }

    override suspend fun getEntityById(id: Int): AppDomainModel? {
        appDao.getEntityById(id)?.let {
            return entityMapper.mapToDomainModule(it)
        } ?: return null
    }


    override suspend fun insert(appDomainModel: AppDomainModel) {
        appDao.insert(entityMapper.mapFromDomainModule(appDomainModel))
    }

    override suspend fun delete(appDomainModel: AppDomainModel) {
        appDao.delete(entityMapper.mapFromDomainModule(appDomainModel))
    }
}