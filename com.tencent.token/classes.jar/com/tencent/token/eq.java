package com.tencent.token;

import android.content.Context;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteOpenHelper;

public class eq
  extends SQLiteOpenHelper
{
  Context a;
  
  eq(Context paramContext, String paramString, int paramInt, SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    super(paramContext, a(paramInt), paramString.getBytes(), paramSQLiteCipherSpec, null, 1, new eo());
    this.a = paramContext;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "mobiletoken.db";
    case 3: 
      return "mobiletoken_gray.db";
    case 2: 
      return "mobiletoken_exp.db";
    case 1: 
      return "mobiletoken.db";
    }
    return "mobiletoken_test.db";
  }
  
  protected void finalize()
  {
    try
    {
      close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eq
 * JD-Core Version:    0.7.0.1
 */