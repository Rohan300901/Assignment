package com.rohan.rohan_pal.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjectDao {
    @Insert
    fun insertEntry(theProject: TheProject)

    @Query("SELECT * FROM yes_thats_me")
    fun getAllIds(): List<TheProject>
}