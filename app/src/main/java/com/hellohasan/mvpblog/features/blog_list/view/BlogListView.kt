package com.hellohasan.mvpblog.features.blog_list.view

import com.hellohasan.mvpblog.features.blog_list.model.BlogResponse

interface BlogListView {
    fun showLoader(shouldShow: Boolean)
    fun showBlogList(blogList: List<BlogResponse>)
    fun showError(error: String)
}