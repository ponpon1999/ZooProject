package com.example.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animal.databinding.FragmentSecondBinding


class SecondFragment : Fragment() ,PlantViewInterface,ViewInterface{
    private var InfoData: String? = null
    private var E_name: String? = null
    private lateinit var presenter: PlantPresenter
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList1: ArrayList<dataView>
    private lateinit var newArrayList2: ArrayList<dataView>
    private lateinit var newArrayList3: ArrayList<dataView>

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentSecondBinding.bind(view)
        binding.infoData.setText(InfoData)
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
        presenter = PlantPresenter(this)
        presenter.processCall()
    }

    companion object {
        fun newInstance(infoData: String, e_name: dataView) =
            SecondFragment().apply {
                InfoData = infoData
//              Log.d("aaa",e_name.name)
                E_name = e_name.name
            }
    }

    private fun getUserdata(
        AlsoKnown: MutableList<String>, Location:MutableList<String>, pic_url: MutableList<String>
    ){
//        Log.d("aaa",info[0])
//        if (info[1].contains(E_name.toString())){
//            Log.d("aaa","susess")
//        }
        for (i in AlsoKnown.indices){
            if(Location[i].contains(E_name.toString())){
                val AlsoKnown =dataView(AlsoKnown[i]!!.toString(), "", "")
                newArrayList1.add(AlsoKnown)
            }
        }
        for (i in Location.indices){
            if(Location[i].contains(E_name.toString())) {
                val Location = dataView("", Location[i]!!.toString(), "")
                newArrayList2.add(Location)
            }
        }

        for (i in pic_url.indices){
            if(Location[i].contains(E_name.toString())) {
                val pic_url = dataView("", "", pic_url[i]!!.toString())
                newArrayList3.add(pic_url)
            }
        }

        var adapter = PlantMyAdapter(newArrayList1,newArrayList2,newArrayList3)


        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : PlantMyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val ThirdFragment = ThirdFragment.newInstance(AlsoKnown[position],Location[position],pic_url[position])
                val beginTransaction = parentFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.container,ThirdFragment)
                beginTransaction.addToBackStack(null)
                beginTransaction.commit()
            }
        })

    }

    override fun show(name: MutableList<String>, info: MutableList<String>, pic_url:MutableList<String>) {
//        context?.let { Toast.makeText(it, "成功", Toast.LENGTH_LONG).show() }
        getUserdata(name,info,pic_url)
    }
}
