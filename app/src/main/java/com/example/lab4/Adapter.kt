package com.example.lab4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import name.ank.lab4.BibDatabase
import java.io.InputStream
import java.io.InputStreamReader
import com.example.lab4.databinding.ArticleBinding
import name.ank.lab4.Keys

class Adapter(base: InputStream) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val reader = InputStreamReader(base)
    private val database = BibDatabase(reader)

    class ViewHolder(binding: ArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        val author = binding.author
        val title = binding.title
        val url = binding.url
    }

    override fun getItemCount(): Int = database.size()
    //override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = database.getEntry(position % database.size())
        holder.author.text = "Author(s): " + entry.getField(Keys.AUTHOR) + "\n"
        holder.title.text = "Title: " + entry.getField(Keys.TITLE) + "\n"
        holder.url.text = "URL: " + (entry.getField(Keys.URL) ?: "unknown") + "\n"
    }
}