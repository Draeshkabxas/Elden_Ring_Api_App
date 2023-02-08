package com.example.postsapi.ui.spirit

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.postsapi.model.Spirit

import com.example.postsapi.databinding.BossItemBinding


class SpiritAdapter(private val onEndScroll:(limit:Int)->Unit ) : ListAdapter<Spirit, RecyclerView.ViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Spirit>() {

            override fun areItemsTheSame(oldItem: Spirit, newItem: Spirit): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Spirit, newItem: Spirit): Boolean {
                return oldItem.id == newItem.id && oldItem.name == newItem.name
            }

        }
    }

    private lateinit var binding: BossItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = BossItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == itemCount - 5 && itemCount < 150){
            onEndScroll(itemCount + 10)
        }
        if (holder is ViewHolder) {
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val itemBinding: BossItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Spirit) {

            itemBinding.apply {

                tvTitle.text = item.name
                tvContent.text = item.description
                tvPic.load(item.image)
            }

        }
    }
}
