package com.example.retrofitbykotlinusigjsonplaceholder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitbykotlinusigjsonplaceholder.R
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.PostsDataModel
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.UsersDataModel

class MainActivityRecyclerViewAdapter(
    var posts: List<PostsDataModel>,
    var users: List<UsersDataModel>
) :
    RecyclerView.Adapter<MainActivityRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_activity_recyclerview_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val postUserId: Int = posts[position].userId
        val postId: Int = posts[position].postId
        val postTitle: String = posts[position].postTitle
        val postBody: String = posts[position].postBody
        val userId: Int = users[position].userId
        val userFullName: String = users[position].userFullName



        holder.setDataToMainActivity(userFullName, postTitle)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val postTitle: TextView = itemView.findViewById(R.id.post_title_text)
        private val postUserName: TextView = itemView.findViewById(R.id.posted_by_textview)

        fun setDataToMainActivity(
            post_Title: String,
            userName: String
        ) {


                postTitle.text = post_Title
                postUserName.text = userName



        }
    }
}