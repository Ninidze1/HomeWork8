package btu.ninidze.homework_8.interacotrs

import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.domain.Note
import btu.ninidze.core.interactors.AddNoteUseCase
import btu.ninidze.core.interactors.GetAllNoteUseCase
import javax.inject.Inject

class GetAllNoteUseCaseImpl @Inject constructor(private val noteDataSource: NoteDataSource): GetAllNoteUseCase {
    override fun invoke():List<Note> = noteDataSource.getAll()
}