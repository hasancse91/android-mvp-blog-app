package com.hellohasan.mvpblog.features.blog_list.presenter

import com.hellohasan.mvpblog.features.blog_list.model.BlogItemUiModel
import com.hellohasan.mvpblog.features.blog_list.model.BlogListModel
import com.hellohasan.mvpblog.features.blog_list.model.BlogListModelImpl
import com.hellohasan.mvpblog.features.blog_list.model.BlogResponse
import com.hellohasan.mvpblog.features.blog_list.model.ModelCallback
import com.hellohasan.mvpblog.features.blog_list.view.BlogListView
import java.text.SimpleDateFormat
import java.util.Locale

class BlogListPresenterImpl(private val view: BlogListView) : BlogListPresenter {

    private val model: BlogListModel = BlogListModelImpl()

    override fun fetchBlogList() {

        view.showLoader(true)

        model.getBlogList(object : ModelCallback{
            override fun onSuccess(blogResponseList: List<BlogResponse>) {
                val blogListUiModel = getBlogUiModelList(blogResponseList)
                view.showBlogList(blogListUiModel)

                view.showLoader(false)
            }

            override fun onError(error: String) {
                view.showError(error)
                view.showLoader(false)
            }
        })

    }

    private fun getBlogUiModelList(blogResponseList: List<BlogResponse>) : List<BlogItemUiModel> {
        val blogUiModelList = mutableListOf<BlogItemUiModel>()

        blogResponseList.forEach {

            val blogUiModel = BlogItemUiModel(
                title = it.title.rendered,
                imageUrl = it.jetpackFeaturedMediaUrl,
                date = getFormatterDate(it.date),
                content = it.content.rendered,
                excerpt = it.excerpt.rendered
            )

            blogUiModelList.add(blogUiModel)
        }

        return blogUiModelList
    }

    private fun getFormatterDate(dateInput: String) : String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val blogModifiedDate = inputFormat.parse(dateInput)

        return outputFormat.format(blogModifiedDate)
    }
}
