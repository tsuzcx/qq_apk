package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ew
  implements ev
{
  public final String a = "token_conf";
  public long b = 1L;
  public int c = 1;
  public byte[] d = null;
  private int e = 11;
  
  public ev a(Cursor paramCursor)
  {
    ew localew = new ew();
    localew.b = paramCursor.getLong(paramCursor.getColumnIndex("plusTime"));
    localew.c = paramCursor.getInt(paramCursor.getColumnIndex("tokenIntVTime"));
    localew.d = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    return localew;
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("plusTime", Long.valueOf(paramLong));
    localContentValues.put("tokenIntVTime", Integer.valueOf(paramInt));
    localContentValues.put("data", paramArrayOfByte);
    et.a(this, "token_conf", localContentValues, "key=?", new String[] { String.valueOf(this.e) });
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS token_conf(_ID INTEGER PRIMARY KEY autoincrement,key INTEGER,plusTime INTEGER,tokenIntVTime INTEGER,data BLOB);");
  }
  
  public boolean a()
  {
    ew localew = (ew)et.a(this, "token_conf", new String[] { "plusTime", "tokenIntVTime", "data" }, null, null);
    if (localew == null) {
      return false;
    }
    this.b = localew.b;
    this.c = localew.c;
    this.d = localew.d;
    return true;
  }
  
  public long b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    new ContentValues();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", Integer.valueOf(this.e));
    localContentValues.put("plusTime", Long.valueOf(this.b));
    localContentValues.put("tokenIntVTime", Integer.valueOf(this.c));
    localContentValues.put("data", this.d);
    return paramSQLiteDatabase.insert("token_conf", null, localContentValues);
  }
  
  public String b()
  {
    return "token_conf";
  }
  
  public ContentValues c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ew
 * JD-Core Version:    0.7.0.1
 */