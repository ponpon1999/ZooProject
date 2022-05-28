package com.example.animal

import android.graphics.drawable.Drawable
import android.icu.number.NumberFormatter.with
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.bumptech.glide.request.RequestListener
import javax.sql.DataSource

class MyAdapter(private val animalName:ArrayList<dataView>,
                private val animalInfo: ArrayList<dataView>,
                private val pic: ArrayList<dataView>
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
            val URL = currentItem3.pic.toString()
            holder.name.text = currentItem1.name
            holder.info.text = currentItem2.info
            //holder.pic.load("https://www.zoo.gov.tw/iTAP/05_Exhibit/04_DesertAnimal.jpg")
            //holder.pic.load("${currentItem3.pic}")
            Glide.with(holder.itemView.context)
                .load(URL)
                .into(holder.pic)

            Log.d("ppp",currentItem3.pic.toString())
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