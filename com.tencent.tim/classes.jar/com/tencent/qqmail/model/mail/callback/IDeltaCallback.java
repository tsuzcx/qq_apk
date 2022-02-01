package com.tencent.qqmail.model.mail.callback;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

public abstract interface IDeltaCallback
{
  public abstract int excludeFolder();
  
  public abstract void onOperationComplete();
  
  public abstract void operation(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.IDeltaCallback
 * JD-Core Version:    0.7.0.1
 */