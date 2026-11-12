package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * جملات انگیزشی (مذهبی و جهانی)
 */
@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val text: String,
    val type: String,                        // "religious" یا "universal"
    val isActive: Boolean = true
)
