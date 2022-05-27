package btu.ninidze.core.interactors

import btu.ninidze.core.domain.Note

interface GetAllNoteUseCase {
    operator fun invoke(): List<Note>
}