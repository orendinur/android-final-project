package com.example.androidfinalproject.data.loacal_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidfinalproject.data.models.Cocktail

@Database(entities = [Cocktail::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cocktailDao() : CocktailDao

    companion object {

        @Volatile
        private var instance : AppDatabase?  = null

        fun getDatabase(context: Context) : AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"cocktails")
                    .fallbackToDestructiveMigration().build().also {
                        instance = it
                    }
            }
    }
}