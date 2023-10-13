package br.com.compras.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.compras.ui.components.ProductCard
import br.com.compras.ui.viewmodels.ProductListViewModel

@Composable
fun ProductListScreen(viewModel: ProductListViewModel) {

    val products by viewModel.productList.collectAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        items(products) { product ->
            ProductCard(product = product)
        }
    }
}