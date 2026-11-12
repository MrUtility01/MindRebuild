package com.mindrebuild.data.dao

import androidx.room.*
import com.mindrebuild.data.model.LearningTopic
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningTopicDao {

    @Query("SELECT * FROM learning_topics WHERE status = 'active' ORDER BY createdAt DESC")
    fun getActiveTopics(): Flow<List<LearningTopic>>

    @Query("SELECT * FROM learning_topics WHERE status = 'later' ORDER BY createdAt DESC")
    fun getLaterTopics(): Flow<List<LearningTopic>>

    @Query("SELECT * FROM learning_topics WHERE status = 'completed' ORDER BY lastReviewedAt DESC")
    fun getCompletedTopics(): Flow<List<LearningTopic>>

    @Query("SELECT * FROM learning_topics WHERE id = :id")
    suspend fun getById(id: Long): LearningTopic?

    @Query("SELECT COUNT(*) FROM learning_topics WHERE status = 'active'")
    fun getActiveCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(topic: LearningTopic): Long

    @Update
    suspend fun update(topic: LearningTopic)

    @Delete
    suspend fun delete(topic: LearningTopic)
}
