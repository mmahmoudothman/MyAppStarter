package com.ozman.myappstarter.domain.use_case

import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.model.AppDomainModel
import kotlinx.coroutines.flow.Flow

class GetDataUseCase(private val repository: AppRepository) {
    operator fun invoke(): Flow<List<AppDomainModel>> {
        return repository.getAllEntities()
    }
}