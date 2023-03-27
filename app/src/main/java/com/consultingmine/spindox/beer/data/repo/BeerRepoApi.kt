package com.consultingmine.spindox.beer.data.repo

import com.consultingmine.spindox.beer.data.model.BeerModel
import kotlinx.coroutines.flow.Flow

interface BeerRepoApi {
    suspend fun getBeers(page: Int?, perPage: Int?): Flow<List<BeerModel>>
}