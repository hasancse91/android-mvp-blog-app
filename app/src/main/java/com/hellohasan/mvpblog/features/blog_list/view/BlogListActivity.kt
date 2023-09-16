package com.hellohasan.mvpblog.features.blog_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvpblog.features.blog_list.model.BlogResponse
import com.hellohasan.mvpblog.databinding.ActivityBlogListBinding
import com.hellohasan.mvpblog.features.blog_list.model.BlogApiInterface
import com.hellohasan.mvpblog.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BlogListActivity : AppCompatActivity(), BlogListView {

    private lateinit var binding: ActivityBlogListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun showLoader(shouldShow: Boolean) {
        binding.progressBar.isVisible = shouldShow
    }

    override fun showBlogList(blogList: List<BlogResponse>) {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = BlogPostRecyclerViewAdapter(blogList)
        binding.recyclerView.adapter = adapter
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

//    private fun showBlogPostList() {
//        val blogApiInterface = RetrofitClient.client.create<BlogApiInterface>()
//        val apiCall = blogApiInterface.getBlogList()
//
//        binding.progressBar.isVisible = true
//
//        apiCall.enqueue(object : Callback<List<BlogResponse>> {
//            override fun onResponse(
//                call: Call<List<BlogResponse>>,
//                response: Response<List<BlogResponse>>
//            ) {
//
//                val blogList = response.body()
//
//                val layoutManager = LinearLayoutManager(this@BlogListActivity)
//                binding.recyclerView.layoutManager = layoutManager
//
//                val adapter = BlogPostRecyclerViewAdapter(blogList!!)
//                binding.recyclerView.adapter = adapter
//
//                binding.progressBar.isVisible = false
//            }
//
//            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
//                Toast.makeText(this@BlogListActivity, t.message, Toast.LENGTH_LONG).show()
//                binding.progressBar.isVisible = false
//            }
//
//        })
//    }


}