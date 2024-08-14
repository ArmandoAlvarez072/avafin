package com.armandoalvarez.avafin.domain.repository

import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.data.util.Resource

interface AvaFinRepository {
    suspend  fun getCustomerInfo(): Resource<CustomerResponse>
}