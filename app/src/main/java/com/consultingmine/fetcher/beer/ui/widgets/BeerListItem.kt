package com.consultingmine.fetcher.beer.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@ExperimentalGlideComposeApi
@Composable
fun BeerListItem(
    imageUrl: String? = null,
    name: String? = null,
    description: String? = null,
    abv: String? = null,
    ibu: String? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Row {
            GlideImage(
                modifier = Modifier
                    .height(100.dp)
                    .padding(10.dp),
                model = imageUrl,
                contentDescription = "Beer image"
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = name ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            bottom = 5.dp
                        ),
                    text = description ?: "",
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
                Row {
                    Text(
                        text = stringResource(
                            id = com.consultingmine.fetcher.beer.R.string.beer_item_abv
                        ),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = abv ?: "")
                }

                Row {
                    Text(
                        text = stringResource(
                            id = com.consultingmine.fetcher.beer.R.string.beer_item_ibu
                        ),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = ibu ?: "N/A")
                }
            }
        }
    }
}