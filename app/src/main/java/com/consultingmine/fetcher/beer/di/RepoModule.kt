package com.consultingmine.fetcher.beer.di

import com.consultingmine.fetcher.beer.data.api.BeerClientApi
import com.consultingmine.fetcher.beer.data.repo.BeerRepoApi
import com.consultingmine.fetcher.beer.data.repo.BeersRepoImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Reusable
    fun provideBeersRepo(
        beerClientApi: BeerClientApi
    ): BeerRepoApi = BeersRepoImpl(beerClientApi)

}