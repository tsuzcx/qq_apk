package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_ConversationUnreadDataORM
{
  public static BottleThrowController.ConversationUnreadData fill(Cursor paramCursor, BottleThrowController.ConversationUnreadData paramConversationUnreadData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.ConversationUnreadData localConversationUnreadData = paramConversationUnreadData;
    if (paramConversationUnreadData == null) {
      localConversationUnreadData = new BottleThrowController.ConversationUnreadData();
    }
    localConversationUnreadData.bottleId = paramCursor.getString(0);
    localConversationUnreadData.msgId = paramCursor.getString(1);
    localConversationUnreadData.unread = paramCursor.getInt(2);
    return localConversationUnreadData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,msgid,unsend from bottleconv  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.ConversationUnreadData paramConversationUnreadData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottleconv(bottleid,msgid,unsend) VALUES (?,?,?)", new Object[] { paramConversationUnreadData.bottleId, paramConversationUnreadData.msgId, Integer.valueOf(paramConversationUnreadData.unread) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.ConversationUnreadData paramConversationUnreadData)
  {
    paramSQLiteDatabase.execSQL("UPDATE bottleconv SET unsend=? WHERE bottleid=? AND msgid=?", new Object[] { Integer.valueOf(paramConversationUnreadData.unread), paramConversationUnreadData.bottleId, paramConversationUnreadData.msgId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_ConversationUnreadDataORM
 * JD-Core Version:    0.7.0.1
 */