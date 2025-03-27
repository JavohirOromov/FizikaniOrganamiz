package com.example.fizikaniorganamiz.screens
import LocalStorage
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fizikaniorganamiz.R
import com.example.fizikaniorganamiz.databinding.FragmentSplashBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class SplashFragment: Fragment(R.layout.fragment_splash) {
    private val binding: FragmentSplashBinding by viewBinding(FragmentSplashBinding::bind)
    private var storage: LocalStorage? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage = LocalStorage.getInstance()

        binding.lottie.playAnimation()

        object: CountDownTimer(1500, 100){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {

                if (storage?.getFirst() == true){
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToPagerFragment())
                }else{
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
                }
            }
        }.start()
    }
}