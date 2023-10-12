package br.com.compras.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.compras.data.foods
import br.com.compras.data.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class HomeScreenViewModel: ViewModel() {

    private val _productList = MutableStateFlow(listOf<Product>())
    val productList = _productList.asStateFlow()

    fun addRandomProduct() {
        val product = (Product(
            name = foods[Random.nextInt(0, foods.size)],
            price = Random.nextFloat() * Random.nextInt(1, 100)
        ))

        _productList.value = _productList.value + product
    }

}