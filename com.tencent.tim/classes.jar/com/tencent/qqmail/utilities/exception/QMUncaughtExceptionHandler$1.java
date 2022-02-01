package com.tencent.qqmail.utilities.exception;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

final class QMUncaughtExceptionHandler$1
  implements Runnable
{
  public void run()
  {
    SPManager.getEditor(QMUncaughtExceptionHandler.access$000()).putInt("reboot", 0).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.exception.QMUncaughtExceptionHandler.1
 * JD-Core Version:    0.7.0.1
 */