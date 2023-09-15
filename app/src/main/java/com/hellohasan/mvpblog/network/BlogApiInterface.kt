package com.hellohasan.mvpblog.network

import com.hellohasan.mvpblog.BlogResponse
import retrofit2.Call
import retrofit2.http.GET

interface BlogApiInterface {

    @GET("posts")
    fun getBlogList() : Call<List<BlogResponse>>
}