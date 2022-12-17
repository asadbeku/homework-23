package com.example.homework_20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.homework_20.Adapters.CarsAdapterDelegate
import kotlin.random.Random

class AddItemDialog(
    private var carAdapter: CarsAdapterDelegate?,
    private var emptyTextView: TextView
) : androidx.fragment.app.DialogFragment() {

    private var repository: CarRepository = CarRepository()
    private val viewModel: AddNewItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var rootView: View = inflater.inflate(R.layout.dialog_add, container, false)
        val addButton = rootView.findViewById<Button>(R.id.addItemButton)
        val cancelButton = rootView.findViewById<Button>(R.id.cancelItemButton)
        val nameAuto = rootView.findViewById<EditText>(R.id.nameCarEditTex)
        val carImageView = rootView.findViewById<EditText>(R.id.imageCarImageView)
        val maxSpeed = rootView.findViewById<EditText>(R.id.maxSpeedEditTex)
        val firstProperty = rootView.findViewById<EditText>(R.id.chargingTimeEditTex)
        val secondProperty = rootView.findViewById<EditText>(R.id.batteryCapabilityEditText)
        val electricRadioButton = rootView.findViewById<RadioButton>(R.id.electraRadioButton)
        val petrolRadioButton = rootView.findViewById<RadioButton>(R.id.petrolRadioButton)
        val hybridRadioButton = rootView.findViewById<RadioButton>(R.id.hybridRadioButton)



        firstProperty.hint = "Charging time"
        secondProperty.hint = "Battery capability"

        electricRadioButton.setOnClickListener {
            firstProperty.hint = "Charging time"
            secondProperty.hint = "Battery capability"
        }

        petrolRadioButton.setOnClickListener {
            firstProperty.hint = "Fuel filtering system"
            secondProperty.hint = "Fuel tank volume"
        }

        hybridRadioButton.setOnClickListener {
            firstProperty.hint = "Types fuel"
            secondProperty.hint = "Power controller"
        }

        cancelButton.setOnClickListener {
            dismiss()
        }

        addButton.setOnClickListener {
            emptyTextView.visibility = View.GONE
            onRadioButtonClicked(
                electricRadioButton,
                nameAuto,
                carImageView,
                maxSpeed,
                firstProperty,
                secondProperty
            )
            onRadioButtonClicked(
                petrolRadioButton,
                nameAuto,
                carImageView,
                maxSpeed,
                firstProperty,
                secondProperty
            )
            onRadioButtonClicked(
                hybridRadioButton,
                nameAuto,
                carImageView,
                maxSpeed,
                firstProperty,
                secondProperty
            )
            observer()
            carAdapter?.notifyItemInserted(repository.list.size)
            dismiss()
        }

        return rootView
    }

    private fun onRadioButtonClicked(
        view: View,
        nameAuto: EditText,
        carImageView: EditText,
        maxSpeed: EditText,
        firstProperty: EditText,
        secondProperty: EditText
    ) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.electraRadioButton ->
                    if (checked) {
                        var newCar = (
                                CarsType.Electra(
                                    Random.nextLong(),
                                    nameAuto.text.toString(),
                                    carImageView.text.toString(),
                                    maxSpeed.text.toString(),
                                    firstProperty.text.toString(),
                                    secondProperty.text.toString()
                                )
                                )
                        viewModel.addCar(newCar)
                    }
                R.id.petrolRadioButton ->
                    if (checked) {
                        repository.list.add(
                            CarsType.Petrol(
                                Random.nextLong(),
                                nameAuto.text.toString(),
                                carImageView.text.toString(),
                                maxSpeed.text.toString(),
                                firstProperty.text.toString(),
                                secondProperty.text.toString()
                            )
                        )
                    }
                R.id.hybridRadioButton ->
                    if (checked) {
                        repository.list.add(
                            CarsType.Hybrid(
                                Random.nextLong(),
                                nameAuto.text.toString(),
                                carImageView.text.toString(),
                                maxSpeed.text.toString(),
                                firstProperty.text.toString(),
                                secondProperty.text.toString()
                            )
                        )
                    }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun observer() {
        viewModel.cars
            .observe(viewLifecycleOwner) { newItem -> carAdapter?.items = newItem }
    }

}