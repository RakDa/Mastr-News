package com.strajnsak.mastrnews.newsdetails


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.strajnsak.mastrnews.R
import com.strajnsak.mastrnews.databinding.FragmentNewsDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentNewsDetailsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_news_details, container, false)
        return binding.root
    }


}
