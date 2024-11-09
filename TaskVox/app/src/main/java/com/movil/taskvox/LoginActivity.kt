package com.movil.taskvox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var botonLogin: Button
    private lateinit var textRegistro: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassword)
        botonLogin = findViewById(R.id.botonLogin)
        textRegistro = findViewById(R.id.textRegistro)

        // Lógica para el botón de iniciar sesión
        botonLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            // Validar si los campos están vacíos
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica de autenticación (simulada aquí)
                val loginExitoso = autenticarUsuario(email, password)

                if (loginExitoso) {
                    // Si la autenticación es exitosa, redirigir a MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Cerrar LoginActivity
                } else {
                    // Si la autenticación falla
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Redirigir a RegisterActivity cuando el usuario haga clic en el texto
        textRegistro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    // Función simulada de autenticación
    private fun autenticarUsuario(email: String, password: String): Boolean {
        // Aquí deberías verificar las credenciales con una base de datos o API
        // Este es solo un ejemplo con credenciales simuladas
        val emailCorrecto = "usuario@ejemplo.com"
        val passwordCorrecta = "123456"

        return email == emailCorrecto && password == passwordCorrecta
    }
}
