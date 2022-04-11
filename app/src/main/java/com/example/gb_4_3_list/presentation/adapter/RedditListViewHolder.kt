package com.example.gb_4_3_list.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_4_3_list.R
import com.example.gb_4_3_list.domain.entity.Post

class RedditListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var title: TextView = itemView.findViewById(R.id.title)
    private var countComments: TextView = itemView.findViewById(R.id.count)
    private  val resurses = itemView.resources

    fun bind(post: Post) {
        title.text = post.title
        countComments.text = resurses.getString(R.string.comment_count, post.numComments)
    }
}
