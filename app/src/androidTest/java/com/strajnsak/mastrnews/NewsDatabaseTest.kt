package com.strajnsak.mastrnews

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.strajnsak.mastrnews.database.NewsDao
import com.strajnsak.mastrnews.database.NewsDatabase
import com.strajnsak.mastrnews.database.NewsItem
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class NewsDatabaseTest {

    private lateinit var newsDao: NewsDao
    private lateinit var db: NewsDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, NewsDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        newsDao = db.newsDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val news = NewsItem("Test title", "Test description", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example.com", 0)
        newsDao.insertSingle(news)
        val latestNews = newsDao.getLatest()
        assertEquals(latestNews?.title, news.title)
    }
}