package com.hafidh.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buDapatkanUmur.setOnClickListener {
            buDapatkanUmurClick()
        }
    }

    fun buDapatkanUmurClick(){
        val tglLahirPengguna = Integer.parseInt(etTglLahir.text.toString())
        val tahunSekarang = Calendar.getInstance().get(Calendar.YEAR)
        val umurUser = tahunSekarang - tglLahirPengguna
        tvTampilkanUmur.text= "Umur Anda sekarang $umurUser tahun"
        Log.d("Lognya", "Umur Anda sekarang $umurUser tahun")
    }
}
