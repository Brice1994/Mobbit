package com.example.mobbit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobbit.commons.adapter.NewsAdapter
import com.example.mobbit.commons.extensions.inflate
import com.example.mobbit.commons.models.RedditNewsItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription

class NewsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    private val newsManager by lazy { NewsManager() }

    var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
    private fun requestNews() {
        val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    retrievedNews ->
                    (news_list as NewsAdapter).addNews(retrievedNews)
                },
                {
                    e ->
                    Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                }
            )
        subscriptions.add(subscription)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            val news = (1..10).mapIndexed{index, v ->
                RedditNewsItem(
                    "author $index",
                    "title $index", index,
                    1457207701L - index * 200,
                    "https://picsum.photos/200/200?image=$index",
                    "url"
                )
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter() {
        if(news_list.adapter == null){
            news_list.adapter = NewsAdapter()
        }
    }
}
