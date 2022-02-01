package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_GeneralBeachInfoDataORM
{
  public static BottleConversationController.GeneralBeachInfoData fill(Cursor paramCursor, BottleConversationController.GeneralBeachInfoData paramGeneralBeachInfoData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.GeneralBeachInfoData localGeneralBeachInfoData = paramGeneralBeachInfoData;
    if (paramGeneralBeachInfoData == null) {
      localGeneralBeachInfoData = new BottleConversationController.GeneralBeachInfoData();
    }
    localGeneralBeachInfoData.bottleId = paramCursor.getString(0);
    localGeneralBeachInfoData.city = paramCursor.getString(1);
    localGeneralBeachInfoData.distance = paramCursor.getInt(2);
    localGeneralBeachInfoData.svnTime = paramCursor.getLong(3);
    localGeneralBeachInfoData.uin = paramCursor.getString(4);
    return localGeneralBeachInfoData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,city,distance,convsvrtime,uin from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.GeneralBeachInfoData paramGeneralBeachInfoData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,city,distance,convsvrtime,uin) VALUES (?,?,?,?,?)", new Object[] { paramGeneralBeachInfoData.bottleId, paramGeneralBeachInfoData.city, Integer.valueOf(paramGeneralBeachInfoData.distance), Long.valueOf(paramGeneralBeachInfoData.svnTime), paramGeneralBeachInfoData.uin });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.GeneralBeachInfoData paramGeneralBeachInfoData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_GeneralBeachInfoDataORM
 * JD-Core Version:    0.7.0.1
 */