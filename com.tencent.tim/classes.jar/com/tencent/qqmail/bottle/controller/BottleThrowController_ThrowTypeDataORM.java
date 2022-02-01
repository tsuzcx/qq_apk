package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_ThrowTypeDataORM
{
  public static BottleThrowController.ThrowTypeData fill(Cursor paramCursor, BottleThrowController.ThrowTypeData paramThrowTypeData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.ThrowTypeData localThrowTypeData = paramThrowTypeData;
    if (paramThrowTypeData == null) {
      localThrowTypeData = new BottleThrowController.ThrowTypeData();
    }
    localThrowTypeData.bottleId = paramCursor.getString(0);
    localThrowTypeData.throwType = paramCursor.getInt(1);
    return localThrowTypeData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,throwtype from bottlethrow  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.ThrowTypeData paramThrowTypeData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlethrow(bottleid,throwtype) VALUES (?,?)", new Object[] { paramThrowTypeData.bottleId, Integer.valueOf(paramThrowTypeData.throwType) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.ThrowTypeData paramThrowTypeData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_ThrowTypeDataORM
 * JD-Core Version:    0.7.0.1
 */