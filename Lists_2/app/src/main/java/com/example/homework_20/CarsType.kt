package com.example.homework_20

sealed class CarsType {
    data class Electra(
        val id: Long,
        val nameCar: String,
        val imageCar: String,
        val maxSpeedCar: String,
        val chargingTime: String,
        val batteryCapability: String
    ) : CarsType()

    data class Petrol(
        val id: Long,
        val nameCar: String,
        val imageCar: String,
        val maxSpeedCar: String,
        val fuelFilteringSystem: String,
        val fuelTankVolume: String
    ) : CarsType()

    data class Hybrid(
        val id: Long,
        val nameCar: String,
        val imageCar: String,
        val maxSpeedCar: String,
        val typesFuel: String,
        val powerController: String
    ) : CarsType()
}
