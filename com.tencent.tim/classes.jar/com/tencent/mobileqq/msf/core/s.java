package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.report.a;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingDeque;

public class s
{
  private static b a = null;
  private static c b = null;
  private static boolean c = true;
  private static boolean d = true;
  private static d e = null;
  
  public static void a() {}
  
  public static void b()
  {
    if ((c) || (d))
    {
      if (b == null) {
        b = new c();
      }
      Handler localHandler = y.b();
      localHandler.removeCallbacks(b);
      localHandler.postDelayed(b, 5000L);
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, Collection paramCollection, int paramInt)
  {
    String str;
    if ((paramCollection != null) && (paramCollection.size() > 0) && (paramStringBuilder != null)) {
      if (paramInt == 1) {
        str = "  ";
      }
    }
    for (;;)
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        if (!paramCollection.hasNext()) {
          break label238;
        }
        Object localObject = paramCollection.next();
        if ((localObject instanceof ToServiceMsg))
        {
          localObject = (ToServiceMsg)localObject;
          if (localObject == null) {
            continue;
          }
          paramStringBuilder.append(str).append(((ToServiceMsg)localObject).getShortStringForLog()).append("\n");
          continue;
          if (paramInt == 2)
          {
            str = "    ";
            break;
          }
          if (paramInt != 3) {
            break label239;
          }
          str = "      ";
          break;
        }
        if ((localObject instanceof FromServiceMsg))
        {
          localObject = (FromServiceMsg)localObject;
          if (localObject != null) {
            paramStringBuilder.append(str).append(((FromServiceMsg)localObject).getShortStringForLog()).append("\n");
          }
        }
        else if ((localObject instanceof MsfMessagePair))
        {
          localObject = (MsfMessagePair)localObject;
          if (localObject != null)
          {
            if (((MsfMessagePair)localObject).toServiceMsg != null) {
              paramStringBuilder.append(str).append(((MsfMessagePair)localObject).toServiceMsg.getShortStringForLog()).append("\n");
            }
            if (((MsfMessagePair)localObject).fromServiceMsg != null) {
              paramStringBuilder.append(str).append(((MsfMessagePair)localObject).fromServiceMsg.getShortStringForLog()).append("\n");
            }
          }
        }
      }
      label238:
      return;
      label239:
      str = "";
    }
  }
  
  public static void c()
  {
    if (e == null) {
      e = new d(null);
    }
    y.b().removeCallbacks(e);
    y.b().postDelayed(e, 60000L);
  }
  
  public static class a
  {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    
    public a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void a()
    {
      this.a = 0;
      this.b = 0;
    }
    
    public boolean a(int paramInt)
    {
      if (this.a == 0) {
        if (paramInt >= this.c) {
          this.a = paramInt;
        }
      }
      for (;;)
      {
        return false;
        if (paramInt >= this.a)
        {
          this.a = paramInt;
          this.b += 1;
          if (this.b >= 40) {
            return true;
          }
        }
        else
        {
          a();
        }
      }
    }
    
    public int b()
    {
      return this.b;
    }
  }
  
  public static class b
    implements Runnable
  {
    public static final int a = 30000;
    private static final String b = "SSOQueueMonitor";
    private final Handler c = y.b();
    private StringBuilder d = new StringBuilder(8096);
    
    private b()
    {
      this.d.ensureCapacity(2048);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   4: iconst_0
      //   5: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   8: aload_0
      //   9: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   12: ldc 49
      //   14: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   20: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   23: getfield 68	com/tencent/mobileqq/msf/core/ak:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   26: invokevirtual 74	java/util/concurrent/ConcurrentHashMap:size	()I
      //   29: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   32: ldc 79
      //   34: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   40: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   43: getfield 82	com/tencent/mobileqq/msf/core/ak:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   46: invokevirtual 74	java/util/concurrent/ConcurrentHashMap:size	()I
      //   49: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   52: ldc 84
      //   54: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   60: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   63: getfield 88	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
      //   66: invokevirtual 91	java/util/concurrent/LinkedBlockingDeque:size	()I
      //   69: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   72: ldc 93
      //   74: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   80: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   83: getfield 96	com/tencent/mobileqq/msf/core/ak:h	Ljava/util/concurrent/LinkedBlockingDeque;
      //   86: invokevirtual 91	java/util/concurrent/LinkedBlockingDeque:size	()I
      //   89: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   92: ldc 98
      //   94: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   100: getfield 102	com/tencent/mobileqq/msf/core/MsfCore:msfMessagePairs	Ljava/util/concurrent/LinkedBlockingQueue;
      //   103: invokevirtual 105	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   106: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   109: ldc 107
      //   111: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: pop
      //   115: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   118: ifeq +24 -> 142
      //   121: ldc 15
      //   123: iconst_2
      //   124: aload_0
      //   125: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   128: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   134: aload_0
      //   135: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   138: iconst_0
      //   139: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   142: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   145: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   148: getfield 68	com/tencent/mobileqq/msf/core/ak:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   151: invokevirtual 74	java/util/concurrent/ConcurrentHashMap:size	()I
      //   154: ifle +38 -> 192
      //   157: aload_0
      //   158: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   161: ldc 122
      //   163: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: ldc 107
      //   168: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   171: pop
      //   172: aload_0
      //   173: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   176: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   179: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   182: getfield 68	com/tencent/mobileqq/msf/core/ak:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   185: invokevirtual 126	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
      //   188: iconst_2
      //   189: invokestatic 129	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/StringBuilder;Ljava/util/Collection;I)V
      //   192: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   195: ifeq +24 -> 219
      //   198: ldc 15
      //   200: iconst_2
      //   201: aload_0
      //   202: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   205: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   208: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   211: aload_0
      //   212: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   215: iconst_0
      //   216: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   219: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   222: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   225: getfield 82	com/tencent/mobileqq/msf/core/ak:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   228: invokevirtual 74	java/util/concurrent/ConcurrentHashMap:size	()I
      //   231: ifle +170 -> 401
      //   234: aload_0
      //   235: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   238: ldc 131
      //   240: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   243: ldc 107
      //   245: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   248: pop
      //   249: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   252: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   255: getfield 82	com/tencent/mobileqq/msf/core/ak:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   258: invokevirtual 126	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
      //   261: astore_1
      //   262: aload_1
      //   263: ifnull +138 -> 401
      //   266: aload_1
      //   267: invokeinterface 134 1 0
      //   272: ifle +129 -> 401
      //   275: aload_1
      //   276: invokeinterface 138 1 0
      //   281: astore_1
      //   282: aload_1
      //   283: invokeinterface 143 1 0
      //   288: ifeq +113 -> 401
      //   291: aload_1
      //   292: invokeinterface 147 1 0
      //   297: astore_2
      //   298: aload_2
      //   299: instanceof 133
      //   302: ifeq +25 -> 327
      //   305: aload_0
      //   306: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   309: aload_2
      //   310: checkcast 133	java/util/Collection
      //   313: iconst_2
      //   314: invokestatic 129	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/StringBuilder;Ljava/util/Collection;I)V
      //   317: aload_0
      //   318: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   321: ldc 107
      //   323: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: pop
      //   327: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   330: ifeq -48 -> 282
      //   333: ldc 15
      //   335: iconst_2
      //   336: aload_0
      //   337: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   340: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   343: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   346: aload_0
      //   347: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   350: iconst_0
      //   351: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   354: goto -72 -> 282
      //   357: astore_1
      //   358: ldc 15
      //   360: iconst_2
      //   361: aload_1
      //   362: invokevirtual 150	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   365: aload_1
      //   366: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   369: aload_0
      //   370: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   373: ifnull +27 -> 400
      //   376: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   379: ifnull +21 -> 400
      //   382: aload_0
      //   383: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   386: astore_1
      //   387: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   390: astore_2
      //   391: aload_1
      //   392: aload_2
      //   393: ldc2_w 157
      //   396: invokevirtual 164	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
      //   399: pop
      //   400: return
      //   401: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   404: ifeq +24 -> 428
      //   407: ldc 15
      //   409: iconst_2
      //   410: aload_0
      //   411: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   414: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   417: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   420: aload_0
      //   421: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   424: iconst_0
      //   425: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   428: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   431: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   434: getfield 88	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
      //   437: invokevirtual 91	java/util/concurrent/LinkedBlockingDeque:size	()I
      //   440: ifle +35 -> 475
      //   443: aload_0
      //   444: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   447: ldc 166
      //   449: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   452: ldc 107
      //   454: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   457: pop
      //   458: aload_0
      //   459: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   462: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   465: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   468: getfield 88	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
      //   471: iconst_2
      //   472: invokestatic 129	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/StringBuilder;Ljava/util/Collection;I)V
      //   475: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   478: ifeq +24 -> 502
      //   481: ldc 15
      //   483: iconst_2
      //   484: aload_0
      //   485: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   488: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   491: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   494: aload_0
      //   495: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   498: iconst_0
      //   499: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   502: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   505: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   508: getfield 96	com/tencent/mobileqq/msf/core/ak:h	Ljava/util/concurrent/LinkedBlockingDeque;
      //   511: invokevirtual 91	java/util/concurrent/LinkedBlockingDeque:size	()I
      //   514: ifle +35 -> 549
      //   517: aload_0
      //   518: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   521: ldc 168
      //   523: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   526: ldc 107
      //   528: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   531: pop
      //   532: aload_0
      //   533: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   536: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   539: getfield 63	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   542: getfield 96	com/tencent/mobileqq/msf/core/ak:h	Ljava/util/concurrent/LinkedBlockingDeque;
      //   545: iconst_2
      //   546: invokestatic 129	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/StringBuilder;Ljava/util/Collection;I)V
      //   549: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   552: ifeq +24 -> 576
      //   555: ldc 15
      //   557: iconst_2
      //   558: aload_0
      //   559: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   562: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   565: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   568: aload_0
      //   569: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   572: iconst_0
      //   573: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   576: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   579: getfield 102	com/tencent/mobileqq/msf/core/MsfCore:msfMessagePairs	Ljava/util/concurrent/LinkedBlockingQueue;
      //   582: invokevirtual 105	java/util/concurrent/LinkedBlockingQueue:size	()I
      //   585: ifle +32 -> 617
      //   588: aload_0
      //   589: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   592: ldc 170
      //   594: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   597: ldc 107
      //   599: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   602: pop
      //   603: aload_0
      //   604: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   607: getstatic 59	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   610: getfield 102	com/tencent/mobileqq/msf/core/MsfCore:msfMessagePairs	Ljava/util/concurrent/LinkedBlockingQueue;
      //   613: iconst_2
      //   614: invokestatic 129	com/tencent/mobileqq/msf/core/s:a	(Ljava/lang/StringBuilder;Ljava/util/Collection;I)V
      //   617: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   620: ifeq +24 -> 644
      //   623: ldc 15
      //   625: iconst_2
      //   626: aload_0
      //   627: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   630: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   633: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   636: aload_0
      //   637: getfield 37	com/tencent/mobileqq/msf/core/s$b:d	Ljava/lang/StringBuilder;
      //   640: iconst_0
      //   641: invokevirtual 47	java/lang/StringBuilder:setLength	(I)V
      //   644: aload_0
      //   645: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   648: ifnull -248 -> 400
      //   651: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   654: ifnull -254 -> 400
      //   657: aload_0
      //   658: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   661: astore_1
      //   662: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   665: astore_2
      //   666: goto -275 -> 391
      //   669: astore_1
      //   670: aload_0
      //   671: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   674: ifnull +23 -> 697
      //   677: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   680: ifnull +17 -> 697
      //   683: aload_0
      //   684: getfield 30	com/tencent/mobileqq/msf/core/s$b:c	Landroid/os/Handler;
      //   687: invokestatic 156	com/tencent/mobileqq/msf/core/s:d	()Lcom/tencent/mobileqq/msf/core/s$b;
      //   690: ldc2_w 157
      //   693: invokevirtual 164	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
      //   696: pop
      //   697: aload_1
      //   698: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	699	0	this	b
      //   261	31	1	localObject1	Object
      //   357	9	1	localThrowable	java.lang.Throwable
      //   386	276	1	localHandler	Handler
      //   669	29	1	localObject2	Object
      //   297	369	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   0	142	357	java/lang/Throwable
      //   142	192	357	java/lang/Throwable
      //   192	219	357	java/lang/Throwable
      //   219	262	357	java/lang/Throwable
      //   266	282	357	java/lang/Throwable
      //   282	327	357	java/lang/Throwable
      //   327	354	357	java/lang/Throwable
      //   401	428	357	java/lang/Throwable
      //   428	475	357	java/lang/Throwable
      //   475	502	357	java/lang/Throwable
      //   502	549	357	java/lang/Throwable
      //   549	576	357	java/lang/Throwable
      //   576	617	357	java/lang/Throwable
      //   617	644	357	java/lang/Throwable
      //   0	142	669	finally
      //   142	192	669	finally
      //   192	219	669	finally
      //   219	262	669	finally
      //   266	282	669	finally
      //   282	327	669	finally
      //   327	354	669	finally
      //   358	369	669	finally
      //   401	428	669	finally
      //   428	475	669	finally
      //   475	502	669	finally
      //   502	549	669	finally
      //   549	576	669	finally
      //   576	617	669	finally
      //   617	644	669	finally
    }
  }
  
  public static class c
    implements Runnable
  {
    public static final int a = 5000;
    private static final String b = "SocketReaderOldMonitor";
    
    public void run()
    {
      try
      {
        int i = MsfSdkUtils.getThreadCounts("MsfCoreSocketReaderOld");
        Properties localProperties;
        if ((i >= 5) && (s.e()))
        {
          s.a(false);
          QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
          localProperties = new Properties();
          localProperties.setProperty("count", String.valueOf(i));
          localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.SocketReaderMultiThreadException", localProperties);
          a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader5多线程异常");
        }
        while (QLog.isColorLevel())
        {
          QLog.d("SocketReaderOldMonitor", 1, "SocketReader current " + i);
          return;
          if ((i >= 3) && (s.f()))
          {
            s.b(false);
            QLog.d("SocketReaderOldMonitor", 1, "SocketReader多线程异常 " + i);
            localProperties = new Properties();
            localProperties.setProperty("count", String.valueOf(i));
            localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
            com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.SocketReaderMultiThreadException", localProperties);
            a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader3多线程异常");
          }
        }
        return;
      }
      catch (Exception localException)
      {
        s.b(false);
        s.a(false);
        localException.printStackTrace();
      }
    }
  }
  
  static class d
    implements Runnable
  {
    private static final String a = "WorkerThreadMonitor";
    private static final long d = 14400000L;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private boolean b = false;
    private final s.a c = new s.a(40);
    private long h = 0L;
    private long i = 0L;
    
    public void run()
    {
      int k = 0;
      Object localObject4 = "";
      for (;;)
      {
        try
        {
          boolean bool = this.c.a(MsfCore.sCore.sender.g.size());
          long l1 = MsfCore.sCore.sender.g.size();
          Object localObject1 = localObject4;
          j = k;
          if (bool)
          {
            localObject1 = localObject4;
            j = k;
            if (!this.b)
            {
              this.b = true;
              this.c.a();
              j = 1;
              QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by sender queue increasing ,queue size", Long.valueOf(l1) });
              localObject1 = "MsfCoreMsgSender";
            }
          }
          this.h = MsfCore.sCore.sender.a();
          long l2 = Math.abs(SystemClock.uptimeMillis() - this.h);
          long l3 = MsfCore.sCore.sender.b();
          localObject4 = localObject1;
          k = j;
          if (l2 >= 14400000L)
          {
            localObject4 = localObject1;
            k = j;
            if (!this.b)
            {
              localObject4 = localObject1;
              k = j;
              if (l3 >= 100L)
              {
                this.b = true;
                k = 2;
                QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by not send data for one hour,interval = ", Long.valueOf(l2) });
                localObject4 = "MsfCoreMsgSender";
                MsfCore.sCore.sender.c();
              }
            }
          }
          this.i = MsfCore.sCore.sender.b.l().f();
          long l4 = Math.abs(SystemClock.uptimeMillis() - this.i);
          if ((l4 < 14400000L) || (this.b)) {
            break label727;
          }
          this.b = true;
          k = 3;
          QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF by not receive data for one hour,interval =", Long.valueOf(l4) });
          localObject1 = "MsfCoreSocketReaderNew";
          QLog.d("WorkerThreadMonitor", 1, new Object[] { "Kill MSF check result[ senderSize:", Long.valueOf(l1), ",sendInterval:", Long.valueOf(l2), ",receiveInterval=", Long.valueOf(l4), ",addCmdCount=", Long.valueOf(l3) });
          if (this.b)
          {
            String str = MsfSdkUtils.getThreadStackString((String)localObject1);
            localObject4 = MsfCore.sCore.getAccountCenter().i();
            HashMap localHashMap = new HashMap();
            localHashMap.put("thread", localObject1);
            localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
            if (localObject4 == null) {
              continue;
            }
            localHashMap.put("uin", localObject4);
            if (str == null) {
              continue;
            }
            localObject4 = str;
            localHashMap.put("stack", localObject4);
            localHashMap.put("killReason", String.valueOf(k));
            localHashMap.put("senderSize", String.valueOf(l1));
            localHashMap.put("sendInterval", String.valueOf(l2));
            localHashMap.put("receiveInterval", String.valueOf(l4));
            localHashMap.put("addCmdCount", String.valueOf(l3));
            if (MsfService.getCore().mtaReporter != null) {
              MsfService.getCore().mtaReporter.a("msf_core_EvtMsfThreadHeldKillMSF", localHashMap);
            }
            if (MsfService.getCore().getStatReporter() != null) {
              MsfService.getCore().getStatReporter().a("msf_core_EvtMsfThreadHeldKillMSF", true, 0L, 0L, localHashMap, false, false);
            }
            if (Math.random() > 0.001000000047497451D) {
              continue;
            }
            j = 1;
            if (j != 0) {
              a.a(new com.tencent.mobileqq.msf.sdk.report.b((String)localObject1 + " QueueHeld"), (String)localObject1 + "HeldCatchedException:" + str, str);
            }
            Thread.sleep(10000L);
            Process.killProcess(Process.myPid());
          }
        }
        catch (Exception localException)
        {
          int j;
          localException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("WorkerThreadMonitor", 2, localException.getMessage(), localException);
          continue;
        }
        finally
        {
          s.c();
        }
        return;
        localObject4 = "0000";
        continue;
        localObject4 = "null";
        continue;
        j = 0;
        continue;
        label727:
        Object localObject3 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.s
 * JD-Core Version:    0.7.0.1
 */