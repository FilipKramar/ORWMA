package com.example.paladinschampions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class LoadScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loadscreen)
         val logo=findViewById<ImageView>(R.id.Logo)
        Glide
            .with(this)
            .load("https://webcdn.hirezstudios.com/paladins/assets/paladins-logo.png")
            .into(logo)

        findViewById<Button>(R.id.enter_button).setOnClickListener {
         val intent = Intent(this, ChampList::class.java)
         startActivity(intent)

    }
    }
}