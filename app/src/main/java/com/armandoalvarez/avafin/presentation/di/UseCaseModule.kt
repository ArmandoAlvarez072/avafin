package com.armandoalvarez.avafin.presentation.di

import com.armandoalvarez.avafin.domain.repository.AvaFinRepository
import com.armandoalvarez.avafin.domain.usecase.GetCustomerInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetCustomerInfoUseCase(
        avaFinRepository: AvaFinRepository
    ): GetCustomerInfoUseCase {
        return GetCustomerInfoUseCase(avaFinRepository)
    }

}