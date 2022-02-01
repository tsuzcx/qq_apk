package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_QueryFirstMessageORM
{
  public static BottleConversationController.QueryFirstMessage fill(Cursor paramCursor, BottleConversationController.QueryFirstMessage paramQueryFirstMessage)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.QueryFirstMessage localQueryFirstMessage = paramQueryFirstMessage;
    if (paramQueryFirstMessage == null) {
      localQueryFirstMessage = new BottleConversationController.QueryFirstMessage();
    }
    localQueryFirstMessage.bottleId = paramCursor.getString(0);
    localQueryFirstMessage.msgId = paramCursor.getString(1);
    return localQueryFirstMessage;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,msgid from bottleconv  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.QueryFirstMessage paramQueryFirstMessage)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottleconv(bottleid,msgid) VALUES (?,?)", new Object[] { paramQueryFirstMessage.bottleId, paramQueryFirstMessage.msgId });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.QueryFirstMessage paramQueryFirstMessage)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_QueryFirstMessageORM
 * JD-Core Version:    0.7.0.1
 */