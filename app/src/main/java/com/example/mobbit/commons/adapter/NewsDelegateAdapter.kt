package com.example.mobbit.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobbit.R
import com.example.mobbit.commons.extensions.getFormattedDate
import com.example.mobbit.commons.extensions.inflate
import com.example.mobbit.commons.extensions.loadImg
import com.example.mobbit.commons.models.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFormattedDate()
        }
    }
}