package com.caiosilva.aula28fev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        Toast.makeText(
            activity,
            arguments?.getString("NomeDoUsuario").orEmpty(),
            Toast.LENGTH_SHORT
        ).show()
        return binding.root
    }
}