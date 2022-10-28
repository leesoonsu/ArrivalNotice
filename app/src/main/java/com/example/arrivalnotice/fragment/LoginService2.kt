package com.example.arrivalnotice

data class LoginService2(
    val access: String,
    val refresh: String
    //output => 서버를 호출했을 때 클라이언트로 내려주는 응답 값
    //access 변수명과 refresh 변수명이 서버에서 내려주는 json 과 일치해야함
)