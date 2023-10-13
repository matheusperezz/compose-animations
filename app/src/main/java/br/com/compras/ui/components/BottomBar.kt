package br.com.compras.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val label: String,
    val icon: ImageVector
) {
    object ProductList : BottomBarItem(
        label = "Produtos",
        icon = Icons.Filled.Home
    )

    object Profile : BottomBarItem(
        label = "Perfil",
        icon = Icons.Filled.Person
    )
}

val bottomBarItems = listOf(
    BottomBarItem.ProductList,
    BottomBarItem.Profile
)

@Composable
fun ComprasBottomBar(
    item: BottomBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomBarItem> = emptyList(),
    onItemChange: (BottomBarItem) -> Unit = {}
) {
    NavigationBar(modifier) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                selected = item.label == label,
                label = { Text(text = label) },
                onClick = { onItemChange(it) },
                icon = { Icon(icon, contentDescription = label) }
            )
        }
    }
}