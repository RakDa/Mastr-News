package com.strajnsak.mastrnews

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.strajnsak.mastrnews.database.NewsItem

@BindingAdapter("newsPostedAtDateTimeFormatted")
fun TextView.setNewsPostedAtDateTimeFormatted(item: NewsItem?){
    item?.let {
        text = covertMilisecondsToDateTimeRepresentation(item.timePublished)
    }
}

