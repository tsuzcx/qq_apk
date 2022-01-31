package com.tencent.wcdb.database;

import java.util.List;

public abstract interface SQLiteTrace
{
  public abstract void onConnectionObtained(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void onConnectionPoolBusy(SQLiteDatabase paramSQLiteDatabase, String paramString1, List paramList, String paramString2);
  
  public abstract void onDatabaseCorrupted(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onSQLExecuted(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteTrace
 * JD-Core Version:    0.7.0.1
 */