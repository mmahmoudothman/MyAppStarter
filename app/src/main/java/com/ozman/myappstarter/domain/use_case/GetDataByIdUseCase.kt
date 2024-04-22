package com.ozman.myappstarter.domain.use_case

import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.model.AppDomainModel

class GetDataByIdUseCase(private val repository: AppRepository) {
    suspend operator fun invoke(id: Int): AppDomainModel? {
        return repository.getEntityById(id)
    }
}