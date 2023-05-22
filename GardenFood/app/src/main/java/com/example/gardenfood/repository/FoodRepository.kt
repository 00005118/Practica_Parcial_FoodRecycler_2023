package com.example.gardenfood.repository

import com.example.gardenfood.data.model.FoodModel

class FoodRepository(private val foodRepository: MutableList<FoodModel>) {

    fun getFood()=foodRepository
    fun addFood(newFood: FoodModel) = foodRepository.add(newFood)

}