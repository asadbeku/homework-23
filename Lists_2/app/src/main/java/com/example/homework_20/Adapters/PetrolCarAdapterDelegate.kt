package com.example.homework_20.Adapters

import android.view.View
import android.view.ViewGroup
import com.example.homework_20.CarsType
import com.example.homework_20.R
import com.example.homework_20.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class PetrolCarAdapterDelegate(private val onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<CarsType.Petrol, CarsType, PetrolCarAdapterDelegate.PetrolHolder>() {

    override fun isForViewType(
        item: CarsType,
        items: MutableList<CarsType>,
        position: Int
    ): Boolean {
        return item is CarsType.Petrol
    }

    override fun onCreateViewHolder(parent: ViewGroup): PetrolHolder {
        return PetrolHolder(
            parent.inflate(R.layout.item_petrol), onItemClicked
        )
    }

    override fun onBindViewHolder(
        item: CarsType.Petrol,
        holder: PetrolHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class PetrolHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit
    ) : BaseCarHolder(view, onItemClicked, view) {

        fun bind(car: CarsType.Petrol) {
            bindPetrol(car.nameCar, car.imageCar, car.maxSpeedCar, car.fuelTankVolume, car.fuelFilteringSystem)
        }

    }
}