package com.example.androidfinalproject.ui.main_page

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfinalproject.R
import com.example.androidfinalproject.databinding.FragmentMainPageBinding
import com.example.androidfinalproject.utils.Success
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainPage : Fragment() {
    private val viewModel: MainPageViewModel by viewModels()

    private var _binding: FragmentMainPageBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: MainPageAdapter

    /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        /*binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_mainPage_to_cocktailsSearch)
        }*/
        binding.root.setBackgroundColor((Color.parseColor("#000000")))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MainPageAdapter(this)
        binding.cocktailsRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.cocktailsRv.adapter = adapter
        viewModel.cocktails.observe(viewLifecycleOwner) {

            when (it.status) {
                is Success -> {
                    adapter.setCocktails(it.status.data!!)
                }
            }

        }
    }

        fun onCocktailClick(idDrink: Int) {
            // findNavController().navigate(R.id.action_cocktailsSearch_to_mainPage)
        }



}