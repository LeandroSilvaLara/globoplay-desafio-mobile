package com.leandro.desafio_globopay.models.network

import androidx.compose.runtime.Immutable
import com.leandro.desafio_globopay.models.Keyword
import com.leandro.desafio_globopay.models.NetworkResponseModel

@Immutable
data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
) : NetworkResponseModel
