package com.example.androidfinalproject.ui.cocktails_search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.androidfinalproject.data.models.AllCocktails
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.data.repository.CocktailRepository
import com.example.androidfinalproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CocktailsSearchViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository) : ViewModel(){

    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

    private var _name =  MutableLiveData<String>().default("")


    private val _cocktails = _name.switchMap {
        if(it == "") {
            cocktailRepository.getCocktailsByName("%" + it + "%");
        }
        else {
            cocktailRepository.getCocktailsByName("%" + it + "%",true)
        }
    }

    val cocktails : LiveData<Resource<List<Cocktail>>> = _cocktails

    fun setName(name : String) {
        _name.value = name
    }
    }
