package com.leandro.desafio_globopay.repository

import com.skydoves.moviecompose.network.service.TheDiscoverService

class DiscoverRepository constructor(
    private val discoverService: TheDiscoverService,
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) : Repository {

}
