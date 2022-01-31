package com.tencent.token;

import android.content.ContentValues;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;

public final class gp
  implements go
{
  public final String a = "token_conf";
  public long b = 1L;
  public int c = 1;
  public byte[] d = null;
  private int e = 11;
  
  public final go a(Cursor paramCursor)
  {
    gp localgp = new gp();
    localgp.b = paramCursor.getLong(paramCursor.getColumnIndex("plusTime"));
    localgp.c = paramCursor.getInt(paramCursor.getColumnIndex("tokenIntVTime"));
    localgp.d = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    return localgp;
  }
  
  public final String a()
  {
    return "token_conf";
  }
  
  public final void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("plusTime", Long.valueOf(paramLong));
    localContentValues.put("tokenIntVTime", Integer.valueOf(paramInt));
    localContentValues.put("data", paramArrayOfByte);
    gl.a(this, "token_conf", localContentValues, "key=?", new String[] { String.valueOf(this.e) });
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS token_conf(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,plusTime INTEGER,tokenIntVTime INTEGER,data BLOB);");
  }
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS token_conf(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,plusTime INTEGER,tokenIntVTime INTEGER,data BLOB);");
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", Integer.valueOf(this.e));
    localContentValues.put("plusTime", Long.valueOf(this.b));
    localContentValues.put("tokenIntVTime", Integer.valueOf(this.c));
    localContentValues.put("data", this.d);
    return paramSQLiteDatabase.insert("token_conf", null, localContentValues);
  }
  
  public final ContentValues b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gp
 * JD-Core Version:    0.7.0.1
 */