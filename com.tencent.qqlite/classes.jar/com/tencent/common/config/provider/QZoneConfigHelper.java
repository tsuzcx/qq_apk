package com.tencent.common.config.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class QZoneConfigHelper
  extends SQLiteOpenHelper
  implements QZoneConfigConst
{
  private static final String r = "QZoneConfigHelper";
  private static final String s = " CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL,second_key text  NOT NULL,value String,PRIMARY KEY (main_key,second_key))";
  private static final String t = " CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)";
  private static final String u = " CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)";
  private static final String v = " CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)";
  private static final String w = " CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)";
  
  public QZoneConfigHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_configs (main_key text  NOT NULL,second_key text  NOT NULL,value String,PRIMARY KEY (main_key,second_key))");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_cookie (name text PRIMARY KEY NOT NULL,cookie text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_update (name text PRIMARY KEY NOT NULL,updatelog text NOT NULL)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_isp_config (key text PRIMARY KEY NOT NULL,value text)");
    paramSQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS qz_check_time (name text PRIMARY KEY NOT NULL,check_time INTEGER NOT NULL)");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneConfigHelper", 2, "updating database from version " + paramInt1 + " to " + paramInt2);
    }
    paramSQLiteDatabase.execSQL("drop table if exists qz_configs");
    paramSQLiteDatabase.execSQL("drop table if exists qz_cookie");
    paramSQLiteDatabase.execSQL("drop table if exists qz_update");
    paramSQLiteDatabase.execSQL("drop table if exists qz_isp_config");
    paramSQLiteDatabase.execSQL("drop table if exists qz_check_time");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigHelper
 * JD-Core Version:    0.7.0.1
 */