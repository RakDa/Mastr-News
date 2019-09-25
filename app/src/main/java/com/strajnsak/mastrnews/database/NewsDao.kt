package com.strajnsak.mastrnews.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingle(news: NewsItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(news: List<NewsItem>)

    @Query("SELECT * FROM NewsItem")
    fun getAllNews(): LiveData<List<NewsItem>>

    @Query("DELETE FROM NewsItem")
    fun clear()

    @Query("SELECT * from NewsItem ORDER BY timePublished DESC LIMIT 1")
    fun getLatest(): NewsItem

}