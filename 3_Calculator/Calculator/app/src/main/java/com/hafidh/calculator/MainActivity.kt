package com.hafidh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buEvent(view:View){
        if(isNewOperation) {
            etShowNumber.setText("")
        }
        isNewOperation = false
        var buSelected = view as Button
        var buClickValue:String = etShowNumber.text.toString()
        Log.d("LogNya", buSelected.toString())
        when(buSelected.id){
            bu0.id ->{
                buClickValue +="0"
            }
            bu1.id ->{
                buClickValue +="1"
            }
            bu2.id ->{
                buClickValue +="2"
            }
            bu3.id ->{
                buClickValue +="3"
            }
            bu4.id ->{
                buClickValue +="4"
            }
            bu5.id ->{
                buClickValue +="5"
            }
            bu6.id ->{
                buClickValue +="6"
            }
            bu7.id ->{
                buClickValue +="7"
            }
            bu8.id ->{
                buClickValue +="8"
            }
            bu9.id ->{
                buClickValue +="9"
            }
            buDot.id ->{
                //TODO: Mencegah nambahin lebih dari 1 koma
                buClickValue +="."
            }
            buPlusMinus.id ->{
                buClickValue = "-$buClickValue"
            }
        }
        etShowNumber.setText(buClickValue)
    }

    var op="+"
    var oldNumber = ""
    var isNewOperation = true

    fun buOpEvent(view: View){
        var buSelected = view as Button
        var buClickValue = etShowNumber.text.toString()
        when(buSelected.id){
            buMul.id -> {
                op="*"
            }
            buDiv.id -> {
                op="/"
            }
            buSub.id -> {
                op="-"
            }
            buSum.id -> {
                op="+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOperation = true
    }

    fun buEqualEvent(view: View){
        val newNumber = etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOperation = true
    }

    fun buPercent(view: View){
        val number = etShowNumber.text.toString().toDouble()/100
        etShowNumber.setText(number.toString())
        isNewOperation = true
    }

    fun buClean(view: View){
        etShowNumber.setText("0")
        isNewOperation = true
    }
}
