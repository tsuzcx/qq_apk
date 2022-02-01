package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class ahe
  implements ahk
{
  public final String a = "ksid_data";
  public int b = 12;
  public String c = "";
  
  public final ahk a(afx paramafx)
  {
    ahe localahe = new ahe();
    localahe.c = paramafx.getString(paramafx.getColumnIndex("ksid"));
    return localahe;
  }
  
  public final String a()
  {
    return "ksid_data";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.b("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
  }
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.b("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", Integer.valueOf(this.b));
    localContentValues.put("ksid", this.c);
    return paramSQLiteDatabase.a("ksid_data", localContentValues);
  }
  
  public final ContentValues b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahe
 * JD-Core Version:    0.7.0.1
 */