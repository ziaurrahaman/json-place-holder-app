package com.example.retrofitbykotlinusigjsonplaceholder.dataModel

import com.google.gson.annotations.SerializedName

data class CommentsDataModel(var comments: List<Comment>) {

    data class Comment(

        @SerializedName("postId")
        val commentedPostId: Int,

        @SerializedName("id")
        val commentId: Int,

        @SerializedName("name")
        val commentUserName: String,

        @SerializedName("body")
        val commentBody: String
    )


}