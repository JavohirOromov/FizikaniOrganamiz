import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fizikaniorganamiz.databinding.ItemInventorBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 18/03/25
 * Javohir's MacBook Air
 */
class InventorAdapter: ListAdapter<InventorData,InventorAdapter.InventorVH>(InventorDU) {

    private var itemClickListener: ((Int) -> Unit)? = null

    fun setItemClickListener(itemClickListener: (Int) -> Unit){
        this.itemClickListener = itemClickListener
    }

    inner class InventorVH(private val binding: ItemInventorBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: InventorData){
            binding.inventorImg.setImageResource(data.image)
            binding.inventorName.text = data.name
            binding.inventorAbut.text = data.about
            binding.itemBg.setBackgroundResource(data.bgItem)
            binding.bgBtn.setBackgroundResource(data.bgButton)
        }

        init {
            binding.itemInventor.setOnClickListener {
                itemClickListener?.invoke(getItem(adapterPosition).id)
            }
        }
    }
    object InventorDU: DiffUtil.ItemCallback<InventorData>() {
        override fun areItemsTheSame(oldItem: InventorData, newItem: InventorData): Boolean {
            return oldItem.id == newItem.id
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: InventorData, newItem: InventorData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventorVH {
        val binding = ItemInventorBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return InventorVH(binding)
    }

    override fun onBindViewHolder(holder: InventorVH, position: Int) {
        holder.bind(getItem(position))
    }
}