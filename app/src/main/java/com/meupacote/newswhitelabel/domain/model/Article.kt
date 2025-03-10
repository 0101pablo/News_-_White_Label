package com.meupacote.newswhitelabel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article (
    var source: Source,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String,
) : Parcelable

@Parcelize
data class Source (
    var id: String,
    var name: String
) : Parcelable