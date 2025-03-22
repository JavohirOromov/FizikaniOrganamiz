import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 17/03/25
 * Javohir's MacBook Air
 */
class MainViewModelImpl(private val repository: AppRepository): ViewModel(), MainViewModel {
    override val itemsLiveData = MutableLiveData<List<SelectionData>>()
    override val openDetailScreenLiveDate = MutableLiveData<Int>()
    override val openArticleDetailScreen = MutableLiveData<Int>()
    override val openInfoScreenLiveData = MutableLiveData<Unit>()


    override fun loadSelections() {
        itemsLiveData.value = repository.selectionList
    }

    override fun openDetailScreen(position: Int) {
        openDetailScreenLiveDate.value = position
    }

    override fun openArticleDetailScreen(position: Int) {
        openArticleDetailScreen.value = position
    }

    override fun openInfoScreen() {
        openInfoScreenLiveData.value = Unit
    }
}