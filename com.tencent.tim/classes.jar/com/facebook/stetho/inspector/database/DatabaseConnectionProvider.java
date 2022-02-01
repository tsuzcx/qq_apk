package com.facebook.stetho.inspector.database;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.io.File;

public abstract interface DatabaseConnectionProvider
{
  public abstract SQLiteDatabase openDatabase(File paramFile)
    throws SQLiteException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.DatabaseConnectionProvider
 * JD-Core Version:    0.7.0.1
 */