package com.giuliano.calculadoracombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliano.calculadoracombustivel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            calculaPreco()
        }
    }

    fun calculaPreco() {
        val precoAlcool = binding.editTextAlcool.text.toString()
        val precoGasolina = binding.editTextGasoline.text.toString()
        if(validaCampos(precoAlcool, precoGasolina)) {
            calcularMelhorPreco(precoAlcool.toDouble(), precoGasolina.toDouble())
            }

    }

    fun calcularMelhorPreco(precoAlcool: Double, precoGasolina: Double) {
        val resultadoPreco = precoAlcool/precoGasolina
        if(resultadoPreco >= 0.7) {
            binding.resultText.text = "Melhor utilizar Gasolina"
        }else {
            binding.resultText.text = "Melhor utilizar Álcool"
        }
    }

    fun validaCampos(alcool: String, gasolina: String): Boolean {
        if(alcool.isNullOrBlank() || gasolina.isNullOrBlank()) {
            return false
        }
        return true
    }
}