package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListExtraTableDataORM
{
  public static BottleListExtraTableData fill(Cursor paramCursor, BottleListExtraTableData paramBottleListExtraTableData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleListExtraTableData localBottleListExtraTableData = paramBottleListExtraTableData;
    if (paramBottleListExtraTableData == null) {
      localBottleListExtraTableData = new BottleListExtraTableData();
    }
    localBottleListExtraTableData.bottleid = paramCursor.getString(0);
    localBottleListExtraTableData.total = paramCursor.getInt(1);
    localBottleListExtraTableData.convsvrtime = paramCursor.getLong(2);
    if (paramCursor.getInt(3) != 0) {}
    for (;;)
    {
      localBottleListExtraTableData.convoverdue = bool;
      localBottleListExtraTableData.convdbtimestamp = paramCursor.getLong(4);
      return localBottleListExtraTableData;
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
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleListExtraTableData paramBottleListExtraTableData)
  {
    int i = 1;
    String str = paramBottleListExtraTableData.bottleid;
    int j = paramBottleListExtraTableData.total;
    long l = paramBottleListExtraTableData.convsvrtime;
    if (paramBottleListExtraTableData.convoverdue) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottlelistextra(bottleid,total,convsvrtime,convoverdue,convdbtimestamp) VALUES (?,?,?,?,?)", new Object[] { str, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Long.valueOf(paramBottleListExtraTableData.convdbtimestamp) });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleListExtraTableData paramBottleListExtraTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListExtraTableDataORM
 * JD-Core Version:    0.7.0.1
 */