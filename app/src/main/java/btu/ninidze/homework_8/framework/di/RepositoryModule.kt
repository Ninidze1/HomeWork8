package btu.ninidze.homework_8.framework.di

import btu.ninidze.core.data.NoteDataSource
import btu.ninidze.core.interactors.AddNoteUseCase
import btu.ninidze.core.interactors.GetAllNoteUseCase
import btu.ninidze.core.interactors.ReadNoteUseCase
import btu.ninidze.core.interactors.RemoveNoteUseCase
import btu.ninidze.homework_8.framework.NoteDataSourceImp
import btu.ninidze.homework_8.interacotrs.AddNoteUseCaseImpl
import btu.ninidze.homework_8.interacotrs.GetAllNoteUseCaseImpl
import btu.ninidze.homework_8.interacotrs.ReadNoteUseCaseImpl
import btu.ninidze.homework_8.interacotrs.RemoveNoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNoteRepository(noteRepository: NoteDataSourceImp): NoteDataSource

    @Binds
    abstract fun bindNoteAddUseCase(addNoteUseCase: AddNoteUseCaseImpl): AddNoteUseCase

    @Binds
    abstract fun bindNoteReadUseCase(readNoteUseCase: ReadNoteUseCaseImpl): ReadNoteUseCase

    @Binds
    abstract fun bindNoteRemoveUseCase(removeNoteUseCase: RemoveNoteUseCaseImpl): RemoveNoteUseCase

    @Binds
    abstract fun bindGetAllNoteUseCase(getAllNoteUseCase: GetAllNoteUseCaseImpl): GetAllNoteUseCase
}