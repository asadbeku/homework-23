package com.example.homework_20.Adapters

import android.view.View
import android.view.ViewGroup
import com.example.homework_20.CarsType
import com.example.homework_20.R
import com.example.homework_20.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HybridCarAdapterDelegate(private val onItemClicked: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<CarsType.Hybrid, CarsType, HybridCarAdapterDelegate.HybridHolder>() {

    override fun isForViewType(
        item: CarsType,
        items: MutableList<CarsType>,
        position: Int
    ): Boolean {
        return item is CarsType.Hybrid
    }

    override fun onCreateViewHolder(parent: ViewGroup): HybridHolder {
        return HybridHolder(
            parent.inflate(R.layout.item_hybrid), onItemClicked
        )
    }

    override fun onBindViewHolder(
        item: CarsType.Hybrid,
        holder: HybridHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class HybridHolder(
        view: View,
        onItemClicked: (position: Int) -> Unit
    ) : BaseCarHolder(view, onItemClicked, view) {

        fun bind(car: CarsType.Hybrid) {
            bindHybrid(car.nameCar, car.imageCar, car.maxSpeedCar, car.typesFuel, car.powerController)
        }

    }
}