package com.hafidh.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
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
        Log.d("logNya buSelected", buSelected.id.toString())
        Log.d("logNya cellId", cellId.toString())
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
            Log.d("logNya Player 1:", player1.toList().toString())
            activePlayer = 2
            autoPlay()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.warnaHijauGelap)
            player2.add(cellId)
            Log.d("logNya Player 2:", player2.toList().toString())
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
            player1WinsCount += 1
            Toast.makeText(this, "Pemain 1 memenangkan permainan", Toast.LENGTH_LONG).show()
            RestartGame()
        }else if(winer == 2){
            player2WinsCount += 1
            Toast.makeText(this, "Pemain 2 memenangkan permainan", Toast.LENGTH_LONG).show()
            RestartGame()
        }
    }

    fun autoPlay(){
        var emptyCells = arrayListOf<Int>()
        for(cellId in 1..9){
            if(!player1.contains(cellId) || player2.contains(cellId)){
                emptyCells.add(cellId)
            }
        }
        Log.d("logNya emptyCells", emptyCells.toList().toString())
        Log.d("logNya size emptyCells", emptyCells.size.toString())

        if(emptyCells.size == 0){
            RestartGame()
        }

        var randomIndex = Random().nextInt(emptyCells.size)
        Log.d("logNya RandomIndex", randomIndex.toString())
        var cellId = emptyCells[randomIndex]
        Log.d("logNya cellId", cellId.toString())

        var buSelected:Button?
        buSelected = when(cellId){
            1 -> bu1
            2 -> bu2
            3 -> bu3
            4 -> bu4
            5 -> bu5
            6 -> bu6
            7 -> bu7
            8 -> bu8
            9 -> bu9
            else -> {bu1}
        }

        playGame(cellId, buSelected)
    }

    var player1WinsCount:Int = 0
    var player2WinsCount:Int = 0

    fun RestartGame(){
        activePlayer = 1
        player1.clear()
        player2.clear()

        for(cellId in 1..9){
            var buSelected:Button? = when(cellId){
                1 -> bu1
                2 -> bu2
                3 -> bu3
                4 -> bu4
                5 -> bu5
                6 -> bu6
                7 -> bu7
                8 -> bu8
                9 -> bu9
                else -> {bu1}
            }
            buSelected!!.text=""
            buSelected.setBackgroundColor(R.color.warnaPutih)
            buSelected.isEnabled = true
        }

        Toast.makeText(this,"Player1: $player1WinsCount, Player2: $player2WinsCount", Toast.LENGTH_LONG).show()
    }
}
