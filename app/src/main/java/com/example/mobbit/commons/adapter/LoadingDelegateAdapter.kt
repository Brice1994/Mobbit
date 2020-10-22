package com.example.mobbit.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobbit.R
import com.example.mobbit.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType){}

    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder (
        parent.inflate(R.layout.news_item_loading)){}
}