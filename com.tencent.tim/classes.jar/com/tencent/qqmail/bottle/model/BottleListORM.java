package com.tencent.qqmail.bottle.model;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleListORM
{
  public static BottleList fill(Cursor paramCursor, BottleList paramBottleList)
  {
    boolean bool2 = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleList localBottleList = paramBottleList;
    if (paramBottleList == null) {
      localBottleList = new BottleList();
    }
    localBottleList.bottleId = paramCursor.getString(0);
    localBottleList.unreadCnt = paramCursor.getInt(1);
    localBottleList.summary = paramCursor.getString(2);
    localBottleList.displaySummary = paramCursor.getString(3);
    localBottleList.emoji = paramCursor.getString(4);
    localBottleList.time = paramCursor.getLong(5);
    localBottleList.type = paramCursor.getInt(6);
    if (paramCursor.getInt(7) != 0)
    {
      bool1 = true;
      localBottleList.isMine = bool1;
      localBottleList.uin = paramCursor.getString(8);
      localBottleList.avatar = paramCursor.getString(9);
      localBottleList.name = paramCursor.getString(10);
      if (paramCursor.getInt(11) == 0) {
        break label215;
      }
    }
    label215:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBottleList.male = bool1;
      localBottleList.unsend = paramCursor.getInt(12);
      return localBottleList;
      bool1 = false;
      break;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottlelist.bottleid,bottlelist.unreadCnt,bottlelist.summary,bottlelist.displaysummary,bottlelist.emoji,bottlelist.time,bottlelist.type,bottlelist.isMine,bottler.uin,bottler.avatar,bottler.name,bottler.sex,COALESCE(MAX(unsend),0)  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleList paramBottleList)
  {
    throw new UnsupportedOperationException("multi table");
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleList paramBottleList)
  {
    throw new UnsupportedOperationException("multi table");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleListORM
 * JD-Core Version:    0.7.0.1
 */