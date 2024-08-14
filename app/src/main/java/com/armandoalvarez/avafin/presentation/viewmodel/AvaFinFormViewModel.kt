package com.armandoalvarez.avafin.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AvaFinFormViewModel @Inject constructor() : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var isEmailError by mutableStateOf(false)
    var isPasswordError by mutableStateOf(false)

    fun updateEmail(value: String) {
        email = value
        isEmailError = email.isBlank()
    }

    fun updatePassword(value: String) {
        password = value
        isPasswordError = password.isBlank()
    }

    fun validateFields(): Boolean {
        isEmailError = email.isBlank()
        isPasswordError = password.isBlank()

        return !isEmailError && !isPasswordError
    }
}


