package btu.ninidze.homework_8.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import btu.ninidze.homework_8.R
import btu.ninidze.homework_8.databinding.FragmentNoteBinding
import btu.ninidze.homework_8.ui.BaseFragment
import btu.ninidze.homework_8.util.extensions.getRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : BaseFragment<FragmentNoteBinding>() {

    private val viewModel: NoteViewModel by viewModels()

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNoteBinding
        get() = FragmentNoteBinding::inflate

    override fun init() {
        initAdapter()
        subscribeToObservers()
        setListeners()
    }

    private fun subscribeToObservers() = with(binding) {
        viewModel.note.observe(viewLifecycleOwner) { notes ->
            rwNotes.getRecyclerViewAdapter<NoteRecyclerViewAdapter>().initList(notes)
        }
    }

    private fun setListeners() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_addNoteFragment)
        }

    }

    private fun initAdapter() = with(binding) {
        rwNotes.apply {
            setHasFixedSize(false)
            layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
            adapter = NoteRecyclerViewAdapter { title ->
                val action = NoteFragmentDirections.actionNoteFragmentToAddNoteFragment(title)
                findNavController().navigate(action)
            }
        }

    }


}