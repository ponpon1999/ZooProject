package com.example.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animal.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() ,PlantViewInterface,ViewInterface{
    private var InfoData: String? = null
    private var E_name: String? = null
    private lateinit var presenter: PlantPresenter
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList1: ArrayList<dataView>
    private lateinit var newArrayList2: ArrayList<dataView>
    private lateinit var newArrayList3: ArrayList<dataView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentSecondBinding.bind(view)
        binding.infoData.setText(InfoData)
//        binding.title1.setText("植物資料")
        newRecyclerview = binding.recyclerView1
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
                E_name = e_name.name
            }
    }

    private fun getUserdata(
        AlsoKnown: MutableList<String>, Location:MutableList<String>, pic_url: MutableList<String>
    ){
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
                val Pic_url = dataView("", "", pic_url[i]!!.toString())
                newArrayList3.add(Pic_url)
            }
        }

        var adapter = PlantMyAdapter(newArrayList1,newArrayList2,newArrayList3)
        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : PlantMyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val ThirdFragment = ThirdFragment.newInstance(newArrayList1[position].name, newArrayList3[position].pic.toString())
                val beginTransaction = parentFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.container,ThirdFragment)
                beginTransaction.addToBackStack(null)
                beginTransaction.commit()
            }
        })

    }

    override fun show(AlsoKnown: MutableList<String>, Location: MutableList<String>, Pic_url:MutableList<String>) {
        getUserdata(AlsoKnown,Location,Pic_url)
    }
}
