package com.example.androidfinalproject.ui.cocktails_search

import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CocktailsSearchViewModel @Inject constructor(
    cocktailRepository: CocktailRepository) : ViewModel(){
        val cocktails = cocktailRepository.getCocktails()
    }
