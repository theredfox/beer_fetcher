package com.consultingmine.spindox.beer.di

import com.consultingmine.spindox.beer.data.api.BeerClientApi
import com.consultingmine.spindox.beer.data.repo.BeerRepoApi
import com.consultingmine.spindox.beer.data.repo.BeersRepoImpl
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