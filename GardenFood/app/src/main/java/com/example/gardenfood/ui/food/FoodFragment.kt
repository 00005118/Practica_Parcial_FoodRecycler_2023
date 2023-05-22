package com.example.gardenfood.ui.food

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.gardenfood.R
import com.example.gardenfood.databinding.FragmentFoodBinding
import com.example.gardenfood.ui.food.menu.viewmodel.FoodViewModel
import java.util.zip.Inflater


class FoodFragment : Fragment() {

    private lateinit var bindingFoodFragment: FragmentFoodBinding
    private val viewModel: FoodViewModel by activityViewModels {
        FoodViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFoodFragment = DataBindingUtil.inflate(inflater,R.layout.fragment_food,container,false)
        return bindingFoodFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFoodFragment.viewmodel = viewModel
    }
}