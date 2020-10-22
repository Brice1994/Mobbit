package com.example.mobbit.commons.models

data class RedditNewsItem (
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
)