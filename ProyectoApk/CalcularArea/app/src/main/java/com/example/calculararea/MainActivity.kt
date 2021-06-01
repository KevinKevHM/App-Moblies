package com.example.calculararea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

 const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val check1 = findViewById<CheckBox>(R.id.check_100)
        val check2 = findViewById<CheckBox>(R.id.check300)
        val plazas = findViewById<EditText>(R.id.txt_plazas)
        val etiqueta_radio = findViewById<TextView>(R.id.txt_etiqueta_intrucciones)
        val etiqueta_plazas = findViewById<TextView>(R.id.txtview_numero_plazas)
        val boton = findViewById<Button>(R.id.btn_sudmit)

        var num_plazas:Int
        val radio_farola = 1
        val n_farolas = 7
        var radio:Int
        val c1 = 100
        val c2 = 300
        var sumatoria_areas_farolas = 0f
        var areas_totales = 0f

       boton.setOnClickListener{

           // val area_farola = (3.14159265*(1*1))*7
                if (check1.isChecked && check2.isChecked){
                    Toast.makeText(applicationContext,"Solo puedes selecionar 1 opcion a la vez", Toast.LENGTH_LONG).show()

                   }

           if (check1.isChecked==false && check2.isChecked==false){
               Toast.makeText(applicationContext,"Por favor selecciona una opcion!", Toast.LENGTH_LONG).show()
           }
           if (!plazas.text.isEmpty()) {
               num_plazas = plazas.text.toString().toInt()




               if (check1.isChecked && check2.isChecked == false) {
                   var areas_farola = (3.14159265 * (radio_farola * radio_farola))
                   var area_plaza = 3.14159265 * (c1 * c1)


                   for (i in 1..n_farolas) {
                       sumatoria_areas_farolas += areas_farola.toFloat()

                   }


                   var result = area_plaza.toFloat() - sumatoria_areas_farolas

                   for (i in 1..num_plazas) {

                       areas_totales += result

                   }

                   val mensage = areas_totales.toString()

                   val intentResultado: Intent = Intent(applicationContext, Result::class.java).apply {
                       putExtra("resultado", mensage)
                   }
                   startActivity(intentResultado)
                   areas_totales = 0f


               }

               if (check2.isChecked && check1.isChecked == false) {
                   var areas_farola = (3.14159265 * (radio_farola * radio_farola))
                   var area_plaza = 3.14159265 * (c2 * c2)

                   for (i in 1..n_farolas) {
                       sumatoria_areas_farolas += areas_farola.toFloat()

                   }

                   var result = area_plaza.toFloat() - sumatoria_areas_farolas

                   for (i in 1..num_plazas) {

                       areas_totales += result

                   }

                   val mensage = areas_totales.toString()

                   val intentResultado: Intent = Intent(applicationContext, Result::class.java).apply {
                       putExtra("resultado", mensage)
                   }
                   startActivity(intentResultado)
                   areas_totales = 0f


               }

           }
           else {
               Toast.makeText(applicationContext, "Por favor indique el numero de plazas", Toast.LENGTH_LONG).show()
           }

            }





    }


}