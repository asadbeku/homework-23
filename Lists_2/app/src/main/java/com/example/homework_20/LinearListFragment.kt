package com.example.homework_20

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_20.Adapters.CarsAdapterDelegate
import kotlinx.android.synthetic.main.list_page.*

class LinearListFragment : Fragment(R.layout.list_page) {

    private var repository: CarRepository = CarRepository()

    private val viewModel: AddNewItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.carListChecker()) {
            emptyTextView.visibility = View.VISIBLE
        }

        fabButton.setOnClickListener {
            showDialog(requireView())
            recyclerView.scrollToPosition(0)
        }
        observeViewModelState()
        initList()
    }

    private var carAdapter: CarsAdapterDelegate? = null

    private fun initList() {
        carAdapter = CarsAdapterDelegate { position ->
            deleteCar(position)
        }
        with(recyclerView) {
            adapter = carAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }
    }

    private fun observeViewModelState() {
        viewModel.cars
            .observe(viewLifecycleOwner) {
                carAdapter?.items = it
            }
    }

    private fun showDialog(view: View) {
        var dialog = AddItemDialog(carAdapter, emptyTextView)
        dialog.show(childFragmentManager, "customDialog")
    }

    private fun deleteCar(position: Int) {
        viewModel.deleteCar(position)
    }
}