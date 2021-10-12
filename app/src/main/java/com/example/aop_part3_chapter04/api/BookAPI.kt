package com.example.aop_part3_chapter04.api

import com.example.aop_part3_chapter04.model.SearchBooksDto
import retrofit2.Call
import retrofit2.http.*


interface BookAPI {


    @GET("v1/search/book.json")
    fun getBookList(@Header("X-Naver-Client-Id") Id:String,
    @Header("X-Naver-Client-Secret")Secret:String,
    @Query(value="query",encoded = false) query: String,
    @Query("display") display:Int = 20,
    ): Call<SearchBooksDto>




}