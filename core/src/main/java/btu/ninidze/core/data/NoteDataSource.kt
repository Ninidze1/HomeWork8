package btu.ninidze.core.data

import btu.ninidze.core.domain.Note

interface NoteDataSource {

    fun add(note: Note)

    fun read(tag: String): String

    fun remove(tag: String)

    fun getAll(): List<Note>

}