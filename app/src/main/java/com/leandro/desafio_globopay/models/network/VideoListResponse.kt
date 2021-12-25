package com.leandro.desafio_globopay.models.network

import androidx.compose.runtime.Immutable
import com.leandro.desafio_globopay.models.NetworkResponseModel
import com.leandro.desafio_globopay.models.Video

@Immutable
data class VideoListResponse(
    val id: Int,
    val results: List<Video>
) : NetworkResponseModel
