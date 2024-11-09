package com.movil.taskvox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Configurar márgenes para ajuste de barras de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener vistas de los campos de entrada
        val inputNombre: EditText = findViewById(R.id.inputNombre)
        val inputEmail: EditText = findViewById(R.id.inputEmail)
        val inputPassword: EditText = findViewById(R.id.inputPassword)

        // Obtener el botón de registro
        val botonRegistro: Button = findViewById(R.id.botonRegistro)

        // Obtener el TextView de Login
        val textLogin: TextView = findViewById(R.id.textLogin)

        // Configurar el botón de registro
        botonRegistro.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val correo = inputEmail.text.toString()
            val contrasena = inputPassword.text.toString()

            // Validaciones básicas
            if (nombre.isBlank() || correo.isBlank() || contrasena.isBlank()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (!correo.contains("@")) {
                Toast.makeText(this, "Por favor, ingresa un correo válido", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica de registro (simulada aquí, deberías integrarlo con tu base de datos o API)
                val registroExitoso = registrarUsuario(nombre, correo, contrasena)

                if (registroExitoso) {
                    // Si el registro es exitoso, redirigir a LoginActivity
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Cerrar RegisterActivity
                } else {
                    // Mostrar mensaje si el registro falla
                    Toast.makeText(this, "Error en el registro, intenta nuevamente", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Configurar el TextView para redirigir a LoginActivity
        textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    // Función simulada para registrar al usuario
    private fun registrarUsuario(nombre: String, correo: String, contrasena: String): Boolean {
        // Aquí iría la lógica para guardar los datos del usuario en una base de datos o realizar validaciones
        // En este ejemplo, solo simulamos un registro exitoso
        return true
    }
}
