package com.armandoalvarez.avafin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.armandoalvarez.avafin.data.util.Resource
import com.armandoalvarez.avafin.presentation.viewmodel.AvaFinViewModel
import com.armandoalvarez.avafin.ui.components.LoadingDialog
import com.armandoalvarez.avafin.ui.components.PrimaryButton
import com.google.gson.Gson

@Composable
fun AvaFin(
    navController: NavController,
    viewModel: AvaFinViewModel = hiltViewModel(),
) {
    val state by viewModel.customerInfoState.collectAsState()

    when (state) {
        is Resource.Loading -> {
            LoadingDialog(showDialog = true)
        }

        is Resource.Success -> {
            LoadingDialog(false)
            val customer = Gson().toJson(state.data).replace("?:", "")
            navController.navigate("form/$customer")
        }

        is Resource.Error -> {
            LoadingDialog(false)
        }
    }

    Column(Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            stringResource(R.string.start_text)
        ) {
            viewModel.getCustomerInfo()
        }

        Spacer(modifier = Modifier.weight(1f))

    }
}