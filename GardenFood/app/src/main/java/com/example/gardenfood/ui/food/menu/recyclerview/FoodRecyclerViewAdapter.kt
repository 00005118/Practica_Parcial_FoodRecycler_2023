package com.example.gardenfood.ui.food.menu.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gardenfood.data.model.FoodModel
import com.example.gardenfood.databinding.FragmentItemBinding

class FoodRecyclerViewAdapter(private val clickListener: (FoodModel)->Unit):RecyclerView.Adapter<FoodRecyclerViewHolder>() {
    private val foods = ArrayList<FoodModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRecyclerViewHolder {
         val binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: FoodRecyclerViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food,clickListener)
    }
    fun setData(foodList: List<FoodModel>){
        foods.clear()
        foods.addAll(foodList)
    }
}