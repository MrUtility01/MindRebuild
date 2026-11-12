package com.mindrebuild.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mindrebuild.data.dao.*
import com.mindrebuild.data.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        InboxItem::class,
        LearningTopic::class,
        Task::class,
        JournalEntry::class,
        KnowledgeEntry::class,
        CuriosityItem::class,
        Quote::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun inboxDao(): InboxDao
    abstract fun learningTopicDao(): LearningTopicDao
    abstract fun taskDao(): TaskDao
    abstract fun journalDao(): JournalDao
    abstract fun knowledgeDao(): KnowledgeDao
    abstract fun curiosityDao(): CuriosityDao
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mindrebuild_database"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // اضافه کردن جملات انگیزشی اولیه
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    prepopulateQuotes(database.quoteDao())
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private suspend fun prepopulateQuotes(quoteDao: QuoteDao) {
            val defaultQuotes = listOf(
                Quote(text = "هر روز فرصت تازه‌ای برای شروع دوباره است.", type = "universal"),
                Quote(text = "با نام خدا شروع کن و با توکل پیش برو.", type = "religious"),
                Quote(text = "قدم‌های کوچک اما پیوسته، کوه‌ها را جابه‌جا می‌کنند.", type = "universal"),
                Quote(text = "خداوند به کسانی که در راه او تلاش می‌کنند یاری می‌رساند.", type = "religious"),
                Quote(text = "ذهن آرام، تصمیم‌های بهتری می‌گیرد.", type = "universal"),
                Quote(text = "صبر و ایمان، کلید گشایش است.", type = "religious"),
                Quote(text = "امروز را دریاب؛ فردا هنوز نیامده است.", type = "universal"),
                Quote(text = "توکل بر خدا + تلاش خودت = آرامش.", type = "religious")
            )
            quoteDao.insertAll(defaultQuotes)
        }
    }
}
