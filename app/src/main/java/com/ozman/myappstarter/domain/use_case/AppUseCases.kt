package com.ozman.myappstarter.domain.use_case

data class AppUseCases(
    val insertDataUseCase: InsertDataUseCase,
    val deleteDataUseCase: DeleteDataUseCase,
    val getDataUseCase: GetDataUseCase,
    val getDataByIdUseCase: GetDataByIdUseCase
)