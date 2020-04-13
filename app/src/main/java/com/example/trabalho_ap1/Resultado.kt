package com.example.trabalho_ap1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_resultado.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

class Resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val data2 = intent.getParcelableExtra<valor2>("dados2")
        if (data2.cheapBeer.toString().toInt() == 1) {
            textResultado.text =
                "A primeira cerveja é mais barata custando R$ ${data2.finalValue}"
            textResultado2.text=
                "Já a segunda custa R$ ${data2.highValue}"

        }
        if (data2.cheapBeer.toString().toInt() == 2) {
            textResultado.text =
                "A segunda cerveja é mais barata custando R$ ${data2.finalValue}"
            textResultado2.text =
                "Já a primeira custa R\$ ${data2.highValue}"
        }
        if (data2.cheapBeer.toString().toInt() == 3) {
            textResultado.text = "Os preços são guais R$ ${data2.finalValue}"
        }
        buttonBack.setOnClickListener(View.OnClickListener {
            val back =
                Intent(this@Resultado, MainActivity::class.java)
            startActivity(back)
            finish()
        })
    }
}