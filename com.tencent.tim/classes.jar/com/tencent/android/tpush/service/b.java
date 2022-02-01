package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.mqttchannel.api.MqttChannel;

public class b
{
  private static Context a = null;
  private static String b = "";
  private static LocalServerSocket c = null;
  private static LocalServerSocket d = null;
  private static volatile boolean e = false;
  private static volatile boolean f = false;
  private static volatile boolean g = false;
  private static boolean h = false;
  private static ServiceConnection i = null;
  private Handler j = null;
  
  private b()
  {
    b = AppInfos.getCurrentPackageName(e());
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, "com.tencent.android.xg.vip.action.keepalive", 0L);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    a(paramContext, "com.tencent.android.xg.vip.action.keepalive", paramLong);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    TLogger.d("PushServiceManager", "startService, action:" + paramString + ", delay:" + paramLong);
    if ((!PushPreferences.getBoolean(paramContext, "start_service_by_user", false)) && (AppInfos.forbidPullupService(paramContext))) {
      TLogger.ii("PushServiceManager", "startService abolish, XG_SERVICE_PULL_UP_OFF on manifest and never called by user");
    }
    for (;;)
    {
      return;
      if (paramContext != null) {}
      try
      {
        localObject = new Intent();
        try
        {
          ((Intent)localObject).setClass(paramContext, XGVipPushService.class);
          ((Intent)localObject).setAction(paramString);
          if (paramLong != 0L) {
            ((Intent)localObject).putExtra("delay_time", paramLong);
          }
          if (i.a(paramContext) > 0) {
            break label284;
          }
          paramContext.startService((Intent)localObject);
          if (!h)
          {
            i = new b.1();
            paramContext.bindService((Intent)localObject, i, 1);
            TLogger.d("PushServiceManager", "bindService ret:" + h);
            return;
          }
        }
        catch (Throwable localThrowable2)
        {
          paramString = (String)localObject;
          localObject = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Object localObject;
          label250:
          paramString = null;
        }
      }
    }
    TLogger.e("PushServiceManager", "startService failed, intent:" + paramString + ", ex:" + localObject);
    try
    {
      localObject = new Intent();
      try
      {
        ((Intent)localObject).setClass(paramContext, XGVipPushService.class);
        if (i.a(paramContext) > 0) {
          break label299;
        }
        paramContext.startService((Intent)localObject);
        return;
      }
      catch (Throwable paramContext)
      {
        paramString = (String)localObject;
      }
    }
    catch (Throwable paramContext)
    {
      break label250;
    }
    TLogger.e("PushServiceManager", "222 startService failed, intent:" + paramString + ", ex:" + paramContext);
    return;
    label284:
    TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
    paramContext.stopService((Intent)localObject);
    return;
    label299:
    TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
    paramContext.stopService((Intent)localObject);
  }
  
  public static boolean a()
  {
    return h;
  }
  
  public static b b()
  {
    return a.a;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null)
    {
      a = paramContext;
      TGlobalHelper.setContext(paramContext);
      b = paramContext.getPackageName();
    }
  }
  
  public static Context e()
  {
    if (a != null) {
      return a;
    }
    return XGPushManager.getContext();
  }
  
  public static ServiceConnection f()
  {
    return i;
  }
  
  public static void g()
  {
    i = null;
  }
  
  public static String h()
  {
    return b;
  }
  
  private void k()
  {
    this.j = new b.2(this, Looper.getMainLooper());
  }
  
  public void a(Intent paramIntent)
  {
    if (this.j == null) {
      k();
    }
    for (;;)
    {
      try
      {
        if (!e) {
          break;
        }
        if (paramIntent == null) {
          break label186;
        }
        Object localObject = paramIntent.getAction();
        TLogger.v("PushServiceManager", "Start Service with action " + (String)localObject);
        long l;
        if (localObject != null)
        {
          if (!"com.tencent.android.xg.vip.action.keepalive".equals(localObject)) {
            break label144;
          }
          localObject = this.j.obtainMessage(2);
          l = paramIntent.getLongExtra("delay_time", 0L);
          if (l == 0L)
          {
            this.j.removeMessages(2);
            this.j.sendMessageDelayed((Message)localObject, 100L);
          }
        }
        else
        {
          return;
        }
        this.j.removeMessages(2);
        this.j.sendMessageDelayed((Message)localObject, l);
        continue;
        if (!"com.tencent.android.xg.vip.action.stop_connect".equals(localObject)) {
          continue;
        }
      }
      finally {}
      label144:
      paramIntent = this.j.obtainMessage(3);
      this.j.removeMessages(3);
      this.j.sendMessageDelayed(paramIntent, 100L);
      continue;
      label186:
      TLogger.v("PushServiceManager", "Start Service with null action  but intent is not null");
      this.j.removeMessages(1);
      paramIntent = this.j.obtainMessage(1);
      this.j.sendMessageDelayed(paramIntent, 100L);
    }
    TLogger.d("PushServiceManager", "send WHAT_SERVICE_START msg at 100ms later on serviceStartHandler");
    this.j.removeMessages(1);
    paramIntent = this.j.obtainMessage(1);
    this.j.sendMessageDelayed(paramIntent, 100L);
  }
  
  public void c()
  {
    try
    {
      TLogger.d("PushServiceManager", "@@ serviceExit()");
      i.a();
      if (this.j != null)
      {
        this.j.removeCallbacksAndMessages(null);
        this.j = null;
      }
      if (CommonWorkingThread.getInstance().getHandler() != null) {
        CommonWorkingThread.getInstance().getHandler().removeCallbacksAndMessages(null);
      }
      a.a().c(a);
      MqttChannel.getInstance(a).stopConnect(null);
      d();
      f.e(e());
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("PushServiceManager", "unexpected for serviceExit:" + localThrowable.getMessage());
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 32	com/tencent/android/tpush/service/b:c	Landroid/net/LocalServerSocket;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull +13 -> 20
    //   10: getstatic 32	com/tencent/android/tpush/service/b:c	Landroid/net/LocalServerSocket;
    //   13: invokevirtual 299	android/net/LocalServerSocket:close	()V
    //   16: aconst_null
    //   17: putstatic 32	com/tencent/android/tpush/service/b:c	Landroid/net/LocalServerSocket;
    //   20: iconst_0
    //   21: invokestatic 305	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: invokevirtual 308	java/lang/Boolean:booleanValue	()Z
    //   27: putstatic 36	com/tencent/android/tpush/service/b:e	Z
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: ldc 72
    //   36: ldc_w 310
    //   39: aload_1
    //   40: invokestatic 313	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: goto -23 -> 20
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	b
    //   5	2	1	localLocalServerSocket	LocalServerSocket
    //   33	7	1	localThrowable	Throwable
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	20	33	java/lang/Throwable
    //   2	6	46	finally
    //   10	20	46	finally
    //   20	32	46	finally
    //   34	43	46	finally
    //   47	49	46	finally
  }
  
  public static class a
  {
    public static final b a = new b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b
 * JD-Core Version:    0.7.0.1
 */