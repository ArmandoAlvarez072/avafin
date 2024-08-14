package com.armandoalvarez.avafin.data.repository.datasource

import com.armandoalvarez.avafin.data.model.CustomerResponse
import retrofit2.Response

interface AvaFinRemoteDataSource {

    suspend fun getCustomerInfo(): Response<CustomerResponse>

}