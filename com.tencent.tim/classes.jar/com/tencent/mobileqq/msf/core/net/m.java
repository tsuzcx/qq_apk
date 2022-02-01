package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class m
{
  public static final int a = -100;
  public static final int b = -200;
  public static final int c = 20200918;
  public static final int q = 10000;
  public static ArrayList r = new ArrayList();
  private static final int u = 30000;
  private static final int v = 2048;
  private long A = 0L;
  private long B = 0L;
  private long C = SystemClock.uptimeMillis();
  private AtomicLong D = new AtomicLong();
  private AtomicLong E = new AtomicLong();
  private ReentrantLock F = new ReentrantLock();
  private Runnable G;
  private final int H;
  protected InetSocketAddress d;
  com.tencent.mobileqq.msf.core.d e;
  int f;
  int g = 30000;
  public h h;
  OutputStream i = null;
  public d j;
  a k = null;
  MsfSocketInputBuffer l = null;
  public String m = "";
  public int n = 0;
  public int o = 0;
  public int p = 0;
  MsfCore s;
  private AtomicInteger t = new AtomicInteger();
  private AtomicBoolean w = new AtomicBoolean();
  private AtomicBoolean x = new AtomicBoolean();
  private AtomicBoolean y = new AtomicBoolean();
  private ToServiceMsg z;
  
  public m(MsfCore paramMsfCore, int paramInt)
  {
    this.s = paramMsfCore;
    this.H = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    for (;;)
    {
      ToServiceMsg localToServiceMsg;
      try
      {
        localToServiceMsg = new ToServiceMsg("", "0", "MSF");
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
        long l1 = com.tencent.mobileqq.msf.core.a.a.u();
        if (l1 > 10000L)
        {
          localToServiceMsg.setTimeout(l1);
          break label434;
          String str1;
          QLog.d("Crypt.ping.", 1, "ssoping cmd:" + str1 + " seq: " + localToServiceMsg.getRequestSsoSeq() + " timeout: " + localToServiceMsg.getTimeout());
          int i1 = str1.getBytes().length + 13 + 1 + 0 + 4;
          int i2 = StringUtils.str2Int(MsfService.getCore().getAccountCenter().i(), 0);
          byte b1 = (byte)(str1.getBytes().length + 1);
          Object localObject = ByteBuffer.allocate(i1);
          ((ByteBuffer)localObject).putInt(i1).putInt(20200918).putInt(i2).put(b1).put(str1.getBytes()).put((byte)5).putInt(0);
          localObject = ((ByteBuffer)localObject).array();
          if (QLog.isColorLevel()) {
            QLog.d("Crypt.ping.", 2, "sendSSOPing, cmd = " + str1 + ", uin = " + i2 + ", s = " + StringUtils.bytes2Str((byte[])localObject));
          }
          localToServiceMsg.putWupBuffer((byte[])localObject);
          this.z = localToServiceMsg;
          this.s.sender.c(localToServiceMsg);
          localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
          if (a(this.s.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) > 0) {
            com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg);
          }
        }
        else
        {
          localToServiceMsg.setTimeout(10000L);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("Crypt.ping.", 1, "send SSOPing pkg fail, exception ", localException);
        return;
      }
      label434:
      do
      {
        str2 = "GWv4";
        break;
        this.s.sender.c(localToServiceMsg.getRequestSsoSeq());
        this.s.sender.d(localToServiceMsg);
        QLog.d("Crypt.ping.", 1, "send SSOPing pkg fail");
        b(com.tencent.qphone.base.a.C);
        return;
      } while (paramBoolean);
      String str2 = "MSF";
    }
  }
  
  private void n()
  {
    if ((this.s != null) && (this.s.pushManager != null) && (this.s.pushManager.as != null))
    {
      this.s.sendSsoMsg(this.s.pushManager.as);
      this.s.pushManager.as = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws IOException
  {
    if ((this.x.get()) || (!this.w.get()) || (this.j == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramString3 = this.j.a(this.e, paramString1, paramString2, paramArrayOfByte);
      if (paramString2.equals("SSO.LoginMerge"))
      {
        if (!this.s.sender.r)
        {
          paramString1 = (ArrayList)this.s.sender.e.remove(Integer.valueOf(paramInt3));
          QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
          if (paramString1 != null)
          {
            paramString1 = paramString1.iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Integer)paramString1.next();
              paramString2 = this.s.sender.c(paramString2.intValue());
              this.s.sender.b(paramString2);
            }
          }
          return -200;
        }
        if (paramToServiceMsg != null) {
          this.s.sender.a(paramToServiceMsg, this.h.hashCode());
        }
        label244:
        if ((!ak.s) || (!f.a())) {
          break label560;
        }
        QLog.d("MSF.C.NetConnTag", 1, "send data in socket adaptor way");
      }
      for (;;)
      {
        try
        {
          if (this.s.sender.I != null) {
            this.s.sender.I.b().a(paramString3, this.h, paramInt3);
          }
          this.D.addAndGet(paramString3.length);
          paramString3 = new StringBuilder();
          if (!QLog.isDevelopLevel()) {
            break label579;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length + new StringBuilder().append(" ").append(Integer.toHexString(this.h.hashCode())).toString());
          break;
          if (paramString2.equals("RegPrxySvc.infoLogin"))
          {
            this.s.sender.a(paramToServiceMsg, this.h.hashCode());
            break label244;
          }
          if (paramString2.equals("RegPrxySvc.getOffMsg"))
          {
            this.s.sender.a(paramToServiceMsg, this.h.hashCode());
            break label244;
          }
          if (!paramString2.equals("RegPrxySvc.infoSync")) {
            break label244;
          }
          this.s.sender.a(paramToServiceMsg, this.h.hashCode());
        }
        catch (Exception paramMsfCommand)
        {
          QLog.d("MSF.C.NetConnTag", 1, "", paramMsfCommand);
          continue;
        }
        label560:
        this.i.write(paramString3);
        this.i.flush();
      }
      label579:
      QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(paramString2) + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString() + new StringBuilder().append(" ").append(Integer.toHexString(this.h.hashCode())).toString());
    }
  }
  
  public InetSocketAddress a()
  {
    return this.d;
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.msf.core.d paramd, d paramd1, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 106	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 108	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 108	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 542	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 364	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 284	com/tencent/mobileqq/msf/core/net/m:z	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 545	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   64: aload_0
    //   65: getfield 547	com/tencent/mobileqq/msf/core/net/m:G	Ljava/lang/Runnable;
    //   68: invokevirtual 550	com/tencent/mobileqq/msf/core/ak:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 384	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/d;
    //   81: aload_0
    //   82: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   85: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   88: aload_1
    //   89: invokevirtual 554	com/tencent/mobileqq/msf/core/d:j	()Z
    //   92: putfield 403	com/tencent/mobileqq/msf/core/ak:r	Z
    //   95: getstatic 559	com/tencent/mobileqq/msf/core/net/x:b	Lcom/tencent/mobileqq/msf/core/net/x;
    //   98: astore 14
    //   100: ldc 88
    //   102: astore 15
    //   104: aload_0
    //   105: lconst_0
    //   106: putfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   109: aload_0
    //   110: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: ldc2_w 560
    //   116: getstatic 567	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokevirtual 571	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   122: ifeq +2666 -> 2788
    //   125: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   128: lstore 8
    //   130: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   133: lstore 6
    //   135: aload_0
    //   136: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   139: putfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   142: invokestatic 581	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   145: iconst_0
    //   146: aload_1
    //   147: invokevirtual 584	com/tencent/mobileqq/a/a/a$c:a	(ZLcom/tencent/mobileqq/msf/core/d;)V
    //   150: aload 15
    //   152: astore 12
    //   154: lload 6
    //   156: lstore 4
    //   158: aload 14
    //   160: astore 11
    //   162: aload 15
    //   164: astore 13
    //   166: aload 14
    //   168: astore_2
    //   169: aload_0
    //   170: new 586	java/net/InetSocketAddress
    //   173: dup
    //   174: aload_1
    //   175: invokevirtual 588	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   178: aload_1
    //   179: invokevirtual 590	com/tencent/mobileqq/msf/core/d:f	()I
    //   182: invokespecial 593	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   185: putfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   188: aload 15
    //   190: astore 12
    //   192: lload 6
    //   194: lstore 4
    //   196: aload 14
    //   198: astore 11
    //   200: aload 15
    //   202: astore 13
    //   204: aload 14
    //   206: astore_2
    //   207: invokestatic 337	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   210: invokevirtual 595	com/tencent/mobileqq/a/a/a:c	()V
    //   213: aload 15
    //   215: astore 12
    //   217: lload 6
    //   219: lstore 4
    //   221: aload 14
    //   223: astore 11
    //   225: aload 15
    //   227: astore 13
    //   229: aload 14
    //   231: astore_2
    //   232: new 187	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   239: astore 17
    //   241: aload 15
    //   243: astore 12
    //   245: lload 6
    //   247: lstore 4
    //   249: aload 14
    //   251: astore 11
    //   253: aload 15
    //   255: astore 13
    //   257: aload 14
    //   259: astore_2
    //   260: ldc_w 597
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_1
    //   270: invokevirtual 598	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 602	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   277: invokestatic 607	com/tencent/mobileqq/msf/core/as:a	(Ljava/lang/String;)V
    //   280: aload 15
    //   282: astore 12
    //   284: lload 6
    //   286: lstore 4
    //   288: aload 14
    //   290: astore 11
    //   292: aload 15
    //   294: astore 13
    //   296: aload 14
    //   298: astore_2
    //   299: invokestatic 484	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   302: ifeq +2495 -> 2797
    //   305: aload 15
    //   307: astore 12
    //   309: lload 6
    //   311: lstore 4
    //   313: aload 14
    //   315: astore 11
    //   317: aload 15
    //   319: astore 13
    //   321: aload 14
    //   323: astore_2
    //   324: aload 17
    //   326: ldc_w 609
    //   329: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 598	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   336: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: astore 18
    //   341: aload 15
    //   343: astore 12
    //   345: lload 6
    //   347: lstore 4
    //   349: aload 14
    //   351: astore 11
    //   353: aload 15
    //   355: astore 13
    //   357: aload 14
    //   359: astore_2
    //   360: aload_1
    //   361: getfield 611	com/tencent/mobileqq/msf/core/d:h	Z
    //   364: ifeq +2425 -> 2789
    //   367: ldc_w 613
    //   370: astore 16
    //   372: aload 15
    //   374: astore 12
    //   376: lload 6
    //   378: lstore 4
    //   380: aload 14
    //   382: astore 11
    //   384: aload 15
    //   386: astore 13
    //   388: aload 14
    //   390: astore_2
    //   391: aload 18
    //   393: aload 16
    //   395: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 615
    //   401: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokestatic 620	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   407: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc_w 622
    //   413: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: astore 18
    //   418: aload 15
    //   420: astore 12
    //   422: lload 6
    //   424: lstore 4
    //   426: aload 14
    //   428: astore 11
    //   430: aload 15
    //   432: astore 13
    //   434: aload 14
    //   436: astore_2
    //   437: aload_1
    //   438: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   441: ifeq +4372 -> 4813
    //   444: ldc_w 629
    //   447: astore 16
    //   449: aload 15
    //   451: astore 12
    //   453: lload 6
    //   455: lstore 4
    //   457: aload 14
    //   459: astore 11
    //   461: aload 15
    //   463: astore 13
    //   465: aload 14
    //   467: astore_2
    //   468: ldc_w 419
    //   471: iconst_1
    //   472: aload 18
    //   474: aload 16
    //   476: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc_w 631
    //   482: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_1
    //   486: invokevirtual 633	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   489: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 15
    //   500: astore 12
    //   502: lload 6
    //   504: lstore 4
    //   506: aload 14
    //   508: astore 11
    //   510: aload 15
    //   512: astore 13
    //   514: aload 14
    //   516: astore_2
    //   517: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   520: lstore 6
    //   522: aload 15
    //   524: astore 12
    //   526: lload 6
    //   528: lstore 4
    //   530: aload 14
    //   532: astore 11
    //   534: aload 15
    //   536: astore 13
    //   538: aload 14
    //   540: astore_2
    //   541: aload_0
    //   542: new 635	com/tencent/mobileqq/msf/core/net/h
    //   545: dup
    //   546: invokespecial 636	com/tencent/mobileqq/msf/core/net/h:<init>	()V
    //   549: putfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   552: aload 15
    //   554: astore 12
    //   556: lload 6
    //   558: lstore 4
    //   560: aload 14
    //   562: astore 11
    //   564: aload 15
    //   566: astore 13
    //   568: aload 14
    //   570: astore_2
    //   571: aload_0
    //   572: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   575: sipush 10000
    //   578: invokevirtual 639	com/tencent/mobileqq/msf/core/net/h:setSoTimeout	(I)V
    //   581: aload 15
    //   583: astore 12
    //   585: lload 6
    //   587: lstore 4
    //   589: aload 14
    //   591: astore 11
    //   593: aload 15
    //   595: astore 13
    //   597: aload 14
    //   599: astore_2
    //   600: aload_0
    //   601: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   604: iconst_1
    //   605: invokevirtual 642	com/tencent/mobileqq/msf/core/net/h:setTcpNoDelay	(Z)V
    //   608: aload 15
    //   610: astore 12
    //   612: lload 6
    //   614: lstore 4
    //   616: aload 14
    //   618: astore 11
    //   620: aload 15
    //   622: astore 13
    //   624: aload 14
    //   626: astore_2
    //   627: aload_0
    //   628: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   631: iconst_1
    //   632: invokevirtual 645	com/tencent/mobileqq/msf/core/net/h:setKeepAlive	(Z)V
    //   635: aload 15
    //   637: astore 12
    //   639: lload 6
    //   641: lstore 4
    //   643: aload 14
    //   645: astore 11
    //   647: aload 15
    //   649: astore 13
    //   651: aload 14
    //   653: astore_2
    //   654: aload_0
    //   655: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   658: ifnull +65 -> 723
    //   661: aload 15
    //   663: astore 12
    //   665: lload 6
    //   667: lstore 4
    //   669: aload 14
    //   671: astore 11
    //   673: aload 15
    //   675: astore 13
    //   677: aload 14
    //   679: astore_2
    //   680: aload_0
    //   681: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   684: getfield 649	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   687: ifnull +36 -> 723
    //   690: aload 15
    //   692: astore 12
    //   694: lload 6
    //   696: lstore 4
    //   698: aload 14
    //   700: astore 11
    //   702: aload 15
    //   704: astore 13
    //   706: aload 14
    //   708: astore_2
    //   709: aload_0
    //   710: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   713: getfield 649	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   716: iconst_1
    //   717: invokeinterface 655 2 0
    //   722: pop
    //   723: aload 15
    //   725: astore 12
    //   727: lload 6
    //   729: lstore 4
    //   731: aload 14
    //   733: astore 11
    //   735: aload 15
    //   737: astore 13
    //   739: aload 14
    //   741: astore_2
    //   742: aload_0
    //   743: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   746: aload_0
    //   747: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   750: aload_1
    //   751: invokevirtual 657	com/tencent/mobileqq/msf/core/d:g	()I
    //   754: invokevirtual 661	com/tencent/mobileqq/msf/core/net/h:connect	(Ljava/net/SocketAddress;I)V
    //   757: aload 15
    //   759: astore 12
    //   761: lload 6
    //   763: lstore 4
    //   765: aload 14
    //   767: astore 11
    //   769: aload 15
    //   771: astore 13
    //   773: aload 14
    //   775: astore_2
    //   776: aload_0
    //   777: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   780: ifnull +65 -> 845
    //   783: aload 15
    //   785: astore 12
    //   787: lload 6
    //   789: lstore 4
    //   791: aload 14
    //   793: astore 11
    //   795: aload 15
    //   797: astore 13
    //   799: aload 14
    //   801: astore_2
    //   802: aload_0
    //   803: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   806: getfield 649	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   809: ifnull +36 -> 845
    //   812: aload 15
    //   814: astore 12
    //   816: lload 6
    //   818: lstore 4
    //   820: aload 14
    //   822: astore 11
    //   824: aload 15
    //   826: astore 13
    //   828: aload 14
    //   830: astore_2
    //   831: aload_0
    //   832: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   835: getfield 649	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   838: iconst_1
    //   839: invokeinterface 664 2 0
    //   844: pop
    //   845: aload 15
    //   847: astore 12
    //   849: lload 6
    //   851: lstore 4
    //   853: aload 14
    //   855: astore 11
    //   857: aload 15
    //   859: astore 13
    //   861: aload 14
    //   863: astore_2
    //   864: aload_0
    //   865: invokestatic 620	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   868: putfield 94	com/tencent/mobileqq/msf/core/net/m:o	I
    //   871: aload 15
    //   873: astore 12
    //   875: lload 6
    //   877: lstore 4
    //   879: aload 14
    //   881: astore 11
    //   883: aload 15
    //   885: astore 13
    //   887: aload 14
    //   889: astore_2
    //   890: aload_0
    //   891: aload_1
    //   892: invokevirtual 666	com/tencent/mobileqq/msf/core/d:d	()I
    //   895: putfield 96	com/tencent/mobileqq/msf/core/net/m:p	I
    //   898: aload 15
    //   900: astore 12
    //   902: lload 6
    //   904: lstore 4
    //   906: aload 14
    //   908: astore 11
    //   910: aload 15
    //   912: astore 13
    //   914: aload 14
    //   916: astore_2
    //   917: aload_3
    //   918: iconst_1
    //   919: putfield 670	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   922: aload 15
    //   924: astore 12
    //   926: lload 6
    //   928: lstore 4
    //   930: aload 14
    //   932: astore 11
    //   934: aload 15
    //   936: astore 13
    //   938: aload 14
    //   940: astore_2
    //   941: aload_3
    //   942: aload_3
    //   943: getfield 672	com/tencent/mobileqq/msf/core/net/a:j	I
    //   946: iconst_1
    //   947: iadd
    //   948: putfield 672	com/tencent/mobileqq/msf/core/net/a:j	I
    //   951: aload 15
    //   953: astore 12
    //   955: lload 6
    //   957: lstore 4
    //   959: aload 14
    //   961: astore 11
    //   963: aload 15
    //   965: astore 13
    //   967: aload 14
    //   969: astore_2
    //   970: aload_0
    //   971: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   974: putfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   977: aload 15
    //   979: astore 12
    //   981: lload 6
    //   983: lstore 4
    //   985: aload 14
    //   987: astore 11
    //   989: aload 15
    //   991: astore 13
    //   993: aload 14
    //   995: astore_2
    //   996: aload_0
    //   997: aload_0
    //   998: getfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1001: lload 6
    //   1003: lsub
    //   1004: putfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   1007: aload 15
    //   1009: astore 12
    //   1011: lload 6
    //   1013: lstore 4
    //   1015: aload 14
    //   1017: astore 11
    //   1019: aload 15
    //   1021: astore 13
    //   1023: aload 14
    //   1025: astore_2
    //   1026: aload_0
    //   1027: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1030: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   1033: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1036: astore 16
    //   1038: aload 15
    //   1040: astore 12
    //   1042: lload 6
    //   1044: lstore 4
    //   1046: aload 14
    //   1048: astore 11
    //   1050: aload 15
    //   1052: astore 13
    //   1054: aload 14
    //   1056: astore_2
    //   1057: aload 16
    //   1059: aload 16
    //   1061: getfield 679	com/tencent/mobileqq/msf/core/net/n:l	J
    //   1064: aload_0
    //   1065: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   1068: ladd
    //   1069: putfield 679	com/tencent/mobileqq/msf/core/net/n:l	J
    //   1072: aload 15
    //   1074: astore 12
    //   1076: lload 6
    //   1078: lstore 4
    //   1080: aload 14
    //   1082: astore 11
    //   1084: aload 15
    //   1086: astore 13
    //   1088: aload 14
    //   1090: astore_2
    //   1091: aload_0
    //   1092: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1095: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   1098: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1101: aload_0
    //   1102: getfield 138	com/tencent/mobileqq/msf/core/net/m:H	I
    //   1105: iconst_1
    //   1106: invokevirtual 682	com/tencent/mobileqq/msf/core/net/n:b	(IZ)V
    //   1109: aload 15
    //   1111: astore 12
    //   1113: lload 6
    //   1115: lstore 4
    //   1117: aload 14
    //   1119: astore 11
    //   1121: aload 15
    //   1123: astore 13
    //   1125: aload 14
    //   1127: astore_2
    //   1128: aload_0
    //   1129: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   1132: lconst_0
    //   1133: lcmp
    //   1134: ifge +27 -> 1161
    //   1137: aload 15
    //   1139: astore 12
    //   1141: lload 6
    //   1143: lstore 4
    //   1145: aload 14
    //   1147: astore 11
    //   1149: aload 15
    //   1151: astore 13
    //   1153: aload 14
    //   1155: astore_2
    //   1156: aload_0
    //   1157: lconst_0
    //   1158: putfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   1161: aload 15
    //   1163: astore 12
    //   1165: lload 6
    //   1167: lstore 4
    //   1169: aload 14
    //   1171: astore 11
    //   1173: aload 15
    //   1175: astore 13
    //   1177: aload 14
    //   1179: astore_2
    //   1180: aload_0
    //   1181: getfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1184: putstatic 685	com/tencent/mobileqq/msf/core/ak:U	J
    //   1187: aload 15
    //   1189: astore 12
    //   1191: lload 6
    //   1193: lstore 4
    //   1195: aload 14
    //   1197: astore 11
    //   1199: aload 15
    //   1201: astore 13
    //   1203: aload 14
    //   1205: astore_2
    //   1206: aload_0
    //   1207: getfield 127	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   1210: lconst_0
    //   1211: invokevirtual 687	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1214: aload 15
    //   1216: astore 12
    //   1218: lload 6
    //   1220: lstore 4
    //   1222: aload 14
    //   1224: astore 11
    //   1226: aload 15
    //   1228: astore 13
    //   1230: aload 14
    //   1232: astore_2
    //   1233: aload_0
    //   1234: getfield 129	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/atomic/AtomicLong;
    //   1237: lconst_0
    //   1238: invokevirtual 687	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1241: aload 15
    //   1243: astore 12
    //   1245: lload 6
    //   1247: lstore 4
    //   1249: aload 14
    //   1251: astore 11
    //   1253: aload 15
    //   1255: astore 13
    //   1257: aload 14
    //   1259: astore_2
    //   1260: aload_0
    //   1261: aload_0
    //   1262: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1265: invokevirtual 691	com/tencent/mobileqq/msf/core/net/h:getOutputStream	()Ljava/io/OutputStream;
    //   1268: putfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   1271: aload 15
    //   1273: astore 12
    //   1275: lload 6
    //   1277: lstore 4
    //   1279: aload 14
    //   1281: astore 11
    //   1283: aload 15
    //   1285: astore 13
    //   1287: aload 14
    //   1289: astore_2
    //   1290: getstatic 75	com/tencent/mobileqq/msf/core/net/m:r	Ljava/util/ArrayList;
    //   1293: aload_0
    //   1294: getfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   1297: invokevirtual 692	java/lang/Object:toString	()Ljava/lang/String;
    //   1300: invokevirtual 695	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1303: ifne +36 -> 1339
    //   1306: aload 15
    //   1308: astore 12
    //   1310: lload 6
    //   1312: lstore 4
    //   1314: aload 14
    //   1316: astore 11
    //   1318: aload 15
    //   1320: astore 13
    //   1322: aload 14
    //   1324: astore_2
    //   1325: getstatic 75	com/tencent/mobileqq/msf/core/net/m:r	Ljava/util/ArrayList;
    //   1328: aload_0
    //   1329: getfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   1332: invokevirtual 692	java/lang/Object:toString	()Ljava/lang/String;
    //   1335: invokevirtual 698	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1338: pop
    //   1339: aload 15
    //   1341: astore 12
    //   1343: lload 6
    //   1345: lstore 4
    //   1347: aload 14
    //   1349: astore 11
    //   1351: aload 15
    //   1353: astore 13
    //   1355: aload 14
    //   1357: astore_2
    //   1358: aload_0
    //   1359: new 700	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   1362: dup
    //   1363: aload_0
    //   1364: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1367: sipush 2048
    //   1370: ldc_w 702
    //   1373: iconst_m1
    //   1374: invokespecial 705	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   1377: putfield 86	com/tencent/mobileqq/msf/core/net/m:l	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   1380: aload 15
    //   1382: astore 12
    //   1384: lload 6
    //   1386: lstore 4
    //   1388: aload 14
    //   1390: astore 11
    //   1392: aload 15
    //   1394: astore 13
    //   1396: aload 14
    //   1398: astore_2
    //   1399: aload_0
    //   1400: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1403: ifnull +32 -> 1435
    //   1406: aload 15
    //   1408: astore 12
    //   1410: lload 6
    //   1412: lstore 4
    //   1414: aload 14
    //   1416: astore 11
    //   1418: aload 15
    //   1420: astore 13
    //   1422: aload 14
    //   1424: astore_2
    //   1425: aload_0
    //   1426: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1429: invokevirtual 708	com/tencent/mobileqq/msf/core/net/m$a:isAlive	()Z
    //   1432: ifne +1985 -> 3417
    //   1435: aload 15
    //   1437: astore 12
    //   1439: lload 6
    //   1441: lstore 4
    //   1443: aload 14
    //   1445: astore 11
    //   1447: aload 15
    //   1449: astore 13
    //   1451: aload 14
    //   1453: astore_2
    //   1454: aload_0
    //   1455: new 9	com/tencent/mobileqq/msf/core/net/m$b
    //   1458: dup
    //   1459: aload_0
    //   1460: invokespecial 711	com/tencent/mobileqq/msf/core/net/m$b:<init>	(Lcom/tencent/mobileqq/msf/core/net/m;)V
    //   1463: putfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1466: aload 15
    //   1468: astore 12
    //   1470: lload 6
    //   1472: lstore 4
    //   1474: aload 14
    //   1476: astore 11
    //   1478: aload 15
    //   1480: astore 13
    //   1482: aload 14
    //   1484: astore_2
    //   1485: aload_0
    //   1486: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1489: ldc_w 713
    //   1492: invokevirtual 716	com/tencent/mobileqq/msf/core/net/m$a:setName	(Ljava/lang/String;)V
    //   1495: aload 15
    //   1497: astore 12
    //   1499: lload 6
    //   1501: lstore 4
    //   1503: aload 14
    //   1505: astore 11
    //   1507: aload 15
    //   1509: astore 13
    //   1511: aload 14
    //   1513: astore_2
    //   1514: aload_0
    //   1515: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1518: invokevirtual 719	com/tencent/mobileqq/msf/core/net/m$a:start	()V
    //   1521: aload 15
    //   1523: astore 12
    //   1525: lload 6
    //   1527: lstore 4
    //   1529: aload 14
    //   1531: astore 11
    //   1533: aload 15
    //   1535: astore 13
    //   1537: aload 14
    //   1539: astore_2
    //   1540: aload_0
    //   1541: getfield 106	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1544: iconst_1
    //   1545: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1548: aload 15
    //   1550: astore 12
    //   1552: lload 6
    //   1554: lstore 4
    //   1556: aload 14
    //   1558: astore 11
    //   1560: aload 15
    //   1562: astore 13
    //   1564: aload 14
    //   1566: astore_2
    //   1567: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   1570: astore 14
    //   1572: ldc_w 723
    //   1575: astore 15
    //   1577: aload 15
    //   1579: astore 12
    //   1581: lload 6
    //   1583: lstore 4
    //   1585: aload 14
    //   1587: astore 11
    //   1589: aload 15
    //   1591: astore 13
    //   1593: aload 14
    //   1595: astore_2
    //   1596: invokestatic 725	com/tencent/mobileqq/msf/core/ak:h	()V
    //   1599: aload 15
    //   1601: astore 12
    //   1603: lload 6
    //   1605: lstore 4
    //   1607: aload 14
    //   1609: astore 11
    //   1611: aload 15
    //   1613: astore 13
    //   1615: aload 14
    //   1617: astore_2
    //   1618: aload_1
    //   1619: invokevirtual 727	com/tencent/mobileqq/msf/core/d:a	()Ljava/lang/String;
    //   1622: putstatic 729	com/tencent/mobileqq/msf/core/ak:E	Ljava/lang/String;
    //   1625: aload 15
    //   1627: astore 12
    //   1629: lload 6
    //   1631: lstore 4
    //   1633: aload 14
    //   1635: astore 11
    //   1637: aload 15
    //   1639: astore 13
    //   1641: aload 14
    //   1643: astore_2
    //   1644: new 187	java/lang/StringBuilder
    //   1647: dup
    //   1648: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1651: aload_0
    //   1652: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1655: invokevirtual 733	com/tencent/mobileqq/msf/core/net/h:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1658: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1661: ldc_w 738
    //   1664: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: aload_0
    //   1668: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1671: invokevirtual 741	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1674: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: putstatic 743	com/tencent/mobileqq/msf/core/ak:F	Ljava/lang/String;
    //   1683: aload 15
    //   1685: astore 12
    //   1687: lload 6
    //   1689: lstore 4
    //   1691: aload 14
    //   1693: astore 11
    //   1695: aload 15
    //   1697: astore 13
    //   1699: aload 14
    //   1701: astore_2
    //   1702: invokestatic 746	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   1705: putstatic 747	com/tencent/mobileqq/msf/core/ak:H	I
    //   1708: aload 15
    //   1710: astore 12
    //   1712: lload 6
    //   1714: lstore 4
    //   1716: aload 14
    //   1718: astore 11
    //   1720: aload 15
    //   1722: astore 13
    //   1724: aload 14
    //   1726: astore_2
    //   1727: aload_1
    //   1728: invokevirtual 748	com/tencent/mobileqq/msf/core/d:h	()V
    //   1731: aload 15
    //   1733: astore 12
    //   1735: lload 6
    //   1737: lstore 4
    //   1739: aload 14
    //   1741: astore 11
    //   1743: aload 15
    //   1745: astore 13
    //   1747: aload 14
    //   1749: astore_2
    //   1750: aload 17
    //   1752: iconst_0
    //   1753: aload 17
    //   1755: invokevirtual 751	java/lang/StringBuilder:length	()I
    //   1758: invokevirtual 755	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1761: pop
    //   1762: aload 15
    //   1764: astore 12
    //   1766: lload 6
    //   1768: lstore 4
    //   1770: aload 14
    //   1772: astore 11
    //   1774: aload 15
    //   1776: astore 13
    //   1778: aload 14
    //   1780: astore_2
    //   1781: invokestatic 484	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1784: ifeq +1723 -> 3507
    //   1787: aload 15
    //   1789: astore 12
    //   1791: lload 6
    //   1793: lstore 4
    //   1795: aload 14
    //   1797: astore 11
    //   1799: aload 15
    //   1801: astore 13
    //   1803: aload 14
    //   1805: astore_2
    //   1806: aload 17
    //   1808: ldc_w 757
    //   1811: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: aload_0
    //   1815: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   1818: invokevirtual 758	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1821: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc_w 760
    //   1827: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: aload_0
    //   1831: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   1834: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1837: ldc_w 762
    //   1840: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_1
    //   1844: invokevirtual 657	com/tencent/mobileqq/msf/core/d:g	()I
    //   1847: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1850: ldc_w 764
    //   1853: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: aload_0
    //   1857: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1860: invokevirtual 768	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   1863: invokevirtual 773	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1866: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: ldc_w 775
    //   1872: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload_0
    //   1876: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1879: invokevirtual 741	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1882: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1885: astore 17
    //   1887: aload 15
    //   1889: astore 12
    //   1891: lload 6
    //   1893: lstore 4
    //   1895: aload 14
    //   1897: astore 11
    //   1899: aload 15
    //   1901: astore 13
    //   1903: aload 14
    //   1905: astore_2
    //   1906: aload_1
    //   1907: getfield 611	com/tencent/mobileqq/msf/core/d:h	Z
    //   1910: ifeq +1589 -> 3499
    //   1913: ldc_w 613
    //   1916: astore 16
    //   1918: aload 15
    //   1920: astore 12
    //   1922: lload 6
    //   1924: lstore 4
    //   1926: aload 14
    //   1928: astore 11
    //   1930: aload 15
    //   1932: astore 13
    //   1934: aload 14
    //   1936: astore_2
    //   1937: aload 17
    //   1939: aload 16
    //   1941: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: ldc_w 622
    //   1947: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: astore 17
    //   1952: aload 15
    //   1954: astore 12
    //   1956: lload 6
    //   1958: lstore 4
    //   1960: aload 14
    //   1962: astore 11
    //   1964: aload 15
    //   1966: astore 13
    //   1968: aload 14
    //   1970: astore_2
    //   1971: aload_1
    //   1972: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1975: ifeq +2852 -> 4827
    //   1978: ldc_w 777
    //   1981: astore 16
    //   1983: aload 15
    //   1985: astore 12
    //   1987: lload 6
    //   1989: lstore 4
    //   1991: aload 14
    //   1993: astore 11
    //   1995: aload 15
    //   1997: astore 13
    //   1999: aload 14
    //   2001: astore_2
    //   2002: ldc_w 419
    //   2005: iconst_1
    //   2006: aload 17
    //   2008: aload 16
    //   2010: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: aload_0
    //   2014: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2017: invokevirtual 455	java/lang/Object:hashCode	()I
    //   2020: invokestatic 508	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   2023: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2032: aload 15
    //   2034: astore 12
    //   2036: lload 6
    //   2038: lstore 4
    //   2040: aload 14
    //   2042: astore 11
    //   2044: aload 15
    //   2046: astore 13
    //   2048: aload 14
    //   2050: astore_2
    //   2051: aload_0
    //   2052: getfield 101	com/tencent/mobileqq/msf/core/net/m:t	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2055: iconst_0
    //   2056: invokevirtual 779	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2059: aload 15
    //   2061: astore 12
    //   2063: lload 6
    //   2065: lstore 4
    //   2067: aload 14
    //   2069: astore 11
    //   2071: aload 15
    //   2073: astore 13
    //   2075: aload 14
    //   2077: astore_2
    //   2078: getstatic 460	com/tencent/mobileqq/msf/core/ak:s	Z
    //   2081: ifeq +134 -> 2215
    //   2084: aload 15
    //   2086: astore 12
    //   2088: lload 6
    //   2090: lstore 4
    //   2092: aload 14
    //   2094: astore 11
    //   2096: aload 15
    //   2098: astore 13
    //   2100: aload 14
    //   2102: astore_2
    //   2103: invokestatic 464	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   2106: istore 10
    //   2108: iload 10
    //   2110: ifeq +105 -> 2215
    //   2113: aload 15
    //   2115: astore 12
    //   2117: lload 6
    //   2119: lstore 4
    //   2121: aload 14
    //   2123: astore 11
    //   2125: aload 15
    //   2127: astore 13
    //   2129: aload 14
    //   2131: astore_2
    //   2132: ldc_w 419
    //   2135: iconst_1
    //   2136: ldc_w 781
    //   2139: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2142: aload 15
    //   2144: astore 12
    //   2146: lload 6
    //   2148: lstore 4
    //   2150: aload 14
    //   2152: astore 11
    //   2154: aload 15
    //   2156: astore 13
    //   2158: aload 14
    //   2160: astore_2
    //   2161: aload_0
    //   2162: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2165: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2168: getfield 469	com/tencent/mobileqq/msf/core/ak:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2171: ifnull +44 -> 2215
    //   2174: aload 15
    //   2176: astore 12
    //   2178: lload 6
    //   2180: lstore 4
    //   2182: aload 14
    //   2184: astore 11
    //   2186: aload 15
    //   2188: astore 13
    //   2190: aload 14
    //   2192: astore_2
    //   2193: aload_0
    //   2194: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2197: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2200: getfield 469	com/tencent/mobileqq/msf/core/ak:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2203: invokevirtual 472	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   2206: aload_0
    //   2207: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2210: invokeinterface 784 2 0
    //   2215: aload 15
    //   2217: astore 12
    //   2219: lload 6
    //   2221: lstore 4
    //   2223: aload 14
    //   2225: astore 11
    //   2227: aload 15
    //   2229: astore 13
    //   2231: aload 14
    //   2233: astore_2
    //   2234: aload_0
    //   2235: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2238: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2241: ifnull +167 -> 2408
    //   2244: aload 15
    //   2246: astore 12
    //   2248: lload 6
    //   2250: lstore 4
    //   2252: aload 14
    //   2254: astore 11
    //   2256: aload 15
    //   2258: astore 13
    //   2260: aload 14
    //   2262: astore_2
    //   2263: aload_0
    //   2264: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2267: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2270: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2273: ifnull +135 -> 2408
    //   2276: aload 15
    //   2278: astore 12
    //   2280: lload 6
    //   2282: lstore 4
    //   2284: aload 14
    //   2286: astore 11
    //   2288: aload 15
    //   2290: astore 13
    //   2292: aload 14
    //   2294: astore_2
    //   2295: aload_0
    //   2296: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2299: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2302: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2305: getfield 802	com/tencent/mobileqq/msf/core/c/k$c:e	J
    //   2308: lconst_0
    //   2309: lcmp
    //   2310: ifle +36 -> 2346
    //   2313: aload 15
    //   2315: astore 12
    //   2317: lload 6
    //   2319: lstore 4
    //   2321: aload 14
    //   2323: astore 11
    //   2325: aload 15
    //   2327: astore 13
    //   2329: aload 14
    //   2331: astore_2
    //   2332: aload_0
    //   2333: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2336: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2339: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2342: lconst_0
    //   2343: putfield 804	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   2346: aload 15
    //   2348: astore 12
    //   2350: lload 6
    //   2352: lstore 4
    //   2354: aload 14
    //   2356: astore 11
    //   2358: aload 15
    //   2360: astore 13
    //   2362: aload 14
    //   2364: astore_2
    //   2365: aload_0
    //   2366: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2369: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2372: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2375: lconst_0
    //   2376: putfield 806	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   2379: aload 15
    //   2381: astore 12
    //   2383: lload 6
    //   2385: lstore 4
    //   2387: aload 14
    //   2389: astore 11
    //   2391: aload 15
    //   2393: astore 13
    //   2395: aload 14
    //   2397: astore_2
    //   2398: ldc_w 419
    //   2401: iconst_1
    //   2402: ldc_w 808
    //   2405: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2408: aload_0
    //   2409: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   2412: invokevirtual 811	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2415: aload 14
    //   2417: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2420: if_acmpeq +18 -> 2438
    //   2423: aload_3
    //   2424: iconst_0
    //   2425: putfield 670	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2428: aload_3
    //   2429: aload_3
    //   2430: getfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2433: iconst_1
    //   2434: iadd
    //   2435: putfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2438: aload_3
    //   2439: aload 14
    //   2441: putfield 815	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2444: aload_3
    //   2445: ldc_w 723
    //   2448: putfield 817	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2451: aload_3
    //   2452: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   2455: lload 8
    //   2457: lsub
    //   2458: putfield 819	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2461: aload 14
    //   2463: astore 12
    //   2465: aload_0
    //   2466: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2469: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2472: ifnull +36 -> 2508
    //   2475: aload_0
    //   2476: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2479: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2482: astore_2
    //   2483: aload 12
    //   2485: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2488: if_acmpne +2091 -> 4579
    //   2491: iconst_1
    //   2492: istore 10
    //   2494: aload_2
    //   2495: iload 10
    //   2497: aload_0
    //   2498: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   2501: aload_1
    //   2502: invokevirtual 588	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2505: invokevirtual 822	com/tencent/mobileqq/msf/core/c/k:b	(ZJLjava/lang/String;)V
    //   2508: aload 12
    //   2510: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2513: if_acmpne +2159 -> 4672
    //   2516: aload_1
    //   2517: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2520: ifeq +16 -> 2536
    //   2523: invokestatic 581	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2526: iconst_1
    //   2527: invokevirtual 824	com/tencent/mobileqq/a/a/a$c:a	(Z)V
    //   2530: invokestatic 581	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2533: invokevirtual 826	com/tencent/mobileqq/a/a/a$c:b	()V
    //   2536: invokestatic 829	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	()V
    //   2539: invokestatic 832	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   2542: ifne +7 -> 2549
    //   2545: iconst_1
    //   2546: invokestatic 835	com/tencent/mobileqq/msf/core/NetConnInfoCenter:setNetSupport	(Z)V
    //   2549: invokestatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   2552: putstatic 840	com/tencent/mobileqq/msf/core/ak:G	I
    //   2555: aload_0
    //   2556: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2559: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2562: aconst_null
    //   2563: invokevirtual 842	com/tencent/mobileqq/msf/core/ak:a	([B)V
    //   2566: aload_0
    //   2567: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2570: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2573: invokevirtual 844	com/tencent/mobileqq/msf/core/ak:f	()V
    //   2576: getstatic 846	com/tencent/mobileqq/msf/core/ak:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2579: iconst_0
    //   2580: invokevirtual 779	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2583: getstatic 848	com/tencent/mobileqq/msf/core/ak:B	Ljava/util/ArrayList;
    //   2586: invokevirtual 851	java/util/ArrayList:clear	()V
    //   2589: aload_0
    //   2590: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2593: ifnull +195 -> 2788
    //   2596: aload_0
    //   2597: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2600: new 187	java/lang/StringBuilder
    //   2603: dup
    //   2604: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   2607: aload_0
    //   2608: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2611: invokevirtual 768	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   2614: invokevirtual 773	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2617: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: ldc_w 775
    //   2623: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2626: aload_0
    //   2627: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2630: invokevirtual 741	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   2633: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2636: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2639: putfield 854	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2642: invokestatic 337	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2645: aload_0
    //   2646: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2649: getstatic 840	com/tencent/mobileqq/msf/core/ak:G	I
    //   2652: aload_0
    //   2653: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   2656: l2i
    //   2657: invokevirtual 857	com/tencent/mobileqq/a/a/a:a	(Ljava/net/Socket;II)V
    //   2660: aload_0
    //   2661: getfield 110	com/tencent/mobileqq/msf/core/net/m:y	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2664: iconst_0
    //   2665: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2668: invokestatic 859	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   2671: ifeq +1955 -> 4626
    //   2674: aload_0
    //   2675: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2678: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2681: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2684: invokevirtual 861	com/tencent/mobileqq/msf/core/net/n:p	()Z
    //   2687: ifeq +1912 -> 4599
    //   2690: aload_0
    //   2691: invokevirtual 863	com/tencent/mobileqq/msf/core/net/m:j	()I
    //   2694: iconst_1
    //   2695: if_icmpne +1904 -> 4599
    //   2698: aload_0
    //   2699: iconst_1
    //   2700: invokespecial 865	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   2703: aload_0
    //   2704: invokespecial 867	com/tencent/mobileqq/msf/core/net/m:n	()V
    //   2707: invokestatic 869	com/tencent/mobileqq/msf/core/a/a:w	()Z
    //   2710: ifeq +1929 -> 4639
    //   2713: aload_0
    //   2714: aload_0
    //   2715: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2718: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2721: aload_0
    //   2722: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2725: invokevirtual 455	java/lang/Object:hashCode	()I
    //   2728: invokevirtual 872	com/tencent/mobileqq/msf/core/ak:a	(I)Ljava/lang/Runnable;
    //   2731: putfield 547	com/tencent/mobileqq/msf/core/net/m:G	Ljava/lang/Runnable;
    //   2734: aload_0
    //   2735: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   2738: invokevirtual 758	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2741: invokestatic 877	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   2744: putstatic 881	com/tencent/mobileqq/msf/core/push/e:d	J
    //   2747: aload_1
    //   2748: invokevirtual 588	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2751: aload_1
    //   2752: invokevirtual 590	com/tencent/mobileqq/msf/core/d:f	()I
    //   2755: getstatic 840	com/tencent/mobileqq/msf/core/ak:G	I
    //   2758: invokestatic 886	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;II)V
    //   2761: aload_0
    //   2762: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   2765: invokevirtual 758	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2768: aload_0
    //   2769: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2772: getfield 854	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2775: invokestatic 890	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   2778: aload_0
    //   2779: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2782: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   2785: invokevirtual 892	com/tencent/mobileqq/msf/core/ak:m	()V
    //   2788: return
    //   2789: ldc_w 894
    //   2792: astore 16
    //   2794: goto -2422 -> 372
    //   2797: aload 15
    //   2799: astore 12
    //   2801: lload 6
    //   2803: lstore 4
    //   2805: aload 14
    //   2807: astore 11
    //   2809: aload 15
    //   2811: astore 13
    //   2813: aload 14
    //   2815: astore_2
    //   2816: aload 17
    //   2818: ldc_w 609
    //   2821: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2824: aload_1
    //   2825: invokevirtual 598	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   2828: invokestatic 528	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2831: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2834: astore 18
    //   2836: aload 15
    //   2838: astore 12
    //   2840: lload 6
    //   2842: lstore 4
    //   2844: aload 14
    //   2846: astore 11
    //   2848: aload 15
    //   2850: astore 13
    //   2852: aload 14
    //   2854: astore_2
    //   2855: aload_1
    //   2856: getfield 611	com/tencent/mobileqq/msf/core/d:h	Z
    //   2859: ifeq +550 -> 3409
    //   2862: ldc_w 613
    //   2865: astore 16
    //   2867: aload 15
    //   2869: astore 12
    //   2871: lload 6
    //   2873: lstore 4
    //   2875: aload 14
    //   2877: astore 11
    //   2879: aload 15
    //   2881: astore 13
    //   2883: aload 14
    //   2885: astore_2
    //   2886: aload 18
    //   2888: aload 16
    //   2890: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: ldc_w 615
    //   2896: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: invokestatic 620	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   2902: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2905: ldc_w 622
    //   2908: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2911: astore 18
    //   2913: aload 15
    //   2915: astore 12
    //   2917: lload 6
    //   2919: lstore 4
    //   2921: aload 14
    //   2923: astore 11
    //   2925: aload 15
    //   2927: astore 13
    //   2929: aload 14
    //   2931: astore_2
    //   2932: aload_1
    //   2933: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2936: ifeq +1884 -> 4820
    //   2939: ldc_w 629
    //   2942: astore 16
    //   2944: aload 15
    //   2946: astore 12
    //   2948: lload 6
    //   2950: lstore 4
    //   2952: aload 14
    //   2954: astore 11
    //   2956: aload 15
    //   2958: astore 13
    //   2960: aload 14
    //   2962: astore_2
    //   2963: ldc_w 419
    //   2966: iconst_1
    //   2967: aload 18
    //   2969: aload 16
    //   2971: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2974: ldc_w 631
    //   2977: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2980: aload_1
    //   2981: invokevirtual 633	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   2984: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2987: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2990: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2993: goto -2495 -> 498
    //   2996: astore 16
    //   2998: aload 12
    //   3000: astore 13
    //   3002: aload 11
    //   3004: astore_2
    //   3005: aload_0
    //   3006: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   3009: lload 4
    //   3011: lsub
    //   3012: putfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   3015: aload 12
    //   3017: astore 13
    //   3019: aload 11
    //   3021: astore_2
    //   3022: aload_0
    //   3023: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3026: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   3029: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   3032: astore 14
    //   3034: aload 12
    //   3036: astore 13
    //   3038: aload 11
    //   3040: astore_2
    //   3041: aload 14
    //   3043: aload 14
    //   3045: getfield 679	com/tencent/mobileqq/msf/core/net/n:l	J
    //   3048: aload_0
    //   3049: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   3052: ladd
    //   3053: putfield 679	com/tencent/mobileqq/msf/core/net/n:l	J
    //   3056: aload 12
    //   3058: astore 13
    //   3060: aload 11
    //   3062: astore_2
    //   3063: aload_0
    //   3064: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3067: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   3070: ifnull +177 -> 3247
    //   3073: aload 12
    //   3075: astore 13
    //   3077: aload 11
    //   3079: astore_2
    //   3080: aload_0
    //   3081: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3084: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3087: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3090: ifnull +157 -> 3247
    //   3093: aload 12
    //   3095: astore 13
    //   3097: aload 11
    //   3099: astore_2
    //   3100: aload_0
    //   3101: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3104: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3107: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3110: getfield 802	com/tencent/mobileqq/msf/core/c/k$c:e	J
    //   3113: lconst_0
    //   3114: lcmp
    //   3115: ifle +51 -> 3166
    //   3118: aload 12
    //   3120: astore 13
    //   3122: aload 11
    //   3124: astore_2
    //   3125: aload_0
    //   3126: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3129: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3132: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3135: getfield 804	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3138: lconst_0
    //   3139: lcmp
    //   3140: ifne +26 -> 3166
    //   3143: aload 12
    //   3145: astore 13
    //   3147: aload 11
    //   3149: astore_2
    //   3150: aload_0
    //   3151: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3154: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3157: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3160: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   3163: putfield 804	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3166: aload 12
    //   3168: astore 13
    //   3170: aload 11
    //   3172: astore_2
    //   3173: aload_0
    //   3174: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3177: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3180: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3183: getfield 806	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3186: lconst_0
    //   3187: lcmp
    //   3188: ifne +59 -> 3247
    //   3191: aload 12
    //   3193: astore 13
    //   3195: aload 11
    //   3197: astore_2
    //   3198: aload_0
    //   3199: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3202: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3205: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3208: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   3211: putfield 806	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3214: aload 12
    //   3216: astore 13
    //   3218: aload 11
    //   3220: astore_2
    //   3221: ldc_w 419
    //   3224: iconst_1
    //   3225: iconst_2
    //   3226: anewarray 4	java/lang/Object
    //   3229: dup
    //   3230: iconst_0
    //   3231: ldc_w 896
    //   3234: aastore
    //   3235: dup
    //   3236: iconst_1
    //   3237: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   3240: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3243: aastore
    //   3244: invokestatic 899	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   3247: aload 12
    //   3249: astore 13
    //   3251: aload 11
    //   3253: astore_2
    //   3254: aload 16
    //   3256: invokevirtual 900	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3259: invokevirtual 903	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3262: astore 15
    //   3264: aload 15
    //   3266: astore 13
    //   3268: aload 11
    //   3270: astore_2
    //   3271: invokestatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   3274: ifne +523 -> 3797
    //   3277: aload 15
    //   3279: astore 13
    //   3281: aload 11
    //   3283: astore_2
    //   3284: getstatic 905	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3287: astore 12
    //   3289: aload 15
    //   3291: astore 13
    //   3293: aload 12
    //   3295: astore_2
    //   3296: aload 12
    //   3298: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3301: astore 11
    //   3303: aload 11
    //   3305: astore 13
    //   3307: aload 12
    //   3309: astore_2
    //   3310: aload_3
    //   3311: invokestatic 909	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3314: putfield 911	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3317: aload_0
    //   3318: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   3321: invokevirtual 811	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3324: aload 12
    //   3326: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3329: if_acmpeq +18 -> 3347
    //   3332: aload_3
    //   3333: iconst_0
    //   3334: putfield 670	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3337: aload_3
    //   3338: aload_3
    //   3339: getfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3342: iconst_1
    //   3343: iadd
    //   3344: putfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3347: aload_3
    //   3348: aload 12
    //   3350: putfield 815	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3353: aload_3
    //   3354: aload 11
    //   3356: putfield 817	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3359: aload_3
    //   3360: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   3363: lload 8
    //   3365: lsub
    //   3366: putfield 819	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3369: goto -904 -> 2465
    //   3372: astore_1
    //   3373: aload_3
    //   3374: iconst_0
    //   3375: putfield 670	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3378: aload_3
    //   3379: aload_3
    //   3380: getfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3383: iconst_1
    //   3384: iadd
    //   3385: putfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3388: aload_3
    //   3389: getstatic 913	com/tencent/mobileqq/msf/core/net/x:f	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3392: putfield 815	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3395: aload_3
    //   3396: aload_1
    //   3397: invokevirtual 914	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   3400: putfield 817	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3403: aload_3
    //   3404: lconst_0
    //   3405: putfield 819	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3408: return
    //   3409: ldc_w 894
    //   3412: astore 16
    //   3414: goto -547 -> 2867
    //   3417: aload 15
    //   3419: astore 12
    //   3421: lload 6
    //   3423: lstore 4
    //   3425: aload 14
    //   3427: astore 11
    //   3429: aload 15
    //   3431: astore 13
    //   3433: aload 14
    //   3435: astore_2
    //   3436: aload_0
    //   3437: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   3440: invokevirtual 916	com/tencent/mobileqq/msf/core/net/m$a:a	()V
    //   3443: goto -1922 -> 1521
    //   3446: astore_1
    //   3447: aload_0
    //   3448: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   3451: invokevirtual 811	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3454: aload_2
    //   3455: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3458: if_acmpeq +18 -> 3476
    //   3461: aload_3
    //   3462: iconst_0
    //   3463: putfield 670	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3466: aload_3
    //   3467: aload_3
    //   3468: getfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3471: iconst_1
    //   3472: iadd
    //   3473: putfield 813	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3476: aload_3
    //   3477: aload_2
    //   3478: putfield 815	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3481: aload_3
    //   3482: aload 13
    //   3484: putfield 817	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3487: aload_3
    //   3488: invokestatic 302	android/os/SystemClock:elapsedRealtime	()J
    //   3491: lload 8
    //   3493: lsub
    //   3494: putfield 819	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3497: aload_1
    //   3498: athrow
    //   3499: ldc_w 894
    //   3502: astore 16
    //   3504: goto -1586 -> 1918
    //   3507: aload 15
    //   3509: astore 12
    //   3511: lload 6
    //   3513: lstore 4
    //   3515: aload 14
    //   3517: astore 11
    //   3519: aload 15
    //   3521: astore 13
    //   3523: aload 14
    //   3525: astore_2
    //   3526: aload 17
    //   3528: ldc_w 757
    //   3531: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3534: aload_0
    //   3535: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   3538: invokevirtual 758	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   3541: invokestatic 528	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3544: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: ldc_w 760
    //   3550: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: aload_0
    //   3554: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   3557: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3560: ldc_w 762
    //   3563: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3566: aload_1
    //   3567: invokevirtual 657	com/tencent/mobileqq/msf/core/d:g	()I
    //   3570: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3573: ldc_w 764
    //   3576: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: aload_0
    //   3580: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3583: invokevirtual 768	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   3586: invokevirtual 773	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3589: invokestatic 528	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3592: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: ldc_w 775
    //   3598: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: aload_0
    //   3602: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3605: invokevirtual 741	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   3608: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3611: astore 17
    //   3613: aload 15
    //   3615: astore 12
    //   3617: lload 6
    //   3619: lstore 4
    //   3621: aload 14
    //   3623: astore 11
    //   3625: aload 15
    //   3627: astore 13
    //   3629: aload 14
    //   3631: astore_2
    //   3632: aload_1
    //   3633: getfield 611	com/tencent/mobileqq/msf/core/d:h	Z
    //   3636: ifeq +1199 -> 4835
    //   3639: ldc_w 613
    //   3642: astore 16
    //   3644: aload 15
    //   3646: astore 12
    //   3648: lload 6
    //   3650: lstore 4
    //   3652: aload 14
    //   3654: astore 11
    //   3656: aload 15
    //   3658: astore 13
    //   3660: aload 14
    //   3662: astore_2
    //   3663: aload 17
    //   3665: aload 16
    //   3667: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3670: ldc_w 622
    //   3673: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3676: astore 17
    //   3678: aload 15
    //   3680: astore 12
    //   3682: lload 6
    //   3684: lstore 4
    //   3686: aload 14
    //   3688: astore 11
    //   3690: aload 15
    //   3692: astore 13
    //   3694: aload 14
    //   3696: astore_2
    //   3697: aload_1
    //   3698: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   3701: ifeq +1142 -> 4843
    //   3704: ldc_w 777
    //   3707: astore 16
    //   3709: aload 15
    //   3711: astore 12
    //   3713: lload 6
    //   3715: lstore 4
    //   3717: aload 14
    //   3719: astore 11
    //   3721: aload 15
    //   3723: astore 13
    //   3725: aload 14
    //   3727: astore_2
    //   3728: ldc_w 419
    //   3731: iconst_1
    //   3732: aload 17
    //   3734: aload 16
    //   3736: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3739: aload_0
    //   3740: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3743: invokevirtual 455	java/lang/Object:hashCode	()I
    //   3746: invokestatic 508	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   3749: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3752: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3755: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3758: goto -1726 -> 2032
    //   3761: astore 16
    //   3763: aload 15
    //   3765: astore 12
    //   3767: lload 6
    //   3769: lstore 4
    //   3771: aload 14
    //   3773: astore 11
    //   3775: aload 15
    //   3777: astore 13
    //   3779: aload 14
    //   3781: astore_2
    //   3782: ldc_w 419
    //   3785: iconst_1
    //   3786: ldc_w 918
    //   3789: aload 16
    //   3791: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3794: goto -1579 -> 2215
    //   3797: aload 15
    //   3799: astore 13
    //   3801: aload 11
    //   3803: astore_2
    //   3804: aload 15
    //   3806: ldc_w 920
    //   3809: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3812: iconst_m1
    //   3813: if_icmple +32 -> 3845
    //   3816: aload 15
    //   3818: astore 13
    //   3820: aload 11
    //   3822: astore_2
    //   3823: getstatic 926	com/tencent/mobileqq/msf/core/net/x:g	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3826: astore 12
    //   3828: aload 15
    //   3830: astore 13
    //   3832: aload 12
    //   3834: astore_2
    //   3835: aload 12
    //   3837: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3840: astore 11
    //   3842: goto -525 -> 3317
    //   3845: aload 15
    //   3847: astore 13
    //   3849: aload 11
    //   3851: astore_2
    //   3852: aload 15
    //   3854: ldc_w 928
    //   3857: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3860: iconst_m1
    //   3861: if_icmple +32 -> 3893
    //   3864: aload 15
    //   3866: astore 13
    //   3868: aload 11
    //   3870: astore_2
    //   3871: getstatic 930	com/tencent/mobileqq/msf/core/net/x:q	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3874: astore 12
    //   3876: aload 15
    //   3878: astore 13
    //   3880: aload 12
    //   3882: astore_2
    //   3883: aload 12
    //   3885: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3888: astore 11
    //   3890: goto -573 -> 3317
    //   3893: aload 15
    //   3895: astore 13
    //   3897: aload 11
    //   3899: astore_2
    //   3900: aload 15
    //   3902: ldc_w 932
    //   3905: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3908: iconst_m1
    //   3909: if_icmple +46 -> 3955
    //   3912: aload 15
    //   3914: astore 13
    //   3916: aload 11
    //   3918: astore_2
    //   3919: getstatic 905	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3922: astore 12
    //   3924: aload 15
    //   3926: astore 13
    //   3928: aload 12
    //   3930: astore_2
    //   3931: aload 12
    //   3933: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3936: astore 11
    //   3938: aload 11
    //   3940: astore 13
    //   3942: aload 12
    //   3944: astore_2
    //   3945: aload_3
    //   3946: invokestatic 909	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3949: putfield 911	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3952: goto -635 -> 3317
    //   3955: aload 15
    //   3957: astore 13
    //   3959: aload 11
    //   3961: astore_2
    //   3962: aload 15
    //   3964: ldc_w 934
    //   3967: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3970: iconst_m1
    //   3971: if_icmple +32 -> 4003
    //   3974: aload 15
    //   3976: astore 13
    //   3978: aload 11
    //   3980: astore_2
    //   3981: getstatic 936	com/tencent/mobileqq/msf/core/net/x:i	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3984: astore 12
    //   3986: aload 15
    //   3988: astore 13
    //   3990: aload 12
    //   3992: astore_2
    //   3993: aload 12
    //   3995: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3998: astore 11
    //   4000: goto -683 -> 3317
    //   4003: aload 15
    //   4005: astore 13
    //   4007: aload 11
    //   4009: astore_2
    //   4010: aload 15
    //   4012: ldc_w 938
    //   4015: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4018: iconst_m1
    //   4019: if_icmple +32 -> 4051
    //   4022: aload 15
    //   4024: astore 13
    //   4026: aload 11
    //   4028: astore_2
    //   4029: getstatic 940	com/tencent/mobileqq/msf/core/net/x:s	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4032: astore 12
    //   4034: aload 15
    //   4036: astore 13
    //   4038: aload 12
    //   4040: astore_2
    //   4041: aload 12
    //   4043: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4046: astore 11
    //   4048: goto -731 -> 3317
    //   4051: aload 15
    //   4053: astore 13
    //   4055: aload 11
    //   4057: astore_2
    //   4058: aload 15
    //   4060: ldc_w 942
    //   4063: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4066: iconst_m1
    //   4067: if_icmple +32 -> 4099
    //   4070: aload 15
    //   4072: astore 13
    //   4074: aload 11
    //   4076: astore_2
    //   4077: getstatic 944	com/tencent/mobileqq/msf/core/net/x:r	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4080: astore 12
    //   4082: aload 15
    //   4084: astore 13
    //   4086: aload 12
    //   4088: astore_2
    //   4089: aload 12
    //   4091: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4094: astore 11
    //   4096: goto -779 -> 3317
    //   4099: aload 15
    //   4101: astore 13
    //   4103: aload 11
    //   4105: astore_2
    //   4106: aload 15
    //   4108: ldc_w 946
    //   4111: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4114: iconst_m1
    //   4115: if_icmpgt +22 -> 4137
    //   4118: aload 15
    //   4120: astore 13
    //   4122: aload 11
    //   4124: astore_2
    //   4125: aload 15
    //   4127: ldc_w 948
    //   4130: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4133: iconst_m1
    //   4134: if_icmple +32 -> 4166
    //   4137: aload 15
    //   4139: astore 13
    //   4141: aload 11
    //   4143: astore_2
    //   4144: getstatic 950	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4147: astore 12
    //   4149: aload 15
    //   4151: astore 13
    //   4153: aload 12
    //   4155: astore_2
    //   4156: aload 12
    //   4158: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4161: astore 11
    //   4163: goto -846 -> 3317
    //   4166: aload 15
    //   4168: astore 13
    //   4170: aload 11
    //   4172: astore_2
    //   4173: aload 15
    //   4175: ldc_w 952
    //   4178: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4181: iconst_m1
    //   4182: if_icmple +32 -> 4214
    //   4185: aload 15
    //   4187: astore 13
    //   4189: aload 11
    //   4191: astore_2
    //   4192: getstatic 954	com/tencent/mobileqq/msf/core/net/x:p	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4195: astore 12
    //   4197: aload 15
    //   4199: astore 13
    //   4201: aload 12
    //   4203: astore_2
    //   4204: aload 12
    //   4206: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4209: astore 11
    //   4211: goto -894 -> 3317
    //   4214: aload 15
    //   4216: astore 13
    //   4218: aload 11
    //   4220: astore_2
    //   4221: aload 15
    //   4223: ldc_w 956
    //   4226: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4229: iconst_m1
    //   4230: if_icmple +32 -> 4262
    //   4233: aload 15
    //   4235: astore 13
    //   4237: aload 11
    //   4239: astore_2
    //   4240: getstatic 958	com/tencent/mobileqq/msf/core/net/x:o	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4243: astore 12
    //   4245: aload 15
    //   4247: astore 13
    //   4249: aload 12
    //   4251: astore_2
    //   4252: aload 12
    //   4254: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4257: astore 11
    //   4259: goto -942 -> 3317
    //   4262: aload 15
    //   4264: astore 13
    //   4266: aload 11
    //   4268: astore_2
    //   4269: aload 15
    //   4271: ldc_w 960
    //   4274: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4277: iconst_m1
    //   4278: if_icmple +32 -> 4310
    //   4281: aload 15
    //   4283: astore 13
    //   4285: aload 11
    //   4287: astore_2
    //   4288: getstatic 962	com/tencent/mobileqq/msf/core/net/x:h	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4291: astore 12
    //   4293: aload 15
    //   4295: astore 13
    //   4297: aload 12
    //   4299: astore_2
    //   4300: aload 12
    //   4302: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4305: astore 11
    //   4307: goto -990 -> 3317
    //   4310: aload 15
    //   4312: astore 13
    //   4314: aload 11
    //   4316: astore_2
    //   4317: aload 15
    //   4319: ldc_w 964
    //   4322: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4325: iconst_m1
    //   4326: if_icmple +32 -> 4358
    //   4329: aload 15
    //   4331: astore 13
    //   4333: aload 11
    //   4335: astore_2
    //   4336: getstatic 966	com/tencent/mobileqq/msf/core/net/x:l	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4339: astore 12
    //   4341: aload 15
    //   4343: astore 13
    //   4345: aload 12
    //   4347: astore_2
    //   4348: aload 12
    //   4350: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4353: astore 11
    //   4355: goto -1038 -> 3317
    //   4358: aload 15
    //   4360: astore 13
    //   4362: aload 11
    //   4364: astore_2
    //   4365: aload 15
    //   4367: ldc_w 968
    //   4370: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4373: iconst_m1
    //   4374: if_icmple +32 -> 4406
    //   4377: aload 15
    //   4379: astore 13
    //   4381: aload 11
    //   4383: astore_2
    //   4384: getstatic 970	com/tencent/mobileqq/msf/core/net/x:j	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4387: astore 12
    //   4389: aload 15
    //   4391: astore 13
    //   4393: aload 12
    //   4395: astore_2
    //   4396: aload 12
    //   4398: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4401: astore 11
    //   4403: goto -1086 -> 3317
    //   4406: aload 15
    //   4408: astore 13
    //   4410: aload 11
    //   4412: astore_2
    //   4413: aload 15
    //   4415: ldc_w 972
    //   4418: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4421: iconst_m1
    //   4422: if_icmple +32 -> 4454
    //   4425: aload 15
    //   4427: astore 13
    //   4429: aload 11
    //   4431: astore_2
    //   4432: getstatic 950	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4435: astore 12
    //   4437: aload 15
    //   4439: astore 13
    //   4441: aload 12
    //   4443: astore_2
    //   4444: aload 12
    //   4446: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4449: astore 11
    //   4451: goto -1134 -> 3317
    //   4454: aload 15
    //   4456: astore 13
    //   4458: aload 11
    //   4460: astore_2
    //   4461: aload 15
    //   4463: ldc_w 974
    //   4466: invokevirtual 924	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4469: iconst_m1
    //   4470: if_icmple +32 -> 4502
    //   4473: aload 15
    //   4475: astore 13
    //   4477: aload 11
    //   4479: astore_2
    //   4480: getstatic 976	com/tencent/mobileqq/msf/core/net/x:n	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4483: astore 12
    //   4485: aload 15
    //   4487: astore 13
    //   4489: aload 12
    //   4491: astore_2
    //   4492: aload 12
    //   4494: invokevirtual 906	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4497: astore 11
    //   4499: goto -1182 -> 3317
    //   4502: aload 15
    //   4504: astore 13
    //   4506: aload 11
    //   4508: astore_2
    //   4509: getstatic 978	com/tencent/mobileqq/msf/core/net/x:u	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4512: astore 14
    //   4514: aload 15
    //   4516: astore 13
    //   4518: aload 14
    //   4520: astore_2
    //   4521: aload 16
    //   4523: invokestatic 982	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4526: astore 15
    //   4528: aload 15
    //   4530: astore 11
    //   4532: aload 14
    //   4534: astore 12
    //   4536: aload 15
    //   4538: astore 13
    //   4540: aload 14
    //   4542: astore_2
    //   4543: aload 15
    //   4545: invokevirtual 983	java/lang/String:length	()I
    //   4548: sipush 200
    //   4551: if_icmple -1234 -> 3317
    //   4554: aload 15
    //   4556: astore 13
    //   4558: aload 14
    //   4560: astore_2
    //   4561: aload 15
    //   4563: iconst_0
    //   4564: sipush 200
    //   4567: invokevirtual 987	java/lang/String:substring	(II)Ljava/lang/String;
    //   4570: astore 11
    //   4572: aload 14
    //   4574: astore 12
    //   4576: goto -1259 -> 3317
    //   4579: iconst_0
    //   4580: istore 10
    //   4582: goto -2088 -> 2494
    //   4585: astore_2
    //   4586: ldc_w 419
    //   4589: iconst_1
    //   4590: ldc_w 989
    //   4593: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4596: goto -2088 -> 2508
    //   4599: aload_0
    //   4600: iconst_0
    //   4601: invokespecial 865	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   4604: goto -1901 -> 2703
    //   4607: astore_2
    //   4608: aload_2
    //   4609: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   4612: ldc_w 419
    //   4615: iconst_1
    //   4616: ldc_w 991
    //   4619: aload_2
    //   4620: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4623: goto -1889 -> 2734
    //   4626: ldc_w 419
    //   4629: iconst_1
    //   4630: ldc_w 993
    //   4633: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4636: goto -1929 -> 2707
    //   4639: ldc_w 419
    //   4642: iconst_1
    //   4643: ldc_w 995
    //   4646: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4649: goto -1915 -> 2734
    //   4652: astore_2
    //   4653: ldc2_w 996
    //   4656: putstatic 881	com/tencent/mobileqq/msf/core/push/e:d	J
    //   4659: ldc_w 419
    //   4662: iconst_1
    //   4663: ldc_w 999
    //   4666: invokestatic 1001	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4669: goto -1922 -> 2747
    //   4672: aload 12
    //   4674: getstatic 721	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4677: if_acmpeq -1889 -> 2788
    //   4680: invokestatic 337	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4683: getstatic 840	com/tencent/mobileqq/msf/core/ak:G	I
    //   4686: aload_0
    //   4687: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   4690: aload 12
    //   4692: invokevirtual 1004	com/tencent/mobileqq/a/a/a:a	(IJLcom/tencent/mobileqq/msf/core/net/x;)V
    //   4695: new 187	java/lang/StringBuilder
    //   4698: dup
    //   4699: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   4702: ldc_w 1006
    //   4705: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: aload_0
    //   4709: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   4712: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4715: ldc_w 1008
    //   4718: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4721: aload_3
    //   4722: getfield 817	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   4725: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4728: ldc_w 1010
    //   4731: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4734: aload_0
    //   4735: getfield 114	com/tencent/mobileqq/msf/core/net/m:B	J
    //   4738: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4741: ldc_w 762
    //   4744: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4747: aload_1
    //   4748: invokevirtual 657	com/tencent/mobileqq/msf/core/d:g	()I
    //   4751: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4754: astore 11
    //   4756: aload_1
    //   4757: getfield 611	com/tencent/mobileqq/msf/core/d:h	Z
    //   4760: ifeq +91 -> 4851
    //   4763: ldc_w 613
    //   4766: astore_2
    //   4767: aload 11
    //   4769: aload_2
    //   4770: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4773: ldc_w 622
    //   4776: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4779: astore_2
    //   4780: aload_1
    //   4781: invokestatic 627	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   4784: ifeq +23 -> 4807
    //   4787: ldc_w 629
    //   4790: astore_1
    //   4791: ldc_w 419
    //   4794: iconst_1
    //   4795: aload_2
    //   4796: aload_1
    //   4797: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4800: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4803: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4806: return
    //   4807: ldc 148
    //   4809: astore_1
    //   4810: goto -19 -> 4791
    //   4813: ldc 148
    //   4815: astore 16
    //   4817: goto -4368 -> 449
    //   4820: ldc 148
    //   4822: astore 16
    //   4824: goto -1880 -> 2944
    //   4827: ldc_w 1012
    //   4830: astore 16
    //   4832: goto -2849 -> 1983
    //   4835: ldc_w 894
    //   4838: astore 16
    //   4840: goto -1196 -> 3644
    //   4843: ldc_w 1012
    //   4846: astore 16
    //   4848: goto -1139 -> 3709
    //   4851: ldc_w 894
    //   4854: astore_2
    //   4855: goto -88 -> 4767
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4858	0	this	m
    //   0	4858	1	paramd	com.tencent.mobileqq.msf.core.d
    //   0	4858	2	paramd1	d
    //   0	4858	3	parama	a
    //   156	3614	4	l1	long
    //   133	3635	6	l2	long
    //   128	3364	8	l3	long
    //   2106	2475	10	bool	boolean
    //   160	4608	11	localObject1	Object
    //   152	4539	12	localObject2	Object
    //   164	4393	13	localObject3	Object
    //   98	4475	14	localObject4	Object
    //   102	4460	15	str1	String
    //   370	2600	16	localObject5	Object
    //   2996	259	16	localThrowable	java.lang.Throwable
    //   3412	323	16	str2	String
    //   3761	761	16	localException	Exception
    //   4815	32	16	str3	String
    //   239	3494	17	localStringBuilder1	StringBuilder
    //   339	2629	18	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	188	2996	java/lang/Throwable
    //   207	213	2996	java/lang/Throwable
    //   232	241	2996	java/lang/Throwable
    //   260	280	2996	java/lang/Throwable
    //   299	305	2996	java/lang/Throwable
    //   324	341	2996	java/lang/Throwable
    //   360	367	2996	java/lang/Throwable
    //   391	418	2996	java/lang/Throwable
    //   437	444	2996	java/lang/Throwable
    //   468	498	2996	java/lang/Throwable
    //   517	522	2996	java/lang/Throwable
    //   541	552	2996	java/lang/Throwable
    //   571	581	2996	java/lang/Throwable
    //   600	608	2996	java/lang/Throwable
    //   627	635	2996	java/lang/Throwable
    //   654	661	2996	java/lang/Throwable
    //   680	690	2996	java/lang/Throwable
    //   709	723	2996	java/lang/Throwable
    //   742	757	2996	java/lang/Throwable
    //   776	783	2996	java/lang/Throwable
    //   802	812	2996	java/lang/Throwable
    //   831	845	2996	java/lang/Throwable
    //   864	871	2996	java/lang/Throwable
    //   890	898	2996	java/lang/Throwable
    //   917	922	2996	java/lang/Throwable
    //   941	951	2996	java/lang/Throwable
    //   970	977	2996	java/lang/Throwable
    //   996	1007	2996	java/lang/Throwable
    //   1026	1038	2996	java/lang/Throwable
    //   1057	1072	2996	java/lang/Throwable
    //   1091	1109	2996	java/lang/Throwable
    //   1128	1137	2996	java/lang/Throwable
    //   1156	1161	2996	java/lang/Throwable
    //   1180	1187	2996	java/lang/Throwable
    //   1206	1214	2996	java/lang/Throwable
    //   1233	1241	2996	java/lang/Throwable
    //   1260	1271	2996	java/lang/Throwable
    //   1290	1306	2996	java/lang/Throwable
    //   1325	1339	2996	java/lang/Throwable
    //   1358	1380	2996	java/lang/Throwable
    //   1399	1406	2996	java/lang/Throwable
    //   1425	1435	2996	java/lang/Throwable
    //   1454	1466	2996	java/lang/Throwable
    //   1485	1495	2996	java/lang/Throwable
    //   1514	1521	2996	java/lang/Throwable
    //   1540	1548	2996	java/lang/Throwable
    //   1567	1572	2996	java/lang/Throwable
    //   1596	1599	2996	java/lang/Throwable
    //   1618	1625	2996	java/lang/Throwable
    //   1644	1683	2996	java/lang/Throwable
    //   1702	1708	2996	java/lang/Throwable
    //   1727	1731	2996	java/lang/Throwable
    //   1750	1762	2996	java/lang/Throwable
    //   1781	1787	2996	java/lang/Throwable
    //   1806	1887	2996	java/lang/Throwable
    //   1906	1913	2996	java/lang/Throwable
    //   1937	1952	2996	java/lang/Throwable
    //   1971	1978	2996	java/lang/Throwable
    //   2002	2032	2996	java/lang/Throwable
    //   2051	2059	2996	java/lang/Throwable
    //   2078	2084	2996	java/lang/Throwable
    //   2103	2108	2996	java/lang/Throwable
    //   2132	2142	2996	java/lang/Throwable
    //   2161	2174	2996	java/lang/Throwable
    //   2193	2215	2996	java/lang/Throwable
    //   2234	2244	2996	java/lang/Throwable
    //   2263	2276	2996	java/lang/Throwable
    //   2295	2313	2996	java/lang/Throwable
    //   2332	2346	2996	java/lang/Throwable
    //   2365	2379	2996	java/lang/Throwable
    //   2398	2408	2996	java/lang/Throwable
    //   2816	2836	2996	java/lang/Throwable
    //   2855	2862	2996	java/lang/Throwable
    //   2886	2913	2996	java/lang/Throwable
    //   2932	2939	2996	java/lang/Throwable
    //   2963	2993	2996	java/lang/Throwable
    //   3436	3443	2996	java/lang/Throwable
    //   3526	3613	2996	java/lang/Throwable
    //   3632	3639	2996	java/lang/Throwable
    //   3663	3678	2996	java/lang/Throwable
    //   3697	3704	2996	java/lang/Throwable
    //   3728	3758	2996	java/lang/Throwable
    //   3782	3794	2996	java/lang/Throwable
    //   109	150	3372	java/lang/InterruptedException
    //   2408	2438	3372	java/lang/InterruptedException
    //   2438	2461	3372	java/lang/InterruptedException
    //   2465	2491	3372	java/lang/InterruptedException
    //   2494	2508	3372	java/lang/InterruptedException
    //   2508	2536	3372	java/lang/InterruptedException
    //   2536	2549	3372	java/lang/InterruptedException
    //   2549	2642	3372	java/lang/InterruptedException
    //   2642	2703	3372	java/lang/InterruptedException
    //   2703	2707	3372	java/lang/InterruptedException
    //   2707	2734	3372	java/lang/InterruptedException
    //   2734	2747	3372	java/lang/InterruptedException
    //   2747	2788	3372	java/lang/InterruptedException
    //   3317	3347	3372	java/lang/InterruptedException
    //   3347	3369	3372	java/lang/InterruptedException
    //   3447	3476	3372	java/lang/InterruptedException
    //   3476	3499	3372	java/lang/InterruptedException
    //   4586	4596	3372	java/lang/InterruptedException
    //   4599	4604	3372	java/lang/InterruptedException
    //   4608	4623	3372	java/lang/InterruptedException
    //   4626	4636	3372	java/lang/InterruptedException
    //   4639	4649	3372	java/lang/InterruptedException
    //   4653	4669	3372	java/lang/InterruptedException
    //   4672	4763	3372	java/lang/InterruptedException
    //   4767	4787	3372	java/lang/InterruptedException
    //   4791	4806	3372	java/lang/InterruptedException
    //   169	188	3446	finally
    //   207	213	3446	finally
    //   232	241	3446	finally
    //   260	280	3446	finally
    //   299	305	3446	finally
    //   324	341	3446	finally
    //   360	367	3446	finally
    //   391	418	3446	finally
    //   437	444	3446	finally
    //   468	498	3446	finally
    //   517	522	3446	finally
    //   541	552	3446	finally
    //   571	581	3446	finally
    //   600	608	3446	finally
    //   627	635	3446	finally
    //   654	661	3446	finally
    //   680	690	3446	finally
    //   709	723	3446	finally
    //   742	757	3446	finally
    //   776	783	3446	finally
    //   802	812	3446	finally
    //   831	845	3446	finally
    //   864	871	3446	finally
    //   890	898	3446	finally
    //   917	922	3446	finally
    //   941	951	3446	finally
    //   970	977	3446	finally
    //   996	1007	3446	finally
    //   1026	1038	3446	finally
    //   1057	1072	3446	finally
    //   1091	1109	3446	finally
    //   1128	1137	3446	finally
    //   1156	1161	3446	finally
    //   1180	1187	3446	finally
    //   1206	1214	3446	finally
    //   1233	1241	3446	finally
    //   1260	1271	3446	finally
    //   1290	1306	3446	finally
    //   1325	1339	3446	finally
    //   1358	1380	3446	finally
    //   1399	1406	3446	finally
    //   1425	1435	3446	finally
    //   1454	1466	3446	finally
    //   1485	1495	3446	finally
    //   1514	1521	3446	finally
    //   1540	1548	3446	finally
    //   1567	1572	3446	finally
    //   1596	1599	3446	finally
    //   1618	1625	3446	finally
    //   1644	1683	3446	finally
    //   1702	1708	3446	finally
    //   1727	1731	3446	finally
    //   1750	1762	3446	finally
    //   1781	1787	3446	finally
    //   1806	1887	3446	finally
    //   1906	1913	3446	finally
    //   1937	1952	3446	finally
    //   1971	1978	3446	finally
    //   2002	2032	3446	finally
    //   2051	2059	3446	finally
    //   2078	2084	3446	finally
    //   2103	2108	3446	finally
    //   2132	2142	3446	finally
    //   2161	2174	3446	finally
    //   2193	2215	3446	finally
    //   2234	2244	3446	finally
    //   2263	2276	3446	finally
    //   2295	2313	3446	finally
    //   2332	2346	3446	finally
    //   2365	2379	3446	finally
    //   2398	2408	3446	finally
    //   2816	2836	3446	finally
    //   2855	2862	3446	finally
    //   2886	2913	3446	finally
    //   2932	2939	3446	finally
    //   2963	2993	3446	finally
    //   3005	3015	3446	finally
    //   3022	3034	3446	finally
    //   3041	3056	3446	finally
    //   3063	3073	3446	finally
    //   3080	3093	3446	finally
    //   3100	3118	3446	finally
    //   3125	3143	3446	finally
    //   3150	3166	3446	finally
    //   3173	3191	3446	finally
    //   3198	3214	3446	finally
    //   3221	3247	3446	finally
    //   3254	3264	3446	finally
    //   3271	3277	3446	finally
    //   3284	3289	3446	finally
    //   3296	3303	3446	finally
    //   3310	3317	3446	finally
    //   3436	3443	3446	finally
    //   3526	3613	3446	finally
    //   3632	3639	3446	finally
    //   3663	3678	3446	finally
    //   3697	3704	3446	finally
    //   3728	3758	3446	finally
    //   3782	3794	3446	finally
    //   3804	3816	3446	finally
    //   3823	3828	3446	finally
    //   3835	3842	3446	finally
    //   3852	3864	3446	finally
    //   3871	3876	3446	finally
    //   3883	3890	3446	finally
    //   3900	3912	3446	finally
    //   3919	3924	3446	finally
    //   3931	3938	3446	finally
    //   3945	3952	3446	finally
    //   3962	3974	3446	finally
    //   3981	3986	3446	finally
    //   3993	4000	3446	finally
    //   4010	4022	3446	finally
    //   4029	4034	3446	finally
    //   4041	4048	3446	finally
    //   4058	4070	3446	finally
    //   4077	4082	3446	finally
    //   4089	4096	3446	finally
    //   4106	4118	3446	finally
    //   4125	4137	3446	finally
    //   4144	4149	3446	finally
    //   4156	4163	3446	finally
    //   4173	4185	3446	finally
    //   4192	4197	3446	finally
    //   4204	4211	3446	finally
    //   4221	4233	3446	finally
    //   4240	4245	3446	finally
    //   4252	4259	3446	finally
    //   4269	4281	3446	finally
    //   4288	4293	3446	finally
    //   4300	4307	3446	finally
    //   4317	4329	3446	finally
    //   4336	4341	3446	finally
    //   4348	4355	3446	finally
    //   4365	4377	3446	finally
    //   4384	4389	3446	finally
    //   4396	4403	3446	finally
    //   4413	4425	3446	finally
    //   4432	4437	3446	finally
    //   4444	4451	3446	finally
    //   4461	4473	3446	finally
    //   4480	4485	3446	finally
    //   4492	4499	3446	finally
    //   4509	4514	3446	finally
    //   4521	4528	3446	finally
    //   4543	4554	3446	finally
    //   4561	4572	3446	finally
    //   2132	2142	3761	java/lang/Exception
    //   2161	2174	3761	java/lang/Exception
    //   2193	2215	3761	java/lang/Exception
    //   2465	2491	4585	java/lang/Exception
    //   2494	2508	4585	java/lang/Exception
    //   2642	2703	4607	java/lang/Exception
    //   2703	2707	4607	java/lang/Exception
    //   2707	2734	4607	java/lang/Exception
    //   4599	4604	4607	java/lang/Exception
    //   4626	4636	4607	java/lang/Exception
    //   4639	4649	4607	java/lang/Exception
    //   2734	2747	4652	java/lang/Exception
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (this.o == 1)
    {
      int i1 = NetConnInfoCenter.getActiveNetworkType();
      if ((i1 == 2) || (i1 == 3)) {
        b(parama);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.y.set(paramBoolean);
  }
  
  public com.tencent.mobileqq.msf.core.d b()
  {
    return this.e;
  }
  
  /* Error */
  public void b(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 94	com/tencent/mobileqq/msf/core/net/m:o	I
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 96	com/tencent/mobileqq/msf/core/net/m:p	I
    //   10: aload_0
    //   11: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   14: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   17: iconst_0
    //   18: putfield 1015	com/tencent/mobileqq/msf/core/ak:q	Z
    //   21: aload_0
    //   22: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   25: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   28: iconst_0
    //   29: putfield 403	com/tencent/mobileqq/msf/core/ak:r	Z
    //   32: aload_0
    //   33: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   36: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   39: lconst_0
    //   40: putfield 1017	com/tencent/mobileqq/msf/core/ak:p	J
    //   43: aload_0
    //   44: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   47: ifnull +26 -> 73
    //   50: getstatic 1019	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   53: ifeq +20 -> 73
    //   56: aload_0
    //   57: getfield 532	com/tencent/mobileqq/msf/core/net/m:d	Ljava/net/InetSocketAddress;
    //   60: invokevirtual 758	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   63: invokestatic 877	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   66: putstatic 1021	com/tencent/mobileqq/msf/core/push/e:c	J
    //   69: iconst_0
    //   70: putstatic 1019	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   73: ldc_w 419
    //   76: iconst_1
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: invokestatic 1027	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   86: invokevirtual 1030	java/lang/Thread:getName	()Ljava/lang/String;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: new 187	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 1032
    //   102: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 899	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   120: astore 6
    //   122: getstatic 1035	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   125: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   128: ifnull +91 -> 219
    //   131: aload_0
    //   132: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   135: astore 6
    //   137: getstatic 1035	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   140: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   143: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   146: ifnull +73 -> 219
    //   149: aload_0
    //   150: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   153: astore 6
    //   155: getstatic 1035	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   158: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   161: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   164: getfield 806	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifne +50 -> 219
    //   172: aload_0
    //   173: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   176: astore 6
    //   178: getstatic 1035	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   181: getfield 792	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   184: getfield 798	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   187: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   190: putfield 806	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   193: ldc_w 419
    //   196: iconst_1
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: ldc_w 1037
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   212: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   215: aastore
    //   216: invokestatic 899	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   219: aload_0
    //   220: getfield 284	com/tencent/mobileqq/msf/core/net/m:z	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   223: ifnull +22 -> 245
    //   226: aload_0
    //   227: invokevirtual 545	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   230: pop
    //   231: aload_0
    //   232: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   235: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   238: aload_0
    //   239: getfield 547	com/tencent/mobileqq/msf/core/net/m:G	Ljava/lang/Runnable;
    //   242: invokevirtual 550	com/tencent/mobileqq/msf/core/ak:a	(Ljava/lang/Runnable;)V
    //   245: aload_0
    //   246: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   249: ifnonnull +63 -> 312
    //   252: ldc_w 419
    //   255: iconst_1
    //   256: new 187	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 1039
    //   266: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_1
    //   270: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: return
    //   280: astore 6
    //   282: ldc2_w 996
    //   285: putstatic 1021	com/tencent/mobileqq/msf/core/push/e:c	J
    //   288: ldc_w 419
    //   291: iconst_1
    //   292: ldc_w 1041
    //   295: invokestatic 1001	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: iconst_0
    //   299: putstatic 1019	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   302: goto -229 -> 73
    //   305: astore_1
    //   306: iconst_0
    //   307: putstatic 1019	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   310: aload_1
    //   311: athrow
    //   312: invokestatic 1044	com/tencent/mobileqq/msf/core/a/a:aI	()Z
    //   315: ifeq +552 -> 867
    //   318: getstatic 460	com/tencent/mobileqq/msf/core/ak:s	Z
    //   321: ifeq +50 -> 371
    //   324: invokestatic 464	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   327: ifeq +44 -> 371
    //   330: ldc_w 419
    //   333: iconst_1
    //   334: ldc_w 1046
    //   337: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_0
    //   341: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   344: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   347: getfield 469	com/tencent/mobileqq/msf/core/ak:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   350: ifnull +21 -> 371
    //   353: aload_0
    //   354: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   357: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   360: getfield 469	com/tencent/mobileqq/msf/core/ak:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   363: invokevirtual 472	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   366: invokeinterface 1047 1 0
    //   371: iconst_1
    //   372: istore_3
    //   373: invokestatic 1048	com/tencent/mobileqq/a/a/f:a	()V
    //   376: invokestatic 337	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   379: aload_1
    //   380: invokevirtual 1050	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/a;)V
    //   383: invokestatic 1055	com/tencent/mobileqq/a/a/a$b:a	()Lcom/tencent/mobileqq/a/a/a$b;
    //   386: aload_1
    //   387: invokevirtual 1056	com/tencent/mobileqq/a/a/a$b:a	(Lcom/tencent/qphone/base/a;)V
    //   390: invokestatic 1059	com/tencent/mobileqq/msf/core/a/a:aH	()Z
    //   393: ifeq +6 -> 399
    //   396: invokestatic 1062	com/tencent/mobileqq/a/a/d:a	()V
    //   399: aload_0
    //   400: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   403: invokevirtual 1063	com/tencent/mobileqq/msf/core/net/h:toString	()Ljava/lang/String;
    //   406: astore 6
    //   408: aload_0
    //   409: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   412: ldc2_w 560
    //   415: getstatic 567	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   418: invokevirtual 571	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   421: istore_2
    //   422: iload_2
    //   423: ifeq +515 -> 938
    //   426: aload_0
    //   427: getfield 101	com/tencent/mobileqq/msf/core/net/m:t	Ljava/util/concurrent/atomic/AtomicInteger;
    //   430: iconst_0
    //   431: invokevirtual 779	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   434: aload_0
    //   435: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   438: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   441: aconst_null
    //   442: invokevirtual 842	com/tencent/mobileqq/msf/core/ak:a	([B)V
    //   445: aload_0
    //   446: getfield 106	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   449: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   452: istore_2
    //   453: aload_0
    //   454: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   457: ifnull +14 -> 471
    //   460: aload_0
    //   461: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   464: getfield 1065	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   467: iconst_0
    //   468: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   471: aload_0
    //   472: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   475: invokevirtual 1069	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   478: ifnull +13 -> 491
    //   481: aload_0
    //   482: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   485: invokevirtual 1069	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   488: invokevirtual 1074	java/io/InputStream:close	()V
    //   491: aload_0
    //   492: getfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   495: astore 7
    //   497: aload 7
    //   499: ifnull +24 -> 523
    //   502: getstatic 75	com/tencent/mobileqq/msf/core/net/m:r	Ljava/util/ArrayList;
    //   505: aload_0
    //   506: getfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   509: invokevirtual 692	java/lang/Object:toString	()Ljava/lang/String;
    //   512: invokevirtual 1076	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   515: pop
    //   516: aload_0
    //   517: getfield 82	com/tencent/mobileqq/msf/core/net/m:i	Ljava/io/OutputStream;
    //   520: invokevirtual 1077	java/io/OutputStream:close	()V
    //   523: aload_0
    //   524: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   527: astore 7
    //   529: aload 7
    //   531: ifnull +30 -> 561
    //   534: aload_0
    //   535: getfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   538: invokevirtual 1078	com/tencent/mobileqq/msf/core/net/h:close	()V
    //   541: aload_1
    //   542: invokestatic 1081	com/tencent/mobileqq/msf/core/aq:a	(Lcom/tencent/qphone/base/a;)V
    //   545: aload_0
    //   546: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   549: invokevirtual 1085	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   552: invokevirtual 1088	com/tencent/mobileqq/msf/core/d/a:f	()V
    //   555: getstatic 75	com/tencent/mobileqq/msf/core/net/m:r	Ljava/util/ArrayList;
    //   558: invokevirtual 851	java/util/ArrayList:clear	()V
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 452	com/tencent/mobileqq/msf/core/net/m:h	Lcom/tencent/mobileqq/msf/core/net/h;
    //   566: aload_0
    //   567: getfield 106	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   570: iconst_0
    //   571: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 384	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/d;
    //   579: aload_0
    //   580: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   583: invokevirtual 811	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   586: aload_0
    //   587: getfield 108	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   590: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   593: ifne -314 -> 279
    //   596: iload_2
    //   597: ifeq -318 -> 279
    //   600: aload_0
    //   601: getfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   604: lconst_0
    //   605: lcmp
    //   606: ifle +120 -> 726
    //   609: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   612: aload_0
    //   613: getfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   616: lsub
    //   617: lstore 4
    //   619: aload_0
    //   620: lconst_0
    //   621: putfield 112	com/tencent/mobileqq/msf/core/net/m:A	J
    //   624: aload_0
    //   625: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   628: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   631: invokevirtual 1090	com/tencent/mobileqq/msf/core/ak:e	()[B
    //   634: invokestatic 1095	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   637: astore 7
    //   639: invokestatic 1098	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   642: astore 8
    //   644: aload_0
    //   645: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   648: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   651: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   654: invokevirtual 1100	com/tencent/mobileqq/msf/core/net/n:g	()V
    //   657: aload_0
    //   658: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   661: getfield 288	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
    //   664: getfield 675	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   667: lconst_0
    //   668: putfield 1102	com/tencent/mobileqq/msf/core/net/n:m	J
    //   671: aload_0
    //   672: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   675: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   678: ifnull +48 -> 726
    //   681: aload_0
    //   682: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   685: invokevirtual 788	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   688: iconst_0
    //   689: lload 4
    //   691: ldc2_w 1103
    //   694: ldiv
    //   695: aload_0
    //   696: getfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   699: aload_1
    //   700: getstatic 747	com/tencent/mobileqq/msf/core/ak:H	I
    //   703: lload 4
    //   705: aload_0
    //   706: getfield 127	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   709: invokevirtual 1106	java/util/concurrent/atomic/AtomicLong:get	()J
    //   712: aload_0
    //   713: getfield 129	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/atomic/AtomicLong;
    //   716: invokevirtual 1106	java/util/concurrent/atomic/AtomicLong:get	()J
    //   719: aload 7
    //   721: aload 8
    //   723: invokevirtual 1109	com/tencent/mobileqq/msf/core/c/k:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   726: invokestatic 484	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   729: ifeq +278 -> 1007
    //   732: ldc_w 419
    //   735: iconst_1
    //   736: new 187	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 1111
    //   746: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 6
    //   751: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: ldc_w 1113
    //   757: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload_1
    //   761: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   770: aload_0
    //   771: getfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   774: ifnull +28 -> 802
    //   777: aload_0
    //   778: getfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   781: aload_1
    //   782: invokevirtual 1116	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   785: ifeq +17 -> 802
    //   788: aload_0
    //   789: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   792: invokevirtual 1120	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/c;
    //   795: aload_0
    //   796: getfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   799: invokevirtual 1125	com/tencent/mobileqq/msf/core/a/c:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   802: ldc_w 775
    //   805: putstatic 729	com/tencent/mobileqq/msf/core/ak:E	Ljava/lang/String;
    //   808: ldc 148
    //   810: putstatic 743	com/tencent/mobileqq/msf/core/ak:F	Ljava/lang/String;
    //   813: aload_0
    //   814: aconst_null
    //   815: putfield 389	com/tencent/mobileqq/msf/core/net/m:e	Lcom/tencent/mobileqq/msf/core/d;
    //   818: aload_0
    //   819: getfield 136	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   822: aconst_null
    //   823: putfield 854	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   826: aload_0
    //   827: getfield 127	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   830: lconst_0
    //   831: invokevirtual 687	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   834: aload_0
    //   835: getfield 129	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/atomic/AtomicLong;
    //   838: lconst_0
    //   839: invokevirtual 687	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   842: invokestatic 1130	com/tencent/qphone/base/util/CodecWarpper:nativeOnConnClose	()V
    //   845: aload_1
    //   846: invokestatic 1133	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   849: return
    //   850: astore 6
    //   852: getstatic 1137	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   855: iconst_1
    //   856: ldc_w 1139
    //   859: aload 6
    //   861: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   864: goto -493 -> 371
    //   867: iconst_0
    //   868: putstatic 460	com/tencent/mobileqq/msf/core/ak:s	Z
    //   871: goto -500 -> 371
    //   874: astore 7
    //   876: aload 7
    //   878: invokevirtual 1140	java/lang/Throwable:printStackTrace	()V
    //   881: goto -326 -> 555
    //   884: astore 7
    //   886: goto -325 -> 561
    //   889: astore 7
    //   891: iconst_1
    //   892: istore_2
    //   893: aload_0
    //   894: getfield 134	com/tencent/mobileqq/msf/core/net/m:F	Ljava/util/concurrent/locks/ReentrantLock;
    //   897: invokevirtual 811	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   900: aload 7
    //   902: athrow
    //   903: astore 7
    //   905: ldc_w 419
    //   908: iconst_1
    //   909: new 187	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   916: ldc_w 1142
    //   919: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 7
    //   924: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: aload 7
    //   932: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   935: goto -349 -> 586
    //   938: aload_0
    //   939: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   942: ifnull +14 -> 956
    //   945: aload_0
    //   946: getfield 84	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   949: getfield 1065	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   952: iconst_0
    //   953: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   956: ldc_w 419
    //   959: iconst_1
    //   960: ldc_w 1144
    //   963: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   966: aload_0
    //   967: getfield 108	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   970: iconst_1
    //   971: invokevirtual 540	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   974: iload_3
    //   975: istore_2
    //   976: aload_0
    //   977: getfield 101	com/tencent/mobileqq/msf/core/net/m:t	Ljava/util/concurrent/atomic/AtomicInteger;
    //   980: iconst_1
    //   981: invokevirtual 1147	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   984: bipush 10
    //   986: if_icmpne -400 -> 586
    //   989: invokestatic 1152	android/os/Process:myPid	()I
    //   992: invokestatic 1155	android/os/Process:killProcess	(I)V
    //   995: iload_3
    //   996: istore_2
    //   997: goto -411 -> 586
    //   1000: astore 7
    //   1002: iconst_1
    //   1003: istore_2
    //   1004: goto -99 -> 905
    //   1007: ldc_w 419
    //   1010: iconst_1
    //   1011: new 187	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1018: ldc_w 1111
    //   1021: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 6
    //   1026: invokestatic 528	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1029: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: ldc_w 1113
    //   1035: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_1
    //   1039: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1048: goto -278 -> 770
    //   1051: astore 6
    //   1053: aload 6
    //   1055: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   1058: goto -245 -> 813
    //   1061: astore 6
    //   1063: ldc_w 419
    //   1066: iconst_1
    //   1067: new 187	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1074: ldc_w 1157
    //   1077: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload 6
    //   1082: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: aload 6
    //   1090: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1093: goto -248 -> 845
    //   1096: astore 7
    //   1098: iconst_1
    //   1099: istore_2
    //   1100: ldc 88
    //   1102: astore 6
    //   1104: goto -199 -> 905
    //   1107: astore 7
    //   1109: goto -204 -> 905
    //   1112: astore 7
    //   1114: goto -221 -> 893
    //   1117: astore 7
    //   1119: goto -596 -> 523
    //   1122: astore 7
    //   1124: goto -633 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1127	0	this	m
    //   0	1127	1	parama	com.tencent.qphone.base.a
    //   421	679	2	bool1	boolean
    //   372	624	3	bool2	boolean
    //   617	87	4	l1	long
    //   120	57	6	localMsfCore	MsfCore
    //   280	1	6	localException1	Exception
    //   406	344	6	str1	String
    //   850	175	6	localException2	Exception
    //   1051	3	6	localException3	Exception
    //   1061	28	6	localException4	Exception
    //   1102	1	6	str2	String
    //   495	225	7	localObject1	Object
    //   874	3	7	localThrowable1	java.lang.Throwable
    //   884	1	7	localThrowable2	java.lang.Throwable
    //   889	12	7	localObject2	Object
    //   903	28	7	localThrowable3	java.lang.Throwable
    //   1000	1	7	localThrowable4	java.lang.Throwable
    //   1096	1	7	localThrowable5	java.lang.Throwable
    //   1107	1	7	localThrowable6	java.lang.Throwable
    //   1112	1	7	localObject3	Object
    //   1117	1	7	localException5	Exception
    //   1122	1	7	localThrowable7	java.lang.Throwable
    //   642	80	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   56	69	280	java/lang/Exception
    //   56	69	305	finally
    //   282	298	305	finally
    //   330	371	850	java/lang/Exception
    //   541	555	874	java/lang/Throwable
    //   534	541	884	java/lang/Throwable
    //   555	561	884	java/lang/Throwable
    //   876	881	884	java/lang/Throwable
    //   426	453	889	finally
    //   893	903	903	java/lang/Throwable
    //   408	422	1000	java/lang/Throwable
    //   938	956	1000	java/lang/Throwable
    //   956	974	1000	java/lang/Throwable
    //   976	995	1000	java/lang/Throwable
    //   770	802	1051	java/lang/Exception
    //   802	813	1051	java/lang/Exception
    //   842	845	1061	java/lang/Exception
    //   399	408	1096	java/lang/Throwable
    //   579	586	1107	java/lang/Throwable
    //   453	471	1112	finally
    //   471	491	1112	finally
    //   491	497	1112	finally
    //   502	523	1112	finally
    //   523	529	1112	finally
    //   534	541	1112	finally
    //   541	555	1112	finally
    //   555	561	1112	finally
    //   561	579	1112	finally
    //   876	881	1112	finally
    //   502	523	1117	java/lang/Exception
    //   471	491	1122	java/lang/Throwable
  }
  
  public boolean c()
  {
    return this.w.get();
  }
  
  public boolean d()
  {
    return this.y.get();
  }
  
  public long e()
  {
    return this.A;
  }
  
  public long f()
  {
    return this.C;
  }
  
  public void g()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
      QLog.d("MSF.C.NetConnTag", 1, "msgSignal seq: " + localToServiceMsg.getRequestSsoSeq());
      int i1 = "CHNK".getBytes().length + 13 + 1 + 0 + 4;
      int i2 = StringUtils.str2Int(MsfService.getCore().getAccountCenter().i(), 0);
      byte b1 = (byte)("CHNK".getBytes().length + 1);
      Object localObject = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject).putInt(i1).putInt(20200918).putInt(i2).put(b1).put("CHNK".getBytes()).put((byte)1).putInt(0);
      localObject = ((ByteBuffer)localObject).array();
      localToServiceMsg.putWupBuffer((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Crypt.ping.MSF.C.NetConnTag", 2, "sendMsgSignal, cmd = " + "CHNK" + ", s = " + StringUtils.bytes2Str((byte[])localObject));
      }
      a(this.s.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send MsgSignal pkg fail, exception ", localException);
    }
  }
  
  public ToServiceMsg h()
  {
    if (this.z != null)
    {
      this.s.sender.c(this.z.getRequestSsoSeq());
      this.s.sender.d(this.z);
    }
    return this.z;
  }
  
  public int i()
  {
    if (this.h == null) {
      return 0;
    }
    return this.h.hashCode();
  }
  
  public int j()
  {
    if ((this.w.get()) && (this.e != null)) {
      return this.e.d();
    }
    return 0;
  }
  
  public long k()
  {
    return this.D.get();
  }
  
  public long l()
  {
    long l1 = 0L;
    h localh = this.h;
    if (localh != null) {
      l1 = localh.a();
    }
    return l1;
  }
  
  protected String m()
  {
    String str = "none";
    if ((this.j instanceof w)) {
      str = "socket";
    }
    while (!(this.j instanceof c)) {
      return str;
    }
    return "http";
  }
  
  abstract class a
    extends Thread
  {
    volatile AtomicBoolean a = new AtomicBoolean(true);
    
    a() {}
    
    public void a() {}
    
    public void run() {}
  }
  
  class b
    extends m.a
  {
    static final String c = "SocketReaderNew";
    final Object d = new Object();
    boolean e = false;
    long f = 0L;
    boolean g = false;
    long h = 0L;
    long i = 0L;
    
    b()
    {
      super();
    }
    
    public void a()
    {
      synchronized (this.d)
      {
        this.d.notifyAll();
        this.e = true;
        QLog.i("SocketReaderNew", 1, "SocketReader(" + this.f + ") onConnOpened");
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   4: invokevirtual 88	java/lang/Thread:getId	()J
      //   7: putfield 39	com/tencent/mobileqq/msf/core/net/m$b:f	J
      //   10: ldc 11
      //   12: iconst_1
      //   13: new 52	java/lang/StringBuilder
      //   16: dup
      //   17: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   20: ldc 55
      //   22: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: aload_0
      //   26: getfield 39	com/tencent/mobileqq/msf/core/net/m$b:f	J
      //   29: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   32: ldc 90
      //   34: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   43: ldc 11
      //   45: iconst_1
      //   46: new 52	java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   53: ldc 55
      //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: aload_0
      //   59: getfield 39	com/tencent/mobileqq/msf/core/net/m$b:f	J
      //   62: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   65: ldc 92
      //   67: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   76: aload_0
      //   77: getfield 95	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   80: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   83: ifeq +504 -> 587
      //   86: aload_0
      //   87: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   90: getfield 105	com/tencent/mobileqq/msf/core/net/m:l	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   93: sipush 30000
      //   96: invokevirtual 111	com/tencent/qphone/base/util/MsfSocketInputBuffer:isDataAvailable	(I)Z
      //   99: ifeq +419 -> 518
      //   102: aload_0
      //   103: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   106: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   109: ifnull +33 -> 142
      //   112: aload_0
      //   113: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   116: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   119: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   122: ifnull +20 -> 142
      //   125: aload_0
      //   126: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   129: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   132: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   135: iconst_2
      //   136: invokeinterface 126 2 0
      //   141: pop
      //   142: aload_0
      //   143: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   146: getfield 129	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/d;
      //   149: aload_0
      //   150: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   153: getfield 105	com/tencent/mobileqq/msf/core/net/m:l	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   156: aload_0
      //   157: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   160: invokestatic 132	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;)I
      //   163: invokeinterface 137 3 0
      //   168: aload_0
      //   169: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   172: invokestatic 140	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/mobileqq/msf/core/net/m;)Ljava/util/concurrent/atomic/AtomicLong;
      //   175: aload_0
      //   176: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   179: getfield 105	com/tencent/mobileqq/msf/core/net/m:l	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   182: invokevirtual 144	com/tencent/qphone/base/util/MsfSocketInputBuffer:getBufferlen	()I
      //   185: i2l
      //   186: invokevirtual 150	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   189: pop2
      //   190: aload_0
      //   191: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   194: getfield 105	com/tencent/mobileqq/msf/core/net/m:l	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   197: invokevirtual 153	com/tencent/qphone/base/util/MsfSocketInputBuffer:reset	()V
      //   200: aload_0
      //   201: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   204: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
      //   207: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
      //   210: pop2
      //   211: aload_0
      //   212: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   215: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   218: ifnull -142 -> 76
      //   221: aload_0
      //   222: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   225: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   228: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   231: ifnull -155 -> 76
      //   234: aload_0
      //   235: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   238: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   241: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   244: iconst_2
      //   245: invokeinterface 164 2 0
      //   250: pop
      //   251: goto -175 -> 76
      //   254: astore_1
      //   255: aload_0
      //   256: getfield 95	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   259: iconst_0
      //   260: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   263: aload_0
      //   264: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   267: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   270: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   273: invokevirtual 176	com/tencent/mobileqq/msf/core/ak:i	()V
      //   276: aload_0
      //   277: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   280: getstatic 181	com/tencent/qphone/base/a:c	Lcom/tencent/qphone/base/a;
      //   283: invokevirtual 184	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
      //   286: aload_1
      //   287: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
      //   290: aload_0
      //   291: getfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   294: lconst_0
      //   295: lcmp
      //   296: ifle +516 -> 812
      //   299: aload_0
      //   300: getfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   303: lconst_0
      //   304: lcmp
      //   305: ifle +507 -> 812
      //   308: aload_0
      //   309: getfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   312: aload_0
      //   313: getfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   316: lsub
      //   317: ldc2_w 188
      //   320: lcmp
      //   321: ifge +491 -> 812
      //   324: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
      //   327: aload_0
      //   328: getfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   331: lsub
      //   332: ldc2_w 188
      //   335: lcmp
      //   336: ifge +476 -> 812
      //   339: aload_0
      //   340: getfield 41	com/tencent/mobileqq/msf/core/net/m$b:g	Z
      //   343: ifne +88 -> 431
      //   346: aload_0
      //   347: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   350: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   353: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/b;
      //   356: ifnull +75 -> 431
      //   359: aload_0
      //   360: iconst_1
      //   361: putfield 41	com/tencent/mobileqq/msf/core/net/m$b:g	Z
      //   364: new 198	java/util/Properties
      //   367: dup
      //   368: invokespecial 199	java/util/Properties:<init>	()V
      //   371: astore_2
      //   372: aload_2
      //   373: ldc 201
      //   375: getstatic 204	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   378: invokevirtual 208	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   381: invokevirtual 212	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
      //   384: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   387: invokevirtual 222	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
      //   390: pop
      //   391: aload_2
      //   392: ldc 224
      //   394: aload_1
      //   395: invokevirtual 227	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   398: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   401: invokevirtual 222	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
      //   404: pop
      //   405: aload_0
      //   406: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   409: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   412: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/b;
      //   415: ldc 229
      //   417: aload_2
      //   418: aload_0
      //   419: getfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   422: aload_0
      //   423: getfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   426: lsub
      //   427: l2i
      //   428: invokevirtual 235	com/tencent/mobileqq/msf/core/c/b:reportTimeKVEvent	(Ljava/lang/String;Ljava/util/Properties;I)V
      //   431: aload_0
      //   432: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   435: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   438: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   441: invokevirtual 176	com/tencent/mobileqq/msf/core/ak:i	()V
      //   444: aload_0
      //   445: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   448: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   451: ifnull +33 -> 484
      //   454: aload_0
      //   455: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   458: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   461: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   464: ifnull +20 -> 484
      //   467: aload_0
      //   468: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   471: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   474: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   477: iconst_2
      //   478: invokeinterface 164 2 0
      //   483: pop
      //   484: ldc 11
      //   486: iconst_1
      //   487: new 52	java/lang/StringBuilder
      //   490: dup
      //   491: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   494: ldc 55
      //   496: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   499: aload_0
      //   500: getfield 39	com/tencent/mobileqq/msf/core/net/m$b:f	J
      //   503: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   506: ldc 237
      //   508: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   511: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   514: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   517: return
      //   518: aload_0
      //   519: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   522: invokestatic 158	android/os/SystemClock:uptimeMillis	()J
      //   525: invokestatic 161	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/mobileqq/msf/core/net/m;J)J
      //   528: pop2
      //   529: aload_0
      //   530: getfield 95	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   533: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   536: ifne -325 -> 211
      //   539: ldc 11
      //   541: iconst_1
      //   542: ldc 239
      //   544: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   547: aload_0
      //   548: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   551: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   554: ifnull +33 -> 587
      //   557: aload_0
      //   558: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   561: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   564: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   567: ifnull +20 -> 587
      //   570: aload_0
      //   571: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   574: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   577: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   580: iconst_2
      //   581: invokeinterface 164 2 0
      //   586: pop
      //   587: aload_0
      //   588: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   591: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   594: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   597: invokevirtual 176	com/tencent/mobileqq/msf/core/ak:i	()V
      //   600: aload_0
      //   601: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   604: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   607: ifnull +33 -> 640
      //   610: aload_0
      //   611: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   614: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   617: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   620: ifnull +20 -> 640
      //   623: aload_0
      //   624: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   627: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   630: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   633: iconst_2
      //   634: invokeinterface 164 2 0
      //   639: pop
      //   640: ldc 11
      //   642: iconst_1
      //   643: new 52	java/lang/StringBuilder
      //   646: dup
      //   647: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   650: ldc 55
      //   652: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   655: aload_0
      //   656: getfield 39	com/tencent/mobileqq/msf/core/net/m$b:f	J
      //   659: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   662: ldc 243
      //   664: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   667: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   670: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   673: aload_0
      //   674: getfield 35	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
      //   677: astore_1
      //   678: aload_1
      //   679: monitorenter
      //   680: aload_0
      //   681: getfield 37	com/tencent/mobileqq/msf/core/net/m$b:e	Z
      //   684: ifne +93 -> 777
      //   687: aload_0
      //   688: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   691: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   694: ifnull +33 -> 727
      //   697: aload_0
      //   698: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   701: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   704: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   707: ifnull +20 -> 727
      //   710: aload_0
      //   711: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   714: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   717: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   720: iconst_2
      //   721: invokeinterface 164 2 0
      //   726: pop
      //   727: aload_0
      //   728: getfield 35	com/tencent/mobileqq/msf/core/net/m$b:d	Ljava/lang/Object;
      //   731: ldc2_w 244
      //   734: invokevirtual 249	java/lang/Object:wait	(J)V
      //   737: aload_0
      //   738: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   741: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   744: ifnull +33 -> 777
      //   747: aload_0
      //   748: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   751: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   754: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   757: ifnull +20 -> 777
      //   760: aload_0
      //   761: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   764: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   767: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   770: iconst_2
      //   771: invokeinterface 126 2 0
      //   776: pop
      //   777: aload_0
      //   778: iconst_0
      //   779: putfield 37	com/tencent/mobileqq/msf/core/net/m$b:e	Z
      //   782: aload_1
      //   783: monitorexit
      //   784: aload_0
      //   785: getfield 95	com/tencent/mobileqq/msf/core/net/m$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   788: iconst_1
      //   789: invokevirtual 168	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   792: goto -749 -> 43
      //   795: astore_1
      //   796: ldc 11
      //   798: iconst_1
      //   799: ldc 251
      //   801: aload_1
      //   802: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   805: aload_1
      //   806: invokevirtual 255	java/lang/Exception:printStackTrace	()V
      //   809: goto -325 -> 484
      //   812: aload_0
      //   813: getfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   816: lconst_0
      //   817: lcmp
      //   818: ifne +66 -> 884
      //   821: aload_0
      //   822: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
      //   825: putfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   828: aload_0
      //   829: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   832: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   835: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   838: invokevirtual 176	com/tencent/mobileqq/msf/core/ak:i	()V
      //   841: aload_0
      //   842: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   845: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   848: ifnull -208 -> 640
      //   851: aload_0
      //   852: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   855: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   858: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   861: ifnull -221 -> 640
      //   864: aload_0
      //   865: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   868: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   871: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   874: iconst_2
      //   875: invokeinterface 164 2 0
      //   880: pop
      //   881: goto -241 -> 640
      //   884: aload_0
      //   885: getfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   888: lconst_0
      //   889: lcmp
      //   890: ifne +77 -> 967
      //   893: aload_0
      //   894: invokestatic 192	android/os/SystemClock:elapsedRealtime	()J
      //   897: putfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   900: goto -72 -> 828
      //   903: astore_1
      //   904: aload_1
      //   905: invokevirtual 255	java/lang/Exception:printStackTrace	()V
      //   908: goto -80 -> 828
      //   911: astore_1
      //   912: aload_0
      //   913: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   916: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   919: getfield 172	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   922: invokevirtual 176	com/tencent/mobileqq/msf/core/ak:i	()V
      //   925: aload_0
      //   926: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   929: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   932: ifnull +33 -> 965
      //   935: aload_0
      //   936: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   939: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   942: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   945: ifnull +20 -> 965
      //   948: aload_0
      //   949: getfield 26	com/tencent/mobileqq/msf/core/net/m$b:j	Lcom/tencent/mobileqq/msf/core/net/m;
      //   952: getfield 115	com/tencent/mobileqq/msf/core/net/m:s	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   955: getfield 121	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   958: iconst_2
      //   959: invokeinterface 164 2 0
      //   964: pop
      //   965: aload_1
      //   966: athrow
      //   967: aload_0
      //   968: lconst_0
      //   969: putfield 45	com/tencent/mobileqq/msf/core/net/m$b:i	J
      //   972: aload_0
      //   973: lconst_0
      //   974: putfield 43	com/tencent/mobileqq/msf/core/net/m$b:h	J
      //   977: goto -149 -> 828
      //   980: astore_2
      //   981: aload_1
      //   982: monitorexit
      //   983: aload_2
      //   984: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	985	0	this	b
      //   254	141	1	localThrowable	java.lang.Throwable
      //   795	11	1	localException1	Exception
      //   903	2	1	localException2	Exception
      //   911	71	1	localObject2	Object
      //   371	47	2	localProperties	java.util.Properties
      //   980	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   43	76	254	java/lang/Throwable
      //   76	142	254	java/lang/Throwable
      //   142	211	254	java/lang/Throwable
      //   211	251	254	java/lang/Throwable
      //   518	587	254	java/lang/Throwable
      //   673	680	795	java/lang/Exception
      //   784	792	795	java/lang/Exception
      //   983	985	795	java/lang/Exception
      //   290	431	903	java/lang/Exception
      //   812	828	903	java/lang/Exception
      //   884	900	903	java/lang/Exception
      //   967	977	903	java/lang/Exception
      //   43	76	911	finally
      //   76	142	911	finally
      //   142	211	911	finally
      //   211	251	911	finally
      //   255	290	911	finally
      //   290	431	911	finally
      //   518	587	911	finally
      //   812	828	911	finally
      //   884	900	911	finally
      //   904	908	911	finally
      //   967	977	911	finally
      //   680	727	980	finally
      //   727	777	980	finally
      //   777	784	980	finally
      //   981	983	980	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m
 * JD-Core Version:    0.7.0.1
 */