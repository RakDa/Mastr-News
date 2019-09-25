package com.strajnsak.mastrnews.newslist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.strajnsak.mastrnews.database.NewsDao

class NewsListViewModelFactory(
    private val newsDao: NewsDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            return NewsListViewModel(newsDao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}