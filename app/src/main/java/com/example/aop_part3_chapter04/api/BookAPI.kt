package com.example.aop_part3_chapter04.api

import com.example.aop_part3_chapter04.model.SearchBooksDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface BookAPI {
    @GET("v1/search/book.json?query=%EC%A3%BC%EC%8B%9D&display=10")
    fun getBookList(): Call<SearchBooksDto>




}