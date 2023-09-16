package com.hellohasan.mvpblog.features.blog_list.view

import com.hellohasan.mvpblog.features.blog_list.model.data.BlogItemUiModel

interface BlogListView {
    fun showLoader(shouldShow: Boolean)
    fun showBlogList(blogList: List<BlogItemUiModel>)
    fun showError(error: String)
}