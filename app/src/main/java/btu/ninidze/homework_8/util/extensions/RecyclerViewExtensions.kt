package btu.ninidze.homework_8.util.extensions

import androidx.recyclerview.widget.RecyclerView

inline fun <reified T : RecyclerView.Adapter<*>> RecyclerView.getRecyclerViewAdapter(): T {
    return this.adapter as T
}