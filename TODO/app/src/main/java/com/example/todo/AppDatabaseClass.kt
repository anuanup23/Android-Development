package com.example.todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoModel::class], version = 1)
abstract class AppDatabaseClass : RoomDatabase(){
    abstract fun todoDao(): TodoDao
}