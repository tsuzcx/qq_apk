package com.tencent.moai.database.sqlite;

class SQLiteDatabase$1
  extends ThreadLocal<SQLiteSession>
{
  SQLiteDatabase$1(SQLiteDatabase paramSQLiteDatabase) {}
  
  protected SQLiteSession initialValue()
  {
    return this.this$0.createSession();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.SQLiteDatabase.1
 * JD-Core Version:    0.7.0.1
 */