package com.example.retrofitbykotlinusigjsonplaceholder

import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.CommentsDataModel
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.PostsDataModel
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.UsersDataModel
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderInterface {

    @GET("posts")
    fun getUserPosts(): Call<List<PostsDataModel>>

    @GET("comments")
    fun getUserComments(): Call<List<CommentsDataModel>>

    @GET("users")
    fun getUserProfile(): Call<List<UsersDataModel>>

}