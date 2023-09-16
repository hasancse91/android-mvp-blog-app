package com.hellohasan.mvpblog.features.blog_list.presenter

interface BlogListPresenter {
    fun fetchBlogList()
    fun onViewDetached()
}