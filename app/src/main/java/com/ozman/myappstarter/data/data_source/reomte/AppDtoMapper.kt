package com.ozman.myappstarter.data.data_source.reomte

import com.ozman.myappstarter.domain.DomainMapper
import com.ozman.myappstarter.domain.model.AppDomainModel

class AppDtoMapper : DomainMapper<AppDto, AppDomainModel> {
    override fun mapToDomainModule(model: AppDto): AppDomainModel {
        return AppDomainModel(model.title, model.id)
    }

    override fun mapFromDomainModule(appDomainModel: AppDomainModel): AppDto {
        return AppDto(appDomainModel.title, appDomainModel.id)
    }
}