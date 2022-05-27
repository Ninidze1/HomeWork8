package btu.ninidze.homework_8.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import btu.ninidze.core.domain.Note
import btu.ninidze.homework_8.databinding.ItemNoteBinding
import btu.ninidze.homework_8.util.Constants.LIST_OF_COLORS

typealias ItemClick = (String) -> Unit
class NoteRecyclerViewAdapter(private val onItemClick: ItemClick) : RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    private val items = mutableListOf<Note>()

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Note) = with(binding) {
            llRoot.setBackgroundColor(getColor(root.context, LIST_OF_COLORS.random()))

            tvTitle.text = if (item.title == "") "No Title" else item.title
            tvContent.text = if (item.text == "") "No Description" else item.text

            binding.llRoot.setOnClickListener {
                onItemClick.invoke(item.title)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    fun addItems(note: Note) {
        if (items.contains(note)) {
            return
        }
        items.add(note)
        notifyItemChanged(itemCount)
    }

    fun initList(notes: List<Note>) {
        items.clear()
        items.addAll(notes)
        notifyDataSetChanged()
    }

}