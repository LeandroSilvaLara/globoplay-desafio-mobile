package com.leandro.desafio_globopay.models.network

import androidx.compose.runtime.Immutable
import com.leandro.desafio_globopay.models.NetworkResponseModel
import com.leandro.desafio_globopay.models.entities.Tv

@Immutable
data class DiscoverTvResponse(
    val page: Int,
    val results: List<Tv>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel