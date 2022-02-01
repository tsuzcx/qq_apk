package com.tencent.qqmail.bottle.model;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationORM
{
  public static BottleConversation fill(Cursor paramCursor, BottleConversation paramBottleConversation)
  {
    boolean bool2 = true;
    if (paramCursor == null) {
      throw new IllegalArgumentException("cursor null");
    }
    BottleConversation localBottleConversation = paramBottleConversation;
    if (paramBottleConversation == null) {
      localBottleConversation = new BottleConversation();
    }
    localBottleConversation.bottleId = paramCursor.getString(0);
    localBottleConversation.msgId = paramCursor.getString(1);
    localBottleConversation.time = paramCursor.getLong(2);
    if (paramCursor.getInt(3) != 0)
    {
      bool1 = true;
      localBottleConversation.isMine = bool1;
      localBottleConversation.unsend = paramCursor.getInt(4);
      localBottleConversation.contentHeader = paramCursor.getString(5);
      localBottleConversation.content = paramCursor.getString(6);
      localBottleConversation.displayContent = paramCursor.getString(7);
      localBottleConversation.emoji = paramCursor.getString(8);
      localBottleConversation.imageUrl = paramCursor.getString(9);
      localBottleConversation.audioUrl = paramCursor.getString(10);
      localBottleConversation.uin = paramCursor.getString(11);
      localBottleConversation.avatar = paramCursor.getString(12);
      localBottleConversation.bigAvatar = paramCursor.getString(13);
      localBottleConversation.name = paramCursor.getString(14);
      if (paramCursor.getInt(15) == 0) {
        break label254;
      }
    }
    label254:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBottleConversation.male = bool1;
      return localBottleConversation;
      bool1 = false;
      break;
    }
  }
  
  public static Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    if (paramSQLiteDatabase == null) {
      throw new IllegalArgumentException("db null");
    }
    return paramSQLiteDatabase.rawQuery("select  bottleconv.bottleid,bottleconv.msgid,bottleconv.time,bottleconv.isMine,bottleconv.unsend,bottleconv.contentheader,bottleconv.content,bottleconv.displaycontent,bottleconv.emoji,bottleconv.imageUrl,bottleconv.audioUrl,bottler.uin,bottler.avatar,bottler.bigavatar,bottler.name,bottler.sex  " + paramString, paramArrayOfString);
  }
  
  public static void replace(SQLiteDatabase paramSQLiteDatabase, BottleConversation paramBottleConversation)
  {
    throw new UnsupportedOperationException("multi table");
  }
  
  public static void update(SQLiteDatabase paramSQLiteDatabase, BottleConversation paramBottleConversation)
  {
    throw new UnsupportedOperationException("multi table");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleConversationORM
 * JD-Core Version:    0.7.0.1
 */