package com.example.aop_part3_chapter04

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aop_part3_chapter04.adapter.BookAdapter
import com.example.aop_part3_chapter04.api.BookAPI
import com.example.aop_part3_chapter04.databinding.ActivityMainBinding
import com.example.aop_part3_chapter04.model.SearchBooksDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)





        setContentView(binding.root)
        val adapter = BookAdapter()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: BookAPI = retrofit.create(BookAPI::class.java)


//t44t4

        service.getBookList()
            .enqueue(object : Callback<SearchBooksDto> {
                override fun onResponse(
                    call: Call<SearchBooksDto>,
                    response: Response<SearchBooksDto>
                ) {

                    Log.d("senderror1",response.body().toString())

                    if (response.isSuccessful.not()) {
                        return
                    }
                    response.body()?.let {


                        adapter.submitList(it.items)
                    }
                }

                override fun onFailure(call: Call<SearchBooksDto>, t: Throwable) {
              Log.e("senderror",t.toString())
                }

            })


    }
}