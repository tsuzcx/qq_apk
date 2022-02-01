package com.tencent.qqmail.bottle.controller;

import android.content.Context;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.bottle.model.table.BottleBeachTable;
import com.tencent.qqmail.bottle.model.table.BottleConversationTable;
import com.tencent.qqmail.bottle.model.table.BottleDraftTable;
import com.tencent.qqmail.bottle.model.table.BottleListExtraTable;
import com.tencent.qqmail.bottle.model.table.BottleListTable;
import com.tencent.qqmail.bottle.model.table.BottleThrowTable;
import com.tencent.qqmail.bottle.model.table.BottlerTable;

public abstract class AbstractBottleSQLiteOpenHelper
  extends QMBaseSQLiteOpenHelper
{
  public AbstractBottleSQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    BottleBeachTable.onCreate(paramSQLiteDatabase);
    BottleConversationTable.onCreate(paramSQLiteDatabase);
    BottleDraftTable.onCreate(paramSQLiteDatabase);
    BottleListExtraTable.onCreate(paramSQLiteDatabase);
    BottleListTable.onCreate(paramSQLiteDatabase);
    BottleThrowTable.onCreate(paramSQLiteDatabase);
    BottlerTable.onCreate(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BottleBeachTable.onDrop(paramSQLiteDatabase);
    BottleConversationTable.onDrop(paramSQLiteDatabase);
    BottleDraftTable.onDrop(paramSQLiteDatabase);
    BottleListExtraTable.onDrop(paramSQLiteDatabase);
    BottleListTable.onDrop(paramSQLiteDatabase);
    BottleThrowTable.onDrop(paramSQLiteDatabase);
    BottlerTable.onDrop(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.AbstractBottleSQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */