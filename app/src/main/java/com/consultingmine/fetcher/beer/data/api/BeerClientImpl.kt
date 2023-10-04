package com.consultingmine.fetcher.beer.data.api

import com.consultingmine.fetcher.beer.data.model.BeerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class BeerClientImpl @Inject constructor(
    private val apiservice: ApiService
) : BeerClientApi {

    private val _beerFlow = MutableStateFlow(listOf<BeerModel>())
    private val beerFlow = _beerFlow.asSharedFlow()

    override suspend fun getBeers(page: Int?, perPage: Int?): Flow<List<BeerModel>> {
        _beerFlow.emit(
            apiservice.getBeers(page, perPage)
        )
        return beerFlow.distinctUntilChanged()
    }
}