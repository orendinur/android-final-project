package com.example.androidfinalproject.ui.cocktails_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidfinalproject.R
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
            when(it.status) {
                is Loading -> binding.progressBar.visibility = View.VISIBLE

                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setCocktails(it.status.data!!)
                }

                is Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),it.status.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCocktailClick(cocktailId: Int) {
        findNavController().navigate(R.id.action_cocktailsSearch_to_mainPage)
    }



}