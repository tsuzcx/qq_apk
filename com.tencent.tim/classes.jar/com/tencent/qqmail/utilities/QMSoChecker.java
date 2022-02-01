package com.tencent.qqmail.utilities;

import com.tencent.qqmail.utilities.thread.Threads;

public class QMSoChecker
{
  private static final String PREFERENCES_NAME = "so_checker";
  private static final String TAG = "QMSoChecker";
  
  public static void doCheck()
  {
    Threads.runInBackground(new QMSoChecker.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMSoChecker
 * JD-Core Version:    0.7.0.1
 */