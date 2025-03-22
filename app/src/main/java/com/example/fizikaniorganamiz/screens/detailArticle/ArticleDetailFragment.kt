package com.example.fizikaniorganamiz.screens.detailArticle
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fizikaniorganamiz.R
import com.example.fizikaniorganamiz.databinding.FragmentArticleDetailBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 22/03/25
 * Javohir's MacBook Air
 */
class ArticleDetailFragment: Fragment(R.layout.fragment_article_detail) {
    private val binding: FragmentArticleDetailBinding by viewBinding(FragmentArticleDetailBinding::bind)

    private val args: ArticleDetailFragmentArgs by navArgs()
    var position = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = args.position
         loadViews()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun loadViews() {
        when (position) {
            0 -> {
                binding.articleImage.setImageResource(R.drawable.article_img1)
                binding.articleTopic.text = "Nyutonning tortishish qonuni"
                binding.articleAbout.text = getString(R.string.textArticle1)
            }

            1 -> {
                binding.articleImage.setImageResource(R.drawable.article_img2)
                binding.articleTopic.text = "Elektromagnit induksiya"
                binding.articleAbout.text = getString(R.string.textArticle2)
            }

            2 -> {
                binding.articleImage.setImageResource(R.drawable.article_img3)
                binding.articleTopic.text = "Maxvell tenglamalari"
                binding.articleAbout.text = getString(R.string.textArticle3)
                binding.back.setColorFilter(Color.BLACK)
            }
            3 -> {
                binding.articleImage.setImageResource(R.drawable.article_img4)
                binding.articleTopic.text = "Nisbiylik nazariyasi"
                binding.articleAbout.text = getString(R.string.textArticle4)
            }

            4 -> {
                binding.articleImage.setImageResource(R.drawable.article_img5)
                binding.articleTopic.text = "Kvant mexanikasi"
                binding.articleAbout.text = getString(R.string.textArticle5)
            }

            5 -> {
                binding.articleImage.setImageResource(R.drawable.article_img6)
                binding.articleTopic.text = "Yadro fizikasining rivojlanishi"
                binding.articleAbout.text = getString(R.string.textArticle6)
            }

            6 -> {
                binding.articleImage.setImageResource(R.drawable.article_img7)
                binding.articleTopic.text = "Supero‘tkazuvchanlik"
                binding.articleAbout.text = getString(R.string.textArticle7)
            }

            7 -> {
                binding.articleImage.setImageResource(R.drawable.article_img8)
                binding.articleTopic.text = "Lazer texnologiyasi "
                binding.articleAbout.text = getString(R.string.textArticle1)
            }
        }
    }
}