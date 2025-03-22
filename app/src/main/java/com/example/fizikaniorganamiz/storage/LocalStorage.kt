import android.content.Context
import android.content.SharedPreferences
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 22/03/25
 * Javohir's MacBook Air
 */
class LocalStorage private constructor(context: Context){
    private val preferences: SharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    companion object{
        private const val FILE_NAME = "Javohir's Info"
        private const val FIRST = "first"
        private lateinit var storage: LocalStorage

        fun init(context: Context){
            if (!(::storage.isInitialized)){
                storage = LocalStorage(context)
            }
        }
        fun getInstance(): LocalStorage{
            return storage
        }
    }
    fun saveFirst(isFirst: Boolean){
        editor.putBoolean(FIRST,isFirst).apply()
    }
    fun getFirst(): Boolean{
        return preferences.getBoolean(FIRST, true)
    }
}