package com.hellohasan.mvpblog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.mvpblog.databinding.ItemBlogPostBinding

class BlogPostRecyclerViewAdapter(private val blogPostList: List<BlogResponse>) :
    RecyclerView.Adapter<BlogPostRecyclerViewAdapter.BlogPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        val binding = ItemBlogPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BlogPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val blogPost = blogPostList[position]
        holder.bind(blogPost)
    }

    override fun getItemCount(): Int {
        return blogPostList.size
    }

    inner class BlogPostViewHolder(private val binding: ItemBlogPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(blogPost: BlogResponse) {
            Glide.with(itemView)
                .load(blogPost.jetpackFeaturedMediaUrl)
                .into(binding.imageViewFeatured)

            binding.textViewTitle.text = blogPost.title.rendered
            binding.textViewModifiedDate.text = blogPost.modified

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, BlogDetailsActivity::class.java)
                intent.putExtra("blog", blogPost)
                binding.root.context.startActivity(intent)
            }
        }
    }
}