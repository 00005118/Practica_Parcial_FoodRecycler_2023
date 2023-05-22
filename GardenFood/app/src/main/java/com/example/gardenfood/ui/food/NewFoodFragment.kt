package com.example.gardenfood.ui.food

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gardenfood.R
import com.example.gardenfood.databinding.FragmentNewFoodBinding
import com.example.gardenfood.ui.food.menu.viewmodel.FoodViewModel


class NewFoodFragment : Fragment() {

    private lateinit var newFoodbinding: FragmentNewFoodBinding
    private val viewModel: FoodViewModel by activityViewModels{
        FoodViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        newFoodbinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_food,container,false)
        return newFoodbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }
    private fun setViewModel(){
        newFoodbinding.viewmodel = viewModel
    }

    private fun observerStatus (){
        viewModel.status.observe(viewLifecycleOwner){ status ->
            when{
                status.equals(FoodViewModel.MOVIE_CREATED)->{
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", viewModel.getFood().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()
                    findNavController().popBackStack()
                }
                status.equals(FoodViewModel.WRONG_DATA)->{
                    Log.d("APP TAG",status)
                    viewModel.clearStatus()
                }
            }

        }
    }
}