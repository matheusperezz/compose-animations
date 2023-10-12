package br.com.compras.ui.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.compras.R
import br.com.compras.ui.theme.softBlack
import br.com.compras.ui.theme.softWhite

@Composable
fun ProductHomeFab(onFabClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = { onFabClick() },
        contentColor = softWhite,
        containerColor = softBlack
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHomeFabPreview() {
    ProductHomeFab()
}