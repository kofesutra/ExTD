package ru.kofesutra.exhibitionstestdemidov.Application

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.kofesutra.exhibitionstestdemidov.model.Exhibit
import ru.kofesutra.exhibitionstestdemidov.databinding.CardViewBinding

class ExhibitAdapter(private val context: Context, private val userList: List<Exhibit>):
    RecyclerView.Adapter<ExhibitAdapter.viewHolderOuter>() {
    lateinit var adapterInner: ExhibitAdapterInner

    class viewHolderOuter(binding: CardViewBinding): RecyclerView.ViewHolder(binding.root){
        val title: TextView = binding.titleR
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderOuter {
        val binding = CardViewBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewHolderOuter(binding)
    }

    override fun onBindViewHolder(holder: viewHolderOuter, position: Int) {
        holder.title.text = userList[position].title
        }

    override fun getItemCount(): Int {
        return  userList.size
    }


}
