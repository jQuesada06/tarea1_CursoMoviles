package com.example.practica1_clase_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var operador: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinnerExample()
    }

    /*fun suma(view: View){
        val et1:EditText = findViewById(R.id.et1);
        val et2:EditText = findViewById(R.id.et2);
        val tvresult:TextView = findViewById(R.id.textViewresult);
        val rSuma:RadioButton = findViewById(R.id.rbSuma);

        var val1 = et1.text.toString().toInt();
        var val2 = et2.text.toString().toInt();

        var resultado = if (rSuma.isChecked)
            val1 + val2
        else
            val1 - val2

        tvresult.text = resultado.toString();
    }*/

    private fun spinnerExample(){
        val elementos = resources.getStringArray(R.array.operaciones)

        val spinner: Spinner = findViewById(R.id.spinner)

        // Crea un ArrayAdapter usando los elementos y el diseño predeterminado para el spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, elementos)

        // Especifica el diseño que se usará cuando se desplieguen las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Une el ArrayAdapter al Spinner
        spinner.adapter = adapter

        // Opcionalmente, puedes configurar un escuchador para detectar la selección del usuario
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSeleccionado = elementos[position]


                operador = itemSeleccionado

                // Realiza alguna acción con el elemento seleccionado
                Toast.makeText(this@MainActivity, "Seleccionaste: $itemSeleccionado", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Se llama cuando no se ha seleccionado nada en el Spinner (opcional)

                Toast.makeText(this@MainActivity, "Nada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun calcular(view: View) {

        val et1:EditText = findViewById(R.id.et1);
        val et2:EditText = findViewById(R.id.et2);
        val tvresult:TextView = findViewById(R.id.textViewresult);
        var val1 = et1.text.toString().toInt();
        var val2 = et2.text.toString().toInt();


        val resultado = operar(val1,val2,operador)

        tvresult.text = resultado.toString()
    }

    private fun operar(val1: Int, val2: Int, operador: String): Int{
        val resultado =  when (operador) {
            "Suma" -> val1 + val2
            "Resta" -> val1 - val2
            "Multiplicacion" -> val1 * val2
            else -> val1 / val2
        }
        return resultado
    }
}