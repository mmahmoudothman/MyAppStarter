package com.ozman.myappstarter.domain

import com.ozman.myappstarter.domain.model.AppDomainModel

interface DomainMapper<T, DAppDomainModel> {
    fun mapToDomainModule(model: T): AppDomainModel

    fun mapFromDomainModule(appDomainModel: AppDomainModel): T
}