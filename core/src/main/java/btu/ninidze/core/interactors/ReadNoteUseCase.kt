package btu.ninidze.core.interactors

interface ReadNoteUseCase {
    operator fun invoke(tag: String): String
}