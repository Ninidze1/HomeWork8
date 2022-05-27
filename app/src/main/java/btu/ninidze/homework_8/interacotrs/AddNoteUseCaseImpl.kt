package btu.ninidze.homework_8.interacotrs

import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.domain.Note
import btu.ninidze.core.interactors.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(private val noteDataSource: NoteDataSource): AddNoteUseCase {
    override fun invoke(note: Note) {
        noteDataSource.add(note)
    }
}