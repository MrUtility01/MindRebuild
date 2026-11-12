package com.mindrebuild.data.dao

import androidx.room.*
import com.mindrebuild.data.model.CuriosityItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CuriosityDao {

    @Query("SELECT * FROM curiosity_items ORDER BY createdAt DESC")
    fun getAll(): Flow<List<CuriosityItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CuriosityItem): Long

    @Update
    suspend fun update(item: CuriosityItem)

    @Delete
    suspend fun delete(item: CuriosityItem)
}
