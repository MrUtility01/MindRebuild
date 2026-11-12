package com.mindrebuild.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موضوع یادگیری
 * جریان اجباری مرحله‌ای:
 * 1. چرا؟
 * 2. توضیح ساده
 * 3. اتصال به پروژه واقعی
 * 4. جمع‌بندی
 */
@Entity(tableName = "learning_topics")
data class LearningTopic(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val why: String = "",                    // مرحله ۱
    val simpleExplanation: String = "",      // مرحله ۲
    val projectConnection: String = "",      // مرحله ۳
    val summary: String = "",                // مرحله ۴
    val currentStep: Int = 1,                // ۱ تا ۴
    val status: String = "active",           // active, paused, completed, later
    val createdAt: Long = System.currentTimeMillis(),
    val lastReviewedAt: Long? = null
)
