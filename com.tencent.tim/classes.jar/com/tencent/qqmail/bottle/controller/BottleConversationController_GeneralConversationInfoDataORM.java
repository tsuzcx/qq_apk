package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_GeneralConversationInfoDataORM
{
  public static BottleConversationController.GeneralConversationInfoData fill(Cursor paramCursor, BottleConversationController.GeneralConversationInfoData paramGeneralConversationInfoData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.GeneralConversationInfoData localGeneralConversationInfoData = paramGeneralConversationInfoData;
    if (paramGeneralConversationInfoData == null) {
      localGeneralConversationInfoData = new BottleConversationController.GeneralConversationInfoData();
    }
    localGeneralConversationInfoData.bottleId = paramCursor.getString(0);
    localGeneralConversationInfoData.city = paramCursor.getString(1);
    localGeneralConversationInfoData.distance = paramCursor.getInt(2);
    localGeneralConversationInfoData.uin = paramCursor.getString(3);
    localGeneralConversationInfoData.unread = paramCursor.getInt(4);
    localGeneralConversationInfoData.total = paramCursor.getInt(5);
    localGeneralConversationInfoData.svnTime = paramCursor.getLong(6);
    if (paramCursor.getInt(7) != 0) {}
    for (;;)
    {
      localGeneralConversationInfoData.convOverdue = bool;
      localGeneralConversationInfoData.dbTimeStamp = paramCursor.getLong(8);
      return localGeneralConversationInfoData;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottlelist.bottleid,bottlelist.city,bottlelist.distance,bottlelist.uin,bottlelist.unreadCnt,bottlelistextra.total,bottlelistextra.convsvrtime,bottlelistextra.convoverdue,bottlelistextra.convdbtimestamp  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.GeneralConversationInfoData paramGeneralConversationInfoData)
  {
    throw new UnsupportedOperationException("multi table");
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.GeneralConversationInfoData paramGeneralConversationInfoData)
  {
    throw new UnsupportedOperationException("multi table");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_GeneralConversationInfoDataORM
 * JD-Core Version:    0.7.0.1
 */