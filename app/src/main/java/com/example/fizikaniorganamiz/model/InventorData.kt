/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 18/03/25
 * Javohir's MacBook Air
 */
class InventorData(val id: Int, val image: Int, val name: String, val about: String, val bgItem: Int, val bgButton: Int): DataRv {
    override fun getType(): Int  = 1
}