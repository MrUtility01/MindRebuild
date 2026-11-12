package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * کار (با پشتیبانی تاریخ شمسی)
 */
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val notes: String = "",
    val dueDateJalali: String? = null,       // مثال: ۱۴۰۴/۰۸/۲۰
    val dueTime: String? = null,             // مثال: ۱۴:۳۰
    val isCompleted: Boolean = false,
    val priority: Int = 0,                   // ۰ = عادی، ۱ = مهم
    val createdAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null
)
