package com.hellohasan.mvpblog.features.blog_list.presenter

import com.hellohasan.mvpblog.features.blog_list.model.BlogListModel
import com.hellohasan.mvpblog.features.blog_list.view.BlogListView

class BlogListPresenterImpl(private val view: BlogListView, private val model: BlogListModel): BlogListPresenter {

    override fun fetchBlogList() {

        view.showLoader(true)

        model.getBlogList()

        view.showBlogList()

        view.showError("Content not found")
    }
}