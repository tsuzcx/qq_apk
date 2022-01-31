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
import com.tencent.token.cw;
import com.tencent.token.dm;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.ui.OpreateMsgActivity;
import com.tencent.token.ui.PushTransitionActivity;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

public class PushService
  extends Service
{
  public Handler a = new k(this);
  private AlarmManager b;
  private PendingIntent c;
  private Intent d;
  private Intent e;
  private Intent f;
  private final int g = 4000;
  private Intent h;
  private Intent i;
  private int j;
  private final int k = 300000;
  private long l = 0L;
  private BroadcastReceiver m = new j(this);
  
  private void a()
  {
    try
    {
      if ((this.l != 0L) && (SystemClock.elapsedRealtime() - this.l >= 300000L))
      {
        this.l = 0L;
        ((NotificationManager)getSystemService("notification")).cancel(2);
      }
      b.a().a(this.a);
      long l1 = System.currentTimeMillis();
      this.b.set(1, l1 + 4000L, this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(m paramm)
  {
    if ((paramm != null) && ((paramm.d == 1) || (paramm.d == 2)))
    {
      if ((!BaseActivity.getIsAppForeground()) || (paramm.d != 2)) {
        break label55;
      }
      cw.a().a(0L, dm.e, this.a);
      h.c("dualmsg::pushservice: query=true");
    }
    label55:
    do
    {
      return;
      localObject = (NotificationManager)getSystemService("notification");
      this.d.removeExtra("com.tencent.input_param");
      this.e.removeExtra("com.tencent.input_param");
      if (!w.b()) {
        RqdApplication.e();
      }
      if (paramm.d == 1)
      {
        if (paramm.e == 32)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putLong("uin", Long.parseLong(new String(paramm.b)));
          this.f.putExtra("com.tencent.input_param", (Bundle)localObject);
          localObject = PendingIntent.getActivity(this, 0, this.f, 134217728);
          new a(this).a(1, getResources().getString(2131230844), new String(paramm.h), (PendingIntent)localObject);
          if (BaseActivity.getIsAppForeground())
          {
            this.h.putExtra("uin", new String(paramm.b));
            LocalBroadcastManager.getInstance(this).sendBroadcast(this.h);
            return;
          }
          com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
          w.a(new String(paramm.b), true);
          com.tencent.token.ui.IndexActivity.isShowAccountTip = true;
          return;
        }
        if ((BaseActivity.getIsAppForeground()) && ("com.tencent.token.ui.IndexActivity".equals(x.a(RqdApplication.l()))))
        {
          LocalBroadcastManager.getInstance(this).sendBroadcast(this.i);
          return;
        }
        w.a(new String(paramm.b), true);
        com.tencent.token.ui.IndexActivity.isShowAccountTip = true;
        localObject = new Bundle();
        ((Bundle)localObject).putLong("uin", Long.parseLong(new String(paramm.b)));
        this.d.putExtra("com.tencent.input_param", (Bundle)localObject);
        localObject = PendingIntent.getActivity(this, 0, this.d, 134217728);
        new a(this).a(1, getResources().getString(2131230844), new String(paramm.h), (PendingIntent)localObject);
        return;
      }
      h.c("push time=" + paramm.f);
    } while (dm.a().d() >= paramm.f);
    Object localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
    new a(this).a(2, getResources().getString(2131230844), new String(paramm.h), (PendingIntent)localObject);
    this.l = SystemClock.elapsedRealtime();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    try
    {
      super.onCreate();
      this.h = new Intent("com.tencent.token.push_ipc_msg");
      this.i = new Intent("com.tencent.token.push_opr_msg");
      Object localObject = new Intent(this, PushService.class);
      this.b = ((AlarmManager)getSystemService("alarm"));
      this.c = PendingIntent.getService(this, 0, (Intent)localObject, 0);
      this.d = new Intent(this, OpreateMsgActivity.class);
      this.e = new Intent(this, PushTransitionActivity.class);
      this.f = new Intent(this, LoginMsgActivity.class);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      try
      {
        registerReceiver(this.m, (IntentFilter)localObject);
        if (Build.VERSION.SDK_INT < 18)
        {
          this.j = ((int)System.currentTimeMillis());
          localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
          localObject = new NotificationCompat.Builder(this).setContentIntent((PendingIntent)localObject).setAutoCancel(true).build();
          startForeground(this.j, (Notification)localObject);
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          localSecurityException.printStackTrace();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.cancel(this.c);
    try
    {
      unregisterReceiver(this.m);
      b.a().d();
      if (Build.VERSION.SDK_INT < 18) {
        ((NotificationManager)getSystemService("notification")).cancel(this.j);
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
        h.c(localException.getMessage());
      }
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.PushService
 * JD-Core Version:    0.7.0.1
 */