package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;

public class SQLiteUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof SQLiteException)) {
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.SQLiteUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */