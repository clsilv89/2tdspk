package com.caiosilva.aula28fev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.caiosilva.aula28fev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirFragments()
    }

    private fun exibirFragments() {
        val primeiroFragment = PrimeiroFragment.newInstance(
            "Caio", "Silva"
        )

        val args = bundleOf("NomeDoUsuario" to "Caio")

        val segundoFragment = SegundoFragment()
        segundoFragment.arguments = args

        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayoutPrimeiroFragment.id, primeiroFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayoutSegundoFragment.id, segundoFragment)
            .commit()
    }
}
