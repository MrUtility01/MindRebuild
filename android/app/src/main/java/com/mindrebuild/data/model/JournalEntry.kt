package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ورودی دفتر خاطرات
 */
@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val content: String,
    val moodTag: String? = null,             // مثلاً: آرام، مضطرب، امیدوار
    val jalaliDate: String,                  // تاریخ شمسی
    val createdAt: Long = System.currentTimeMillis()
)
