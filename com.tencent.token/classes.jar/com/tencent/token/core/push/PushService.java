package com.tencent.token.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.token.cb;
import com.tencent.token.cp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.ui.OpreateMsgActivity;
import com.tencent.token.ui.PushTransitionActivity;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import com.tmsdk.common.util.TmsLog;

public class PushService
  extends Service
{
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i != 3069)
      {
        if (i != 4014) {
          return;
        }
        paramAnonymousMessage = (f)paramAnonymousMessage.obj;
        PushService.a(PushService.this, paramAnonymousMessage);
        return;
      }
      if ((paramAnonymousMessage.arg1 == 0) && (cp.a().b() > 0))
      {
        paramAnonymousMessage = new StringBuilder();
        paramAnonymousMessage.append("push:getIsAppForeground");
        paramAnonymousMessage.append(BaseActivity.getIsAppForeground());
        g.b(paramAnonymousMessage.toString());
        if (BaseActivity.getIsAppForeground())
        {
          paramAnonymousMessage = new StringBuilder();
          paramAnonymousMessage.append("isshowingverify");
          paramAnonymousMessage.append(RqdApplication.b);
          g.c(paramAnonymousMessage.toString());
          if (RqdApplication.b) {
            break label149;
          }
        }
      }
      label149:
      try
      {
        new DualMsgShowDialog(BaseActivity.sTopActivity, 2131558764, 0, false, 0L).show();
        return;
      }
      catch (Exception paramAnonymousMessage) {}
      IndexActivity.setFromWhere(19);
      return;
    }
  };
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
  private BroadcastReceiver m = new BroadcastReceiver()
  {
    private boolean b = false;
    
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      try
      {
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          paramAnonymousContext = (ConnectivityManager)PushService.this.getSystemService("connectivity");
          if (paramAnonymousContext == null) {
            return;
          }
          paramAnonymousContext = paramAnonymousContext.getActiveNetworkInfo();
          if ((paramAnonymousContext != null) && (paramAnonymousContext.isConnected()))
          {
            b.a().a(1);
            boolean bool = this.b;
            if (bool)
            {
              try
              {
                PushService.a(PushService.this);
              }
              catch (Exception paramAnonymousContext)
              {
                g.c(paramAnonymousContext.getMessage());
              }
              this.b = false;
            }
          }
          else
          {
            this.b = true;
            b.a().a(7);
            PushService.c(PushService.this).cancel(PushService.b(PushService.this));
            return;
          }
        }
      }
      catch (Exception paramAnonymousContext)
      {
        paramAnonymousContext.printStackTrace();
        paramAnonymousIntent = new StringBuilder();
        paramAnonymousIntent.append("Push Service");
        paramAnonymousIntent.append(paramAnonymousContext.toString());
        g.d(paramAnonymousIntent.toString());
      }
    }
  };
  
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
  
  private void a(f paramf)
  {
    if ((paramf != null) && ((paramf.d == 1) || (paramf.d == 2)))
    {
      if ((BaseActivity.getIsAppForeground()) && (paramf.d == 2))
      {
        cb.a().a(0L, cp.e, this.a);
        g.c("dualmsg::pushservice: query=true");
        return;
      }
      Object localObject = (NotificationManager)getSystemService("notification");
      this.d.removeExtra("com.tencent.input_param");
      this.e.removeExtra("com.tencent.input_param");
      if (!l.b()) {
        RqdApplication.e();
      }
      if (paramf.d == 1)
      {
        if (paramf.e == 32)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putLong("uin", Long.parseLong(new String(paramf.b)));
          this.f.putExtra("com.tencent.input_param", (Bundle)localObject);
          localObject = PendingIntent.getActivity(this, 0, this.f, 134217728);
          new a(this).a(1, getResources().getString(2131492986), new String(paramf.h), (PendingIntent)localObject);
          if (BaseActivity.getIsAppForeground())
          {
            this.h.putExtra("uin", new String(paramf.b));
            LocalBroadcastManager.getInstance(this).sendBroadcast(this.h);
            return;
          }
          com.tencent.token.ui.AccountPageActivity.mNeedShowIpcMsg = true;
          l.a(new String(paramf.b), true);
          IndexActivity.isShowAccountTip = true;
          return;
        }
        if ((BaseActivity.getIsAppForeground()) && ("com.tencent.token.ui.IndexActivity".equals(m.a(RqdApplication.l()))))
        {
          LocalBroadcastManager.getInstance(this).sendBroadcast(this.i);
          return;
        }
        l.a(new String(paramf.b), true);
        IndexActivity.isShowAccountTip = true;
        localObject = new Bundle();
        ((Bundle)localObject).putLong("uin", Long.parseLong(new String(paramf.b)));
        this.d.putExtra("com.tencent.input_param", (Bundle)localObject);
        localObject = PendingIntent.getActivity(this, 0, this.d, 134217728);
        new a(this).a(1, getResources().getString(2131492986), new String(paramf.h), (PendingIntent)localObject);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("push time=");
      ((StringBuilder)localObject).append(paramf.f);
      g.c(((StringBuilder)localObject).toString());
      if (cp.a().d() < paramf.f)
      {
        localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
        new a(this).a(2, getResources().getString(2131492986), new String(paramf.h), (PendingIntent)localObject);
        this.l = SystemClock.elapsedRealtime();
      }
    }
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
      Object localObject1 = new Intent(this, PushService.class);
      this.b = ((AlarmManager)getSystemService("alarm"));
      this.c = PendingIntent.getService(this, 0, (Intent)localObject1, 0);
      this.d = new Intent(this, OpreateMsgActivity.class);
      this.e = new Intent(this, PushTransitionActivity.class);
      this.f = new Intent(this, LoginMsgActivity.class);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      try
      {
        registerReceiver(this.m, (IntentFilter)localObject1);
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        this.j = ((int)System.currentTimeMillis());
        Object localObject2 = PendingIntent.getActivity(this, 0, this.e, 134217728);
        localObject2 = new NotificationCompat.Builder(this).setContentIntent((PendingIntent)localObject2).setAutoCancel(true).build();
        startForeground(this.j, (Notification)localObject2);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    TmsLog.i("PushService", "@pushservice oncreate()");
  }
  
  public void onDestroy()
  {
    TmsLog.i("PushService", "@pushservice onDestroy()");
    super.onDestroy();
    this.b.cancel(this.c);
    try
    {
      unregisterReceiver(this.m);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    b.a().d();
    if (Build.VERSION.SDK_INT < 18) {
      ((NotificationManager)getSystemService("notification")).cancel(this.j);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    TmsLog.i("PushService", "@pushservice onStartCommand()");
    if (paramInt1 != 1) {
      try
      {
        a();
        com.tencent.service.f.a().a(this);
      }
      catch (Exception localException)
      {
        g.c(localException.getMessage());
      }
    }
    if (Build.VERSION.SDK_INT < 18) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.PushService
 * JD-Core Version:    0.7.0.1
 */