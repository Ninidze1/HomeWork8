package btu.ninidze.homework_8.interacotrs

import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.interactors.RemoveNoteUseCase
import javax.inject.Inject

class RemoveNoteUseCaseImpl @Inject constructor(private val noteDataSource: NoteDataSource): RemoveNoteUseCase {
    override fun invoke(tag: String) {
        noteDataSource.read(tag)
    }
}