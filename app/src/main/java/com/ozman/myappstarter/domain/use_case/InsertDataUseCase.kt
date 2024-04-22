package com.ozman.myappstarter.domain.use_case

import com.ozman.myappstarter.data.data_source.local.InvalidDataException
import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.model.AppDomainModel

class InsertDataUseCase(private val repository: AppRepository) {
    suspend operator fun invoke(data: AppDomainModel) {
        if (data.title.isBlank()) {
            throw InvalidDataException("The title of the entity can't be empty.")
        }
        repository.insert(data)
    }
}