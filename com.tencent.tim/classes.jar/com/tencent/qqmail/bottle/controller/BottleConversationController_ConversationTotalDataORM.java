package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_ConversationTotalDataORM
{
  public static BottleConversationController.ConversationTotalData fill(Cursor paramCursor, BottleConversationController.ConversationTotalData paramConversationTotalData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.ConversationTotalData localConversationTotalData = paramConversationTotalData;
    if (paramConversationTotalData == null) {
      localConversationTotalData = new BottleConversationController.ConversationTotalData();
    }
    localConversationTotalData.bottleId = paramCursor.getString(0);
    localConversationTotalData.total = paramCursor.getInt(1);
    return localConversationTotalData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,total from bottlelistextra  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ConversationTotalData paramConversationTotalData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,total) VALUES (?,?)", new Object[] { paramConversationTotalData.bottleId, Integer.valueOf(paramConversationTotalData.total) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ConversationTotalData paramConversationTotalData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_ConversationTotalDataORM
 * JD-Core Version:    0.7.0.1
 */