package com.tencent.qqmail.bottle.controller;

import android.content.Context;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;

public class BottleSQLiteOpenHelper
  extends AbstractBottleSQLiteOpenHelper
{
  public static final String CANONICAL_NAME = "com.tencent.qqmail.bottle.controller.BottleSQLiteOpenHelper";
  public static final String FIELNAME = "bottle";
  private static final int VERSION = 1277197;
  
  public BottleSQLiteOpenHelper(Context paramContext, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    super(paramContext, "bottle" + paramInt, paramCursorFactory, 1277197);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "BottleSQLiteOpenHelper", "onUpgrade: " + paramInt1 + ", " + paramInt2);
    if (paramInt2 != 1277197) {
      throw new DevRuntimeException("change version, and check upgrade code");
    }
    switch (paramInt1)
    {
    case 842107: 
    default: 
      super.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
      return;
    }
    paramSQLiteDatabase.execSQL("ALTER TABLE beachbottle ADD COLUMN adurl VARCHAR");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleSQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */