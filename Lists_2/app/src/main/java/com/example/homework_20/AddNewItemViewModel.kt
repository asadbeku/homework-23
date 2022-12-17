package com.example.homework_20

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddNewItemViewModel : ViewModel() {
    private val repository: CarRepository = CarRepository()
    val carLiveData = MutableLiveData<List<CarsType>>(repository.list)

    val cars: LiveData<List<CarsType>>
        get() = carLiveData

    fun carListChecker(): Boolean {
        return carLiveData.value!!.isEmpty()
    }

//    fun observeViewModelState(viewModel: AddNewItemViewModel, viewL) {
//        viewModel.cars
//            .observe(viewLifecycleOwner) { newPersons -> carAdapter?.items = newPersons }
//    }

    fun addCar(car: CarsType) {
        val oldList = listOf(car) + repository.list
        val newList = listOf(car) + carLiveData.value.orEmpty()
        carLiveData.postValue(oldList)
    }

    fun deleteCar(position: Int) {
        carLiveData.postValue(
            repository.deleteItem(
                carLiveData.value.orEmpty(), position
            )
        )
    }
}