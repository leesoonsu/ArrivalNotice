package com.example.arrivalnotice

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("/api/token/")
    fun requestLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginService2>

}
//interface 는 객체에 담긴 캡슐 지정(속성과 메소드)
//input 설정 =>username 과 password  그리고 login class 형태로 output을 받아옴
//call<Login>은 호출하고 응답으로 어떤 값을 받아올지 적는 것