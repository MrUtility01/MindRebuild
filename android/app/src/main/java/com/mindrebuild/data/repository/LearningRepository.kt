package com.mindrebuild.data.repository

import com.mindrebuild.data.dao.LearningTopicDao
import com.mindrebuild.data.model.LearningTopic
import kotlinx.coroutines.flow.Flow

class LearningRepository(private val learningTopicDao: LearningTopicDao) {

    fun getActiveTopics(): Flow<List<LearningTopic>> = learningTopicDao.getActiveTopics()

    fun getActiveCount(): Flow<Int> = learningTopicDao.getActiveCount()

    fun getLaterTopics(): Flow<List<LearningTopic>> = learningTopicDao.getLaterTopics()

    suspend fun getTopic(id: Long): LearningTopic? = learningTopicDao.getById(id)

    suspend fun createTopic(title: String): Long {
        return learningTopicDao.insert(
            LearningTopic(title = title, currentStep = 1, status = "active")
        )
    }

    suspend fun updateTopic(topic: LearningTopic) {
        learningTopicDao.update(topic)
    }

    suspend fun advanceStep(topic: LearningTopic, fieldValue: String): LearningTopic {
        val updated = when (topic.currentStep) {
            1 -> topic.copy(why = fieldValue, currentStep = 2)
            2 -> topic.copy(simpleExplanation = fieldValue, currentStep = 3)
            3 -> topic.copy(projectConnection = fieldValue, currentStep = 4)
            4 -> topic.copy(summary = fieldValue, currentStep = 4, status = "completed")
            else -> topic
        }
        learningTopicDao.update(updated)
        return updated
    }
}
