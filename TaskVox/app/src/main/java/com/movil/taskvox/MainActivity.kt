package com.movil.taskvox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar componentes
        val iconoMicrofono: ImageView = findViewById(R.id.iconoMicrofono)
        val botonGrabar: Button = findViewById(R.id.botonGrabar)
        val botonRecordatorio: Button = findViewById(R.id.botonRecordatorio)

        // Listener para el botón Grabar Tarea
        botonGrabar.setOnClickListener {
            // Abrir RecordingActivity (solo cambio de pantalla sin grabar)
            val intent = Intent(this, RecordingActivity::class.java)
            startActivity(intent)
        }

        // Listener para el botón Recordatorio (si quieres hacer lo mismo para este botón)
        botonRecordatorio.setOnClickListener {
            // Abrir RecordingActivity (si es necesario, puedes cambiar la actividad si lo deseas)
            val intent = Intent(this, RecordingActivity::class.java)
            startActivity(intent)
        }
    }
}
