package com.meupacote.newswhitelabel.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meupacote.newswhitelabel.R
import com.meupacote.newswhitelabel.databinding.ItemArticleBinding
import com.meupacote.newswhitelabel.domain.model.Article

class NewsListAdapter : ListAdapter<Article, NewsListAdapter.NewsViewHolder>(ArticleCallBack()) {

    var onArticleClick: ((article: Article) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemArticleBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article: Article = getItem(position)
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onArticleClick?.invoke(article)
        }
    }

    class NewsViewHolder(private val itemBinding: ItemArticleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(article: Article) {
            itemBinding.run {
                tvArticleTitle.text = article.title
                Glide
                    .with(this.root.context)
                    .load(article.urlToImage)
                    .fitCenter()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(ivArticleImage)
            }
        }
    }

    class ArticleCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
}