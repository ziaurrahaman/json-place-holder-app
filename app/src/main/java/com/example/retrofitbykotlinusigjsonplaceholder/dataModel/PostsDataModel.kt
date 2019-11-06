package com.example.retrofitbykotlinusigjsonplaceholder.dataModel

import com.google.gson.annotations.SerializedName

data class PostsDataModel(

    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val postId: Int,
    @SerializedName("title")
    val postTitle: String,
    @SerializedName("body")
    val postBody: String

)