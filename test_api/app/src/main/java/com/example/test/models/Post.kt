package com.example.test.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("userId")
    @Expose
    var userID : String,

    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String
)