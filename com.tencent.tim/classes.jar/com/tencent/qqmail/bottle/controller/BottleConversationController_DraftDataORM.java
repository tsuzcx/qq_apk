package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_DraftDataORM
{
  public static BottleConversationController.DraftData fill(Cursor paramCursor, BottleConversationController.DraftData paramDraftData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.DraftData localDraftData = paramDraftData;
    if (paramDraftData == null) {
      localDraftData = new BottleConversationController.DraftData();
    }
    localDraftData.bottleId = paramCursor.getString(0);
    localDraftData.draft = paramCursor.getString(1);
    return localDraftData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,draft from bottledraft  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.DraftData paramDraftData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottledraft(bottleid,draft) VALUES (?,?)", new Object[] { paramDraftData.bottleId, paramDraftData.draft });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.DraftData paramDraftData)
  {
    paramSQLiteDatabase.execSQL("UPDATE bottledraft SET draft=? WHERE bottleid=?", new Object[] { paramDraftData.draft, paramDraftData.bottleId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_DraftDataORM
 * JD-Core Version:    0.7.0.1
 */