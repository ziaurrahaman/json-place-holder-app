package com.example.retrofitbykotlinusigjsonplaceholder

import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.PostsDataModel
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.UsersDataModel

interface OnDataLoaded {

    fun getPosts(posts: List<PostsDataModel>)
    fun getUsers(posts: List<PostsDataModel>)

}