package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paladinschampions.R
import com.example.paladinschampions.Skill

class SkillAdapter(private val skilllist:ArrayList<Skill>):RecyclerView.Adapter<SkillAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.skill,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val skill:Skill=skilllist[position]
        holder.Name.text=skill.Name
        holder.Description.text=skill.Description
        Glide
            .with(holder.itemView)
            .load(skill.Image )
            .into(holder.Image)

    }

    override fun getItemCount(): Int {
        return skilllist.size
    }
    class  MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val Image: ImageView =
            itemView.findViewById(R.id.SkillPicture)
        val Name: TextView =
            itemView.findViewById(R.id.skillName)
        val Description: TextView =
            itemView.findViewById(R.id.skillDescription)




    }

}
