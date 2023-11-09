package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.FragmentPlayerBinding


class PlayerFragment : Fragment() {
    private lateinit var root: View
    private lateinit var playerBinding: FragmentPlayerBinding
    private lateinit var selectPlay: Spinner
    private lateinit var onItemSelectedListener: OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onItemSelectedListener = context as OnItemSelectedListener

        Log.d("LifeCycle", "OnAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        playerBinding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = playerBinding.root
        selectPlay = playerBinding.spinner

        setHasOptionsMenu(true)
        setupSelectPlaySpinner()
        lifecycle.addObserver(CustomObserver())
        return root
    }

    private fun setupSelectPlaySpinner() {
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.available_plays_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        selectPlay.adapter = adapter
        selectPlay.onItemSelectedListener = onItemSelectedListener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.homeFragment -> {
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
}
