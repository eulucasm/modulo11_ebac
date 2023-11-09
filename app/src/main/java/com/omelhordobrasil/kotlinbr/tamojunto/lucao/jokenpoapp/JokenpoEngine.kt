package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import kotlin.random.Random

enum class Result {
    WIN, DRAWN, LOSS
}

class JokenpoEngine(val availablePlays: Array<String>) {

    fun calculateResult(playerPlay: String): Result {
        val aiPlay = getAIPlay()

        return when {
            playerPlay == aiPlay -> Result.DRAWN
            playerPlay == "Pedra" && aiPlay == "Tesoura" -> Result.WIN
            playerPlay == "Papel" && aiPlay == "Pedra" -> Result.WIN
            playerPlay == "Tesoura" && aiPlay == "Papel" -> Result.WIN
            else -> Result.LOSS
        }
    }

    private fun getAIPlay(): String {
        val playIndex = Random.nextInt(0, 2)
        return availablePlays[playIndex]
    }
}