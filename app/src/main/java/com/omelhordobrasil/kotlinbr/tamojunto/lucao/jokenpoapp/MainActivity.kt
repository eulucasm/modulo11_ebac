package com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.omelhordobrasil.kotlinbr.tamojunto.lucao.jokenpoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var navDrawer: NavigationView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var editText: EditText
    private var currentPlay: String = "Pedra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val toolbarMain = bindingMain.toolbar

//        Log.d("Lifecycle", "onCreate")

        setContentView(bindingMain.root)
        setSupportActionBar(toolbarMain)



        drawer = bindingMain.root
        navDrawer = bindingMain.navView
        bottomNav = bindingMain.bottomNav
        editText = bindingMain.editText

        savedInstanceState?.getString("editTextValue")?.let {
            editText.setText(it)
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment

        navController = navHostFragment.navController


        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.playerFragment, R.id.resultFragment), drawer)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }

        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        navDrawer.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.resultFragment -> {
                    val args = Bundle()
                    args.putString("currentPlay", currentPlay)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }

        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment -> {
                    val args = Bundle()
                    args.putString("currentPlay", currentPlay)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextValue", editText.text.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val plays = resources.getStringArray(R.array.available_plays_array)
        currentPlay = plays[position]

        Toast.makeText(this, "Jogada Selecionada: ${currentPlay.toString()}", Toast.LENGTH_SHORT)
            .show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }
}