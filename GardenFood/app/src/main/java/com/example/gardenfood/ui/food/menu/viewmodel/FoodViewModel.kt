package com.example.gardenfood.ui.food.menu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.example.gardenfood.FoodReviewerApplication
import com.example.gardenfood.R
import com.example.gardenfood.data.model.FoodModel
import com.example.gardenfood.repository.FoodRepository
import com.example.gardenfood.ui.food.NewFoodFragment

class FoodViewModel(private val repository: FoodRepository): ViewModel() {
    var name  = MutableLiveData("")
    var price = MutableLiveData("")
    var description = MutableLiveData("")
    var status = MutableLiveData("")

    fun getFood()= repository.getFood()
    fun addFood(food:FoodModel) = repository.addFood(food)

    private fun validarData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            price.value.isNullOrEmpty()->return false
            description.value.isNullOrEmpty()->return false
        }
        return true
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as FoodReviewerApplication
                FoodViewModel(app.foodRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
    fun clearData(){
        name.value = ""
        description.value = ""
        price.value = ""
    }

    //CREAR UNA UNA PELICULA
    fun createFood(){
        if(!validarData()){
            status.value = WRONG_DATA
            return
        }
        val newMovie = FoodModel(
            name.value.toString(),
            description.value.toString(),
            price.value.toString().toDouble()
        )
        addFood(newMovie)
        status.value = MOVIE_CREATED

    }
    ///////////////////////////////////////////////
    fun setSelectedFood(food:FoodModel){
        name.value = food.name
        price.value = food.price.toString()
        description.value = food.description
    }
}