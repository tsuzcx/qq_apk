package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_ListBottlerDataORM
{
  public static BottleConversationController.ListBottlerData fill(Cursor paramCursor, BottleConversationController.ListBottlerData paramListBottlerData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.ListBottlerData localListBottlerData = paramListBottlerData;
    if (paramListBottlerData == null) {
      localListBottlerData = new BottleConversationController.ListBottlerData();
    }
    localListBottlerData.bottleId = paramCursor.getString(0);
    localListBottlerData.uin = paramCursor.getString(1);
    localListBottlerData.time = paramCursor.getLong(2);
    localListBottlerData.type = paramCursor.getInt(3);
    localListBottlerData.unreadCnt = paramCursor.getInt(4);
    return localListBottlerData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,uin,time,type,unreadCnt from bottlelist  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ListBottlerData paramListBottlerData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelist(bottleid,uin,time,type,unreadCnt) VALUES (?,?,?,?,?)", new Object[] { paramListBottlerData.bottleId, paramListBottlerData.uin, Long.valueOf(paramListBottlerData.time), Integer.valueOf(paramListBottlerData.type), Integer.valueOf(paramListBottlerData.unreadCnt) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ListBottlerData paramListBottlerData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_ListBottlerDataORM
 * JD-Core Version:    0.7.0.1
 */