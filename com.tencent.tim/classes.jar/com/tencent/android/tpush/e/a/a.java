package com.tencent.android.tpush.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.android.tpush.logging.TLogger;

public class a
  extends SQLiteOpenHelper
{
  public a(Context paramContext)
  {
    super(paramContext, "xg_message_vip.db", null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE messagetoshow (_id INTEGER PRIMARY KEY AUTOINCREMENT, msgid INTEGER, message TEXT, time INTEGER, busiid INTEGER, showedtime INTEGER, status INTEGER, UNIQUE (msgid) ON CONFLICT IGNORE);");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    TLogger.d("MessageInfoDBHelper", "action - onCreate");
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    TLogger.d("MessageInfoDBHelper", "action - onUpgrade");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.e.a.a
 * JD-Core Version:    0.7.0.1
 */