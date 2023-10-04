package com.consultingmine.fetcher.beer.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.*
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.consultingmine.fetcher.beer.ui.widgets.BeerListItem
import com.consultingmine.fetcher.beer.ui.widgets.TopBar

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainScreen(
    listState: LazyListState,
    state: MainScreenContract.State,
    onNewSearch: ((text: String) -> Unit)?
) {
    Column {
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            fieldValue = state.search,
            onSearchChange = { search -> onNewSearch?.invoke(search) }
        )
        
        LazyColumn {
            items(state.beers) {
                BeerListItem(
                    imageUrl = it.imageUrl,
                    name = it.name,
                    description = it.description,
                    ibu = it.ibu.toString(),
                    abv = it.abu.toString()
                )
            }
        }
    }
}