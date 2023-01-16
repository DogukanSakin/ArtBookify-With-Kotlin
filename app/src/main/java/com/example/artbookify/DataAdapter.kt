package com.example.artbookify

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artbookify.databinding.RecyclerRowBinding

class DataAdapter(val dataList: ArrayList<DataModel>): RecyclerView.Adapter<DataAdapter.DataHolder>() {
    class DataHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return DataHolder(binding);
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.binding.recyclerViewTextView.text=dataList.get(position).name;
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,DetailsActivity::class.java);
            intent.putExtra("info","old");
            intent.putExtra("id",dataList.get(position).id);
            holder.itemView.context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
        return dataList.size;
    }
}