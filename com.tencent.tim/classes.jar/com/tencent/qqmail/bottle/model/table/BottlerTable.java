package com.tencent.qqmail.bottle.model.table;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public final class BottlerTable
{
  public static final String FIELD_ANONYMOUS = "anonymous";
  public static final String FIELD_AVATAR = "avatar";
  public static final String FIELD_BIG_AVATAR = "bigavatar";
  public static final String FIELD_ISMINE = "isMine";
  public static final String FIELD_NAME = "name";
  public static final String FIELD_SEX = "sex";
  public static final String FIELD_UIN = "uin";
  public static final String FULL_FIELD_ANONYMOUS = "bottler.anonymous";
  public static final String FULL_FIELD_AVATAR = "bottler.avatar";
  public static final String FULL_FIELD_BIG_AVATAR = "bottler.bigavatar";
  public static final String FULL_FIELD_ISMINE = "bottler.isMine";
  public static final String FULL_FIELD_NAME = "bottler.name";
  public static final String FULL_FIELD_SEX = "bottler.sex";
  public static final String FULL_FIELD_UIN = "bottler.uin";
  public static final String TABLE_NAME = "bottler";
  
  public static void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bottler(uin VARCHAR, avatar VARCHAR, bigavatar VARCHAR, name VARCHAR, anonymous INTEGER, sex INTEGER, isMine INTEGER, PRIMARY KEY(uin))");
  }
  
  public static void onDrop(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS bottler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottlerTable
 * JD-Core Version:    0.7.0.1
 */