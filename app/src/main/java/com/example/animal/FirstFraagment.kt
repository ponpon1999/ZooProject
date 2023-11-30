package com.example.animal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animal.databinding.FragmentFirstBinding

class FirstFragment : androidx.fragment.app.Fragment(),ViewInterface {
    private lateinit var presenter: Presenter
    private lateinit var Recyclerview: RecyclerView
    private lateinit var NameData: ArrayList<dataView>
    private lateinit var InfoData: ArrayList<dataView>
    private lateinit var PicData: ArrayList<dataView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val binding = FragmentFirstBinding.bind(view)
        Recyclerview = binding.recyclerView
        Recyclerview.layoutManager = LinearLayoutManager(context)
        Recyclerview.setHasFixedSize(true)
        NameData = arrayListOf()
        InfoData = arrayListOf()
        PicData = arrayListOf()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = Presenter(this)
        presenter.processCall()
    }

    private fun PrintData(
        NameData: MutableList<String>, InfoData:MutableList<String>, PicData: MutableList<String>
    ){
        for (i in NameData.indices){
            val GetData =dataView(NameData[i]!!.toString(), InfoData[i]!!.toString(), PicData[i]!!.toString())
            NameData.add(GetData)
            InfoData.add(GetData)
            PicData.add(GetData)
        }
        var adapter = MyAdapter(NameData,InfoData,PicData)
        Recyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val secondFragment = SecondFragment.newInstance(InfoData[position],NameData[position])
                val beginTransaction = parentFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.container,secondFragment)
                beginTransaction.addToBackStack(null)
                beginTransaction.commit()
            }
        })
    }

    override fun show(name: MutableList<String>, info: MutableList<String>, pic_url:MutableList<String>) {
        PrintData(name,info,pic_url)
    }
}

private fun <E> MutableList<E>.add(element: dataView) {
}
