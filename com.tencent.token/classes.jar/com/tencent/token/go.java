package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;

public abstract interface go
{
  public abstract go a(Cursor paramCursor);
  
  public abstract String a();
  
  public abstract void a(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract long b(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract ContentValues b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.go
 * JD-Core Version:    0.7.0.1
 */