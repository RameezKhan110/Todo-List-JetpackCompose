package com.example.memomate.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.memomate.ApplicationClass

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {

        private var INSTANCE: NotesDatabase? = null
        fun getDatabase(): NotesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        ApplicationClass.application.baseContext,
                        NotesDatabase::class.java,
                        "notes_database"
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}