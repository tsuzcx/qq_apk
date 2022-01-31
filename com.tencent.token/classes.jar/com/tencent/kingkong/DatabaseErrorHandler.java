package com.tencent.kingkong;

import com.tencent.kingkong.database.SQLiteDatabase;

public abstract interface DatabaseErrorHandler
{
  public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.DatabaseErrorHandler
 * JD-Core Version:    0.7.0.1
 */