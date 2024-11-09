package com.movil.taskvox

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var layoutCambiarIdioma: LinearLayout
    private lateinit var contenidoCambiarIdioma: LinearLayout
    private lateinit var layoutAjustarTema: LinearLayout
    private lateinit var contenidoAjustarTema: LinearLayout
    private lateinit var layoutNotificaciones: LinearLayout
    private lateinit var contenidoNotificaciones: LinearLayout
    private lateinit var layoutRestaurarConfiguraciones: LinearLayout
    private lateinit var contenidoRestaurarConfiguraciones: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Inicializar layouts
        layoutCambiarIdioma = findViewById(R.id.layoutCambiarIdioma)
        contenidoCambiarIdioma = findViewById(R.id.contenidoCambiarIdioma)
        layoutAjustarTema = findViewById(R.id.layoutAjustarTema)
        contenidoAjustarTema = findViewById(R.id.contenidoAjustarTema)
        layoutNotificaciones = findViewById(R.id.layoutNotificaciones)
        contenidoNotificaciones = findViewById(R.id.contenidoNotificaciones)
        layoutRestaurarConfiguraciones = findViewById(R.id.layoutRestaurarConfiguraciones)
        contenidoRestaurarConfiguraciones = findViewById(R.id.contenidoRestaurarConfiguraciones)

        // Configurar listeners de clic para los encabezados
        layoutCambiarIdioma.setOnClickListener { toggleVisibility(contenidoCambiarIdioma) }
        layoutAjustarTema.setOnClickListener { toggleVisibility(contenidoAjustarTema) }
        layoutNotificaciones.setOnClickListener { toggleVisibility(contenidoNotificaciones) }
        layoutRestaurarConfiguraciones.setOnClickListener { toggleVisibility(contenidoRestaurarConfiguraciones) }
    }

    private fun toggleVisibility(content: LinearLayout) {
        if (content.visibility == View.VISIBLE) {
            content.visibility = View.GONE
        } else {
            content.visibility = View.VISIBLE
        }
    }
}
