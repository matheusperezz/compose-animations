package br.com.compras.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.compras.ui.screens.ProfileScreen

internal const val profileRoute = "profile"

fun NavGraphBuilder.profileScreen(navController: NavHostController){
    composable(profileRoute){
        ProfileScreen()
    }
}

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null
){
    navigate(profileRoute, null)
}