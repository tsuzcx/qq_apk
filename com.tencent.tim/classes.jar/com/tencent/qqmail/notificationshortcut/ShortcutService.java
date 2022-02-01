package com.tencent.qqmail.notificationshortcut;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.qqmail.utilities.log.QMLog;

public class ShortcutService
  extends Service
{
  private static final int NotificationID = 12345;
  public static final String TAG = "ShortcutService";
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, "ShortcutService", "onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    stopForeground(true);
    QMLog.log(4, "ShortcutService", "onDestroy");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "ShortcutService", "onStartCommand");
    startForeground(12345, NotificationShortCutManager.getShortNotification(this));
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortcutService
 * JD-Core Version:    0.7.0.1
 */