package btu.ninidze.homework_8.ui.add

import androidx.annotation.ColorRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import btu.ninidze.core.domain.Note
import btu.ninidze.homework_8.R
import btu.ninidze.homework_8.framework.Interactors
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val interactors: Interactors) : ViewModel() {

    private var _note = MutableLiveData<Note>()
    val note: LiveData<Note> = _note


    fun addNote(note: Note) {
        interactors.addNoteUseCase(note)
    }

    fun getNote(tag: String) {
        _note.postValue(Note(
            title = tag,
            text = interactors.readNoteUseCase(tag)
        ))
    }


}