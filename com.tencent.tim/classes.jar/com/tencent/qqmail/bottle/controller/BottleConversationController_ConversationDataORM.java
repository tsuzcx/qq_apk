package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_ConversationDataORM
{
  public static BottleConversationController.ConversationData fill(Cursor paramCursor, BottleConversationController.ConversationData paramConversationData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.ConversationData localConversationData = paramConversationData;
    if (paramConversationData == null) {
      localConversationData = new BottleConversationController.ConversationData();
    }
    localConversationData.bottleId = paramCursor.getString(0);
    localConversationData.time = paramCursor.getLong(1);
    return localConversationData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,time from bottleconv  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ConversationData paramConversationData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottleconv(bottleid,time) VALUES (?,?)", new Object[] { paramConversationData.bottleId, Long.valueOf(paramConversationData.time) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.ConversationData paramConversationData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_ConversationDataORM
 * JD-Core Version:    0.7.0.1
 */