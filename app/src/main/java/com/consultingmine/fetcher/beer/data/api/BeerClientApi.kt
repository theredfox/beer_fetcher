package com.consultingmine.fetcher.beer.data.api

import com.consultingmine.fetcher.beer.data.model.BeerModel
import kotlinx.coroutines.flow.Flow

interface BeerClientApi {
    suspend fun getBeers(page: Int?, perPage: Int?): Flow<List<BeerModel>>
}