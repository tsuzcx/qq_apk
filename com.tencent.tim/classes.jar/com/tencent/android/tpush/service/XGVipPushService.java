package com.tencent.android.tpush.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.k;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import org.json.JSONArray;
import org.json.JSONException;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.SERVICESCHECK})
public class XGVipPushService
  extends BaseMqttClientService
{
  private static volatile String b = null;
  private static long c = 0L;
  private static JSONArray d = null;
  private static long e = 270000L;
  private static Service f = null;
  Runnable a = new XGVipPushService.4(this);
  private Handler g;
  private boolean h = false;
  private com.tencent.android.tpush.service.channel.a i = new com.tencent.android.tpush.service.channel.a();
  private boolean j = false;
  
  public static Service a()
  {
    return f;
  }
  
  public static void a(Context paramContext)
  {
    CommonWorkingThread.getInstance().execute(new XGVipPushService.3(paramContext));
  }
  
  /* Error */
  private void a(Intent paramIntent, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 93
    //   4: new 95	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   11: ldc 98
    //   13: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 111	com/tencent/android/tpush/logging/TLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 115	com/tencent/android/tpush/service/XGVipPushService:getApplicationContext	()Landroid/content/Context;
    //   30: invokestatic 120	com/tencent/android/tpush/common/i:a	(Landroid/content/Context;)I
    //   33: ifle +20 -> 53
    //   36: ldc 93
    //   38: ldc 122
    //   40: invokestatic 125	com/tencent/android/tpush/logging/TLogger:ee	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 115	com/tencent/android/tpush/service/XGVipPushService:getApplicationContext	()Landroid/content/Context;
    //   47: invokestatic 129	com/tencent/android/tpush/service/util/f:e	(Landroid/content/Context;)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_1
    //   54: ifnull +71 -> 125
    //   57: getstatic 42	com/tencent/android/tpush/service/XGVipPushService:d	Lorg/json/JSONArray;
    //   60: ifnonnull +13 -> 73
    //   63: new 131	org/json/JSONArray
    //   66: dup
    //   67: invokespecial 132	org/json/JSONArray:<init>	()V
    //   70: putstatic 42	com/tencent/android/tpush/service/XGVipPushService:d	Lorg/json/JSONArray;
    //   73: aload_1
    //   74: invokevirtual 137	android/content/Intent:getAction	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_2
    //   79: invokestatic 140	com/tencent/android/tpush/common/i:b	(Ljava/lang/String;)Z
    //   82: ifne +43 -> 125
    //   85: getstatic 42	com/tencent/android/tpush/service/XGVipPushService:d	Lorg/json/JSONArray;
    //   88: ifnull +37 -> 125
    //   91: getstatic 42	com/tencent/android/tpush/service/XGVipPushService:d	Lorg/json/JSONArray;
    //   94: invokevirtual 144	org/json/JSONArray:length	()I
    //   97: istore_3
    //   98: iload_3
    //   99: bipush 10
    //   101: if_icmpge +24 -> 125
    //   104: aload_2
    //   105: ldc 146
    //   107: ldc 148
    //   109: invokevirtual 154	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   112: astore 4
    //   114: aload 4
    //   116: astore_2
    //   117: getstatic 42	com/tencent/android/tpush/service/XGVipPushService:d	Lorg/json/JSONArray;
    //   120: aload_2
    //   121: invokevirtual 158	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   124: pop
    //   125: aload_0
    //   126: invokespecial 160	com/tencent/android/tpush/service/XGVipPushService:c	()V
    //   129: invokestatic 165	com/tencent/android/tpush/service/b:b	()Lcom/tencent/android/tpush/service/b;
    //   132: aload_1
    //   133: invokevirtual 168	com/tencent/android/tpush/service/b:a	(Landroid/content/Intent;)V
    //   136: goto -86 -> 50
    //   139: astore_1
    //   140: ldc 93
    //   142: ldc 170
    //   144: aload_1
    //   145: invokestatic 173	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   148: goto -98 -> 50
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    //   156: astore 4
    //   158: ldc 93
    //   160: new 95	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   167: ldc 175
    //   169: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 4
    //   174: invokevirtual 178	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 181	com/tencent/android/tpush/logging/TLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto -69 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	XGVipPushService
    //   0	189	1	paramIntent	Intent
    //   0	189	2	paramString	String
    //   97	5	3	k	int
    //   112	3	4	str	String
    //   156	17	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   26	50	139	java/lang/Throwable
    //   57	73	139	java/lang/Throwable
    //   73	98	139	java/lang/Throwable
    //   117	125	139	java/lang/Throwable
    //   125	136	139	java/lang/Throwable
    //   158	186	139	java/lang/Throwable
    //   2	26	151	finally
    //   26	50	151	finally
    //   57	73	151	finally
    //   73	98	151	finally
    //   104	114	151	finally
    //   117	125	151	finally
    //   125	136	151	finally
    //   140	148	151	finally
    //   158	186	151	finally
    //   104	114	156	java/lang/Throwable
  }
  
  private void b(Context paramContext)
  {
    c();
    a(paramContext);
    c(paramContext);
  }
  
  private void c()
  {
    CommonWorkingThread.getInstance().execute(new XGVipPushService.1(this));
  }
  
  private void c(Context paramContext)
  {
    CommonWorkingThread.getInstance().execute(new XGVipPushService.2(this, paramContext));
  }
  
  private void d()
  {
    TLogger.d("XGVipPushService", "action - initCheckMessageHandler, on 60s later");
    this.g = new Handler();
    this.g.postDelayed(this.a, 60000L);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    TLogger.ii("XGVipPushService", "Service onBind()");
    if (!this.h)
    {
      a(paramIntent, "onBind");
      this.h = true;
    }
    return super.onBind(paramIntent);
  }
  
  public void onConnectComplete(boolean paramBoolean)
  {
    TLogger.ii("XGVipPushService", "onConnectComplete isReconnect:" + paramBoolean);
  }
  
  public void onConnectionLost()
  {
    TLogger.ii("XGVipPushService", "onConnectionLost");
  }
  
  public void onCreate()
  {
    super.onCreate();
    c = System.currentTimeMillis();
    f = this;
    Context localContext = getApplicationContext();
    b.b(localContext);
    ServiceStat.init(localContext);
    MqttChannel.getInstance(this).startConnect(null);
    a.a().b(localContext);
    b(localContext);
    TLogger.ii("XGVipPushService", "Service onCreate() : " + getPackageName());
    if (i.a(getApplicationContext()) > 0) {
      f.e(getApplicationContext());
    }
    d();
  }
  
  public void onDestroy()
  {
    b.b().c();
    TLogger.flush();
    super.onDestroy();
  }
  
  public void onHeartBeat()
  {
    TLogger.ii("XGVipPushService", "heartBeat");
    com.tencent.android.tpush.a.b(this);
    f.d(this);
  }
  
  public void onMessageArrived(String paramString1, String paramString2)
  {
    TLogger.ii("XGVipPushService", "onMessageArrived: topic:" + paramString1 + ", message:" + paramString2);
    if (i.b(this, paramString1)) {}
    try
    {
      paramString1 = new k();
      paramString1.a(paramString2);
      com.tencent.android.tpush.service.b.a.a().a(paramString1.b, paramString1.a, this.i);
      return;
    }
    catch (JSONException paramString1)
    {
      TLogger.ee("XGVipPushService", "decode push msg fail", paramString1);
      ServiceStat.reportErrCode(this, -101, "onMessageArrived:" + paramString2, 0L, "inner");
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    TLogger.i("XGVipPushService", "Service onStart() : " + getPackageName());
    super.onStart(paramIntent, paramInt);
  }
  
  @SuppressLint({"WrongConstant"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    TLogger.ii("XGVipPushService", "Service onStartCommand() : " + getPackageName());
    super.onStartCommand(paramIntent, 1, paramInt2);
    a(paramIntent, "onStartCommand");
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.XGVipPushService
 * JD-Core Version:    0.7.0.1
 */