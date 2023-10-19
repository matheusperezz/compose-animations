package br.com.compras.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import br.com.compras.ui.theme.softBlack
import br.com.compras.ui.theme.softWhite

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
    item: MutableState<BottomBarItem>,
    modifier: Modifier = Modifier,
    items: List<BottomBarItem> = emptyList(),
    onItemChange: (BottomBarItem) -> Unit = {}
) {
    NavigationBar(
        modifier = modifier,
        containerColor = softBlack,
    ) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                selected = item == it,
                label = { Text(text = label, style = TextStyle(softWhite)) },
                onClick = {
                    onItemChange(it)
                },
                icon = { Icon(icon, contentDescription = label, tint = softWhite) }
            )
        }
    }
}