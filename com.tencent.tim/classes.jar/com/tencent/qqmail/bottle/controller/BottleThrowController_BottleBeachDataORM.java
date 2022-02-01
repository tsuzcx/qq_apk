package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleThrowController_BottleBeachDataORM
{
  public static BottleThrowController.BottleBeachData fill(Cursor paramCursor, BottleThrowController.BottleBeachData paramBottleBeachData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleThrowController.BottleBeachData localBottleBeachData = paramBottleBeachData;
    if (paramBottleBeachData == null) {
      localBottleBeachData = new BottleThrowController.BottleBeachData();
    }
    localBottleBeachData.bottleid = paramCursor.getString(0);
    localBottleBeachData.type = paramCursor.getInt(1);
    localBottleBeachData.subject = paramCursor.getString(2);
    localBottleBeachData.time = paramCursor.getLong(3);
    localBottleBeachData.geo = paramCursor.getString(4);
    localBottleBeachData.city = paramCursor.getString(5);
    localBottleBeachData.distance = paramCursor.getInt(6);
    localBottleBeachData.contentheader = paramCursor.getString(7);
    localBottleBeachData.content = paramCursor.getString(8);
    localBottleBeachData.displaycontent = paramCursor.getString(9);
    localBottleBeachData.emoji = paramCursor.getString(10);
    localBottleBeachData.imageurl = paramCursor.getString(11);
    localBottleBeachData.number = paramCursor.getInt(12);
    localBottleBeachData.uin = paramCursor.getString(13);
    localBottleBeachData.convsvrtime = paramCursor.getLong(14);
    return localBottleBeachData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,type,subject,time,geo,city,distance,contentheader,content,displaycontent,emoji,imageurl,number,uin,convsvrtime from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleBeachData paramBottleBeachData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,type,subject,time,geo,city,distance,contentheader,content,displaycontent,emoji,imageurl,number,uin,convsvrtime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { paramBottleBeachData.bottleid, Integer.valueOf(paramBottleBeachData.type), paramBottleBeachData.subject, Long.valueOf(paramBottleBeachData.time), paramBottleBeachData.geo, paramBottleBeachData.city, Integer.valueOf(paramBottleBeachData.distance), paramBottleBeachData.contentheader, paramBottleBeachData.content, paramBottleBeachData.displaycontent, paramBottleBeachData.emoji, paramBottleBeachData.imageurl, Integer.valueOf(paramBottleBeachData.number), paramBottleBeachData.uin, Long.valueOf(paramBottleBeachData.convsvrtime) });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleThrowController.BottleBeachData paramBottleBeachData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController_BottleBeachDataORM
 * JD-Core Version:    0.7.0.1
 */