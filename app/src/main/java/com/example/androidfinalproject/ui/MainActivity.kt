package com.example.androidfinalproject.ui

import android.annotation.SuppressLint
import android.content.Intent
import com.example.androidfinalproject.R
import kotlin.text.Typography.dagger


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.graphics.alpha
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.androidfinalproject.MainPage
import com.example.androidfinalproject.databinding.ActivityMainBinding
import com.example.androidfinalproject.ui.cocktails_search.CocktailsSearch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#000000")))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

       menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.nav_search -> {

                supportFragmentManager.beginTransaction().replace(R.id.main_activity , CocktailsSearch()).commit()

            }

            R.id.nav_fav -> {

            }

            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_activity , MainPage()).commit()
            }

       }
        return super.onOptionsItemSelected(item)
    }

}