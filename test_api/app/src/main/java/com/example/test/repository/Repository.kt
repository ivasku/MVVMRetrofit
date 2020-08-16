package com.example.test.repository

import androidx.lifecycle.LiveData
import com.example.test.api.ApiService
import com.example.test.models.Post
import com.example.test.models.User
import com.example.test.util.GenericApiResponse

class Repository constructor(
    val apiService: ApiService
) {

    fun getUsers() : LiveData<GenericApiResponse<List<User>>> {
       return apiService.getUsersData()
    }

    fun getPost(postId: Int) : LiveData<GenericApiResponse<Post>> {
        return apiService.getPostData(postId)
    }

}