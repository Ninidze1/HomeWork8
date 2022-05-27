package btu.ninidze.homework_8.framework

import android.content.SharedPreferences
import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.domain.Note
import btu.ninidze.homework_8.util.Constants.DEFAULT_VALUE
import javax.inject.Inject

class NoteDataSourceImp @Inject constructor(private val sharedPreferences: SharedPreferences) : NoteDataSource {

    override fun add(note: Note) {
        sharedPreferences.edit().putString(note.title, note.text).apply()
    }

    override fun read(tag: String): String = sharedPreferences.getString(tag, DEFAULT_VALUE).toString()

    override fun remove(tag: String) {
        sharedPreferences.edit().remove(tag).apply()
    }

    override fun getAll(): List<Note> =  sharedPreferences.all.map { Note(it.key, it.value as String) }

}