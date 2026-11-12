package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * دانش تثبیت‌شده (موضوعاتی که یادگیری‌شان کامل شده)
 */
@Entity(tableName = "knowledge_entries")
data class KnowledgeEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val relatedTopicId: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
)
