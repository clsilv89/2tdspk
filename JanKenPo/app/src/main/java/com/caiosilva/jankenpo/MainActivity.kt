package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listOfImages = arrayListOf(R.drawable.papel, R.drawable.pedra, R.drawable.tesoura)
    private val options = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewPapel.setOnClickListener {
            println("clicou no papel")
            Toast.makeText(this, chooseWinner(0, onOptionSelected()), Toast.LENGTH_LONG).show()
        }

        binding.imageViewPedra.setOnClickListener {
            println("clicou na pedra")
            Toast.makeText(this, chooseWinner(1, onOptionSelected()), Toast.LENGTH_LONG).show()
        }

        binding.imageViewTesoura.setOnClickListener {
            println("clicou na tesoura")
            Toast.makeText(this, chooseWinner(2, onOptionSelected()), Toast.LENGTH_LONG).show()
        }
    }

    private fun onOptionSelected(): Int {
        val appChoice: Int = Random.nextInt(3)
        binding.imageViewAppChoice.setImageDrawable(getDrawable(listOfImages[appChoice]))

        return appChoice
    }

    private fun chooseWinner(playerChoice: Int, appChoice: Int): String {
        val result = listOf(
            listOf(
                getString(R.string.players_draw, options[playerChoice]),
                getString(R.string.player_wins, options[playerChoice]),
                getString(R.string.player_loses, options[playerChoice])
            ),
            listOf(
                getString(R.string.player_loses, options[playerChoice]),
                getString(R.string.players_draw, options[playerChoice]),
                getString(R.string.player_wins, options[playerChoice])
            ),
            listOf(
                getString(R.string.player_wins, options[playerChoice]),
                getString(R.string.player_loses, options[playerChoice]),
                getString(R.string.players_draw, options[playerChoice])
            )
        )

        return result[playerChoice][appChoice]
    }
}
