package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleBeachController_BeachBottleInfoORM
{
  public static BottleBeachController.BeachBottleInfo fill(Cursor paramCursor, BottleBeachController.BeachBottleInfo paramBeachBottleInfo)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleBeachController.BeachBottleInfo localBeachBottleInfo = paramBeachBottleInfo;
    if (paramBeachBottleInfo == null) {
      localBeachBottleInfo = new BottleBeachController.BeachBottleInfo();
    }
    localBeachBottleInfo.bottleId = paramCursor.getString(0);
    localBeachBottleInfo.uin = paramCursor.getString(1);
    return localBeachBottleInfo;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,uin from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleBeachController.BeachBottleInfo paramBeachBottleInfo)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,uin) VALUES (?,?)", new Object[] { paramBeachBottleInfo.bottleId, paramBeachBottleInfo.uin });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleBeachController.BeachBottleInfo paramBeachBottleInfo)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController_BeachBottleInfoORM
 * JD-Core Version:    0.7.0.1
 */