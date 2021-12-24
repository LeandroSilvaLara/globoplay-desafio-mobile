package com.leandro.desafio_globopay.models.entities

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import com.leandro.desafio_globopay.models.Keyword
import com.leandro.desafio_globopay.models.Review
import com.leandro.desafio_globopay.models.Video


@Immutable
@Entity(primaryKeys = [("id")])
data class Tv(
    var page: Int,
    var keywords: List<Keyword>? = emptyList(),
    var videos: List<Video>? = emptyList(),
    var reviews: List<Review>? = emptyList(),
    val poster_path: String?,
    val popularity: Float,
    val id: Long,
    val backdrop_path: String?,
    val vote_average: Float,
    val overview: String,
    val first_air_date: String?,
    val origin_country: List<String>,
    val genre_ids: List<Int>,
    val original_language: String,
    val vote_count: Int,
    val name: String,
    val original_name: String
)