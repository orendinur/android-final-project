package com.example.androidfinalproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.databinding.FragmentCocktailDescriptionBinding
import com.example.androidfinalproject.ui.cocktails_search.CocktailsSearchViewModel

class DescriptionFragment : Fragment() {

    private var _binding: FragmentCocktailDescriptionBinding? = null

    private val binding get() = _binding!!

    private val viewModel: CocktailsSearchViewModel by activityViewModels()

    private var cocktailDescription: Cocktail? = null
    set(value) {
        binding.cokctailName.text = value?.strDrink
        binding.isAlcoholic.text = value?.strAlcoholic
        Glide.with(this).load(value?.strDrinkThumb).into(binding.coktailImage)
        if(value?.strInstructions != null) binding.instructions.text = value?.strInstructions else binding.bottomInstructionsLayout.visibility = View.INVISIBLE


    var ingridientsStr = value?.strIngredient1 + "\n" +
            value?.strIngredient2 + "\n" +
            value?.strIngredient3 + "\n" +
     value?.strIngredient4 + "\n"+
     value?.strIngredient5 + "\n"+
     value?.strIngredient6 + "\n"+
     value?.strIngredient7 + "\n"+
     value?.strIngredient8 + "\n"+
     value?.strIngredient9 + "\n"+
     value?.strIngredient10 + "\n"+
     value?.strIngredient11 + "\n"+
     value?.strIngredient12 + "\n"+
     value?.strIngredient13 + "\n"+
     value?.strIngredient14 + "\n"+
     value?.strIngredient15 + "\n"

   var drinkMeasureStr = viewModel.selectedCocktail.value?.strMeasure1 + "\n" +
     value?.strMeasure2 + "\n"+
     value?.strMeasure3 + "\n"+
     value?.strMeasure4 + "\n"+
     value?.strMeasure5 + "\n"+
     value?.strMeasure6 + "\n"+
     value?.strMeasure7 + "\n"+
     value?.strMeasure8 + "\n"+
     value?.strMeasure9 + "\n"+
     value?.strMeasure10 + "\n"+
     value?.strMeasure11 + "\n"+
     value?.strMeasure12 + "\n"+
     value?.strMeasure13 + "\n"+
     value?.strMeasure14 + "\n"+
     value?.strMeasure15 + "\n"

    binding.ingridients.text = ingridientsStr.replace("null", "")
    binding.measures.text = drinkMeasureStr.replace("null", "")
        field = value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCocktailDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedCocktail.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "observer triggered ${viewModel.selectedCocktail.value?.strDrink}", Toast.LENGTH_LONG).show()
            cocktailDescription = it
        }
        Toast.makeText(requireContext(), "${cocktailDescription?.strDrink}", Toast.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
