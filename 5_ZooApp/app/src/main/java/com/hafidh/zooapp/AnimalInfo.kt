package com.hafidh.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        //nerima data dari MainActiviy
        val bundle:Bundle = intent.extras!!
        val name = bundle.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")

        ivAnimalImage.setImageResource(image)
        tvAnimalName.text = name
        tvAnimalDesc.text = desc
    }
}
