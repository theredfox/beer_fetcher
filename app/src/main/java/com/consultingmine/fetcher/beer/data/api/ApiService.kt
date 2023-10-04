package com.consultingmine.fetcher.beer.data.api

import com.consultingmine.fetcher.beer.data.model.BeerModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int?, @Query("per_page") perPage: Int?): List<BeerModel>
}