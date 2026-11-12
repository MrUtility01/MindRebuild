package com.mindrebuild.data.repository

import com.mindrebuild.data.dao.InboxDao
import com.mindrebuild.data.model.InboxItem
import kotlinx.coroutines.flow.Flow

class InboxRepository(private val inboxDao: InboxDao) {

    fun getUnprocessedItems(): Flow<List<InboxItem>> = inboxDao.getUnprocessedItems()

    fun getUnprocessedCount(): Flow<Int> = inboxDao.getUnprocessedCount()

    suspend fun addItem(content: String): Long {
        return inboxDao.insert(InboxItem(content = content))
    }

    suspend fun markAsProcessed(id: Long) {
        inboxDao.markAsProcessed(id)
    }

    suspend fun deleteItem(id: Long) {
        inboxDao.deleteById(id)
    }

    suspend fun updateItem(item: InboxItem) {
        inboxDao.update(item)
    }
}
