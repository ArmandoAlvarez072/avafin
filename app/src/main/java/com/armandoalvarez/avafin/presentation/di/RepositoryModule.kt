package com.armandoalvarez.avafin.presentation.di

import com.armandoalvarez.avafin.data.repository.AvaFinRepositoryImpl
import com.armandoalvarez.avafin.data.repository.datasource.AvaFinRemoteDataSource
import com.armandoalvarez.avafin.domain.repository.AvaFinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesLoginRepository(
        avaFinRemoteDataSource: AvaFinRemoteDataSource,
    ): AvaFinRepository {
        return AvaFinRepositoryImpl(avaFinRemoteDataSource)
    }

}