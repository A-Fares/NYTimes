package com.afares.journaldev.ui.fragments.articledetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afares.journaldev.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

}