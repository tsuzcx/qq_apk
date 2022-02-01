package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListExtraTable
{
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_CONVERSAION_SVR_TIME = "convsvrtime";
  public static final String FIELD_CONVERSATION_DB_TIMESTAMP = "convdbtimestamp";
  public static final String FIELD_CONVERSATION_OVERDUE = "convoverdue";
  public static final String FIELD_TOTAL = "total";
  public static final String FULL_FIELD_BOTTLE_ID = "bottlelistextra.bottleid";
  public static final String FULL_FIELD_CONVERSAION_SVR_TIME = "bottlelistextra.convsvrtime";
  public static final String FULL_FIELD_CONVERSATION_DB_TIMESTAMP = "bottlelistextra.convdbtimestamp";
  public static final String FULL_FIELD_CONVERSATION_OVERDUE = "bottlelistextra.convoverdue";
  public static final String FULL_FIELD_TOTAL = "bottlelistextra.total";
  public static final String TABLE_NAME = "bottlelistextra";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottlelistextra(bottleid VARCHAR, total INTEGER, convsvrtime INTEGER, convoverdue INTEGER, convdbtimestamp INTEGER, PRIMARY KEY(bottleid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottlelistextra");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListExtraTable
 * JD-Core Version:    0.7.0.1
 */