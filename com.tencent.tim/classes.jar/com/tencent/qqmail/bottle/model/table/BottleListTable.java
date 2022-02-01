package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListTable
{
  public static final String FIELD_BOTTLER_UIN = "uin";
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_CITY = "city";
  public static final String FIELD_DISPLAY_SUMMARY = "displaysummary";
  public static final String FIELD_DISPLAY_SUMMARY_EMOJI = "emoji";
  public static final String FIELD_DISTANCE = "distance";
  public static final String FIELD_GEO = "geo";
  public static final String FIELD_ISMINE = "isMine";
  public static final String FIELD_SUMMARY = "summary";
  public static final String FIELD_TIME = "time";
  public static final String FIELD_TYPE = "type";
  public static final String FIELD_UNREAD_COUNT = "unreadCnt";
  public static final String FULL_FIELD_BOTTLER_UIN = "bottlelist.uin";
  public static final String FULL_FIELD_BOTTLE_ID = "bottlelist.bottleid";
  public static final String FULL_FIELD_CITY = "bottlelist.city";
  public static final String FULL_FIELD_DISPLAY_SUMMARY = "bottlelist.displaysummary";
  public static final String FULL_FIELD_DISPLAY_SUMMARY_EMOJI = "bottlelist.emoji";
  public static final String FULL_FIELD_DISTANCE = "bottlelist.distance";
  public static final String FULL_FIELD_GEO = "bottlelist.geo";
  public static final String FULL_FIELD_ISMINE = "bottlelist.isMine";
  public static final String FULL_FIELD_SUMMARY = "bottlelist.summary";
  public static final String FULL_FIELD_TIME = "bottlelist.time";
  public static final String FULL_FIELD_TYPE = "bottlelist.type";
  public static final String FULL_FIELD_UNREAD_COUNT = "bottlelist.unreadCnt";
  public static final String TABLE_NAME = "bottlelist";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottlelist(bottleid VARCHAR, unreadCnt INTEGER, summary VARCHAR, displaysummary VARCHAR, emoji VARCHAR, time INTEGER, type INTEGER, geo VARCHAR, city VARCHAR, distance INTEGER, isMine INTEGER, uin VARCHAR, PRIMARY KEY(bottleid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottlelist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListTable
 * JD-Core Version:    0.7.0.1
 */