package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_BottleListExtraDataORM
{
  public static BottleConversationController.BottleListExtraData fill(Cursor paramCursor, BottleConversationController.BottleListExtraData paramBottleListExtraData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.BottleListExtraData localBottleListExtraData = paramBottleListExtraData;
    if (paramBottleListExtraData == null) {
      localBottleListExtraData = new BottleConversationController.BottleListExtraData();
    }
    localBottleListExtraData.bottleId = paramCursor.getString(0);
    localBottleListExtraData.total = paramCursor.getInt(1);
    localBottleListExtraData.svnTime = paramCursor.getLong(2);
    if (paramCursor.getInt(3) != 0) {}
    for (;;)
    {
      localBottleListExtraData.convOverdue = bool;
      localBottleListExtraData.dbTimeStamp = paramCursor.getLong(4);
      return localBottleListExtraData;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,total,convsvrtime,convoverdue,convdbtimestamp from bottlelistextra  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BottleListExtraData paramBottleListExtraData)
  {
    int i = 1;
    String str = paramBottleListExtraData.bottleId;
    int j = paramBottleListExtraData.total;
    long l = paramBottleListExtraData.svnTime;
    if (paramBottleListExtraData.convOverdue) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,total,convsvrtime,convoverdue,convdbtimestamp) VALUES (?,?,?,?,?)", new Object[] { str, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Long.valueOf(paramBottleListExtraData.dbTimeStamp) });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.BottleListExtraData paramBottleListExtraData)
  {
    int i = 1;
    int j = paramBottleListExtraData.total;
    long l = paramBottleListExtraData.svnTime;
    if (paramBottleListExtraData.convOverdue) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("UPDATE bottlelistextra SET total=?, convsvrtime=?, convoverdue=?, convdbtimestamp=? WHERE bottleid=?", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Long.valueOf(paramBottleListExtraData.dbTimeStamp), paramBottleListExtraData.bottleId });
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_BottleListExtraDataORM
 * JD-Core Version:    0.7.0.1
 */