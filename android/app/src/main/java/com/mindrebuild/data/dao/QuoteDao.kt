package com.mindrebuild.data.dao

import androidx.room.*
import com.mindrebuild.data.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quotes WHERE isActive = 1")
    fun getActiveQuotes(): Flow<List<Quote>>

    @Query("SELECT * FROM quotes WHERE isActive = 1 ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomQuote(): Quote?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quote: Quote): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<Quote>)

    @Update
    suspend fun update(quote: Quote)
}
