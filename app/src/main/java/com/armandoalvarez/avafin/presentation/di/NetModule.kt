package com.armandoalvarez.avafin.presentation.di

import com.armandoalvarez.avafin.data.api.ApiService
import com.armandoalvarez.avafin.data.util.MockInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .setLenient()
            .create()
    }


    @Provides
    @Singleton
    fun providesRetrofit(
        mockInterceptor: MockInterceptor,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://avafin.com/") // URL base ficticia
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(mockInterceptor)
                    .build()
            )
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(
        retrofit: Retrofit
    ): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}