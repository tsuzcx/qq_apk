package com.tencent.moai.database;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public abstract interface DatabaseErrorHandler
{
  public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.DatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */