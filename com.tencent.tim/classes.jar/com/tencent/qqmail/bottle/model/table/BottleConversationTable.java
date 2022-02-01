package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottleConversationTable
{
  public static final String FIELD_AUDIO_URL = "audioUrl";
  public static final String FIELD_BOTTLER_UIN = "uin";
  public static final String FIELD_BOTTLE_ID = "bottleid";
  public static final String FIELD_CONTENT = "content";
  public static final String FIELD_CONTENT_HEADER = "contentheader";
  public static final String FIELD_DISPLAY_CONTENT = "displaycontent";
  public static final String FIELD_DISPLAY_CONTENT_EMOJI = "emoji";
  public static final String FIELD_IMAGE_URL = "imageUrl";
  public static final String FIELD_ISMINE = "isMine";
  public static final String FIELD_MSG_ID = "msgid";
  public static final String FIELD_TIME = "time";
  public static final String FIELD_UNSEND = "unsend";
  public static final String FULL_FIELD_AUDIO_URL = "bottleconv.audioUrl";
  public static final String FULL_FIELD_BOTTLER_UIN = "bottleconv.uin";
  public static final String FULL_FIELD_BOTTLE_ID = "bottleconv.bottleid";
  public static final String FULL_FIELD_CONTENT = "bottleconv.content";
  public static final String FULL_FIELD_CONTENT_HEADER = "bottleconv.contentheader";
  public static final String FULL_FIELD_DISPLAY_CONTENT = "bottleconv.displaycontent";
  public static final String FULL_FIELD_DISPLAY_CONTENT_EMOJI = "bottleconv.emoji";
  public static final String FULL_FIELD_IMAGE_URL = "bottleconv.imageUrl";
  public static final String FULL_FIELD_ISMINE = "bottleconv.isMine";
  public static final String FULL_FIELD_MSG_ID = "bottleconv.msgid";
  public static final String FULL_FIELD_TIME = "bottleconv.time";
  public static final String FULL_FIELD_UNSEND = "bottleconv.unsend";
  public static final String TABLE_NAME = "bottleconv";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottleconv(bottleid VARCHAR, msgid VARCHAR, time INTEGER, contentheader VARCHAR, content VARCHAR, displaycontent VARCHAR, emoji VARCHAR, isMine INTEGER, imageUrl VARCHAR, audioUrl VARCHAR, unsend INTEGER, uin VARCHAR, PRIMARY KEY(bottleid, msgid))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottleconv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleConversationTable
 * JD-Core Version:    0.7.0.1
 */