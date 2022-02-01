package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class g
{
  public static final String a = "send_mode";
  public static final int b = 0;
  public static final int c = 1;
  public static final String d = "unknown";
  public static final String e = "pcactive";
  public static final String f = "quicksend";
  public static final int g = 0;
  public static final int h = -1;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final String o = "light_sender_type";
  public static final int p = 0;
  public static final int q = 1;
  private static final String r = "LightSender";
  private MsfCore s;
  private LinkedBlockingQueue t = new LinkedBlockingQueue();
  private ConcurrentLinkedQueue u = new ConcurrentLinkedQueue();
  private long v = 0L;
  private ThreadPoolExecutor w;
  private int x = com.tencent.mobileqq.msf.core.a.a.ac();
  private int y = com.tencent.mobileqq.msf.core.a.a.ac();
  private int z = 60;
  
  public g(MsfCore paramMsfCore, Context paramContext)
  {
    this.s = paramMsfCore;
    CodecWarpper.nativeSetKsid(paramMsfCore.getAccountCenter().f());
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.w = new ThreadPoolExecutor(this.x, this.y, this.z, TimeUnit.SECONDS, this.t, new a("LightSender"));
      this.w.allowCoreThreadTimeOut(true);
      return;
    }
    this.w = new ThreadPoolExecutor(1, 1, this.z, TimeUnit.SECONDS, this.t, new a("LightSender"));
  }
  
  private FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte1;
    int i1;
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4) {
        i1 = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
      }
    }
    else
    {
      try
      {
        byte[] arrayOfByte2 = new byte[i1];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i1 - 4);
        arrayOfByte1 = l.b(arrayOfByte2);
        arrayOfByte2 = new byte[arrayOfByte1.length + 4];
        arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
        arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
        arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
        arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
        paramFromServiceMsg.putWupBuffer(arrayOfByte2);
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("LightSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        return null;
      }
    }
    return null;
  }
  
  private CopyOnWriteArrayList a(CopyOnWriteArrayList paramCopyOnWriteArrayList, String paramString)
  {
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return paramCopyOnWriteArrayList;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      d locald = (d)paramCopyOnWriteArrayList.next();
      if ((locald != null) && (paramString.equals(locald.j))) {
        localCopyOnWriteArrayList.add(0, locald);
      } else {
        localCopyOnWriteArrayList.add(locald);
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, f paramf)
  {
    paramf.f = paramInt;
    if (paramFromServiceMsg == null)
    {
      FromServiceMsg localFromServiceMsg = w.a(paramToServiceMsg);
      if (localFromServiceMsg != null)
      {
        localFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.s.getSsoRespHandler().a(paramToServiceMsg, localFromServiceMsg);
      }
    }
    for (;;)
    {
      com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
      return;
      this.s.getSsoRespHandler().a(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.net.b paramb, String paramString1, int paramInt, f paramf, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    if (NetConnInfoCenter.isWifiConn()) {
      if (paramb.a()) {
        localObject1 = this.s.getSsoListManager().a(c.a.a("Quic", "Wifi", "Ipv4"), true);
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramBoolean) {
        localObject2 = a((CopyOnWriteArrayList)localObject1, paramString2);
      }
      if (localObject2 == null) {
        break label335;
      }
      paramString2 = ((CopyOnWriteArrayList)localObject2).iterator();
      long l1;
      do
      {
        if (!paramString2.hasNext()) {
          break;
        }
        localObject1 = (d)paramString2.next();
        paramb.a(((d)localObject1).g());
        l1 = SystemClock.elapsedRealtime();
        paramBoolean = paramb.a(((d)localObject1).c(), ((d)localObject1).f(), paramString1, paramf);
        paramf.k += 1;
      } while (!paramBoolean);
      paramf.j = (SystemClock.elapsedRealtime() - l1);
      return true;
      localObject2 = this.s.getSsoListManager().a(c.a.a("Http", "Wifi", "Ipv4"), true);
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.s.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
      if ((paramf.l) && (localCopyOnWriteArrayList != null))
      {
        localObject1 = localCopyOnWriteArrayList;
        if (localCopyOnWriteArrayList.size() > 0) {}
      }
      else
      {
        localObject1 = localObject2;
        continue;
        if (paramb.a()) {
          localObject1 = this.s.getSsoListManager().a(c.a.a("Quic", "Mobile", "Ipv4"), true);
        } else {
          localObject1 = this.s.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
        }
      }
    }
    QLog.d("LightSender", 1, "LightSender connect all fail ssoseq:" + paramInt);
    return false;
    label335:
    QLog.d("LightSender", 1, "LightSender ssolist is empty ssoseq:" + paramInt);
    return false;
  }
  
  private boolean c()
  {
    return this.t.size() + this.w.getActiveCount() >= this.y;
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightSender", 2, "LightSender, addSendQueue cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
      }
      b localb = new b(paramToServiceMsg);
      this.w.submit(localb);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("LightSender", 1, "submit task failed, cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq(), localException);
    }
  }
  
  private String e(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))) {
      return "pcactive";
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null)) {
      return "quicksend";
    }
    return "unknown";
  }
  
  /* Error */
  private byte[] f(ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 343	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 7
    //   15: aload_1
    //   16: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   19: ifnull +533 -> 552
    //   22: invokestatic 382	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   25: istore_2
    //   26: iload_2
    //   27: ifne +44 -> 71
    //   30: invokestatic 385	java/lang/System:currentTimeMillis	()J
    //   33: lstore 5
    //   35: aload_0
    //   36: getfield 78	com/tencent/mobileqq/msf/core/g:v	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifeq +17 -> 58
    //   44: lload 5
    //   46: aload_0
    //   47: getfield 78	com/tencent/mobileqq/msf/core/g:v	J
    //   50: lsub
    //   51: ldc2_w 386
    //   54: lcmp
    //   55: ifle +16 -> 71
    //   58: aload_0
    //   59: lload 5
    //   61: putfield 78	com/tencent/mobileqq/msf/core/g:v	J
    //   64: invokestatic 393	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   67: iconst_1
    //   68: invokestatic 397	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
    //   71: iconst_0
    //   72: invokestatic 401	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   75: i2b
    //   76: istore_3
    //   77: iconst_0
    //   78: istore 4
    //   80: aload_1
    //   81: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   84: ldc 13
    //   86: invokevirtual 410	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   89: ifeq +20 -> 109
    //   92: aload_1
    //   93: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   96: ldc 13
    //   98: invokevirtual 414	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: checkcast 416	java/lang/Integer
    //   104: invokevirtual 419	java/lang/Integer:intValue	()I
    //   107: istore 4
    //   109: aload_1
    //   110: iload_3
    //   111: invokestatic 424	com/tencent/mobileqq/msf/core/ak:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
    //   114: astore 8
    //   116: aload 8
    //   118: astore 7
    //   120: iload 4
    //   122: iconst_1
    //   123: if_icmpne +260 -> 383
    //   126: sipush 591
    //   129: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   132: if_icmpne +136 -> 268
    //   135: aload_1
    //   136: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   139: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   142: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   145: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   148: ldc_w 435
    //   151: aload 9
    //   153: aconst_null
    //   154: aload_1
    //   155: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   158: aload_0
    //   159: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   162: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   165: aload_1
    //   166: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   169: iconst_0
    //   170: iload_2
    //   171: aload_1
    //   172: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   175: iconst_1
    //   176: invokestatic 448	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   179: areturn
    //   180: astore 8
    //   182: ldc 48
    //   184: iconst_1
    //   185: new 306	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 450
    //   195: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 8
    //   200: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: goto -138 -> 71
    //   212: astore 7
    //   214: aload 7
    //   216: invokevirtual 454	java/lang/Throwable:printStackTrace	()V
    //   219: ldc 48
    //   221: iconst_1
    //   222: new 306	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 456
    //   232: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   239: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: aload 7
    //   247: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: aconst_null
    //   251: areturn
    //   252: astore 8
    //   254: ldc 48
    //   256: iconst_1
    //   257: ldc_w 435
    //   260: aload 8
    //   262: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto -145 -> 120
    //   268: sipush 595
    //   271: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   274: if_icmpeq +12 -> 286
    //   277: sipush 600
    //   280: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   283: if_icmpne +51 -> 334
    //   286: aload_1
    //   287: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   290: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   293: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   296: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   299: ldc_w 435
    //   302: aload 9
    //   304: aconst_null
    //   305: aload_1
    //   306: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   309: aload_0
    //   310: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   313: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   316: aload_1
    //   317: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   320: iconst_0
    //   321: iload_2
    //   322: aload 7
    //   324: aconst_null
    //   325: aload_1
    //   326: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   329: iconst_1
    //   330: invokestatic 459	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[B[BZ)[B
    //   333: areturn
    //   334: aload_1
    //   335: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   338: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   341: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   344: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   347: ldc_w 435
    //   350: aload 9
    //   352: aconst_null
    //   353: aload_1
    //   354: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   357: aload_0
    //   358: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   361: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   364: aload_1
    //   365: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   368: iconst_0
    //   369: iload_2
    //   370: iload_3
    //   371: aload 7
    //   373: aconst_null
    //   374: aload_1
    //   375: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   378: iconst_1
    //   379: invokestatic 462	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[B[BZ)[B
    //   382: areturn
    //   383: sipush 591
    //   386: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   389: if_icmpne +48 -> 437
    //   392: aload_1
    //   393: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   396: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   399: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   402: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   405: ldc_w 435
    //   408: aload 9
    //   410: aconst_null
    //   411: aload_1
    //   412: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   415: aload_0
    //   416: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   419: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   422: aload_1
    //   423: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   426: iconst_0
    //   427: iload_2
    //   428: aload_1
    //   429: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   432: iconst_1
    //   433: invokestatic 448	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
    //   436: areturn
    //   437: sipush 595
    //   440: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   443: if_icmpeq +12 -> 455
    //   446: sipush 600
    //   449: invokestatic 427	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
    //   452: if_icmpne +51 -> 503
    //   455: aload_1
    //   456: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   459: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   462: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   465: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   468: ldc_w 435
    //   471: aload 9
    //   473: aconst_null
    //   474: aload_1
    //   475: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   478: aload_0
    //   479: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   482: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   485: aload_1
    //   486: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   489: iconst_0
    //   490: iload_2
    //   491: aload 7
    //   493: aconst_null
    //   494: aload_1
    //   495: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   498: iconst_1
    //   499: invokestatic 459	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[B[BZ)[B
    //   502: areturn
    //   503: aload_1
    //   504: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   507: invokestatic 429	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
    //   510: invokestatic 431	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
    //   513: invokestatic 433	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
    //   516: ldc_w 435
    //   519: aload 9
    //   521: aconst_null
    //   522: aload_1
    //   523: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   526: aload_0
    //   527: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   530: invokevirtual 441	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   533: aload_1
    //   534: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   537: iconst_0
    //   538: iload_2
    //   539: iload_3
    //   540: aload 7
    //   542: aconst_null
    //   543: aload_1
    //   544: invokevirtual 377	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   547: iconst_1
    //   548: invokestatic 462	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[B[BZ)[B
    //   551: areturn
    //   552: iconst_0
    //   553: newarray byte
    //   555: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	g
    //   0	556	1	paramToServiceMsg	ToServiceMsg
    //   25	514	2	b1	byte
    //   76	464	3	b2	byte
    //   78	46	4	i1	int
    //   33	27	5	l1	long
    //   13	106	7	localObject	Object
    //   212	329	7	localThrowable1	Throwable
    //   114	3	8	arrayOfByte	byte[]
    //   180	19	8	localThrowable2	Throwable
    //   252	9	8	localException	Exception
    //   10	510	9	str	String
    // Exception table:
    //   from	to	target	type
    //   64	71	180	java/lang/Throwable
    //   6	12	212	java/lang/Throwable
    //   15	26	212	java/lang/Throwable
    //   30	58	212	java/lang/Throwable
    //   58	64	212	java/lang/Throwable
    //   71	77	212	java/lang/Throwable
    //   80	109	212	java/lang/Throwable
    //   109	116	212	java/lang/Throwable
    //   126	180	212	java/lang/Throwable
    //   182	209	212	java/lang/Throwable
    //   254	265	212	java/lang/Throwable
    //   268	286	212	java/lang/Throwable
    //   286	334	212	java/lang/Throwable
    //   334	383	212	java/lang/Throwable
    //   383	437	212	java/lang/Throwable
    //   437	455	212	java/lang/Throwable
    //   455	503	212	java/lang/Throwable
    //   503	552	212	java/lang/Throwable
    //   109	116	252	java/lang/Exception
  }
  
  public void a()
  {
    if (!this.t.isEmpty())
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.a != null) && (localb.a.getServiceName().equals("MessageSvc.QueryPullUp"))) {
          localIterator.remove();
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    label123:
    for (boolean bool = false;; bool = false)
    {
      return bool;
      for (;;)
      {
        try
        {
          if (paramToServiceMsg.getAttributes().containsKey("light_sender_type"))
          {
            i1 = ((Integer)paramToServiceMsg.getAttributes().get("light_sender_type")).intValue();
            if ((i1 == 1) && (c()))
            {
              if (!QLog.isColorLevel()) {
                break label123;
              }
              QLog.d("LightSender", 2, "LightSender busy returns, cmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
              break label123;
            }
            d(paramToServiceMsg);
            bool = true;
            break;
          }
        }
        finally {}
        int i1 = 0;
      }
    }
  }
  
  /* Error */
  public boolean a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +4638 -> 4639
    //   4: aload_1
    //   5: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   8: istore 5
    //   10: aload_1
    //   11: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   14: ldc_w 484
    //   17: invokevirtual 410	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +4613 -> 4633
    //   23: aload_1
    //   24: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   27: ldc_w 484
    //   30: invokevirtual 414	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 416	java/lang/Integer
    //   36: invokevirtual 419	java/lang/Integer:intValue	()I
    //   39: istore 4
    //   41: aload_1
    //   42: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   45: ldc_w 486
    //   48: invokevirtual 410	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   51: ifeq +4564 -> 4615
    //   54: aload_1
    //   55: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   58: ldc_w 486
    //   61: invokevirtual 414	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 416	java/lang/Integer
    //   67: invokevirtual 419	java/lang/Integer:intValue	()I
    //   70: istore 7
    //   72: iload 4
    //   74: istore 6
    //   76: iload 5
    //   78: istore 4
    //   80: iload 7
    //   82: istore 5
    //   84: new 214	com/tencent/mobileqq/msf/core/quicksend/f
    //   87: dup
    //   88: invokespecial 487	com/tencent/mobileqq/msf/core/quicksend/f:<init>	()V
    //   91: astore 16
    //   93: aload 16
    //   95: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   98: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   101: aload 16
    //   103: iconst_0
    //   104: putfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   107: aload 16
    //   109: iload_2
    //   110: putfield 304	com/tencent/mobileqq/msf/core/quicksend/f:l	Z
    //   113: new 493	java/util/Random
    //   116: dup
    //   117: invokespecial 494	java/util/Random:<init>	()V
    //   120: bipush 100
    //   122: invokevirtual 498	java/util/Random:nextInt	(I)I
    //   125: iconst_2
    //   126: irem
    //   127: ifne +678 -> 805
    //   130: invokestatic 501	com/tencent/mobileqq/msf/core/a/a:bv	()Z
    //   133: ifeq +672 -> 805
    //   136: iconst_1
    //   137: istore 10
    //   139: iload 10
    //   141: ifne +670 -> 811
    //   144: new 503	com/tencent/mobileqq/msf/core/net/g
    //   147: dup
    //   148: invokespecial 504	com/tencent/mobileqq/msf/core/net/g:<init>	()V
    //   151: astore 14
    //   153: aload_1
    //   154: invokevirtual 343	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   157: astore_3
    //   158: iload_2
    //   159: ifeq +40 -> 199
    //   162: aload_1
    //   163: ldc_w 506
    //   166: iconst_0
    //   167: invokestatic 510	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokevirtual 514	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast 416	java/lang/Integer
    //   176: invokevirtual 419	java/lang/Integer:intValue	()I
    //   179: istore 7
    //   181: aload_1
    //   182: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   185: ldc_w 506
    //   188: iload 7
    //   190: iconst_1
    //   191: iadd
    //   192: invokestatic 510	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 336	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifne +9 -> 211
    //   205: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   208: ifeq +627 -> 835
    //   211: new 306	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 523
    //   221: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 345
    //   231: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   238: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: ldc_w 525
    //   244: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 6
    //   249: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: ldc_w 527
    //   255: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: astore_3
    //   259: iload_2
    //   260: ifeq +563 -> 823
    //   263: iconst_1
    //   264: istore 7
    //   266: aload_3
    //   267: iload 7
    //   269: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc_w 529
    //   275: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: astore_3
    //   279: iload 10
    //   281: ifeq +548 -> 829
    //   284: iconst_1
    //   285: istore 7
    //   287: ldc_w 531
    //   290: iconst_1
    //   291: aload_3
    //   292: iload 7
    //   294: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc_w 533
    //   300: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokestatic 536	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   306: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_0
    //   316: aload_1
    //   317: invokespecial 538	com/tencent/mobileqq/msf/core/g:f	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)[B
    //   320: astore 17
    //   322: aload 17
    //   324: ifnonnull +633 -> 957
    //   327: aload_0
    //   328: aload_1
    //   329: aconst_null
    //   330: iconst_1
    //   331: new 306	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 540
    //   341: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: iload 4
    //   346: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 542
    //   352: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: aload 16
    //   360: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   363: iconst_0
    //   364: istore 9
    //   366: aload 14
    //   368: invokeinterface 546 1 0
    //   373: aload 14
    //   375: invokeinterface 548 1 0
    //   380: aload 16
    //   382: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   385: aload 16
    //   387: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   390: lsub
    //   391: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   394: iload 9
    //   396: istore 8
    //   398: aload_0
    //   399: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   402: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   405: ifnull +397 -> 802
    //   408: iload 9
    //   410: istore 8
    //   412: aload_0
    //   413: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   416: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   419: ifnull +383 -> 802
    //   422: iload 9
    //   424: istore 8
    //   426: aload_1
    //   427: ifnull +375 -> 802
    //   430: iload 9
    //   432: istore 8
    //   434: aload_0
    //   435: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   438: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   441: aload_1
    //   442: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   445: ifeq +357 -> 802
    //   448: new 407	java/util/HashMap
    //   451: dup
    //   452: invokespecial 561	java/util/HashMap:<init>	()V
    //   455: astore_3
    //   456: aload_3
    //   457: ldc_w 563
    //   460: aload 16
    //   462: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   465: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   468: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload_3
    //   473: ldc_w 570
    //   476: aload 16
    //   478: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   481: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   484: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   487: pop
    //   488: aload_3
    //   489: ldc_w 577
    //   492: aload 16
    //   494: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   497: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: aload_3
    //   502: ldc_w 581
    //   505: aload 16
    //   507: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   510: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: aload_3
    //   515: ldc_w 585
    //   518: ldc_w 587
    //   521: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload_3
    //   526: ldc_w 589
    //   529: aload 16
    //   531: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   534: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   537: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   540: pop
    //   541: aload_3
    //   542: ldc_w 596
    //   545: aload 16
    //   547: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   550: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   553: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   556: pop
    //   557: aload_3
    //   558: ldc_w 598
    //   561: aload 16
    //   563: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   566: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   569: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   572: pop
    //   573: aload_3
    //   574: ldc_w 602
    //   577: aload 16
    //   579: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   582: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   585: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   588: pop
    //   589: aload_3
    //   590: ldc_w 606
    //   593: aload 16
    //   595: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   598: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   601: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   604: pop
    //   605: aload_3
    //   606: ldc_w 608
    //   609: aload 16
    //   611: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   614: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   617: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: aload_3
    //   622: ldc_w 610
    //   625: aload 16
    //   627: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   630: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: aload_3
    //   635: ldc_w 614
    //   638: aload 16
    //   640: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   643: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   646: pop
    //   647: aload_3
    //   648: ldc_w 618
    //   651: new 306	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 435
    //   661: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: iload 6
    //   666: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   669: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: pop
    //   676: aload_3
    //   677: ldc_w 620
    //   680: new 306	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 435
    //   690: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: iload 5
    //   695: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   698: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: pop
    //   705: aload_3
    //   706: ldc_w 622
    //   709: iload_2
    //   710: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   713: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   716: pop
    //   717: aload_3
    //   718: ldc_w 626
    //   721: iload 10
    //   723: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   726: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   729: pop
    //   730: iconst_1
    //   731: istore 4
    //   733: iload_2
    //   734: ifeq +3803 -> 4537
    //   737: iconst_3
    //   738: istore 4
    //   740: aload_3
    //   741: ldc_w 628
    //   744: iload 4
    //   746: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   749: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   752: pop
    //   753: aload_3
    //   754: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   757: ldc_w 435
    //   760: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   763: pop
    //   764: aload_0
    //   765: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   768: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   771: astore_1
    //   772: aload 16
    //   774: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   777: istore_2
    //   778: aload 16
    //   780: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   783: lstore 12
    //   785: iconst_0
    //   786: istore 8
    //   788: aload_1
    //   789: ldc_w 637
    //   792: iload_2
    //   793: lload 12
    //   795: lconst_0
    //   796: aload_3
    //   797: iconst_0
    //   798: iconst_0
    //   799: invokevirtual 642	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   802: iload 8
    //   804: ireturn
    //   805: iconst_0
    //   806: istore 10
    //   808: goto -669 -> 139
    //   811: new 644	com/tencent/mobileqq/msf/core/net/f
    //   814: dup
    //   815: invokespecial 645	com/tencent/mobileqq/msf/core/net/f:<init>	()V
    //   818: astore 14
    //   820: goto -667 -> 153
    //   823: iconst_0
    //   824: istore 7
    //   826: goto -560 -> 266
    //   829: iconst_0
    //   830: istore 7
    //   832: goto -545 -> 287
    //   835: new 306	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 523
    //   845: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_3
    //   849: invokestatic 650	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   852: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: ldc_w 345
    //   858: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload_1
    //   862: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   865: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   868: ldc_w 525
    //   871: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: iload 6
    //   876: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   879: ldc_w 527
    //   882: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: astore_3
    //   886: iload_2
    //   887: ifeq +58 -> 945
    //   890: iconst_1
    //   891: istore 7
    //   893: aload_3
    //   894: iload 7
    //   896: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   899: ldc_w 529
    //   902: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: astore_3
    //   906: iload 10
    //   908: ifeq +43 -> 951
    //   911: iconst_1
    //   912: istore 7
    //   914: ldc_w 531
    //   917: iconst_1
    //   918: aload_3
    //   919: iload 7
    //   921: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc_w 533
    //   927: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokestatic 536	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   933: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   936: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: goto -627 -> 315
    //   945: iconst_0
    //   946: istore 7
    //   948: goto -55 -> 893
    //   951: iconst_0
    //   952: istore 7
    //   954: goto -40 -> 914
    //   957: aload_0
    //   958: aload_1
    //   959: invokespecial 652	com/tencent/mobileqq/msf/core/g:e	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   962: astore 18
    //   964: aload 16
    //   966: aload_1
    //   967: invokevirtual 444	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   970: putfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   973: aload 16
    //   975: aload_1
    //   976: invokevirtual 343	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   979: putfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   982: aload 16
    //   984: aload 17
    //   986: arraylength
    //   987: putfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   990: aload 16
    //   992: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   995: putfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   998: ldc_w 435
    //   1001: astore 15
    //   1003: aload 15
    //   1005: astore_3
    //   1006: aload_1
    //   1007: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1010: ldc_w 654
    //   1013: invokevirtual 410	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1016: ifeq +3635 -> 4651
    //   1019: aload 15
    //   1021: astore_3
    //   1022: aload_1
    //   1023: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1026: ldc_w 654
    //   1029: invokevirtual 414	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1032: ifnull +3619 -> 4651
    //   1035: aload_1
    //   1036: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1039: ldc_w 654
    //   1042: invokevirtual 414	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 201	java/lang/String
    //   1048: astore_3
    //   1049: goto +3602 -> 4651
    //   1052: aload_0
    //   1053: aload 14
    //   1055: aload 18
    //   1057: iload 4
    //   1059: aload 16
    //   1061: aload_3
    //   1062: iload 8
    //   1064: invokespecial 656	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/mobileqq/msf/core/net/b;Ljava/lang/String;ILcom/tencent/mobileqq/msf/core/quicksend/f;Ljava/lang/String;Z)Z
    //   1067: istore 8
    //   1069: aload 16
    //   1071: iload 8
    //   1073: putfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1076: iload 8
    //   1078: ifne +470 -> 1548
    //   1081: aload_0
    //   1082: aload_1
    //   1083: aconst_null
    //   1084: iconst_2
    //   1085: new 306	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1092: ldc_w 540
    //   1095: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: iload 4
    //   1100: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1103: ldc_w 658
    //   1106: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: aload 16
    //   1114: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   1117: iconst_0
    //   1118: istore 9
    //   1120: aload 14
    //   1122: invokeinterface 546 1 0
    //   1127: aload 14
    //   1129: invokeinterface 548 1 0
    //   1134: aload 16
    //   1136: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   1139: aload 16
    //   1141: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1144: lsub
    //   1145: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1148: iload 9
    //   1150: istore 8
    //   1152: aload_0
    //   1153: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1156: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1159: ifnull -357 -> 802
    //   1162: iload 9
    //   1164: istore 8
    //   1166: aload_0
    //   1167: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1170: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1173: ifnull -371 -> 802
    //   1176: iload 9
    //   1178: istore 8
    //   1180: aload_1
    //   1181: ifnull -379 -> 802
    //   1184: iload 9
    //   1186: istore 8
    //   1188: aload_0
    //   1189: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1192: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1195: aload_1
    //   1196: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1199: ifeq -397 -> 802
    //   1202: new 407	java/util/HashMap
    //   1205: dup
    //   1206: invokespecial 561	java/util/HashMap:<init>	()V
    //   1209: astore_3
    //   1210: aload_3
    //   1211: ldc_w 563
    //   1214: aload 16
    //   1216: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1219: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1222: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1225: pop
    //   1226: aload_3
    //   1227: ldc_w 570
    //   1230: aload 16
    //   1232: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1235: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1238: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1241: pop
    //   1242: aload_3
    //   1243: ldc_w 577
    //   1246: aload 16
    //   1248: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1251: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1254: pop
    //   1255: aload_3
    //   1256: ldc_w 581
    //   1259: aload 16
    //   1261: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1264: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1267: pop
    //   1268: aload_3
    //   1269: ldc_w 585
    //   1272: ldc_w 587
    //   1275: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1278: pop
    //   1279: aload_3
    //   1280: ldc_w 589
    //   1283: aload 16
    //   1285: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1288: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1291: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1294: pop
    //   1295: aload_3
    //   1296: ldc_w 596
    //   1299: aload 16
    //   1301: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1304: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1307: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1310: pop
    //   1311: aload_3
    //   1312: ldc_w 598
    //   1315: aload 16
    //   1317: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1320: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1323: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1326: pop
    //   1327: aload_3
    //   1328: ldc_w 602
    //   1331: aload 16
    //   1333: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1336: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1339: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1342: pop
    //   1343: aload_3
    //   1344: ldc_w 606
    //   1347: aload 16
    //   1349: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1352: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1355: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: pop
    //   1359: aload_3
    //   1360: ldc_w 608
    //   1363: aload 16
    //   1365: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1368: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1371: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1374: pop
    //   1375: aload_3
    //   1376: ldc_w 610
    //   1379: aload 16
    //   1381: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1384: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1387: pop
    //   1388: aload_3
    //   1389: ldc_w 614
    //   1392: aload 16
    //   1394: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1397: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1400: pop
    //   1401: aload_3
    //   1402: ldc_w 618
    //   1405: new 306	java/lang/StringBuilder
    //   1408: dup
    //   1409: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1412: ldc_w 435
    //   1415: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: iload 6
    //   1420: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1423: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1429: pop
    //   1430: aload_3
    //   1431: ldc_w 620
    //   1434: new 306	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1441: ldc_w 435
    //   1444: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: iload 5
    //   1449: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1458: pop
    //   1459: aload_3
    //   1460: ldc_w 622
    //   1463: iload_2
    //   1464: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1467: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1470: pop
    //   1471: aload_3
    //   1472: ldc_w 626
    //   1475: iload 10
    //   1477: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1480: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1483: pop
    //   1484: iconst_1
    //   1485: istore 4
    //   1487: iload_2
    //   1488: ifeq +3060 -> 4548
    //   1491: iconst_3
    //   1492: istore 4
    //   1494: aload_3
    //   1495: ldc_w 628
    //   1498: iload 4
    //   1500: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1503: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1506: pop
    //   1507: aload_3
    //   1508: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   1511: ldc_w 435
    //   1514: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1517: pop
    //   1518: aload_0
    //   1519: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1522: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1525: astore_1
    //   1526: aload 16
    //   1528: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1531: istore_2
    //   1532: aload 16
    //   1534: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1537: lstore 12
    //   1539: goto -754 -> 785
    //   1542: iconst_0
    //   1543: istore 8
    //   1545: goto -493 -> 1052
    //   1548: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   1551: lstore 12
    //   1553: aload 14
    //   1555: aload_1
    //   1556: aload 17
    //   1558: aload 18
    //   1560: aload 16
    //   1562: invokeinterface 661 5 0
    //   1567: astore_3
    //   1568: aload_3
    //   1569: ifnonnull +464 -> 2033
    //   1572: aload_0
    //   1573: aload_1
    //   1574: aconst_null
    //   1575: iconst_3
    //   1576: new 306	java/lang/StringBuilder
    //   1579: dup
    //   1580: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1583: ldc_w 540
    //   1586: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: iload 4
    //   1591: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1594: ldc_w 663
    //   1597: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1603: aload 16
    //   1605: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   1608: iconst_0
    //   1609: istore 9
    //   1611: aload 14
    //   1613: invokeinterface 546 1 0
    //   1618: aload 14
    //   1620: invokeinterface 548 1 0
    //   1625: aload 16
    //   1627: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   1630: aload 16
    //   1632: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1635: lsub
    //   1636: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1639: iload 9
    //   1641: istore 8
    //   1643: aload_0
    //   1644: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1647: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1650: ifnull -848 -> 802
    //   1653: iload 9
    //   1655: istore 8
    //   1657: aload_0
    //   1658: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1661: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1664: ifnull -862 -> 802
    //   1667: iload 9
    //   1669: istore 8
    //   1671: aload_1
    //   1672: ifnull -870 -> 802
    //   1675: iload 9
    //   1677: istore 8
    //   1679: aload_0
    //   1680: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1683: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1686: aload_1
    //   1687: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1690: ifeq -888 -> 802
    //   1693: new 407	java/util/HashMap
    //   1696: dup
    //   1697: invokespecial 561	java/util/HashMap:<init>	()V
    //   1700: astore_3
    //   1701: aload_3
    //   1702: ldc_w 563
    //   1705: aload 16
    //   1707: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1710: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1713: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1716: pop
    //   1717: aload_3
    //   1718: ldc_w 570
    //   1721: aload 16
    //   1723: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1726: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1729: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1732: pop
    //   1733: aload_3
    //   1734: ldc_w 577
    //   1737: aload 16
    //   1739: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1742: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1745: pop
    //   1746: aload_3
    //   1747: ldc_w 581
    //   1750: aload 16
    //   1752: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1755: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: pop
    //   1759: aload_3
    //   1760: ldc_w 585
    //   1763: ldc_w 587
    //   1766: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1769: pop
    //   1770: aload_3
    //   1771: ldc_w 589
    //   1774: aload 16
    //   1776: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1779: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1782: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1785: pop
    //   1786: aload_3
    //   1787: ldc_w 596
    //   1790: aload 16
    //   1792: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1795: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1798: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1801: pop
    //   1802: aload_3
    //   1803: ldc_w 598
    //   1806: aload 16
    //   1808: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1811: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1814: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1817: pop
    //   1818: aload_3
    //   1819: ldc_w 602
    //   1822: aload 16
    //   1824: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1827: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1830: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1833: pop
    //   1834: aload_3
    //   1835: ldc_w 606
    //   1838: aload 16
    //   1840: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1843: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1846: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1849: pop
    //   1850: aload_3
    //   1851: ldc_w 608
    //   1854: aload 16
    //   1856: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1859: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1862: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1865: pop
    //   1866: aload_3
    //   1867: ldc_w 610
    //   1870: aload 16
    //   1872: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1875: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1878: pop
    //   1879: aload_3
    //   1880: ldc_w 614
    //   1883: aload 16
    //   1885: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1888: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1891: pop
    //   1892: aload_3
    //   1893: ldc_w 618
    //   1896: new 306	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1903: ldc_w 435
    //   1906: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: iload 6
    //   1911: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1914: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1917: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1920: pop
    //   1921: aload_3
    //   1922: ldc_w 620
    //   1925: new 306	java/lang/StringBuilder
    //   1928: dup
    //   1929: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   1932: ldc_w 435
    //   1935: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: iload 5
    //   1940: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1943: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1946: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1949: pop
    //   1950: aload_3
    //   1951: ldc_w 622
    //   1954: iload_2
    //   1955: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1958: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1961: pop
    //   1962: aload_3
    //   1963: ldc_w 626
    //   1966: iload 10
    //   1968: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1971: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1974: pop
    //   1975: iconst_1
    //   1976: istore 4
    //   1978: iload_2
    //   1979: ifeq +2580 -> 4559
    //   1982: iconst_3
    //   1983: istore 4
    //   1985: aload_3
    //   1986: ldc_w 628
    //   1989: iload 4
    //   1991: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1994: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1997: pop
    //   1998: aload_3
    //   1999: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2002: ldc_w 435
    //   2005: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2008: pop
    //   2009: aload_0
    //   2010: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2013: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2016: astore_1
    //   2017: aload 16
    //   2019: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2022: istore_2
    //   2023: aload 16
    //   2025: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2028: lstore 12
    //   2030: goto -1245 -> 785
    //   2033: aload 16
    //   2035: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   2038: lload 12
    //   2040: lsub
    //   2041: putfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2044: aload_0
    //   2045: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2048: getfield 667	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2051: getfield 671	com/tencent/mobileqq/msf/core/ak:C	Lcom/tencent/mobileqq/msf/core/ak$a;
    //   2054: aload_3
    //   2055: invokevirtual 677	com/tencent/mobileqq/msf/core/ak$a:nativeParseData	([B)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   2058: astore_3
    //   2059: aload_3
    //   2060: ifnull +1049 -> 3109
    //   2063: aload_0
    //   2064: aload_3
    //   2065: invokespecial 679	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   2068: astore_3
    //   2069: aload_3
    //   2070: ifnonnull +464 -> 2534
    //   2073: aload_0
    //   2074: aload_1
    //   2075: aconst_null
    //   2076: iconst_5
    //   2077: new 306	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2084: ldc_w 540
    //   2087: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: iload 4
    //   2092: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2095: ldc_w 663
    //   2098: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2104: aload 16
    //   2106: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2109: iconst_0
    //   2110: istore 9
    //   2112: aload 14
    //   2114: invokeinterface 546 1 0
    //   2119: aload 14
    //   2121: invokeinterface 548 1 0
    //   2126: aload 16
    //   2128: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   2131: aload 16
    //   2133: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2136: lsub
    //   2137: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2140: iload 9
    //   2142: istore 8
    //   2144: aload_0
    //   2145: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2148: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2151: ifnull -1349 -> 802
    //   2154: iload 9
    //   2156: istore 8
    //   2158: aload_0
    //   2159: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2162: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2165: ifnull -1363 -> 802
    //   2168: iload 9
    //   2170: istore 8
    //   2172: aload_1
    //   2173: ifnull -1371 -> 802
    //   2176: iload 9
    //   2178: istore 8
    //   2180: aload_0
    //   2181: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2184: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2187: aload_1
    //   2188: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2191: ifeq -1389 -> 802
    //   2194: new 407	java/util/HashMap
    //   2197: dup
    //   2198: invokespecial 561	java/util/HashMap:<init>	()V
    //   2201: astore_3
    //   2202: aload_3
    //   2203: ldc_w 563
    //   2206: aload 16
    //   2208: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2211: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2214: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2217: pop
    //   2218: aload_3
    //   2219: ldc_w 570
    //   2222: aload 16
    //   2224: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2227: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2230: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2233: pop
    //   2234: aload_3
    //   2235: ldc_w 577
    //   2238: aload 16
    //   2240: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2243: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2246: pop
    //   2247: aload_3
    //   2248: ldc_w 581
    //   2251: aload 16
    //   2253: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2256: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2259: pop
    //   2260: aload_3
    //   2261: ldc_w 585
    //   2264: ldc_w 587
    //   2267: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2270: pop
    //   2271: aload_3
    //   2272: ldc_w 589
    //   2275: aload 16
    //   2277: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2280: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2283: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2286: pop
    //   2287: aload_3
    //   2288: ldc_w 596
    //   2291: aload 16
    //   2293: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2296: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2299: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2302: pop
    //   2303: aload_3
    //   2304: ldc_w 598
    //   2307: aload 16
    //   2309: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2312: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2315: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2318: pop
    //   2319: aload_3
    //   2320: ldc_w 602
    //   2323: aload 16
    //   2325: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2328: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2331: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2334: pop
    //   2335: aload_3
    //   2336: ldc_w 606
    //   2339: aload 16
    //   2341: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2344: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2347: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2350: pop
    //   2351: aload_3
    //   2352: ldc_w 608
    //   2355: aload 16
    //   2357: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2360: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2363: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2366: pop
    //   2367: aload_3
    //   2368: ldc_w 610
    //   2371: aload 16
    //   2373: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2376: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2379: pop
    //   2380: aload_3
    //   2381: ldc_w 614
    //   2384: aload 16
    //   2386: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2389: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2392: pop
    //   2393: aload_3
    //   2394: ldc_w 618
    //   2397: new 306	java/lang/StringBuilder
    //   2400: dup
    //   2401: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2404: ldc_w 435
    //   2407: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: iload 6
    //   2412: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2415: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2421: pop
    //   2422: aload_3
    //   2423: ldc_w 620
    //   2426: new 306	java/lang/StringBuilder
    //   2429: dup
    //   2430: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2433: ldc_w 435
    //   2436: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: iload 5
    //   2441: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2444: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2447: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2450: pop
    //   2451: aload_3
    //   2452: ldc_w 622
    //   2455: iload_2
    //   2456: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2459: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2462: pop
    //   2463: aload_3
    //   2464: ldc_w 626
    //   2467: iload 10
    //   2469: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2472: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2475: pop
    //   2476: iconst_1
    //   2477: istore 4
    //   2479: iload_2
    //   2480: ifeq +2090 -> 4570
    //   2483: iconst_3
    //   2484: istore 4
    //   2486: aload_3
    //   2487: ldc_w 628
    //   2490: iload 4
    //   2492: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2495: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2498: pop
    //   2499: aload_3
    //   2500: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2503: ldc_w 435
    //   2506: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2509: pop
    //   2510: aload_0
    //   2511: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2514: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2517: astore_1
    //   2518: aload 16
    //   2520: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2523: istore_2
    //   2524: aload 16
    //   2526: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2529: lstore 12
    //   2531: goto -1746 -> 785
    //   2534: aload_3
    //   2535: aload_3
    //   2536: invokevirtual 682	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   2539: invokevirtual 685	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   2542: aload_3
    //   2543: invokevirtual 686	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2546: ldc_w 688
    //   2549: iload_2
    //   2550: invokestatic 691	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2553: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2556: pop
    //   2557: aload_1
    //   2558: ifnull +50 -> 2608
    //   2561: aload_3
    //   2562: aload_1
    //   2563: invokevirtual 692	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   2566: invokevirtual 695	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
    //   2569: aload_3
    //   2570: aload_1
    //   2571: invokevirtual 699	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   2574: invokevirtual 703	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   2577: aload_3
    //   2578: aload_1
    //   2579: invokevirtual 438	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   2582: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:setAppId	(I)V
    //   2585: aload_3
    //   2586: aload_1
    //   2587: invokevirtual 348	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   2590: invokevirtual 685	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   2593: aload_1
    //   2594: invokevirtual 405	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   2597: ldc_w 688
    //   2600: iload_2
    //   2601: invokestatic 691	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2604: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2607: pop
    //   2608: aload_0
    //   2609: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2612: invokevirtual 229	com/tencent/mobileqq/msf/core/MsfCore:getSsoRespHandler	()Lcom/tencent/mobileqq/msf/core/an;
    //   2615: aload_1
    //   2616: aload_3
    //   2617: iload 6
    //   2619: invokevirtual 709	com/tencent/mobileqq/msf/core/an:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;I)Z
    //   2622: istore 9
    //   2624: iload 9
    //   2626: ifne +40 -> 2666
    //   2629: aload_0
    //   2630: aload_1
    //   2631: aconst_null
    //   2632: bipush 6
    //   2634: new 306	java/lang/StringBuilder
    //   2637: dup
    //   2638: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2641: ldc_w 540
    //   2644: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2647: iload 4
    //   2649: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2652: ldc_w 711
    //   2655: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2661: aload 16
    //   2663: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2666: aload 16
    //   2668: iconst_1
    //   2669: putfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2672: iconst_1
    //   2673: istore 11
    //   2675: iconst_1
    //   2676: istore 8
    //   2678: aload 14
    //   2680: invokeinterface 546 1 0
    //   2685: aload 14
    //   2687: invokeinterface 548 1 0
    //   2692: aload 16
    //   2694: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   2697: aload 16
    //   2699: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2702: lsub
    //   2703: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2706: aload_0
    //   2707: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2710: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2713: ifnull +374 -> 3087
    //   2716: aload_0
    //   2717: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2720: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2723: ifnull +364 -> 3087
    //   2726: aload_1
    //   2727: ifnull +360 -> 3087
    //   2730: aload_0
    //   2731: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2734: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2737: aload_1
    //   2738: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2741: ifeq +346 -> 3087
    //   2744: new 407	java/util/HashMap
    //   2747: dup
    //   2748: invokespecial 561	java/util/HashMap:<init>	()V
    //   2751: astore_3
    //   2752: aload_3
    //   2753: ldc_w 563
    //   2756: aload 16
    //   2758: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2761: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2764: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2767: pop
    //   2768: aload_3
    //   2769: ldc_w 570
    //   2772: aload 16
    //   2774: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2777: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2780: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2783: pop
    //   2784: aload_3
    //   2785: ldc_w 577
    //   2788: aload 16
    //   2790: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2793: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2796: pop
    //   2797: aload_3
    //   2798: ldc_w 581
    //   2801: aload 16
    //   2803: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2806: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2809: pop
    //   2810: aload_3
    //   2811: ldc_w 585
    //   2814: ldc_w 587
    //   2817: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2820: pop
    //   2821: aload_3
    //   2822: ldc_w 589
    //   2825: aload 16
    //   2827: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2830: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2833: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2836: pop
    //   2837: aload_3
    //   2838: ldc_w 596
    //   2841: aload 16
    //   2843: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2846: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2849: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2852: pop
    //   2853: aload_3
    //   2854: ldc_w 598
    //   2857: aload 16
    //   2859: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2862: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2865: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2868: pop
    //   2869: aload_3
    //   2870: ldc_w 602
    //   2873: aload 16
    //   2875: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2878: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2881: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2884: pop
    //   2885: aload_3
    //   2886: ldc_w 606
    //   2889: aload 16
    //   2891: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2894: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2897: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2900: pop
    //   2901: aload_3
    //   2902: ldc_w 608
    //   2905: aload 16
    //   2907: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2910: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2913: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2916: pop
    //   2917: aload_3
    //   2918: ldc_w 610
    //   2921: aload 16
    //   2923: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2926: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2929: pop
    //   2930: aload_3
    //   2931: ldc_w 614
    //   2934: aload 16
    //   2936: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2939: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2942: pop
    //   2943: aload_3
    //   2944: ldc_w 618
    //   2947: new 306	java/lang/StringBuilder
    //   2950: dup
    //   2951: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2954: ldc_w 435
    //   2957: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2960: iload 6
    //   2962: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2965: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2968: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2971: pop
    //   2972: aload_3
    //   2973: ldc_w 620
    //   2976: new 306	java/lang/StringBuilder
    //   2979: dup
    //   2980: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   2983: ldc_w 435
    //   2986: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2989: iload 5
    //   2991: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2994: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2997: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3000: pop
    //   3001: aload_3
    //   3002: ldc_w 622
    //   3005: iload_2
    //   3006: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3009: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3012: pop
    //   3013: aload_3
    //   3014: ldc_w 626
    //   3017: iload 10
    //   3019: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3022: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3025: pop
    //   3026: iconst_1
    //   3027: istore 4
    //   3029: iload_2
    //   3030: ifeq +1551 -> 4581
    //   3033: iconst_3
    //   3034: istore 4
    //   3036: aload_3
    //   3037: ldc_w 628
    //   3040: iload 4
    //   3042: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3045: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3048: pop
    //   3049: aload_3
    //   3050: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3053: ldc_w 435
    //   3056: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3059: pop
    //   3060: aload_0
    //   3061: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3064: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3067: ldc_w 637
    //   3070: aload 16
    //   3072: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3075: aload 16
    //   3077: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3080: lconst_0
    //   3081: aload_3
    //   3082: iconst_0
    //   3083: iconst_0
    //   3084: invokevirtual 642	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3087: iload 9
    //   3089: ifeq -2287 -> 802
    //   3092: invokestatic 239	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3095: astore_3
    //   3096: iload 11
    //   3098: istore_2
    //   3099: aload_3
    //   3100: aload_1
    //   3101: aconst_null
    //   3102: aload 16
    //   3104: invokevirtual 242	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   3107: iload_2
    //   3108: ireturn
    //   3109: aload_0
    //   3110: aload_1
    //   3111: aconst_null
    //   3112: iconst_4
    //   3113: new 306	java/lang/StringBuilder
    //   3116: dup
    //   3117: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3120: ldc_w 540
    //   3123: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: iload 4
    //   3128: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3131: ldc_w 713
    //   3134: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3137: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3140: aload 16
    //   3142: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   3145: aload 14
    //   3147: invokeinterface 546 1 0
    //   3152: aload 14
    //   3154: invokeinterface 548 1 0
    //   3159: aload 16
    //   3161: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   3164: aload 16
    //   3166: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3169: lsub
    //   3170: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3173: aload_0
    //   3174: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3177: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3180: ifnull +374 -> 3554
    //   3183: aload_0
    //   3184: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3187: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3190: ifnull +364 -> 3554
    //   3193: aload_1
    //   3194: ifnull +360 -> 3554
    //   3197: aload_0
    //   3198: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3201: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3204: aload_1
    //   3205: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3208: ifeq +346 -> 3554
    //   3211: new 407	java/util/HashMap
    //   3214: dup
    //   3215: invokespecial 561	java/util/HashMap:<init>	()V
    //   3218: astore_1
    //   3219: aload_1
    //   3220: ldc_w 563
    //   3223: aload 16
    //   3225: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3228: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3231: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3234: pop
    //   3235: aload_1
    //   3236: ldc_w 570
    //   3239: aload 16
    //   3241: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3244: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3247: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3250: pop
    //   3251: aload_1
    //   3252: ldc_w 577
    //   3255: aload 16
    //   3257: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3260: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3263: pop
    //   3264: aload_1
    //   3265: ldc_w 581
    //   3268: aload 16
    //   3270: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3273: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3276: pop
    //   3277: aload_1
    //   3278: ldc_w 585
    //   3281: ldc_w 587
    //   3284: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3287: pop
    //   3288: aload_1
    //   3289: ldc_w 589
    //   3292: aload 16
    //   3294: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3297: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3300: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3303: pop
    //   3304: aload_1
    //   3305: ldc_w 596
    //   3308: aload 16
    //   3310: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3313: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3316: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3319: pop
    //   3320: aload_1
    //   3321: ldc_w 598
    //   3324: aload 16
    //   3326: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3329: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3332: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3335: pop
    //   3336: aload_1
    //   3337: ldc_w 602
    //   3340: aload 16
    //   3342: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3345: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3348: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3351: pop
    //   3352: aload_1
    //   3353: ldc_w 606
    //   3356: aload 16
    //   3358: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3361: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3364: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3367: pop
    //   3368: aload_1
    //   3369: ldc_w 608
    //   3372: aload 16
    //   3374: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3377: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3380: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3383: pop
    //   3384: aload_1
    //   3385: ldc_w 610
    //   3388: aload 16
    //   3390: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3393: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3396: pop
    //   3397: aload_1
    //   3398: ldc_w 614
    //   3401: aload 16
    //   3403: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3406: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3409: pop
    //   3410: aload_1
    //   3411: ldc_w 618
    //   3414: new 306	java/lang/StringBuilder
    //   3417: dup
    //   3418: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3421: ldc_w 435
    //   3424: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3427: iload 6
    //   3429: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3432: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3435: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3438: pop
    //   3439: aload_1
    //   3440: ldc_w 620
    //   3443: new 306	java/lang/StringBuilder
    //   3446: dup
    //   3447: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3450: ldc_w 435
    //   3453: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: iload 5
    //   3458: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3461: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3464: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3467: pop
    //   3468: aload_1
    //   3469: ldc_w 622
    //   3472: iload_2
    //   3473: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3476: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3479: pop
    //   3480: aload_1
    //   3481: ldc_w 626
    //   3484: iload 10
    //   3486: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3489: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3492: pop
    //   3493: iconst_1
    //   3494: istore 4
    //   3496: iload_2
    //   3497: ifeq +1095 -> 4592
    //   3500: iconst_3
    //   3501: istore 4
    //   3503: aload_1
    //   3504: ldc_w 628
    //   3507: iload 4
    //   3509: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3512: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3515: pop
    //   3516: aload_1
    //   3517: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3520: ldc_w 435
    //   3523: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3526: pop
    //   3527: aload_0
    //   3528: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3531: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3534: ldc_w 637
    //   3537: aload 16
    //   3539: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3542: aload 16
    //   3544: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3547: lconst_0
    //   3548: aload_1
    //   3549: iconst_0
    //   3550: iconst_0
    //   3551: invokevirtual 642	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3554: iconst_0
    //   3555: ireturn
    //   3556: astore_3
    //   3557: iconst_0
    //   3558: istore 9
    //   3560: aload_0
    //   3561: aload_1
    //   3562: aconst_null
    //   3563: iconst_m1
    //   3564: new 306	java/lang/StringBuilder
    //   3567: dup
    //   3568: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3571: ldc_w 540
    //   3574: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: iload 4
    //   3579: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3582: ldc_w 715
    //   3585: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3591: aload 16
    //   3593: invokespecial 544	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   3596: aload_3
    //   3597: invokevirtual 454	java/lang/Throwable:printStackTrace	()V
    //   3600: ldc 48
    //   3602: iconst_1
    //   3603: new 306	java/lang/StringBuilder
    //   3606: dup
    //   3607: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3610: ldc_w 717
    //   3613: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: iload 4
    //   3618: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3621: ldc_w 719
    //   3624: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3630: aload_3
    //   3631: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3634: iconst_0
    //   3635: istore 11
    //   3637: iconst_0
    //   3638: istore 8
    //   3640: aload 14
    //   3642: invokeinterface 546 1 0
    //   3647: aload 14
    //   3649: invokeinterface 548 1 0
    //   3654: aload 16
    //   3656: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   3659: aload 16
    //   3661: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3664: lsub
    //   3665: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3668: aload_0
    //   3669: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3672: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3675: ifnull +374 -> 4049
    //   3678: aload_0
    //   3679: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3682: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3685: ifnull +364 -> 4049
    //   3688: aload_1
    //   3689: ifnull +360 -> 4049
    //   3692: aload_0
    //   3693: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3696: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3699: aload_1
    //   3700: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3703: ifeq +346 -> 4049
    //   3706: new 407	java/util/HashMap
    //   3709: dup
    //   3710: invokespecial 561	java/util/HashMap:<init>	()V
    //   3713: astore_3
    //   3714: aload_3
    //   3715: ldc_w 563
    //   3718: aload 16
    //   3720: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3723: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3726: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3729: pop
    //   3730: aload_3
    //   3731: ldc_w 570
    //   3734: aload 16
    //   3736: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3739: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3742: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3745: pop
    //   3746: aload_3
    //   3747: ldc_w 577
    //   3750: aload 16
    //   3752: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3755: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3758: pop
    //   3759: aload_3
    //   3760: ldc_w 581
    //   3763: aload 16
    //   3765: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3768: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3771: pop
    //   3772: aload_3
    //   3773: ldc_w 585
    //   3776: ldc_w 587
    //   3779: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3782: pop
    //   3783: aload_3
    //   3784: ldc_w 589
    //   3787: aload 16
    //   3789: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3792: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3795: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3798: pop
    //   3799: aload_3
    //   3800: ldc_w 596
    //   3803: aload 16
    //   3805: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3808: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3811: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3814: pop
    //   3815: aload_3
    //   3816: ldc_w 598
    //   3819: aload 16
    //   3821: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3824: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3827: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3830: pop
    //   3831: aload_3
    //   3832: ldc_w 602
    //   3835: aload 16
    //   3837: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3840: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3843: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3846: pop
    //   3847: aload_3
    //   3848: ldc_w 606
    //   3851: aload 16
    //   3853: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3856: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3859: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3862: pop
    //   3863: aload_3
    //   3864: ldc_w 608
    //   3867: aload 16
    //   3869: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3872: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3875: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3878: pop
    //   3879: aload_3
    //   3880: ldc_w 610
    //   3883: aload 16
    //   3885: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3888: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3891: pop
    //   3892: aload_3
    //   3893: ldc_w 614
    //   3896: aload 16
    //   3898: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3901: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3904: pop
    //   3905: aload_3
    //   3906: ldc_w 618
    //   3909: new 306	java/lang/StringBuilder
    //   3912: dup
    //   3913: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3916: ldc_w 435
    //   3919: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3922: iload 6
    //   3924: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3927: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3930: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3933: pop
    //   3934: aload_3
    //   3935: ldc_w 620
    //   3938: new 306	java/lang/StringBuilder
    //   3941: dup
    //   3942: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   3945: ldc_w 435
    //   3948: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3951: iload 5
    //   3953: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3956: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3959: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3962: pop
    //   3963: aload_3
    //   3964: ldc_w 622
    //   3967: iload_2
    //   3968: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3971: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3974: pop
    //   3975: aload_3
    //   3976: ldc_w 626
    //   3979: iload 10
    //   3981: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3984: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3987: pop
    //   3988: iconst_1
    //   3989: istore 4
    //   3991: iload_2
    //   3992: ifeq +534 -> 4526
    //   3995: iconst_3
    //   3996: istore 4
    //   3998: aload_3
    //   3999: ldc_w 628
    //   4002: iload 4
    //   4004: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4007: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4010: pop
    //   4011: aload_3
    //   4012: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   4015: ldc_w 435
    //   4018: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4021: pop
    //   4022: aload_0
    //   4023: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4026: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   4029: ldc_w 637
    //   4032: aload 16
    //   4034: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   4037: aload 16
    //   4039: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   4042: lconst_0
    //   4043: aload_3
    //   4044: iconst_0
    //   4045: iconst_0
    //   4046: invokevirtual 642	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   4049: iload 9
    //   4051: ifeq -3249 -> 802
    //   4054: invokestatic 239	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4057: astore_3
    //   4058: iload 11
    //   4060: istore_2
    //   4061: goto -962 -> 3099
    //   4064: astore_3
    //   4065: iconst_0
    //   4066: istore 9
    //   4068: aload 14
    //   4070: invokeinterface 546 1 0
    //   4075: aload 14
    //   4077: invokeinterface 548 1 0
    //   4082: aload 16
    //   4084: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   4087: aload 16
    //   4089: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   4092: lsub
    //   4093: putfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   4096: aload_0
    //   4097: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4100: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   4103: ifnull +395 -> 4498
    //   4106: aload_0
    //   4107: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4110: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   4113: ifnull +385 -> 4498
    //   4116: aload_1
    //   4117: ifnull +381 -> 4498
    //   4120: aload_0
    //   4121: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4124: getfield 556	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   4127: aload_1
    //   4128: invokevirtual 560	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   4131: ifeq +367 -> 4498
    //   4134: new 407	java/util/HashMap
    //   4137: dup
    //   4138: invokespecial 561	java/util/HashMap:<init>	()V
    //   4141: astore 14
    //   4143: aload 14
    //   4145: ldc_w 563
    //   4148: aload 16
    //   4150: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   4153: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   4156: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4159: pop
    //   4160: aload 14
    //   4162: ldc_w 570
    //   4165: aload 16
    //   4167: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   4170: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4173: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4176: pop
    //   4177: aload 14
    //   4179: ldc_w 577
    //   4182: aload 16
    //   4184: getfield 579	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   4187: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4190: pop
    //   4191: aload 14
    //   4193: ldc_w 581
    //   4196: aload 16
    //   4198: getfield 583	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   4201: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4204: pop
    //   4205: aload 14
    //   4207: ldc_w 585
    //   4210: ldc_w 587
    //   4213: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4216: pop
    //   4217: aload 14
    //   4219: ldc_w 589
    //   4222: aload 16
    //   4224: getfield 591	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   4227: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4230: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4233: pop
    //   4234: aload 14
    //   4236: ldc_w 596
    //   4239: aload 16
    //   4241: getfield 216	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   4244: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4247: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4250: pop
    //   4251: aload 14
    //   4253: ldc_w 598
    //   4256: aload 16
    //   4258: getfield 600	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   4261: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4264: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4267: pop
    //   4268: aload 14
    //   4270: ldc_w 602
    //   4273: aload 16
    //   4275: getfield 604	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   4278: invokestatic 568	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   4281: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4284: pop
    //   4285: aload 14
    //   4287: ldc_w 606
    //   4290: aload 16
    //   4292: getfield 297	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   4295: invokestatic 575	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4298: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4301: pop
    //   4302: aload 14
    //   4304: ldc_w 608
    //   4307: aload 16
    //   4309: getfield 295	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   4312: invokestatic 594	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4315: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4318: pop
    //   4319: aload 14
    //   4321: ldc_w 610
    //   4324: aload 16
    //   4326: getfield 612	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   4329: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4332: pop
    //   4333: aload 14
    //   4335: ldc_w 614
    //   4338: aload 16
    //   4340: getfield 616	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   4343: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4346: pop
    //   4347: aload 14
    //   4349: ldc_w 618
    //   4352: new 306	java/lang/StringBuilder
    //   4355: dup
    //   4356: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   4359: ldc_w 435
    //   4362: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: iload 6
    //   4367: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4370: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4373: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4376: pop
    //   4377: aload 14
    //   4379: ldc_w 620
    //   4382: new 306	java/lang/StringBuilder
    //   4385: dup
    //   4386: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   4389: ldc_w 435
    //   4392: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4395: iload 5
    //   4397: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4400: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4403: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4406: pop
    //   4407: aload 14
    //   4409: ldc_w 622
    //   4412: iload_2
    //   4413: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   4416: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4419: pop
    //   4420: aload 14
    //   4422: ldc_w 626
    //   4425: iload 10
    //   4427: invokestatic 624	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   4430: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4433: pop
    //   4434: iconst_1
    //   4435: istore 4
    //   4437: iload_2
    //   4438: ifeq +77 -> 4515
    //   4441: iconst_3
    //   4442: istore 4
    //   4444: aload 14
    //   4446: ldc_w 628
    //   4449: iload 4
    //   4451: invokestatic 630	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   4454: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4457: pop
    //   4458: aload 14
    //   4460: getstatic 635	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   4463: ldc_w 435
    //   4466: invokevirtual 518	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4469: pop
    //   4470: aload_0
    //   4471: getfield 92	com/tencent/mobileqq/msf/core/g:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4474: getfield 552	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   4477: ldc_w 637
    //   4480: aload 16
    //   4482: getfield 491	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   4485: aload 16
    //   4487: getfield 489	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   4490: lconst_0
    //   4491: aload 14
    //   4493: iconst_0
    //   4494: iconst_0
    //   4495: invokevirtual 642	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   4498: iload 9
    //   4500: ifeq +13 -> 4513
    //   4503: invokestatic 239	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4506: aload_1
    //   4507: aconst_null
    //   4508: aload 16
    //   4510: invokevirtual 242	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   4513: aload_3
    //   4514: athrow
    //   4515: iload 10
    //   4517: ifeq -73 -> 4444
    //   4520: iconst_5
    //   4521: istore 4
    //   4523: goto -79 -> 4444
    //   4526: iload 10
    //   4528: ifeq -530 -> 3998
    //   4531: iconst_5
    //   4532: istore 4
    //   4534: goto -536 -> 3998
    //   4537: iload 10
    //   4539: ifeq -3799 -> 740
    //   4542: iconst_5
    //   4543: istore 4
    //   4545: goto -3805 -> 740
    //   4548: iload 10
    //   4550: ifeq -3056 -> 1494
    //   4553: iconst_5
    //   4554: istore 4
    //   4556: goto -3062 -> 1494
    //   4559: iload 10
    //   4561: ifeq -2576 -> 1985
    //   4564: iconst_5
    //   4565: istore 4
    //   4567: goto -2582 -> 1985
    //   4570: iload 10
    //   4572: ifeq -2086 -> 2486
    //   4575: iconst_5
    //   4576: istore 4
    //   4578: goto -2092 -> 2486
    //   4581: iload 10
    //   4583: ifeq -1547 -> 3036
    //   4586: iconst_5
    //   4587: istore 4
    //   4589: goto -1553 -> 3036
    //   4592: iload 10
    //   4594: ifeq -1091 -> 3503
    //   4597: iconst_5
    //   4598: istore 4
    //   4600: goto -1097 -> 3503
    //   4603: astore_3
    //   4604: goto -536 -> 4068
    //   4607: astore_3
    //   4608: goto -540 -> 4068
    //   4611: astore_3
    //   4612: goto -1052 -> 3560
    //   4615: iconst_m1
    //   4616: istore 7
    //   4618: iload 4
    //   4620: istore 6
    //   4622: iload 5
    //   4624: istore 4
    //   4626: iload 7
    //   4628: istore 5
    //   4630: goto -4546 -> 84
    //   4633: iconst_0
    //   4634: istore 4
    //   4636: goto -4595 -> 41
    //   4639: iconst_m1
    //   4640: istore 5
    //   4642: iconst_0
    //   4643: istore 6
    //   4645: iconst_0
    //   4646: istore 4
    //   4648: goto -4564 -> 84
    //   4651: iload 6
    //   4653: iconst_1
    //   4654: if_icmpne -3112 -> 1542
    //   4657: iconst_1
    //   4658: istore 8
    //   4660: goto -3608 -> 1052
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4663	0	this	g
    //   0	4663	1	paramToServiceMsg	ToServiceMsg
    //   0	4663	2	paramBoolean	boolean
    //   0	4663	3	paramObject	Object
    //   39	4608	4	i1	int
    //   8	4633	5	i2	int
    //   74	4581	6	i3	int
    //   70	4557	7	i4	int
    //   396	4263	8	bool1	boolean
    //   364	4135	9	bool2	boolean
    //   137	4456	10	bool3	boolean
    //   2673	1386	11	bool4	boolean
    //   783	1747	12	l1	long
    //   151	4341	14	localObject	Object
    //   1001	19	15	str1	String
    //   91	4418	16	localf	f
    //   320	1237	17	arrayOfByte	byte[]
    //   962	597	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   315	322	3556	java/lang/Throwable
    //   327	363	3556	java/lang/Throwable
    //   957	998	3556	java/lang/Throwable
    //   1006	1019	3556	java/lang/Throwable
    //   1022	1049	3556	java/lang/Throwable
    //   1052	1076	3556	java/lang/Throwable
    //   1081	1117	3556	java/lang/Throwable
    //   1548	1568	3556	java/lang/Throwable
    //   1572	1608	3556	java/lang/Throwable
    //   2033	2059	3556	java/lang/Throwable
    //   2063	2069	3556	java/lang/Throwable
    //   2073	2109	3556	java/lang/Throwable
    //   2534	2557	3556	java/lang/Throwable
    //   2561	2608	3556	java/lang/Throwable
    //   2608	2624	3556	java/lang/Throwable
    //   3109	3145	3556	java/lang/Throwable
    //   315	322	4064	finally
    //   327	363	4064	finally
    //   957	998	4064	finally
    //   1006	1019	4064	finally
    //   1022	1049	4064	finally
    //   1052	1076	4064	finally
    //   1081	1117	4064	finally
    //   1548	1568	4064	finally
    //   1572	1608	4064	finally
    //   2033	2059	4064	finally
    //   2063	2069	4064	finally
    //   2073	2109	4064	finally
    //   2534	2557	4064	finally
    //   2561	2608	4064	finally
    //   2608	2624	4064	finally
    //   3109	3145	4064	finally
    //   2629	2666	4603	finally
    //   2666	2672	4603	finally
    //   3560	3634	4607	finally
    //   2629	2666	4611	java/lang/Throwable
    //   2666	2672	4611	java/lang/Throwable
  }
  
  public void b()
  {
    if (!this.u.isEmpty())
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
        if (localToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp")) {
          localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
        }
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if (paramToServiceMsg.getRequestSsoSeq() == localToServiceMsg.getRequestSsoSeq()) {
        localIterator.remove();
      }
    }
  }
  
  public boolean c(ToServiceMsg paramToServiceMsg)
  {
    return a(paramToServiceMsg, false, null);
  }
  
  static class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = (paramString + "-pool-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
  
  class b
    implements Runnable
  {
    public ToServiceMsg a;
    
    b(ToServiceMsg paramToServiceMsg)
    {
      this.a = paramToServiceMsg;
    }
    
    public void run()
    {
      do
      {
        try
        {
          if ((g.a(g.this) != null) && (g.a(g.this).mMsfMonitorCallback != null)) {
            g.a(g.this).mMsfMonitorCallback.handleStart(3);
          }
          Object localObject1 = Thread.currentThread().getName();
          int i = g.b(g.this).getActiveCount();
          if (QLog.isColorLevel()) {
            QLog.d("LightSender", 2, "threadName: " + (String)localObject1 + " threadPoolAccount: " + i);
          }
          localObject1 = this.a;
          if (localObject1 == null) {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.d("LightSender", 1, "LightSender sendTask exception,", localException);
          return;
        }
        finally
        {
          if ((g.a(g.this) == null) || (g.a(g.this).mMsfMonitorCallback == null)) {
            break;
          }
          g.a(g.this).mMsfMonitorCallback.handleEnd(3);
        }
        g.c(g.this).add(this.a);
        com.tencent.mobileqq.a.a.a.a().c(this.a);
        g.this.c(this.a);
        g.this.b(this.a);
      } while ((g.a(g.this) == null) || (g.a(g.this).mMsfMonitorCallback == null));
      g.a(g.this).mMsfMonitorCallback.handleEnd(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g
 * JD-Core Version:    0.7.0.1
 */