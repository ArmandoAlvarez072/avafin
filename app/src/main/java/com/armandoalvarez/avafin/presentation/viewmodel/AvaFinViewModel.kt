package com.armandoalvarez.avafin.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armandoalvarez.avafin.R
import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.data.util.Network
import com.armandoalvarez.avafin.data.util.Resource
import com.armandoalvarez.avafin.domain.usecase.GetCustomerInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AvaFinViewModel @Inject constructor(
    private val application: Application,
    private val getCustomerInfoUseCase: GetCustomerInfoUseCase,
) : ViewModel() {

    private val customerState = MutableStateFlow<Resource<CustomerResponse>>(Resource.Error(null))
    val customerInfoState: StateFlow<Resource<CustomerResponse>> = customerState

    fun getCustomerInfo() = viewModelScope.launch {
        customerState.value = Resource.Loading()
        if (Network.isNetworkAvailable(application)) {
            val apiResult = getCustomerInfoUseCase.execute()
            customerState.value = apiResult
        } else {
            customerState.value = Resource.Error(application.getString(R.string.network_error))
        }

    }


}