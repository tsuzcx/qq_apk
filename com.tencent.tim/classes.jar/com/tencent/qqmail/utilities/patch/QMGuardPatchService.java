package com.tencent.qqmail.utilities.patch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMGuardPatchService
  extends Service
{
  private static final String TAG = "QMGuardPatchService";
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, "QMGuardPatchService", "onCreate@" + Integer.toHexString(hashCode()));
    try
    {
      startForeground(QMPatchManagerService.getForegroundId(), QMPatchManagerService.getForegroundNotification());
      label45:
      stopForeground(true);
      stopSelf();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label45;
    }
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMGuardPatchService", "onDestroy@" + Integer.toHexString(hashCode()));
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMGuardPatchService
 * JD-Core Version:    0.7.0.1
 */