package btu.ninidze.core.interactors

import btu.ninidze.core.domain.Note

interface AddNoteUseCase {
    operator fun invoke(note: Note)
}