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

public class PushService
  extends Service
{
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 3069: 
        do
        {
          do
          {
            return;
          } while ((paramAnonymousMessage.arg1 != 0) || (cp.a().b() <= 0));
          g.b("push:getIsAppForeground" + BaseActivity.getIsAppForeground());
          if (!BaseActivity.getIsAppForeground()) {
            break;
          }
          g.c("isshowingverify" + RqdApplication.b);
        } while (RqdApplication.b);
        try
        {
          new DualMsgShowDialog(BaseActivity.sTopActivity, 2131362156, 0, false, 0L).show();
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          return;
        }
        IndexActivity.setFromWhere(19);
        return;
      }
      paramAnonymousMessage = (f)paramAnonymousMessage.obj;
      PushService.a(PushService.this, paramAnonymousMessage);
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
    
    /* Error */
    public void onReceive(android.content.Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      // Byte code:
      //   0: aload_2
      //   1: invokevirtual 30	android/content/Intent:getAction	()Ljava/lang/String;
      //   4: ldc 32
      //   6: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   9: ifeq +138 -> 147
      //   12: aload_0
      //   13: getfield 14	com/tencent/token/core/push/PushService$1:a	Lcom/tencent/token/core/push/PushService;
      //   16: ldc 40
      //   18: invokevirtual 44	com/tencent/token/core/push/PushService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   21: checkcast 46	android/net/ConnectivityManager
      //   24: astore_1
      //   25: aload_1
      //   26: ifnonnull +4 -> 30
      //   29: return
      //   30: aload_1
      //   31: invokevirtual 50	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
      //   34: astore_1
      //   35: aload_1
      //   36: ifnull +81 -> 117
      //   39: aload_1
      //   40: invokevirtual 56	android/net/NetworkInfo:isConnected	()Z
      //   43: ifeq +74 -> 117
      //   46: invokestatic 61	com/tencent/token/core/push/b:a	()Lcom/tencent/token/core/push/b;
      //   49: iconst_1
      //   50: invokevirtual 64	com/tencent/token/core/push/b:a	(I)V
      //   53: aload_0
      //   54: getfield 19	com/tencent/token/core/push/PushService$1:b	Z
      //   57: istore_3
      //   58: iload_3
      //   59: ifeq +88 -> 147
      //   62: aload_0
      //   63: getfield 14	com/tencent/token/core/push/PushService$1:a	Lcom/tencent/token/core/push/PushService;
      //   66: invokestatic 66	com/tencent/token/core/push/PushService:a	(Lcom/tencent/token/core/push/PushService;)V
      //   69: aload_0
      //   70: iconst_0
      //   71: putfield 19	com/tencent/token/core/push/PushService$1:b	Z
      //   74: return
      //   75: astore_1
      //   76: aload_1
      //   77: invokevirtual 69	java/lang/Exception:printStackTrace	()V
      //   80: new 71	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 72	java/lang/StringBuilder:<init>	()V
      //   87: ldc 74
      //   89: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: aload_1
      //   93: invokevirtual 81	java/lang/Exception:toString	()Ljava/lang/String;
      //   96: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   102: invokestatic 88	com/tencent/token/global/g:d	(Ljava/lang/String;)V
      //   105: return
      //   106: astore_1
      //   107: aload_1
      //   108: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   111: invokestatic 94	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   114: goto -45 -> 69
      //   117: aload_0
      //   118: iconst_1
      //   119: putfield 19	com/tencent/token/core/push/PushService$1:b	Z
      //   122: invokestatic 61	com/tencent/token/core/push/b:a	()Lcom/tencent/token/core/push/b;
      //   125: bipush 7
      //   127: invokevirtual 64	com/tencent/token/core/push/b:a	(I)V
      //   130: aload_0
      //   131: getfield 14	com/tencent/token/core/push/PushService$1:a	Lcom/tencent/token/core/push/PushService;
      //   134: invokestatic 97	com/tencent/token/core/push/PushService:c	(Lcom/tencent/token/core/push/PushService;)Landroid/app/AlarmManager;
      //   137: aload_0
      //   138: getfield 14	com/tencent/token/core/push/PushService$1:a	Lcom/tencent/token/core/push/PushService;
      //   141: invokestatic 100	com/tencent/token/core/push/PushService:b	(Lcom/tencent/token/core/push/PushService;)Landroid/app/PendingIntent;
      //   144: invokevirtual 106	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
      //   147: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	1
      //   0	148	1	paramAnonymousContext	android.content.Context
      //   0	148	2	paramAnonymousIntent	Intent
      //   57	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   0	25	75	java/lang/Exception
      //   30	35	75	java/lang/Exception
      //   39	58	75	java/lang/Exception
      //   69	74	75	java/lang/Exception
      //   107	114	75	java/lang/Exception
      //   117	147	75	java/lang/Exception
      //   62	69	106	java/lang/Exception
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
      if ((!BaseActivity.getIsAppForeground()) || (paramf.d != 2)) {
        break label55;
      }
      cb.a().a(0L, cp.e, this.a);
      g.c("dualmsg::pushservice: query=true");
    }
    label55:
    do
    {
      return;
      localObject = (NotificationManager)getSystemService("notification");
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
          new a(this).a(1, getResources().getString(2131230844), new String(paramf.h), (PendingIntent)localObject);
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
        new a(this).a(1, getResources().getString(2131230844), new String(paramf.h), (PendingIntent)localObject);
        return;
      }
      g.c("push time=" + paramf.f);
    } while (cp.a().d() >= paramf.f);
    Object localObject = PendingIntent.getActivity(this, 0, this.e, 134217728);
    new a(this).a(2, getResources().getString(2131230844), new String(paramf.h), (PendingIntent)localObject);
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
        g.c(localException.getMessage());
      }
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.PushService
 * JD-Core Version:    0.7.0.1
 */