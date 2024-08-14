package com.armandoalvarez.avafin.data.api

import com.armandoalvarez.avafin.data.model.CustomerResponse
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

    @POST("user")
    suspend fun getCustomerInfo(): Response<CustomerResponse>

}