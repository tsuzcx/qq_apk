package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public class er
  implements ev
{
  public String a;
  public String b;
  
  public ev a(Cursor paramCursor)
  {
    er localer = new er();
    localer.a = paramCursor.getString(paramCursor.getColumnIndex("uinhash"));
    localer.b = paramCursor.getString(paramCursor.getColumnIndex("filename"));
    return localer;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS qqface(uinhash TEXT PRIMARY KEY,filename TEXT);");
  }
  
  public long b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uinhash", this.a);
    localContentValues.put("filename", this.b);
    return paramSQLiteDatabase.insert("qqface", null, localContentValues);
  }
  
  public String b()
  {
    return "qqface";
  }
  
  public ContentValues c()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uinhash", this.a);
    localContentValues.put("filename", this.b);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.er
 * JD-Core Version:    0.7.0.1
 */