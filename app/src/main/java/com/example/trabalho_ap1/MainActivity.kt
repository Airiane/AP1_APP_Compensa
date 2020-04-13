package com.example.trabalho_ap1

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    View.OnClickListener {

    var quant1 = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.dropdown)
        btn_enviar.setOnClickListener(View.OnClickListener {
            if (!"".equals(editValue1.text.toString())) {
                var submit = valor1(editValue1.text.toString(), quant1.toString())
                val submitFor = Intent(this, Tela2::class.java)
                submitFor.putExtra("dados1", submit)
                startActivity(submitFor)
            } else {
                val alert =
                        AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Alerta")
                alert
                        .setIcon(R.drawable.ic_info_foreground)
                        .setMessage("Preencha todos os campos!")
                        .setCancelable(true)
                        .setPositiveButton("OK!",
                                DialogInterface.OnClickListener { dialogInterface, i -> })
                val alertDialog = alert.create()
                alertDialog.show()
            }
        })

        var list = arrayOf("1 l", "600 ml", "550 ml", "355 ml", "350 ml", "300 ml")
        spinner!!.setOnItemSelectedListener(this)

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