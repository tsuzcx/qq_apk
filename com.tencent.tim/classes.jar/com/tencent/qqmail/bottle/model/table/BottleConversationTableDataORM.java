package com.tencent.qqmail.bottle.model.table;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationTableDataORM
{
  public static BottleConversationTableData fill(Cursor paramCursor, BottleConversationTableData paramBottleConversationTableData)
  {
    boolean bool = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversationTableData localBottleConversationTableData = paramBottleConversationTableData;
    if (paramBottleConversationTableData == null) {
      localBottleConversationTableData = new BottleConversationTableData();
    }
    localBottleConversationTableData.bottleid = paramCursor.getString(0);
    localBottleConversationTableData.msgid = paramCursor.getString(1);
    localBottleConversationTableData.time = paramCursor.getLong(2);
    localBottleConversationTableData.contentheader = paramCursor.getString(3);
    localBottleConversationTableData.content = paramCursor.getString(4);
    localBottleConversationTableData.displaycontent = paramCursor.getString(5);
    localBottleConversationTableData.emoji = paramCursor.getString(6);
    if (paramCursor.getInt(7) != 0) {}
    for (;;)
    {
      localBottleConversationTableData.isMine = bool;
      localBottleConversationTableData.imageUrl = paramCursor.getString(8);
      localBottleConversationTableData.audioUrl = paramCursor.getString(9);
      localBottleConversationTableData.unsend = paramCursor.getInt(10);
      localBottleConversationTableData.uin = paramCursor.getString(11);
      return localBottleConversationTableData;
      bool = false;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleid,msgid,time,contentheader,content,displaycontent,emoji,isMine,imageUrl,audioUrl,unsend,uin from bottleconv  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversationTableData paramBottleConversationTableData)
  {
    int i = 1;
    String str1 = paramBottleConversationTableData.bottleid;
    String str2 = paramBottleConversationTableData.msgid;
    long l = paramBottleConversationTableData.time;
    String str3 = paramBottleConversationTableData.contentheader;
    String str4 = paramBottleConversationTableData.content;
    String str5 = paramBottleConversationTableData.displaycontent;
    String str6 = paramBottleConversationTableData.emoji;
    if (paramBottleConversationTableData.isMine) {}
    for (;;)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO bottleconv(bottleid,msgid,time,contentheader,content,displaycontent,emoji,isMine,imageUrl,audioUrl,unsend,uin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { str1, str2, Long.valueOf(l), str3, str4, str5, str6, Integer.valueOf(i), paramBottleConversationTableData.imageUrl, paramBottleConversationTableData.audioUrl, Integer.valueOf(paramBottleConversationTableData.unsend), paramBottleConversationTableData.uin });
      return;
      i = 0;
    }
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversationTableData paramBottleConversationTableData)
  {
    throw new UnsupportedOperationException("no updatekey");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleConversationTableDataORM
 * JD-Core Version:    0.7.0.1
 */