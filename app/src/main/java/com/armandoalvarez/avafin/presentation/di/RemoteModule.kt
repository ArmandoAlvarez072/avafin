package com.armandoalvarez.avafin.presentation.di

import com.armandoalvarez.avafin.data.api.ApiService
import com.armandoalvarez.avafin.data.repository.datasource.AvaFinRemoteDataSource
import com.armandoalvarez.avafin.data.repository.datasourceimpl.AvaFinRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun providesLoginRemoteDataSource(
        apiService: ApiService
    ): AvaFinRemoteDataSource {
        return AvaFinRemoteDataSourceImpl(apiService)
    }

}