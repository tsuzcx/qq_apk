package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleManager_UpdateConversationTotalORM
{
  public static BottleManager.UpdateConversationTotal fill(Cursor paramCursor, BottleManager.UpdateConversationTotal paramUpdateConversationTotal)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleManager.UpdateConversationTotal localUpdateConversationTotal = paramUpdateConversationTotal;
    if (paramUpdateConversationTotal == null) {
      localUpdateConversationTotal = new BottleManager.UpdateConversationTotal();
    }
    localUpdateConversationTotal.bottleId = paramCursor.getString(0);
    localUpdateConversationTotal.total = paramCursor.getInt(1);
    return localUpdateConversationTotal;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,total from bottlelistextra  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleManager.UpdateConversationTotal paramUpdateConversationTotal)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,total) VALUES (?,?)", new Object[] { paramUpdateConversationTotal.bottleId, Integer.valueOf(paramUpdateConversationTotal.total) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleManager.UpdateConversationTotal paramUpdateConversationTotal)
  {
    paramSQLiteDatabase.execSQL("UPDATE bottlelistextra SET total=? WHERE bottleid=?", new Object[] { Integer.valueOf(paramUpdateConversationTotal.total), paramUpdateConversationTotal.bottleId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager_UpdateConversationTotalORM
 * JD-Core Version:    0.7.0.1
 */