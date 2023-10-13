package br.com.compras.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import androidx.navigation.navigation
import br.com.compras.ui.components.BottomBarItem

internal const val homeGraphRoute = "home"

fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation(
        startDestination = productListRoute,
        route = homeGraphRoute
    ){
        productListScreen(navController)
        profileScreen(navController)
    }
}

fun NavController.navigateToHomeGraph(){
    navigate(homeGraphRoute)
}

fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomBarItem
){
    val (route, navigate) = when (item){
        BottomBarItem.ProductList -> Pair(
            productListRoute,
            ::navigateToProductList
        )
        BottomBarItem.Profile -> Pair(
            profileRoute,
            ::navigateToProfile
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }

    navigate(navOptions)
}