package com.caiosilva.aula28fev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caiosilva.aula28fev.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {
    private lateinit var binding: FragmentSegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(inflater)

        val nomeUsuario = arguments?.getString("NOME_USUARIO").orEmpty()

        binding.buttonSegundoFragment.text = nomeUsuario

        return binding.root
    }
}