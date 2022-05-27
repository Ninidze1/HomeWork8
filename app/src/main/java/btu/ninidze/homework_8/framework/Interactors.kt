package btu.ninidze.homework_8.framework

import btu.ninidze.core.interactors.AddNoteUseCase
import btu.ninidze.core.interactors.GetAllNoteUseCase
import btu.ninidze.core.interactors.ReadNoteUseCase
import btu.ninidze.core.interactors.RemoveNoteUseCase
import javax.inject.Inject

data class Interactors @Inject constructor(
    val addNoteUseCase: AddNoteUseCase,
    val readNoteUseCase: ReadNoteUseCase,
    val removeNoteUseCase: RemoveNoteUseCase,
    val getAllNoteUseCase: GetAllNoteUseCase,
)