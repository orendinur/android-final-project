package com.example.androidfinalproject.ui.favorites

import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(cocktailRepository: CocktailRepository) : ViewModel(){
    val favoriteCocktails = cocktailRepository.getFavoriteCocktails()
}