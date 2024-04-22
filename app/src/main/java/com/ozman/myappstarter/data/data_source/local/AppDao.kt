package com.ozman.myappstarter.data.data_source.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface AppDao {

    @Query("SELECT * FROM appEntity")
    fun getAllEntities(): Flow<List<AppEntity>>

    @Query("SELECT * FROM appEntity WHERE id= :id")
    suspend fun getEntityById(id: Int): AppEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(appEntity: AppEntity)

    @Delete
    suspend fun delete(appEntity: AppEntity)


}