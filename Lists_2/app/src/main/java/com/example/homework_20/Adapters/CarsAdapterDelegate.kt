package com.example.homework_20.Adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.homework_20.CarsType
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CarsAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<CarsType>(CarDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(   ElectraCarAdapterDelegate(onItemClicked))
            .addDelegate(PetrolCarAdapterDelegate(onItemClicked))
            .addDelegate(HybridCarAdapterDelegate(onItemClicked))
    }

    fun update(list: MutableList<CarsType>){
        items = list
    }

    class CarDiffUtilCallback : DiffUtil.ItemCallback<CarsType>() {
        override fun areItemsTheSame(oldItem: CarsType, newItem: CarsType): Boolean {
            return when {
                oldItem is CarsType.Electra && newItem is CarsType.Electra -> oldItem.id == newItem.id
                oldItem is CarsType.Petrol && newItem is CarsType.Petrol -> oldItem.id == newItem.id
                oldItem is CarsType.Hybrid && newItem is CarsType.Hybrid -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: CarsType, newItem: CarsType): Boolean {
            return when {
                oldItem is CarsType.Electra && newItem is CarsType.Electra -> oldItem == newItem
                oldItem is CarsType.Petrol && newItem is CarsType.Petrol -> oldItem == newItem
                oldItem is CarsType.Hybrid && newItem is CarsType.Hybrid -> oldItem == newItem
                else -> false
            }
        }

    }
}