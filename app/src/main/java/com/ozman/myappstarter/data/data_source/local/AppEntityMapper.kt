package com.ozman.myappstarter.data.data_source.local

import com.ozman.myappstarter.domain.DomainMapper
import com.ozman.myappstarter.domain.model.AppDomainModel

class AppEntityMapper : DomainMapper<AppEntity, AppDomainModel> {
    override fun mapToDomainModule(model: AppEntity): AppDomainModel {
        return AppDomainModel(model.title, model.id)
    }

    override fun mapFromDomainModule(appDomainModel: AppDomainModel): AppEntity {
        return AppEntity(appDomainModel.title, appDomainModel.id)
    }


    fun fromEntityList(initial: List<AppEntity>): List<AppDomainModel> {
        return initial.map { mapToDomainModule(it) }
    }

    fun toEntityList(initial: List<AppDomainModel>): List<AppEntity> {
        return initial.map { mapFromDomainModule(it) }
    }
}