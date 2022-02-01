package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleBeachTable
{
  public static final String FIELD_ADURL = "adurl";
  public static final String FIELD_BOTTLER_UIN = "uin";
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_CITY = "city";
  public static final String FIELD_CONTENT = "content";
  public static final String FIELD_CONTENT_HEADER = "contentheader";
  public static final String FIELD_CONVERSAION_SVR_TIME = "convsvrtime";
  public static final String FIELD_DISPLAY_CONTENT = "displaycontent";
  public static final String FIELD_DISPLAY_CONTENT_EMOJI = "emoji";
  public static final String FIELD_DISTANCE = "distance";
  public static final String FIELD_GEO = "geo";
  public static final String FIELD_IMAGE_URL = "imageurl";
  public static final String FIELD_NUMBER = "number";
  public static final String FIELD_SUBJECT = "subject";
  public static final String FIELD_TAG_COLOR = "tagcolor";
  public static final String FIELD_TIME = "time";
  public static final String FIELD_TYPE = "type";
  public static final String FULL_FIELD_ADURL = "beachbottle.adurl";
  public static final String FULL_FIELD_BOTTLER_UIN = "beachbottle.uin";
  public static final String FULL_FIELD_BOTTLE_ID = "beachbottle.bottleid";
  public static final String FULL_FIELD_CITY = "beachbottle.city";
  public static final String FULL_FIELD_CONTENT = "beachbottle.content";
  public static final String FULL_FIELD_CONTENT_HEADER = "beachbottle.contentheader";
  public static final String FULL_FIELD_CONVERSAION_SVR_TIME = "beachbottle.convsvrtime";
  public static final String FULL_FIELD_DISPLAY_CONTENT = "beachbottle.displaycontent";
  public static final String FULL_FIELD_DISPLAY_CONTENT_EMOJI = "beachbottle.emoji";
  public static final String FULL_FIELD_DISTANCE = "beachbottle.distance";
  public static final String FULL_FIELD_GEO = "beachbottle.geo";
  public static final String FULL_FIELD_IMAGE_URL = "beachbottle.imageurl";
  public static final String FULL_FIELD_NUMBER = "beachbottle.number";
  public static final String FULL_FIELD_SUBJECT = "beachbottle.subject";
  public static final String FULL_FIELD_TAG_COLOR = "beachbottle.tagcolor";
  public static final String FULL_FIELD_TIME = "beachbottle.time";
  public static final String FULL_FIELD_TYPE = "beachbottle.type";
  public static final String TABLE_NAME = "beachbottle";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS beachbottle(bottleid VARCHAR, type INTEGER, subject VARCHAR, time INTEGER, geo VARCHAR, city VARCHAR, distance INTEGER, contentheader VARCHAR, content VARCHAR, displaycontent VARCHAR, emoji VARCHAR, imageurl VARCHAR, number INTEGER, uin VARCHAR, convsvrtime INTEGER, tagcolor INTEGER, adurl VARCHAR, PRIMARY KEY(bottleid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS beachbottle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleBeachTable
 * JD-Core Version:    0.7.0.1
 */