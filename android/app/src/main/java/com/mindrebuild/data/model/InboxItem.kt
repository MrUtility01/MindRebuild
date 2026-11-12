package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * آیتم صندوق ورودی (تخلیه ذهن)
 * کاربر می‌تواند هر چیزی را بدون نظم اینجا بنویسد و بعداً پردازش کند.
 */
@Entity(tableName = "inbox_items")
data class InboxItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val content: String,
    val createdAt: Long = System.currentTimeMillis(),
    val isProcessed: Boolean = false
)
