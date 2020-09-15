package com.hafidh.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animal
        listOfAnimals.add(Animal("Babon","Babon tinggal di hutan, makan pisang. Dia sejenis monyet", R.drawable.baboon, false))
        listOfAnimals.add(Animal("Bulldog","Bulldog adlah hewan peliharaan", R.drawable.bulldog, false))
        listOfAnimals.add(Animal("Panda","Panda suka makan Bambu", R.drawable.panda, true))
        listOfAnimals.add(Animal("Swallow Bird","Swallow bird bisa terbang", R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal("White Tiger","White tiger adalah kucing besar yang tinggal dihutan dan berwarna putih hitam", R.drawable.white_tiger, true))
        listOfAnimals.add(Animal("Zebra","Zebra tinggal di padang rumput seperti di afrika", R.drawable.zebra, false))

        adapter = AnimalAdapter(this, listOfAnimals)
        lvAnimal.adapter = adapter
    }

    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index:Int){
        listOfAnimals.add(index, listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }

    
    inner class AnimalAdapter:BaseAdapter{
        var listOfAnimals= ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals=listOfAnimals
            this.context=context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            var myView:View
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if(animal.isKiller==true){
                myView = inflater.inflate(R.layout.animal_killer_ticket, null)
            }else{
                myView = inflater.inflate(R.layout.animal_ticket, null)
            }

            myView.tvName.text = animal.name
            myView.tvDesc.text = animal.desc
            myView.ivAnimalImage.setImageResource(animal.image!!)

            myView.ivAnimalImage.setOnClickListener{
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name!!)
                intent.putExtra("desc", animal.desc!!)
                intent.putExtra("image", animal.image!!)
                context!!.startActivity(intent)
            }

            myView.btnDelete.setOnClickListener {
                delete(p0)
            }

            myView.btnDuplicate.setOnClickListener {
                add(p0)
            }

            return myView
        }
        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }
    }
}
