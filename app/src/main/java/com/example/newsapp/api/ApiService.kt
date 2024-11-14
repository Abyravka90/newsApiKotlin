package com.example.newsapp.api

import com.example.newsapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c83da61268d141a59f4051024a4826f2
interface ApiService {
    @GET("top-headlines")
    fun getArticles(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
        @Query("apiKey")apiKey: String = "c83da61268d141a59f4051024a4826f2"
    ) : Call<ResponseNews>
}