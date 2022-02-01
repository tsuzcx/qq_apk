package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListController_ListBottleInfoORM
{
  public static BottleListController.ListBottleInfo fill(Cursor paramCursor, BottleListController.ListBottleInfo paramListBottleInfo)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleListController.ListBottleInfo localListBottleInfo = paramListBottleInfo;
    if (paramListBottleInfo == null) {
      localListBottleInfo = new BottleListController.ListBottleInfo();
    }
    localListBottleInfo.bottleId = paramCursor.getString(0);
    localListBottleInfo.uin = paramCursor.getString(1);
    localListBottleInfo.unreadCnt = paramCursor.getInt(2);
    return localListBottleInfo;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,uin,unreadCnt from bottlelist  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleListController.ListBottleInfo paramListBottleInfo)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelist(bottleid,uin,unreadCnt) VALUES (?,?,?)", new Object[] { paramListBottleInfo.bottleId, paramListBottleInfo.uin, Integer.valueOf(paramListBottleInfo.unreadCnt) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleListController.ListBottleInfo paramListBottleInfo)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController_ListBottleInfoORM
 * JD-Core Version:    0.7.0.1
 */