package btu.ninidze.core.data

import btu.ninidze.core.domain.Note


class NoteRepository(private val dataSource: NoteDataSource) {

    fun addNote(note: Note) = dataSource.add(note)

    fun getNote(tag: String) = dataSource.read(tag)

    fun removeNote(tag: String) = dataSource.remove(tag)

    fun getAll(): List<Note> = dataSource.getAll()


}