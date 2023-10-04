package com.consultingmine.fetcher.beer.data.repo

import com.consultingmine.fetcher.beer.data.api.BeerClientApi
import com.consultingmine.fetcher.beer.data.model.BeerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

class BeersRepoImpl @Inject constructor(
    private val client: BeerClientApi
) : BeerRepoApi {
    override suspend fun getBeers(page: Int?, perPage: Int?): Flow<List<BeerModel>> = supervisorScope {
        client.getBeers(page, perPage)
    }
}