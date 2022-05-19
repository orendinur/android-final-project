package com.example.androidfinalproject.ui.cocktails_search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CocktailsSearchViewModel @Inject constructor(
    cocktailRepository: CocktailRepository
) : ViewModel() {
    val cocktails = cocktailRepository.getCocktails()

//    private val mutableSelectedCocktail = MutableLiveData<Cocktail>()
//    val selectedCocktail: LiveData<Cocktail> get() = mutableSelectedCocktail
    var selectedCocktail = MutableLiveData<Cocktail>()

    fun selectCocktail(cocktail: Cocktail) {
//        mutableSelectedCocktail.value = cocktail
        selectedCocktail.value = cocktail
    }

}
