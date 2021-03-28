package com.afares.journaldev.adapter

import androidx.recyclerview.widget.DiffUtil

/**  DiffUtil used to notify updates to a RecyclerView Adapter better than
 * notifySetDataChanges -> which update recycler view any time you change
 * the list that cost for performance              */

class ArticlesDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}