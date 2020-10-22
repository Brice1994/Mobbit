package com.example.mobbit

import com.example.mobbit.commons.models.RedditNewsItem
import rx.Observable

class NewsManager() {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
                subscriber ->
            val news = (1..10).mapIndexed{index, v ->
                RedditNewsItem(
                    "author $index",
                    "title $index", index,
                    1457207701L - index * 200,
                    "https://picsum.photos/200/200?image=$index",
                    "url"
                )
            }
            subscriber.onNext(news)
        }
    }
}