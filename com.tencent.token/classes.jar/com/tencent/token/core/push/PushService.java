package com.tencent.token.core.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.token.aic;
import com.tencent.token.db.b;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.sb;
import com.tencent.token.sb.1;
import com.tencent.token.sb.a;
import com.tencent.token.tr;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.ui.OpreateMsgActivity;
import com.tencent.token.ui.PushTransitionActivity;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.xh;
import com.tencent.token.xl;
import com.tencent.token.xv;
import com.tmsdk.common.util.TmsLog;

public class PushService
  extends Service
{
  @SuppressLint({"HandlerLeak"})
  public Handler a = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i != 3069)
      {
        if (i != 4014) {
          return;
        }
        paramAnonymousMessage = (xl)paramAnonymousMessage.obj;
        PushService.a(PushService.this, paramAnonymousMessage);
        return;
      }
      if ((paramAnonymousMessage.arg1 == 0) && (tr.a().b() > 0))
      {
        paramAnonymousMessage = new StringBuilder("push:getIsAppForeground");
        paramAnonymousMessage.append(BaseActivity.getIsAppForeground());
        xv.b(paramAnonymousMessage.toString());
        if (BaseActivity.getIsAppForeground())
        {
          paramAnonymousMessage = new StringBuilder("isshowingverify");
          paramAnonymousMessage.append(RqdApplication.b);
          xv.c(paramAnonymousMessage.toString());
          if (RqdApplication.b) {
            break label137;
          }
        }
      }
      label137:
      try
      {
        new DualMsgShowDialog(BaseActivity.sTopActivity, false, 0L).show();
        return;
      }
      catch (Exception paramAnonymousMessage) {}
      IndexActivity.setFromWhere(19);
      return;
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
    
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
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
            xh.a().a(1);
            boolean bool = this.b;
            if (bool)
            {
              try
              {
                PushService.a(PushService.this);
              }
              catch (Exception paramAnonymousContext)
              {
                xv.c(paramAnonymousContext.getMessage());
              }
              this.b = false;
            }
          }
          else
          {
            this.b = true;
            xh.a().a(7);
            PushService.c(PushService.this).cancel(PushService.b(PushService.this));
          }
        }
        return;
      }
      catch (Exception paramAnonymousContext)
      {
        paramAnonymousContext.printStackTrace();
        paramAnonymousIntent = new StringBuilder("Push Service");
        paramAnonymousIntent.append(paramAnonymousContext.toString());
        xv.c(paramAnonymousIntent.toString());
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
      xh.a().a(this.a);
      long l1 = System.currentTimeMillis();
      this.b.set(1, l1 + 4000L, this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
        db.b localb = new db.b(this, (byte)0);
        localb.e = ((PendingIntent)localObject2);
        localObject2 = localb.b().d();
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
    xh.a().d();
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
        sb localsb = sb.a.a();
        if (localsb.c) {
          TmsLog.i("LoginTraceManager", "@checkHasChanged, has job doing, cancel this time.");
        } else if (System.currentTimeMillis() - aic.a("login_trace_push_timestamp") < 432000000L) {
          TmsLog.i("LoginTraceManager", "@checkHasChanged, time since last push is less than 5 day, cancel this time.");
        } else if (aic.c()) {
          TmsLog.i("LoginTraceManager", "@checkHasChanged, user has launch today, cancel this time.");
        } else if (aic.a()) {
          TmsLog.i("LoginTraceManager", "@checkHasChanged, qqpimsecure is installed, cancel this time.");
        } else {
          localsb.a.post(new sb.1(localsb, this));
        }
      }
      catch (Exception localException)
      {
        xv.c(localException.getMessage());
      }
    }
    if (Build.VERSION.SDK_INT < 18) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.PushService
 * JD-Core Version:    0.7.0.1
 */