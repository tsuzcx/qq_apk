package com.tencent.qqmail.utilities.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.aidl.INotifyService.Stub;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.BaseService;
import com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket;
import com.tencent.qqmail.utilities.thread.Threads;

public class QMNotifyService
  extends BaseService
{
  private static final int CMD_ON_REBOOT = 2;
  private static final int CMD_SCHEDULED_JOBS = 1;
  private static final String INTENT_KEY_CMD = "cmd";
  private static final String INTENT_KEY_EXTRAS = "extras";
  private static final String TAG = "QMNotifyService";
  private NotifyReceiverBinder mNotifyServiceBinder = new NotifyReceiverBinder(null);
  
  public static Intent createOnRebootIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMNotifyService.class).putExtra("cmd", 2);
  }
  
  public static Intent createScheduledJobsIntent(Bundle paramBundle)
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMNotifyService.class).putExtra("extras", paramBundle).putExtra("cmd", 1);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mNotifyServiceBinder;
  }
  
  public void onCreate()
  {
    QMLog.log(4, "QMNotifyService", "NotifyService onCreate");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMNotifyService", "onDestroy");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 0;
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    if (paramIntent == null)
    {
      QMLog.log(4, "QMNotifyService", "onStartCommand, command: " + i);
      if (i != 1) {
        break label81;
      }
      Threads.runInBackground(new QMNotifyService.1(this, paramIntent.getBundleExtra("extras")));
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      i = paramIntent.getIntExtra("cmd", 0);
      break;
      label81:
      if (i == 2)
      {
        if (AppStatusUtil.isAppOnBackGround()) {
          QMActivityManager.shareInstance().finishAllActivity();
        }
        Threads.runInBackground(new QMNotifyService.2(this));
      }
    }
  }
  
  class NotifyReceiverBinder
    extends INotifyService.Stub
  {
    private NotifyReceiverBinder() {}
    
    public int receivePushMail(ReceivePacket paramReceivePacket)
      throws RemoteException
    {
      Threads.runInBackground(new QMNotifyService.NotifyReceiverBinder.1(this, paramReceivePacket));
      return paramReceivePacket.cmd_id;
    }
    
    public void stopService()
      throws RemoteException
    {
      QMNotifyService.this.stopSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.services.QMNotifyService
 * JD-Core Version:    0.7.0.1
 */