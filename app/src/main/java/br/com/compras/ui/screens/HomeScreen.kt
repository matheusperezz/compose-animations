package br.com.compras.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.compras.ui.components.ProductCard
import br.com.compras.ui.components.ProductHomeFab
import br.com.compras.ui.theme.softBlack
import br.com.compras.ui.theme.softWhite
import br.com.compras.ui.viewmodels.HomeScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {

    val products by viewModel.productList.collectAsState(emptyList())


    Scaffold(
        topBar = {},
        bottomBar = {},
        floatingActionButton = {
            ProductHomeFab {
                viewModel.addRandomProduct()
            }
        },
        modifier = Modifier.background(softWhite)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {

            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}