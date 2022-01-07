package com.example.mvvmroomretro.Api

import com.example.testzetriweb.Model.LoginResponse
import com.example.testzetriweb.Model.LoginResponse2
import retrofit2.Call
import retrofit2.http.*


interface QuoteService {

//    @GET("top-headlines")
//    suspend fun getQuotes(@Query("sources") limit: String, @Query("apiKey") limit2: String?) : Response<QuoteList>


    @POST("posts")
    fun userLogin(@Body LoginResponse:LoginResponse): Call<LoginResponse>

    @DELETE("posts/{id}")
    fun delete( @Path("id")id:Int):Call<Unit>


    @PUT("posts/{id}")
    fun put(@Path("id")id: Int,@Body LoginResponse:LoginResponse):Call<LoginResponse>


    @FormUrlEncoded
    @POST("posts")
    fun userLogin2(@Field("UserId") UserId: String, @Field("title") title: String):Call<LoginResponse>


    @FormUrlEncoded
    @POST("posts")
    fun userLogin3(@Field("name") UserId: String, @Field("job") title: String):Call<LoginResponse2>



}