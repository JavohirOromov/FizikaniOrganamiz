import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
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

    private var inventorItemClickListener: ((Int) -> Unit)? = null
    private var articleItemClickListener: ((Int) -> Unit)? = null
    private var emptyStateClickListener: ((Boolean) -> Unit)? = null
    private var binding2_2: ArticleRvBinding? = null
    fun setInventorItemClickListener(listener: (Int) -> Unit){
        this.inventorItemClickListener = listener
    }
    fun setArticleItemClickListener(listener: (Int) -> Unit){
        this.articleItemClickListener = listener
    }
    fun setEmptyStateClickListener(listener: (Boolean) -> Unit){
        this.emptyStateClickListener = listener
    }
   abstract inner class ParentVH(view: View): RecyclerView.ViewHolder(view){
       abstract fun bind(items: List<DataRv>)
   }
    inner class InventorVH(private val binding1: InventorRvBinding) : ParentVH(binding1.root) {
        private var inventorList = listOf<InventorData>()

        override fun bind(items: List<DataRv>) {
            val adapter = InventorAdapter()
            binding1.inventorList.adapter = adapter
            inventorList = items.filterIsInstance<InventorData>()
            adapter.submitList(inventorList)

            adapter.setItemClickListener {
                inventorItemClickListener?.invoke(it)
            }
            val searchEditText = binding1.search.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            searchEditText.setTextColor(Color.BLACK)
            binding1.search.setIconifiedByDefault(false)
            binding1.search.queryHint = "Qidiruv..."
            (binding1.search as? SearchView)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    filterList(newText ?: "")
                    return true
                }
            })
        }

        private fun filterList(query: String) {
            val filteredList = if (query.isEmpty()) {
                inventorList
            } else {
                inventorList.filter { it.name.contains(query, ignoreCase = true) }
            }
            (binding1.inventorList.adapter as? InventorAdapter)?.submitList(filteredList)
            if (filteredList.isEmpty()){
                binding1.inventorList.visibility = View.GONE
                binding2_2?.article?.visibility = View.GONE
                emptyStateClickListener?.invoke(filteredList.isEmpty())
            }else{
                binding1.inventorList.visibility = View.VISIBLE
                binding2_2?.article?.visibility = View.VISIBLE
                emptyStateClickListener?.invoke(filteredList.isEmpty())
            }
        }
    }

    inner class ArticleVH(private val binding2: ArticleRvBinding): ParentVH(binding2.root){
        override fun bind(items: List<DataRv>) {
            val adapter = ArticleAdapter()
            binding2.articleList.adapter = adapter
            adapter.submitList(items.filterIsInstance<ArticleData>())
            adapter.setItemClickListener {
                articleItemClickListener?.invoke(it)
            }
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
                binding2_2 = binding2
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
    fun filterList(query: String, fullList: List<SelectionData>) {
        val filteredList = if (query.isEmpty()) {
            fullList
        } else {
            fullList.map { parentItem ->
                if (parentItem.type == 1) {
                    val filteredInventors = parentItem.items.filter {
                        it is InventorData && it.name.contains(query, ignoreCase = true)
                    }
                    SelectionData(id = parentItem.id, type = parentItem.type, items = filteredInventors)
                } else {
                    parentItem
                }
            }.filter { it.items.isNotEmpty() }
        }
        submitList(filteredList)
    }
}
