package com.example.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@Suppress("UNREACHABLE_CODE")
class PlantMyAdapter(private val AlsoKnown:ArrayList<dataView>,
                     private val Location: ArrayList<dataView>,
                     private val Pic_url: ArrayList<dataView>
                ) :

    RecyclerView.Adapter<PlantMyAdapter.MyViewHolder>() {
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
        Pic_url.run {
            val currentItem1 = AlsoKnown[position]
            val currentItem2= Location[position]
            val currentItem3= Pic_url[position]
            val URL = (currentItem3.pic.toString()).replace("http", "https")
            holder.alsoKnown.text = currentItem1.name
            holder.location.text = currentItem2.info
            //holder.pic.load("https://www.zoo.gov.tw/iTAP/05_Exhibit/04_DesertAnimal.jpg")
            //holder.pic.load("${currentItem3.pic}")
            Glide.with(holder.itemView.context)
                .load(URL)
                .into(holder.pic_url)
        }
    }

    override fun getItemCount(): Int {
        return AlsoKnown.size
        return Location.size
        return Pic_url.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val alsoKnown : TextView = itemView.findViewById(R.id.name)
        val location : TextView = itemView.findViewById(R.id.info)
        val pic_url: ImageView = itemView.findViewById(R.id.pic)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}