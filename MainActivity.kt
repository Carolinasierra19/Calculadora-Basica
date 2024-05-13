package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // busco los EditText y Buttons en el xml
        val number1EditText: EditText = findViewById(R.id.editTextNumber1)
        val number2EditText: EditText = findViewById(R.id.editTextNumber2)
        val sumarButton: Button = findViewById(R.id.buttonSumar)
        val restarButton: Button = findViewById(R.id.buttonRestar)
        val multiplicarButton: Button = findViewById(R.id.buttonMultiplicar)
        val dividirButton: Button = findViewById(R.id.buttonDividir)

        // armo los Listeners para los botones
        sumarButton.setOnClickListener {
            calcular("+") // llamo la función "calcular" con el operador suma
        }

        restarButton.setOnClickListener {
            calcular("-") // Llamo la función "calcular" con el operador resta
        }

        multiplicarButton.setOnClickListener {
            calcular("*") // Llamo la función "calcular" con el operador multiplicación
        }

        dividirButton.setOnClickListener {
            calcular("/") // Llamo la función "calcular" con el operador división
        }
    }

    private fun calcular(operador: String) {
        // busco los EditText para los números
        val number1EditText: EditText = findViewById(R.id.editTextNumber1)
        val number2EditText: EditText = findViewById(R.id.editTextNumber2)

        // agarro los números ingresados como texto y los convierto a Double
        val number1 = number1EditText.text.toString().toDoubleOrNull()
        val number2 = number2EditText.text.toString().toDoubleOrNull()

        // chequeo si los números son válidos
        if (number1 == null || number2 == null) {
            showToast("Por favor, ingrese números válidos")
            return
        }

        // Se hace la operación según el operador ingresado
        val resultado = when (operador) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> {
                // chequeo si se está dividiendo por cero
                if (number2 == 0.0) {
                    showToast("No se puede dividir por cero")
                    return
                }
                number1 / number2
            }
            else -> {
                showToast("Por favor, seleccione una operación")
                return
            }
        }

        // Aca cree un  Intent para iniciar la ResultActivity (la segunda actividad) y me va a traer el resultado de la operación aritmética
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT", resultado)
        startActivity(intent)// Se inicia
    }

    // Función para mostrar un mensaje en caso de ingresar un numero no valido
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
