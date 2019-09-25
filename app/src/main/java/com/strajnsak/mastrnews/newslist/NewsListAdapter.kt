package com.strajnsak.mastrnews.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.strajnsak.mastrnews.database.NewsItem
import com.strajnsak.mastrnews.databinding.ListItemNewsBinding

class NewsListAdapter: ListAdapter<NewsItem, NewsListAdapter.NewsListViewHolder>(NewsListDiffCallback()) {

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder.from(parent)
    }

    class NewsListViewHolder private constructor(val binding: ListItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: NewsItem){
            binding.newsItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NewsListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemNewsBinding.inflate(layoutInflater, parent, false)
                return NewsListViewHolder(binding)
            }
        }
    }

}

class NewsListDiffCallback: DiffUtil.ItemCallback<NewsItem>(){
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.urlToArticle == newItem.urlToArticle
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }

}

