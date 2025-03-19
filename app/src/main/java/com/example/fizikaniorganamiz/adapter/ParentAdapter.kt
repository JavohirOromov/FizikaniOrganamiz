import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fizikaniorganamiz.databinding.ArticleRvBinding
import com.example.fizikaniorganamiz.databinding.InventorRvBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 19/03/25
 * Javohir's MacBook Air
 */
class ParentAdapter: ListAdapter<SelectionData,ParentAdapter.ParentVH>(ParentDU) {

   abstract inner class ParentVH(view: View): RecyclerView.ViewHolder(view){
       abstract fun bind(items: List<DataRv>)
   }
    inner class InventorVH(private val binding1: InventorRvBinding): ParentVH(binding1.root){
        override fun bind(items: List<DataRv>) {
            val adapter = InventorAdapter()
            binding1.inventorList.adapter = adapter
            adapter.submitList(items.filterIsInstance<InventorData>())
        }
    }
    inner class ArticleVH(private val binding2: ArticleRvBinding): ParentVH(binding2.root){
        override fun bind(items: List<DataRv>) {
            val adapter = ArticleAdapter()
            binding2.articleList.adapter = adapter
            adapter.submitList(items.filterIsInstance<ArticleData>())
        }
    }

    object ParentDU: DiffUtil.ItemCallback<SelectionData>() {
        override fun areItemsTheSame(oldItem: SelectionData, newItem: SelectionData): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: SelectionData, newItem: SelectionData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentVH {
        return when(viewType){
            1 -> {
                val binding1 = InventorRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                InventorVH(binding1)
            }
            else -> {
                val binding2 = ArticleRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ArticleVH(binding2)
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun onBindViewHolder(holder: ParentVH, position: Int) {
        holder.bind(getItem(position).items)
    }
}
