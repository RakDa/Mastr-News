package com.strajnsak.mastrnews.newslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.strajnsak.mastrnews.database.NewsDao
import com.strajnsak.mastrnews.database.NewsItem
import kotlinx.coroutines.*

class NewsListViewModel(val newsDao: NewsDao, application: Application) : AndroidViewModel(application){

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val news = newsDao.getAllNews()


    init {
        uiScope.launch {
            insertDummyDataIntoDatabaseIfEmpty()
        }
    }

    private suspend fun insertDummyDataIntoDatabaseIfEmpty(){
        withContext (Dispatchers.IO) {
            if(newsDao.getAllNews().value == null){
                newsDao.insertSingle(NewsItem("Test title1", "Test description1", "Lorem ipsum dolor1...", "http://example.com/test1.png", "htps://example1.com", 1))
                newsDao.insertSingle(NewsItem("Test title2", "Test description2", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example2.com", 2))
                newsDao.insertSingle(NewsItem("Test title3", "Test description3", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example3.com", 3))
                newsDao.insertSingle(NewsItem("Test title4", "Test description4", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example4.com", 4))
                newsDao.insertSingle(NewsItem("Test title5", "Test description5", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example5.com", 5))
                newsDao.insertSingle(NewsItem("Test title6", "Test description6", "Lorem ipsum dolor...", "http://example.com/test.png", "htps://example6.com", 6))
            }
        }
    }


}