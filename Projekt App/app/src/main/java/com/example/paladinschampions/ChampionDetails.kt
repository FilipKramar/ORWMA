package com.example.paladinschampions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.SkillAdapter

class ChampionDetails : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView
    private lateinit var skillarray :ArrayList<Skill>
    private lateinit var skillAdapter: SkillAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_details)

        recyclerView=findViewById(R.id.skillrecycler)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        skillarray= arrayListOf()
        skillAdapter= SkillAdapter(skillarray)
        recyclerView.adapter=skillAdapter


        val ime: TextView =findViewById(R.id.Name)
        val slika: ImageView =findViewById(R.id.Picture)
        val uloga: TextView =findViewById(R.id.role)



        val bundle:Bundle?=intent.extras
        var j:Int=0
        for (i in 1..5) {

            val skillname=bundle!!.getString("skill${i}name")
            val skilldesc=bundle!!.getString("skill${i}desc")
            val skillimage=bundle!!.getString("skill${i}image")
            var skill= Skill(skillname,skilldesc,skillimage)
            skillarray.add(j,skill)
            j++

        }




        ime.text=bundle!!.getString("ime")
        Glide
            .with(this)
            .load(bundle!!.getString("slika"))
            .into(slika)
        uloga.text=bundle!!.getString("role")

        skillAdapter.notifyDataSetChanged()
        findViewById<Button>(R.id.Back).setOnClickListener {
            val intent = Intent(this, ChampList::class.java)
            startActivity(intent)

        }
    }
}