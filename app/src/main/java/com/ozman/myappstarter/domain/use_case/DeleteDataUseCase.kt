package com.ozman.myappstarter.domain.use_case

import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.model.AppDomainModel

class DeleteDataUseCase(private val repository: AppRepository) {

    suspend operator fun invoke(model: AppDomainModel) {
        repository.delete(model)
    }
}