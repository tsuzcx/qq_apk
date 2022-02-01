package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListTableDataORM
{
  public static BottleListTableData fill(Cursor paramCursor, BottleListTableData paramBottleListTableData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleListTableData localBottleListTableData = paramBottleListTableData;
    if (paramBottleListTableData == null) {
      localBottleListTableData = new BottleListTableData();
    }
    localBottleListTableData.bottleid = paramCursor.getString(0);
    localBottleListTableData.unreadCnt = paramCursor.getInt(1);
    localBottleListTableData.summary = paramCursor.getString(2);
    localBottleListTableData.displaysummary = paramCursor.getString(3);
    localBottleListTableData.emoji = paramCursor.getString(4);
    localBottleListTableData.time = paramCursor.getLong(5);
    localBottleListTableData.type = paramCursor.getInt(6);
    localBottleListTableData.geo = paramCursor.getString(7);
    localBottleListTableData.city = paramCursor.getString(8);
    localBottleListTableData.distance = paramCursor.getInt(9);
    if (paramCursor.getInt(10) != 0) {}
    for (;;)
    {
      localBottleListTableData.isMine = bool;
      localBottleListTableData.uin = paramCursor.getString(11);
      return localBottleListTableData;
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
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleListTableData paramBottleListTableData)
  {
    int i = 1;
    String str1 = paramBottleListTableData.bottleid;
    int j = paramBottleListTableData.unreadCnt;
    String str2 = paramBottleListTableData.summary;
    String str3 = paramBottleListTableData.displaysummary;
    String str4 = paramBottleListTableData.emoji;
    long l = paramBottleListTableData.time;
    int k = paramBottleListTableData.type;
    String str5 = paramBottleListTableData.geo;
    String str6 = paramBottleListTableData.city;
    int m = paramBottleListTableData.distance;
    if (paramBottleListTableData.isMine) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottlelist(bottleid,unreadCnt,summary,displaysummary,emoji,time,type,geo,city,distance,isMine,uin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { str1, Integer.valueOf(j), str2, str3, str4, Long.valueOf(l), Integer.valueOf(k), str5, str6, Integer.valueOf(m), Integer.valueOf(i), paramBottleListTableData.uin });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleListTableData paramBottleListTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListTableDataORM
 * JD-Core Version:    0.7.0.1
 */