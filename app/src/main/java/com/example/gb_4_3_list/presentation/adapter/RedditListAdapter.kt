package com.example.gb_4_3_list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.gb_4_3_list.R
import com.example.gb_4_3_list.domain.entity.Post

class RedditListAdapter :
    PagingDataAdapter<Post, RedditListViewHolder>(DataDifferntiator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditListViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.post_item_list,
            parent,
            false
        )
        return RedditListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RedditListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    object DataDifferntiator : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}
