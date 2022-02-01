package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_BottleListExtraAllDataORM
{
  public static BottleThrowController.BottleListExtraAllData fill(Cursor paramCursor, BottleThrowController.BottleListExtraAllData paramBottleListExtraAllData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.BottleListExtraAllData localBottleListExtraAllData = paramBottleListExtraAllData;
    if (paramBottleListExtraAllData == null) {
      localBottleListExtraAllData = new BottleThrowController.BottleListExtraAllData();
    }
    localBottleListExtraAllData.bottleid = paramCursor.getString(0);
    localBottleListExtraAllData.total = paramCursor.getInt(1);
    localBottleListExtraAllData.convsvrtime = paramCursor.getLong(2);
    if (paramCursor.getInt(3) != 0) {}
    for (;;)
    {
      localBottleListExtraAllData.convoverdue = bool;
      localBottleListExtraAllData.convdbtimestamp = paramCursor.getLong(4);
      return localBottleListExtraAllData;
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
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListExtraAllData paramBottleListExtraAllData)
  {
    int i = 1;
    String str = paramBottleListExtraAllData.bottleid;
    int j = paramBottleListExtraAllData.total;
    long l = paramBottleListExtraAllData.convsvrtime;
    if (paramBottleListExtraAllData.convoverdue) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,total,convsvrtime,convoverdue,convdbtimestamp) VALUES (?,?,?,?,?)", new Object[] { str, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Long.valueOf(paramBottleListExtraAllData.convdbtimestamp) });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleListExtraAllData paramBottleListExtraAllData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_BottleListExtraAllDataORM
 * JD-Core Version:    0.7.0.1
 */