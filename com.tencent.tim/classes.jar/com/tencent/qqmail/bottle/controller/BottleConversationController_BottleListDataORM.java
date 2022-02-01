package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_BottleListDataORM
{
  public static BottleConversationController.BottleListData fill(Cursor paramCursor, BottleConversationController.BottleListData paramBottleListData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.BottleListData localBottleListData = paramBottleListData;
    if (paramBottleListData == null) {
      localBottleListData = new BottleConversationController.BottleListData();
    }
    localBottleListData.bottleId = paramCursor.getString(0);
    localBottleListData.unreadCnt = paramCursor.getInt(1);
    localBottleListData.uin = paramCursor.getString(2);
    return localBottleListData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,unreadCnt,uin from bottlelist  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BottleListData paramBottleListData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelist(bottleid,unreadCnt,uin) VALUES (?,?,?)", new Object[] { paramBottleListData.bottleId, Integer.valueOf(paramBottleListData.unreadCnt), paramBottleListData.uin });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BottleListData paramBottleListData)
  {
    paramSQLiteDatabase.execSQL("UPDATE bottlelist SET unreadCnt=?, uin=? WHERE bottleid=?", new Object[] { Integer.valueOf(paramBottleListData.unreadCnt), paramBottleListData.uin, paramBottleListData.bottleId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_BottleListDataORM
 * JD-Core Version:    0.7.0.1
 */