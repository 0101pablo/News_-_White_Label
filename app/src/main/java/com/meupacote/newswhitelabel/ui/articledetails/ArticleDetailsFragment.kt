package com.meupacote.newswhitelabel.ui.articledetails

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.meupacote.newswhitelabel.R
import com.meupacote.newswhitelabel.databinding.FragmentArticleDetailsBinding
import com.meupacote.newswhitelabel.domain.model.Article
import com.meupacote.newswhitelabel.ui.MainActivity

class ArticleDetailsFragment : Fragment() {

    private var _binding: FragmentArticleDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("article", Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable("article")
        }

        article?.run {
            (activity as MainActivity).setToolbarTitle(title)
            Glide
                .with(requireActivity())
                .load(urlToImage)
                .override(binding.ivArticleDetailsImage.width)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivArticleDetailsImage)
            binding.tvArticleDetailsTitle.text = title
            binding.tvArticleDetailsDescription.text = description
            binding.tvArticleDetailsContent.text = content
        }
    }
}