package com.example.fizikaniorganamiz.screens.main
import ArticleData
import InventorData
import ParentAdapter
import SelectionData
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottie.playAnimation()
        val inventorList = listOf(
            InventorData(
                1,
                R.drawable.tesla_img,
                "Nikola Tesla",
                "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                R.drawable.bg_tesla1,
                R.drawable.bg_tesla2
            ),
            InventorData(
                2,
                R.drawable.nyuton_img,
                "Isak Nyuton",
                "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                R.drawable.bg_nyuton,
                R.drawable.bg_nyuton2
            ),
            InventorData(
                3,
                R.drawable.einstein_img,
                " Eynshteyn",
                "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                R.drawable.bg_einstein1,
                R.drawable.bg_einstein2
            ),
            InventorData(
                4,
                R.drawable.faradey_img,
                "Maykl Faradey",
                "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                R.drawable.bg_faradey1,
                R.drawable.bg_faradey2
            ),
                    InventorData(5,
            R.drawable.volta_img,
            "Volta",
            "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                        R.drawable.bg_volta1
                        ,R.drawable.bg_volta2
        ),
        InventorData(
            6,
            R.drawable.amper_img,
            "Amper",
            "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
            R.drawable.bg_amper1,
            R.drawable.bg_amper2
        ),
        InventorData(
            7,
            R.drawable.faradey_img,
            "Robert Fulton",
            "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
            R.drawable.bg_fulton1,
            R.drawable.bg_fulton2
        ),
        InventorData(
            8,
            R.drawable.galileo_img,
            "Galileo Galilei",
            "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
            R.drawable.bg_galileo1,
            R.drawable.bg_galileo2
        ),
            InventorData(
                9,
                R.drawable.watt_img,
                "James Watt",
                "Daho fizik Nikola Tesla (1856–1943) -amerikalik fizik va ixtirochi",
                R.drawable.bg_watt1,
                R.drawable.bg_watt2
            ),
        )
        val articleList = listOf(
            ArticleData(1,R.drawable.article_img1,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(2,R.drawable.article_img2,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(3,R.drawable.article_img3,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(4,R.drawable.article_img4,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(5,R.drawable.article_img5,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(6,R.drawable.article_img6,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi."),
            ArticleData(7,R.drawable.article_img7,"Nyutonning tortishish qonuni","(1687-yil, Isaak Nyuton) – Osmon jismlari harakati va mexanikaning asosiy qonunlarini tushuntirdi.")
        )
        val selectionList = listOf(
            SelectionData(1,1,inventorList),
            SelectionData(2,2,articleList)
        )
        val parentAdapter = ParentAdapter()
        binding.listItem.adapter = parentAdapter
        binding.listItem.layoutManager = LinearLayoutManager(requireContext())
        parentAdapter.submitList(selectionList)
    }
}