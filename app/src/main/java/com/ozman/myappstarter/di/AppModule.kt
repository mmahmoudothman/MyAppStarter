package com.ozman.myappstarter.di

import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.use_case.AppUseCases
import com.ozman.myappstarter.domain.use_case.DeleteDataUseCase
import com.ozman.myappstarter.domain.use_case.GetDataByIdUseCase
import com.ozman.myappstarter.domain.use_case.GetDataUseCase
import com.ozman.myappstarter.domain.use_case.InsertDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideAppUseCases(repository: AppRepository): AppUseCases {
        return AppUseCases(
            InsertDataUseCase(repository),
            DeleteDataUseCase(repository),
            GetDataUseCase(repository),
            GetDataByIdUseCase(repository)
        )
    }

}