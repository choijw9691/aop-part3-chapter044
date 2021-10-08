package com.example.aop_part3_chapter04.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aop_part3_chapter04.R
import com.example.aop_part3_chapter04.databinding.ItemBookBinding
import com.example.aop_part3_chapter04.model.SearchBooksDto
import com.example.aop_part3_chapter04.model.book


class BookAdapter : ListAdapter<book, BookAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookModel: book) {
            binding.titleTextView.text = bookModel.title
            binding.descriptionTextView.text = bookModel.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<book>() {
            override fun areItemsTheSame(oldItem: book, newItem: book): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: book, newItem: book): Boolean {
                return oldItem == newItem
            }

        }
    }

}