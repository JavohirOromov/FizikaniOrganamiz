package com.example.fizikaniorganamiz.screens.pager
import PagerAdapter
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fizikaniorganamiz.R
import com.example.fizikaniorganamiz.databinding.FragmentPagerBinding
import com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class PagerFragment: Fragment(R.layout.fragment_pager) {

    private val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pager.adapter = PagerAdapter(requireActivity())
        binding.springDots.attachTo(binding.pager)

        binding.next.setOnClickListener {
            binding.pager.currentItem ++
        }
        binding.back.setOnClickListener {
            binding.pager.currentItem--
        }
        binding.next1.setOnClickListener {
            binding.pager.currentItem++
        }
        binding.pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.next.text = if (position == 2) "Davom etish" else "Keyingi"
                binding.liner.isGone = position == 0
                binding.next1.isGone = position != 0
                binding.next.setOnClickListener {
                    if (binding.pager.currentItem < 2) {
                        binding.pager.currentItem += 1
                    } else {
                        findNavController().navigate(R.id.action_pagerFragment_to_mainFragment)
                    }
                }
            }
        })
    }
}