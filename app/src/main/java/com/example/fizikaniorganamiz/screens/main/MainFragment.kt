package com.example.fizikaniorganamiz.screens.main
import MainViewModel
import MainViewModelFactory
import ParentAdapter
import SelectionData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
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
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }
    private val adapter by lazy { ParentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openDetailScreenLiveDate.observe(this,openDetailScreenObserver)
        viewModel.openArticleDetailScreen.observe(this,openArticleDetailScreenObserver)
        viewModel.openInfoScreenLiveData.observe(this,openInfoScreenObserver)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addClickEvents()
        viewModel.itemsLiveData.observe(viewLifecycleOwner, selectionObserver)
        viewModel.showEmptyAnimation.observe(viewLifecycleOwner,showEmptyAnimationObserver)
    }
    private fun initAdapter(){
        viewModel.loadSelections()
        binding.listItem.adapter = adapter
        binding.listItem.layoutManager = LinearLayoutManager(requireContext())
    }
    private fun addClickEvents(){
        adapter.setInventorItemClickListener {
            viewModel.openDetailScreen(it)
        }
        adapter.setArticleItemClickListener {
            viewModel.openArticleDetailScreen(it)
        }
        binding.info.setOnClickListener {
            viewModel.openInfoScreen()
        }
        adapter.setEmptyStateClickListener {
            viewModel.showEmptyAnimation(it)
        }
    }
    private val selectionObserver = Observer<List<SelectionData>>{
        adapter.submitList(it)
    }
    private val openDetailScreenObserver = Observer<Int>{ position ->
        Log.d("TTT","$position")
        val actions = MainFragmentDirections.actionMainFragmentToDetailFragment(position)
        findNavController().navigate(actions)
    }
    private val openArticleDetailScreenObserver = Observer<Int>{ position ->
        val actions = MainFragmentDirections.actionMainFragmentToArticleDetailFragment(position)
        findNavController().navigate(actions)
    }
    private val openInfoScreenObserver = Observer<Unit>{
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/Javohir_Oromov"))
        startActivity(intent)
    }
    private val showEmptyAnimationObserver = Observer<Boolean>{ isEmpty ->
        if (isEmpty){
            binding.empty.visibility = View.VISIBLE
        }else{
            binding.empty.visibility = View.GONE
        }
    }
}