package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleBeachTableDataORM
{
  public static BottleBeachTableData fill(Cursor paramCursor, BottleBeachTableData paramBottleBeachTableData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleBeachTableData localBottleBeachTableData = paramBottleBeachTableData;
    if (paramBottleBeachTableData == null) {
      localBottleBeachTableData = new BottleBeachTableData();
    }
    localBottleBeachTableData.bottleid = paramCursor.getString(0);
    localBottleBeachTableData.type = paramCursor.getInt(1);
    localBottleBeachTableData.subject = paramCursor.getString(2);
    localBottleBeachTableData.time = paramCursor.getLong(3);
    localBottleBeachTableData.geo = paramCursor.getString(4);
    localBottleBeachTableData.city = paramCursor.getString(5);
    localBottleBeachTableData.distance = paramCursor.getInt(6);
    localBottleBeachTableData.contentheader = paramCursor.getString(7);
    localBottleBeachTableData.content = paramCursor.getString(8);
    localBottleBeachTableData.displaycontent = paramCursor.getString(9);
    localBottleBeachTableData.emoji = paramCursor.getString(10);
    localBottleBeachTableData.imageurl = paramCursor.getString(11);
    localBottleBeachTableData.number = paramCursor.getInt(12);
    localBottleBeachTableData.uin = paramCursor.getString(13);
    localBottleBeachTableData.convsvrtime = paramCursor.getLong(14);
    localBottleBeachTableData.tagcolor = paramCursor.getInt(15);
    localBottleBeachTableData.adurl = paramCursor.getString(16);
    return localBottleBeachTableData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,type,subject,time,geo,city,distance,contentheader,content,displaycontent,emoji,imageurl,number,uin,convsvrtime,tagcolor,adurl from beachbottle  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleBeachTableData paramBottleBeachTableData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO beachbottle(bottleid,type,subject,time,geo,city,distance,contentheader,content,displaycontent,emoji,imageurl,number,uin,convsvrtime,tagcolor,adurl) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { paramBottleBeachTableData.bottleid, Integer.valueOf(paramBottleBeachTableData.type), paramBottleBeachTableData.subject, Long.valueOf(paramBottleBeachTableData.time), paramBottleBeachTableData.geo, paramBottleBeachTableData.city, Integer.valueOf(paramBottleBeachTableData.distance), paramBottleBeachTableData.contentheader, paramBottleBeachTableData.content, paramBottleBeachTableData.displaycontent, paramBottleBeachTableData.emoji, paramBottleBeachTableData.imageurl, Integer.valueOf(paramBottleBeachTableData.number), paramBottleBeachTableData.uin, Long.valueOf(paramBottleBeachTableData.convsvrtime), Integer.valueOf(paramBottleBeachTableData.tagcolor), paramBottleBeachTableData.adurl });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleBeachTableData paramBottleBeachTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleBeachTableDataORM
 * JD-Core Version:    0.7.0.1
 */