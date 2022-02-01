package com.tencent.qqmail.utilities.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;

public class QMIPCBroadcastManager
  extends BroadcastReceiver
{
  private static final String FINISH_ALL_ACTIVITY_ACTOIN = "com.tencent.androidqqmail.FINISH_ALL_ACTIVITY_ACTION";
  private static final String KEY_NAME = "name";
  private static final String KEY_PID = "pid";
  private static final String PERMISSION = "com.tencent.androidqqmail.permission.INNER_IPC_BROADCAST";
  private static final String PERMISSION_CHANGED_ACTION = "com.tencent.androidqqmail.PERMISSION_CHANGED";
  private static final String SP_CHANGED_ACTION = "com.tencent.androidqqmail.SP_CHANGED";
  private static final String TAG = "QMIPCBroadcastManager";
  private static QMIPCBroadcastManager sInstance = new QMIPCBroadcastManager();
  
  static
  {
    register();
  }
  
  private void handleFinishAllActivity()
  {
    QMLog.log(4, "QMIPCBroadcastManager", "handleFinishAllActivity");
    if (QMApplicationContext.sharedInstance().isMainProcess()) {
      QMActivityManager.shareInstance().finishAllActivity();
    }
  }
  
  private void handlePermissionChanged()
  {
    QMLog.log(4, "QMIPCBroadcastManager", "handlePermissionChanged");
    PermissionUtils.handlePermissionChange();
  }
  
  private void handleSPChanged(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("pid", 0);
    int j = Process.myPid();
    paramIntent = paramIntent.getStringExtra("name");
    QMLog.log(3, "QMIPCBroadcastManager", "handleSPChanged, pid: " + i + ", myPid: " + j + ", sp_name: " + paramIntent);
    if (i != j) {
      SPManager.handleChanged(paramIntent);
    }
  }
  
  public static void init() {}
  
  public static void notifyFinishAllActivity()
  {
    QMLog.log(4, "QMIPCBroadcastManager", "notifyFinishAllActivity");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.androidqqmail.FINISH_ALL_ACTIVITY_ACTION");
    QMApplicationContext.sharedInstance().sendBroadcast(localIntent, "com.tencent.androidqqmail.permission.INNER_IPC_BROADCAST");
  }
  
  public static void notifyPermissionChanged()
  {
    QMLog.log(4, "QMIPCBroadcastManager", "notifyPermissionChanged");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.androidqqmail.PERMISSION_CHANGED");
    QMApplicationContext.sharedInstance().sendBroadcast(localIntent, "com.tencent.androidqqmail.permission.INNER_IPC_BROADCAST");
  }
  
  public static void notifySPChanged(String paramString)
  {
    QMLog.log(4, "QMIPCBroadcastManager", "notifySPChanged: " + paramString);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.androidqqmail.SP_CHANGED");
    localIntent.putExtra("pid", Process.myPid());
    localIntent.putExtra("name", paramString);
    QMApplicationContext.sharedInstance().sendBroadcast(localIntent, "com.tencent.androidqqmail.permission.INNER_IPC_BROADCAST");
  }
  
  private static void register()
  {
    QMLog.log(4, "QMIPCBroadcastManager", "register inner ipc receiver");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.androidqqmail.SP_CHANGED");
    localIntentFilter.addAction("com.tencent.androidqqmail.PERMISSION_CHANGED");
    localIntentFilter.addAction("com.tencent.androidqqmail.FINISH_ALL_ACTIVITY_ACTION");
    QMApplicationContext.sharedInstance().registerReceiver(sInstance, localIntentFilter, "com.tencent.androidqqmail.permission.INNER_IPC_BROADCAST", null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = SafeIntent.createSafeIntet(paramIntent);
    paramIntent = paramContext.getAction();
    QMLog.log(4, "QMIPCBroadcastManager", "ipc onReceive, action: " + paramIntent);
    int i = -1;
    switch (paramIntent.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramIntent.equals("com.tencent.androidqqmail.SP_CHANGED"))
        {
          i = 0;
          continue;
          if (paramIntent.equals("com.tencent.androidqqmail.PERMISSION_CHANGED"))
          {
            i = 1;
            continue;
            if (paramIntent.equals("com.tencent.androidqqmail.FINISH_ALL_ACTIVITY_ACTION")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    handleSPChanged(paramContext);
    return;
    handlePermissionChanged();
    return;
    handleFinishAllActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.receiver.QMIPCBroadcastManager
 * JD-Core Version:    0.7.0.1
 */