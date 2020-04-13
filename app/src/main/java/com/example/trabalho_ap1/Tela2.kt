package com.example.trabalho_ap1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_tela2.*
import kotlinx.android.synthetic.main.activity_main.btn_enviar
import kotlinx.android.synthetic.main.activity_main.quant

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

class Tela2 : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {

    var quant1 = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val spinner = findViewById<Spinner>(R.id.dropdown)
        var editValue = findViewById<EditText>(R.id.editValue2)
        btn_enviar.setOnClickListener(View.OnClickListener {
            if (!"".equals(editValue2.text.toString())) {

                val dados1 = intent.getParcelableExtra<valor1>("dados1")
                var price1 = editValue.text.toString().toFloat() / quant1
                var price2 = dados1.value1.toString().toFloat() / dados1.size.toString().toFloat()

                if (price1 > price2) {

                    var cheapBeer = 1
                    var submit = valor2(price2.toString(), price1.toString(), cheapBeer.toString())
                    val submitFor = Intent(this, Resultado::class.java)
                    submitFor.putExtra("dados2", submit)
                    startActivity(submitFor)
                }

                if (price2 > price1) {

                    var cheapBeer = 2
                    var submit =
                        valor2(price1.toString(), price2.toString(), cheapBeer.toString())
                    val submitFor = Intent(this, Resultado::class.java)
                    submitFor.putExtra("dados2", submit)
                    startActivity(submitFor)
                }

                if (price1 == price2) {
                    var cheapBeer = 3
                    var submit =
                        valor2(price1.toString(), price2.toString(), cheapBeer.toString())
                    val submitFor = Intent(this, Resultado::class.java)
                    submitFor.putExtra("dados2", submit)
                    startActivity(submitFor)
                }
            } else {
                val alert =
                    AlertDialog.Builder(this@Tela2)
                alert.setTitle("Alerta")
                alert
                    .setIcon(R.drawable.ic_info_foreground)
                    .setMessage("Preencha todos os campos!")
                    .setCancelable(true)
                    .setPositiveButton("OK!",
                        DialogInterface.OnClickListener { _, _ -> })
                val alertDialog = alert.create()
                alertDialog.show()
            }
        })

        var list = arrayOf("1000 ml", "600 ml", "550 ml", "355 ml", "350 ml", "300 ml")
        spinner.setOnItemSelectedListener(this)
        val choice = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        choice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(choice)
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, select: Int, id: Long) {
        if (select == 0) {
            quant.text = "1000 ml"
            quant1 = 1000
        }
        if (select == 1) {
            quant.text = "600 ml"
            quant1 = 600
        }
        if (select == 2) {
            quant.text = "550 ml"
            quant1 = 550
        }
        if (select == 3) {
            quant.text = "355 ml"
            quant1 = 355
        }
        if (select == 4) {
            quant.text = "350 ml"
            quant1 = 350
        }
        if (select == 5) {
            quant.text = "300 ml"
            quant1 = 300
        }

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }

    override fun onClick(v: View?) {
    }
}