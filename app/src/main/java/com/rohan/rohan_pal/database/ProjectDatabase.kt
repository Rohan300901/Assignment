package com.rohan.rohan_pal.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TheProject::class], version = 1)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}