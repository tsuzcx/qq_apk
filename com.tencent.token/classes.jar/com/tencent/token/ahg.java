package com.tencent.token;

import android.content.ContentValues;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ahg
  implements ahk
{
  public String a;
  public String b;
  
  public final ahk a(afx paramafx)
  {
    ahg localahg = new ahg();
    localahg.a = paramafx.getString(paramafx.getColumnIndex("uinhash"));
    localahg.b = paramafx.getString(paramafx.getColumnIndex("filename"));
    return localahg;
  }
  
  public final String a()
  {
    return "qqface";
  }
  
  public final void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.b("CREATE TABLE IF NOT EXISTS qqface(uinhash TEXT PRIMARY KEY,filename TEXT);");
  }
  
  public final long b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.b("CREATE TABLE IF NOT EXISTS qqface(uinhash TEXT PRIMARY KEY,filename TEXT);");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uinhash", this.a);
    localContentValues.put("filename", this.b);
    return paramSQLiteDatabase.a("qqface", localContentValues);
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
 * Qualified Name:     com.tencent.token.ahg
 * JD-Core Version:    0.7.0.1
 */