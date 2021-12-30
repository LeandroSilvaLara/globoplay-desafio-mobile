package com.leandro.desafio_globopay.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val movieIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

    val movieFlow = movieIdSharedFlow.flatMapLatest {
        movieRepository.loadMovieById(it)
    }

    val videoListFlow = movieIdSharedFlow.flatMapLatest {
        movieRepository.loadVideoList(it)
    }.shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)

    val keywordListFlow = movieIdSharedFlow.flatMapLatest {
        movieRepository.loadKeywordList(it)
    }

    val reviewListFlow = movieIdSharedFlow.flatMapLatest {
        movieRepository.loadReviewsList(it)
    }

    init {
        Timber.d("Injection MovieDetailViewModel")
    }

    fun fetchMovieDetailsById(id: Long) = movieIdSharedFlow.tryEmit(id)
}
