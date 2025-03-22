import androidx.lifecycle.LiveData
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 17/03/25
 * Javohir's MacBook Air
 */
interface MainViewModel {
    val itemsLiveData: LiveData<List<SelectionData>>
    val openDetailScreenLiveDate: LiveData<Int>
    val openArticleDetailScreen: LiveData<Int>
    val openInfoScreenLiveData: LiveData<Unit>
    val showEmptyAnimation: LiveData<Boolean>

    fun loadSelections()
    fun openDetailScreen(position: Int)
    fun openArticleDetailScreen(position: Int)
    fun openInfoScreen()
    fun showEmptyAnimation(isEmpty: Boolean)
}