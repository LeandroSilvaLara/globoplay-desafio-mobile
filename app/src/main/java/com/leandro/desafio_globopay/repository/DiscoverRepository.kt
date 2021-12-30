package com.leandro.desafio_globopay.repository

import androidx.annotation.WorkerThread
import com.leandro.desafio_globopay.persistence.MovieDao
import com.leandro.desafio_globopay.persistence.TvDao
import com.leandro.desafio_globopay.ui.models.network.service.TheDiscoverService
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import timber.log.Timber

class DiscoverRepository constructor(
    private val discoverService: TheDiscoverService,
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) : Repository {

    init {
        Timber.d("Injection DiscoverRepository")
    }

    @WorkerThread
    fun loadMovies(page: Int, success: () -> Unit, error: () -> Unit) = flow {
        var movies = movieDao.getMovieList(page)
        if (movies.isEmpty()) {
            val response = discoverService.fetchDiscoverMovie(page)
            response.suspendOnSuccess {
                movies = data.results
                movies.forEach { it.page = page }
                movieDao.insertMovieList(movies)
                emit(movies)
            }.onError {
                error()
            }.onException { error() }
        } else {
            emit(movies)
        }
    }.onCompletion { success() }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadTvs(page: Int, success: () -> Unit, error: () -> Unit) = flow {
        var tvs = tvDao.getTvList(page)
        if (tvs.isEmpty()) {
            val response = discoverService.fetchDiscoverTv(page)
            response.suspendOnSuccess {
                tvs = data.results
                tvs.forEach { it.page = page }
                tvDao.insertTv(tvs)
                emit(tvs)
            }.onError {
                error()
            }.onException { error() }
        } else {
            emit(tvs)
        }
    }.onCompletion { success() }.flowOn(Dispatchers.IO)
}