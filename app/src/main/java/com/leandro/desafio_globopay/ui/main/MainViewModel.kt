package com.leandro.desafio_globopay.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import com.leandro.desafio_globopay.repository.DiscoverRepository
import com.leandro.desafio_globopay.repository.PeopleRepository
import com.leandro.desafio_globopay.ui.models.network.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val imageLoader: ImageLoader,
    private val discoverRepository: DiscoverRepository,
    private val peopleRepository: PeopleRepository
) : ViewModel() {

    //private val _selectedTab: MutableState<MainScreenHomeTab> =
    //    mutableStateOf(MainScreenHomeTab.MOVIE)
    //val selectedTab: State<MainScreenHomeTab> get() = _selectedTab

    private val _movieLoadingState: MutableState<NetworkState> = mutableStateOf(NetworkState.IDLE)
    val movieLoadingState: State<NetworkState> get() = _movieLoadingState

    val movies: State<MutableList<Movie>> = mutableStateOf(mutableListOf())
    val moviePageStateFlow: MutableStateFlow<Int> = MutableStateFlow(1)
    private val newMovieFlow = moviePageStateFlow.flatMapLatest {
        _movieLoadingState.value = NetworkState.LOADING
        discoverRepository.loadMovies(
            page = it,
            success = { _movieLoadingState.value = NetworkState.SUCCESS },
            error = { _movieLoadingState.value = NetworkState.ERROR }
        )
    }.shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)



}