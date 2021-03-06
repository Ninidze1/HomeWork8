package btu.ninidze.homework_8.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.domain.Note
import btu.ninidze.core.interactors.AddNoteUseCase
import btu.ninidze.homework_8.framework.Interactors
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val interactors: Interactors) : ViewModel() {

    private var _notes = MutableLiveData<List<Note>>()
    val note: LiveData<List<Note>> = _notes

    init {
        _notes.postValue(interactors.getAllNoteUseCase())
    }

    fun getNote(tag: String): String = interactors.readNoteUseCase(tag)

    fun addNote(note: Note) {
        interactors.addNoteUseCase(note)
    }

    fun deleteNote(tag: String) {
        interactors.removeNoteUseCase(tag)
    }

}