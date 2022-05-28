package com.example.animal

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlantPresenter(private val view: PlantViewInterface):PlantViewInterfacePresenter {

    val a = mutableListOf("")
    val b = mutableListOf("")
    val c = mutableListOf("")

    override fun processCall() {
        val service =
            RetrofitInstance().retrofitInstance.create(apiterface::class.java)
        val call=service.getPosts2()
        call.enqueue(object : Callback<Plant> {
            override fun onFailure(call: Call<Plant>, t: Throwable) {
            }
            override fun onResponse(call: Call<Plant>, response: Response<Plant>) {
                val data=response.body()
                val lim = data?.result?.results.toString()
                Log.d("ooo",lim)
                for (i in 0..data!!.result.results!!.size-1){
                    a.add(data!!.result.results!![i].F_AlsoKnown)
                    b.add(data!!.result.results!![i].F_Location)
                    c.add(data!!.result.results!![i].F_Pic01_URL)
                }
                a.removeAt(0)
                b.removeAt(0)
                c.removeAt(0)
                Log.d("ooo",a.toString())
                view.show(a,b,c)
            }

        })
    }

}

private fun <T> Call<T>.enqueue(callback: Callback<Plant>) {

}


