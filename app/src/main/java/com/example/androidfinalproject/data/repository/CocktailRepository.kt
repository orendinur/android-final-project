package com.example.androidfinalproject.data.repository

import com.example.androidfinalproject.data.loacal_db.CocktailDao
import com.example.androidfinalproject.data.remote_db.CocktailRemoteDataSource
import com.example.androidfinalproject.utils.performFetching
import com.example.androidfinalproject.utils.performFetchingAndSaving
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepository @Inject constructor (
    private val remoteDataSource : CocktailRemoteDataSource,
    private val localDataSource : CocktailDao
    ){

    fun getCocktails() = performFetchingAndSaving(
        {localDataSource.getAllCocktails()},
        {remoteDataSource.getCocktails()},
        {localDataSource.insertCocktails(it.drinks)}
    )

    fun getCocktail(id : Int) = performFetchingAndSaving(
        {localDataSource.getCocktail(id)},
        {remoteDataSource.getCocktail(id)},
        {localDataSource.insertCocktail(it)}
    )

    fun getCocktailsByName(name : String) = performFetchingAndSaving(
                { localDataSource.getCocktailsByName(name) },
                { remoteDataSource.getCocktailsByName(name) },
                { localDataSource.insertCocktails(it.drinks) }
            )

    fun getCocktailsByName(name: String, flag: Boolean) = performFetching(
                { localDataSource.getCocktailsByName(name) },
                { remoteDataSource.getCocktailsByName(name) }
            )
    }
