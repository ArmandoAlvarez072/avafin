package com.armandoalvarez.avafin.data.repository

import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.data.repository.datasource.AvaFinRemoteDataSource
import com.armandoalvarez.avafin.data.util.Resource
import com.armandoalvarez.avafin.data.util.Util
import com.armandoalvarez.avafin.domain.repository.AvaFinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AvaFinRepositoryImpl(
    private val avaFinRemoteDataSource: AvaFinRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AvaFinRepository {


    override suspend fun getCustomerInfo(): Resource<CustomerResponse> = withContext(dispatcher) {
        Util.responseToResource(avaFinRemoteDataSource.getCustomerInfo())
    }

}