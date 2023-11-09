package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingHome = FragmentHomeBinding.inflate(inflater, container, false)
        editText = bindingHome.editText

        if(savedInstanceState?.containsKey("editTextValue") == true){
            val value = savedInstanceState.getString("editTextValue")
            editText.setText(value)
        }

        bindingHome.buttonstart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }

        lifecycle.addObserver(CustomObserver())
        return bindingHome.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "OnCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextValue", editText.text.toString())
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