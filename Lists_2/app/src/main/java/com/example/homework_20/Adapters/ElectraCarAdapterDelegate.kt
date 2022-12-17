package com.example.homework_20.Adapters

import android.view.View
import android.view.ViewGroup
import com.example.homework_20.CarsType
import com.example.homework_20.R
import com.example.homework_20.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ElectraCarAdapterDelegate(private val onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<CarsType.Electra, CarsType, ElectraCarAdapterDelegate.ElectraHolder>() {

    override fun isForViewType(
        item: CarsType,
        items: MutableList<CarsType>,
        position: Int
    ): Boolean {
        return item is CarsType.Electra
    }

    override fun onCreateViewHolder(parent: ViewGroup): ElectraHolder {
        return ElectraHolder(
            parent.inflate(R.layout.item_electra), onItemClicked
        )
    }

    override fun onBindViewHolder(
        item: CarsType.Electra,
        holder: ElectraHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class ElectraHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit
    ) : BaseCarHolder(view, onItemClicked, view) {

        fun bind(car: CarsType.Electra) {
            bindElectra(car.nameCar, car.imageCar, car.maxSpeedCar, car.chargingTime, car.batteryCapability)
        }

    }
}