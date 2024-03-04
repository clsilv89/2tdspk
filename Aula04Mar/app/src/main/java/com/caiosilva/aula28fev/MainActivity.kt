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

        showFragments()
    }

    private fun showFragments() {
//        val primeiroFragment = PrimeiroFragment()
        val primeiroFragment = PrimeiroFragment.newInstance("Caio", "Silva")
        val segundoFragment = SegundoFragment()
        // val list = listOf("cachorro", "gato", "papagaio")

        val bundle = bundleOf("NOME_USUARIO" to "Caio")
        segundoFragment.arguments = bundle

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
