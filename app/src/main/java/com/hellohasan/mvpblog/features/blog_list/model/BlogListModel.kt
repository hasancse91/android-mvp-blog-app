package com.hellohasan.mvpblog.features.blog_list.model

interface BlogListModel {
    fun getBlogList(callback: ModelCallback)
}