package com.consultingmine.spindox.beer.data.actions

import com.consultingmine.spindox.beer.data.model.BeerModel
import com.consultingmine.spindox.beer.data.repo.BeerRepoApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetBeers {
    suspend fun execute(page: Int?, perPage: Int?): Flow<List<BeerModel>>
}

class GetBeersImpl @Inject constructor(
    private val beerRepo: BeerRepoApi
) : GetBeers {
    override suspend fun execute(page: Int?, perPage: Int?): Flow<List<BeerModel>> = beerRepo.getBeers(page, perPage)
}