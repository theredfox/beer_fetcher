package com.consultingmine.fetcher.beer.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier,
    fieldValue: String?,
    onSearchChange: ((text: String) -> Unit)? = null
) {
    Row(
        modifier = modifier
    ){
       TextField(
           modifier = Modifier
               .fillMaxWidth()
               .padding(10.dp),
           value = fieldValue ?: "",
           onValueChange = { text ->
               onSearchChange?.invoke(text)
           }
       )
    }
}