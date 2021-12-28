package com.leandro.desafio_globopay.models.network

import androidx.compose.runtime.Immutable
import com.leandro.desafio_globopay.models.NetworkResponseModel
import com.leandro.desafio_globopay.models.entities.Person

@Immutable
data class PeopleResponse(
    val page: Int,
    val results: List<Person>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel