package com.tencent.qqmail.bottle.model;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottlerORM
{
  public static Bottler fill(Cursor paramCursor, Bottler paramBottler)
  {
    boolean bool2 = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    Bottler localBottler = paramBottler;
    if (paramBottler == null) {
      localBottler = new Bottler();
    }
    localBottler.uin = paramCursor.getString(0);
    localBottler.avatar = paramCursor.getString(1);
    localBottler.bigAvatar = paramCursor.getString(2);
    localBottler.name = paramCursor.getString(3);
    if (paramCursor.getInt(4) != 0)
    {
      bool1 = true;
      localBottler.male = bool1;
      if (paramCursor.getInt(5) == 0) {
        break label124;
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBottler.anonymous = bool1;
      return localBottler;
      bool1 = false;
      break;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  uin,avatar,bigavatar,name,sex,anonymous from bottler  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, Bottler paramBottler)
  {
    int j = 1;
    String str1 = paramBottler.uin;
    String str2 = paramBottler.avatar;
    String str3 = paramBottler.bigAvatar;
    String str4 = paramBottler.name;
    int i;
    if (paramBottler.male)
    {
      i = 1;
      if (!paramBottler.anonymous) {
        break label93;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottler(uin,avatar,bigavatar,name,sex,anonymous) VALUES (?,?,?,?,?,?)", new Object[] { str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      i = 0;
      break;
      label93:
      j = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, Bottler paramBottler)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottlerORM
 * JD-Core Version:    0.7.0.1
 */