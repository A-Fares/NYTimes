package com.afares.journaldev.ui.fragments.articledetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.afares.journaldev.R
import com.afares.journaldev.databinding.FragmentArticleDetailsBinding
import com.afares.journaldev.databinding.FragmentArticlesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsFragment : Fragment() {

    private val args: ArticleDetailsFragmentArgs by navArgs()

    private var _binding: FragmentArticleDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)


        binding.apply {
            titleTv.text=args.article.title
            bylineTv.text=args.article.byline
            abstractTextView.text=args.article.abstract
            publishDate.text=args.article.publishedDate

            articleImageView.load(args.imageUrl) {
                error(R.drawable.ic_error_placeholder)
            }
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}