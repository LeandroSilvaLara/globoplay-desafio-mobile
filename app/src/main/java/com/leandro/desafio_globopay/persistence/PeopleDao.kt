package com.leandro.desafio_globopay.persistence

import androidx.room.*
import com.leandro.desafio_globopay.models.entities.Person

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeople(people: List<Person>)

    @Update
    suspend fun updatePerson(person: Person)

    @Query("SELECT * FROM people WHERE id = :id_")
    suspend fun getPerson(id_: Long): Person

    @Query("SELECT * FROM People WHERE page = :page_")
    suspend fun getPeople(page_: Int): List<Person>
}