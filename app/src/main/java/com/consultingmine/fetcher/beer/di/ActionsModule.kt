package com.consultingmine.fetcher.beer.di

import com.consultingmine.fetcher.beer.data.actions.GetBeers
import com.consultingmine.fetcher.beer.data.actions.GetBeersImpl
import com.consultingmine.fetcher.beer.data.repo.BeerRepoApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ActionsModule {
    @Provides
    @Reusable
    fun provideGetBeers(
        beerRepoApi: BeerRepoApi
    ): GetBeers = GetBeersImpl(beerRepoApi)
}