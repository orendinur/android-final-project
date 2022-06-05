package com.example.androidfinalproject.ui.description_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DescriptionCocktailViewModel @Inject constructor(
    val cocktailRepository: CocktailRepository): ViewModel() {

    private val mutableSelectedCocktail = MutableLiveData<Cocktail>()
    val selectedCocktail: LiveData<Cocktail> get() = mutableSelectedCocktail

    fun selectCocktail(cocktail: Cocktail) {
        mutableSelectedCocktail.value = cocktail
    }
}