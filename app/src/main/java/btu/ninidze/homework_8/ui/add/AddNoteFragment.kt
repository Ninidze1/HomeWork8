package btu.ninidze.homework_8.ui.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import btu.ninidze.core.domain.Note
import btu.ninidze.homework_8.R
import btu.ninidze.homework_8.databinding.FragmentAddNoteBinding
import btu.ninidze.homework_8.ui.BaseFragment
import btu.ninidze.homework_8.util.Constants.EMPTY_STRING
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>() {

    private val viewModel: AddNoteViewModel by viewModels()
    private val args: AddNoteFragmentArgs by navArgs()

    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAddNoteBinding
        get() = FragmentAddNoteBinding::inflate

    override fun init(){
        loadViews()
        setListeners()
        subscribeToObservers()
    }

    private fun subscribeToObservers() = with(binding) {
        viewModel.note.observe(viewLifecycleOwner) { note ->
            edTitle.setText(note.title)
            edText.setText(note.text)
        }
    }

    private fun loadViews() = with(binding) {
        val title = args.title
        if (title != EMPTY_STRING) {
            viewModel.getNote(title)
        }
    }

    private fun setListeners() = with(binding) {
        btnSave.setOnClickListener {

            val note = Note(
                title = edTitle.text.trim().toString(),
                text = edText.text.trim().toString()
            )
            viewModel.addNote(note)

            findNavController().navigateUp()
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}