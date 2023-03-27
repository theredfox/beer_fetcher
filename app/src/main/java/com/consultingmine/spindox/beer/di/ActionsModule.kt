package com.consultingmine.spindox.beer.di

import com.consultingmine.spindox.beer.data.actions.GetBeers
import com.consultingmine.spindox.beer.data.actions.GetBeersImpl
import com.consultingmine.spindox.beer.data.repo.BeerRepoApi
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