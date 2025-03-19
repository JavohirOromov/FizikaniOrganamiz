import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class PagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> FirstPage()
            1 -> SecondPage()
            else -> ThreePage()
        }
    }
}