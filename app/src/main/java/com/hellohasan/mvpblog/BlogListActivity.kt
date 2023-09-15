package com.hellohasan.mvpblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvpblog.databinding.ActivityMainBinding
import com.hellohasan.mvpblog.network.BlogApiInterface
import com.hellohasan.mvpblog.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BlogListActivity : AppCompatActivity() {

     private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blogApiInterface = RetrofitClient.client.create<BlogApiInterface>()
        val apiCall = blogApiInterface.getBlogList()

        binding.progressBar.isVisible = true

        apiCall.enqueue(object : Callback<List<BlogResponse>> {
            override fun onResponse(
                call: Call<List<BlogResponse>>,
                response: Response<List<BlogResponse>>
            ) {

                val blogList = response.body()

                val layoutManager = LinearLayoutManager(this@BlogListActivity)
                binding.recyclerView.layoutManager = layoutManager

                val adapter = BlogPostRecyclerViewAdapter(blogList!!)
                binding.recyclerView.adapter = adapter

                binding.progressBar.isVisible = false
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                Toast.makeText(this@BlogListActivity, t.message, Toast.LENGTH_LONG).show()
                binding.progressBar.isVisible = false
            }

        })

    }
}