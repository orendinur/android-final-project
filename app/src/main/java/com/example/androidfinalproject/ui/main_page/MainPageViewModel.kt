package com.example.androidfinalproject.ui.main_page

import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor( cocktailRepository: CocktailRepository) : ViewModel(){
    val allCocktails = cocktailRepository.getCocktails()
    val margaritas = cocktailRepository.getCocktailsByName("%margarita%")
    val pina = cocktailRepository.getCocktailsByName("%pina%")
    val randomCocktail = cocktailRepository.getRandomCocktails()
}