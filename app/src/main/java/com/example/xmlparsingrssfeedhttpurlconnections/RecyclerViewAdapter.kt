package com.example.xmlparsingrssfeedhttpurlconnections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(val details: ArrayList<myDetails>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = details[position]

        holder.itemView.apply {
            tvTitle.text = data.title
            tvDescription.text=data.description
            tvDescription.visibility = View.GONE

            ivDescription.setOnClickListener {
                if (tvDescription.visibility == View.VISIBLE) {
                    tvDescription.visibility = View.GONE
                }else
                {
                    tvDescription.visibility = View.VISIBLE
                }

            }
        }
    }

    override fun getItemCount() = details.size
}