package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.startActivityButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav2()
            findNavController().navigate(action)
        }

        return binding.root
    }

}