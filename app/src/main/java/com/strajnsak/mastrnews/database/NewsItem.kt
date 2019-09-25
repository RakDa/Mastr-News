package com.strajnsak.mastrnews.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsItem(
    @PrimaryKey
    var title: String,
    var description: String,
    var content: String,
    var urlToImage: String,
    var urlToArticle: String,
    var timePublished: Long
)