package com.example.myapplication

import android.content.Intent // Importo aca  la clase Intent para iniciar la otra actividad
import android.os.Bundle // Importo la  clase Bundle para manejar datos entre esta actividad y la otra
import androidx.appcompat.app.AppCompatActivity // Importo la clase AppCompatActivity para crear la actividad
import android.widget.Button // Importo la clase Button para manejar botones en la interfaz de usuario
import android.widget.TextView // Importo la clase TextView para manejar texto en la interfaz de usuario

// Clase ResultActivity que hereda de AppCompatActivity
class ResultActivity : AppCompatActivity() {
    // Método onCreate, la llamo para crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        // aca al método onCreate para realizar la incializacacion
        //esta parte la hice con un tutorial de youtube de android studio porque sin esto no pude inicializar de otra forma
        super.onCreate(savedInstanceState)
        // aca saco el diseño de la actividad a partir del archivo XML activity_result.xml
        setContentView(R.layout.activity_result)

        // aca saco el resultado pasado desde la actividad anterior utilizando el Intent
        val resultado = intent.getDoubleExtra("RESULT", 0.0)

        // aca busco el TextView en el diseño de la actividad para mostrar el resultado
        val resultTextView = findViewById<TextView>(R.id.textViewResult)
        // aca saco el texto del TextView con el resultado obtenido
        resultTextView.text = "Resultado: $resultado"

        // aca busco el botón "buttonBack" en el diseño de la actividad
        val backButton = findViewById<Button>(R.id.buttonBack)
        // aca le meto un Listener para el botón "buttonBack"
        backButton.setOnClickListener {
            // aca esta el Intent para regresar a la MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // aca se inicia la MainActivity utilizando el Intent
            startActivity(intent)
        }
    }
}
