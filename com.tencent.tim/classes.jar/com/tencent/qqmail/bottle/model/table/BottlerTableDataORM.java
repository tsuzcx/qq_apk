package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottlerTableDataORM
{
  public static BottlerTableData fill(Cursor paramCursor, BottlerTableData paramBottlerTableData)
  {
    boolean bool2 = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottlerTableData localBottlerTableData = paramBottlerTableData;
    if (paramBottlerTableData == null) {
      localBottlerTableData = new BottlerTableData();
    }
    localBottlerTableData.uin = paramCursor.getString(0);
    localBottlerTableData.avatar = paramCursor.getString(1);
    localBottlerTableData.bigavatar = paramCursor.getString(2);
    localBottlerTableData.name = paramCursor.getString(3);
    if (paramCursor.getInt(4) != 0)
    {
      bool1 = true;
      localBottlerTableData.anonymous = bool1;
      if (paramCursor.getInt(5) == 0) {
        break label137;
      }
    }
    label137:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBottlerTableData.sex = bool1;
      localBottlerTableData.isMine = paramCursor.getInt(6);
      return localBottlerTableData;
      bool1 = false;
      break;
    }
  }
  
  public static void insertOrIgnore(SQLiteDatabase paramSQLiteDatabase, BottlerTableData paramBottlerTableData)
  {
    int j = 1;
    String str1 = paramBottlerTableData.uin;
    String str2 = paramBottlerTableData.avatar;
    String str3 = paramBottlerTableData.bigavatar;
    String str4 = paramBottlerTableData.name;
    int i;
    if (paramBottlerTableData.anonymous)
    {
      i = 1;
      if (!paramBottlerTableData.sex) {
        break label104;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL("INSERT OR IGNORE INTO bottler(uin,avatar,bigavatar,name,anonymous,sex,isMine) VALUES (?,?,?,?,?,?,?)", new Object[] { str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramBottlerTableData.isMine) });
      return;
      i = 0;
      break;
      label104:
      j = 0;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  uin,avatar,bigavatar,name,anonymous,sex,isMine from bottler  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottlerTableData paramBottlerTableData)
  {
    int j = 1;
    String str1 = paramBottlerTableData.uin;
    String str2 = paramBottlerTableData.avatar;
    String str3 = paramBottlerTableData.bigavatar;
    String str4 = paramBottlerTableData.name;
    int i;
    if (paramBottlerTableData.anonymous)
    {
      i = 1;
      if (!paramBottlerTableData.sex) {
        break label104;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottler(uin,avatar,bigavatar,name,anonymous,sex,isMine) VALUES (?,?,?,?,?,?,?)", new Object[] { str1, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramBottlerTableData.isMine) });
      return;
      i = 0;
      break;
      label104:
      j = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottlerTableData paramBottlerTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottlerTableDataORM
 * JD-Core Version:    0.7.0.1
 */