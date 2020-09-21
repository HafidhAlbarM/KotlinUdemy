package com.hafidh.diagnosakerusakankendaraan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_pertanyaan.view.*

class MainActivity : AppCompatActivity() {

    var listOfPertanyaan = ArrayList<Pertanyaan>()
    var adapter:PertanyaanAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfPertanyaan.add(Pertanyaan(1,"Apakah mesin mobil sulit di starter?",
            "Motor starter rusak, atau\n" +
                "Ada kesalahan dalam sistem rangkaian listrik, atau\n" +
                "Penyambungan antar terminal kurang baik, atau\n" +
                "Kurangnya arus listrik pada baterai.\n"))
        listOfPertanyaan.add(Pertanyaan(2,"Apakah motor starter bekerja, namun mesin tetap tidak dapat bekerja?","Motor starter rusak\n" +
                "Roda gigi dari roda gaya atau pinion rusak\n" +
                "Bensin habis, atau terlalu banyak bensin dalam ruang bakar\n" +
                "Bensin terlalu sedikit dalam karburator\n" +
                "Karburator banjir\n" +
                "Mesin menjadi terlalu panas\n" +
                "Busi yang tidak dalam performa terbaiknya\n"))
        listOfPertanyaan.add(Pertanyaan(3, "Apakah mesin mobil tidak bekerja dengan halus?","Kabel busi dan distributor tidak terpasang dengan baik\n" +
                    "Ada beberapa busi yang tidak bekerja dengan baik\n" +
                    "Penyetelan karburator kurang tepat\n"))
        listOfPertanyaan.add(Pertanyaan(4,"Apakah Mesin tidak menghasilkan daya yang penuh?","Kesalahan atau kerusakan dari sistem pembakaran atau penyalaan mesin\n" +
                    "Penyaluran bahan bakar yang kurang tepat\n" +
                    "Mesin mobil yang terlalu panas\n" +
                    "Slip pada kopling\n" +
                    "Terjadi gesekan pada rem\n" +
                    "Proses kompresi dalam silinder kurang maksimal\n"))
        listOfPertanyaan.add(Pertanyaan(5, "Apakah Mesin tidak menghasilkan daya yang penuh?","Kesalahan atau kerusakan dari sistem pembakaran atau penyalaan mesin\n" +
                "Penyaluran bahan bakar yang kurang tepat\n" +
                "Mesin mobil yang terlalu panas\n" +
                "Slip pada kopling\n" +
                "Terjadi gesekan pada rem\n" +
                "Proses kompresi dalam silinder kurang maksimal\n"))
        listOfPertanyaan.add(Pertanyaan(6,"Apakah  Mesin tiba-tiba mati?","Kurang tepatnya penyetelan putaran tanpa beban akibat saluran bahan bakar yang tersumbat atau bahan bakar yang habis\n" +
                "Busi tidak bekerja akibat kabel listrik terlepas atau terjadi korsleting listrik, ataupun terminal baterai kotor.\n"))
        listOfPertanyaan.add(Pertanyaan(7, "Apakah Mesin tiba-tiba panas?","Kekurangan air dalam karburator\n" +
                "Tersumbatnya pipa-pipa radiator\n" +
                "Selang radiator terpelintir atau tertekuk\n" +
                "Sirip radiator kotor\n" +
                "Rusaknya thermostat\n" +
                "Pompa pendingin tidak bekerja dengan baik\n" +
                "Saat penyetelan kurang tepat. Hal ini dikarenakan terlalu banyak kerak karbon dalam ruang bakar\n" +
                "Tersumbatnya knalpot\n" +
                "Slip pada kopling\n" +
                "Rem yang menggesek\n" +
                "Minyak pelumas yang rusak\n" +
                "Proses pelumasan yang kurang baik\n" +
                "Salah dalam menjalankan kendaraan\n" +
                "Beban kendaraan terlalu berat\n"))

        adapter=PertanyaanAdapter(this, listOfPertanyaan)
        lvPertanyaan.adapter = adapter
    }

    inner class PertanyaanAdapter:BaseAdapter{
        var listOfPertanyaan = ArrayList<Pertanyaan>()
        var context:Context?=null
        constructor(context: Context, listOfPertanyaan: ArrayList<Pertanyaan>):super(){
            this.listOfPertanyaan = listOfPertanyaan
            this.context = context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val pertanyaan = listOfPertanyaan[p0]
            var myView:View
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            myView = inflater.inflate(R.layout.card_pertanyaan, null)
            myView.tvPertanyaan.text = pertanyaan.pertanyaan
            return myView
        }

        override fun getItem(p0: Int): Any {
            return listOfPertanyaan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfPertanyaan.size
        }

    }
}
