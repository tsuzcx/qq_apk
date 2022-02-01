package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleDraftTableDataORM
{
  public static BottleDraftTableData fill(Cursor paramCursor, BottleDraftTableData paramBottleDraftTableData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleDraftTableData localBottleDraftTableData = paramBottleDraftTableData;
    if (paramBottleDraftTableData == null) {
      localBottleDraftTableData = new BottleDraftTableData();
    }
    localBottleDraftTableData.bottleid = paramCursor.getString(0);
    localBottleDraftTableData.draft = paramCursor.getString(1);
    return localBottleDraftTableData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,draft from bottledraft  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleDraftTableData paramBottleDraftTableData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottledraft(bottleid,draft) VALUES (?,?)", new Object[] { paramBottleDraftTableData.bottleid, paramBottleDraftTableData.draft });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleDraftTableData paramBottleDraftTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleDraftTableDataORM
 * JD-Core Version:    0.7.0.1
 */