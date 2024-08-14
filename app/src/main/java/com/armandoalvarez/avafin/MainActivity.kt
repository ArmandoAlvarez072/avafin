package com.armandoalvarez.avafin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.armandoalvarez.avafin.data.model.CustomerResponse
import com.armandoalvarez.avafin.ui.theme.AvaFinTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvaFinTheme {
                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController, startDestination = "home",
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable("home",
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(
                                animationSpec = tween(
                                    600
                                )
                            )
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut(
                                animationSpec = tween(
                                    600
                                )
                            )
                        }) {
                        AvaFin(navController = navController)
                    }
                    composable(
                        "form/{customer}",
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(
                                animationSpec = tween(
                                    600
                                )
                            )
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }) + fadeOut(
                                animationSpec = tween(
                                    600
                                )
                            )
                        },
                        arguments = listOf(navArgument("customer") { type = NavType.StringType })

                    ) {backStackEntry ->
                        val jsonUser = backStackEntry.arguments?.getString("customer")


                        val customer = Gson().fromJson(jsonUser, CustomerResponse::class.java)
                        Form(customer = customer)
                    }
                }
            }
        }
    }
}