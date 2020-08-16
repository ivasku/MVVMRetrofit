package com.example.test.api

import androidx.lifecycle.LiveData
import com.example.test.models.Post
import com.example.test.models.User
import com.example.test.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsersData(): LiveData<GenericApiResponse<List<User>>>

    @GET("posts/{id}")  // @Query("param") param: String
    fun getPostData(@Path("id") id: Int): LiveData<GenericApiResponse<Post>>

}