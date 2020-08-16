package com.example.test.models

import com.example.test.models.Address
import com.example.test.models.Company
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(


    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("username")
    @Expose
    var username: String,

    @SerializedName("address")
    @Expose
    var adress: Address,

    @SerializedName("company")
    @Expose
    var company: Company

)