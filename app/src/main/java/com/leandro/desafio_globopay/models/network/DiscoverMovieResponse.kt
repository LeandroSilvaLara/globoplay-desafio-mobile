package com.leandro.desafio_globopay.models.network

import androidx.compose.runtime.Immutable


@Immutable
data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel
