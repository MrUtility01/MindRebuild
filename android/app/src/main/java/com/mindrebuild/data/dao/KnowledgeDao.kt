package com.mindrebuild.data.dao

import androidx.room.*
import com.mindrebuild.data.model.KnowledgeEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface KnowledgeDao {

    @Query("SELECT * FROM knowledge_entries ORDER BY createdAt DESC")
    fun getAll(): Flow<List<KnowledgeEntry>>

    @Query("SELECT * FROM knowledge_entries WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<KnowledgeEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: KnowledgeEntry): Long

    @Update
    suspend fun update(entry: KnowledgeEntry)

    @Delete
    suspend fun delete(entry: KnowledgeEntry)
}
