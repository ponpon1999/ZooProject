package com.example.animal

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

@Suppress("UNREACHABLE_CODE")
class MyAdapter(private val animalName: MutableList<String>,
                private val animalInfo: MutableList<String>,
                private val pic: MutableList<String>
                ) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)

        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        pic?.run {
            val currentItem1 = animalName[position]
            val currentItem2= animalInfo[position]
            val currentItem3= pic[position]
            val URL = (currentItem3).replace("http", "https")
            Log.d(TAG,URL+"good")
            holder.name.text = currentItem1
            holder.info.text = currentItem2
            holder.run { pic.load(URL) }
//            holder.run { pic.load("https://www.zoo.gov.tw/iTAP/05_Exhibit/04_DesertAnimal.jpg") }
//            holder.pic.load("${currentItem3.pic}")
//            Glide.with(holder.itemView.context)
//                .load(URL)
//                .into(holder.pic)
        }
    }

    override fun getItemCount(): Int {
        return animalName.size
        return animalInfo.size
        return pic.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val info : TextView = itemView.findViewById(R.id.info)
        val pic: ImageView = itemView.findViewById(R.id.pic)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

