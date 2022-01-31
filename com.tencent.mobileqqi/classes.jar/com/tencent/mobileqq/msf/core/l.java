package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.b.g;
import com.tencent.mobileqq.msf.core.b.g.b;
import com.tencent.mobileqq.msf.core.b.h;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.e.c;
import com.tencent.msf.service.protocol.e.d;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

public class l
{
  public static final int A = -10008;
  public static final int B = -302;
  public static final int C = 302;
  static CopyOnWriteArraySet D = new CopyOnWriteArraySet();
  private static final AtomicInteger J = new AtomicInteger();
  private static int M = 0;
  private static String N;
  private static String[] O;
  private static AtomicBoolean X = new AtomicBoolean();
  public static final String b = "__extraTimeoutSeq";
  public static final String c = "MSF.C.NetConnTag";
  public static AtomicInteger d = new AtomicInteger(0);
  public static String h = ":";
  public static String i = "0";
  public static int j = 0;
  public static long k = 0L;
  public static long s = 0L;
  static int t = 0;
  static AtomicBoolean u;
  public static final String w = "GrayUinPro.Check";
  public static final String x = "res";
  ArrayList E = new ArrayList();
  boolean F = false;
  private ConcurrentHashMap G = new ConcurrentHashMap();
  private com.tencent.mobileqq.msf.sdk.k H = new com.tencent.mobileqq.msf.sdk.k(1000);
  private com.tencent.mobileqq.msf.sdk.k I = new com.tencent.mobileqq.msf.sdk.k();
  private int K = 0;
  private String L = "0";
  private AlarmManager P;
  private volatile boolean Q = false;
  private Object R = new Object();
  private String S = "";
  private PendingIntent T;
  private byte[] U = null;
  private long V = 0L;
  private Random W = new Random(System.currentTimeMillis());
  public com.tencent.mobileqq.msf.core.b.i a;
  a e = new a();
  MsfCore f;
  public b g;
  c l = new c();
  HashSet m = new HashSet();
  long n;
  AtomicBoolean o = new AtomicBoolean();
  int p = 0;
  long q = 0L;
  long r = 0L;
  HashSet v = new HashSet();
  public int y = -1;
  public AtomicBoolean z = new AtomicBoolean();
  
  static
  {
    M = 0;
    N = "";
    O = new String[] { "StreamSvr.UploadStreamMsg" };
    k = -1L;
    s = 0L;
    t = -1;
    u = new AtomicBoolean();
  }
  
