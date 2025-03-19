package com.example.fizikaniorganamiz.screens.main
import AppRepository
import ParentAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fizikaniorganamiz.R
import com.example.fizikaniorganamiz.databinding.FragmentMainBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 17/03/25
 * Javohir's MacBook Air
 */
class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private var repository: AppRepository? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottie.playAnimation()
        repository = AppRepository.getInstanceRepository()
        val parentAdapter = ParentAdapter()
        binding.listItem.adapter = parentAdapter
        binding.listItem.layoutManager = LinearLayoutManager(requireContext())
        parentAdapter.submitList(repository?.selectionList)
    }
}