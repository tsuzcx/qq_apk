package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_UnsendConversationDataORM
{
  public static BottleThrowController.UnsendConversationData fill(Cursor paramCursor, BottleThrowController.UnsendConversationData paramUnsendConversationData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.UnsendConversationData localUnsendConversationData = paramUnsendConversationData;
    if (paramUnsendConversationData == null) {
      localUnsendConversationData = new BottleThrowController.UnsendConversationData();
    }
    localUnsendConversationData.bottleId = paramCursor.getString(0);
    localUnsendConversationData.content = paramCursor.getString(1);
    localUnsendConversationData.geo = paramCursor.getString(2);
    localUnsendConversationData.city = paramCursor.getString(3);
    return localUnsendConversationData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleconv.bottleid,bottleconv.content,bottlethrow.geo,bottlethrow.city  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.UnsendConversationData paramUnsendConversationData)
  {
    throw new UnsupportedOperationException("multi table");
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.UnsendConversationData paramUnsendConversationData)
  {
    throw new UnsupportedOperationException("multi table");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_UnsendConversationDataORM
 * JD-Core Version:    0.7.0.1
 */