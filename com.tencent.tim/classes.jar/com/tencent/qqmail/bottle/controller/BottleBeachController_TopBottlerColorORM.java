package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleBeachController_TopBottlerColorORM
{
  public static BottleBeachController.TopBottlerColor fill(Cursor paramCursor, BottleBeachController.TopBottlerColor paramTopBottlerColor)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleBeachController.TopBottlerColor localTopBottlerColor = paramTopBottlerColor;
    if (paramTopBottlerColor == null) {
      localTopBottlerColor = new BottleBeachController.TopBottlerColor();
    }
    localTopBottlerColor.bottleId = paramCursor.getString(0);
    localTopBottlerColor.tagColor = paramCursor.getInt(1);
    return localTopBottlerColor;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,tagcolor from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleBeachController.TopBottlerColor paramTopBottlerColor)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,tagcolor) VALUES (?,?)", new Object[] { paramTopBottlerColor.bottleId, Integer.valueOf(paramTopBottlerColor.tagColor) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleBeachController.TopBottlerColor paramTopBottlerColor)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController_TopBottlerColorORM
 * JD-Core Version:    0.7.0.1
 */