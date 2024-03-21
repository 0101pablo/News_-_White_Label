package com.meupacote.newswhitelabel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var status: String = "",
    var totalResults: Int = 0,
    var articles: List<Article> = emptyList(),
) : Parcelable