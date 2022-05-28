package com.example.androidfinalproject.ui.cocktails_search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.databinding.ItemCocktailBinding

class CocktailsAdapter(private val listener: CocktailItemListener) :
    RecyclerView.Adapter<CocktailsAdapter.CocktailViewHolder>() {

    private val cocktails = ArrayList<Cocktail>()

    class CocktailViewHolder(private val itemBinding: ItemCocktailBinding,
                             private val listener: CocktailItemListener
    )
        : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var cocktail: Cocktail

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bind(item: Cocktail) {
            this.cocktail = item
            itemBinding.name.text = item.strDrink
            Glide.with(itemBinding.root)
                .load(item.strDrinkThumb)
                .into(itemBinding.image)
        }

        override fun onClick(v: View?) {
            listener.onCocktailClick(cocktail.idDrink)
        }
    }

    fun setCocktails(cocktails : Collection<Cocktail>) {
        this.cocktails.clear()
        this.cocktails.addAll(cocktails)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val binding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CocktailViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) =
        holder.bind(cocktails[position])


    override fun getItemCount() = cocktails.size

    interface CocktailItemListener {
        fun onCocktailClick(cocktailId : Int)
    }
}