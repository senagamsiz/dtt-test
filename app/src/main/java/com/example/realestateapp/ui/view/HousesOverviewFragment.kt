package com.example.realestateapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.realestateapp.databinding.FragmentHousesOverviewBinding
import com.example.realestateapp.ui.viewmodel.HousesOverviewEvent
import com.example.realestateapp.ui.viewmodel.HousesOverviewUiState
import com.example.realestateapp.ui.viewmodel.HousesOverviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HousesOverviewFragment : Fragment() {

    private var _binding: FragmentHousesOverviewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HousesOverviewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHousesOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.dispatch(HousesOverviewEvent.LoadData)
        viewModel.uiState.observe(viewLifecycleOwner){renderUi(it)}
    }

    private fun renderUi(uiState: HousesOverviewUiState) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}