package com.meupacote.newswhitelabel.ui.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.meupacote.newswhitelabel.databinding.FragmentNewsListBinding
import com.meupacote.newswhitelabel.domain.model.Article
import com.meupacote.newswhitelabel.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsListViewModel by viewModels()

    private val newsListAdapter = NewsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle("BBC News")
        setRecyclerView()
        setListeners()
        observeNavBackStack()
        observeVMEvents()
        getNews()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setRecyclerView() {
        binding.recyclerNews.run {
            setHasFixedSize(true)
            adapter = newsListAdapter
        }
    }

    private fun setListeners() {
        with(binding) {
            swipeNews.setOnRefreshListener {
                getNews()
            }
            newsListAdapter.onArticleClick = { article ->
                goToArticleDetails(article)
            }
        }
    }

    private fun goToArticleDetails(article: Article) {
        findNavController().navigate(
            NewsListFragmentDirections
                .actionNewsListFragmentToArticleDetailsFragment(article)
        )
    }

    private fun observeNavBackStack() {

    }

    private fun observeVMEvents() {
        viewModel.newsData.observe(viewLifecycleOwner) { news ->
            binding.swipeNews.isRefreshing = false
            newsListAdapter.submitList(news.articles)
            binding.emptyListText.visibility =
                if (newsListAdapter.itemCount == 0) VISIBLE else GONE
        }
    }

    private fun getNews() {
        viewModel.getNews()
    }
}