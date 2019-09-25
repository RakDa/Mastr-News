package com.strajnsak.mastrnews.newslist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.strajnsak.mastrnews.R
import com.strajnsak.mastrnews.database.NewsDatabase
import com.strajnsak.mastrnews.databinding.FragmentNewsListBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentNewsListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_news_list, container, false)

        val application = requireNotNull(this.activity).application

        val newsDao = NewsDatabase.getInstance(application).newsDao

        val viewModelFactory = NewsListViewModelFactory(newsDao, application)

        val newsListViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsListViewModel::class.java)

        binding.newsListViewModel = newsListViewModel

        binding.setLifecycleOwner(this)

        val adapter = NewsListAdapter()

        binding.newsList.adapter = adapter

        newsListViewModel.news.observe(viewLifecycleOwner, Observer {
            it?.let {
               adapter.submitList(it)
            }
        } )



        return binding.root
    }


}
