package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowTableDataORM
{
  public static BottleThrowTableData fill(Cursor paramCursor, BottleThrowTableData paramBottleThrowTableData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowTableData localBottleThrowTableData = paramBottleThrowTableData;
    if (paramBottleThrowTableData == null) {
      localBottleThrowTableData = new BottleThrowTableData();
    }
    localBottleThrowTableData.bottleid = paramCursor.getString(0);
    localBottleThrowTableData.geo = paramCursor.getString(1);
    localBottleThrowTableData.city = paramCursor.getString(2);
    localBottleThrowTableData.throwtype = paramCursor.getInt(3);
    return localBottleThrowTableData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,geo,city,throwtype from bottlethrow  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowTableData paramBottleThrowTableData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottlethrow(bottleid,geo,city,throwtype) VALUES (?,?,?,?)", new Object[] { paramBottleThrowTableData.bottleid, paramBottleThrowTableData.geo, paramBottleThrowTableData.city, Integer.valueOf(paramBottleThrowTableData.throwtype) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowTableData paramBottleThrowTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleThrowTableDataORM
 * JD-Core Version:    0.7.0.1
 */