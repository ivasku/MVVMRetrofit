package com.example.test.di

import com.example.test.api.ApiService
import com.example.test.MainViewModel
import com.example.test.repository.Repository
import com.example.test.util.LiveDataCallAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    viewModel { MainViewModel(get()) }


}

val apiModule = module {

    fun provideApi(retrofitBuilder: Retrofit.Builder) : ApiService {
    return retrofitBuilder
        .build()
        .create(ApiService::class.java)
}

    fun provideGsonBuilder() : Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create() // read only fields with expose annotatioin
    }

    fun provideRetrofitBuilder(gson: Gson) : Retrofit.Builder {
        val httpClient = OkHttpClient.Builder()
            .callTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(httpClient)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    single{ (provideRetrofitBuilder(get()))}

    single{ (provideGsonBuilder())}
    single{ (provideApi(get())) }

    single { Repository(get()) }

}
