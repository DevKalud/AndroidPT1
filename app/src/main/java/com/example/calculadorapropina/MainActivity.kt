package com.example.calculadorapropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadorapropina.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding // sirve para almacenar las variables en un solo tag de llamada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculadoraDepropina() }
    }

    fun calculadoraDepropina() {
        val valorDelcosto = binding.CostOfService.text.toString()//obtengo el dato del costo
        val cost = valorDelcosto.toDouble() // convierto el dato en tipo Double||
        val porcentaje_Propina = binding.tipOptions.checkedRadioButtonId// declaro el porcentaje de propina  seleccionado
        val porcentaje = when (porcentaje_Propina) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15

        }
        var propina = porcentaje * cost
        val activado = binding.roundUpSwitch.isChecked // asigno a una variable cuando el switch es activado
        if (activado) {
            propina = kotlin.math.ceil(propina)
        }
       val formatoPro= NumberFormat.getCurrencyInstance().format(propina)
        binding.tipResult.text=getString(R.string.cantidad_de_propina, formatoPro)// asigno el tipo de formato para que se vea en dolares


    }
}