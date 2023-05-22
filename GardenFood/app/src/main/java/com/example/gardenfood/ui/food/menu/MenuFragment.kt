package com.example.gardenfood.ui.food.menu

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardenfood.R
import com.example.gardenfood.data.model.FoodModel
import com.example.gardenfood.databinding.FragmentMenuBinding
import com.example.gardenfood.ui.food.menu.recyclerview.FoodRecyclerViewAdapter
import com.example.gardenfood.ui.food.menu.viewmodel.FoodViewModel

class MenuFragment : Fragment() {

    private lateinit var bindingMenuFragment: FragmentMenuBinding
    private lateinit var adapter: FoodRecyclerViewAdapter
    private val foodViewModel: FoodViewModel by activityViewModels{
        FoodViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingMenuFragment = FragmentMenuBinding.inflate(inflater,container,false)
        return bindingMenuFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        bindingMenuFragment.foodRecyclerView.setOnClickListener(){
            foodViewModel.clearData()
            it.findNavController().navigate(R.id.action_menuFragment_to_newFoodFragment)
        }
        bindingMenuFragment.newFoodButton.setOnClickListener(){
            foodViewModel.clearData()
            it.findNavController().navigate(R.id.action_menuFragment_to_newFoodFragment)
        }
    }

    private fun setRecyclerView(view:View){
        bindingMenuFragment.foodRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = FoodRecyclerViewAdapter { selectedFood -> showSelectedItem(selectedFood) }
        bindingMenuFragment.foodRecyclerView.adapter = adapter
        displayFood()
    }

    private fun showSelectedItem(food: FoodModel){
        foodViewModel.setSelectedFood(food)
        findNavController().navigate(R.id.action_menuFragment_to_foodFragment)
    }

    private fun displayFood(){
        adapter.setData(foodViewModel.getFood())
        adapter.notifyDataSetChanged()
    }
}