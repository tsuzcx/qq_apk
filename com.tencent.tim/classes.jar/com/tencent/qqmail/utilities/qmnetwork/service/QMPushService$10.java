package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qqmail.utilities.aidl.INotifyService.Stub;
import com.tencent.qqmail.utilities.log.QMLog;

class QMPushService$10
  implements ServiceConnection
{
  QMPushService$10(QMPushService paramQMPushService) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    QMLog.log(4, "QMPushService", "onServiceConnected, name: " + ???);
    synchronized (QMPushService.access$4200(this.this$0))
    {
      QMPushService.access$4102(this.this$0, INotifyService.Stub.asInterface(paramIBinder));
      QMPushService.access$4302(this.this$0, false);
      QMPushService.access$4200(this.this$0).notifyAll();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    boolean bool = true;
    ??? = new StringBuilder().append("onServiceDisconnected, isBounded: ");
    if (QMPushService.access$4100(this.this$0) != null) {}
    for (;;)
    {
      QMLog.log(4, "QMPushService", bool);
      QMPushService.access$2900(this.this$0);
      synchronized (QMPushService.access$4200(this.this$0))
      {
        QMPushService.access$4302(this.this$0, true);
        QMPushService.access$4102(this.this$0, null);
        QMPushService.access$4200(this.this$0).notifyAll();
        return;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.10
 * JD-Core Version:    0.7.0.1
 */