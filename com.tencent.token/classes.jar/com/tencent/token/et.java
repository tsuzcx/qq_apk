package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public abstract interface et
{
  public abstract et a(Cursor paramCursor);
  
  public abstract void a(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract long b(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract String b();
  
  public abstract ContentValues c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.et
 * JD-Core Version:    0.7.0.1
 */