package com.hellohasan.mvpblog.features.blog_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvpblog.databinding.ActivityBlogListBinding
import com.hellohasan.mvpblog.features.blog_list.model.data.BlogItemUiModel
import com.hellohasan.mvpblog.features.blog_list.presenter.BlogListPresenter
import com.hellohasan.mvpblog.features.blog_list.presenter.BlogListPresenterImpl

class BlogListActivity : AppCompatActivity(), BlogListView {

    private lateinit var binding: ActivityBlogListBinding
    private lateinit var presenter: BlogListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = BlogListPresenterImpl(this)

        presenter.fetchBlogList()
    }

    override fun showLoader(shouldShow: Boolean) {
        binding.progressBar.isVisible = shouldShow
    }

    override fun showBlogList(blogList: List<BlogItemUiModel>) {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = BlogPostRecyclerViewAdapter(blogList)
        binding.recyclerView.adapter = adapter
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}