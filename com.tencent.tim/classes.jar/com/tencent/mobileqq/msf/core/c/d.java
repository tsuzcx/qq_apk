package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class d
  extends SQLiteOpenHelper
{
  private static final String a = "monitor.db";
  private static int b = 6;
  private static String c = "create table dataflow(_id INTEGER PRIMARY KEY,processName CHAR(50),uin CHAR(20) NOT NULL,ip CHAR(20) NOT NULL,refer CHAR(50),port INTEGER NOT NULL,flag INTEGER NOT NULL,buffersize LONG NOT NULL,networktype INTEGER NOT NULL,mType CHAR NOT NULL,curtime LONG NOT NULL,status Byte NOT NULL)";
  private static String d = "create table dataflow_rdm(_id INTEGER PRIMARY KEY,uin CHAR(20) NOT NULL,flag INTEGER NOT NULL,buffersize LONG NOT NULL,networktype INTEGER NOT NULL,mType CHAR NOT NULL,data CHAR NOT NULL)";
  
  public d(Context paramContext)
  {
    super(paramContext, "monitor.db", null, b);
  }
  
  public static final d a()
  {
    return a.a();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(c);
    paramSQLiteDatabase.execSQL(d);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table dataflow");
    paramSQLiteDatabase.execSQL("drop table dataflow_rdm");
    paramSQLiteDatabase.execSQL(c);
    paramSQLiteDatabase.execSQL(d);
  }
  
  static class a
  {
    private static final d a = new d(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.d
 * JD-Core Version:    0.7.0.1
 */