package com.example.gardenfood

import android.app.Application
import com.example.gardenfood.data.foodList
import com.example.gardenfood.repository.FoodRepository

class FoodReviewerApplication:Application() {
    val foodRepository:FoodRepository by lazy {
        FoodRepository(foodList)
    }
}