package com.example.homework_20.Adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_20.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_electra.*
import kotlinx.android.synthetic.main.item_hybrid.*
import kotlinx.android.synthetic.main.item_petrol.*

abstract class BaseCarHolder(
    view: View,
    onItemClick: (position: Int) -> Unit,
    override val containerView: View?
) : RecyclerView.ViewHolder(view), LayoutContainer {

    init {
        view.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bindElectra(nameCar: String,imageCar: String,maxSpeedCar: String,batteryCapability: String,chargingTime: String) {
        electraCarName.text = nameCar
        electraMaxSpeed.text = maxSpeedCar
        electraFirstProperty.text = batteryCapability
        electraSecondProperty.text = chargingTime

        Glide.with(itemView)
            .load(imageCar)
            .placeholder(R.drawable.ic_baseline_directions_car_24)
            .into(electraCarImageView)
    }

    fun bindPetrol(
        nameCar: String,
        imageCar: String,
        maxSpeedCar: String,
        firstProperty: String,
        secondProperty: String
    ) {
        petrolCarName.text = nameCar
        petrolMaxSpeed.text = maxSpeedCar
        petrolFirstProperty.text = firstProperty
        petrolSecondProperty.text = secondProperty

        Glide.with(itemView)
            .load(imageCar)
            .placeholder(R.drawable.ic_baseline_directions_car_24)
            .into(petrolCarImageView)
    }

    fun bindHybrid(
        nameCar: String,
        imageCar: String,
        maxSpeedCar: String,
        typesFuel: String,
        powerController: String
    ) {
        hybridCarName.text = nameCar
        hybridMaxSpeed.text = maxSpeedCar
        hybridFirstProperty.text = typesFuel
        hybridSecondProperty.text = powerController

        Glide.with(itemView)
            .load(imageCar)
            .placeholder(R.drawable.ic_baseline_directions_car_24)
            .into(hybridCarImageView)
    }
}