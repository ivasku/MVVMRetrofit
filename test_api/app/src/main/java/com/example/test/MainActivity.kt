package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.rv.AdapterExample
import com.example.test.util.GenericApiResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModeltest:MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModeltest.getUsers().observe(this, Observer {
            when(it) {

                is GenericApiResponse.ApiSuccessResponse -> {
                  //  Log.d("TMS", "ApiSuccessResponse: ${it.body[0].username}")
                    for (item in it.body) {
                        Log.d("TMS", "User: ${item.username}")
                        Log.d("TMS", "User: ${item.id}")
                        Log.d("TMS", "User: ${item.adress.city}")
                        Log.d("TMS", "User: ${item.company.name}")

                    }
                    rv.adapter = AdapterExample(it.body)
                    rv.layoutManager = LinearLayoutManager(this)
                    rv.setHasFixedSize(true)

                }

                is GenericApiResponse.ApiErrorResponse -> {
                    Log.d("TMS", "User: ${it.errorMessage}")
                }

                is GenericApiResponse.ApiEmptyResponse -> {
                    Log.d("TMS", "User: EMPTY")
                }
            }
        })


        viewModeltest.getPost(3).observe(this, Observer {

            when (it) {

                is GenericApiResponse.ApiSuccessResponse -> {
                    Log.d("TMS", "Post: ${it.body.body}")
                    Log.d("TMS", "Post: ${it.body.id}")
                    Log.d("TMS", "Post: ${it.body.title}")
                    Log.d("TMS", "Post: ${it.body.userID}")
                }

                is GenericApiResponse.ApiErrorResponse -> {
                    Log.d("TMS", "Post: ${it.errorMessage}")
                }

                is GenericApiResponse.ApiEmptyResponse -> {
                    Log.d("TMS", "Post: EMPTY")
                }
            }
        })

    }
}