package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;

public class gi
  implements go
{
  public String a;
  public String b;
  
  public final go a(Cursor paramCursor)
  {
    gi localgi = new gi();
    localgi.a = paramCursor.getString(paramCursor.getColumnIndex("uinhash"));
    localgi.b = paramCursor.getString(paramCursor.getColumnIndex("filename"));
    return localgi;
  }
  
  public final String a()
  {
    return "qqface";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS qqface(uinhash TEXT PRIMARY KEY,filename TEXT);");
  }
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS qqface(uinhash TEXT PRIMARY KEY,filename TEXT);");
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uinhash", this.a);
    localContentValues.put("filename", this.b);
    return paramSQLiteDatabase.insert("qqface", null, localContentValues);
  }
  
  public final ContentValues b()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uinhash", this.a);
    localContentValues.put("filename", this.b);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gi
 * JD-Core Version:    0.7.0.1
 */