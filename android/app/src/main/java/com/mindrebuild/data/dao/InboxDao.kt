package com.mindrebuild.data.dao

import androidx.room.*
import com.mindrebuild.data.model.InboxItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InboxDao {

    @Query("SELECT * FROM inbox_items WHERE isProcessed = 0 ORDER BY createdAt DESC")
    fun getUnprocessedItems(): Flow<List<InboxItem>>

    @Query("SELECT * FROM inbox_items ORDER BY createdAt DESC")
    fun getAllItems(): Flow<List<InboxItem>>

    @Query("SELECT COUNT(*) FROM inbox_items WHERE isProcessed = 0")
    fun getUnprocessedCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: InboxItem): Long

    @Update
    suspend fun update(item: InboxItem)

    @Delete
    suspend fun delete(item: InboxItem)

    @Query("UPDATE inbox_items SET isProcessed = 1 WHERE id = :id")
    suspend fun markAsProcessed(id: Long)

    @Query("DELETE FROM inbox_items WHERE id = :id")
    suspend fun deleteById(id: Long)
}
