package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowTable
{
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_CITY = "city";
  public static final String FIELD_GEO = "geo";
  public static final String FIELD_THROW_TYPE = "throwtype";
  public static final String FULL_FIELD_BOTTLE_ID = "bottlethrow.bottleid";
  public static final String FULL_FIELD_CITY = "bottlethrow.city";
  public static final String FULL_FIELD_GEO = "bottlethrow.geo";
  public static final String FULL_FIELD_THROW_TYPE = "bottlethrow.throwtype";
  public static final String TABLE_NAME = "bottlethrow";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottlethrow(bottleid VARCHAR, geo VARCHAR, city VARCHAR, throwtype INTEGER, PRIMARY KEY(bottleid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottlethrow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleThrowTable
 * JD-Core Version:    0.7.0.1
 */