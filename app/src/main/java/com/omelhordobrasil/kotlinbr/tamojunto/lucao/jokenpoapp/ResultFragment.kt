package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var root: View
    private lateinit var resultBinding: FragmentResultBinding
    private lateinit var engine: JokenpoEngine
    private lateinit var resultText: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultBinding = FragmentResultBinding.inflate(inflater, container, false)
        engine = JokenpoEngine(resources.getStringArray(R.array.available_plays_array))

        val currentPlay = arguments?.getString("currentPlay")
        resultText = resultBinding.txtJogadorVencedor


        currentPlay?.let {
            updateResultText(currentPlay)
        }


        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        root = resultBinding.root

        //Observador do ciclo de vida dessa Fragment
        lifecycle.addObserver(CustomObserver())
        return root
    }

    private fun updateResultText(currentPlay: String){
        val resultGame = engine.calculateResult(currentPlay)

        resultText.text = when(resultGame){
            Result.WIN -> "Você Ganhou! :)"
            Result.LOSS -> "Você Perdeu :("
            else -> "Você Empatou."
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.homeFragment ->{
                findNavController().navigate(R.id.homeFragment)
                true
            }
            else -> false
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "OnDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("LifeCycle", "OnDetach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LifeCycle", "OnAttach")
    }
}