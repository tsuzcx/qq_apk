package com.tencent.biz.common.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper
  extends SQLiteOpenHelper
{
  public DBHelper(Context paramContext)
  {
    super(paramContext, "offline_download.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table download_info(_id integer PRIMARY KEY AUTOINCREMENT, thread_id integer, start_pos integer, end_pos integer, compelete_size integer,url char)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.download.DBHelper
 * JD-Core Version:    0.7.0.1
 */