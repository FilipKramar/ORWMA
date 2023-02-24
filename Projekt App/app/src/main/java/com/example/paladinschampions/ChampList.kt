package com.example.paladinschampions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Champ
import com.example.myapplication.ChampionListAdapter
import com.google.firebase.firestore.*

class ChampList : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView
    private lateinit var champarrayList :ArrayList<Champ>
    private lateinit var championListAdapter: ChampionListAdapter
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.champlist)
        recyclerView=findViewById(R.id.ChampRecycler)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        champarrayList= arrayListOf()
        championListAdapter= ChampionListAdapter(champarrayList)
        recyclerView.adapter=championListAdapter
        championListAdapter.setOnItemClickListener(object :ChampionListAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@ChampList, ChampionDetails::class.java)
                intent.putExtra("ime",champarrayList[position].Name)
                intent.putExtra("slika",champarrayList[position].Image)
                intent.putExtra("role",champarrayList[position].Role)

                intent.putExtra("skill1name",champarrayList[position].Skill1Name)
                intent.putExtra("skill1desc",champarrayList[position].Skill1Description)
                intent.putExtra("skill1image",champarrayList[position].Skill1Image)

                intent.putExtra("skill2name",champarrayList[position].Skill2Name)
                intent.putExtra("skill2desc",champarrayList[position].Skill2Description)
                intent.putExtra("skill2image",champarrayList[position].Skill2Image)

                intent.putExtra("skill3name",champarrayList[position].Skill3Name)
                intent.putExtra("skill3desc",champarrayList[position].Skill3Description)
                intent.putExtra("skill3image",champarrayList[position].Skill3Image)

                intent.putExtra("skill4name",champarrayList[position].Skill4Name)
                intent.putExtra("skill4desc",champarrayList[position].Skill4Description)
                intent.putExtra("skill4image",champarrayList[position].Skill4Image)

                intent.putExtra("skill5name",champarrayList[position].Skill5Name)
                intent.putExtra("skill5desc",champarrayList[position].Skill5Description)
                intent.putExtra("skill5image",champarrayList[position].Skill5Image)

                startActivity(intent)

            }

        })

        EventChangeListener()
    }

    private fun EventChangeListener() {
        db= FirebaseFirestore.getInstance()
        db.collection("champions").orderBy("Name",Query.Direction.ASCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if(error!=null){
                        Log.e("Firestore error",error.message.toString())
                        return
                    }
                    for(dc: DocumentChange in value?.documentChanges!!){
                        if (dc.type== DocumentChange.Type.ADDED){
                            champarrayList.add(dc.document.toObject(Champ::class.java))
                        }
                        championListAdapter.notifyDataSetChanged()
                    }
                }
            }
            )
    }
}
