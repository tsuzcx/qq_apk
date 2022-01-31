package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.b.i;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.core.net.f.b;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.e.c;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class l
{
  public static long C = 0L;
  static int D = -1;
  static AtomicBoolean E = new AtomicBoolean();
  public static final String G = "GrayUinPro.Check";
  public static final String H = "res";
  public static final int K = -10008;
  public static final int L = -302;
  public static final int M = 302;
  static CopyOnWriteArraySet N = new CopyOnWriteArraySet();
  private static final AtomicInteger W = new AtomicInteger();
  private static int Z = 0;
  private static String aa;
  private static String[] ab;
  private static AtomicBoolean ai = new AtomicBoolean();
  public static final String b = "__extraTimeoutSeq";
  public static final String m = "MSF.C.NetConnTag";
  public static ConcurrentHashMap n = new ConcurrentHashMap();
  public static AtomicInteger o = new AtomicInteger(0);
  public static String r = ":";
  public static String s = "0";
  public static int t = 0;
  public static long u;
  public static int x;
  long A = 0L;
  long B = 0L;
  HashSet F = new HashSet();
  public int I = -1;
  public AtomicBoolean J = new AtomicBoolean();
  ArrayList O = new ArrayList();
  boolean P = false;
  private ConcurrentHashMap Q = new ConcurrentHashMap();
  private ConcurrentHashMap R = new ConcurrentHashMap();
  private ConcurrentHashMap S = new ConcurrentHashMap();
  private com.tencent.mobileqq.msf.sdk.k T = new com.tencent.mobileqq.msf.sdk.k(1000);
  private com.tencent.mobileqq.msf.sdk.k U = new com.tencent.mobileqq.msf.sdk.k();
  private Handler V;
  private int X = 0;
  private String Y = "0";
  public h a;
  private HashSet ac = new HashSet();
  private volatile boolean ad = false;
  private Object ae = new Object();
  private byte[] af = null;
  private long ag = 0L;
  private Random ah = new Random(System.currentTimeMillis());
  b c = new b();
  public int d = 10;
  public int e = 3072;
  public int f = 0;
  public int g = 500;
  public int h = 0;
  public int i = 300;
  public long j = 0L;
  public boolean k = false;
  public volatile boolean l = false;
  public a p = new a();
  MsfCore q;
  c v = new c();
  long w;
  AtomicBoolean y = new AtomicBoolean();
  int z = 0;
  
  static
  {
    Z = 0;
    aa = "";
    ab = new String[] { "StreamSvr.UploadStreamMsg" };
    u = -1L;
    x = 0;
  }
  
  public l(MsfCore paramMsfCore)
  {
    this.q = paramMsfCore;
    a.a();
    HandlerThread localHandlerThread = new HandlerThread("mergehandle", 5);
    localHandlerThread.start();
    this.V = new Handler(localHandlerThread.getLooper());
    this.X = paramMsfCore.getMsfAppid();
    this.a = new h(paramMsfCore);
    this.v.setName("MsfCoreMsgSender");
    try
    {
      paramMsfCore = com.tencent.mobileqq.msf.core.a.a.c();
      if (paramMsfCore != null)
      {
        this.d = Integer.parseInt(paramMsfCore[0]);
        this.e = Integer.parseInt(paramMsfCore[1]);
        this.i = Integer.parseInt(paramMsfCore[2]);
        this.g = Integer.parseInt(paramMsfCore[3]);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "maxDelaySize: " + this.e + " noMergeSize: " + this.i + " globaldelayTime: " + this.g + " delayWaitSendCount: " + this.d);
        }
      }
      return;
    }
    catch (Exception paramMsfCore)
    {
      try
      {
        for (;;)
        {
          a(com.tencent.mobileqq.msf.core.a.a.d());
          try
          {
            this.h = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "mergeDuration: " + this.h);
            }
            return;
          }
          catch (Exception paramMsfCore)
          {
            QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
          }
          paramMsfCore = paramMsfCore;
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
      catch (Exception paramMsfCore)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      N.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      N.remove(paramString);
      if (n.containsKey(paramString))
      {
        n.remove(paramString);
        QLog.d("MSF.C.NetConnTag", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(paramString));
      }
    }
  }
  
  public static void b(int paramInt)
  {
    Z = paramInt;
  }
  
  /* Error */
  private void b(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   3: ifnull +58 -> 61
    //   6: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   9: arraylength
    //   10: ifle +51 -> 61
    //   13: aload_0
    //   14: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   17: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   20: invokevirtual 412	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   23: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +34 -> 60
    //   29: ldc 49
    //   31: iconst_2
    //   32: new 329	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 414
    //   42: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   48: invokestatic 419	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: return
    //   61: getstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   64: ifnull +58 -> 122
    //   67: getstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   70: arraylength
    //   71: ifle +51 -> 122
    //   74: aload_0
    //   75: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   78: getstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   81: invokevirtual 424	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   84: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -27 -> 60
    //   90: ldc 49
    //   92: iconst_2
    //   93: new 329	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 414
    //   103: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   109: invokestatic 419	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: return
    //   122: aload_1
    //   123: invokevirtual 429	android/content/Context:getPackageName	()Ljava/lang/String;
    //   126: astore_1
    //   127: new 431	java/io/File
    //   130: dup
    //   131: new 329	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 437	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 440	java/io/File:getPath	()Ljava/lang/String;
    //   144: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 442
    //   150: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: ldc_w 444
    //   157: ldc_w 446
    //   160: invokevirtual 450	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   163: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 452
    //   169: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 454	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 456	java/util/Properties
    //   182: dup
    //   183: invokespecial 457	java/util/Properties:<init>	()V
    //   186: astore_3
    //   187: new 459	java/io/FileInputStream
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 462	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: aload_2
    //   200: invokevirtual 466	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: ldc_w 468
    //   209: invokevirtual 471	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 4
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: ldc_w 473
    //   220: invokevirtual 471	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: ldc_w 475
    //   231: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   234: putstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: ldc_w 475
    //   243: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   255: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   258: invokevirtual 412	com/tencent/mobileqq/msf/core/net/h:a	([Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_1
    //   263: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +36 -> 302
    //   269: aload_2
    //   270: astore_1
    //   271: ldc 49
    //   273: iconst_2
    //   274: new 329	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 481
    //   284: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 411	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   290: invokestatic 419	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   293: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   308: getstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   311: invokevirtual 424	com/tencent/mobileqq/msf/core/net/h:b	([Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +36 -> 355
    //   322: aload_2
    //   323: astore_1
    //   324: ldc 49
    //   326: iconst_2
    //   327: new 329	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 481
    //   337: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 422	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   343: invokestatic 419	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_2
    //   356: invokevirtual 484	java/io/FileInputStream:close	()V
    //   359: return
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   365: return
    //   366: astore_3
    //   367: aconst_null
    //   368: astore_2
    //   369: aload_2
    //   370: astore_1
    //   371: aload_3
    //   372: invokevirtual 488	java/lang/Exception:printStackTrace	()V
    //   375: aload_2
    //   376: invokevirtual 484	java/io/FileInputStream:close	()V
    //   379: return
    //   380: astore_1
    //   381: aload_1
    //   382: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   385: return
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 484	java/io/FileInputStream:close	()V
    //   393: aload_2
    //   394: athrow
    //   395: astore_1
    //   396: aload_1
    //   397: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   400: goto -7 -> 393
    //   403: astore_2
    //   404: goto -15 -> 389
    //   407: astore_3
    //   408: goto -39 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	l
    //   0	411	1	paramContext	android.content.Context
    //   195	181	2	localFileInputStream	java.io.FileInputStream
    //   386	8	2	localObject1	Object
    //   403	1	2	localObject2	Object
    //   186	54	3	localObject3	Object
    //   366	6	3	localException1	Exception
    //   407	1	3	localException2	Exception
    //   212	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   355	359	360	java/io/IOException
    //   187	196	366	java/lang/Exception
    //   375	379	380	java/io/IOException
    //   187	196	386	finally
    //   389	393	395	java/io/IOException
    //   198	203	403	finally
    //   205	214	403	finally
    //   216	224	403	finally
    //   226	237	403	finally
    //   239	249	403	finally
    //   251	261	403	finally
    //   263	269	403	finally
    //   271	302	403	finally
    //   304	314	403	finally
    //   316	322	403	finally
    //   324	355	403	finally
    //   371	375	403	finally
    //   198	203	407	java/lang/Exception
    //   205	214	407	java/lang/Exception
    //   216	224	407	java/lang/Exception
    //   226	237	407	java/lang/Exception
    //   239	249	407	java/lang/Exception
    //   251	261	407	java/lang/Exception
    //   263	269	407	java/lang/Exception
    //   271	302	407	java/lang/Exception
    //   304	314	407	java/lang/Exception
    //   316	322	407	java/lang/Exception
    //   324	355	407	java/lang/Exception
  }
  
  public static void b(String paramString)
  {
    aa = paramString;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  /* Error */
  private void c(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 518	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   3: ifnull +81 -> 84
    //   6: getstatic 518	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   9: ldc 136
    //   11: invokevirtual 521	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +70 -> 84
    //   17: getstatic 518	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   20: invokestatic 526	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 528	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   28: ifnull +10 -> 38
    //   31: aload_1
    //   32: invokevirtual 530	com/tencent/mobileqq/msf/core/d:d	()I
    //   35: ifgt +4 -> 39
    //   38: return
    //   39: aload_0
    //   40: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   43: getstatic 518	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   46: invokevirtual 532	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   49: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -14 -> 38
    //   55: ldc 49
    //   57: iconst_2
    //   58: new 329	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 534
    //   68: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 518	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   74: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 429	android/content/Context:getPackageName	()Ljava/lang/String;
    //   88: astore_1
    //   89: new 431	java/io/File
    //   92: dup
    //   93: new 329	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   100: invokestatic 437	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   103: invokevirtual 440	java/io/File:getPath	()Ljava/lang/String;
    //   106: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 442
    //   112: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: ldc_w 444
    //   119: ldc_w 446
    //   122: invokevirtual 450	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 536
    //   131: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 454	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: astore_1
    //   141: new 456	java/util/Properties
    //   144: dup
    //   145: invokespecial 457	java/util/Properties:<init>	()V
    //   148: astore 4
    //   150: aload_1
    //   151: invokevirtual 539	java/io/File:exists	()Z
    //   154: ifeq +252 -> 406
    //   157: new 459	java/io/FileInputStream
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 462	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   165: astore_2
    //   166: aload_2
    //   167: astore_1
    //   168: aload 4
    //   170: aload_2
    //   171: invokevirtual 466	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   174: aload_2
    //   175: astore_1
    //   176: aload_2
    //   177: invokevirtual 484	java/io/FileInputStream:close	()V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 484	java/io/FileInputStream:close	()V
    //   188: iconst_0
    //   189: ifeq +11 -> 200
    //   192: new 541	java/lang/NullPointerException
    //   195: dup
    //   196: invokespecial 542	java/lang/NullPointerException:<init>	()V
    //   199: athrow
    //   200: aload 4
    //   202: ldc_w 544
    //   205: invokevirtual 471	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_1
    //   209: aload_1
    //   210: ifnull -172 -> 38
    //   213: aload_1
    //   214: invokevirtual 547	java/lang/String:trim	()Ljava/lang/String;
    //   217: invokevirtual 550	java/lang/String:length	()I
    //   220: ifle -182 -> 38
    //   223: aload_1
    //   224: invokestatic 526	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   227: astore_2
    //   228: aload_2
    //   229: invokevirtual 528	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   232: ifnull -194 -> 38
    //   235: aload_2
    //   236: invokevirtual 530	com/tencent/mobileqq/msf/core/d:d	()I
    //   239: ifle -201 -> 38
    //   242: aload_1
    //   243: invokevirtual 547	java/lang/String:trim	()Ljava/lang/String;
    //   246: ldc_w 363
    //   249: ldc 136
    //   251: invokevirtual 450	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 304	com/tencent/mobileqq/msf/core/l:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   259: aload_1
    //   260: invokevirtual 532	com/tencent/mobileqq/msf/core/net/h:a	(Ljava/lang/String;)V
    //   263: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq -228 -> 38
    //   269: ldc 49
    //   271: iconst_2
    //   272: new 329	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 552
    //   282: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: return
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   301: goto -113 -> 188
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   309: goto -109 -> 200
    //   312: astore_3
    //   313: aconst_null
    //   314: astore_2
    //   315: aload_2
    //   316: astore_1
    //   317: aload_3
    //   318: invokevirtual 488	java/lang/Exception:printStackTrace	()V
    //   321: aload_2
    //   322: ifnull +7 -> 329
    //   325: aload_2
    //   326: invokevirtual 484	java/io/FileInputStream:close	()V
    //   329: iconst_0
    //   330: ifeq -130 -> 200
    //   333: new 541	java/lang/NullPointerException
    //   336: dup
    //   337: invokespecial 542	java/lang/NullPointerException:<init>	()V
    //   340: athrow
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   346: goto -146 -> 200
    //   349: astore_1
    //   350: aload_1
    //   351: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   354: goto -25 -> 329
    //   357: astore_2
    //   358: aconst_null
    //   359: astore_1
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 484	java/io/FileInputStream:close	()V
    //   368: iconst_0
    //   369: ifeq +11 -> 380
    //   372: new 541	java/lang/NullPointerException
    //   375: dup
    //   376: invokespecial 542	java/lang/NullPointerException:<init>	()V
    //   379: athrow
    //   380: aload_2
    //   381: athrow
    //   382: astore_1
    //   383: aload_1
    //   384: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   387: goto -19 -> 368
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   395: goto -15 -> 380
    //   398: astore_2
    //   399: goto -39 -> 360
    //   402: astore_3
    //   403: goto -88 -> 315
    //   406: aconst_null
    //   407: astore_2
    //   408: goto -228 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	l
    //   0	411	1	paramContext	android.content.Context
    //   165	161	2	localObject1	Object
    //   357	24	2	localObject2	Object
    //   398	1	2	localObject3	Object
    //   407	1	2	localObject4	Object
    //   312	6	3	localException1	Exception
    //   402	1	3	localException2	Exception
    //   148	53	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   184	188	296	java/io/IOException
    //   192	200	304	java/io/IOException
    //   150	166	312	java/lang/Exception
    //   333	341	341	java/io/IOException
    //   325	329	349	java/io/IOException
    //   150	166	357	finally
    //   364	368	382	java/io/IOException
    //   372	380	390	java/io/IOException
    //   168	174	398	finally
    //   176	180	398	finally
    //   317	321	398	finally
    //   168	174	402	java/lang/Exception
    //   176	180	402	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    com.tencent.mobileqq.msf.sdk.n.b(Integer.parseInt(paramString));
  }
  
  private int d(ToServiceMsg paramToServiceMsg)
  {
    Object localObject;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.Q.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(W.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject);
        label85:
        if (this.T.offer(paramToServiceMsg)) {
          break label338;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.T.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label262;
        }
        localObject = k.a(paramToServiceMsg);
        ((FromServiceMsg)localObject).setBusinessFail(1008, "send queue is full!");
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      }
    }
    for (;;)
    {
      if ((!E.get()) && (f.b))
      {
        E.set(true);
        D = paramToServiceMsg.getRequestSsoSeq();
      }
      return paramToServiceMsg.getRequestSsoSeq();
      localObject = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      break;
      if (!paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
        break label85;
      }
      this.q.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
      break label85;
      label262:
      localObject = (ArrayList)this.S.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject).next();
          FromServiceMsg localFromServiceMsg = k.a(localToServiceMsg);
          localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
          this.q.addRespToQuque(localToServiceMsg, localFromServiceMsg);
        }
        continue;
        label338:
        if (this.S.contains(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) {
          this.S.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue");
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.F.contains(paramToServiceMsg.getUin()))
      {
        this.ag += 1L;
        if (this.ag >= 2L)
        {
          i1 = i2;
          if (this.ah.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static void g()
  {
    Iterator localIterator = N.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    N.clear();
  }
  
  public static int l()
  {
    return Z;
  }
  
  public static String m()
  {
    return aa;
  }
  
  private void p()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.q.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.m());
      a(localToServiceMsg);
      this.z += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.A = System.currentTimeMillis();
      this.y.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    r();
  }
  
  private void q()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.q.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(10000L);
      a(localToServiceMsg);
      this.z = com.tencent.mobileqq.msf.core.a.a.n();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
      }
      this.A = System.currentTimeMillis();
      this.y.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    r();
  }
  
  private void r()
  {
    this.z = 0;
    this.y.set(false);
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
      this.Q.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(W.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label165;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.T.a(paramToServiceMsg);
        return paramToServiceMsg.getRequestSsoSeq();
        label165:
        localRunnable = this.q.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
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
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.Q.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.q.msfAlarmer.b().removeCallbacks(localRunnable);
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
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.F.add(paramFromServiceMsg.getUin());
    }
    label331:
    for (;;)
    {
      try
      {
        Object localObject1 = paramFromServiceMsg.getWupBuffer();
        if ((localObject1.length <= 4) || (localObject1[0] != 0) || (localObject1[1] != 0) || (localObject1[2] != 0) || (localObject1[3] != 4)) {
          break label331;
        }
        Object localObject2 = new byte[localObject1.length - 4];
        System.arraycopy(localObject1, 4, localObject2, 0, localObject2.length);
        localObject1 = localObject2;
        QLog.d("MSF.C.NetConnTag", 1, "recv buf:" + HexUtil.bytes2HexStr((byte[])localObject1));
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((com.tencent.msf.service.protocol.e.d)localObject1).a + " yyb:" + ((com.tencent.msf.service.protocol.e.d)localObject1).b + " msg:" + HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.q.getSsoRespHandler();
          n.a.put(paramFromServiceMsg.getUin(), localObject1);
          this.q.getAccountCenter().m(paramFromServiceMsg.getUin());
          return;
        }
        n.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
      return;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
      return;
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
        r();
      }
      do
      {
        return;
        if (this.z < com.tencent.mobileqq.msf.core.a.a.n()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.z + ",try close conn");
          }
          this.q.sender.a.a(com.tencent.qphone.base.a.p);
          r();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.A > com.tencent.mobileqq.msf.core.a.a.n() * com.tencent.mobileqq.msf.core.a.a.m())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.A) + ",try close conn");
        }
        this.q.sender.a.a(com.tencent.qphone.base.a.e);
        r();
        return;
      }
      p();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    r();
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nateiveRemoveAccountKey(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.O.add(paramHashMap);
    this.P = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.O.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.af = paramArrayOfByte;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.ac.add(str);
        i1 += 1;
      }
    }
    this.ac.add("GrayUinPro.Check");
    this.ac.add("StatSvc.register");
    this.ac.add("StatSvc.get");
    this.ac.add("RegPrxySvc.infoLogin");
    this.ac.add("wtlogin.login");
    this.ac.add("RegPrxySvc.getOffMsg");
    this.ac.add("login.auth");
    this.ac.add("wtlogin.exchange");
    this.ac.add("wtlogin.trans_emp");
    this.ac.add("MessageSvc.PbSendMsg");
    this.ac.add("LongConn.OffPicUp");
    this.ac.add("LongConn.OffPicDown");
    this.ac.add("ImgStore.GroupPicUp");
    this.ac.add("ImgStore.GroupPicDown");
    this.ac.add("StreamSvr.UploadStreamMsg");
    this.ac.add("StreamSvr.RespUploadStreamMsg");
    this.ac.add("StreamSvr.PushStreamMsg");
    this.ac.add("StreamSvr.RespPushStreamMsg");
    this.ac.add("OidbSvc.0x787_1");
    this.ac.add("OidbSvc.0x49d_107");
    this.ac.add("MultiMsg.ApplyUp");
    this.ac.add("MultiMsg.ApplyDown");
    this.ac.add("PttCenterSvr.ShortVideoUpReq");
    this.ac.add("PttCenterSvr.ShortVideoDownReq");
    this.ac.add("ImgStore.GroupPicUp#pttGu");
    this.ac.add("ImgStore.GroupPicDown#pttGd");
    this.ac.add("PttStore.GroupPttUp");
    this.ac.add("PttStore.GroupPttDown");
    this.ac.add("Heartbeat.Alive");
    this.ac.add("friendlist.getFriendGroupList");
    this.ac.add("VideoSvc.Send");
    this.ac.add("VideoSvc.Ack");
    this.ac.add("SharpSvr.c2s");
    this.ac.add("SharpSvr.c2sack");
    this.ac.add("SharpSvr.s2c");
    this.ac.add("SharpSvr.s2cack");
    this.ac.add("MultiVideo.c2s");
    this.ac.add("MultiVideo.c2sack");
    this.ac.add("MultiVideo.s2c");
    this.ac.add("MultiVideo.s2cack");
    this.ac.add("MessageSvc.PbGetMsg");
    this.ac.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ac.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.ac.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ac.add("cmd_openConn");
    this.ac.add("wtlogin.exchange_emp");
    this.ac.add("wtlogin.name2uin");
  }
  
  public boolean a()
  {
    return this.Q.isEmpty();
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1025	com/tencent/mobileqq/msf/core/l:b	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 1027	com/tencent/mobileqq/msf/core/l:c	(Landroid/content/Context;)V
    //   10: aload_0
    //   11: getfield 211	com/tencent/mobileqq/msf/core/l:p	Lcom/tencent/mobileqq/msf/core/l$a;
    //   14: aload_1
    //   15: iconst_0
    //   16: invokevirtual 1031	com/tencent/mobileqq/msf/core/l$a:init	(Landroid/content/Context;Z)V
    //   19: aload_0
    //   20: getfield 267	com/tencent/mobileqq/msf/core/l:q	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   23: invokevirtual 880	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   26: invokevirtual 1033	com/tencent/mobileqq/msf/core/auth/b:f	()[B
    //   29: invokestatic 1036	com/tencent/qphone/base/util/CodecWarpper:setKsid	([B)V
    //   32: aload_0
    //   33: getfield 218	com/tencent/mobileqq/msf/core/l:v	Lcom/tencent/mobileqq/msf/core/l$c;
    //   36: invokevirtual 1037	com/tencent/mobileqq/msf/core/l$c:start	()V
    //   39: invokestatic 1043	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   42: ldc_w 1045
    //   45: invokevirtual 1050	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +72 -> 122
    //   53: aload_1
    //   54: invokevirtual 550	java/lang/String:length	()I
    //   57: ifle +65 -> 122
    //   60: invokestatic 1043	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   63: ldc_w 1052
    //   66: invokevirtual 1050	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +163 -> 236
    //   76: aload 4
    //   78: invokevirtual 550	java/lang/String:length	()I
    //   81: ifle +155 -> 236
    //   84: aload 4
    //   86: invokestatic 1056	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: lstore_2
    //   90: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   93: lload_2
    //   94: lsub
    //   95: ldc2_w 1057
    //   98: lcmp
    //   99: ifle +101 -> 200
    //   102: new 1060	com/tencent/mobileqq/msf/core/m
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 1061	com/tencent/mobileqq/msf/core/m:<init>	(Lcom/tencent/mobileqq/msf/core/l;)V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc_w 1063
    //   115: invokevirtual 1066	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   118: aload_1
    //   119: invokevirtual 1067	java/lang/Thread:start	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore 4
    //   126: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -124 -> 5
    //   132: ldc 49
    //   134: iconst_2
    //   135: new 329	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1069
    //   145: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 4
    //   150: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: goto -154 -> 5
    //   162: astore 4
    //   164: invokestatic 327	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq -157 -> 10
    //   170: ldc 49
    //   172: iconst_2
    //   173: new 329	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 1071
    //   183: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 4
    //   188: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: goto -187 -> 10
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 1073	com/tencent/mobileqq/msf/core/l:c	(Ljava/lang/String;)V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_1
    //   208: ldc 49
    //   210: iconst_1
    //   211: new 329	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 1075
    //   221: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iconst_1
    //   235: ireturn
    //   236: invokestatic 1043	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   239: ldc_w 1052
    //   242: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   245: invokestatic 1078	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   248: invokevirtual 1082	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: aload_1
    //   253: invokespecial 1073	com/tencent/mobileqq/msf/core/l:c	(Ljava/lang/String;)V
    //   256: iconst_1
    //   257: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	l
    //   0	258	1	paramContext	android.content.Context
    //   89	5	2	l1	long
    //   69	16	4	str	String
    //   124	25	4	localException1	Exception
    //   162	25	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	124	java/lang/Exception
    //   5	10	162	java/lang/Exception
    //   39	49	207	java/lang/Exception
    //   53	71	207	java/lang/Exception
    //   76	122	207	java/lang/Exception
    //   200	205	207	java/lang/Exception
    //   236	256	207	java/lang/Exception
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.f.a(f.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", h.D);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", h.D);
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
      if ((l2 != 0L) && (l3 - l2 > paramToServiceMsg.getTimeout()) && (l3 - l2 > this.q.pushManager.e()))
      {
        if (l2 >= this.a.n().c())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
          }
          this.q.sender.a.a(com.tencent.qphone.base.a.q);
          r();
          return true;
        }
        return true;
      }
      if ((l1 == 0L) || (l1 > this.a.n().c()))
      {
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
        }
        try
        {
          if ((this.y.get()) && (System.currentTimeMillis() - this.A < com.tencent.mobileqq.msf.core.a.a.r() + 120000)) {
            break label529;
          }
          l1 = System.currentTimeMillis();
          if (l1 - this.A <= com.tencent.mobileqq.msf.core.a.a.r()) {
            break label474;
          }
          if (paramToServiceMsg.getRequestSsoSeq() == D)
          {
            D = -1;
            QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
            this.q.sender.a.a(com.tencent.qphone.base.a.t);
            r();
            return true;
          }
        }
        finally {}
        p();
      }
      for (;;)
      {
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
          break label608;
        }
        return false;
        label474:
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.A + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.r());
        break;
        label529:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.y + "net detect has started, no need sendHeartbeat");
        break;
        QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
      }
      for (;;)
      {
        try
        {
          label608:
          if (this.a.b())
          {
            int i3 = 1;
            paramFromServiceMsg = ab;
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
            if ((i2 != 0) && (o.incrementAndGet() >= com.tencent.mobileqq.msf.core.a.a.o()))
            {
              QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
              o.set(0);
              this.q.sender.a.a(com.tencent.qphone.base.a.e);
              r();
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
    if (this.q.isSuspended())
    {
      ??? = k.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    String str1;
    Object localObject2;
    String str2;
    int i1;
    if (this.q.configManager.J != null)
    {
      Iterator localIterator = this.q.configManager.J.keySet().iterator();
      ??? = null;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          localObject2 = (a.a)this.q.configManager.J.get(str1);
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + str1);
            }
            this.q.configManager.J.remove(str1);
            ??? = localObject2;
          }
          else
          {
            str2 = paramToServiceMsg.getServiceCmd();
            if (str1.charAt(str1.length() - 1) == '*')
            {
              ??? = localObject2;
              if (!str2.startsWith(str1.substring(0, str1.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label1755;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
              i1 = 1;
              ??? = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (??? != null))
      {
        localObject2 = k.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!str1.equals(str2)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1755;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str2 + " sCmd:" + str1);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn))
      {
        ??? = k.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (ai.get())
      {
        ??? = k.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)n.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.F.remove(paramToServiceMsg.getUin());
          n.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = k.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.q.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.q.getAccountCenter().i(((FromServiceMsg)localObject2).getUin())) {
            this.q.getAccountCenter().m(((FromServiceMsg)localObject2).getUin());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((FromServiceMsg)localObject2).setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.q.getAccountCenter().k(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.Y.equals(paramToServiceMsg.getUin())))
      {
        this.Y = paramToServiceMsg.getUin();
        this.q.statReporter.a(this.Y);
        if (this.X != paramToServiceMsg.getAppId()) {
          this.X = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.k) && (this.l))
        {
          this.j = SystemClock.elapsedRealtime();
          this.k = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.l))
        {
          this.j = SystemClock.elapsedRealtime();
          this.k = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.ac.size() == ???.length)) {
            break label1362;
          }
          a((String[])???);
        }
        label1103:
        if ((!this.l) || (SystemClock.elapsedRealtime() - this.j >= this.h)) {
          break label1744;
        }
        if (this.ac.size() == 0) {
          a(null);
        }
        if (!this.ac.contains(paramToServiceMsg.getServiceCmd())) {
          break label1484;
        }
        if (!paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) {
          break label1478;
        }
        this.U.add(paramToServiceMsg);
        i1 = paramToServiceMsg.getWupBuffer().length;
      }
      for (;;)
      {
        synchronized (this.ae)
        {
          this.f = (i1 + this.f);
          if (!this.ad)
          {
            this.V.post(this.c);
            this.ad = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(h());
            break;
            label1362:
            if (??? != null) {
              break label1103;
            }
            a(null);
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label1478:
      return d(paramToServiceMsg);
      label1484:
      this.w = SystemClock.elapsedRealtime();
      this.U.add(paramToServiceMsg);
      i1 = paramToServiceMsg.getWupBuffer().length;
      for (;;)
      {
        synchronized (this.ae)
        {
          this.f = (i1 + this.f);
          if (!this.ad)
          {
            this.V.postDelayed(this.c, this.g);
            this.ad = true;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd() + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
            return paramToServiceMsg.getRequestSsoSeq();
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " scmd: " + paramToServiceMsg.getServiceCmd().hashCode() + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + "SSO.LoginMerge".hashCode() + " delayWaitSendList");
      }
      label1744:
      return d(paramToServiceMsg);
      i1 = 0;
      continue;
      label1755:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public byte[] b()
  {
    return this.af;
  }
  
  public void c()
  {
    if (this.Y != "0") {
      this.q.getAccountCenter().a(false);
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.p.onReceData(paramArrayOfByte);
  }
  
  public byte[] c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      int i1;
      try
      {
        String str = paramToServiceMsg.getServiceCmd();
        i1 = str.indexOf("#");
        localObject = str;
        if (i1 != -1) {
          localObject = str.substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          b1 = 0;
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            b1 = 1;
            g();
            return CodecWarpper.encodeRequest(paramToServiceMsg.getRequestSsoSeq(), k.d(), k.f(), k.g(), "", (String)localObject, b(), paramToServiceMsg.getAppId(), this.q.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), false);
          }
          if (!NetConnInfoCenterImpl.isMobileConn()) {
            continue;
          }
          int i2 = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
          i1 = i2;
          if (i2 <= 254) {
            break label207;
          }
          i2 = 254;
          i1 = i2;
          if (!QLog.isColorLevel()) {
            break label207;
          }
          QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
          i1 = i2;
          break label207;
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        localObject = new byte[0];
      }
      return localObject;
      label207:
      byte b1 = (byte)i1;
    }
  }
  
  public ToServiceMsg d()
  {
    return null;
  }
  
  public ConcurrentHashMap e()
  {
    return this.Q;
  }
  
  public ConcurrentHashMap f()
  {
    return this.R;
  }
  
  public String h()
  {
    return this.Y;
  }
  
  public int i()
  {
    return this.X;
  }
  
  public void j()
  {
    try
    {
      if (this.P)
      {
        Iterator localIterator = this.O.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.q.configManager.a(localHashMap, "");
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
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.O.size());
    }
    this.O.clear();
    this.P = false;
  }
  
  public void k()
  {
    Iterator localIterator = this.Q.entrySet().iterator();
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
        if ((localObject1 == null) || (this.T.contains(localObject1))) {
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
        this.q.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
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
      case -7: 
        return com.tencent.qphone.base.a.s;
      }
      return com.tencent.qphone.base.a.y;
    }
    
    private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
    {
      paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
      paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
      Object localObject1 = paramFromServiceMsg.getMsgCookie();
      if ((localObject1 != null) && (localObject1.length > 0)) {
        l.this.q.sender.a((byte[])localObject1);
      }
      paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
      ToServiceMsg localToServiceMsg;
      label132:
      int i;
      Object localObject2;
      if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == -10008))
      {
        l.a(paramFromServiceMsg.getUin(), false);
        if (NetConnInfoCenterImpl.isNeedWifiAuth()) {
          NetConnInfoCenterImpl.setNeedWifiAuth(false);
        }
        localToServiceMsg = l.this.q.sender.a(paramFromServiceMsg.getRequestSsoSeq());
        if (localToServiceMsg == null) {
          break label1004;
        }
        localObject1 = localToServiceMsg.getServiceCmd();
        i = ((String)localObject1).indexOf("#");
        if (i == -1) {
          break label1013;
        }
        localObject2 = ((String)localObject1).substring(i + 1, ((String)localObject1).length()) + "_new";
        ((String)localObject1).substring(0, i);
        i.a(true, paramFromServiceMsg.getUin(), paramInt, (String)localObject2, 1, l.this.a.n().l, l.this.a.n().m);
        label224:
        if ((localToServiceMsg == null) || (localToServiceMsg.getAttribute("__timestamp_msf2net") == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)) {
          break label1585;
        }
        l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        l2 = l1;
        if (l1 <= 2147483647L) {}
      }
      label1585:
      for (long l2 = 0L;; l2 = 0L)
      {
        for (;;)
        {
          localObject2 = new StringBuilder();
          if (QLog.isDevelopLevel()) {
            if (l2 == 0L)
            {
              localObject1 = String.valueOf(l2);
              label342:
              if (paramFromServiceMsg.getResultCode() == 1000) {
                break label1080;
              }
              QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + (String)localObject1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
              label445:
              paramFromServiceMsg.addAttribute("_tag_LOGSTR", l.r + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
              paramFromServiceMsg.addAttribute("_tag_socket", l.r);
              paramFromServiceMsg.addAttribute("_tag_localsocket", l.s);
              if (localToServiceMsg == null) {}
            }
          }
          try
          {
            l.this.a.a(paramFromServiceMsg, localToServiceMsg);
            if ((l.this.q.isReconnectSso.get()) && (l.this.q.sender.a()))
            {
              l.this.a.n().a(com.tencent.qphone.base.a.h);
              l.this.q.isReconnectSso.set(false);
            }
            if (localToServiceMsg != null)
            {
              paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
              paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
              paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
              if (!paramFromServiceMsg.isSuccess())
              {
                i = paramFromServiceMsg.getBusinessFailCode();
                paramInt = i;
                if (i == 302)
                {
                  paramFromServiceMsg.setBusinessFail(-302);
                  paramInt = -302;
                }
                if (paramInt == -302)
                {
                  l.this.a.n().a(com.tencent.qphone.base.a.i);
                  l.this.q.reSendMsg(localToServiceMsg);
                  return;
                  if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (l.N.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.requestrebindmblwtLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.requestverifywtlogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("connauthsvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("connauthsvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("connauthsvr.get_auth_api_list_emp"))) {
                    break;
                  }
                  localObject1 = (ConcurrentLinkedQueue)l.n.get(paramFromServiceMsg.getUin());
                  if ((localObject1 != null) && (((ConcurrentLinkedQueue)localObject1).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
                  {
                    l.n.remove(paramFromServiceMsg.getUin());
                    l.a(paramFromServiceMsg.getUin(), true);
                    QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
                    break;
                  }
                  QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
                  break;
                  label1004:
                  localObject1 = paramFromServiceMsg.getServiceCmd();
                  break label132;
                  label1013:
                  i.a(true, paramFromServiceMsg.getUin(), paramInt, (String)localObject1, 1, l.this.a.n().l, l.this.a.n().m);
                  break label224;
                  localObject1 = l2 + NetConnInfoCenter.getSignalStrengthsLog();
                  break label342;
                  label1080:
                  QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd() + " len:" + paramInt + " costTime:" + (String)localObject1);
                  break label445;
                  if (paramFromServiceMsg.getResultCode() != 1000)
                  {
                    QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
                    break label445;
                  }
                  QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + paramFromServiceMsg.getServiceCmd().hashCode() + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString());
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              l.this.a.c();
              QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
            }
            if (paramInt == -10008)
            {
              if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
              {
                localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
                l.this.q.reSendMsg(localToServiceMsg);
                return;
              }
              QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
            }
          }
        }
        if (l.o().get()) {
          QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
        }
        for (;;)
        {
          l.this.q.getAccountCenter().g.a();
          paramFromServiceMsg = l.this.q.netConnICenter;
          NetConnInfoCenter.impl.checkRecordTime();
          l.this.j();
          return;
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
          {
            l.this.a(paramFromServiceMsg, localToServiceMsg);
          }
          else
          {
            l.o.set(0);
            l.this.q.getSsoRespHandler().c(localToServiceMsg, paramFromServiceMsg);
          }
        }
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      l.this.a.n().a(a(paramInt1));
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(l.e(l.this)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(l.this.a.n().l + ":" + l.this.a.n().m);
      if (QLog.isDevelopLevel()) {
        QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
      MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
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
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(l.this.q.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      l.this.q.addRespToQuque(null, localFromServiceMsg);
      l.o().set(true);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      Object localObject4 = null;
      try
      {
        a.a(paramInt1);
        if (paramObject == null) {
          break label389;
        }
        if (l.D != -1) {
          l.D = -1;
        }
        l.this.B = System.currentTimeMillis();
        l.C = l.this.B;
        localObject1 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject1).getWupBuffer().length;
          if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
            break label390;
          }
          ((FromServiceMsg)localObject1).setRequestSsoSeq(((FromServiceMsg)localObject1).getAppSeq());
          if (((FromServiceMsg)localObject1).isSuccess()) {
            break label390;
          }
          QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
          Object localObject2 = (ArrayList)l.g(l.this).remove(Integer.valueOf(((FromServiceMsg)localObject1).getRequestSsoSeq()));
          if (((FromServiceMsg)localObject1).getBusinessFailCode() == -10107)
          {
            if (l.this.l) {
              l.this.l = false;
            }
            QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject2).toArray()) + "resend, close merge.");
          }
          if (localObject2 == null) {
            break label390;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramInt1 = ((Integer)((Iterator)localObject2).next()).intValue();
            localObject4 = l.this.q.sender.a(paramInt1);
            if (localObject4 != null) {
              l.a(l.this, (ToServiceMsg)localObject4);
            }
          }
          if (!localThrowable1.toString().contains("InvalidProtocol")) {
            break label340;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject1 = localException;
        }
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      label340:
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + localThrowable1.toString(), localThrowable1);
      }
      for (;;)
      {
        label389:
        return;
        label390:
        int i;
        if ((((FromServiceMsg)localObject1).getFlag() & 0x1) != 0)
        {
          localObject3 = ((FromServiceMsg)localObject1).getWupBuffer();
          i = localObject3.length;
          if (i > 4) {
            i = (localObject3[0] & 0xFF) << 24 | 0x0 | (localObject3[1] & 0xFF) << 16 | (localObject3[2] & 0xFF) << 8 | localObject3[3] & 0xFF;
          }
        }
        else
        {
          try
          {
            localObject4 = new byte[i];
            System.arraycopy(localObject3, 4, localObject4, 0, i - 4);
            localObject4 = com.tencent.qphone.base.util.f.b((byte[])localObject4);
            Object localObject5 = new byte[localObject4.length + 4];
            localObject5[0] = ((byte)(localObject4.length + 4 >> 24 & 0xFF));
            localObject5[1] = ((byte)(localObject4.length + 4 >> 16 & 0xFF));
            localObject5[2] = ((byte)(localObject4.length + 4 >> 8 & 0xFF));
            localObject5[3] = ((byte)(localObject4.length + 4 & 0xFF));
            System.arraycopy(localObject4, 0, localObject5, 4, localObject4.length);
            ((FromServiceMsg)localObject1).putWupBuffer((byte[])localObject5);
            if ((!((FromServiceMsg)localObject1).isSuccess()) || (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))) {
              break label975;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject1).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject1).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject1).getWupBuffer().length);
            localObject3 = new SSOLoginMerge.BusiBuffData();
            localObject4 = new byte[((FromServiceMsg)localObject1).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject1).getWupBuffer(), 4, localObject4, 0, localObject4.length);
            localObject3 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject3).mergeFrom((byte[])localObject4)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject3).next();
              localObject5 = new FromServiceMsg();
              ((FromServiceMsg)localObject5).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject4).ServiceCmd.get());
              ((FromServiceMsg)localObject5).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject4).SeqNo.get());
              ((FromServiceMsg)localObject5).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject4).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject5).setAppSeq(((FromServiceMsg)localObject5).getRequestSsoSeq());
              ((FromServiceMsg)localObject5).setMsgSuccess();
              ((FromServiceMsg)localObject5).setUin(((FromServiceMsg)localObject1).getUin());
              ((FromServiceMsg)localObject5).putWupBuffer(l.b(((FromServiceMsg)localObject5).getWupBuffer()));
              a((FromServiceMsg)localObject5, ((FromServiceMsg)localObject5).getWupBuffer().length);
            }
            if (((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge")) {
              break label960;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "uncompress data failed " + localException);
            }
            if (!((FromServiceMsg)localObject1).getServiceCmd().equals("SSO.LoginMerge"))
            {
              onInvalidData(-7, localObject3.length);
              return;
            }
            a(-7, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
            return;
          }
        }
      }
      onInvalidData(-6, localObject3.length);
      return;
      label960:
      a(-6, localObject3.length, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      return;
      label975:
      a((FromServiceMsg)localObject1, paramInt2);
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      int j;
      synchronized (l.a(l.this))
      {
        j = l.b(l.this).size();
        i = j;
        if (j > l.this.d) {
          i = l.this.d;
        }
        long l = SystemClock.elapsedRealtime();
        if (l.this.w >= l)
        {
          l.c(l.this).postDelayed(l.this.c, l.this.g);
          if ((!l.d(l.this)) && (l.b(l.this).size() - l.this.e > 0))
          {
            l.c(l.this).postDelayed(l.this.c, l.this.g);
            l.a(l.this, true);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + l.b(l.this).size() + ", " + i + " sso package should be merged.");
          }
          if (i <= 0) {
            break label1451;
          }
          j = i;
        }
        try
        {
          if (i > l.b(l.this).size()) {
            j = l.b(l.this).size();
          }
          if (j != 1) {
            break label348;
          }
          ??? = (ToServiceMsg)l.b(l.this).peek();
          if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= l.this.i)) {
            break label348;
          }
          l locall = l.this;
          locall.f -= ((ToServiceMsg)???).getWupBuffer().length;
          l.a(l.this, (ToServiceMsg)l.b(l.this).poll());
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            synchronized (l.a(l.this))
            {
              if ((l.this.f >= l.this.e) && (!l.d(l.this)))
              {
                l.a(l.this, true);
                l.c(l.this).post(l.this.c);
                if (m > 0)
                {
                  l.g(l.this).put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localArrayList);
                  l.h(l.this).put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                  localObject5 = ((SSOLoginMerge.BusiBuffData)localObject5).toByteArray();
                  localObject6 = new ByteArrayOutputStream();
                  com.tencent.qphone.base.util.f.a((byte[])localObject5, (OutputStream)localObject6);
                  localObject6 = l.b(((ByteArrayOutputStream)localObject6).toByteArray());
                  ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                  }
                }
                if (??? == null) {
                  continue;
                }
                ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
                l.a(l.this, (ToServiceMsg)???);
                return;
                localException = localException;
                QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
                l.this.l = false;
                if (l.b(l.this).size() <= 0) {
                  continue;
                }
                localToServiceMsg1 = (ToServiceMsg)l.b(l.this).poll();
                if (localToServiceMsg1 == null) {
                  continue;
                }
                l.a(l.this, localToServiceMsg1);
                continue;
                ??? = l.this;
                ((l)???).f -= localToServiceMsg2.getWupBuffer().length;
                if (j == 0)
                {
                  localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                  localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                  localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                  localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                  if (localToServiceMsg2.getWupBuffer().length < 4)
                  {
                    localBusiBuffItem.BusiBuffLen.set(l.b(localToServiceMsg2.getWupBuffer()).length);
                    if (localToServiceMsg2.getWupBuffer().length < 4) {
                      continue;
                    }
                    ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                    System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                    localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                    localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                    ((SSOLoginMerge.BusiBuffData)localObject5).BusiBuffVec.add(localBusiBuffItem);
                    localArrayList.add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                    ((ArrayList)localObject6).add(localToServiceMsg2);
                    l.f(l.this).put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                    localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(l.n().incrementAndGet()));
                    if (localToServiceMsg2.getTimeout() != -1L) {
                      continue;
                    }
                    localToServiceMsg2.setTimeout(30000L);
                    ??? = l.this.q.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                    localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                    i.a(true, l.e(l.this), localToServiceMsg2.getWupBuffer().length, localToServiceMsg2.getServiceCmd(), 0, l.this.a.n().l, l.this.a.n().m);
                    break;
                  }
                }
                else
                {
                  if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                    continue;
                  }
                  l.b(l.this).a(localToServiceMsg2);
                  ??? = l.this;
                  ((l)???).f += localToServiceMsg2.getWupBuffer().length;
                  m = i;
                  continue;
                }
                localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
                continue;
                ??? = localToServiceMsg2.getWupBuffer();
                continue;
                ??? = l.this.q.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                continue;
              }
              if ((!l.d(l.this)) && (l.b(l.this).size() >= l.this.d))
              {
                l.a(l.this, true);
                l.c(l.this).post(l.this.c);
              }
            }
            if ((!l.d(l.this)) && (!l.b(l.this).isEmpty()))
            {
              l.c(l.this).postDelayed(l.this.c, l.this.g);
              l.a(l.this, true);
            }
          }
        }
        l.a(l.this, false);
      }
      label348:
      ??? = new ToServiceMsg("MSF SSOPackageMerge", l.e(l.this), "SSO.LoginMerge");
      ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
      ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
      if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
        ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
      }
      ((ToServiceMsg)???).setTimeout(30000L);
      ((ToServiceMsg)???).setNeedCallback(false);
      ArrayList localArrayList = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject5 = new SSOLoginMerge.BusiBuffData();
      int i = j;
      if (i > l.b(l.this).size()) {
        i = l.b(l.this).size();
      }
      for (;;)
      {
        int m = i;
        ToServiceMsg localToServiceMsg2;
        if (j < i)
        {
          localToServiceMsg2 = (ToServiceMsg)l.b(l.this).poll();
          if (localToServiceMsg2 == null) {
            break label1445;
          }
          k += localToServiceMsg2.getWupBuffer().length;
          if ((k < l.this.e) || (j == 0)) {
            break label866;
          }
          l.b(l.this).a(localToServiceMsg2);
          m = j;
        }
        ToServiceMsg localToServiceMsg1;
        label866:
        SSOLoginMerge.BusiBuffItem localBusiBuffItem;
        label1445:
        break label1473;
        break label1466;
        label1451:
        localObject5 = null;
        localObject6 = null;
        localArrayList = null;
        Object localObject3 = null;
        break;
        label1466:
        int k = 0;
        j = 0;
        continue;
        label1473:
        j += 1;
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
      int m;
      Object localObject2;
      long l1;
      long l2;
      label141:
      label431:
      boolean bool1;
      for (;;)
      {
        int k;
        int i;
        Object localObject1;
        try
        {
          localToServiceMsg = (ToServiceMsg)l.i(l.this).k();
          if (localToServiceMsg != null)
          {
            try
            {
              String str = localToServiceMsg.getServiceCmd();
              m = str.indexOf("#");
              if (m == -1) {
                break label1794;
              }
              localObject2 = str.substring(m + 1, str.length()) + "_new";
              str = str.substring(0, m);
              l1 = ((Long)localToServiceMsg.getAttribute("__timestamp_addSendQueue", Long.valueOf(0L))).longValue();
              l2 = System.currentTimeMillis();
              l.this.q.configManager.a(localToServiceMsg, l2);
              if (localToServiceMsg.getWupBuffer() == null) {
                break label760;
              }
              k = 0;
              if (!NetConnInfoCenterImpl.isWifiConn()) {
                break label610;
              }
              i = 1;
              if (i != l.x)
              {
                l.x = i;
                l.g();
                QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead network type changed");
              }
              if (com.tencent.mobileqq.msf.core.auth.d.d.containsKey(localToServiceMsg.getUin()))
              {
                l.this.q.getAccountCenter().q(localToServiceMsg.getUin());
                com.tencent.mobileqq.msf.core.auth.d.d.remove(localToServiceMsg.getUin());
                QLog.d("MSF.C.NetConnTag", 1, "ReloadKey for uin:" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()) + " while ssoSeq=" + localToServiceMsg.getRequestSsoSeq());
              }
              if (!l.this.a.b())
              {
                l.g();
                QLog.d("MSF.C.NetConnTag", 1, "resetUserSimpleHead not connect network");
              }
              byte[] arrayOfByte1 = CodecWarpper.encodeRequest(localToServiceMsg.getRequestSsoSeq(), k.d(), k.f(), k.g(), "", str, l.this.b(), localToServiceMsg.getAppId(), l.this.q.getMsfAppid(), localToServiceMsg.getUin(), (byte)0, i, localToServiceMsg.getWupBuffer(), false);
              QLog.d("MSF.C.NetConnTag", 1, "pa ok: " + localToServiceMsg.getRequestSsoSeq());
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
              l.i(l.this).remove(localToServiceMsg);
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
          l.this.q.getAccountCenter().m(((FromServiceMsg)localObject1).getUin());
          ((FromServiceMsg)localObject1).setBusinessFail(2012, ((FromServiceMsg)localObject1).getBusinessFailMsg());
          bool1 = false;
          if (localToServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {
            bool1 = ((Boolean)localToServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();
          }
          ((FromServiceMsg)localObject1).addAttribute("_attr_sameDevice", Boolean.valueOf(bool1));
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject1);
          l.this.q.addRespToQuque(null, (FromServiceMsg)localObject1);
          l.this.a.a(com.tencent.qphone.base.a.a);
        }
        catch (Exception localException1)
        {
          int n;
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
          label610:
          if (NetConnInfoCenterImpl.isMobileConn())
          {
            n = NetConnInfoCenterImpl.getMobileNetworkType() + 100;
            m = n;
            if (n <= 254) {
              break label1800;
            }
            n = 254;
            m = n;
            if (!QLog.isColorLevel()) {
              break label1800;
            }
            QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
            m = n;
            break label1800;
          }
          if (this.a != 0L)
          {
            i = k;
            if (l2 - this.a <= 60000L) {}
          }
          else
          {
            this.a = l2;
            try
            {
              NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
              i = k;
            }
            catch (Exception localException2)
            {
              QLog.d("MSF.C.NetConnTag", 1, "checkConnInfo " + localException2);
              i = k;
            }
            continue;
            label760:
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
          break label431;
        }
        l2 = System.currentTimeMillis();
        if (l2 - l1 > localToServiceMsg.getTimeout())
        {
          if (!QLog.isColorLevel()) {
            break label431;
          }
          QLog.d("MSF.C.NetConnTag", 2, localToServiceMsg + " is already sendTimeout,break.");
          break label431;
        }
        if ((l.C != 0L) && (l2 - l.C > com.tencent.mobileqq.msf.core.a.a.s()) && (l.this.a.b()))
        {
          if (l.C >= l.this.a.n().c())
          {
            l.C = 0L;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "lastMessageTimeTooLong Close socket now. System.currentTimeMillis() - lastRecvSsoRespTime :" + (System.currentTimeMillis() - l.C) + " getNetIdleTimeInterval()" + com.tencent.mobileqq.msf.core.a.a.s());
            }
            l.this.a(com.tencent.qphone.base.a.o);
          }
        }
        else if ((l.C != 0L) && (l2 - l.C > 360000L) && (l.this.a.b()) && (l.C >= l.this.a.n().c()) && (!l.this.y.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "no receive data for 5 minutes, start fast net detect now.");
          }
          l.j(l.this);
        }
        boolean bool2;
        try
        {
          localToServiceMsg.addAttribute("__timestamp_msf2net_boot", Long.valueOf(SystemClock.elapsedRealtime()));
          localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(0L));
          localToServiceMsg.addAttribute("_tag_socket", l.r);
          localToServiceMsg.addAttribute("_tag_localsocket", l.s);
          bool2 = l.this.a.a(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), localThrowable2, (String)localObject2, localToServiceMsg.getMsfCommand(), localToServiceMsg.getUin(), localToServiceMsg.getRequestSsoSeq(), arrayOfByte2, localToServiceMsg);
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
            l.C = 0L;
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
          if ((localToServiceMsg.getUin() != null) && (localToServiceMsg.getUin().length() > 4) && (!localToServiceMsg.getServiceCmd().startsWith("login.")) && (!localToServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (!localToServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) && (!localToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) && (!localToServiceMsg.getServiceCmd().equals("account.requestrebindmblwtLogin_emp")) && (!localToServiceMsg.getServiceCmd().equals("account.requestverifywtlogin_emp")) && (!localToServiceMsg.getServiceCmd().equals("connauthsvr.get_app_info_emp")) && (!localToServiceMsg.getServiceCmd().equals("connauthsvr.sdk_auth_api_emp")) && (!localToServiceMsg.getServiceCmd().equals("connauthsvr.get_auth_api_list_emp")) && (!l.N.contains(localToServiceMsg.getUin())))
          {
            if (l.n.get(localToServiceMsg.getUin()) == null)
            {
              ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
              l.n.put(localToServiceMsg.getUin(), localConcurrentLinkedQueue);
            }
            ((ConcurrentLinkedQueue)l.n.get(localToServiceMsg.getUin())).offer(Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
            QLog.d("MSF.C.NetConnTag", 1, "send Packet addQueue, ssoSeq=" + localToServiceMsg.getRequestSsoSeq() + ", uin=" + MsfSdkUtils.getShortUin(localToServiceMsg.getUin()));
          }
          localToServiceMsg.addAttribute("__timestamp_msf2net", Long.valueOf(System.currentTimeMillis()));
          if (localToServiceMsg.getServiceCmd().startsWith("SharpSvr.c2s")) {
            l.u = SystemClock.elapsedRealtime();
          }
          bool1 = bool2;
        }
        if (l.this.J.get())
        {
          bool1 = bool2;
          if (l.this.I == -1)
          {
            l.this.I = localToServiceMsg.getRequestSsoSeq();
            QLog.d("MSF.C.NetConnTag", 1, "set afterReloadD2SendSeq " + l.this.I);
            bool1 = bool2;
            continue;
            label1794:
            localObject2 = null;
            break;
            label1800:
            int j = (byte)m;
            break label141;
            bool1 = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.l
 * JD-Core Version:    0.7.0.1
 */