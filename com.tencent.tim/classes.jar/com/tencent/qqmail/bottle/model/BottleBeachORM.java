package com.tencent.qqmail.bottle.model;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleBeachORM
{
  public static BottleBeach fill(Cursor paramCursor, BottleBeach paramBottleBeach)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleBeach localBottleBeach = paramBottleBeach;
    if (paramBottleBeach == null) {
      localBottleBeach = new BottleBeach();
    }
    localBottleBeach.bottleid = paramCursor.getString(0);
    localBottleBeach.time = paramCursor.getLong(1);
    localBottleBeach.distance = paramCursor.getInt(2);
    localBottleBeach.imageUrl = paramCursor.getString(3);
    localBottleBeach.uin = paramCursor.getString(4);
    localBottleBeach.avatar = paramCursor.getString(5);
    localBottleBeach.bigAvatar = paramCursor.getString(6);
    localBottleBeach.name = paramCursor.getString(7);
    if (paramCursor.getInt(8) != 0) {}
    for (;;)
    {
      localBottleBeach.male = bool;
      localBottleBeach.city = paramCursor.getString(9);
      localBottleBeach.contentHeader = paramCursor.getString(10);
      localBottleBeach.content = paramCursor.getString(11);
      localBottleBeach.displayContent = paramCursor.getString(12);
      localBottleBeach.emoji = paramCursor.getString(13);
      localBottleBeach.type = paramCursor.getInt(14);
      localBottleBeach.tagColor = paramCursor.getInt(15);
      localBottleBeach.adUrl = paramCursor.getString(16);
      return localBottleBeach;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  beachbottle.bottleid,beachbottle.time,beachbottle.distance,beachbottle.imageurl,bottler.uin,bottler.avatar,bottler.bigavatar,bottler.name,bottler.sex,beachbottle.city,beachbottle.contentheader,beachbottle.content,beachbottle.displaycontent,beachbottle.emoji,beachbottle.type,beachbottle.tagcolor,beachbottle.adurl  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleBeach paramBottleBeach)
  {
    throw new UnsupportedOperationException("multi table");
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleBeach paramBottleBeach)
  {
    throw new UnsupportedOperationException("multi table");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleBeachORM
 * JD-Core Version:    0.7.0.1
 */