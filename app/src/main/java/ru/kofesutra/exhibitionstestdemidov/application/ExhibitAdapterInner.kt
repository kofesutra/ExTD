package ru.kofesutra.exhibitionstestdemidov.application

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.kofesutra.exhibitionstestdemidov.databinding.CardViewInnerBinding
import ru.kofesutra.exhibitionstestdemidov.model.Exhibit

class ExhibitAdapterInner (private val context: Context, private val userListInner: List<Exhibit>):
    RecyclerView.Adapter<ExhibitAdapterInner.viewHolderInner>() {

    class viewHolderInner(binding: CardViewInnerBinding) : RecyclerView.ViewHolder(binding.root) {
        var image: ImageView = binding.imageViewPhone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderInner {
        val binding = CardViewInnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolderInner(binding)
    }

    override fun onBindViewHolder(holder: viewHolderInner, position: Int) {
//        holder.image = userListInner[position].images

        Glide.with(context)
            .load(userListInner[position].images)
//            .placeholder(R.drawable.placeholder) // Плейсхолдер
//            .error(R.drawable.place_error) // Ошибка загрузки
            .override(1200, 600)
            .fitCenter()
            .into(holder.image)
    }

    override fun getItemCount(): Int {
//        return userListInner.size
        return 1
    }
}

