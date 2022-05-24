package com.example.realestateapp.ui.view.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.realestateapp.data.model.House
import com.example.realestateapp.databinding.HousesItemBinding
import java.util.*

class HouseAdapter(
    private val houses: MutableList<House>,
    private val clickListener: HouseClickListener
) : ListAdapter<House, HouseAdapter.ViewHolder>(HouseDiffCallBack()),
    Filterable {


    interface OnCheckListSize {
        fun onCheckListSize(isThereAnyItem: Boolean)
    }

    private lateinit var listenerOnCheckListSize: OnCheckListSize
    fun setOnCheckListener(listener: OnCheckListSize) {
        listenerOnCheckListSize = listener
    }

    var filteredHouseList: MutableList<House> = houses

    class ViewHolder private constructor(private val binding: HousesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HousesItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: House, clickListener: HouseClickListener) {
            binding.house = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredHouseList = houses
                } else {
                    val filteredList = houses
                        .filter {
                            "${it.city} ${it.zip}".toLowerCase(Locale.ROOT).contains(charSearch)
                        }
                        .toMutableList()

                    filteredHouseList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredHouseList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                submitList(results.values as MutableList<House>)
                notifyDataSetChanged()

                when ((results.values as MutableList<House>).size) {
                    0 -> listenerOnCheckListSize.onCheckListSize(false)
                    else -> listenerOnCheckListSize.onCheckListSize(true)
                }
            }

        }
    }

}