package com.consultingmine.fetcher.beer.data.model

import com.google.gson.annotations.SerializedName

data class BeerModel(
    val name: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    val description: String?,
    val abu: Double?,
    val ibu: Double?
)