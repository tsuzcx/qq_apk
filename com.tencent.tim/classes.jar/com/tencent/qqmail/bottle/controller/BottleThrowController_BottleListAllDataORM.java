package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_BottleListAllDataORM
{
  public static BottleThrowController.BottleListAllData fill(Cursor paramCursor, BottleThrowController.BottleListAllData paramBottleListAllData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.BottleListAllData localBottleListAllData = paramBottleListAllData;
    if (paramBottleListAllData == null) {
      localBottleListAllData = new BottleThrowController.BottleListAllData();
    }
    localBottleListAllData.bottleid = paramCursor.getString(0);
    localBottleListAllData.unreadCnt = paramCursor.getInt(1);
    localBottleListAllData.summary = paramCursor.getString(2);
    localBottleListAllData.displaysummary = paramCursor.getString(3);
    localBottleListAllData.emoji = paramCursor.getString(4);
    localBottleListAllData.time = paramCursor.getLong(5);
    localBottleListAllData.type = paramCursor.getInt(6);
    localBottleListAllData.geo = paramCursor.getString(7);
    localBottleListAllData.city = paramCursor.getString(8);
    localBottleListAllData.distance = paramCursor.getInt(9);
    if (paramCursor.getInt(10) != 0) {}
    for (;;)
    {
      localBottleListAllData.isMine = bool;
      localBottleListAllData.uin = paramCursor.getString(11);
      return localBottleListAllData;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,unreadCnt,summary,displaysummary,emoji,time,type,geo,city,distance,isMine,uin from bottlelist  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListAllData paramBottleListAllData)
  {
    int i = 1;
    String str1 = paramBottleListAllData.bottleid;
    int j = paramBottleListAllData.unreadCnt;
    String str2 = paramBottleListAllData.summary;
    String str3 = paramBottleListAllData.displaysummary;
    String str4 = paramBottleListAllData.emoji;
    long l = paramBottleListAllData.time;
    int k = paramBottleListAllData.type;
    String str5 = paramBottleListAllData.geo;
    String str6 = paramBottleListAllData.city;
    int m = paramBottleListAllData.distance;
    if (paramBottleListAllData.isMine) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottlelist(bottleid,unreadCnt,summary,displaysummary,emoji,time,type,geo,city,distance,isMine,uin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { str1, Integer.valueOf(j), str2, str3, str4, Long.valueOf(l), Integer.valueOf(k), str5, str6, Integer.valueOf(m), Integer.valueOf(i), paramBottleListAllData.uin });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListAllData paramBottleListAllData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_BottleListAllDataORM
 * JD-Core Version:    0.7.0.1
 */