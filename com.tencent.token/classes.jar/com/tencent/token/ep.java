package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ep
  implements ev
{
  public final String a = "ksid_data";
  public String b = "";
  private int c = 12;
  
  public ev a(Cursor paramCursor)
  {
    ep localep = new ep();
    localep.b = paramCursor.getString(paramCursor.getColumnIndex("ksid"));
    return localep;
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ksid_data(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,ksid TEXT);");
  }
  
  public void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ksid", paramString);
    et.a(this, "ksid_data", localContentValues, "key=?", new String[] { String.valueOf(this.c) });
  }
  
  public boolean a()
  {
    ep localep = (ep)et.a(this, "ksid_data", new String[] { "ksid" }, null, null);
    if (localep == null) {
      return false;
    }
    this.b = localep.b;
    return true;
  }
  
  public long b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", Integer.valueOf(this.c));
    localContentValues.put("ksid", this.b);
    return paramSQLiteDatabase.insert("ksid_data", null, localContentValues);
  }
  
  public String b()
  {
    return "ksid_data";
  }
  
  public ContentValues c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ep
 * JD-Core Version:    0.7.0.1
 */