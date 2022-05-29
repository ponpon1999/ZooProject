package com.example.animal

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val view: ViewInterface):ViewInterfacePresenter {

    val a = mutableListOf("")
    val b = mutableListOf("")
    val c = mutableListOf("")

    override fun processCall() {
        val service =
            RetrofitInstance().retrofitInstance.create(apiterface::class.java)
        val call=service.getPosts1()
        call.enqueue(object : Callback<animal> {
            override fun onFailure(call: Call<animal>, t: Throwable) {
            }
            override fun onResponse(call: Call<animal>, response: Response<animal>) {
                val data=response.body()
                val lim = data?.result?.results.toString()
                //Log.d("a",data.toString())
                Log.d("a",lim)
                for (i in 0..data!!.result.results!!.size-1){
                    a.add(data!!.result.results!![i].e_name)
                    b.add(data!!.result.results!![i].e_info)
                    c.add(data!!.result.results!![i].e_pic_url)
                }
                a.removeAt(0)
                b.removeAt(0)
                c.removeAt(0)
                view.show(a,b,c)
            }
        })
    }

}

private fun <T> Call<T>.enqueue(callback: Callback<animal>) {

}


