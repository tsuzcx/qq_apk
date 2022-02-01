package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottlerController_MyInformationDataORM
{
  public static BottlerController.MyInformationData fill(Cursor paramCursor, BottlerController.MyInformationData paramMyInformationData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottlerController.MyInformationData localMyInformationData = paramMyInformationData;
    if (paramMyInformationData == null) {
      localMyInformationData = new BottlerController.MyInformationData();
    }
    localMyInformationData.uin = paramCursor.getString(0);
    localMyInformationData.name = paramCursor.getString(1);
    localMyInformationData.avatar = paramCursor.getString(2);
    localMyInformationData.bigAvatar = paramCursor.getString(3);
    return localMyInformationData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  uin,name,avatar,bigavatar from bottler  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottlerController.MyInformationData paramMyInformationData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottler(uin,name,avatar,bigavatar) VALUES (?,?,?,?)", new Object[] { paramMyInformationData.uin, paramMyInformationData.name, paramMyInformationData.avatar, paramMyInformationData.bigAvatar });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottlerController.MyInformationData paramMyInformationData)
  {
    paramSQLiteDatabase.execSQL("UPDATE bottler SET name=?, avatar=?, bigavatar=?, sex=? WHERE uin=?", new Object[] { paramMyInformationData.name, paramMyInformationData.avatar, paramMyInformationData.bigAvatar, Boolean.valueOf(paramMyInformationData.male), paramMyInformationData.uin });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController_MyInformationDataORM
 * JD-Core Version:    0.7.0.1
 */