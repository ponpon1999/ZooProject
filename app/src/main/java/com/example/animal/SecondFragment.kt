package com.example.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animal.databinding.FragmentSecondBinding

class SecondFragment : Fragment() ,ViewInterface{
    private var InfoData2: String? = null
    private var E_name: String? = null
    private lateinit var presenter: PlantPresenter
    private lateinit var Recyclerview: RecyclerView
    private lateinit var NameData: ArrayList<dataView>
    private lateinit var InfoData: ArrayList<dataView>
    private lateinit var PicData: ArrayList<dataView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentSecondBinding.bind(view)
        binding.infoData.setText(InfoData2)
        Recyclerview = binding.recyclerView1
        Recyclerview.layoutManager = LinearLayoutManager(context)
        Recyclerview.setHasFixedSize(true)
        NameData = arrayListOf()
        InfoData = arrayListOf()
        PicData = arrayListOf()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PlantPresenter(this)
        presenter.processCall()
    }


    companion object {
        fun newInstance(infoData: String, e_name: String) =
            SecondFragment().apply {
                InfoData2 = infoData
                E_name = e_name
            }
    }

    private fun getUserdata(
        AlsoKnown: MutableList<String>, Location:MutableList<String>, pic_url: MutableList<String>
    ){
        for (i in AlsoKnown.indices){
            if(Location[i].contains(E_name.toString())){
                val GetData =dataView(AlsoKnown[i]!!.toString(), Location[i]!!.toString(), pic_url[i]!!.toString())
                NameData.add(GetData)
                InfoData.add(GetData)
                PicData.add(GetData)
            }
        }
        var adapter = PlantMyAdapter(NameData,InfoData,PicData)
        Recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : PlantMyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val ThirdFragment = ThirdFragment.newInstance(NameData[position].name, PicData[position].pic.toString())
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
