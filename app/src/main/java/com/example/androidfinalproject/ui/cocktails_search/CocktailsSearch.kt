package com.example.androidfinalproject.ui.cocktails_search

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidfinalproject.R
import com.example.androidfinalproject.data.repository.CocktailRepository
import com.example.androidfinalproject.databinding.FragmentCocktailsSearchBinding
import com.example.androidfinalproject.utils.Loading
import com.example.androidfinalproject.utils.Success
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailsSearch : Fragment(), CocktailsAdapter.CocktailItemListener {

    private val viewModel : CocktailsSearchViewModel by viewModels()

    private var _binding: FragmentCocktailsSearchBinding? = null

    private val binding get() = _binding!!

    private  lateinit var  adapter: CocktailsAdapter

    private lateinit var cocktailRepository: CocktailRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailsSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CocktailsAdapter(this)
        binding.cocktailsRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.cocktailsRv.adapter = adapter

        viewModel.cocktails.observe(viewLifecycleOwner) {
            Log.i("fff","fffffffffff")
            when (it.status) {
                is Loading -> binding.progressBar.visibility = View.VISIBLE

                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setCocktails(it.status.data!!)
                }

                is Error -> {
                    Log.i("e","booommmm")
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.status.message, Toast.LENGTH_LONG).show()
                }
            }
            if (adapter.itemCount == 0 && it.status !is Loading) {
                Toast.makeText(requireContext(), "No results", Toast.LENGTH_SHORT).show()
            }
        }
        binding.search.doAfterTextChanged {
      //      viewModel.cocktails = cocktailRepository.getCocktailsByName("%" + binding.search.text.toString() + "%")
            viewModel.setName(binding.search.text.toString())
            Log.i("YYYYYYYYYYYYY", binding.search.text.toString())

        }
    }

    override fun onCocktailClick(cocktailId: Int) {
        findNavController().navigate(R.id.action_cocktailsSearch_to_mainPage)
    }

}