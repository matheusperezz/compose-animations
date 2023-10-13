package br.com.compras.ui.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.compras.ui.screens.ProductListScreen
import br.com.compras.ui.viewmodels.ProductListViewModel

internal const val productListRoute = "products"

fun NavGraphBuilder.productListScreen(navController: NavHostController){
    composable(productListRoute){
        val viewModel = viewModel<ProductListViewModel>()
        ProductListScreen(viewModel = viewModel)
    }
}

fun NavController.navigateToProductList(
    navOptions: NavOptions? = null
){
    navigate(productListRoute, navOptions)
}