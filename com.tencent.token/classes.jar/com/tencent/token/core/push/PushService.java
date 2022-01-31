package com.tencent.token.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsMessage;
import com.tencent.token.af;
import com.tencent.token.av;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.ui.OpreateMsgActivity;
import com.tencent.token.ui.PushTransitionActivity;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PushService
  extends Service
{
  public Handler a = new f(this);
  private AlarmManager b;
  private PendingIntent c;
  private Intent d;
  private Intent e;
  private Intent f;
  private ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
  private boolean h = false;
  private UserTask i;
  private String j = "QQ安全中心";
  private final int k = 3000;
  private Intent l;
  private Intent m;
  private int n;
  private final int o = 300000;
  private long p = 0L;
  private BroadcastReceiver q = new e(this);
  
  private void a()
  {
    if ((this.p != 0L) && (SystemClock.elapsedRealtime() - this.p >= 300000L))
    {
      this.p = 0L;
      ((NotificationManager)getSystemService("notification")).cancel(2);
    }
    j localj = a.a().c();
    long l1;
    if ((localj != null) && ((localj.d == 1) || (localj.d == 2)))
    {
      if ((localj.d != 2) || (localj.e != 1)) {
        break label210;
      }
      com.tencent.token.global.e.c("recevie auto sms push = " + Long.parseLong(new String(localj.b)));
      l1 = Long.parseLong(new String(localj.b));
      if (!this.h)
      {
        this.h = true;
        this.i = new g(this, l1);
        this.i.a(new String[] { "" });
      }
      af.a().c(this.a);
    }
    for (;;)
    {
      l1 = System.currentTimeMillis();
      this.b.set(1, l1 + 3000L, this.c);
      return;
      label210:
      if ((BaseActivity.getIsAppForeground()) && (localj.d == 2))
      {
        af.a().a(av.d, this.a);
        com.tencent.token.global.e.c("dualmsg::pushservice: query=true");
      }
      else
      {
        NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
        this.d.removeExtra("com.tencent.input_param");
        this.e.removeExtra("com.tencent.input_param");
        if (!s.b()) {
          RqdApplication.b();
        }
        Object localObject;
        if (localj.d == 1)
        {
          if (localj.e == 32)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putLong("uin", Long.parseLong(new String(localj.b)));
            this.f.putExtra("com.tencent.input_param", (Bundle)localObject);
            localObject = PendingIntent.getActivity(this, 0, this.f, 134217728);
            localNotificationManager.notify(1, new NotificationCompat.Builder(this).setDefaults(1).setAutoCancel(true).setContentTitle(getResources().getString(2131361792)).setSmallIcon(2130837686).setContentIntent((PendingIntent)localObject).setContentText(new String(localj.h)).build());
            if (BaseActivity.getIsAppForeground())
            {
              this.l.putExtra("uin", new String(localj.b));
              LocalBroadcastManager.getInstance(this).sendBroadcast(this.l);
            }
            else
            {
              com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
              s.a(new String(localj.b), true);
              com.tencent.token.ui.IndexActivity.isShowAccountTip = true;
            }
          }
          else if ((BaseActivity.getIsAppForeground()) && ("com.tencent.token.ui.IndexActivity".equals(t.a(RqdApplication.i()))))
          {
            LocalBroadcastManager.getInstance(this).sendBroadcast(this.m);
          }
          else
          {
            s.a(new String(localj.b), true);
            com.tencent.token.ui.IndexActivity.isShowAccountTip = true;
            localObject = new Bundle();
            ((Bundle)localObject).putLong("uin", Long.parseLong(new String(localj.b)));
            this.d.putExtra("com.tencent.input_param", (Bundle)localObject);
            localObject = PendingIntent.getActivity(this, 0, this.d, 134217728);
            localNotificationManager.notify(1, new NotificationCompat.Builder(this).setDefaults(1).setAutoCancel(true).setContentTitle(getResources().getString(2131361792)).setSmallIcon(2130837686).setContentIntent((PendingIntent)localObject).setContentText(new String(localj.h)).build());
          }
        }
        else
        {
          com.tencent.token.global.e.c("push time=" + localj.f);
          if (av.a().c() < localj.f)
          {
            localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
            localNotificationManager.notify(2, new NotificationCompat.Builder(this).setDefaults(1).setAutoCancel(true).setContentTitle(getResources().getString(2131361792)).setSmallIcon(2130837686).setContentIntent((PendingIntent)localObject).setContentText(new String(localj.h)).build());
            this.p = SystemClock.elapsedRealtime();
          }
        }
      }
    }
  }
  
  private static SmsMessage[] a(Intent paramIntent)
  {
    Object[] arrayOfObject = (Object[])paramIntent.getSerializableExtra("pdus");
    if (arrayOfObject == null) {
      return null;
    }
    int i2 = arrayOfObject.length;
    paramIntent = new SmsMessage[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          paramIntent[i1] = SmsMessage.createFromPdu((byte[])arrayOfObject[i1]);
          i1 += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
    return paramIntent;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.l = new Intent("com.tencent.token.push_ipc_msg");
    this.m = new Intent("com.tencent.token.push_opr_msg");
    Object localObject = new Intent(this, PushService.class);
    this.b = ((AlarmManager)getSystemService("alarm"));
    this.c = PendingIntent.getService(this, 0, (Intent)localObject, 0);
    this.d = new Intent(this, OpreateMsgActivity.class);
    this.e = new Intent(this, PushTransitionActivity.class);
    this.f = new Intent(this, LoginMsgActivity.class);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((IntentFilter)localObject).addAction("android.provider.Telephony.SMS_RECEIVED");
    ((IntentFilter)localObject).addAction("com.tencent.token.action.dualsms");
    try
    {
      registerReceiver(this.q, (IntentFilter)localObject);
      if (Build.VERSION.SDK_INT < 18)
      {
        this.n = ((int)System.currentTimeMillis());
        localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
        localObject = new NotificationCompat.Builder(this).setContentIntent((PendingIntent)localObject).setAutoCancel(true).build();
        startForeground(this.n, (Notification)localObject);
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localSecurityException.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.cancel(this.c);
    try
    {
      unregisterReceiver(this.q);
      a.a().d();
      if (Build.VERSION.SDK_INT < 18) {
        ((NotificationManager)getSystemService("notification")).cancel(this.n);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1) {}
    try
    {
      a();
      if (Build.VERSION.SDK_INT < 18) {
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.token.global.e.c(localException.getMessage());
      }
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.PushService
 * JD-Core Version:    0.7.0.1
 */