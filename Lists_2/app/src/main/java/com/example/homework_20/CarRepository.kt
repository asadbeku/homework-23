package com.example.homework_20

class CarRepository {

    var list = mutableListOf<CarsType>(
        CarsType.Electra(
            1,
            "Tesla model x",
            "https://cdn.pixabay.com/photo/2021/01/21/11/09/tesla-5937063_960_720.jpg",
            "223 km/h",
            "2 hour 30 min",
            "97%"
        ),
        CarsType.Petrol(
            2,
            "Bugatti veyron",
            "https://cdn.pixabay.com/photo/2020/11/25/06/59/car-5774774_960_720.jpg",
            "350 km/h",
            "Have",
            "45 l"
        ),
        CarsType.Hybrid(
            3,
            "BMW i8",
            "https://cdn.pixabay.com/photo/2018/01/25/18/37/car-3106817_960_720.jpg",
            "215 km/h",
            "Petrol & Elector",
            "Have"
        )
    )

    fun deleteItem(cars: List<CarsType>, position: Int): List<CarsType> {
        return cars.filterIndexed { index, _ -> index != position }
    }

}