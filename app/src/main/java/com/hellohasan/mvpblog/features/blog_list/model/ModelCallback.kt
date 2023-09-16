package com.hellohasan.mvpblog.features.blog_list.model

interface ModelCallback {
    fun onSuccess(blogResponseList: List<BlogResponse>)
    fun onError(error: String)
}