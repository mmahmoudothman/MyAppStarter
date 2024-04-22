package com.ozman.myappstarter.di

import android.content.Context
import androidx.room.Room
import com.ozman.myappstarter.data.data_source.local.AppDao
import com.ozman.myappstarter.data.data_source.local.AppDatabase
import com.ozman.myappstarter.data.data_source.local.AppEntityMapper
import com.ozman.myappstarter.data.data_source.reomte.AppDtoMapper
import com.ozman.myappstarter.data.data_source.reomte.RetrofitService
import com.ozman.myappstarter.data.reposiroy_imp.AppRepository
import com.ozman.myappstarter.domain.repos_interface.AppRepositoryInt
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providesAppDtoMapper() = AppDtoMapper()


    @Singleton
    @Provides
    fun provideAppEntityMapper() = AppEntityMapper()


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideDao(
        database: AppDatabase
    ) = database.appDao()

    @Singleton
    @Provides
    fun providesRepository(
        appDao: AppDao,
        retrofitService: RetrofitService,
        entityMapper: AppEntityMapper,
    ): AppRepositoryInt {
        return AppRepository(appDao, retrofitService, entityMapper)
    }

}