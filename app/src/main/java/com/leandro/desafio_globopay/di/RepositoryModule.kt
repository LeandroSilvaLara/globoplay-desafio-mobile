package com.leandro.desafio_globopay.di

import com.leandro.desafio_globopay.repository.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideDiscoverRepository(
        discoverService: TheDiscoverService,
        movieDao: MovieDao,
        tvDao: TvDao
    ): DiscoverRepository {
        return DiscoverRepository(discoverService, movieDao, tvDao)
    }

    @Provides
    @ViewModelScoped
    fun provideMovieRepository(
        movieService: MovieService,
        movieDao: MovieDao
    ): MovieRepository {
        return MovieRepository(movieService, movieDao)
    }

    @Provides
    @ViewModelScoped
    fun providePeopleRepository(
        peopleService: PeopleService,
        peopleDao: PeopleDao
    ): PeopleRepository {
        return PeopleRepository(peopleService, peopleDao)
    }

    @Provides
    @ViewModelScoped
    fun provideTvRepository(
        tvService: TvService,
        tvDao: TvDao
    ): TvRepository {
        return TvRepository(tvService, tvDao)
    }
}
