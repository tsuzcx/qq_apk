package com.tencent.qqmail.model.mail.callback;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public class SimpleDeltaCallback
  implements IDeltaCallback
{
  public int excludeFolder()
  {
    return -1010101;
  }
  
  public void onDeltaComplete(boolean paramBoolean, Exception paramException) {}
  
  public void onOperationComplete() {}
  
  public void operation(SQLiteDatabase paramSQLiteDatabase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.SimpleDeltaCallback
 * JD-Core Version:    0.7.0.1
 */