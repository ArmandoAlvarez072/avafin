package com.armandoalvarez.avafin.data.repository.datasourceimpl

import com.armandoalvarez.avafin.data.api.ApiService
import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.data.repository.datasource.AvaFinRemoteDataSource
import retrofit2.Response

class AvaFinRemoteDataSourceImpl(
    private val apiService: ApiService
) : AvaFinRemoteDataSource {

    override suspend fun getCustomerInfo(): Response<CustomerResponse> {
        return apiService.getCustomerInfo()
    }
}