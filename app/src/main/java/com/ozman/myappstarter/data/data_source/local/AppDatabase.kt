package com.ozman.myappstarter.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AppEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao


    companion object {
        const val DATABASE_NAME = "app_dp"
    }
}