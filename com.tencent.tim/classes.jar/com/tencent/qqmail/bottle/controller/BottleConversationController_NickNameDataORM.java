package com.tencent.qqmail.bottle.controller;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationController_NickNameDataORM
{
  public static BottleConversationController.NickNameData fill(Cursor paramCursor, BottleConversationController.NickNameData paramNickNameData)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationController.NickNameData localNickNameData = paramNickNameData;
    if (paramNickNameData == null) {
      localNickNameData = new BottleConversationController.NickNameData();
    }
    localNickNameData.uin = paramCursor.getString(0);
    localNickNameData.name = paramCursor.getString(1);
    return localNickNameData;
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  uin,name from bottler  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.NickNameData paramNickNameData)
  {
    paramSQLiteDatabase.execSQL("REPLACE INTO bottler(uin,name) VALUES (?,?)", new Object[] { paramNickNameData.uin, paramNickNameData.name });
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationController.NickNameData paramNickNameData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController_NickNameDataORM
 * JD-Core Version:    0.7.0.1
 */