package br.com.compras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.compras.data.foods
import br.com.compras.data.models.Product
import br.com.compras.ui.theme.Typography
import br.com.compras.ui.theme.softBlack
import br.com.compras.ui.theme.softWhite
import kotlin.random.Random

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    val formatPrice = "%.2f".format(product.price)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = softBlack
        ),
    ) {
        Text(
            text = product.name,
            style = Typography.titleMedium,
            color = softWhite,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Text(
            text = "R$ $formatPrice",
            style = Typography.labelSmall,
            color = softWhite,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        Product(
            name = foods[Random.nextInt(0, foods.size)],
            price = Random.nextFloat() * Random.nextInt(1, 100)
        )
    )
}