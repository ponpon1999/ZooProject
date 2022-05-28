package com.example.animal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animal.databinding.FragmentFirstBinding

class FirstFragment : androidx.fragment.app.Fragment(),ViewInterface {
    private lateinit var presenter: Presenter
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList1: ArrayList<dataView>
    private lateinit var newArrayList2: ArrayList<dataView>
    private lateinit var newArrayList3: ArrayList<dataView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val binding = FragmentFirstBinding.bind(view)

        newRecyclerview = binding.recyclerView
        newRecyclerview.layoutManager = LinearLayoutManager(context)
        newRecyclerview.setHasFixedSize(true)
        newArrayList1 = arrayListOf<dataView>()
        newArrayList2 = arrayListOf<dataView>()
        newArrayList3 = arrayListOf<dataView>()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = Presenter(this)
        presenter.processCall()
    }

    private fun getUserdata(
        name: MutableList<String>, info:MutableList<String>, pic_url: MutableList<String>
    ){
        for (i in name.indices){
            val name =dataView(name[i]!!.toString(), "", "")
            newArrayList1.add(name)
        }

        for (i in info.indices){
            val info =dataView("", info[i]!!.toString(), "")
            newArrayList2.add(info)
        }

        for (i in pic_url.indices){
            val pic_url =dataView("", "", pic_url[i]!!.toString())
            newArrayList3.add(pic_url)
        }
        var adapter = MyAdapter(newArrayList1,newArrayList2,newArrayList3)


        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val secondFragment = SecondFragment.newInstance(info[position],newArrayList1[position])
                val beginTransaction = parentFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.container,secondFragment)
                beginTransaction.addToBackStack(null)
                beginTransaction.commit()
            }
        })
    }

    override fun show(name: MutableList<String>, info: MutableList<String>, pic_url:MutableList<String>) {
//        context?.let { Toast.makeText(it, "成功", Toast.LENGTH_LONG).show() }
        Log.d("abc",name.toString())
        getUserdata(name,info,pic_url)
    }


}