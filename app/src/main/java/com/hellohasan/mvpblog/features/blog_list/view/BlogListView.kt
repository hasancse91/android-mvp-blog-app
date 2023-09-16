package com.hellohasan.mvpblog.features.blog_list.view

import com.hellohasan.mvpblog.features.blog_list.model.BlogItemUiModel
import com.hellohasan.mvpblog.features.blog_list.model.BlogResponse

interface BlogListView {
    fun showLoader(shouldShow: Boolean)
    fun showBlogList(blogList: List<BlogItemUiModel>)
    fun showError(error: String)
}