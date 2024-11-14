package com.example.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemRowNewsBinding
import com.example.newsapp.model.ArticlesItem

class NewsAdapter(private val listNews: List<ArticlesItem>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(private val binding: ItemRowNewsBinding):
    RecyclerView.ViewHolder(binding.root){ // # 1
        fun bind(articlesItem: ArticlesItem){
            binding.apply {
                tvJudul.text = articlesItem.title
                tvPenulis.text = articlesItem.author
                tvTanggalPosting.text = articlesItem.publishedAt

                Glide.with(itemView.context)
                    .load(articlesItem.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_DETAIL,articlesItem)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }


//harus diingat implement members dalam recycler view adapter dibagian atas saya kasih nomer 1
    // ini ngebinding data kedalam layout yang kita inginkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return  ViewHolder(binding)
    }

//    kasih menentukan data yang kita miliki
    override fun getItemCount(): Int {
        return listNews.size
    }

    //ksih tahu kita posisi di index ke berapa
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

}