package com.tencent.token;

import android.content.Context;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.kingkong.database.SQLiteOpenHelper;

public final class gh
  extends SQLiteOpenHelper
{
  Context a;
  
  gh(Context paramContext, String paramString, int paramInt) {}
  
  protected final void finalize()
  {
    try
    {
      close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gh
 * JD-Core Version:    0.7.0.1
 */