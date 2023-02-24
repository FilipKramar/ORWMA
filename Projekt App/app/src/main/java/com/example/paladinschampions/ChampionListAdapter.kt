package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paladinschampions.R

class ChampionListAdapter(private val champlist:ArrayList<Champ>):RecyclerView.Adapter<ChampionListAdapter.MyViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.champions,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val champ:Champ=champlist[position]
        holder.ChampName.text=champ.Name
        Glide
            .with(holder.itemView)
            .load(champ.Image)
            .into(holder.ChampPic)


    }

    override fun getItemCount(): Int {
        return champlist.size
    }
   class  MyViewHolder(itemView:View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val ChampPic: ImageView =
            itemView.findViewById(R.id.ChampionPicture)
        val ChampName: TextView =
            itemView.findViewById(R.id.name)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


    }

}
