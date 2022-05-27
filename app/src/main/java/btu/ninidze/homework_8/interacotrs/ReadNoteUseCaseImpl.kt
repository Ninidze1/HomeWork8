package btu.ninidze.homework_8.interacotrs

import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.domain.Note
import btu.ninidze.core.interactors.AddNoteUseCase
import btu.ninidze.core.interactors.ReadNoteUseCase
import javax.inject.Inject

class ReadNoteUseCaseImpl @Inject constructor(private val noteDataSource: NoteDataSource): ReadNoteUseCase {
    override fun invoke(tag: String): String = noteDataSource.read(tag)
}