package com.example.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.Post
import com.example.test.models.User
import com.example.test.repository.Repository
import com.example.test.util.GenericApiResponse

class MainViewModel constructor(
    val repository: Repository
): ViewModel() {




    fun getUsers() :LiveData<GenericApiResponse<List<User>>> {
        return repository.getUsers()
    }

    fun getPost(postId: Int) : LiveData<GenericApiResponse<Post>> {
        return repository.getPost(postId)
    }

}