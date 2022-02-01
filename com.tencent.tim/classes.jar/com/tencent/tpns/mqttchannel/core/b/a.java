package com.tencent.tpns.mqttchannel.core.b;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.android.tpns.mqtt.IMqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.DNSResolver;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.core.common.b.c.a;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends c.a
  implements MqttCallbackExtended
{
  private static long b = ;
  private static boolean c = true;
  private static ExecutorService d = Executors.newSingleThreadExecutor();
  private static int k = 4;
  private static ConcurrentHashMap<Long, com.tencent.tpns.mqttchannel.core.common.b.a> w = new ConcurrentHashMap();
  private ReentrantLock A = new ReentrantLock();
  private volatile boolean B = false;
  private ReentrantLock C = new ReentrantLock();
  ReentrantLock a = new ReentrantLock();
  private volatile MqttAsyncClient e = null;
  private volatile MqttConnectState f = MqttConnectState.DISCONNECTED;
  private volatile int g = 0;
  private volatile int h = 0;
  private volatile int i = 0;
  private volatile int[] j = { 4, 16, 32, 64, 128 };
  private Context l;
  private Map<Long, Pair<com.tencent.tpns.mqttchannel.core.common.b.a, Runnable>> m = new ConcurrentHashMap();
  private boolean n;
  private Class o = null;
  private Handler p = null;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private volatile int t;
  private volatile int u;
  private List<com.tencent.tpns.mqttchannel.core.common.b.a> v = new CopyOnWriteArrayList();
  private Queue<com.tencent.tpns.mqttchannel.core.common.a.a> x = new ConcurrentLinkedQueue();
  private long y = 0L;
  private c z = null;
  
  a(Context paramContext)
  {
    this.l = paramContext;
    this.n = a(paramContext);
    this.q = GuidInfoManager.isServerDestroy(paramContext);
    d();
    this.t = GuidInfoManager.getEncryptLevel(paramContext);
    com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.t + ", compressLevel: " + this.u);
    if (this.p == null) {
      m();
    }
    f();
  }
  
  private static com.tencent.tpns.mqttchannel.core.common.b.a a(Long paramLong)
  {
    try
    {
      paramLong = (com.tencent.tpns.mqttchannel.core.common.b.a)w.remove(paramLong);
      return paramLong;
    }
    catch (Throwable paramLong)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "getTagAliasCallback", paramLong);
    }
    return null;
  }
  
  private void a(int paramInt, Message paramMessage)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handleTimeOut " + paramInt + " obj : " + paramMessage.obj);
    try
    {
      long l1 = ((com.tencent.tpns.mqttchannel.core.common.a.a)paramMessage.obj).a();
      paramMessage = c(Long.valueOf(l1));
      if ((paramMessage != null) && (paramMessage.a == 6)) {
        this.m.remove(Long.valueOf(paramMessage.a()));
      }
      paramMessage = b(Long.valueOf(l1));
      if (paramMessage != null) {
        d.execute(new a.11(this, paramMessage));
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Unknown msg " + paramInt, paramMessage);
    }
  }
  
  private void a(int paramInt, com.tencent.tpns.mqttchannel.core.common.a.a parama)
  {
    Message localMessage = new Message();
    localMessage.obj = parama;
    localMessage.what = paramInt;
    if (!this.p.hasMessages(paramInt, Long.valueOf(parama.a()))) {
      this.p.sendMessageDelayed(localMessage, 30000L);
    }
  }
  
  private void a(a parama, String paramString)
  {
    CommonWorkingThread.getInstance().execute(new a.9(this, parama, paramString));
  }
  
  private void a(com.tencent.tpns.mqttchannel.core.common.a.a parama)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - handMQTTMsg");
    switch (parama.a)
    {
    default: 
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Error type of MQTTMessage");
    case 4: 
      return;
    case 2: 
      f(parama, a(Long.valueOf(parama.a())));
      return;
    case 1: 
      g(parama, a(Long.valueOf(parama.a())));
      return;
    case 3: 
      h(parama, a(Long.valueOf(parama.a())));
      return;
    case 6: 
      com.tencent.tpns.mqttchannel.core.common.b.a locala = a(Long.valueOf(parama.a()));
      if (this.t == 1)
      {
        if (this.u == 1)
        {
          a(parama, locala, "_xg/rpc/send/gzip_aes");
          return;
        }
        a(parama, locala, "_xg/rpc/send/aes");
        return;
      }
      if (this.u == 1)
      {
        a(parama, locala, "_xg/rpc/send/gzip");
        return;
      }
      a(parama, locala, "_xg/rpc/send");
      return;
    }
    f(parama, a(Long.valueOf(parama.a())));
  }
  
  private void a(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1, String paramString)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRealRequest");
    switch (a.13.a[e().ordinal()])
    {
    default: 
      e(parama, parama1);
      a(null);
    case 1: 
      JSONObject localJSONObject;
      for (;;)
      {
        return;
        if (this.f != MqttConnectState.SUBTOPICS)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "sub topic not finish!");
          e(parama, parama1);
          return;
        }
        if (this.e.getClientId() == null)
        {
          a(parama1, -102, "sendRealRequest token is null");
          return;
        }
        parama.a(this.e.getClientId());
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "sendRequest " + parama);
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("id", parama.a());
          localJSONObject.put("cmd", parama.b());
          localJSONObject.put("paramsMd5", parama.f());
          localJSONObject.put("params", new JSONObject(parama.c()));
          localObject1 = new a.16(this, parama, parama1, paramString);
          this.m.put(Long.valueOf(parama.a()), new Pair(parama1, localObject1));
          CommonWorkingThread.getInstance().execute((Runnable)localObject1, 10000L);
          try
          {
            if (!paramString.equals("_xg/rpc/send/gzip_aes")) {
              break label557;
            }
            localObject1 = localJSONObject.toString();
            localObject2 = CommonHelper.encodeGZipContent(((String)localObject1).getBytes());
            if (localObject2 != null) {
              break;
            }
            a(parama1, -706, "sendRequest " + parama.b() + " compress failed");
            return;
          }
          catch (Throwable paramString)
          {
            b(1010, parama);
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest error MqttException ", paramString);
            localObject1 = (Pair)this.m.remove(Long.valueOf(parama.a()));
          }
          if (localObject1 != null)
          {
            CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable)((Pair)localObject1).second);
            if (this.i < 1) {
              break label794;
            }
            a(parama1, -701, "sendRequest error: " + paramString.toString());
            return;
          }
        }
        catch (JSONException paramString)
        {
          b(1010, parama);
          a(parama1, -101, "sendRealRequest JSONException: " + paramString);
          return;
        }
      }
      com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + ((String)localObject1).length() + ", after: " + localObject2.length);
      Object localObject2 = Security.encryptSrvData((byte[])localObject2);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(parama1, -704, "sendRequest " + parama.b() + " encrypt failed");
        return;
        label557:
        if (!paramString.equals("_xg/rpc/send/gzip")) {
          break label711;
        }
        localObject2 = localJSONObject.toString();
        localObject1 = CommonHelper.encodeGZipContent(((String)localObject2).getBytes());
        if (localObject1 == null)
        {
          a(parama1, -706, "sendRequest " + parama.b() + " compress failed");
          return;
        }
        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + ((String)localObject2).length() + ", after: " + localObject1.length);
      }
      for (;;)
      {
        localObject1 = new MqttMessage((byte[])localObject1);
        ((MqttMessage)localObject1).setQos(1);
        this.e.publish(paramString, (MqttMessage)localObject1, null, new a.17(this, parama, paramString, localJSONObject, parama1));
        return;
        label711:
        if (paramString.equals("_xg/rpc/send/aes"))
        {
          localObject2 = Security.encryptSrvData(localJSONObject.toString().getBytes());
          localObject1 = localObject2;
          if (localObject2 == null) {
            a(parama1, -704, "sendRequest " + parama.b() + " encrypt failed");
          }
        }
        else
        {
          localObject1 = localJSONObject.toString().getBytes();
        }
      }
      label794:
      this.i += 1;
      com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "stop connect and retry sendRequest");
      b(new a.18(this, parama, parama1));
      return;
    }
    e(parama, parama1);
  }
  
  private void a(com.tencent.tpns.mqttchannel.core.common.b.a parama, int paramInt, String paramString)
  {
    if (parama != null) {}
    try
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - doCallback, code:" + paramInt + ", message:" + paramString);
      parama.handleCallback(paramInt, paramString);
      return;
    }
    catch (Throwable parama)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Callback code:" + paramInt + ", message:" + paramString + " RemoteException:", parama);
    }
  }
  
  private static void a(Long paramLong, com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    try
    {
      if (w.size() > 2000)
      {
        ArrayList localArrayList = new ArrayList(w.keySet());
        Collections.sort(localArrayList);
        w.remove(localArrayList.get(0));
      }
      w.put(paramLong, parama);
      return;
    }
    catch (Throwable paramLong)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "putTagAliasCallback", paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.B = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      this.o = Class.forName("com.tencent.android.tpush.service.XGVipPushService");
      Intent localIntent = new Intent(paramContext, this.o);
      localIntent.setPackage(paramContext.getPackageName());
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, querey intent info is null or empty");
    }
    catch (Throwable paramContext)
    {
      try
      {
        paramContext = paramContext.getPackageManager().queryIntentServices(localIntent, 512);
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label89;
        }
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Has Xgpush!!!");
        return true;
      }
      catch (Throwable paramContext)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, querey intent fail");
        return false;
      }
      paramContext = paramContext;
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "No Xgpush, Not found xgpush class");
      return false;
    }
    label89:
    return false;
  }
  
  private com.tencent.tpns.mqttchannel.core.common.b.a b(Long paramLong)
  {
    int i2 = 0;
    int i1 = 0;
    try
    {
      Iterator localIterator = this.x.iterator();
      i2 = i1;
      int i3 = i1;
      if (localIterator.hasNext())
      {
        i2 = i1;
        com.tencent.tpns.mqttchannel.core.common.a.a locala = (com.tencent.tpns.mqttchannel.core.common.a.a)localIterator.next();
        i2 = i1;
        if (paramLong.longValue() != locala.a()) {
          break label123;
        }
        i2 = i1;
        localIterator.remove();
        i1 = 1;
      }
      for (;;)
      {
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "removeCacheMessages", localThrowable);
      i3 = i2;
      if (i3 == 0) {
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "removeCacheMessages error id " + paramLong);
      }
      return a(paramLong);
    }
  }
  
  /* Error */
  private ArrayList<String> b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 620	com/tencent/tpns/baseapi/XGApiConfig:getAccessId	(Landroid/content/Context;)J
    //   6: invokestatic 626	com/tencent/tpns/baseapi/base/util/Util:checkAccessId	(J)Z
    //   9: ifeq +23 -> 32
    //   12: aload_1
    //   13: invokestatic 630	com/tencent/tpns/baseapi/XGApiConfig:getAccessKey	(Landroid/content/Context;)Ljava/lang/String;
    //   16: invokestatic 634	com/tencent/tpns/baseapi/base/util/Util:checkAccessKey	(Ljava/lang/String;)Z
    //   19: ifeq +13 -> 32
    //   22: aload_1
    //   23: invokestatic 637	com/tencent/tpns/baseapi/base/device/GuidInfoManager:getToken	(Landroid/content/Context;)Ljava/lang/String;
    //   26: invokestatic 641	com/tencent/tpns/mqttchannel/core/common/c/b:a	(Ljava/lang/String;)Z
    //   29: ifeq +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: aload_1
    //   35: invokestatic 646	com/tencent/tpns/baseapi/base/util/CloudManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tpns/baseapi/base/util/CloudManager;
    //   38: invokevirtual 649	com/tencent/tpns/baseapi/base/util/CloudManager:disablePullMsg	()Z
    //   41: ifne -9 -> 32
    //   44: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   47: lstore 5
    //   49: new 387	org/json/JSONObject
    //   52: dup
    //   53: invokespecial 388	org/json/JSONObject:<init>	()V
    //   56: astore 9
    //   58: aload_1
    //   59: invokestatic 620	com/tencent/tpns/baseapi/XGApiConfig:getAccessId	(Landroid/content/Context;)J
    //   62: lstore 7
    //   64: aload_1
    //   65: invokestatic 630	com/tencent/tpns/baseapi/XGApiConfig:getAccessKey	(Landroid/content/Context;)Ljava/lang/String;
    //   68: astore 10
    //   70: aload 9
    //   72: ldc_w 651
    //   75: lload 7
    //   77: invokevirtual 394	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload 9
    //   83: ldc_w 653
    //   86: aload 10
    //   88: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload 9
    //   94: ldc_w 655
    //   97: iconst_0
    //   98: invokevirtual 658	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload 9
    //   104: ldc_w 660
    //   107: ldc_w 662
    //   110: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 9
    //   116: ldc_w 664
    //   119: lload 5
    //   121: invokevirtual 394	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_1
    //   126: invokestatic 637	com/tencent/tpns/baseapi/base/device/GuidInfoManager:getToken	(Landroid/content/Context;)Ljava/lang/String;
    //   129: astore 10
    //   131: aload 10
    //   133: ifnull +14 -> 147
    //   136: aload 9
    //   138: ldc_w 666
    //   141: aload 10
    //   143: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: new 668	org/json/JSONArray
    //   150: dup
    //   151: invokespecial 669	org/json/JSONArray:<init>	()V
    //   154: astore 10
    //   156: aload_1
    //   157: lload 7
    //   159: invokestatic 673	com/tencent/tpns/baseapi/base/util/Util:getNotifiedMsgIds	(Landroid/content/Context;J)Ljava/lang/String;
    //   162: astore 11
    //   164: aload 11
    //   166: ifnull +86 -> 252
    //   169: aload 11
    //   171: invokevirtual 471	java/lang/String:length	()I
    //   174: ifle +78 -> 252
    //   177: aload_1
    //   178: invokevirtual 563	android/content/Context:getPackageName	()Ljava/lang/String;
    //   181: astore 12
    //   183: aload 11
    //   185: new 171	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   192: aload 12
    //   194: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 675
    //   200: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokevirtual 679	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore 11
    //   211: aload 11
    //   213: arraylength
    //   214: istore 4
    //   216: iconst_0
    //   217: istore_2
    //   218: iload_2
    //   219: iload 4
    //   221: if_icmpge +31 -> 252
    //   224: aload 11
    //   226: iload_2
    //   227: aaload
    //   228: astore 12
    //   230: aload 10
    //   232: aload 12
    //   234: iconst_1
    //   235: invokevirtual 683	java/lang/String:substring	(I)Ljava/lang/String;
    //   238: invokestatic 687	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   241: invokevirtual 690	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   244: pop
    //   245: iload_2
    //   246: iconst_1
    //   247: iadd
    //   248: istore_2
    //   249: goto -31 -> 218
    //   252: aload 9
    //   254: ldc_w 692
    //   257: aload 10
    //   259: invokevirtual 401	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: aload 9
    //   265: ldc_w 694
    //   268: iconst_1
    //   269: invokevirtual 658	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   272: pop
    //   273: aload_1
    //   274: aload_1
    //   275: invokestatic 697	com/tencent/tpns/baseapi/XGApiConfig:getOfflineMsgServerAddr	(Landroid/content/Context;)Ljava/lang/String;
    //   278: aload 9
    //   280: invokevirtual 435	org/json/JSONObject:toString	()Ljava/lang/String;
    //   283: aconst_null
    //   284: invokestatic 701	com/tencent/tpns/baseapi/base/util/CommonHelper:getOfflineMsg	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tpns/baseapi/core/net/HttpRequestCallback;)Ljava/lang/String;
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +10 -> 299
    //   292: aload_1
    //   293: invokevirtual 471	java/lang/String:length	()I
    //   296: ifgt +25 -> 321
    //   299: ldc 169
    //   301: ldc_w 703
    //   304: invokestatic 371	com/tencent/tpns/mqttchannel/core/common/c/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore_1
    //   310: ldc 169
    //   312: ldc_w 705
    //   315: aload_1
    //   316: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   319: aconst_null
    //   320: areturn
    //   321: new 387	org/json/JSONObject
    //   324: dup
    //   325: aload_1
    //   326: invokespecial 411	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   329: astore_1
    //   330: aload_1
    //   331: ldc_w 707
    //   334: invokevirtual 711	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   337: istore_2
    //   338: iload_2
    //   339: ifeq +58 -> 397
    //   342: ldc 169
    //   344: new 171	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 713
    //   354: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload_2
    //   358: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 715
    //   364: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: ldc_w 717
    //   371: invokevirtual 721	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 385	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aconst_null
    //   384: areturn
    //   385: astore_1
    //   386: ldc 169
    //   388: ldc_w 723
    //   391: aload_1
    //   392: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aconst_null
    //   396: areturn
    //   397: aload_1
    //   398: ldc_w 725
    //   401: invokevirtual 729	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   404: astore_1
    //   405: new 525	java/util/ArrayList
    //   408: dup
    //   409: invokespecial 730	java/util/ArrayList:<init>	()V
    //   412: astore 9
    //   414: aload_1
    //   415: ifnonnull +14 -> 429
    //   418: ldc 169
    //   420: ldc_w 732
    //   423: invokestatic 385	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: goto +67 -> 493
    //   429: ldc 169
    //   431: new 171	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 734
    //   441: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_1
    //   445: invokevirtual 735	org/json/JSONArray:length	()I
    //   448: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 385	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: iload_3
    //   458: istore_2
    //   459: iload_2
    //   460: aload_1
    //   461: invokevirtual 735	org/json/JSONArray:length	()I
    //   464: if_icmpge +29 -> 493
    //   467: aload 9
    //   469: aload_1
    //   470: iload_2
    //   471: invokevirtual 739	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   474: invokevirtual 435	org/json/JSONObject:toString	()Ljava/lang/String;
    //   477: invokevirtual 742	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   480: pop
    //   481: iload_2
    //   482: iconst_1
    //   483: iadd
    //   484: istore_2
    //   485: goto -26 -> 459
    //   488: astore 12
    //   490: goto -245 -> 245
    //   493: aload 9
    //   495: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	a
    //   0	496	1	paramContext	Context
    //   217	268	2	i1	int
    //   1	457	3	i2	int
    //   214	8	4	i3	int
    //   47	73	5	l1	long
    //   62	96	7	l2	long
    //   56	438	9	localObject1	Object
    //   68	190	10	localObject2	Object
    //   162	63	11	localObject3	Object
    //   181	52	12	str	String
    //   488	1	12	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   70	131	309	java/lang/Throwable
    //   136	147	309	java/lang/Throwable
    //   147	164	309	java/lang/Throwable
    //   169	216	309	java/lang/Throwable
    //   252	273	309	java/lang/Throwable
    //   321	338	385	java/lang/Throwable
    //   342	383	385	java/lang/Throwable
    //   397	414	385	java/lang/Throwable
    //   418	426	385	java/lang/Throwable
    //   429	457	385	java/lang/Throwable
    //   459	481	385	java/lang/Throwable
    //   230	245	488	java/lang/Throwable
  }
  
  private void b()
  {
    try
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - callAllConnectBackSuccess");
      if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(GuidInfoManager.getToken(this.l)))
      {
        Iterator localIterator = this.v.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.tpns.mqttchannel.core.common.b.a locala = (com.tencent.tpns.mqttchannel.core.common.b.a)localIterator.next();
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "callAllBackSucess");
          a(locala, 0, "success");
        }
      }
      c();
    }
    finally {}
    this.v.clear();
  }
  
  private void b(int paramInt, com.tencent.tpns.mqttchannel.core.common.a.a parama)
  {
    this.p.removeMessages(paramInt, parama);
    b(Long.valueOf(parama.a()));
  }
  
  private com.tencent.tpns.mqttchannel.core.common.a.a c(Long paramLong)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.tpns.mqttchannel.core.common.a.a locala = (com.tencent.tpns.mqttchannel.core.common.a.a)localIterator.next();
      if (paramLong.longValue() == locala.a()) {
        return locala;
      }
    }
    return null;
  }
  
  private void c()
  {
    try
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.tpns.mqttchannel.core.common.b.a locala = (com.tencent.tpns.mqttchannel.core.common.b.a)localIterator.next();
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "callAllConnectBackFailed");
        a(locala, -102, "connect failed beacuse token is null");
      }
    }
    finally {}
  }
  
  private void d()
  {
    int i1 = GuidInfoManager.getRefuseRate(this.l);
    if ((i1 > 0) && (new Random().nextInt(100) < i1))
    {
      this.r = true;
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Resources exceeded Limit, refuse this connect!");
      return;
    }
    this.r = false;
  }
  
  private b e()
  {
    if (this.e == null) {
      return b.c;
    }
    if ((this.e.isConnected()) && ((this.f == MqttConnectState.CONNECTED) || (this.f == MqttConnectState.SUBTOPICS))) {
      return b.a;
    }
    if (this.e.isConnecting()) {
      return b.b;
    }
    return b.d;
  }
  
  private void e(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "addCacheMessage " + parama);
    try
    {
      this.x.offer(parama);
      if (this.x.size() > 100) {
        this.x.poll();
      }
      if ((parama.a() > 0L) && (parama1 != null)) {
        a(Long.valueOf(parama.a()), parama1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "addCacheMessage", localThrowable);
      }
    }
  }
  
  private void e(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    try
    {
      if (this.v.size() > 100) {
        this.v.remove(0);
      }
      this.v.add(parama);
      return;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "ping starRtc at " + MqttConfigImpl.getKeepAliveInterval(this.l));
      Object localObject = new Intent("com.tencent.android.xg.vip.action.ACTION_SDK_KEEPALIVE");
      ((Intent)localObject).setPackage(this.l.getPackageName());
      localObject = PendingIntent.getBroadcast(this.l, 0, (Intent)localObject, 134217728);
      TPushAlarmManager.getAlarmManager(this.l).set(0, System.currentTimeMillis() + MqttConfigImpl.getKeepAliveInterval(this.l) * 1000, (PendingIntent)localObject, XGApiConfig.isPowerSaveMode(this.l));
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Alarm started with interval: " + MqttConfigImpl.getKeepAliveInterval(this.l));
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Alarm started failed ", localThrowable);
    }
  }
  
  private void f(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRealPublishData");
    switch (a.13.a[e().ordinal()])
    {
    default: 
      e(parama, parama1);
      a(null);
      return;
    case 1: 
      try
      {
        if (this.e.getClientId() == null)
        {
          a(parama1, -102, "sendPublishData token is null");
          return;
        }
      }
      catch (Throwable parama)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData error MqttException ", parama);
        a(parama1, -801, "sendPublishData error: " + parama);
        return;
      }
      parama.a(this.e.getClientId());
      MqttMessage localMqttMessage = new MqttMessage(parama.c().getBytes());
      localMqttMessage.setQos(1);
      this.e.publish(parama.b(), localMqttMessage, null, new a.19(this, parama, parama1));
      return;
    }
    e(parama, parama1);
  }
  
  private void f(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    CommonWorkingThread.getInstance().execute(new a.12(this, parama));
  }
  
  private void g()
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - ping");
    for (;;)
    {
      try
      {
        switch (a.13.a[e().ordinal()])
        {
        case 1: 
          a(null);
          Util.stopWakeCpu();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        i();
        Util.stopWakeCpu();
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "ping", localThrowable);
        return;
      }
      if (Math.abs(System.currentTimeMillis() - this.y) < 15000L) {
        break;
      }
      h();
      a();
      this.e.ping(new a.1(this));
      return;
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "The client is connecting");
      Util.stopWakeCpu();
      return;
    }
  }
  
  private void g(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - subscrbieReal");
    switch (a.13.a[e().ordinal()])
    {
    default: 
      e(parama, parama1);
      a(null);
      return;
    case 1: 
      try
      {
        this.e.subscribe(parama.b(), 1, null, new a.20(this, parama1, parama));
        return;
      }
      catch (Throwable parama)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie error MqttException ", parama);
        a(parama1, -901, "subscrbie error " + parama);
        return;
      }
    }
    e(parama, parama1);
  }
  
  /* Error */
  private void g(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 169
    //   4: ldc_w 919
    //   7: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 141	com/tencent/tpns/mqttchannel/core/b/a:A	Ljava/util/concurrent/locks/ReentrantLock;
    //   14: invokevirtual 922	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   17: aload_0
    //   18: invokespecial 356	com/tencent/tpns/mqttchannel/core/b/a:e	()Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   21: getstatic 800	com/tencent/tpns/mqttchannel/core/b/a$b:a	Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   24: if_acmpne +32 -> 56
    //   27: ldc 169
    //   29: ldc_w 924
    //   32: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: ifnull +12 -> 48
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: ldc_w 751
    //   45: invokespecial 317	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 141	com/tencent/tpns/mqttchannel/core/b/a:A	Ljava/util/concurrent/locks/ReentrantLock;
    //   52: invokevirtual 927	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: return
    //   56: aload_0
    //   57: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   60: ifnull +462 -> 522
    //   63: aload_0
    //   64: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   67: invokevirtual 930	com/tencent/tpns/mqttchannel/core/b/a$c:isAlive	()Z
    //   70: ifne +82 -> 152
    //   73: aload_0
    //   74: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   77: istore_3
    //   78: iload_3
    //   79: ifne +73 -> 152
    //   82: ldc 169
    //   84: ldc_w 932
    //   87: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   94: invokevirtual 935	com/tencent/tpns/mqttchannel/core/b/a$c:join	()V
    //   97: aload_0
    //   98: new 14	com/tencent/tpns/mqttchannel/core/b/a$c
    //   101: dup
    //   102: aload_0
    //   103: aload_1
    //   104: invokespecial 936	com/tencent/tpns/mqttchannel/core/b/a$c:<init>	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   107: putfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   110: aload_0
    //   111: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   114: invokevirtual 939	com/tencent/tpns/mqttchannel/core/b/a$c:start	()V
    //   117: aload_1
    //   118: ifnull -70 -> 48
    //   121: aload_0
    //   122: aload_1
    //   123: invokespecial 941	com/tencent/tpns/mqttchannel/core/b/a:e	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   126: goto -78 -> 48
    //   129: astore_1
    //   130: ldc 169
    //   132: ldc_w 943
    //   135: aload_1
    //   136: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -91 -> 48
    //   142: astore_1
    //   143: aload_0
    //   144: getfield 141	com/tencent/tpns/mqttchannel/core/b/a:A	Ljava/util/concurrent/locks/ReentrantLock;
    //   147: invokevirtual 927	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   150: aload_1
    //   151: athrow
    //   152: aload_0
    //   153: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   156: ifnull +230 -> 386
    //   159: aload_0
    //   160: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   163: invokevirtual 930	com/tencent/tpns/mqttchannel/core/b/a$c:isAlive	()Z
    //   166: ifeq +220 -> 386
    //   169: ldc 169
    //   171: new 171	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 945
    //   181: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   188: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 950
    //   194: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: invokespecial 356	com/tencent/tpns/mqttchannel/core/b/a:e	()Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   201: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: ldc_w 952
    //   207: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: iload_2
    //   217: bipush 25
    //   219: if_icmpge +18 -> 237
    //   222: ldc2_w 953
    //   225: invokestatic 960	java/lang/Thread:sleep	(J)V
    //   228: aload_0
    //   229: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   232: istore_3
    //   233: iload_3
    //   234: ifeq +374 -> 608
    //   237: aload_0
    //   238: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   241: ifne +103 -> 344
    //   244: ldc 169
    //   246: new 171	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 945
    //   256: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   263: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   266: ldc_w 962
    //   269: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   276: invokevirtual 930	com/tencent/tpns/mqttchannel/core/b/a$c:isAlive	()Z
    //   279: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   282: ldc_w 964
    //   285: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: invokespecial 356	com/tencent/tpns/mqttchannel/core/b/a:e	()Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   292: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 328	com/tencent/tpns/mqttchannel/core/common/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_0
    //   302: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   305: invokevirtual 967	com/tencent/tpns/mqttchannel/core/b/a$c:interrupt	()V
    //   308: ldc 169
    //   310: ldc_w 969
    //   313: invokestatic 328	com/tencent/tpns/mqttchannel/core/common/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: ldc 169
    //   318: ldc_w 971
    //   321: invokestatic 328	com/tencent/tpns/mqttchannel/core/common/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: new 14	com/tencent/tpns/mqttchannel/core/b/a$c
    //   328: dup
    //   329: aload_0
    //   330: aload_1
    //   331: invokespecial 936	com/tencent/tpns/mqttchannel/core/b/a$c:<init>	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   334: putfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   337: aload_0
    //   338: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   341: invokevirtual 939	com/tencent/tpns/mqttchannel/core/b/a$c:start	()V
    //   344: aload_1
    //   345: ifnull -297 -> 48
    //   348: aload_0
    //   349: aload_1
    //   350: invokespecial 941	com/tencent/tpns/mqttchannel/core/b/a:e	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   353: goto -305 -> 48
    //   356: astore 4
    //   358: ldc 169
    //   360: ldc_w 973
    //   363: aload 4
    //   365: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: goto -131 -> 237
    //   371: astore 4
    //   373: ldc 169
    //   375: ldc_w 975
    //   378: aload 4
    //   380: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   383: goto -75 -> 308
    //   386: aload_0
    //   387: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   390: ifeq +72 -> 462
    //   393: ldc 169
    //   395: new 171	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 977
    //   405: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_0
    //   409: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   412: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: ldc_w 962
    //   418: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   425: invokevirtual 930	com/tencent/tpns/mqttchannel/core/b/a$c:isAlive	()Z
    //   428: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   431: ldc_w 964
    //   434: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_0
    //   438: invokespecial 356	com/tencent/tpns/mqttchannel/core/b/a:e	()Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   441: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_1
    //   451: ifnull -403 -> 48
    //   454: aload_0
    //   455: aload_1
    //   456: invokespecial 941	com/tencent/tpns/mqttchannel/core/b/a:e	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   459: goto -411 -> 48
    //   462: ldc 169
    //   464: new 171	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 979
    //   474: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: invokespecial 789	com/tencent/tpns/mqttchannel/core/b/a:o	()Z
    //   481: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc_w 962
    //   487: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   494: invokevirtual 930	com/tencent/tpns/mqttchannel/core/b/a$c:isAlive	()Z
    //   497: invokevirtual 948	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   500: ldc_w 964
    //   503: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_0
    //   507: invokespecial 356	com/tencent/tpns/mqttchannel/core/b/a:e	()Lcom/tencent/tpns/mqttchannel/core/b/a$b;
    //   510: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 328	com/tencent/tpns/mqttchannel/core/common/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -471 -> 48
    //   522: ldc 169
    //   524: ldc_w 981
    //   527: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload_0
    //   531: new 14	com/tencent/tpns/mqttchannel/core/b/a$c
    //   534: dup
    //   535: aload_0
    //   536: aload_1
    //   537: invokespecial 936	com/tencent/tpns/mqttchannel/core/b/a$c:<init>	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   540: putfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   543: aload_0
    //   544: getfield 136	com/tencent/tpns/mqttchannel/core/b/a:z	Lcom/tencent/tpns/mqttchannel/core/b/a$c;
    //   547: invokevirtual 939	com/tencent/tpns/mqttchannel/core/b/a$c:start	()V
    //   550: aload_1
    //   551: ifnull -503 -> 48
    //   554: aload_0
    //   555: aload_1
    //   556: invokespecial 941	com/tencent/tpns/mqttchannel/core/b/a:e	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
    //   559: goto -511 -> 48
    //   562: astore_1
    //   563: ldc 169
    //   565: ldc_w 983
    //   568: aload_1
    //   569: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   572: goto -524 -> 48
    //   575: astore_1
    //   576: ldc 169
    //   578: ldc_w 985
    //   581: invokestatic 371	com/tencent/tpns/mqttchannel/core/common/c/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: return
    //   585: astore 4
    //   587: ldc 169
    //   589: ldc_w 985
    //   592: invokestatic 371	com/tencent/tpns/mqttchannel/core/common/c/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: goto -445 -> 150
    //   598: astore 4
    //   600: goto -372 -> 228
    //   603: astore 4
    //   605: goto -261 -> 344
    //   608: iload_2
    //   609: iconst_1
    //   610: iadd
    //   611: istore_2
    //   612: goto -396 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	a
    //   0	615	1	parama	com.tencent.tpns.mqttchannel.core.common.b.a
    //   1	611	2	i1	int
    //   77	157	3	bool	boolean
    //   356	8	4	localThrowable1	Throwable
    //   371	8	4	localThrowable2	Throwable
    //   585	1	4	localException	Exception
    //   598	1	4	localThrowable3	Throwable
    //   603	1	4	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   82	117	129	java/lang/Throwable
    //   121	126	129	java/lang/Throwable
    //   17	35	142	finally
    //   39	48	142	finally
    //   56	78	142	finally
    //   82	117	142	finally
    //   121	126	142	finally
    //   130	139	142	finally
    //   152	216	142	finally
    //   222	228	142	finally
    //   228	233	142	finally
    //   237	301	142	finally
    //   301	308	142	finally
    //   308	324	142	finally
    //   324	344	142	finally
    //   348	353	142	finally
    //   358	368	142	finally
    //   373	383	142	finally
    //   386	450	142	finally
    //   454	459	142	finally
    //   462	519	142	finally
    //   522	550	142	finally
    //   554	559	142	finally
    //   563	572	142	finally
    //   228	233	356	java/lang/Throwable
    //   301	308	371	java/lang/Throwable
    //   522	550	562	java/lang/Throwable
    //   554	559	562	java/lang/Throwable
    //   48	55	575	java/lang/Exception
    //   143	150	585	java/lang/Exception
    //   222	228	598	java/lang/Throwable
    //   324	344	603	java/lang/Throwable
  }
  
  private void h()
  {
    this.p.removeMessages(1006);
    this.p.sendEmptyMessageDelayed(1006, 10000L);
  }
  
  private void h(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - unSubscrbieReal");
    switch (a.13.a[e().ordinal()])
    {
    default: 
      e(parama, parama1);
      a(null);
      return;
    case 1: 
      try
      {
        this.e.unsubscribe(parama.b(), null, new a.2(this, parama, parama1));
        return;
      }
      catch (Throwable parama)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie error MqttException ", parama);
        a(parama1, -1001, "unSubscrbie error " + parama);
        return;
      }
    }
    e(parama, parama1);
  }
  
  private void h(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    if ((parama != null) && (this.v.remove(parama))) {
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "remove old callback success");
    }
    b();
  }
  
  private void i()
  {
    this.p.removeMessages(1006);
  }
  
  private void i(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    if (this.q)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed");
      a(parama, -3, "connect onFailure: Resources have been destroyed");
    }
    do
    {
      return;
      if (this.r)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources exceeded limit");
        a(parama, -4, "connect onFailure: Resources exceeded limit");
        return;
      }
    } while (!this.s);
    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed by cloud");
    a(parama, -4, "connect onFailure: Resources have been destroyed by cloud");
  }
  
  private void j()
  {
    try
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "destroyMqttClient");
      this.e.destroy();
      this.f = MqttConnectState.DISCONNECTED;
      CommonWorkingThread.getInstance().execute(new a.15(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "stopConnect close error:", localThrowable);
      }
    }
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        int i2 = CloudManager.getInstance(this.l).getRecons();
        int i1 = i2;
        if (i2 <= 0) {
          i1 = k;
        }
        this.g += 1;
        Object localObject1;
        if ((this.g <= i1) && (this.h <= k))
        {
          localObject1 = this.p.obtainMessage(1);
          this.p.removeMessages(1);
          if (this.g > this.j.length)
          {
            l1 = this.j[(this.j.length - 1)] * 1000;
            long l2;
            if (!DeviceInfos.isScreenOn(this.l))
            {
              l2 = l1;
              if (DeviceInfos.getChangedStatus(this.l) <= 0) {}
            }
            else
            {
              l2 = l1 / 2L;
            }
            this.p.sendMessageDelayed((Message)localObject1, l2);
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "tryReConnect -> retryCount:" + this.g + ", subRetryCount:" + this.h + ", delay:" + l2);
            return;
          }
          long l1 = this.j[(this.g - 1)] * 1000;
          continue;
        }
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "tryReConnect too times, give up connect retryCount: " + this.g + ", sub retryCount: " + this.h);
        try
        {
          if ((!c) && (System.currentTimeMillis() - b <= 1800000L)) {
            break label442;
          }
          localObject1 = b(this.l);
          if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
            break label333;
          }
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "can't get any offline msg");
        }
        catch (Throwable localThrowable)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "request for offline msg by http error", localThrowable);
        }
        continue;
        c = false;
      }
      finally {}
      label333:
      b = System.currentTimeMillis();
      Iterator localIterator = localObject2.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(new a.5(this, new com.tencent.tpns.mqttchannel.core.common.a.a(0L, "/_xg/push/" + XGApiConfig.getAccessId(this.l) + "/" + GuidInfoManager.getToken(this.l), str)), "doOfflineMsgByHttpArrived");
      }
      continue;
      label442:
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "get offline msg by HTTP time not reached");
    }
  }
  
  private void l()
  {
    for (;;)
    {
      try
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - initAfterConnected, encryptLevel:" + this.t);
        if (this.e != null)
        {
          localObject1 = this.e.getClientId();
          if (localObject1 == null) {}
        }
        try
        {
          if (this.t != 1) {
            break label210;
          }
          if (this.u != 1) {
            continue;
          }
          localObject1 = new String[2];
          localObject1[0] = com.tencent.tpns.mqttchannel.core.common.c.b.g(this.l, this.e.getClientId());
          localObject1[1] = com.tencent.tpns.mqttchannel.core.common.c.b.h(this.l, this.e.getClientId());
          MqttAsyncClient localMqttAsyncClient = this.e;
          a.8 local8 = new a.8(this);
          localMqttAsyncClient.subscribe((String[])localObject1, new int[] { 1, 1 }, null, local8);
        }
        catch (Throwable localThrowable)
        {
          this.h += 1;
          com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error MqttException ", localThrowable);
          continue;
        }
        return;
      }
      finally {}
      Object localObject1 = new String[2];
      localObject1[0] = com.tencent.tpns.mqttchannel.core.common.c.b.c(this.l, this.e.getClientId());
      localObject1[1] = com.tencent.tpns.mqttchannel.core.common.c.b.d(this.l, this.e.getClientId());
      continue;
      label210:
      String[] arrayOfString;
      if (this.u == 1)
      {
        arrayOfString = new String[2];
        arrayOfString[0] = com.tencent.tpns.mqttchannel.core.common.c.b.e(this.l, this.e.getClientId());
        arrayOfString[1] = com.tencent.tpns.mqttchannel.core.common.c.b.f(this.l, this.e.getClientId());
      }
      else
      {
        arrayOfString = new String[2];
        arrayOfString[0] = com.tencent.tpns.mqttchannel.core.common.c.b.a(this.l, this.e.getClientId());
        arrayOfString[1] = com.tencent.tpns.mqttchannel.core.common.c.b.b(this.l, this.e.getClientId());
      }
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  private void m()
  {
    if (this.p != null) {
      return;
    }
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "initHandler");
    this.p = new a.10(this);
  }
  
  private void n()
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handlePingTimeOut");
    p();
  }
  
  private boolean o()
  {
    return this.B;
  }
  
  private void p()
  {
    if (o()) {
      return;
    }
    try
    {
      if (this.C.isLocked())
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Handling ping failed, return this time");
        try
        {
          this.C.unlock();
          Util.stopWakeCpu();
          return;
        }
        catch (Exception localException1)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "pingLock Exception");
          return;
        }
      }
      this.C.lock();
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "handlePingFailed");
      b(null);
      if (q()) {
        a(null);
      }
      try
      {
        this.C.unlock();
        Util.stopWakeCpu();
        return;
      }
      catch (Exception localException2)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "pingLock Exception");
        return;
      }
      try
      {
        this.C.unlock();
        Util.stopWakeCpu();
        throw localObject;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "pingLock Exception");
        }
      }
    }
    finally {}
  }
  
  private boolean q()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Util.checkPermission(this.l, "android.permission.INTERNET"))
    {
      bool1 = bool2;
      if (!Util.checkPermission(this.l, "android.permission.ACCESS_NETWORK_STATE")) {}
    }
    try
    {
      Object localObject = (ConnectivityManager)this.l.getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isAvailable()))
        {
          bool1 = ((NetworkInfo)localObject).isConnected();
          if (!bool1) {}
        }
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 169
    //   4: ldc_w 1176
    //   7: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: ldc 169
    //   12: new 171	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1178
    //   22: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 132	com/tencent/tpns/mqttchannel/core/b/a:x	Ljava/util/Queue;
    //   29: invokeinterface 813 1 0
    //   34: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 385	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 132	com/tencent/tpns/mqttchannel/core/b/a:x	Ljava/util/Queue;
    //   47: invokeinterface 816 1 0
    //   52: checkcast 234	com/tencent/tpns/mqttchannel/core/common/a/a
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +46 -> 103
    //   60: ldc 169
    //   62: new 171	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1180
    //   72: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 232	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 1182	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/common/a/a;)V
    //   90: goto -47 -> 43
    //   93: astore_1
    //   94: ldc 169
    //   96: ldc_w 1184
    //   99: aload_1
    //   100: invokestatic 216	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   55	32	1	locala	com.tencent.tpns.mqttchannel.core.common.a.a
    //   93	7	1	localThrowable	Throwable
    //   106	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	43	93	java/lang/Throwable
    //   43	56	93	java/lang/Throwable
    //   60	90	93	java/lang/Throwable
    //   2	10	106	finally
    //   10	43	106	finally
    //   43	56	106	finally
    //   60	90	106	finally
    //   94	103	106	finally
  }
  
  public void a()
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "onHeartBeat ");
    if ((this.e != null) && (!this.e.isConnected()))
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "onHeartBeat: mqttAsyncClient not connect!");
      this.f = MqttConnectState.DISCONNECTED;
      f(null);
    }
    a(new a.6(this), "onHeartBeat");
  }
  
  public void a(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - sendRequest");
    if ((this.q) || (this.r) || (this.s))
    {
      i(parama1);
      return;
    }
    if (parama.a() > 0L) {
      a(1010, parama);
    }
    if (this.t == 1)
    {
      if (this.u == 1)
      {
        a(parama, parama1, "_xg/rpc/send/gzip_aes");
        return;
      }
      a(parama, parama1, "_xg/rpc/send/aes");
      return;
    }
    if (this.u == 1)
    {
      a(parama, parama1, "_xg/rpc/send/gzip");
      return;
    }
    a(parama, parama1, "_xg/rpc/send");
  }
  
  public void a(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - startConnect");
    f(parama);
  }
  
  public void b(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    if (parama.a() > 0L) {
      a(1001, parama);
    }
    f(parama, parama1);
  }
  
  public void b(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    for (;;)
    {
      try
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "stopConnect");
        if ((this.f != MqttConnectState.CONNECTED) && (this.f != MqttConnectState.CONNECTING) && (this.f != MqttConnectState.SUBTOPICS))
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Mqtt is not conneted");
          a(parama, 0, "Mqtt is not conneted");
          return;
        }
        if (this.e == null)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "stopConnect error: mqttAsyncClient is null");
          a(parama, -602, "stopConnect error: mqttAsyncClient is null");
          return;
        }
      }
      finally {}
      this.f = MqttConnectState.DISCONNECTING;
      try
      {
        this.e.disconnect(10000L, null, new a.14(this, parama));
      }
      catch (Throwable localThrowable)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "stopConnect error MqttException " + localThrowable.getMessage());
        this.f = MqttConnectState.DISCONNECTED;
        j();
        a(parama, -601, "stopConnect error MqttException: " + localThrowable);
      }
    }
  }
  
  public void c(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    if (parama.a() > 0L) {
      a(1002, parama);
    }
    g(parama, parama1);
  }
  
  public void c(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    a(parama, 0, this.f.toString());
  }
  
  public void connectComplete(boolean paramBoolean, String paramString)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "connectComplete: " + paramString + ", reconnect:" + paramBoolean);
    a(new a.3(this, paramBoolean), "doConnectComplete");
  }
  
  public void connectionLost(Throwable paramThrowable)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "connectionLost, cause:" + paramThrowable + " retryCount:" + this.g);
    paramThrowable.printStackTrace();
    this.f = MqttConnectState.DISCONNECTED;
    a(new a.4(this), "doConnectionLost");
    k();
  }
  
  public void d(com.tencent.tpns.mqttchannel.core.common.a.a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1)
  {
    if (parama.a() > 0L) {
      a(1003, parama);
    }
    h(parama, parama1);
  }
  
  public void d(com.tencent.tpns.mqttchannel.core.common.b.a parama)
  {
    g();
  }
  
  public void deliveryComplete(IMqttDeliveryToken paramIMqttDeliveryToken)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "action - deliveryComplete");
  }
  
  public void messageArrived(String paramString, MqttMessage paramMqttMessage)
  {
    if (paramMqttMessage == null)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived mqttMessage null");
      return;
    }
    Object localObject;
    if ((com.tencent.tpns.mqttchannel.core.common.c.b.i(this.l, paramString)) || (com.tencent.tpns.mqttchannel.core.common.c.b.k(this.l, paramString)) || (com.tencent.tpns.mqttchannel.core.common.c.b.m(this.l, paramString)) || (com.tencent.tpns.mqttchannel.core.common.c.b.o(this.l, paramString)))
    {
      try
      {
        if (!com.tencent.tpns.mqttchannel.core.common.c.b.o(this.l, paramString)) {
          break label166;
        }
        localObject = Security.decryptSrvData(paramMqttMessage.getPayload());
        if (localObject == null)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
          return;
        }
      }
      catch (Throwable paramString)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived handle RpcReceiveTopic throw JSONException " + paramString.toString() + ", payload: " + new String(paramMqttMessage.getPayload()));
        return;
      }
      byte[] arrayOfByte = CommonHelper.decodeGZipContent((byte[])localObject);
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response unzip after decrypt failed");
        return;
        label166:
        if (com.tencent.tpns.mqttchannel.core.common.c.b.m(this.l, paramString))
        {
          arrayOfByte = CommonHelper.decodeGZipContent(paramMqttMessage.getPayload());
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response unzip failed");
          }
        }
        else if (com.tencent.tpns.mqttchannel.core.common.c.b.k(this.l, paramString))
        {
          arrayOfByte = Security.decryptSrvData(paramMqttMessage.getPayload());
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
          }
        }
        else
        {
          localObject = paramMqttMessage.getPayload();
        }
      }
      localObject = new String((byte[])localObject);
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MessageArrived, rpc topic :" + paramString + ", payload:" + (String)localObject);
      paramString = new JSONObject((String)localObject);
      long l1 = paramString.getLong("id");
      int i1 = paramString.optInt("ret", 0);
      paramString = paramString.optString("result", "");
      localObject = (Pair)this.m.remove(Long.valueOf(l1));
      if (localObject != null)
      {
        CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable)((Pair)localObject).second);
        a((com.tencent.tpns.mqttchannel.core.common.b.a)((Pair)localObject).first, i1, paramString);
        return;
      }
      com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "Not found the rpc Request id");
      return;
    }
    if (com.tencent.tpns.mqttchannel.core.common.c.b.p(this.l, paramString))
    {
      paramMqttMessage = Security.decryptSrvData(paramMqttMessage.getPayload());
      if (paramMqttMessage == null)
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
        return;
      }
      localObject = CommonHelper.decodeGZipContent(paramMqttMessage);
      paramMqttMessage = (MqttMessage)localObject;
      if (localObject == null) {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message unzip after decrypt failed");
      }
    }
    else if (com.tencent.tpns.mqttchannel.core.common.c.b.n(this.l, paramString))
    {
      localObject = CommonHelper.decodeGZipContent(paramMqttMessage.getPayload());
      paramMqttMessage = (MqttMessage)localObject;
      if (localObject == null) {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message unzip failed");
      }
    }
    else if (com.tencent.tpns.mqttchannel.core.common.c.b.l(this.l, paramString))
    {
      localObject = Security.decryptSrvData(paramMqttMessage.getPayload());
      paramMqttMessage = (MqttMessage)localObject;
      if (localObject == null) {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
      }
    }
    else
    {
      paramMqttMessage = paramMqttMessage.getPayload();
    }
    paramMqttMessage = new String(paramMqttMessage);
    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MessageArrived, topic :" + paramString + ", payload:" + paramMqttMessage);
    a(new a.7(this, new com.tencent.tpns.mqttchannel.core.common.a.a(0L, paramString, paramMqttMessage)), "doMessageArrived");
  }
  
  static abstract interface a
  {
    public abstract void a(com.tencent.tpns.mqttchannel.core.common.b.b paramb);
  }
  
  public static enum b
  {
    private b() {}
  }
  
  class c
    extends Thread
  {
    com.tencent.tpns.mqttchannel.core.common.b.a a;
    
    c(com.tencent.tpns.mqttchannel.core.common.b.a parama)
    {
      this.a = parama;
    }
    
    private GUIDInfo a()
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "getFinalMqttServerAddrAndGuidInfo");
      Object localObject3 = new GUIDInfo();
      if (GuidInfoManager.isServerDestroy(a.g(a.this)))
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "getFinalMqttServerAddrAndGuidInfo: Resources have been destroyed");
        ((GUIDInfo)localObject3).errCode = 10030006;
        return localObject3;
      }
      Object localObject2;
      Object localObject1;
      if (GuidInfoManager.isExpired(a.g(a.this)))
      {
        com.tencent.tpns.mqttchannel.core.common.c.a.c("IMqttServiceImpl", "Guid expired, request for new one.");
        localObject2 = GuidInfoManager.refreshConnectInfoSynchronized(a.g(a.this), 0, null);
        if (((GUIDInfo)localObject2).isError())
        {
          if (((GUIDInfo)localObject2).errCode == 10030006)
          {
            com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Get guidServer error GUID_SERVER_DESTROY, directly return");
            return localObject2;
          }
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get guidServer error, guid == null;");
          localObject1 = GUIDInfo.getGuidInfoFromShar(a.g(a.this));
          if (((GUIDInfo)localObject1).isError()) {
            break label755;
          }
        }
      }
      for (;;)
      {
        ((GUIDInfo)localObject1).mqttServerIP = GuidInfoManager.getMqttServerIP(a.g(a.this));
        return localObject1;
        localObject1 = DNSResolver.hostToIp(((GUIDInfo)localObject2).mqttServer, ((GUIDInfo)localObject2).mqttPortList);
        if (com.tencent.tpns.mqttchannel.core.common.c.b.a((String)localObject1))
        {
          localObject1 = GuidInfoManager.getMqttServerIP(a.g(a.this));
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MqttServer domain resolver failed, get from shar: " + (String)localObject1);
        }
        for (;;)
        {
          ((GUIDInfo)localObject2).mqttServerIP = ((String)localObject1);
          return localObject2;
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get MqttServer: " + ((GUIDInfo)localObject2).mqttServer + ", save address: " + (String)localObject1);
          GuidInfoManager.setMqttServerIP(a.g(a.this), (String)localObject1);
          GuidInfoManager.setMqttServerRefreshTime(a.g(a.this), System.currentTimeMillis());
        }
        com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "GuidInfo not expired. Check mqttServer");
        localObject1 = GuidInfoManager.getMqttServerIP(a.g(a.this));
        if (GuidInfoManager.isMqttServerExpired(a.g(a.this)))
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Mqtt expired. Last MqttServer address: " + (String)localObject1);
          localObject2 = GUIDInfo.getGuidInfoFromShar(a.g(a.this));
          if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(((GUIDInfo)localObject2).mqttServer))
          {
            localObject3 = DNSResolver.hostToIp(((GUIDInfo)localObject2).mqttServer, ((GUIDInfo)localObject2).mqttPortList);
            if (com.tencent.tpns.mqttchannel.core.common.c.b.a((String)localObject3))
            {
              ((GUIDInfo)localObject2).mqttServerIP = ((String)localObject1);
              return localObject2;
            }
            if (localObject1 != null)
            {
              int i = ((String)localObject1).lastIndexOf(":");
              int j = ((String)localObject3).lastIndexOf(":");
              Object localObject4;
              Object localObject5;
              if (i > 0)
              {
                localObject4 = ((String)localObject1).substring(0, i);
                if (j <= 0) {
                  break label499;
                }
                localObject5 = ((String)localObject3).substring(0, j);
              }
              for (;;)
              {
                if (!((String)localObject4).equals(localObject5))
                {
                  com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "MqttServerAddr changed, request guidServer for new one.");
                  localObject3 = GuidInfoManager.refreshConnectInfoSynchronized(a.g(a.this), 1, null);
                  if (GuidInfoManager.isServerDestroy(a.g(a.this)))
                  {
                    com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "Resources have been destroyed");
                    ((GUIDInfo)localObject2).errCode = 10030006;
                    return localObject2;
                    localObject4 = localObject1;
                    break;
                    label499:
                    localObject5 = localObject3;
                    continue;
                  }
                  if ((localObject3 == null) || (((GUIDInfo)localObject3).isError()))
                  {
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get new server guid error, get guid and finalMqttServerAddr from Shar");
                    ((GUIDInfo)localObject2).mqttServerIP = ((String)localObject1);
                    return localObject2;
                  }
                  if (!com.tencent.tpns.mqttchannel.core.common.c.b.a(((GUIDInfo)localObject3).mqttServer))
                  {
                    localObject4 = DNSResolver.hostToIp(((GUIDInfo)localObject3).mqttServer, ((GUIDInfo)localObject3).mqttPortList);
                    if (com.tencent.tpns.mqttchannel.core.common.c.b.a((String)localObject4)) {
                      break label748;
                    }
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Get MqttServer: " + ((GUIDInfo)localObject3).mqttServer + ", save address: " + (String)localObject4);
                    GuidInfoManager.setMqttServerIP(a.g(a.this), (String)localObject4);
                    GuidInfoManager.setMqttServerRefreshTime(a.g(a.this), System.currentTimeMillis());
                    localObject2 = localObject3;
                    localObject1 = localObject4;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Guid status: " + localObject2);
          localObject3 = localObject2;
          if (localObject2 == null) {
            break;
          }
          localObject3 = localObject2;
          if (((GUIDInfo)localObject2).isError()) {
            break;
          }
          ((GUIDInfo)localObject2).mqttServerIP = ((String)localObject1);
          return localObject2;
          com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "get new server guid error");
          continue;
          localObject1 = localObject3;
          continue;
          localObject1 = localObject3;
          continue;
          com.tencent.tpns.mqttchannel.core.common.c.a.e("IMqttServiceImpl", "get local GUIDInfo guid error");
          continue;
          com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "MqttServer not expired.");
          localObject2 = GUIDInfo.getGuidInfoFromShar(a.g(a.this));
          continue;
          label748:
          localObject2 = localObject3;
        }
        label755:
        localObject1 = localObject2;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 24
      //   2: new 106	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   9: ldc 183
      //   11: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: aload_0
      //   15: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   18: invokestatic 186	com/tencent/tpns/mqttchannel/core/b/a:c	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   21: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   24: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   27: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   30: aload_0
      //   31: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   34: invokestatic 186	com/tencent/tpns/mqttchannel/core/b/a:c	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   37: getstatic 192	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTED	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   40: if_acmpeq +16 -> 56
      //   43: aload_0
      //   44: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   47: invokestatic 186	com/tencent/tpns/mqttchannel/core/b/a:c	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   50: getstatic 195	com/tencent/tpns/mqttchannel/api/MqttConnectState:SUBTOPICS	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   53: if_acmpne +32 -> 85
      //   56: ldc 24
      //   58: ldc 197
      //   60: invokestatic 163	com/tencent/tpns/mqttchannel/core/common/c/a:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   63: aload_0
      //   64: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   67: ifnull +17 -> 84
      //   70: aload_0
      //   71: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   74: aload_0
      //   75: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   78: iconst_0
      //   79: ldc 199
      //   81: invokestatic 202	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
      //   84: return
      //   85: aload_0
      //   86: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   89: invokestatic 205	com/tencent/tpns/mqttchannel/core/b/a:d	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Z
      //   92: ifeq +11 -> 103
      //   95: ldc 24
      //   97: ldc 207
      //   99: invokestatic 163	com/tencent/tpns/mqttchannel/core/common/c/a:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   102: return
      //   103: aload_0
      //   104: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   107: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   110: invokevirtual 215	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   113: aload_0
      //   114: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   117: iconst_1
      //   118: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   121: aload_0
      //   122: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   125: invokestatic 220	com/tencent/tpns/mqttchannel/core/b/a:e	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Z
      //   128: ifne +13 -> 141
      //   131: aload_0
      //   132: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   135: invokestatic 223	com/tencent/tpns/mqttchannel/core/b/a:f	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Z
      //   138: ifeq +44 -> 182
      //   141: aload_0
      //   142: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   145: aload_0
      //   146: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   149: invokestatic 225	com/tencent/tpns/mqttchannel/core/b/a:b	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
      //   152: aload_0
      //   153: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   156: getstatic 228	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTFAIL	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   159: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   162: pop
      //   163: aload_0
      //   164: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   167: iconst_0
      //   168: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   171: aload_0
      //   172: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   175: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   178: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   181: return
      //   182: aload_0
      //   183: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   186: getstatic 237	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTING	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   189: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   192: pop
      //   193: aload_0
      //   194: invokespecial 239	com/tencent/tpns/mqttchannel/core/b/a$c:a	()Lcom/tencent/tpns/baseapi/base/device/GUIDInfo;
      //   197: astore_2
      //   198: aload_2
      //   199: ifnull +10 -> 209
      //   202: aload_2
      //   203: invokevirtual 69	com/tencent/tpns/baseapi/base/device/GUIDInfo:isError	()Z
      //   206: ifeq +81 -> 287
      //   209: aload_2
      //   210: ifnonnull +55 -> 265
      //   213: aload_0
      //   214: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   217: aload_0
      //   218: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   221: bipush 251
      //   223: ldc 241
      //   225: invokestatic 202	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
      //   228: aload_0
      //   229: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   232: getstatic 228	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTFAIL	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   235: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   238: pop
      //   239: ldc 24
      //   241: ldc 243
      //   243: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   246: aload_0
      //   247: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   250: iconst_0
      //   251: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   254: aload_0
      //   255: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   258: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   261: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   264: return
      //   265: aload_0
      //   266: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   269: aload_0
      //   270: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   273: aload_2
      //   274: getfield 54	com/tencent/tpns/baseapi/base/device/GUIDInfo:errCode	I
      //   277: aload_2
      //   278: getfield 246	com/tencent/tpns/baseapi/base/device/GUIDInfo:result	Ljava/lang/String;
      //   281: invokestatic 202	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
      //   284: goto -56 -> 228
      //   287: aload_0
      //   288: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   291: aload_0
      //   292: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   295: invokestatic 38	com/tencent/tpns/mqttchannel/core/b/a:g	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Landroid/content/Context;
      //   298: invokestatic 252	com/tencent/tpns/baseapi/base/util/CloudManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tpns/baseapi/base/util/CloudManager;
      //   301: invokevirtual 255	com/tencent/tpns/baseapi/base/util/CloudManager:shouldRefuse	()Z
      //   304: invokestatic 258	com/tencent/tpns/mqttchannel/core/b/a:b	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)Z
      //   307: pop
      //   308: ldc 24
      //   310: new 106	java/lang/StringBuilder
      //   313: dup
      //   314: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   317: ldc_w 260
      //   320: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   323: aload_0
      //   324: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   327: invokestatic 263	com/tencent/tpns/mqttchannel/core/b/a:h	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Z
      //   330: invokevirtual 266	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   333: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   336: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   339: aload_0
      //   340: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   343: invokestatic 263	com/tencent/tpns/mqttchannel/core/b/a:h	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Z
      //   346: ifeq +44 -> 390
      //   349: aload_0
      //   350: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   353: aload_0
      //   354: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   357: invokestatic 225	com/tencent/tpns/mqttchannel/core/b/a:b	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
      //   360: aload_0
      //   361: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   364: getstatic 228	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTFAIL	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   367: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   370: pop
      //   371: aload_0
      //   372: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   375: iconst_0
      //   376: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   379: aload_0
      //   380: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   383: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   386: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   389: return
      //   390: aload_0
      //   391: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   394: aload_2
      //   395: getfield 269	com/tencent/tpns/baseapi/base/device/GUIDInfo:encrypt	I
      //   398: invokestatic 272	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;I)I
      //   401: pop
      //   402: aload_0
      //   403: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   406: aload_0
      //   407: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   410: invokestatic 38	com/tencent/tpns/mqttchannel/core/b/a:g	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Landroid/content/Context;
      //   413: invokestatic 252	com/tencent/tpns/baseapi/base/util/CloudManager:getInstance	(Landroid/content/Context;)Lcom/tencent/tpns/baseapi/base/util/CloudManager;
      //   416: invokevirtual 276	com/tencent/tpns/baseapi/base/util/CloudManager:getCompressLevel	()I
      //   419: invokestatic 278	com/tencent/tpns/mqttchannel/core/b/a:b	(Lcom/tencent/tpns/mqttchannel/core/b/a;I)I
      //   422: pop
      //   423: ldc 24
      //   425: new 106	java/lang/StringBuilder
      //   428: dup
      //   429: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   432: ldc_w 280
      //   435: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   438: aload_0
      //   439: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   442: invokestatic 284	com/tencent/tpns/mqttchannel/core/b/a:i	(Lcom/tencent/tpns/mqttchannel/core/b/a;)I
      //   445: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   448: ldc_w 289
      //   451: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   454: aload_0
      //   455: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   458: invokestatic 292	com/tencent/tpns/mqttchannel/core/b/a:j	(Lcom/tencent/tpns/mqttchannel/core/b/a;)I
      //   461: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   464: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   467: invokestatic 61	com/tencent/tpns/mqttchannel/core/common/c/a:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   470: aload_2
      //   471: getfield 87	com/tencent/tpns/baseapi/base/device/GUIDInfo:mqttServerIP	Ljava/lang/String;
      //   474: astore_1
      //   475: ldc 24
      //   477: new 106	java/lang/StringBuilder
      //   480: dup
      //   481: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   484: ldc_w 294
      //   487: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   490: aload_1
      //   491: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: ldc_w 296
      //   497: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   500: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   503: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   506: aload_0
      //   507: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   510: invokestatic 38	com/tencent/tpns/mqttchannel/core/b/a:g	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Landroid/content/Context;
      //   513: invokestatic 301	com/tencent/tpns/baseapi/XGApiConfig:getDebugMQTTServer	(Landroid/content/Context;)Ljava/lang/String;
      //   516: invokestatic 104	com/tencent/tpns/mqttchannel/core/common/c/b:a	(Ljava/lang/String;)Z
      //   519: ifne +14 -> 533
      //   522: aload_0
      //   523: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   526: invokestatic 38	com/tencent/tpns/mqttchannel/core/b/a:g	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Landroid/content/Context;
      //   529: invokestatic 301	com/tencent/tpns/baseapi/XGApiConfig:getDebugMQTTServer	(Landroid/content/Context;)Ljava/lang/String;
      //   532: astore_1
      //   533: ldc 24
      //   535: new 106	java/lang/StringBuilder
      //   538: dup
      //   539: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   542: ldc_w 303
      //   545: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   548: aload_1
      //   549: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   552: ldc_w 305
      //   555: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   558: aload_0
      //   559: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   562: invokestatic 186	com/tencent/tpns/mqttchannel/core/b/a:c	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   565: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   568: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   571: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   574: ldc 24
      //   576: new 106	java/lang/StringBuilder
      //   579: dup
      //   580: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   583: ldc_w 307
      //   586: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   589: aload_2
      //   590: getfield 310	com/tencent/tpns/baseapi/base/device/GUIDInfo:token	Ljava/lang/String;
      //   593: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   596: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   599: invokestatic 75	com/tencent/tpns/mqttchannel/core/common/c/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   602: aload_0
      //   603: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   606: invokestatic 314	com/tencent/tpns/mqttchannel/core/b/a:k	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/android/tpns/mqtt/MqttAsyncClient;
      //   609: astore_3
      //   610: aload_3
      //   611: ifnull +11 -> 622
      //   614: aload_0
      //   615: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   618: aconst_null
      //   619: invokevirtual 317	com/tencent/tpns/mqttchannel/core/b/a:b	(Lcom/tencent/tpns/mqttchannel/core/common/b/a;)V
      //   622: aload_0
      //   623: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   626: new 319	com/tencent/android/tpns/mqtt/MqttAsyncClient
      //   629: dup
      //   630: aload_1
      //   631: aload_2
      //   632: getfield 310	com/tencent/tpns/baseapi/base/device/GUIDInfo:token	Ljava/lang/String;
      //   635: new 321	com/tencent/android/tpns/mqtt/persist/MemoryPersistence
      //   638: dup
      //   639: invokespecial 322	com/tencent/android/tpns/mqtt/persist/MemoryPersistence:<init>	()V
      //   642: aconst_null
      //   643: invokespecial 325	com/tencent/android/tpns/mqtt/MqttAsyncClient:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/android/tpns/mqtt/MqttClientPersistence;Lcom/tencent/android/tpns/mqtt/MqttPingSender;)V
      //   646: invokestatic 328	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/android/tpns/mqtt/MqttAsyncClient;)Lcom/tencent/android/tpns/mqtt/MqttAsyncClient;
      //   649: pop
      //   650: new 330	com/tencent/android/tpns/mqtt/MqttConnectOptions
      //   653: dup
      //   654: invokespecial 331	com/tencent/android/tpns/mqtt/MqttConnectOptions:<init>	()V
      //   657: astore_1
      //   658: aload_1
      //   659: iconst_0
      //   660: invokevirtual 335	com/tencent/android/tpns/mqtt/MqttConnectOptions:setAutomaticReconnect	(Z)V
      //   663: aload_1
      //   664: iconst_1
      //   665: invokevirtual 338	com/tencent/android/tpns/mqtt/MqttConnectOptions:setCleanSession	(Z)V
      //   668: aload_1
      //   669: aload_2
      //   670: getfield 341	com/tencent/tpns/baseapi/base/device/GUIDInfo:userName	Ljava/lang/String;
      //   673: invokevirtual 345	com/tencent/android/tpns/mqtt/MqttConnectOptions:setUserName	(Ljava/lang/String;)V
      //   676: aload_2
      //   677: getfield 348	com/tencent/tpns/baseapi/base/device/GUIDInfo:passWord	Ljava/lang/String;
      //   680: ifnull +14 -> 694
      //   683: aload_1
      //   684: aload_2
      //   685: getfield 348	com/tencent/tpns/baseapi/base/device/GUIDInfo:passWord	Ljava/lang/String;
      //   688: invokevirtual 352	java/lang/String:toCharArray	()[C
      //   691: invokevirtual 356	com/tencent/android/tpns/mqtt/MqttConnectOptions:setPassword	([C)V
      //   694: aload_1
      //   695: aload_0
      //   696: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   699: invokestatic 38	com/tencent/tpns/mqttchannel/core/b/a:g	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Landroid/content/Context;
      //   702: invokestatic 362	com/tencent/tpns/mqttchannel/core/common/config/MqttConfigImpl:getKeepAliveInterval	(Landroid/content/Context;)I
      //   705: invokevirtual 366	com/tencent/android/tpns/mqtt/MqttConnectOptions:setKeepAliveInterval	(I)V
      //   708: aload_0
      //   709: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   712: invokestatic 314	com/tencent/tpns/mqttchannel/core/b/a:k	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/android/tpns/mqtt/MqttAsyncClient;
      //   715: aload_0
      //   716: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   719: invokevirtual 370	com/tencent/android/tpns/mqtt/MqttAsyncClient:setCallback	(Lcom/tencent/android/tpns/mqtt/MqttCallback;)V
      //   722: aload_0
      //   723: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   726: invokestatic 314	com/tencent/tpns/mqttchannel/core/b/a:k	(Lcom/tencent/tpns/mqttchannel/core/b/a;)Lcom/tencent/android/tpns/mqtt/MqttAsyncClient;
      //   729: aload_1
      //   730: aconst_null
      //   731: new 372	com/tencent/tpns/mqttchannel/core/b/a$c$1
      //   734: dup
      //   735: aload_0
      //   736: invokespecial 375	com/tencent/tpns/mqttchannel/core/b/a$c$1:<init>	(Lcom/tencent/tpns/mqttchannel/core/b/a$c;)V
      //   739: invokevirtual 379	com/tencent/android/tpns/mqtt/MqttAsyncClient:connect	(Lcom/tencent/android/tpns/mqtt/MqttConnectOptions;Ljava/lang/Object;Lcom/tencent/android/tpns/mqtt/IMqttActionListener;)Lcom/tencent/android/tpns/mqtt/IMqttToken;
      //   742: pop
      //   743: aload_0
      //   744: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   747: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   750: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   753: return
      //   754: astore_3
      //   755: ldc 24
      //   757: new 106	java/lang/StringBuilder
      //   760: dup
      //   761: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   764: ldc_w 381
      //   767: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   770: aload_3
      //   771: invokevirtual 384	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   774: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   777: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   780: invokestatic 31	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   783: goto -161 -> 622
      //   786: astore_1
      //   787: aload_0
      //   788: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   791: iconst_0
      //   792: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   795: aload_0
      //   796: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   799: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   802: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   805: ldc 24
      //   807: new 106	java/lang/StringBuilder
      //   810: dup
      //   811: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   814: ldc_w 386
      //   817: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   820: aload_1
      //   821: invokevirtual 387	java/lang/Throwable:toString	()Ljava/lang/String;
      //   824: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   827: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   830: aload_1
      //   831: invokestatic 390	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   834: aload_0
      //   835: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   838: getstatic 228	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTFAIL	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   841: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   844: pop
      //   845: aload_0
      //   846: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   849: aload_0
      //   850: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   853: sipush -1102
      //   856: new 106	java/lang/StringBuilder
      //   859: dup
      //   860: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   863: ldc_w 392
      //   866: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   869: aload_1
      //   870: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   873: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   876: invokestatic 202	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
      //   879: return
      //   880: astore_1
      //   881: aload_0
      //   882: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   885: iconst_0
      //   886: invokestatic 218	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Z)V
      //   889: aload_0
      //   890: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   893: getstatic 228	com/tencent/tpns/mqttchannel/api/MqttConnectState:CONNECTFAIL	Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   896: invokestatic 231	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;)Lcom/tencent/tpns/mqttchannel/api/MqttConnectState;
      //   899: pop
      //   900: ldc 24
      //   902: ldc_w 394
      //   905: aload_1
      //   906: invokestatic 390	com/tencent/tpns/mqttchannel/core/common/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   909: aload_0
      //   910: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   913: aload_0
      //   914: getfield 20	com/tencent/tpns/mqttchannel/core/b/a$c:a	Lcom/tencent/tpns/mqttchannel/core/common/b/a;
      //   917: sipush -1101
      //   920: new 106	java/lang/StringBuilder
      //   923: dup
      //   924: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   927: ldc_w 396
      //   930: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   933: aload_1
      //   934: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   937: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   940: invokestatic 202	com/tencent/tpns/mqttchannel/core/b/a:a	(Lcom/tencent/tpns/mqttchannel/core/b/a;Lcom/tencent/tpns/mqttchannel/core/common/b/a;ILjava/lang/String;)V
      //   943: aload_0
      //   944: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   947: invokestatic 400	com/tencent/tpns/mqttchannel/core/b/a:m	(Lcom/tencent/tpns/mqttchannel/core/b/a;)V
      //   950: aload_0
      //   951: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   954: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   957: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   960: return
      //   961: astore_1
      //   962: aload_0
      //   963: getfield 15	com/tencent/tpns/mqttchannel/core/b/a$c:b	Lcom/tencent/tpns/mqttchannel/core/b/a;
      //   966: getfield 210	com/tencent/tpns/mqttchannel/core/b/a:a	Ljava/util/concurrent/locks/ReentrantLock;
      //   969: invokevirtual 234	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   972: aload_1
      //   973: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	974	0	this	c
      //   474	256	1	localObject1	Object
      //   786	84	1	localThrowable1	Throwable
      //   880	54	1	localThrowable2	Throwable
      //   961	12	1	localObject2	Object
      //   197	488	2	localGUIDInfo	GUIDInfo
      //   609	2	3	localMqttAsyncClient	MqttAsyncClient
      //   754	17	3	localThrowable3	Throwable
      // Exception table:
      //   from	to	target	type
      //   614	622	754	java/lang/Throwable
      //   574	610	786	java/lang/Throwable
      //   622	650	786	java/lang/Throwable
      //   755	783	786	java/lang/Throwable
      //   708	743	880	java/lang/Throwable
      //   708	743	961	finally
      //   881	950	961	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a
 * JD-Core Version:    0.7.0.1
 */