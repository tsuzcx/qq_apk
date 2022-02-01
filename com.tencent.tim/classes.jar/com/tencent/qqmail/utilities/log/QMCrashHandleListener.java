package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.exception.QMUncaughtExceptionHandler;
import moai.oss.KvHelper;

public class QMCrashHandleListener
  implements CrashHandleListener
{
  public static final int FIRST_SIGNAL_ID = 1;
  public static final int SECOND_SIGNAL_ID = 2;
  public static final String TAG = "QMCrashHandleListener";
  
  private void handleNativeCrash(Error paramError)
  {
    QMUncaughtExceptionHandler.dumpCrashLog(true, null, paramError);
    if (!QMUncaughtExceptionHandler.reboot()) {
      QMUncaughtExceptionHandler.handlePatchCrash(true);
    }
  }
  
  public void onCrash(int paramInt, Error paramError)
  {
    QMLog.log(7, "QMCrashHandleListener", "Native Crash, id:" + paramInt);
    if (paramInt == 1) {
      KvHelper.firstTimeNativeCrashByApp(new double[0]);
    }
    while (paramInt != 2) {
      return;
    }
    KvHelper.secondTimeNativeCrashByApp(new double[0]);
    handleNativeCrash(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMCrashHandleListener
 * JD-Core Version:    0.7.0.1
 */