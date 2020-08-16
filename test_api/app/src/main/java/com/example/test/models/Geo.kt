package com.example.test.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geo (
    @SerializedName("lat")
    @Expose
    var lat: String,

    @SerializedName("lng")
    @Expose
    var lng: String
)