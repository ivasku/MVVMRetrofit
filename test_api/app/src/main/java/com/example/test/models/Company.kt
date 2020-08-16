package com.example.test.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Company (
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("catchPhrase")
    @Expose
    var catchPhrase: String,

    @SerializedName("bs")
    @Expose
    var bs: String
)