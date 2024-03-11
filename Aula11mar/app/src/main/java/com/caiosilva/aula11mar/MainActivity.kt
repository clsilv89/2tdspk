package com.caiosilva.aula11mar

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.aula11mar.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private var arrayList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirLista()
        exibirSpinner()
    }

    private fun exibirSpinner() {
        val lista: ArrayList<String> =
            arrayListOf(
                "Cachorro",
                "Papagaio",
                "Gato",
                "Rato",
                "Iguana",
                "Tartaruga",
                "Coelho",
                "Peixe-Beta",
                "Galinha"
            )
        for (i in 0..1000000) {
            lista.add(lista[i].toString())
        }
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            lista
        )

        binding.spinnerTextList.adapter = adapter
        binding.spinnerTextList.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (arrayList.contains(lista[position])) {
                        arrayList.remove(lista[position])
                    } else {
                        arrayList.add(lista[position])
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    private fun exibirLista() {
        val lista: List<String> = listOf(
            "Cachorro",
            "Papagaio",
            "Gato",
            "Rato",
            "Iguana",
            "Tartaruga",
            "Coelho",
            "Peixe-Beta",
            "Galinha"
        )
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayList
        )

        binding.listViewTextList.adapter = adapter
        binding.listViewTextList.setOnItemClickListener { parent, view, position, id ->
            if (arrayList.contains(lista[position])) {
                arrayList.remove(lista[position])
            } else {
                arrayList.add(lista[position])
            }
        }
    }
}