  public l(MsfCore paramMsfCore)
  {
    this.f = paramMsfCore;
    a.a();
    this.K = paramMsfCore.getMsfAppid();
    this.a = new com.tencent.mobileqq.msf.core.b.i(paramMsfCore);
    this.l.setName("MsfCoreMsgSender");
    this.m.add("GrayUinPro.Check");
    this.m.add("StatSvc.register");
    this.m.add("RegPrxySvc.infoLogin");
    this.m.add("wtlogin.login");
    this.m.add("login.auth");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      D.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      D.remove(paramString);
    }
  }
  
  public static void b(int paramInt)
  {
    M = paramInt;
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 289	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   3: ifnull +59 -> 62
    //   6: getstatic 289	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   9: ldc 122
    //   11: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +48 -> 62
    //   17: aload_0
    //   18: getfield 245	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   21: getstatic 289	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   24: invokevirtual 294	com/tencent/mobileqq/msf/core/b/i:a	(Ljava/lang/String;)V
    //   27: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +31 -> 61
    //   33: ldc 36
    //   35: iconst_2
    //   36: new 302	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 305
    //   46: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 289	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   52: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: aload_1
    //   63: invokevirtual 321	android/content/Context:getPackageName	()Ljava/lang/String;
    //   66: astore_1
    //   67: new 323	java/io/File
    //   70: dup
    //   71: new 302	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 329	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   81: invokevirtual 332	java/io/File:getPath	()Ljava/lang/String;
    //   84: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 334
    //   90: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: ldc_w 336
    //   97: ldc_w 338
    //   100: invokevirtual 342	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   103: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 344
    //   109: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_1
    //   119: new 348	java/util/Properties
    //   122: dup
    //   123: invokespecial 349	java/util/Properties:<init>	()V
    //   126: astore 4
    //   128: aload_1
    //   129: invokevirtual 352	java/io/File:exists	()Z
    //   132: ifeq +233 -> 365
    //   135: new 354	java/io/FileInputStream
    //   138: dup
    //   139: aload_1
    //   140: invokespecial 357	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_2
    //   144: aload_2
    //   145: astore_1
    //   146: aload 4
    //   148: aload_2
    //   149: invokevirtual 361	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 364	java/io/FileInputStream:close	()V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 364	java/io/FileInputStream:close	()V
    //   166: iconst_0
    //   167: ifeq +11 -> 178
    //   170: new 366	java/lang/NullPointerException
    //   173: dup
    //   174: invokespecial 367	java/lang/NullPointerException:<init>	()V
    //   177: athrow
    //   178: aload 4
    //   180: ldc_w 369
    //   183: invokevirtual 373	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull -127 -> 61
    //   191: aload_1
    //   192: invokevirtual 376	java/lang/String:trim	()Ljava/lang/String;
    //   195: invokevirtual 379	java/lang/String:length	()I
    //   198: ifle -137 -> 61
    //   201: aload_1
    //   202: invokevirtual 376	java/lang/String:trim	()Ljava/lang/String;
    //   205: ldc_w 381
    //   208: ldc 122
    //   210: invokevirtual 342	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 245	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   218: aload_1
    //   219: invokevirtual 294	com/tencent/mobileqq/msf/core/b/i:a	(Ljava/lang/String;)V
    //   222: invokestatic 300	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -164 -> 61
    //   228: ldc 36
    //   230: iconst_2
    //   231: new 302	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 383
    //   241: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 316	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: return
    //   255: astore_1
    //   256: aload_1
    //   257: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   260: goto -94 -> 166
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   268: goto -90 -> 178
    //   271: astore_3
    //   272: aconst_null
    //   273: astore_2
    //   274: aload_2
    //   275: astore_1
    //   276: aload_3
    //   277: invokevirtual 387	java/lang/Exception:printStackTrace	()V
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 364	java/io/FileInputStream:close	()V
    //   288: iconst_0
    //   289: ifeq -111 -> 178
    //   292: new 366	java/lang/NullPointerException
    //   295: dup
    //   296: invokespecial 367	java/lang/NullPointerException:<init>	()V
    //   299: athrow
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   305: goto -127 -> 178
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   313: goto -25 -> 288
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_1
    //   319: aload_1
    //   320: ifnull +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 364	java/io/FileInputStream:close	()V
    //   327: iconst_0
    //   328: ifeq +11 -> 339
    //   331: new 366	java/lang/NullPointerException
    //   334: dup
    //   335: invokespecial 367	java/lang/NullPointerException:<init>	()V
    //   338: athrow
    //   339: aload_2
    //   340: athrow
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   346: goto -19 -> 327
    //   349: astore_1
    //   350: aload_1
    //   351: invokevirtual 386	java/io/IOException:printStackTrace	()V
    //   354: goto -15 -> 339
    //   357: astore_2
    //   358: goto -39 -> 319
    //   361: astore_3
    //   362: goto -88 -> 274
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -209 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	l
    //   0	370	1	paramContext	Context
    //   143	142	2	localFileInputStream	java.io.FileInputStream
    //   316	24	2	localObject1	Object
    //   357	1	2	localObject2	Object
    //   366	1	2	localObject3	Object
    //   271	6	3	localException1	Exception
    //   361	1	3	localException2	Exception
    //   126	53	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   162	166	255	java/io/IOException
    //   170	178	263	java/io/IOException
    //   128	144	271	java/lang/Exception
    //   292	300	300	java/io/IOException
    //   284	288	308	java/io/IOException
    //   128	144	316	finally
    //   323	327	341	java/io/IOException
    //   331	339	349	java/io/IOException
    //   146	152	357	finally
    //   154	158	357	finally
    //   276	280	357	finally
    //   146	152	361	java/lang/Exception
    //   154	158	361	java/lang/Exception
  }
  
  public static void b(String paramString)
  {
    N = paramString;
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.G.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(J.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject = this.f.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject);
      }
    }
    else
    {
      if (this.H.offer(paramToServiceMsg)) {
        break label211;
      }
      QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.H.size());
      localObject = j.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setBusinessFail(1008, "send queue is full!");
      this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
    }
    for (;;)
    {
      if ((!u.get()) && (e.b))
      {
        u.set(true);
        t = paramToServiceMsg.getRequestSsoSeq();
      }
      return;
      localObject = this.f.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      break;
      label211:
      QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue");
    }
  }
  
  private void c(String paramString)
  {
    com.tencent.mobileqq.msf.sdk.n.b(Integer.parseInt(paramString));
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.v.contains(paramToServiceMsg.getUin()))
      {
        this.V += 1L;
        if (this.V >= 2L)
        {
          i1 = i2;
          if (this.W.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static void f()
  {
    Iterator localIterator = D.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    D.clear();
  }
  
  public static int k()
  {
    return M;
  }
  
  public static String l()
  {
    return N;
  }
  
  private void n()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.f.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.h());
      a(localToServiceMsg);
      this.p += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.q = System.currentTimeMillis();
      this.o.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    p();
  }
  
  private void o()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.f.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(10000L);
      a(localToServiceMsg);
      this.p = com.tencent.mobileqq.msf.core.a.a.i();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
      }
      this.q = System.currentTimeMillis();
      this.o.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    p();
  }
  
  private void p()
  {
    this.p = 0;
    this.o.set(false);
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this.S);
    localIntent.setAction(this.S);
    this.T = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
    this.P = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    this.P.set(0, System.currentTimeMillis() + 1500L, this.T);
    this.Q = true;
    QLog.d("MSF.C.NetConnTag", 4, "register alarm to send delayMsg.");
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    Runnable localRunnable;
    if (paramToServiceMsg.isNeedCallback())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg + " to send");
      }
      this.G.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(J.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label165;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.f.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.H.a(paramToServiceMsg);
        return paramToServiceMsg.getRequestSsoSeq();
        label165:
        localRunnable = this.f.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + localException, localException);
        }
      }
    }
  }
  
  public ToServiceMsg a(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.G.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.f.msfAlarmer.b().removeCallbacks(localRunnable);
    }
    return localToServiceMsg;
  }
  
  public void a(int paramInt, String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    Object localObject = new c();
    ((c)localObject).a = paramInt;
    ((c)localObject).b = paramString;
    localUniPacket.put("req", localObject);
    localObject = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject).setAppId(paramInt);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "role send gray check for " + paramString + " use " + paramInt + " to:" + localObject);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.a.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      this.v.add(paramFromServiceMsg.getUin());
      try
      {
        Object localObject = paramFromServiceMsg.getWupBuffer();
        UniPacket localUniPacket = new UniPacket();
        localUniPacket.decode((byte[])localObject);
        localObject = (d)localUniPacket.getByClass("res", new d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((d)localObject).a);
        }
        if (((d)localObject).a == 1)
        {
          this.f.getSsoRespHandler();
          n.a.add(paramFromServiceMsg.getUin());
          this.f.getAccountCenter().m(paramFromServiceMsg.getUin());
          return;
        }
        n.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
    }
    else if (QLog.isDevelopLevel())
    {
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "handleHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        p();
      }
      do
      {
        return;
        if (this.p < com.tencent.mobileqq.msf.core.a.a.i()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "continueTimeoutCount is " + this.p + ",try close conn");
          }
          this.f.sender.a.a(com.tencent.qphone.base.a.p);
          p();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.q > com.tencent.mobileqq.msf.core.a.a.i() * com.tencent.mobileqq.msf.core.a.a.h())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.q) + ",try close conn");
        }
        this.f.sender.a.a(com.tencent.qphone.base.a.e);
        p();
        return;
      }
      n();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    p();
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nateiveRemoveAccountKey(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.E.add(paramHashMap);
    this.F = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.E.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.U = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.G.isEmpty();
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      b(paramContext);
      this.e.init(paramContext, false);
      CodecWarpper.setKsid(this.f.getAccountCenter().f());
      this.l.start();
      try
      {
        localObject = k.a().getConfig("LOGLEVEL_");
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          String str = k.a().getConfig("LOGLEVELTIME");
          if ((str == null) || (str.length() <= 0)) {
            break label299;
          }
          long l1 = Long.parseLong(str);
          if (System.currentTimeMillis() - l1 <= 259200000L) {
            break label258;
          }
          localObject = new m(this);
          ((Thread)localObject).setName("resetLogLevelThread");
          ((Thread)localObject).start();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject;
          QLog.d("MSF.C.NetConnTag", 1, "set logLevel error " + localException2);
          continue;
          k.a().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
          c(localException2);
        }
      }
      this.S = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction(this.S);
      this.g = new b(null);
      paramContext.registerReceiver(this.g, (IntentFilter)localObject);
      this.P = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
      return true;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "loadTestServerConfig error " + localException1);
          continue;
          label258:
          c(localException1);
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      g.a(g.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", com.tencent.mobileqq.msf.core.b.i.D);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", com.tencent.mobileqq.msf.core.b.i.D);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
        l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
      }
      if ((l2 != 0L) && (l3 - l2 > paramToServiceMsg.getTimeout()) && (l3 - l2 > this.f.pushManager.e()))
      {
        if (l2 >= this.a.n().c())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: timenow0 - addtoqueueTime is " + (l3 - l2) + ",try close conn");
          }
          this.f.sender.a.a(com.tencent.qphone.base.a.q);
          p();
          return true;
        }
        return true;
      }
      if ((l1 == 0L) || (l1 > this.a.n().c()))
      {
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
        }
        try
        {
          if ((this.o.get()) && (System.currentTimeMillis() - this.q < com.tencent.mobileqq.msf.core.a.a.k() + 120000)) {
            break label487;
          }
          l1 = System.currentTimeMillis();
          if (l1 - this.q <= com.tencent.mobileqq.msf.core.a.a.k()) {
            break label432;
          }
          if (paramToServiceMsg.getRequestSsoSeq() == t)
          {
            t = -1;
            QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
            this.f.sender.a.a(com.tencent.qphone.base.a.t);
            p();
            return true;
          }
        }
        finally {}
        n();
      }
      for (;;)
      {
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
          break label566;
        }
        return false;
        label432:
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.q + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.k());
        break;
        label487:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.o + "net detect has started, no need sendHeartbeat");
        break;
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
      }
      for (;;)
      {
        try
        {
          label566:
          if (this.a.b())
          {
            int i3 = 1;
            paramFromServiceMsg = O;
            int i4 = paramFromServiceMsg.length;
            i1 = 0;
            int i2 = i3;
            if (i1 < i4)
            {
              CharSequence localCharSequence = paramFromServiceMsg[i1];
              if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
                continue;
              }
              i2 = 0;
            }
            if ((i2 != 0) && (d.incrementAndGet() >= com.tencent.mobileqq.msf.core.a.a.j()))
            {
              QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
              d.set(0);
              this.f.sender.a.a(com.tencent.qphone.base.a.e);
              p();
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int i1;
          QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
          continue;
        }
        return true;
        i1 += 1;
      }
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    Object localObject1;
    if (this.f.isSuspended())
    {
      localObject1 = j.a(paramToServiceMsg);
      ((FromServiceMsg)localObject1).setBusinessFail(2009, "MSF is suspeded.");
      this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2;
    String str1;
    String str2;
    int i1;
    if (this.f.configManager.I != null)
    {
      localObject2 = this.f.configManager.I.keySet();
      localObject1 = null;
      Iterator localIterator = ((Set)localObject2).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          localObject2 = (a.a)this.f.configManager.I.get(str1);
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + str1);
            }
            this.f.configManager.I.remove(str1);
            localObject1 = localObject2;
          }
          else
          {
            str2 = paramToServiceMsg.getServiceCmd();
            if (str1.charAt(str1.length() - 1) == '*')
            {
              localObject1 = localObject2;
              if (!str2.startsWith(str1.substring(0, str1.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label944;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
              i1 = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (localObject1 != null))
      {
        localObject2 = j.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)localObject1).b.c, new String(((a.a)localObject1).b.d));
        this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = localObject2;
        if (!str1.equals(str2)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label944;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
        i1 = 1;
        localObject1 = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn))
      {
        localObject1 = j.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (X.get())
      {
        localObject1 = j.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(2014, "error");
        this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if ((n.a.contains(paramToServiceMsg.getUin())) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject1 = j.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(2008, paramToServiceMsg.getUin() + "不在灰度名单内");
        this.f.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if (this.f.getAccountCenter().i(((FromServiceMsg)localObject1).getUin())) {
          this.f.getAccountCenter().m(((FromServiceMsg)localObject1).getUin());
        }
        return paramToServiceMsg.getRequestSsoSeq();
      }
      CodecWarpper.getFileStoreKey();
      localObject1 = this.f.getAccountCenter().k(paramToServiceMsg.getUin());
      if (localObject1 != null) {
        paramToServiceMsg.setUin((String)localObject1);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.L.equals(paramToServiceMsg.getUin())))
      {
        this.L = paramToServiceMsg.getUin();
        this.f.statReporter.a(this.L);
      }
      for (;;)
      {
        if (this.K != paramToServiceMsg.getAppId()) {
          this.K = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        c(paramToServiceMsg);
        return paramToServiceMsg.getRequestSsoSeq();
        if ((paramToServiceMsg.getUin().equals("0")) && (!paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) && (!paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
          paramToServiceMsg.setUin(g());
        }
      }
      i1 = 0;
      continue;
      label944:
      i1 = 1;
      localObject1 = localObject2;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.e.onReceData(paramArrayOfByte);
  }
  
  public byte[] b()
  {
    return this.U;
  }
  
  public void c()
  {
    if (this.L != "0") {
      this.f.getAccountCenter().a(false);
    }
  }
  
  public ToServiceMsg d()
  {
    return null;
  }
  
  public ConcurrentHashMap e()
  {
    return this.G;
  }
  
  public String g()
  {
    return this.L;
  }
  
  public int h()
  {
    return this.K;
  }
  
  public void i()
  {
    try
    {
      if (this.F)
      {
        Iterator localIterator = this.E.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.f.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "report waitReportData error " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.E.size());
    }
    this.E.clear();
    this.F = false;
  }
  
  public void j()
  {
    Iterator localIterator = this.G.entrySet().iterator();
    label173:
    for (;;)
    {
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (this.H.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label173;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        this.f.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        localObject2 = BaseConstants.CMD_NeedResendCmds;
        int i2 = localObject2.length;
        i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            Object localObject3 = localObject2[i1];
            if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
            {
              i1 = 1;
              break;
            }
            i1 += 1;
            continue;
            return;
          }
        }
        i1 = 0;
      }
    }
  }
  
  class a
    extends CodecWarpper
  {
    a() {}
    
    private com.tencent.qphone.base.a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return com.tencent.qphone.base.a.u;
      case -2: 
        return com.tencent.qphone.base.a.v;
      case -3: 
        return com.tencent.qphone.base.a.w;
      case -4: 
        return com.tencent.qphone.base.a.x;
      case -5: 
        return com.tencent.qphone.base.a.j;
      case -6: 
        return com.tencent.qphone.base.a.r;
      }
      return com.tencent.qphone.base.a.s;
    }
    
    public void onInvalidData(int paramInt1, int paramInt2)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      a.a(paramInt1);
      l.this.a.n().a(a(paramInt1));
      try
      {
        l.this.a.e();
        return;
      }
      catch (Exception localException)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
    
    public void onInvalidSign()
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
      a.a(-1);
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(l.this.f.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      l.this.f.addRespToQuque(null, localFromServiceMsg);
      l.m().set(true);
    }
    
    /* Error */
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      // Byte code:
      //   0: iload_1
      //   1: invokestatic 80	com/tencent/mobileqq/msf/core/a:a	(I)V
      //   4: aload_2
      //   5: ifnull +1844 -> 1849
      //   8: getstatic 173	com/tencent/mobileqq/msf/core/l:t	I
      //   11: iconst_m1
      //   12: if_icmpeq +7 -> 19
      //   15: iconst_m1
      //   16: putstatic 173	com/tencent/mobileqq/msf/core/l:t	I
      //   19: aload_0
      //   20: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   23: invokestatic 179	java/lang/System:currentTimeMillis	()J
      //   26: putfield 182	com/tencent/mobileqq/msf/core/l:r	J
      //   29: aload_0
      //   30: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   33: getfield 182	com/tencent/mobileqq/msf/core/l:r	J
      //   36: putstatic 184	com/tencent/mobileqq/msf/core/l:s	J
      //   39: aload_2
      //   40: checkcast 109	com/tencent/qphone/base/remote/FromServiceMsg
      //   43: astore 10
      //   45: aload_0
      //   46: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   49: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   52: invokevirtual 89	com/tencent/mobileqq/msf/core/b/i:n	()Lcom/tencent/mobileqq/msf/core/b/h;
      //   55: getfield 187	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
      //   58: invokevirtual 193	java/net/Socket:isClosed	()Z
      //   61: ifne +1032 -> 1093
      //   64: aload_0
      //   65: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   68: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   71: invokevirtual 89	com/tencent/mobileqq/msf/core/b/i:n	()Lcom/tencent/mobileqq/msf/core/b/h;
      //   74: getfield 187	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
      //   77: invokevirtual 197	java/net/Socket:getInetAddress	()Ljava/net/InetAddress;
      //   80: invokevirtual 202	java/net/InetAddress:getHostName	()Ljava/lang/String;
      //   83: astore 9
      //   85: aload_0
      //   86: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   89: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   92: invokevirtual 89	com/tencent/mobileqq/msf/core/b/i:n	()Lcom/tencent/mobileqq/msf/core/b/h;
      //   95: getfield 187	com/tencent/mobileqq/msf/core/b/h:f	Ljava/net/Socket;
      //   98: invokevirtual 205	java/net/Socket:getPort	()I
      //   101: istore_1
      //   102: aload 10
      //   104: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   107: astore 11
      //   109: aload 11
      //   111: ldc 210
      //   113: invokevirtual 216	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   116: istore 4
      //   118: iload 4
      //   120: iconst_m1
      //   121: if_icmpeq +901 -> 1022
      //   124: new 51	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   131: aload 11
      //   133: iload 4
      //   135: iconst_1
      //   136: iadd
      //   137: aload 11
      //   139: invokevirtual 219	java/lang/String:length	()I
      //   142: invokevirtual 223	java/lang/String:substring	(II)Ljava/lang/String;
      //   145: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: ldc 225
      //   150: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   156: astore 12
      //   158: aload 11
      //   160: iconst_0
      //   161: iload 4
      //   163: invokevirtual 223	java/lang/String:substring	(II)Ljava/lang/String;
      //   166: pop
      //   167: iconst_1
      //   168: aload 10
      //   170: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   173: iload_3
      //   174: aload 12
      //   176: iconst_1
      //   177: aload 9
      //   179: iload_1
      //   180: invokestatic 233	com/tencent/mobileqq/msf/core/d/f:a	(ZLjava/lang/String;ILjava/lang/String;ILjava/lang/String;I)V
      //   183: aload 10
      //   185: invokevirtual 236	com/tencent/qphone/base/remote/FromServiceMsg:getFlag	()I
      //   188: iconst_1
      //   189: iand
      //   190: ifeq +183 -> 373
      //   193: aload 10
      //   195: invokevirtual 240	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   198: astore 9
      //   200: aload 9
      //   202: arraylength
      //   203: istore_1
      //   204: iload_1
      //   205: iconst_4
      //   206: if_icmple +956 -> 1162
      //   209: iconst_0
      //   210: aload 9
      //   212: iconst_0
      //   213: baload
      //   214: sipush 255
      //   217: iand
      //   218: bipush 24
      //   220: ishl
      //   221: ior
      //   222: aload 9
      //   224: iconst_1
      //   225: baload
      //   226: sipush 255
      //   229: iand
      //   230: bipush 16
      //   232: ishl
      //   233: ior
      //   234: aload 9
      //   236: iconst_2
      //   237: baload
      //   238: sipush 255
      //   241: iand
      //   242: bipush 8
      //   244: ishl
      //   245: ior
      //   246: aload 9
      //   248: iconst_3
      //   249: baload
      //   250: sipush 255
      //   253: iand
      //   254: ior
      //   255: istore_1
      //   256: iload_1
      //   257: newarray byte
      //   259: astore 11
      //   261: aload 9
      //   263: iconst_4
      //   264: aload 11
      //   266: iconst_0
      //   267: iload_1
      //   268: iconst_4
      //   269: isub
      //   270: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   273: aload 11
      //   275: invokestatic 250	com/tencent/qphone/base/util/b:b	([B)[B
      //   278: astore 11
      //   280: aload 11
      //   282: arraylength
      //   283: iconst_4
      //   284: iadd
      //   285: newarray byte
      //   287: astore 12
      //   289: aload 12
      //   291: iconst_0
      //   292: aload 11
      //   294: arraylength
      //   295: iconst_4
      //   296: iadd
      //   297: bipush 24
      //   299: ishr
      //   300: sipush 255
      //   303: iand
      //   304: i2b
      //   305: bastore
      //   306: aload 12
      //   308: iconst_1
      //   309: aload 11
      //   311: arraylength
      //   312: iconst_4
      //   313: iadd
      //   314: bipush 16
      //   316: ishr
      //   317: sipush 255
      //   320: iand
      //   321: i2b
      //   322: bastore
      //   323: aload 12
      //   325: iconst_2
      //   326: aload 11
      //   328: arraylength
      //   329: iconst_4
      //   330: iadd
      //   331: bipush 8
      //   333: ishr
      //   334: sipush 255
      //   337: iand
      //   338: i2b
      //   339: bastore
      //   340: aload 12
      //   342: iconst_3
      //   343: aload 11
      //   345: arraylength
      //   346: iconst_4
      //   347: iadd
      //   348: sipush 255
      //   351: iand
      //   352: i2b
      //   353: bastore
      //   354: aload 11
      //   356: iconst_0
      //   357: aload 12
      //   359: iconst_4
      //   360: aload 11
      //   362: arraylength
      //   363: invokestatic 244	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   366: aload 10
      //   368: aload 12
      //   370: invokevirtual 254	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   373: aload 10
      //   375: ldc_w 256
      //   378: invokestatic 179	java/lang/System:currentTimeMillis	()J
      //   381: invokestatic 262	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   384: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   387: pop
      //   388: aload 10
      //   390: ldc_w 268
      //   393: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
      //   396: invokestatic 262	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   399: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   402: pop
      //   403: aload 10
      //   405: invokevirtual 276	com/tencent/qphone/base/remote/FromServiceMsg:getMsgCookie	()[B
      //   408: astore 9
      //   410: aload 9
      //   412: ifnull +24 -> 436
      //   415: aload 9
      //   417: arraylength
      //   418: ifle +18 -> 436
      //   421: aload_0
      //   422: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   425: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   428: getfield 279	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
      //   431: aload 9
      //   433: invokevirtual 281	com/tencent/mobileqq/msf/core/l:a	([B)V
      //   436: aload 10
      //   438: invokevirtual 284	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   441: ifne +731 -> 1172
      //   444: aload 10
      //   446: invokevirtual 287	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
      //   449: sipush -10008
      //   452: if_icmpne +720 -> 1172
      //   455: aload 10
      //   457: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   460: iconst_0
      //   461: invokestatic 290	com/tencent/mobileqq/msf/core/l:a	(Ljava/lang/String;Z)V
      //   464: aload 10
      //   466: aload 10
      //   468: invokevirtual 293	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
      //   471: invokevirtual 296	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
      //   474: invokestatic 301	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNeedWifiAuth	()Z
      //   477: ifeq +7 -> 484
      //   480: iconst_0
      //   481: invokestatic 304	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNeedWifiAuth	(Z)V
      //   484: aload_0
      //   485: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   488: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   491: getfield 279	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
      //   494: aload 10
      //   496: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   499: invokevirtual 310	com/tencent/mobileqq/msf/core/l:a	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   502: astore 11
      //   504: lconst_0
      //   505: lstore 7
      //   507: lload 7
      //   509: lstore 5
      //   511: aload 11
      //   513: ifnull +93 -> 606
      //   516: lload 7
      //   518: lstore 5
      //   520: aload 11
      //   522: ldc_w 312
      //   525: invokevirtual 318	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   528: ifnull +78 -> 606
      //   531: lload 7
      //   533: lstore 5
      //   535: aload 10
      //   537: ifnull +69 -> 606
      //   540: lload 7
      //   542: lstore 5
      //   544: aload 10
      //   546: ldc_w 256
      //   549: invokevirtual 319	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   552: ifnull +54 -> 606
      //   555: aload 10
      //   557: ldc_w 256
      //   560: invokevirtual 319	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   563: checkcast 258	java/lang/Long
      //   566: invokevirtual 322	java/lang/Long:longValue	()J
      //   569: aload 11
      //   571: ldc_w 312
      //   574: invokevirtual 318	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   577: checkcast 258	java/lang/Long
      //   580: checkcast 258	java/lang/Long
      //   583: invokevirtual 322	java/lang/Long:longValue	()J
      //   586: lsub
      //   587: lstore 5
      //   589: lload 5
      //   591: lstore 7
      //   593: lload 5
      //   595: lconst_0
      //   596: lcmp
      //   597: ifge +1233 -> 1830
      //   600: lconst_0
      //   601: lstore 7
      //   603: goto +1227 -> 1830
      //   606: new 51	java/lang/StringBuilder
      //   609: dup
      //   610: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   613: astore 12
      //   615: invokestatic 325	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   618: ifeq +771 -> 1389
      //   621: lload 5
      //   623: lconst_0
      //   624: lcmp
      //   625: ifne +657 -> 1282
      //   628: lload 5
      //   630: invokestatic 328	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   633: astore 9
      //   635: aload 10
      //   637: invokevirtual 331	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   640: sipush 1000
      //   643: if_icmpeq +665 -> 1308
      //   646: ldc_w 333
      //   649: iconst_1
      //   650: aload 12
      //   652: ldc_w 335
      //   655: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   658: aload 10
      //   660: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   663: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   666: ldc_w 337
      //   669: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   672: aload 10
      //   674: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   677: invokestatic 341	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   680: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   683: ldc_w 343
      //   686: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   689: aload 10
      //   691: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   694: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   697: ldc_w 345
      //   700: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   703: iload_3
      //   704: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   707: ldc_w 347
      //   710: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   713: aload 9
      //   715: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   718: ldc_w 349
      //   721: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   724: aload 10
      //   726: invokevirtual 331	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   729: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   732: ldc_w 351
      //   735: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   738: aload 10
      //   740: invokevirtual 354	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
      //   743: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   746: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   749: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   752: aload 10
      //   754: ldc_w 356
      //   757: new 51	java/lang/StringBuilder
      //   760: dup
      //   761: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   764: getstatic 359	com/tencent/mobileqq/msf/core/l:h	Ljava/lang/String;
      //   767: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   770: ldc_w 361
      //   773: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   776: aload 10
      //   778: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   781: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   784: ldc_w 361
      //   787: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   790: aload 10
      //   792: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   795: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   798: ldc_w 361
      //   801: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   804: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   807: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   810: pop
      //   811: aload 10
      //   813: ldc_w 363
      //   816: getstatic 359	com/tencent/mobileqq/msf/core/l:h	Ljava/lang/String;
      //   819: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   822: pop
      //   823: aload 10
      //   825: ldc_w 365
      //   828: getstatic 368	com/tencent/mobileqq/msf/core/l:i	Ljava/lang/String;
      //   831: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   834: pop
      //   835: aload 11
      //   837: ifnull +17 -> 854
      //   840: aload_0
      //   841: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   844: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   847: aload 10
      //   849: aload 11
      //   851: invokevirtual 371	com/tencent/mobileqq/msf/core/b/i:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   854: aload_0
      //   855: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   858: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   861: getfield 375	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   864: invokevirtual 378	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   867: ifeq +49 -> 916
      //   870: aload_0
      //   871: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   874: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   877: getfield 279	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/l;
      //   880: invokevirtual 380	com/tencent/mobileqq/msf/core/l:a	()Z
      //   883: ifeq +33 -> 916
      //   886: aload_0
      //   887: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   890: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   893: invokevirtual 89	com/tencent/mobileqq/msf/core/b/i:n	()Lcom/tencent/mobileqq/msf/core/b/h;
      //   896: getstatic 382	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
      //   899: invokevirtual 96	com/tencent/mobileqq/msf/core/b/h:a	(Lcom/tencent/qphone/base/a;)V
      //   902: aload_0
      //   903: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   906: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   909: getfield 375	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   912: iconst_0
      //   913: invokevirtual 165	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   916: aload 11
      //   918: ifnull +793 -> 1711
      //   921: aload 10
      //   923: aload 11
      //   925: invokevirtual 383	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
      //   928: invokevirtual 386	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
      //   931: aload 10
      //   933: aload 11
      //   935: invokevirtual 390	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   938: invokevirtual 143	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
      //   941: aload 10
      //   943: aload 11
      //   945: invokevirtual 393	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   948: invokevirtual 396	com/tencent/qphone/base/remote/FromServiceMsg:setAppId	(I)V
      //   951: aload 10
      //   953: invokevirtual 284	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   956: ifne +755 -> 1711
      //   959: aload 10
      //   961: invokevirtual 287	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
      //   964: istore_3
      //   965: iload_3
      //   966: istore_1
      //   967: iload_3
      //   968: sipush 302
      //   971: if_icmpne +15 -> 986
      //   974: aload 10
      //   976: sipush -302
      //   979: invokevirtual 398	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(I)V
      //   982: sipush -302
      //   985: istore_1
      //   986: iload_1
      //   987: sipush -302
      //   990: if_icmpne +667 -> 1657
      //   993: aload_0
      //   994: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   997: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   1000: invokevirtual 89	com/tencent/mobileqq/msf/core/b/i:n	()Lcom/tencent/mobileqq/msf/core/b/h;
      //   1003: getstatic 400	com/tencent/qphone/base/a:i	Lcom/tencent/qphone/base/a;
      //   1006: invokevirtual 96	com/tencent/mobileqq/msf/core/b/h:a	(Lcom/tencent/qphone/base/a;)V
      //   1009: aload_0
      //   1010: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1013: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1016: aload 11
      //   1018: invokevirtual 404	com/tencent/mobileqq/msf/core/MsfCore:reSendMsg	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1021: return
      //   1022: iconst_1
      //   1023: aload 10
      //   1025: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1028: iload_3
      //   1029: aload 11
      //   1031: iconst_1
      //   1032: aload 9
      //   1034: iload_1
      //   1035: invokestatic 233	com/tencent/mobileqq/msf/core/d/f:a	(ZLjava/lang/String;ILjava/lang/String;ILjava/lang/String;I)V
      //   1038: goto -855 -> 183
      //   1041: astore 9
      //   1043: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1046: ifeq +803 -> 1849
      //   1049: getstatic 49	com/tencent/mobileqq/msf/core/l$a:tag	Ljava/lang/String;
      //   1052: iconst_2
      //   1053: new 51	java/lang/StringBuilder
      //   1056: dup
      //   1057: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1060: ldc_w 409
      //   1063: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1066: aload_2
      //   1067: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1070: ldc_w 411
      //   1073: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1076: aload 9
      //   1078: invokevirtual 412	java/lang/Throwable:toString	()Ljava/lang/String;
      //   1081: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1084: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1087: aload 9
      //   1089: invokestatic 415	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1092: return
      //   1093: iconst_1
      //   1094: aload 10
      //   1096: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1099: iload_3
      //   1100: aload 10
      //   1102: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1105: iconst_1
      //   1106: ldc_w 417
      //   1109: iconst_0
      //   1110: invokestatic 233	com/tencent/mobileqq/msf/core/d/f:a	(ZLjava/lang/String;ILjava/lang/String;ILjava/lang/String;I)V
      //   1113: goto -930 -> 183
      //   1116: astore 10
      //   1118: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1121: ifeq +31 -> 1152
      //   1124: getstatic 49	com/tencent/mobileqq/msf/core/l$a:tag	Ljava/lang/String;
      //   1127: iconst_2
      //   1128: new 51	java/lang/StringBuilder
      //   1131: dup
      //   1132: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1135: ldc_w 419
      //   1138: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1141: aload 10
      //   1143: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1146: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1149: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1152: aload_0
      //   1153: aload 9
      //   1155: arraylength
      //   1156: bipush 249
      //   1158: invokevirtual 421	com/tencent/mobileqq/msf/core/l$a:onInvalidData	(II)V
      //   1161: return
      //   1162: aload_0
      //   1163: aload 9
      //   1165: arraylength
      //   1166: bipush 250
      //   1168: invokevirtual 421	com/tencent/mobileqq/msf/core/l$a:onInvalidData	(II)V
      //   1171: return
      //   1172: aload 10
      //   1174: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1177: ifnull -713 -> 464
      //   1180: aload 10
      //   1182: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1185: invokevirtual 219	java/lang/String:length	()I
      //   1188: iconst_4
      //   1189: if_icmple -725 -> 464
      //   1192: getstatic 425	com/tencent/mobileqq/msf/core/l:D	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   1195: aload 10
      //   1197: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1200: invokevirtual 431	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
      //   1203: ifne -739 -> 464
      //   1206: aload 10
      //   1208: invokevirtual 284	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   1211: ifeq -747 -> 464
      //   1214: aload 10
      //   1216: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1219: ldc_w 433
      //   1222: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   1225: ifne -761 -> 464
      //   1228: aload 10
      //   1230: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1233: ldc_w 439
      //   1236: invokevirtual 437	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   1239: ifne -775 -> 464
      //   1242: aload 10
      //   1244: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1247: ldc_w 441
      //   1250: invokevirtual 444	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1253: ifne -789 -> 464
      //   1256: aload 10
      //   1258: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1261: ldc_w 446
      //   1264: invokevirtual 444	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1267: ifne -803 -> 464
      //   1270: aload 10
      //   1272: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1275: iconst_1
      //   1276: invokestatic 290	com/tencent/mobileqq/msf/core/l:a	(Ljava/lang/String;Z)V
      //   1279: goto -815 -> 464
      //   1282: new 51	java/lang/StringBuilder
      //   1285: dup
      //   1286: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1289: lload 5
      //   1291: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1294: invokestatic 454	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSignalStrengthsLog	()Ljava/lang/String;
      //   1297: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1300: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1303: astore 9
      //   1305: goto -670 -> 635
      //   1308: ldc_w 333
      //   1311: iconst_1
      //   1312: aload 12
      //   1314: ldc_w 335
      //   1317: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1320: aload 10
      //   1322: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1325: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1328: ldc_w 337
      //   1331: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1334: aload 10
      //   1336: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1339: invokestatic 341	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   1342: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1345: ldc_w 343
      //   1348: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1351: aload 10
      //   1353: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1356: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1359: ldc_w 345
      //   1362: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1365: iload_3
      //   1366: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1369: ldc_w 347
      //   1372: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1375: aload 9
      //   1377: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1380: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1383: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1386: goto -634 -> 752
      //   1389: aload 10
      //   1391: invokevirtual 331	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   1394: sipush 1000
      //   1397: if_icmpeq +123 -> 1520
      //   1400: ldc_w 333
      //   1403: iconst_1
      //   1404: aload 12
      //   1406: ldc_w 335
      //   1409: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1412: aload 10
      //   1414: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1417: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1420: ldc_w 337
      //   1423: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1426: aload 10
      //   1428: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1431: invokestatic 341	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   1434: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1437: ldc_w 343
      //   1440: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1443: aload 10
      //   1445: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1448: invokevirtual 457	java/lang/String:hashCode	()I
      //   1451: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1454: new 51	java/lang/StringBuilder
      //   1457: dup
      //   1458: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1461: ldc_w 459
      //   1464: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1467: aload 10
      //   1469: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1472: iload_3
      //   1473: iadd
      //   1474: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1477: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1480: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1483: ldc_w 349
      //   1486: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1489: aload 10
      //   1491: invokevirtual 331	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   1494: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1497: ldc_w 351
      //   1500: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1503: aload 10
      //   1505: invokevirtual 354	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
      //   1508: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1511: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1514: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1517: goto -765 -> 752
      //   1520: ldc_w 333
      //   1523: iconst_1
      //   1524: aload 12
      //   1526: ldc_w 335
      //   1529: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1532: aload 10
      //   1534: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1537: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1540: ldc_w 337
      //   1543: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1546: aload 10
      //   1548: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1551: invokestatic 341	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   1554: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1557: ldc_w 343
      //   1560: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1563: aload 10
      //   1565: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1568: invokevirtual 457	java/lang/String:hashCode	()I
      //   1571: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1574: new 51	java/lang/StringBuilder
      //   1577: dup
      //   1578: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1581: ldc_w 459
      //   1584: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1587: aload 10
      //   1589: invokevirtual 307	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1592: iload_3
      //   1593: iadd
      //   1594: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1597: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1600: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1603: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1606: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1609: goto -857 -> 752
      //   1612: astore 9
      //   1614: aload_0
      //   1615: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1618: getfield 83	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/b/i;
      //   1621: invokevirtual 462	com/tencent/mobileqq/msf/core/b/i:c	()V
      //   1624: getstatic 49	com/tencent/mobileqq/msf/core/l$a:tag	Ljava/lang/String;
      //   1627: iconst_1
      //   1628: new 51	java/lang/StringBuilder
      //   1631: dup
      //   1632: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1635: ldc_w 464
      //   1638: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1641: aload 9
      //   1643: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1646: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1649: aload 9
      //   1651: invokestatic 415	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1654: goto -800 -> 854
      //   1657: iload_1
      //   1658: sipush -10008
      //   1661: if_icmpne +50 -> 1711
      //   1664: aload 11
      //   1666: invokestatic 470	com/tencent/mobileqq/msf/sdk/MsfMsgUtil:hasResendBy10008	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
      //   1669: ifne +32 -> 1701
      //   1672: aload 11
      //   1674: invokevirtual 474	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1677: ldc_w 476
      //   1680: iconst_1
      //   1681: invokestatic 481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1684: invokevirtual 487	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1687: pop
      //   1688: aload_0
      //   1689: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1692: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1695: aload 11
      //   1697: invokevirtual 404	com/tencent/mobileqq/msf/core/MsfCore:reSendMsg	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1700: return
      //   1701: getstatic 49	com/tencent/mobileqq/msf/core/l$a:tag	Ljava/lang/String;
      //   1704: iconst_1
      //   1705: ldc_w 489
      //   1708: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1711: invokestatic 159	com/tencent/mobileqq/msf/core/l:m	()Ljava/util/concurrent/atomic/AtomicBoolean;
      //   1714: invokevirtual 378	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   1717: ifeq +61 -> 1778
      //   1720: getstatic 49	com/tencent/mobileqq/msf/core/l$a:tag	Ljava/lang/String;
      //   1723: iconst_1
      //   1724: new 51	java/lang/StringBuilder
      //   1727: dup
      //   1728: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   1731: ldc_w 491
      //   1734: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1737: aload 10
      //   1739: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1742: ldc_w 493
      //   1745: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1748: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1751: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1754: aload_0
      //   1755: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1758: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1761: invokevirtual 499	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   1764: getfield 505	com/tencent/mobileqq/msf/core/auth/b:g	Lcom/tencent/mobileqq/msf/core/auth/d;
      //   1767: invokevirtual 509	com/tencent/mobileqq/msf/core/auth/d:a	()V
      //   1770: aload_0
      //   1771: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1774: invokevirtual 511	com/tencent/mobileqq/msf/core/l:i	()V
      //   1777: return
      //   1778: aload 10
      //   1780: invokevirtual 512	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   1783: getstatic 515	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_HeartbeatAlive	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   1786: if_acmpne +17 -> 1803
      //   1789: aload_0
      //   1790: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1793: aload 10
      //   1795: aload 11
      //   1797: invokevirtual 516	com/tencent/mobileqq/msf/core/l:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1800: goto -46 -> 1754
      //   1803: getstatic 519	com/tencent/mobileqq/msf/core/l:d	Ljava/util/concurrent/atomic/AtomicInteger;
      //   1806: iconst_0
      //   1807: invokevirtual 523	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   1810: aload_0
      //   1811: getfield 12	com/tencent/mobileqq/msf/core/l$a:a	Lcom/tencent/mobileqq/msf/core/l;
      //   1814: getfield 113	com/tencent/mobileqq/msf/core/l:f	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1817: invokevirtual 527	com/tencent/mobileqq/msf/core/MsfCore:getSsoRespHandler	()Lcom/tencent/mobileqq/msf/core/n;
      //   1820: aload 11
      //   1822: aload 10
      //   1824: invokevirtual 531	com/tencent/mobileqq/msf/core/n:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   1827: goto -73 -> 1754
      //   1830: lload 7
      //   1832: lstore 5
      //   1834: lload 7
      //   1836: ldc2_w 532
      //   1839: lcmp
      //   1840: ifle -1234 -> 606
      //   1843: lconst_0
      //   1844: lstore 5
      //   1846: goto -1240 -> 606
      //   1849: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1850	0	this	a
      //   0	1850	1	paramInt1	int
      //   0	1850	2	paramObject	Object
      //   0	1850	3	paramInt2	int
      //   116	46	4	i	int
      //   509	1336	5	l1	long
      //   505	1330	7	l2	long
      //   83	950	9	localObject1	Object
      //   1041	123	9	localThrowable	Throwable
      //   1303	73	9	str	String
      //   1612	38	9	localException1	Exception
      //   43	1058	10	localFromServiceMsg	FromServiceMsg
      //   1116	707	10	localException2	Exception
      //   107	1714	11	localObject2	Object
      //   156	1369	12	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	1041	java/lang/Throwable
      //   8	19	1041	java/lang/Throwable
      //   19	118	1041	java/lang/Throwable
      //   124	183	1041	java/lang/Throwable
      //   183	204	1041	java/lang/Throwable
      //   256	373	1041	java/lang/Throwable
      //   373	410	1041	java/lang/Throwable
      //   415	436	1041	java/lang/Throwable
      //   436	464	1041	java/lang/Throwable
      //   464	484	1041	java/lang/Throwable
      //   484	504	1041	java/lang/Throwable
      //   520	531	1041	java/lang/Throwable
      //   544	589	1041	java/lang/Throwable
      //   606	621	1041	java/lang/Throwable
      //   628	635	1041	java/lang/Throwable
      //   635	752	1041	java/lang/Throwable
      //   752	835	1041	java/lang/Throwable
      //   840	854	1041	java/lang/Throwable
      //   854	916	1041	java/lang/Throwable
      //   921	965	1041	java/lang/Throwable
      //   974	982	1041	java/lang/Throwable
      //   993	1021	1041	java/lang/Throwable
      //   1022	1038	1041	java/lang/Throwable
      //   1093	1113	1041	java/lang/Throwable
      //   1118	1152	1041	java/lang/Throwable
      //   1152	1161	1041	java/lang/Throwable
      //   1162	1171	1041	java/lang/Throwable
      //   1172	1279	1041	java/lang/Throwable
      //   1282	1305	1041	java/lang/Throwable
      //   1308	1386	1041	java/lang/Throwable
      //   1389	1517	1041	java/lang/Throwable
      //   1520	1609	1041	java/lang/Throwable
      //   1614	1654	1041	java/lang/Throwable
      //   1664	1700	1041	java/lang/Throwable
      //   1701	1711	1041	java/lang/Throwable
      //   1711	1754	1041	java/lang/Throwable
      //   1754	1777	1041	java/lang/Throwable
      //   1778	1800	1041	java/lang/Throwable
      //   1803	1827	1041	java/lang/Throwable
      //   256	373	1116	java/lang/Exception
      //   840	854	1612	java/lang/Exception
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      int i = 0;
      int j;
      synchronized (l.a(l.this))
      {
        long l = SystemClock.elapsedRealtime();
        if (l.this.n >= l)
        {
          l.b(l.this);
          j = l.c(l.this).size();
          QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + j);
          if (j <= 0) {
            break label281;
          }
        }
      }
      for (;;)
      {
        try
        {
          ??? = ByteBuffer.allocate(20480);
          if (i < j)
          {
            paramIntent = (ToServiceMsg)l.c(l.this).poll();
            if (paramIntent != null)
            {
              l.a(l.this, paramIntent);
              ???.put(paramIntent.getWupBuffer());
            }
            i += 1;
            continue;
            l.a(l.this, false);
            break;
            paramIntent = finally;
            throw paramIntent;
          }
          if (j > 0)
          {
            ???.flip();
            paramIntent = new byte[???.limit()];
            ???.get(paramIntent);
            ??? = new ByteArrayOutputStream();
            GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(???);
            localGZIPOutputStream.write(paramIntent);
            localGZIPOutputStream.finish();
            localGZIPOutputStream.close();
            ??? = ???.toByteArray();
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList buffer size is " + paramIntent.length + ", zip size is " + ???.length);
          }
          return;
        }
        catch (Exception ???)
        {
          QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error " + ???, ???);
          return;
        }
        label281:
        ??? = null;
      }
    }
  }
  
  class c
    extends Thread
  {
    long a = 0L;
    
    c() {}
    
    private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
    {
      l.this.a(paramToServiceMsg.getRequestSsoSeq());
    }
    
    public void run()
    {
      ToServiceMsg localToServiceMsg;
      int i;
      Object localObject2;
      long l1;
      long l2;
      byte b1;
      label141:
      boolean bool1;
      for (;;)
      {
        byte b2;
        label266:
        Object localObject1;
        try
        {
          localToServiceMsg = (ToServiceMsg)l.d(l.this).k();
          if (localToServiceMsg != null)
          {
            try
            {
              String str = localToServiceMsg.getServiceCmd();
              i = str.indexOf("#");
              if (i == -1) {
                break label1353;
              }
              localObject2 = str.substring(i + 1, str.length()) + "_new";
              str = str.substring(0, i);
              l1 = ((Long)localToServiceMsg.getAttribute("__timestamp_addSendQueue", Long.valueOf(0L))).longValue();
              l2 = System.currentTimeMillis();
              l.this.f.configManager.a(localToServiceMsg, l2);
              if (localToServiceMsg.getWupBuffer() == null) {
                break label591;
              }
              b2 = 0;
              if (!NetConnInfoCenterImpl.isWifiConn()) {
                break label441;
              }
              b1 = 1;
              byte[] arrayOfByte1 = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), j.d(), j.f(), j.g(), "", str, l.this.b(), localToServiceMsg.getAppId(), l.this.f.getMsfAppid(), localToServiceMsg.getUin(), (byte)0, b1, localToServiceMsg.getWupBuffer());
              if (arrayOfByte1 != null) {
                break;
              }
              l.this.a(localToServiceMsg.getRequestSsoSeq());
            }
            catch (Throwable localThrowable1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, localThrowable1.toString(), localThrowable1);
              }
              a(localToServiceMsg, "发送错误", localThrowable1.toString());
              l.d(l.this).remove(localToServiceMsg);
            }
            localObject1 = localToServiceMsg.getMsfCommand();
            localObject2 = MsfCommand._msf_kickedAndCleanTokenResp;
            if (localObject1 != localObject2) {}
          }
        }
        catch (Throwable localThrowable2) {}
        try
        {
          localObject1 = (FromServiceMsg)localToServiceMsg.getAttribute(localToServiceMsg.getServiceCmd());
          l.this.f.getAccountCenter().m(((FromServiceMsg)localObject1).getUin());
          ((FromServiceMsg)localObject1).setBusinessFail(2012, ((FromServiceMsg)localObject1).getBusinessFailMsg());
          bool1 = false;
          if (localToServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
            bool1 = ((Boolean)localToServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
          }
          ((FromServiceMsg)localObject1).addAttribute("_attr_sameDevice", Boolean.valueOf(bool1));
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject1);
          l.this.f.addRespToQuque(null, (FromServiceMsg)localObject1);
          l.this.a.a(com.tencent.qphone.base.a.a);
        }
        catch (Exception localException1)
        {
          label441:
          int j;
          label591:
          byte[] arrayOfByte2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MSF.C.NetConnTag", 2, "send offlineMsg to app error " + localException1.toString());
          continue;
        }
        Thread.sleep(10L);
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, localThrowable2.toString(), localThrowable2);
          continue;
          if (NetConnInfoCenterImpl.isMobileConn())
          {
            j = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
            i = j;
            if (j <= 254) {
              break label1359;
            }
            j = 254;
            i = j;
            if (!QLog.isColorLevel()) {
              break label1359;
            }
            QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
            i = j;
            break label1359;
          }
          if (this.a != 0L)
          {
            b1 = b2;
            if (l2 - this.a <= 60000L) {}
          }
          else
          {
            this.a = l2;
            try
            {
              NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
              b1 = b2;
            }
            catch (Exception localException2)
            {
              QLog.d("MSF.C.NetConnTag", 1, "checkConnInfo " + localException2);
              b1 = b2;
            }
            continue;
            arrayOfByte2 = new byte[0];
          }
        }
      }
      if ((!localToServiceMsg.getUin().equals("0")) && (!((Boolean)localToServiceMsg.getAttribute("grayCheck", Boolean.valueOf(false))).booleanValue()) && (localToServiceMsg.getAppId() != -1) && (localToServiceMsg.getAppId() != 100)) {
        l.b(l.this, localToServiceMsg);
      }
      for (;;)
      {
        if (bool1) {
          break label266;
        }
        l2 = System.currentTimeMillis();
        if (l2 - l1 > localToServiceMsg.getTimeout())
        {
          if (!QLog.isColorLevel()) {
            break label266;
          }
          QLog.d("MSF.C.NetConnTag", 2, localToServiceMsg + " is already sendTimeout,break.");
          break label266;
        }
        if ((l.s != 0L) && (l2 - l.s > com.tencent.mobileqq.msf.core.a.a.l()) && (l.this.a.b()))
        {
          if (l.s >= l.this.a.n().c())
          {
            l.s = 0L;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "lastMessageTimeTooLong Close socket now. System.currentTimeMillis() - lastRecvSsoRespTime :" + (System.currentTimeMillis() - l.s) + " getNetIdleTimeInterval()" + com.tencent.mobileqq.msf.core.a.a.l());
            }
            l.this.a(com.tencent.qphone.base.a.o);
          }
        }
        else if ((l.s != 0L) && (l2 - l.s > 360000L) && (l.this.a.b()) && (l.s >= l.this.a.n().c()) && (!l.this.o.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "no receive data for 5 minutes, start fast net detect now.");
          }
          l.e(l.this);
        }
        boolean bool2;
        try
        {
          localToServiceMsg.addAttribute("__timestamp_msf2net_boot", Long.valueOf(SystemClock.elapsedRealtime()));
          localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(0L));
          localToServiceMsg.addAttribute("_tag_socket", l.h);
          localToServiceMsg.addAttribute("_tag_localsocket", l.i);
          bool2 = l.this.a.a(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), localThrowable2, (String)localObject2, localToServiceMsg.getMsfCommand(), localToServiceMsg.getUin(), localToServiceMsg.getRequestSsoSeq(), arrayOfByte2);
          if (!bool2)
          {
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net_boot");
            localToServiceMsg.getAttributes().remove("__timestamp_msf2net");
            localToServiceMsg.getAttributes().remove("_tag_socket");
            localToServiceMsg.getAttributes().remove("_tag_localsocket");
            l.this.a.a(com.tencent.qphone.base.a.d);
            try
            {
              Thread.sleep(BaseConstants.reSendIntrevTime);
              bool1 = bool2;
            }
            catch (Exception localException3)
            {
              bool1 = bool2;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.NetConnTag", 2, localException3.toString(), localException3);
            bool1 = bool2;
            continue;
            l.s = 0L;
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.NetConnTag", 2, "send msg error " + localThrowable3, localThrowable3);
              bool2 = bool1;
            }
          }
          localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(System.currentTimeMillis()));
          if (localToServiceMsg.getServiceCmd().startsWith("SharpSvr.c2s")) {
            l.k = SystemClock.elapsedRealtime();
          }
          bool1 = bool2;
        }
        if (l.this.z.get())
        {
          bool1 = bool2;
          if (l.this.y == -1)
          {
            l.this.y = localToServiceMsg.getRequestSsoSeq();
            QLog.d("MSF.C.NetConnTag", 1, "set afterReloadD2SendSeq " + l.this.y);
            bool1 = bool2;
            continue;
            label1353:
            localObject2 = null;
            break;
            label1359:
            b1 = (byte)i;
            break label141;
            bool1 = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.l
 * JD-Core Version:    0.7.0.1
 */