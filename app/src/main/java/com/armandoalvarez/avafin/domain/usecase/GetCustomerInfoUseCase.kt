package com.armandoalvarez.avafin.domain.usecase

import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.data.util.Resource
import com.armandoalvarez.avafin.domain.repository.AvaFinRepository

class GetCustomerInfoUseCase(
    private val avaFinRepository: AvaFinRepository
) {
    suspend fun execute(): Resource<CustomerResponse> {
        return avaFinRepository.getCustomerInfo()
    }
}

