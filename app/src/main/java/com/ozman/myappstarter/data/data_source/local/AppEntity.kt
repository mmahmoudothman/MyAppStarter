package com.ozman.myappstarter.data.data_source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AppEntity(
    val title: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

class InvalidDataException(message: String) : Exception(message)