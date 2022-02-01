package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_BeachBottlerDataORM
{
  public static BottleConversationController.BeachBottlerData fill(Cursor paramCursor, BottleConversationController.BeachBottlerData paramBeachBottlerData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.BeachBottlerData localBeachBottlerData = paramBeachBottlerData;
    if (paramBeachBottlerData == null) {
      localBeachBottlerData = new BottleConversationController.BeachBottlerData();
    }
    localBeachBottlerData.bottleId = paramCursor.getString(0);
    localBeachBottlerData.uin = paramCursor.getString(1);
    localBeachBottlerData.type = paramCursor.getInt(2);
    return localBeachBottlerData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,uin,type from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BeachBottlerData paramBeachBottlerData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,uin,type) VALUES (?,?,?)", new Object[] { paramBeachBottlerData.bottleId, paramBeachBottlerData.uin, Integer.valueOf(paramBeachBottlerData.type) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BeachBottlerData paramBeachBottlerData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_BeachBottlerDataORM
 * JD-Core Version:    0.7.0.1
 */