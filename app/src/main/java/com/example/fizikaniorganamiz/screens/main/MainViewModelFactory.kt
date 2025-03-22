import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 21/03/25
 * Javohir's MacBook Air
 */
class MainViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModelImpl(AppRepository.getInstanceRepository()) as T
    }
}