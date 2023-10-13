package br.com.compras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.compras.ui.components.BottomBarItem
import br.com.compras.ui.components.ComprasBottomBar
import br.com.compras.ui.components.ProductFab
import br.com.compras.ui.components.bottomBarItems
import br.com.compras.ui.navigation.ComprasNavHost
import br.com.compras.ui.navigation.navigateSingleTopWithPopUpTo
import br.com.compras.ui.navigation.productListRoute
import br.com.compras.ui.theme.ComprasTheme
import br.com.compras.ui.theme.softWhite
import br.com.compras.ui.viewmodels.ProductListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination
            ComprasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel by viewModels<ProductListViewModel>()
                    val currentRoute = currentDestination?.route
                    val selectedItem: BottomBarItem by remember(currentDestination) {
                        val item = when (currentRoute){
                            productListRoute -> BottomBarItem.ProductList
                            else -> BottomBarItem.ProductList
                        }
                        mutableStateOf(item)
                    }
                    val containsInBottomBarItems = when(currentRoute) {
                        productListRoute -> true
                        else -> false
                    }

                    val isShowFab = when(currentDestination?.route){
                        productListRoute -> true
                        else -> false
                    }

                    ComprasApp(
                        onFabClick = { viewModel.addRandomProduct() },
                        bottomBarItemSelected = selectedItem,
                        onBottomBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        isShowFab = isShowFab
                    ) {
                        ComprasNavHost(navController = navController)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComprasApp(
    bottomBarItemSelected: BottomBarItem = bottomBarItems.first(),
    onBottomBarItemSelectedChange: (BottomBarItem) -> Unit = {},
    isShowTopBar: Boolean = false,
    isShowBottomBar: Boolean = false,
    isShowFab: Boolean = true,
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {},
        bottomBar = {
            ComprasBottomBar(
                item = bottomBarItemSelected,
                items = bottomBarItems,
                onItemChange = onBottomBarItemSelectedChange
            )
        },
        floatingActionButton = {
            if (isShowFab){
                ProductFab {
                    onFabClick()
                }
            }
        },
        modifier = Modifier.background(softWhite)
    ) {
        Box(modifier = Modifier.padding(it)){
            content()
        }
    }
}