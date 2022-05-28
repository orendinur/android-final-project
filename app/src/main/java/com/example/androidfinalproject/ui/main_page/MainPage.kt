package com.example.androidfinalproject.ui.main_page

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.R
import com.example.androidfinalproject.databinding.FragmentMainPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPage : Fragment() {
    private val viewModel : MainPageViewModel by viewModels()
            private  lateinit var  adapter: MainPageAdapter

    private var _binding: FragmentMainPageBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainPageBinding.inflate(inflater,container,false)
       /* binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_mainPage_to_cocktailsSearch)
        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MainPageAdapter(this);
        binding.cocktailsRv.layoutManager =LinearLayoutManager(requireContext())

        binding.cocktailsRv.adapter = adapter
        viewModel.cocktails.observe(viewLifecycleOwner) {

            //adapter.setCocktails(it.status.data!!)
            it.status.data?.let { it1 -> adapter.setCocktails(it1) }
        }

    }

    fun onCocktailClick(idDrink: Int) {
        findNavController().navigate(R.id.action_cocktailsSearch_to_mainPage)
    }


}