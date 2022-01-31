package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;

public final class gg
  implements go
{
  public final String a = "ksid_data";
  public String b = "";
  private int c = 12;
  
  public final go a(Cursor paramCursor)
  {
    gg localgg = new gg();
    localgg.b = paramCursor.getString(paramCursor.getColumnIndex("ksid"));
    return localgg;
  }
  
  public final String a()
  {
    return "ksid_data";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
  }
  
  public final void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ksid", paramString);
    gl.a(this, "ksid_data", localContentValues, "key=?", new String[] { String.valueOf(this.c) });
  }
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", Integer.valueOf(this.c));
    localContentValues.put("ksid", this.b);
    return paramSQLiteDatabase.insert("ksid_data", null, localContentValues);
  }
  
  public final ContentValues b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gg
 * JD-Core Version:    0.7.0.1
 */