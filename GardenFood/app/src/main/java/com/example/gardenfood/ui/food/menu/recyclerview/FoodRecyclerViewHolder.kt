package com.example.gardenfood.ui.food.menu.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.gardenfood.data.model.FoodModel
import com.example.gardenfood.databinding.FragmentItemBinding

class FoodRecyclerViewHolder(private val binding: FragmentItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(food : FoodModel, clickListener:(FoodModel)->Unit){
        //Cargando datos en cada card
        binding.nameFoodTextView.text = food.name
        binding.priceTextView.text = food.price.toString()
        binding.descriptionFoodTextView.text = food.description

        //cargando la opcion click
        binding.foodCardView.setOnClickListener{
            clickListener(food)
        }
    }
}