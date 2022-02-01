package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_BottleListOverdueDataORM
{
  public static BottleThrowController.BottleListOverdueData fill(Cursor paramCursor, BottleThrowController.BottleListOverdueData paramBottleListOverdueData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.BottleListOverdueData localBottleListOverdueData = paramBottleListOverdueData;
    if (paramBottleListOverdueData == null) {
      localBottleListOverdueData = new BottleThrowController.BottleListOverdueData();
    }
    localBottleListOverdueData.bottleId = paramCursor.getString(0);
    if (paramCursor.getInt(1) != 0) {}
    for (;;)
    {
      localBottleListOverdueData.convOverdue = bool;
      return localBottleListOverdueData;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,convoverdue from bottlelistextra  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListOverdueData paramBottleListOverdueData)
  {
    int i = 0;
    String str = paramBottleListOverdueData.bottleId;
    if (paramBottleListOverdueData.convOverdue) {
      i = 1;
    }
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,convoverdue) VALUES (?,?)", new Object[] { str, Integer.valueOf(i) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListOverdueData paramBottleListOverdueData)
  {
    if (paramBottleListOverdueData.convOverdue) {}
    for (int i = 1;; i = 0)
    {
      paramSQLiteDatabase.execSQL("UPDATE bottlelistextra SET convoverdue=? WHERE bottleid=?", new Object[] { Integer.valueOf(i), paramBottleListOverdueData.bottleId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_BottleListOverdueDataORM
 * JD-Core Version:    0.7.0.1
 */