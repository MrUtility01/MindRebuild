package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * آیتم بخش «بعداً» (کنجکاوی)
 */
@Entity(tableName = "curiosity_items")
data class CuriosityItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
