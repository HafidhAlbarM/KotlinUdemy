package com.hafidh.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View){
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        //Log.d("tombol", buSelected.id.toString())
        //Log.d("tombol: cellId", cellId.toString())
        playGame(cellId, buSelected)
    }

    var activePlayer = 1
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()

    fun playGame(cellId:Int, buSelected:Button){
        if(activePlayer == 1){
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.warnaBiru)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.warnaHijauGelap)
            player2.add(cellId)
            activePlayer = 1
        }

        buSelected.isEnabled = false

        checkwiner()
    }

    fun checkwiner(){
        var winer = 0

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer = 1
        }else if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer = 1
        }else if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer = 1
        }else if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer = 2
        }

        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer = 1
        }else if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer = 2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer = 1
        }else if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer = 2
        }

        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
        }else if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
        }
        
        if(winer == 1){
            Toast.makeText(this, "Pemain 1 memenangkan permainan", Toast.LENGTH_LONG).show()
        }else if(winer == 2){
            Toast.makeText(this, "Pemain 2 memenangkan permainan", Toast.LENGTH_LONG).show()
        }
    }

    fun autoPlay(){
        var emptyCells = arrayListOf<Int>()
        for(cellId in 1..9){
            if(!player1.contains(cellId) || player2.contains(cellId)){
                emptyCells.add(cellId)
            }
        }
        Log.d("logNya 1", emptyCells.toList().toString())
        Log.d("logNya 2", emptyCells.size.toString())

        var randomIndex = Random().nextInt(emptyCells.size)
        Log.d("logNya 3", randomIndex.toString())

    }
}
