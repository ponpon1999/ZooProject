package com.example.animal

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val view: FirstFragment):ViewInterfacePresenter {
    val Name = mutableListOf("")//儲存園區名稱
    val Info = mutableListOf("")//儲存園區資訊
    val Pic = mutableListOf("")//儲存園區圖片URL

    override fun processCall() {
        val service =
            RetrofitInstance().retrofitInstance.create(APIinterface::class.java)
        val call=service.getPosts1()
        call?.enqueue(object : Callback<animal> {
            override fun onFailure(call: Call<animal>, t: Throwable) {
            }
            override fun onResponse(call: Call<animal>, response: Response<animal>) {
                val data=response.body()
                for (i in 0..data!!.result.results!!.size-1){
                    Name.add(data!!.result.results!![i].e_name)
                    Info.add(data!!.result.results!![i].e_info)
                    Pic.add(data!!.result.results!![i].e_pic_url)
                }
                Name.removeAt(0)
                Info.removeAt(0)
                Pic.removeAt(0)
                view.show(Name,Info,Pic)
            }
        })
    }
}


