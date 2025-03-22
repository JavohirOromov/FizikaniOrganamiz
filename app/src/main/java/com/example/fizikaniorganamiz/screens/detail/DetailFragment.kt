package com.example.fizikaniorganamiz.screens.detail
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fizikaniorganamiz.R
import com.example.fizikaniorganamiz.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    private val args: DetailFragmentArgs by navArgs()
    private var position = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = args.position
        loadViews()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun loadViews(){
        when (position) {
            1 -> {
                binding.inventorImage.setImageResource(R.drawable.tesla_img)
                binding.inventor.text = "Nikola Tesla"
                binding.inventorAbout.text = getString(R.string.textTesla)
            }
            2 -> {
                binding.inventorImage.setImageResource(R.drawable.nyuton_img)
                binding.inventor.text = "Isak Nyuton"
                binding.inventorAbout.text = getString(R.string.textNyuton)
            }
            3 -> {
                binding.inventorImage.setImageResource(R.drawable.einstein_img)
                binding.inventor.text = "Albert Einstein"
                binding.inventorAbout.text = getString(R.string.textEinstein)
            }
            4 ->{
                binding.inventorImage.setImageResource(R.drawable.faradey_img)
                binding.inventor.text = "Maykl Faradey"
                binding.inventorAbout.text = getString(R.string.textFaraday)
            }
            5 -> {
                binding.inventorImage.setImageResource(R.drawable.volta_img)
                binding.inventor.text = "Allesadro Volta"
                binding.inventorAbout.text = getString(R.string.textVolta)
            }
            6 -> {
                binding.inventorImage.setImageResource(R.drawable.amper_img)
                binding.inventor.text = "Amper"
                binding.inventorAbout.text = getString(R.string.textAmper)
            }
            7 -> {
                binding.inventorImage.setImageResource(R.drawable.fulton_img)
                binding.inventor.text = "Robert Fulton"
                binding.inventorAbout.text = getString(R.string.textFulton)
            }
            8 ->{
                binding.inventorImage.setImageResource(R.drawable.galileo_img)
                binding.inventor.text = "Galileo Galilei"
                binding.inventorAbout.text = getString(R.string.textGalilei)
            }
            9 ->{
                binding.inventorImage.setImageResource(R.drawable.watt_img)
                binding.inventor.text = "James Watt"
                binding.inventorAbout.text = getString(R.string.textJamesWatt)
            }
        }
    }
}
