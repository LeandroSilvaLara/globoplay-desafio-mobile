package com.leandro.desafio_globopay.ui.main

import androidx.lifecycle.ViewModel
import coil.ImageLoader
import com.leandro.desafio_globopay.repository.DiscoverRepository
import com.leandro.desafio_globopay.repository.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val imageLoader: ImageLoader,
    private val discoverRepository: DiscoverRepository,
    private val peopleRepository: PeopleRepository
) : ViewModel() {

}