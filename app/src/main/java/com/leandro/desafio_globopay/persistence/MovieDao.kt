package com.leandro.desafio_globopay.persistence

import androidx.room.*
import com.leandro.desafio_globopay.models.entities.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM MOVIE WHERE id = :id_")
    suspend fun getMovie(id_: Long): Movie

    @Query("SELECT * FROM Movie WHERE page = :page_")
    suspend fun getMovieList(page_: Int): List<Movie>
}
