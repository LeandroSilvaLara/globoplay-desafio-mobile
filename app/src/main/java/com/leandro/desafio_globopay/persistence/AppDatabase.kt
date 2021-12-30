package com.leandro.desafio_globopay.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leandro.desafio_globopay.models.entities.Movie
import com.leandro.desafio_globopay.models.entities.Person
import com.leandro.desafio_globopay.models.entities.Tv

@Database(
    entities = [(Movie::class), (Tv::class), (Person::class)],
    version = 3, exportSchema = false
)
@TypeConverters(
    value = [
        (StringListConverter::class), (IntegerListConverter::class),
        (KeywordListConverter::class), (VideoListConverter::class), (ReviewListConverter::class)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
    abstract fun peopleDao(): PeopleDao
}
