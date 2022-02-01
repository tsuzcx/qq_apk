package com.facebook.stetho.inspector.database;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteException;
import java.io.File;

public class DefaultDatabaseConnectionProvider
  implements DatabaseConnectionProvider
{
  @SQLiteDatabaseCompat.SQLiteOpenOptions
  protected int determineOpenOptions(File paramFile)
  {
    int i = 0;
    if (new File(paramFile.getParent(), paramFile.getName() + "-wal").exists()) {
      i = 1;
    }
    return i;
  }
  
  public SQLiteDatabase openDatabase(File paramFile)
    throws SQLiteException
  {
    return performOpen(paramFile, determineOpenOptions(paramFile));
  }
  
  protected SQLiteDatabase performOpen(File paramFile, @SQLiteDatabaseCompat.SQLiteOpenOptions int paramInt)
  {
    SQLiteDatabaseCompat localSQLiteDatabaseCompat = SQLiteDatabaseCompat.getInstance();
    int i = localSQLiteDatabaseCompat.provideOpenFlags(paramInt);
    paramFile = SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, 0x0 | i);
    localSQLiteDatabaseCompat.enableFeatures(paramInt, paramFile);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.database.DefaultDatabaseConnectionProvider
 * JD-Core Version:    0.7.0.1
 */