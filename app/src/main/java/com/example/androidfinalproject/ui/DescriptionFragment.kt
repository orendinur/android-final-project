package com.example.androidfinalproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.androidfinalproject.R
import com.example.androidfinalproject.data.models.Cocktail
import com.example.androidfinalproject.databinding.FragmentCocktailDescriptionBinding
import com.example.androidfinalproject.databinding.FragmentCocktailsSearchBinding
import com.example.androidfinalproject.ui.cocktails_search.CocktailsSearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DescriptionFragment : Fragment() {

//  TODO: Create a viewModel
//   private val viewModel : CocktailsSearchViewModel by viewModels()

    private var _binding: FragmentCocktailDescriptionBinding? = null

    private val binding get() = _binding!!

    var strDrink = "Mojito"
    var alcoholic = "Alcoholic"
    var glass = "Glass"
    var instructions ="Take this shitty drink and shav it up in your fucking ass" +
            "Take this shitty drink and shav it up in your fucking ass" +
            "Take this shitty drink and shav it up in your fucking ass"
    var thumb ="https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg"



    private val viewModel: CocktailsSearchViewModel by activityViewModels()

    private var cocktailDescriptionInfo: Cocktail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.selectedCocktail.observe(this) {
            //TODO: Add the binding here

            cocktailDescriptionInfo = it
        }
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

        binding.cokctailName.text = strDrink
        binding.isAlcoholic.text = alcoholic
        binding.glass.text = glass
        Glide.with(this).load(thumb).into(binding.coktailImage)

        binding.instructions.text = instructions


        Toast.makeText(requireContext(), "${cocktailDescriptionInfo?.strDrink}", Toast.LENGTH_LONG).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//TODO:
// create a viewModel
// add fragment to navigation
// fill fragment with viewModel
