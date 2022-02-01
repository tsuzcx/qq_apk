package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleDraftTable
{
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_DRAFT = "draft";
  public static final String FULL_FIELD_BOTTLE_ID = "bottledraft.bottleid";
  public static final String FULL_FIELD_DRAFT = "bottledraft.draft";
  public static final String TABLE_NAME = "bottledraft";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottledraft(bottleid VARCHAR, draft VARCHAR, PRIMARY KEY(bottleid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottledraft");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleDraftTable
 * JD-Core Version:    0.7.0.1
 */