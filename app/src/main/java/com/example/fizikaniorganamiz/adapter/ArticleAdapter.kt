import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fizikaniorganamiz.databinding.ItemArticleBinding
/**
 * Creator: Javohir Oromov
 * Project: Fizikani O'rganamiz
 * Date: 18/03/25
 * Javohir's MacBook Air
 */
class ArticleAdapter:ListAdapter<ArticleData, ArticleAdapter.ArticleVH>(ArticleDU) {
    inner class ArticleVH(private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: ArticleData){
            binding.image.setImageResource(data.image)
            binding.articleTopic.text = data.topic
            binding.article.text = data.article
        }
    }
    object ArticleDU: DiffUtil.ItemCallback<ArticleData>() {
        override fun areItemsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean {
            return oldItem.id == newItem.id
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleVH(binding)
    }
    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        holder.bind(getItem(position))
    }
}