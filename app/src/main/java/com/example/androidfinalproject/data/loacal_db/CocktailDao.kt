package com.example.androidfinalproject.data.loacal_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidfinalproject.data.models.Cocktail

@Dao
interface CocktailDao {
    
    @Query("SELECT * FROM cocktails")
    fun  getAllCocktails() : LiveData<List<Cocktail>>
    
    @Query("SELECT * FROM cocktails WHERE idDrink = :id")
    fun getCocktail(id : Int) : LiveData<Cocktail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktail(cocktail: Cocktail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktails(cocktails : List<Cocktail>)
    
}