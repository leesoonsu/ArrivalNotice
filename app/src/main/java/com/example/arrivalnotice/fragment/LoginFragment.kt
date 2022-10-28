package com.example.arrivalnotice.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.arrivalnotice.LoginService
import com.example.arrivalnotice.LoginService2
import com.example.arrivalnotice.R
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var retrofit = Retrofit.Builder()
            .baseUrl("http://3.35.87.164:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //api 주소 불러오기(api 객체 설정)

        var loginService = retrofit.create(LoginService::class.java)
        //LoginService 에 대한 객체(인터페이스 호출)

        button.setOnClickListener {
            var id = editText.text.toString()
            var pw = editText2.text.toString()

            loginService.requestLogin(username = id, password = pw).enqueue(object: Callback<LoginService2>{
                override fun onFailure(call: Call<LoginService2>, t: Throwable) {
                    t.message?.let { it1 -> Log.e("LOGIN", it1) }
                    val builder = AlertDialog.Builder(
                        activity!!
                    )
                    builder.setTitle("에러")
                    builder.setMessage("호출실패했습니다.")
                    builder.show()
                }
                //api 서버와 연결이 실패했을 경우

                override fun onResponse(call: Call<LoginService2>, response: Response<LoginService2>) {
                    var login = response.body()
                    Log.d("LOGIN","refresh : "+login?.refresh)
                    Log.d("LOGIN","access : "+login?.access)
                    val builder = AlertDialog.Builder(
                        activity!!
                    )
                    builder.setTitle(login?.refresh)
                    builder.setMessage(login?.access)
                    builder.show()
                }
            })
            //api 서버와 연결을 성공했을 경우
        }
        navController = Navigation.findNavController(view)
    }


}




