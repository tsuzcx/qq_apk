package com.tencent.wcdb.database;

class SQLiteDatabase$1
  extends ThreadLocal
{
  SQLiteDatabase$1(SQLiteDatabase paramSQLiteDatabase) {}
  
  protected SQLiteSession initialValue()
  {
    return this.this$0.createSession();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDatabase.1
 * JD-Core Version:    0.7.0.1
 */