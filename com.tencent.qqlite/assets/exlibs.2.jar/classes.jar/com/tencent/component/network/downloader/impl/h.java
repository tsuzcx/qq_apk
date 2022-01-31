package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public final class h
  extends a
{
  private static List<DownloadGlobalStrategy.StrategyInfo> x;
  private static final Object y = new Object();
  private boolean p;
  private boolean q;
  private String r;
  private String s;
  private int t = 0;
  private final long u = SystemClock.uptimeMillis();
  private int v = 4;
  private int[] w = new int[this.v];
  private HttpResponse z = null;
  
  public h(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean);
  }
  
  private static int a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return 0;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-ErrNo").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return 0;
  }
  
  private static int b(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return -1;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-RtFlag").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return -1;
  }
  
  private boolean b(int paramInt)
    throws Exception
  {
    if (this.e == null)
    {
      this.e = DownloadGlobalStrategy.getInstance(this.a).getStrategyLib(j(), k());
      if (x != null) {}
    }
    Object localObject4;
    int i;
    synchronized (y)
    {
      if (x == null)
      {
        x = new ArrayList();
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
        localStrategyInfo1.id = 6;
        localObject4 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
        ((DownloadGlobalStrategy.StrategyInfo)localObject4).id = 7;
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
        localStrategyInfo2.id = 8;
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
        localStrategyInfo3.id = 9;
        x.add(localStrategyInfo1);
        x.add(localObject4);
        x.add(localStrategyInfo2);
        x.add(localStrategyInfo3);
      }
      this.e.copyStrageList();
      this.e.enableUpdate(false);
      this.e.addStrategy(x);
      this.f = this.g;
      this.g = this.e.getStrategyInfo(paramInt);
      Const.c("downloader", "downloader strategy: " + this.g.toString() + " currAttempCount:" + paramInt + " best:" + this.e.getBestId() + " url:" + j() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
      this.p = this.g.allowProxy;
      this.q = this.g.useConfigApn;
      localObject4 = k();
      i = this.e.getPort();
      paramInt = i;
      if (!Const.a(i))
      {
        this.e.setPort(80);
        paramInt = 80;
      }
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.g.id) {
        break label776;
      }
      i = paramInt;
      if (this.f != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.f.id)
        {
          if ((this.n == null) || (!this.n.supportExtraPort((String)localObject4))) {
            break label672;
          }
          i = this.n.changePort((String)localObject4, paramInt);
          if ((i == paramInt) || (!Const.a(i)))
          {
            Const.a("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            return false;
          }
        }
      }
    }
    Object localObject3 = this.e.getBackupIP();
    ??? = localObject3;
    if (this.m != null)
    {
      ??? = localObject3;
      if (!this.m.isIPValid((String)localObject4, (String)localObject3))
      {
        this.e.setBackupIP(null);
        ??? = this.m.resolveIP((String)localObject4);
        if (TextUtils.isEmpty((CharSequence)???)) {
          break label701;
        }
        this.e.setBackupIP((String)???);
      }
    }
    if ((??? == null) || (((String)???).equals(this.e.getDirectIP())) || (((String)???).equals(this.e.getDnsIP())))
    {
      Const.c("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
      return false;
      label672:
      Const.a("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
      return false;
      label701:
      Const.c("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return false;
    }
    this.g = this.g.clone();
    this.g.setIPInfo(new IPInfo((String)???, i));
    paramInt = NetworkManager.getIspType();
    if ((paramInt <= 0) || (paramInt > this.v)) {}
    for (;;)
    {
      return true;
      label776:
      if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.f.id)
          {
            if ((this.n == null) || (!this.n.supportExtraPort((String)localObject4))) {
              break label989;
            }
            i = this.n.changePort((String)localObject4, paramInt);
            if ((i == paramInt) || (!Const.a(i)))
            {
              Const.a("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
        ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        if ((??? == null) || (((String)???).equals(this.e.getBackupIP())) || (((String)???).equals(this.e.getDirectIP())))
        {
          this.e.setDnsIP(null);
          Const.c("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          label989:
          Const.a("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.e.setDnsIP((String)???);
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, i));
        break;
      }
      if (6 == this.g.id)
      {
        ??? = null;
        if (this.l != null)
        {
          localObject3 = this.l.resolveIP((String)localObject4);
          ??? = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
          }
        }
        if (??? == null)
        {
          Const.c("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (7 == this.g.id)
      {
        ??? = null;
        if (this.m != null)
        {
          localObject3 = this.m.resolveIP((String)localObject4);
          ??? = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
          }
        }
        if (??? == null)
        {
          Const.c("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (8 == this.g.id)
      {
        ??? = null;
        do
        {
          paramInt = o();
          localObject3 = ???;
          if (paramInt == 0) {
            break;
          }
          localObject3 = ???;
          if (this.l != null) {
            localObject3 = this.l.resolveIPByIsp((String)localObject4, paramInt);
          }
          ??? = localObject3;
        } while (TextUtils.isEmpty((CharSequence)localObject3));
        ??? = localObject3;
        if (localObject3 == null) {
          ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        }
        if (??? == null)
        {
          Const.c("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (9 == this.g.id)
      {
        ??? = null;
        do
        {
          paramInt = o();
          localObject3 = ???;
          if (paramInt == 0) {
            break;
          }
          localObject3 = ???;
          if (this.l != null) {
            localObject3 = this.l.resolveIPByIsp((String)localObject4, paramInt);
          }
          ??? = localObject3;
        } while (TextUtils.isEmpty((CharSequence)localObject3));
        ??? = localObject3;
        if (localObject3 == null) {
          ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        }
        if (??? == null)
        {
          Const.c("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.f.id)
          {
            if ((this.n == null) || (!this.n.supportExtraPort((String)localObject4))) {
              break label1865;
            }
            i = this.n.changePort((String)localObject4, paramInt);
            if ((i == paramInt) || (!Const.a(i)))
            {
              Const.a("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
      }
      label1865:
      do
      {
        localObject3 = this.e.getDirectIP();
        ??? = localObject3;
        if (this.l != null)
        {
          ??? = localObject3;
          if (!this.l.isIPValid((String)localObject3, (String)localObject4))
          {
            this.e.setDirectIP(null);
            ??? = this.l.resolveIP((String)localObject4);
            if (TextUtils.isEmpty((CharSequence)???)) {
              break label1997;
            }
            this.e.setDirectIP((String)???);
          }
        }
        if ((??? != null) && (!((String)???).equals(this.e.getBackupIP())) && (!((String)???).equals(this.e.getDnsIP()))) {
          break label2026;
        }
        Const.c("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
        return false;
        Const.a("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.g.id) {
          break;
        }
        i = paramInt;
      } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.g.id);
      ??? = this.a;
      if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.g.id) {}
      for (boolean bool = true; NetworkUtils.getProxy((Context)???, bool) == null; bool = false)
      {
        Const.c("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
      }
      return true;
      label1997:
      Const.c("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return false;
      label2026:
      this.g = this.g.clone();
      this.g.setIPInfo(new IPInfo((String)???, i));
      break;
      this.w[(paramInt - 1)] = 1;
    }
  }
  
  private int o()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.v) {
        return 0;
      }
      if (this.w[i] == 0)
      {
        this.w[i] = 1;
        return i + 1;
      }
      i += 1;
    }
  }
  
  protected final void a()
  {
    super.a();
    this.s = Const.c(j());
    this.t = Const.d(j());
  }
  
  /* Error */
  public final void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 382
    //   6: astore 12
    //   8: iconst_2
    //   9: anewarray 28	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_0
    //   15: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: invokestatic 387	com/tencent/component/network/downloader/impl/a$b:a	([Ljava/lang/Object;)I
    //   26: istore 6
    //   28: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   31: lstore 7
    //   33: aload_1
    //   34: invokeinterface 393 1 0
    //   39: ifeq +10 -> 49
    //   42: return
    //   43: ldc2_w 394
    //   46: invokestatic 399	java/lang/Thread:sleep	(J)V
    //   49: aload_0
    //   50: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   53: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   56: ifne +16 -> 72
    //   59: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   62: lload 7
    //   64: lsub
    //   65: ldc2_w 404
    //   68: lcmp
    //   69: ifle -26 -> 43
    //   72: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   75: lload 7
    //   77: lsub
    //   78: ldc2_w 404
    //   81: lcmp
    //   82: ifgt +5859 -> 5941
    //   85: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   88: lstore 9
    //   90: new 205	com/tencent/component/network/downloader/impl/ipc/Const
    //   93: dup
    //   94: invokespecial 406	com/tencent/component/network/downloader/impl/ipc/Const:<init>	()V
    //   97: astore 15
    //   99: aload 15
    //   101: iload 6
    //   103: putfield 408	com/tencent/component/network/downloader/impl/ipc/Const:a	I
    //   106: aload 15
    //   108: aload_0
    //   109: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   112: putfield 410	com/tencent/component/network/downloader/impl/ipc/Const:b	Ljava/lang/String;
    //   115: aload_0
    //   116: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   119: pop
    //   120: aload 15
    //   122: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   125: putfield 417	com/tencent/component/network/downloader/impl/ipc/Const:c	J
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   138: aconst_null
    //   139: astore 14
    //   141: aconst_null
    //   142: astore 13
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   149: invokespecial 425	com/tencent/component/network/downloader/impl/h:b	(I)Z
    //   152: istore 11
    //   154: iload 11
    //   156: ifne +210 -> 366
    //   159: iload 4
    //   161: istore_3
    //   162: aload_0
    //   163: invokevirtual 427	com/tencent/component/network/downloader/impl/h:d	()Z
    //   166: ifne +5781 -> 5947
    //   169: aload_0
    //   170: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   173: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   176: ifne +12 -> 188
    //   179: aload_2
    //   180: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   183: bipush 6
    //   185: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   188: aload_2
    //   189: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   192: invokevirtual 441	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   195: istore 4
    //   197: aload_2
    //   198: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   201: getfield 444	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   204: istore 5
    //   206: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   209: astore_1
    //   210: aload_2
    //   211: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   214: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   217: astore 13
    //   219: aload_2
    //   220: new 151	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 455
    //   227: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: ldc_w 457
    //   233: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 459
    //   239: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload 4
    //   244: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 459
    //   250: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 5
    //   255: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc_w 459
    //   261: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload_3
    //   265: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc_w 459
    //   271: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 459
    //   281: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 382
    //   287: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 459
    //   293: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 13
    //   298: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 459
    //   304: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 12
    //   309: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 459
    //   315: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokestatic 188	com/tencent/component/network/NetworkManager:getIspType	()I
    //   321: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 459
    //   327: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   334: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   337: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   340: ldc_w 464
    //   343: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokevirtual 467	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   352: return
    //   353: astore_1
    //   354: ldc 149
    //   356: ldc_w 382
    //   359: aload_1
    //   360: invokestatic 470	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: return
    //   364: astore 13
    //   366: aload 13
    //   368: ifnull +808 -> 1176
    //   371: aload 13
    //   373: athrow
    //   374: astore 13
    //   376: iconst_0
    //   377: istore_3
    //   378: aload_2
    //   379: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   382: aload 13
    //   384: invokevirtual 473	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   387: iload 4
    //   389: iconst_1
    //   390: iadd
    //   391: istore 4
    //   393: aload_2
    //   394: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   397: lload 9
    //   399: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   402: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   405: aload_0
    //   406: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   409: invokestatic 488	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   412: invokevirtual 491	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   415: astore 16
    //   417: aload_0
    //   418: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   421: ifnull +3356 -> 3777
    //   424: aload_0
    //   425: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   428: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   431: ifnull +3346 -> 3777
    //   434: aload_0
    //   435: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   438: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   441: invokevirtual 496	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   444: astore 14
    //   446: aload 14
    //   448: ifnull +3337 -> 3785
    //   451: aload 14
    //   453: astore 12
    //   455: aload_2
    //   456: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   459: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   462: ifne +60 -> 522
    //   465: aload_0
    //   466: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   469: ifnull +24 -> 493
    //   472: aload_0
    //   473: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   476: aload_0
    //   477: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   480: aload_2
    //   481: invokevirtual 505	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   484: aload_0
    //   485: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   488: invokeinterface 511 4 0
    //   493: aload_0
    //   494: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   497: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   500: ifne +22 -> 522
    //   503: aload_0
    //   504: aload_0
    //   505: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   508: iconst_1
    //   509: isub
    //   510: putfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   513: aload_2
    //   514: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   517: bipush 6
    //   519: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   522: aload_1
    //   523: invokeinterface 393 1 0
    //   528: ifne +628 -> 1156
    //   531: aload_2
    //   532: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   535: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   538: ifne +3267 -> 3805
    //   541: new 151	java/lang/StringBuilder
    //   544: dup
    //   545: ldc_w 513
    //   548: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   551: aload_0
    //   552: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   555: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 515
    //   561: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 16
    //   566: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   569: ldc_w 520
    //   572: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 14
    //   577: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 522
    //   583: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 524
    //   589: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 526
    //   595: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   601: invokevirtual 199	java/lang/Thread:getId	()J
    //   604: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: ldc_w 528
    //   610: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   616: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc_w 530
    //   622: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_0
    //   626: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   629: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   632: ldc_w 532
    //   635: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_0
    //   639: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   642: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: ldc_w 534
    //   648: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: astore 17
    //   653: aload_0
    //   654: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   657: ifeq +3136 -> 3793
    //   660: aload_0
    //   661: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   664: aload_0
    //   665: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   668: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   671: astore 14
    //   673: aload 17
    //   675: aload 14
    //   677: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   680: ldc_w 536
    //   683: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   690: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   693: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   696: ldc_w 538
    //   699: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_2
    //   703: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   706: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   709: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: ldc_w 540
    //   715: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload_2
    //   719: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   722: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   725: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   728: ldc_w 545
    //   731: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   737: aload_0
    //   738: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   741: lsub
    //   742: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   745: ldc_w 547
    //   748: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_2
    //   752: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   755: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   758: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   761: ldc_w 459
    //   764: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_2
    //   768: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   771: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   774: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   777: ldc_w 555
    //   780: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_2
    //   784: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   787: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   790: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   793: ldc_w 560
    //   796: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_0
    //   800: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   803: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   806: ldc_w 459
    //   809: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_0
    //   813: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   816: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: ldc_w 564
    //   822: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iload 4
    //   827: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 566
    //   833: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_2
    //   837: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   840: invokevirtual 441	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   843: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   846: ldc_w 568
    //   849: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: iload_3
    //   853: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 570
    //   859: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_0
    //   863: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   866: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: ldc_w 574
    //   872: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: astore 14
    //   877: aload_0
    //   878: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   881: ifnull +2918 -> 3799
    //   884: aload_0
    //   885: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   888: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   891: istore 5
    //   893: ldc 149
    //   895: aload 14
    //   897: iload 5
    //   899: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: ldc_w 576
    //   905: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload_2
    //   909: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   912: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   915: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: ldc_w 581
    //   921: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload_0
    //   925: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   928: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   931: ldc_w 585
    //   934: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: aload 13
    //   942: invokestatic 470	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   945: getstatic 231	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   948: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   951: aload_0
    //   952: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   955: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   958: if_icmpne +35 -> 993
    //   961: aload_0
    //   962: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   965: ifnull +28 -> 993
    //   968: aload_0
    //   969: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   972: aload_0
    //   973: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   976: aload_0
    //   977: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   980: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   983: aload_2
    //   984: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   987: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   990: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   993: getstatic 345	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   996: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   999: aload_0
    //   1000: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1003: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1006: if_icmpne +35 -> 1041
    //   1009: aload_0
    //   1010: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   1013: ifnull +28 -> 1041
    //   1016: aload_0
    //   1017: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   1020: aload_0
    //   1021: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1024: aload_0
    //   1025: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   1028: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1031: aload_2
    //   1032: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1035: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1038: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1041: aload 15
    //   1043: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   1046: putfield 593	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   1049: aload 15
    //   1051: aload_0
    //   1052: getfield 594	com/tencent/component/network/downloader/impl/h:d	J
    //   1055: putfield 596	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   1058: aload 15
    //   1060: aload_0
    //   1061: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1064: putfield 598	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   1067: aload 15
    //   1069: iload_3
    //   1070: putfield 600	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   1073: aload 15
    //   1075: aload 13
    //   1077: putfield 603	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   1080: aload 16
    //   1082: ifnonnull +3138 -> 4220
    //   1085: aconst_null
    //   1086: astore 13
    //   1088: aload 15
    //   1090: aload 13
    //   1092: putfield 606	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1099: ifnull +3131 -> 4230
    //   1102: aload_0
    //   1103: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1106: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1109: ifnull +3121 -> 4230
    //   1112: aload_0
    //   1113: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1116: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1119: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   1122: astore 13
    //   1124: aload 15
    //   1126: aload 13
    //   1128: putfield 610	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   1131: aload 15
    //   1133: aload_2
    //   1134: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1137: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1140: putfield 612	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   1143: aload_2
    //   1144: aload 15
    //   1146: invokevirtual 616	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   1149: aload_0
    //   1150: aload_2
    //   1151: aload 15
    //   1153: invokevirtual 619	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   1156: aload_0
    //   1157: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1160: ifnull +4793 -> 5953
    //   1163: aload_0
    //   1164: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1167: invokevirtual 624	org/apache/http/client/methods/HttpGet:abort	()V
    //   1170: iload 4
    //   1172: istore_3
    //   1173: goto -1011 -> 162
    //   1176: getstatic 627	com/tencent/component/network/downloader/impl/h:i	Ljava/lang/ThreadLocal;
    //   1179: invokevirtual 633	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1182: checkcast 635	com/tencent/component/network/utils/a/e$b
    //   1185: astore 16
    //   1187: aload 16
    //   1189: aload_0
    //   1190: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   1193: putfield 637	com/tencent/component/network/utils/a/e$b:a	Z
    //   1196: aload 16
    //   1198: aload_0
    //   1199: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   1202: putfield 639	com/tencent/component/network/utils/a/e$b:b	Z
    //   1205: aload 15
    //   1207: iload 4
    //   1209: putfield 641	com/tencent/component/network/downloader/impl/ipc/Const:k	I
    //   1212: aload_2
    //   1213: invokevirtual 644	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1216: aload_0
    //   1217: aload_0
    //   1218: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1221: putfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   1224: aload_0
    //   1225: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1228: ifnull +225 -> 1453
    //   1231: aload_0
    //   1232: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1235: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1238: ifnull +215 -> 1453
    //   1241: aload_0
    //   1242: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1245: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1248: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   1251: invokestatic 279	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1254: ifne +199 -> 1453
    //   1257: aload_0
    //   1258: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1261: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1264: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   1267: astore 13
    //   1269: aload_0
    //   1270: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1273: astore 12
    //   1275: aload 13
    //   1277: invokestatic 646	com/tencent/component/network/downloader/impl/ipc/Const:e	(Ljava/lang/String;)I
    //   1280: iconst_2
    //   1281: if_icmpge +97 -> 1378
    //   1284: aload_0
    //   1285: getfield 39	com/tencent/component/network/downloader/impl/h:t	I
    //   1288: istore_3
    //   1289: iload_3
    //   1290: ifle +1135 -> 2425
    //   1293: aload_0
    //   1294: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1297: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1300: iload_3
    //   1301: putfield 647	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   1304: iload_3
    //   1305: istore 5
    //   1307: iload_3
    //   1308: invokestatic 224	com/tencent/component/network/downloader/impl/ipc/Const:a	(I)Z
    //   1311: ifne +7 -> 1318
    //   1314: bipush 80
    //   1316: istore 5
    //   1318: new 151	java/lang/StringBuilder
    //   1321: dup
    //   1322: aload 13
    //   1324: invokestatic 651	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1327: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1330: ldc_w 653
    //   1333: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: iload 5
    //   1338: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1341: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: astore 13
    //   1346: aload 13
    //   1348: astore 12
    //   1350: aload_0
    //   1351: getfield 373	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1354: ifnull +24 -> 1378
    //   1357: aload_0
    //   1358: aload_0
    //   1359: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   1362: aload_0
    //   1363: getfield 373	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1366: aload 13
    //   1368: invokevirtual 657	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1371: putfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   1374: aload 13
    //   1376: astore 12
    //   1378: aload 15
    //   1380: aload_0
    //   1381: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1384: invokevirtual 159	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1387: putfield 659	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   1390: ldc 149
    //   1392: new 151	java/lang/StringBuilder
    //   1395: dup
    //   1396: ldc_w 661
    //   1399: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1402: aload 15
    //   1404: getfield 659	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   1407: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 663
    //   1413: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 12
    //   1418: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: ldc 176
    //   1423: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: aload_0
    //   1427: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1430: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: ldc 251
    //   1435: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1441: invokevirtual 199	java/lang/Thread:getId	()J
    //   1444: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokestatic 209	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1453: aload_0
    //   1454: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1457: ifnull +15 -> 1472
    //   1460: aload 15
    //   1462: aload_0
    //   1463: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1466: invokevirtual 159	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1469: putfield 659	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   1472: aload_0
    //   1473: aload_0
    //   1474: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1477: aload_0
    //   1478: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1481: aload_0
    //   1482: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1485: aload_0
    //   1486: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   1489: aload 16
    //   1491: invokestatic 668	com/tencent/component/network/utils/a/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   1494: putfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1497: aload_0
    //   1498: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1501: ifnull +24 -> 1525
    //   1504: aload_0
    //   1505: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1508: aload_0
    //   1509: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1512: aload_0
    //   1513: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1516: aload_0
    //   1517: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1520: invokeinterface 672 4 0
    //   1525: aload_0
    //   1526: aload_0
    //   1527: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1530: aload_0
    //   1531: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1534: aload_0
    //   1535: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1538: invokevirtual 675	com/tencent/component/network/downloader/impl/h:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1541: aload_0
    //   1542: aload_0
    //   1543: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1546: aload_0
    //   1547: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1550: aload_0
    //   1551: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1554: invokevirtual 677	com/tencent/component/network/downloader/impl/h:b	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1557: invokestatic 680	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   1560: astore 12
    //   1562: aload_0
    //   1563: aload_0
    //   1564: getfield 683	com/tencent/component/network/downloader/impl/h:j	Lorg/apache/http/client/HttpClient;
    //   1567: aload_0
    //   1568: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1571: aload 12
    //   1573: invokeinterface 689 3 0
    //   1578: putfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1581: aload_0
    //   1582: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1585: ifnull +2179 -> 3764
    //   1588: aload_0
    //   1589: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1592: invokeinterface 693 1 0
    //   1597: invokeinterface 698 1 0
    //   1602: istore_3
    //   1603: aload_2
    //   1604: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1607: iload_3
    //   1608: putfield 444	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   1611: sipush 200
    //   1614: iload_3
    //   1615: if_icmpeq +10 -> 1625
    //   1618: sipush 206
    //   1621: iload_3
    //   1622: if_icmpne +1266 -> 2888
    //   1625: aload_0
    //   1626: aload_0
    //   1627: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1630: aload_2
    //   1631: aload_1
    //   1632: iload_3
    //   1633: invokevirtual 701	com/tencent/component/network/downloader/impl/h:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   1636: ifeq +4323 -> 5959
    //   1639: aload_2
    //   1640: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1643: invokevirtual 704	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   1646: iload 4
    //   1648: iconst_1
    //   1649: iadd
    //   1650: istore 4
    //   1652: aload_2
    //   1653: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1656: lload 9
    //   1658: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   1661: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1664: aload_0
    //   1665: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1668: invokestatic 488	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   1671: invokevirtual 491	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1674: astore 14
    //   1676: aload_0
    //   1677: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1680: ifnull +759 -> 2439
    //   1683: aload_0
    //   1684: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1687: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1690: ifnull +749 -> 2439
    //   1693: aload_0
    //   1694: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1697: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1700: invokevirtual 496	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   1703: astore 13
    //   1705: aload 13
    //   1707: ifnull +740 -> 2447
    //   1710: aload 13
    //   1712: astore 12
    //   1714: aload_2
    //   1715: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1718: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1721: ifne +60 -> 1781
    //   1724: aload_0
    //   1725: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1728: ifnull +24 -> 1752
    //   1731: aload_0
    //   1732: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1735: aload_0
    //   1736: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1739: aload_2
    //   1740: invokevirtual 505	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1743: aload_0
    //   1744: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   1747: invokeinterface 511 4 0
    //   1752: aload_0
    //   1753: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1756: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1759: ifne +22 -> 1781
    //   1762: aload_0
    //   1763: aload_0
    //   1764: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   1767: iconst_1
    //   1768: isub
    //   1769: putfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   1772: aload_2
    //   1773: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1776: bipush 6
    //   1778: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   1781: aload_1
    //   1782: invokeinterface 393 1 0
    //   1787: ifne +618 -> 2405
    //   1790: aload_2
    //   1791: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1794: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1797: ifne +669 -> 2466
    //   1800: new 151	java/lang/StringBuilder
    //   1803: dup
    //   1804: ldc_w 513
    //   1807: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1810: aload_0
    //   1811: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1814: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: ldc_w 515
    //   1820: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: aload 14
    //   1825: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1828: ldc_w 520
    //   1831: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: aload 13
    //   1836: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: ldc_w 522
    //   1842: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: ldc_w 524
    //   1848: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: ldc_w 526
    //   1854: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1860: invokevirtual 199	java/lang/Thread:getId	()J
    //   1863: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1866: ldc_w 528
    //   1869: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1875: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: ldc_w 530
    //   1881: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: aload_0
    //   1885: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   1888: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1891: ldc_w 532
    //   1894: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: aload_0
    //   1898: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   1901: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1904: ldc_w 534
    //   1907: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: astore 13
    //   1912: aload_0
    //   1913: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   1916: ifeq +539 -> 2455
    //   1919: aload_0
    //   1920: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1923: aload_0
    //   1924: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   1927: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   1930: astore_1
    //   1931: aload 13
    //   1933: aload_1
    //   1934: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1937: ldc_w 536
    //   1940: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: aload_0
    //   1944: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1947: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1950: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1953: ldc_w 538
    //   1956: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: aload_2
    //   1960: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1963: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1966: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: ldc_w 540
    //   1972: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: aload_2
    //   1976: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1979: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1982: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1985: ldc_w 545
    //   1988: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   1994: aload_0
    //   1995: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   1998: lsub
    //   1999: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2002: ldc_w 547
    //   2005: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: aload_2
    //   2009: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2012: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2015: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2018: ldc_w 459
    //   2021: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: aload_2
    //   2025: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2028: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2031: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2034: ldc_w 555
    //   2037: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: aload_2
    //   2041: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2044: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2047: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2050: ldc_w 560
    //   2053: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: aload_0
    //   2057: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   2060: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2063: ldc_w 459
    //   2066: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload_0
    //   2070: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   2073: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2076: ldc_w 564
    //   2079: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: iload 4
    //   2084: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2087: ldc_w 566
    //   2090: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: aload_2
    //   2094: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2097: invokevirtual 441	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2100: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2103: ldc_w 568
    //   2106: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: iload_3
    //   2110: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2113: ldc_w 570
    //   2116: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2119: aload_0
    //   2120: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   2123: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: ldc_w 574
    //   2129: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: astore_1
    //   2133: aload_0
    //   2134: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2137: ifnull +323 -> 2460
    //   2140: aload_0
    //   2141: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2144: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2147: istore 5
    //   2149: ldc 149
    //   2151: aload_1
    //   2152: iload 5
    //   2154: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2157: ldc_w 576
    //   2160: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: aload_2
    //   2164: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2167: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2170: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: ldc_w 581
    //   2176: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: aload_0
    //   2180: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   2183: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2186: ldc_w 585
    //   2189: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2195: aconst_null
    //   2196: invokestatic 470	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2199: getstatic 231	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2202: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2205: aload_0
    //   2206: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2209: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2212: if_icmpne +35 -> 2247
    //   2215: aload_0
    //   2216: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2219: ifnull +28 -> 2247
    //   2222: aload_0
    //   2223: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2226: aload_0
    //   2227: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   2230: aload_0
    //   2231: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   2234: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2237: aload_2
    //   2238: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2241: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2244: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2247: getstatic 345	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2250: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2253: aload_0
    //   2254: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2257: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2260: if_icmpne +35 -> 2295
    //   2263: aload_0
    //   2264: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2267: ifnull +28 -> 2295
    //   2270: aload_0
    //   2271: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2274: aload_0
    //   2275: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   2278: aload_0
    //   2279: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   2282: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2285: aload_2
    //   2286: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2289: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2292: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2295: aload 15
    //   2297: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   2300: putfield 593	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   2303: aload 15
    //   2305: aload_0
    //   2306: getfield 594	com/tencent/component/network/downloader/impl/h:d	J
    //   2309: putfield 596	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   2312: aload 15
    //   2314: aload_0
    //   2315: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   2318: putfield 598	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   2321: aload 15
    //   2323: iload_3
    //   2324: putfield 600	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   2327: aload 15
    //   2329: aconst_null
    //   2330: putfield 603	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   2333: aload 14
    //   2335: ifnonnull +537 -> 2872
    //   2338: aconst_null
    //   2339: astore_1
    //   2340: aload 15
    //   2342: aload_1
    //   2343: putfield 606	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   2346: aload_0
    //   2347: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2350: ifnull +531 -> 2881
    //   2353: aload_0
    //   2354: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2357: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2360: ifnull +521 -> 2881
    //   2363: aload_0
    //   2364: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2367: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2370: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   2373: astore_1
    //   2374: aload 15
    //   2376: aload_1
    //   2377: putfield 610	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   2380: aload 15
    //   2382: aload_2
    //   2383: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2386: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2389: putfield 612	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   2392: aload_2
    //   2393: aload 15
    //   2395: invokevirtual 616	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   2398: aload_0
    //   2399: aload_2
    //   2400: aload 15
    //   2402: invokevirtual 619	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   2405: aload_0
    //   2406: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   2409: ifnull +3553 -> 5962
    //   2412: aload_0
    //   2413: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   2416: invokevirtual 624	org/apache/http/client/methods/HttpGet:abort	()V
    //   2419: iload 4
    //   2421: istore_3
    //   2422: goto -2253 -> 169
    //   2425: aload_0
    //   2426: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2429: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2432: getfield 647	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   2435: istore_3
    //   2436: goto -1132 -> 1304
    //   2439: ldc_w 524
    //   2442: astore 13
    //   2444: goto -739 -> 1705
    //   2447: ldc_w 706
    //   2450: astore 12
    //   2452: goto -738 -> 1714
    //   2455: aconst_null
    //   2456: astore_1
    //   2457: goto -526 -> 1931
    //   2460: iconst_0
    //   2461: istore 5
    //   2463: goto -314 -> 2149
    //   2466: new 151	java/lang/StringBuilder
    //   2469: dup
    //   2470: ldc_w 708
    //   2473: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2476: aload_0
    //   2477: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   2480: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: ldc_w 515
    //   2486: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2489: aload 14
    //   2491: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2494: ldc_w 520
    //   2497: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2500: aload 13
    //   2502: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: ldc_w 522
    //   2508: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2511: ldc_w 524
    //   2514: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: ldc_w 526
    //   2520: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2526: invokevirtual 199	java/lang/Thread:getId	()J
    //   2529: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2532: ldc_w 528
    //   2535: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2541: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: ldc_w 530
    //   2547: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: aload_0
    //   2551: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   2554: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2557: ldc_w 532
    //   2560: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: aload_0
    //   2564: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   2567: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2570: ldc_w 534
    //   2573: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2576: astore 13
    //   2578: aload_0
    //   2579: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   2582: ifeq +253 -> 2835
    //   2585: aload_0
    //   2586: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   2589: aload_0
    //   2590: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   2593: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2596: astore_1
    //   2597: aload 13
    //   2599: aload_1
    //   2600: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2603: ldc_w 540
    //   2606: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: aload_2
    //   2610: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2613: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2616: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2619: ldc_w 545
    //   2622: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2625: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   2628: aload_0
    //   2629: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   2632: lsub
    //   2633: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2636: ldc_w 547
    //   2639: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2642: aload_2
    //   2643: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2646: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2649: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2652: ldc_w 459
    //   2655: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: aload_2
    //   2659: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2662: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2665: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2668: ldc_w 555
    //   2671: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: aload_2
    //   2675: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2678: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2681: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2684: ldc_w 560
    //   2687: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2690: aload_0
    //   2691: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   2694: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2697: ldc_w 459
    //   2700: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2703: aload_0
    //   2704: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   2707: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2710: ldc_w 564
    //   2713: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: iload 4
    //   2718: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2721: ldc_w 710
    //   2724: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2727: iload_3
    //   2728: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2731: ldc_w 538
    //   2734: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: aload_2
    //   2738: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2741: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2744: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: ldc_w 570
    //   2750: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: aload_0
    //   2754: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   2757: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: ldc_w 574
    //   2763: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: astore_1
    //   2767: aload_0
    //   2768: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2771: ifnull +69 -> 2840
    //   2774: aload_0
    //   2775: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2778: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2781: istore 5
    //   2783: ldc 149
    //   2785: aload_1
    //   2786: iload 5
    //   2788: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2791: ldc_w 576
    //   2794: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2797: aload_2
    //   2798: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2801: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2804: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2807: ldc_w 581
    //   2810: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload_0
    //   2814: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   2817: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2820: ldc_w 585
    //   2823: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2826: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2829: invokestatic 209	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2832: goto -633 -> 2199
    //   2835: aconst_null
    //   2836: astore_1
    //   2837: goto -240 -> 2597
    //   2840: iconst_0
    //   2841: istore 5
    //   2843: goto -60 -> 2783
    //   2846: astore_1
    //   2847: ldc 149
    //   2849: ldc_w 382
    //   2852: aload_1
    //   2853: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2856: goto -609 -> 2247
    //   2859: astore_1
    //   2860: ldc 149
    //   2862: ldc_w 382
    //   2865: aload_1
    //   2866: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2869: goto -574 -> 2295
    //   2872: aload 14
    //   2874: invokevirtual 715	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   2877: astore_1
    //   2878: goto -538 -> 2340
    //   2881: ldc_w 717
    //   2884: astore_1
    //   2885: goto -511 -> 2374
    //   2888: aload_0
    //   2889: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   2892: invokestatic 719	com/tencent/component/network/downloader/impl/h:b	(Lorg/apache/http/HttpResponse;)I
    //   2895: ifne +8 -> 2903
    //   2898: aload_0
    //   2899: iconst_0
    //   2900: invokevirtual 721	com/tencent/component/network/downloader/impl/h:a	(I)V
    //   2903: sipush 404
    //   2906: iload_3
    //   2907: if_icmpne +41 -> 2948
    //   2910: aload_0
    //   2911: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   2914: invokestatic 723	com/tencent/component/network/downloader/impl/h:a	(Lorg/apache/http/HttpResponse;)I
    //   2917: istore 5
    //   2919: iload 5
    //   2921: sipush -6101
    //   2924: if_icmpeq +19 -> 2943
    //   2927: iload 5
    //   2929: sipush -5062
    //   2932: if_icmpeq +11 -> 2943
    //   2935: iload 5
    //   2937: sipush -5023
    //   2940: if_icmpne +8 -> 2948
    //   2943: aload_0
    //   2944: iconst_0
    //   2945: invokevirtual 721	com/tencent/component/network/downloader/impl/h:a	(I)V
    //   2948: aload_2
    //   2949: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2952: iconst_3
    //   2953: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2956: aload_0
    //   2957: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2960: ifnull +2999 -> 5959
    //   2963: aload_0
    //   2964: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2967: aload_0
    //   2968: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   2971: iconst_1
    //   2972: invokeinterface 727 3 0
    //   2977: iload 4
    //   2979: iconst_1
    //   2980: iadd
    //   2981: istore 5
    //   2983: aload_2
    //   2984: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2987: lload 9
    //   2989: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   2992: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2995: aload_0
    //   2996: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   2999: invokestatic 488	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   3002: invokevirtual 491	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3005: astore 14
    //   3007: aload_0
    //   3008: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3011: ifnull +2445 -> 5456
    //   3014: aload_0
    //   3015: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3018: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3021: ifnull +2435 -> 5456
    //   3024: aload_0
    //   3025: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3028: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3031: invokevirtual 496	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3034: astore 13
    //   3036: aload 13
    //   3038: ifnull +2426 -> 5464
    //   3041: aload 13
    //   3043: astore 12
    //   3045: aload_2
    //   3046: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3049: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3052: ifne +60 -> 3112
    //   3055: aload_0
    //   3056: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3059: ifnull +24 -> 3083
    //   3062: aload_0
    //   3063: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3066: aload_0
    //   3067: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3070: aload_2
    //   3071: invokevirtual 505	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3074: aload_0
    //   3075: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   3078: invokeinterface 511 4 0
    //   3083: aload_0
    //   3084: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3087: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3090: ifne +22 -> 3112
    //   3093: aload_0
    //   3094: aload_0
    //   3095: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   3098: iconst_1
    //   3099: isub
    //   3100: putfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   3103: aload_2
    //   3104: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3107: bipush 6
    //   3109: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3112: aload_1
    //   3113: invokeinterface 393 1 0
    //   3118: ifne +626 -> 3744
    //   3121: aload_2
    //   3122: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3125: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3128: ifne +2356 -> 5484
    //   3131: new 151	java/lang/StringBuilder
    //   3134: dup
    //   3135: ldc_w 513
    //   3138: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3141: aload_0
    //   3142: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3145: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: ldc_w 515
    //   3151: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3154: aload 14
    //   3156: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3159: ldc_w 520
    //   3162: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: aload 13
    //   3167: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: ldc_w 522
    //   3173: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3176: ldc_w 524
    //   3179: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3182: ldc_w 526
    //   3185: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3188: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3191: invokevirtual 199	java/lang/Thread:getId	()J
    //   3194: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3197: ldc_w 528
    //   3200: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3206: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3209: ldc_w 530
    //   3212: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3215: aload_0
    //   3216: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   3219: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3222: ldc_w 532
    //   3225: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: aload_0
    //   3229: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   3232: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3235: ldc_w 534
    //   3238: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3241: astore 16
    //   3243: aload_0
    //   3244: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   3247: ifeq +2225 -> 5472
    //   3250: aload_0
    //   3251: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3254: aload_0
    //   3255: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   3258: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3261: astore 13
    //   3263: aload 16
    //   3265: aload 13
    //   3267: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3270: ldc_w 536
    //   3273: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3276: aload_0
    //   3277: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3280: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3283: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3286: ldc_w 538
    //   3289: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: aload_2
    //   3293: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3296: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3299: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3302: ldc_w 540
    //   3305: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3308: aload_2
    //   3309: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3312: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3315: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3318: ldc_w 545
    //   3321: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3324: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   3327: aload_0
    //   3328: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   3331: lsub
    //   3332: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3335: ldc_w 547
    //   3338: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: aload_2
    //   3342: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3345: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3348: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3351: ldc_w 459
    //   3354: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3357: aload_2
    //   3358: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3361: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3364: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3367: ldc_w 555
    //   3370: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: aload_2
    //   3374: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3377: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3380: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3383: ldc_w 560
    //   3386: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3389: aload_0
    //   3390: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   3393: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3396: ldc_w 459
    //   3399: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3402: aload_0
    //   3403: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   3406: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3409: ldc_w 564
    //   3412: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3415: iload 5
    //   3417: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3420: ldc_w 566
    //   3423: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: aload_2
    //   3427: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3430: invokevirtual 441	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3433: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3436: ldc_w 568
    //   3439: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: iload_3
    //   3443: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3446: ldc_w 570
    //   3449: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3452: aload_0
    //   3453: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   3456: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: ldc_w 574
    //   3462: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3465: astore 13
    //   3467: aload_0
    //   3468: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3471: ifnull +2007 -> 5478
    //   3474: aload_0
    //   3475: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3478: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3481: istore 4
    //   3483: ldc 149
    //   3485: aload 13
    //   3487: iload 4
    //   3489: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3492: ldc_w 576
    //   3495: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: aload_2
    //   3499: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3502: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3505: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3508: ldc_w 581
    //   3511: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3514: aload_0
    //   3515: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   3518: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3521: ldc_w 585
    //   3524: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3527: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3530: aconst_null
    //   3531: invokestatic 470	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3534: getstatic 231	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3537: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3540: aload_0
    //   3541: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3544: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3547: if_icmpne +35 -> 3582
    //   3550: aload_0
    //   3551: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3554: ifnull +28 -> 3582
    //   3557: aload_0
    //   3558: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3561: aload_0
    //   3562: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   3565: aload_0
    //   3566: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   3569: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3572: aload_2
    //   3573: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3576: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3579: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3582: getstatic 345	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3585: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3588: aload_0
    //   3589: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3592: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3595: if_icmpne +35 -> 3630
    //   3598: aload_0
    //   3599: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3602: ifnull +28 -> 3630
    //   3605: aload_0
    //   3606: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3609: aload_0
    //   3610: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   3613: aload_0
    //   3614: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   3617: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3620: aload_2
    //   3621: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3624: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3627: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3630: aload 15
    //   3632: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   3635: putfield 593	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   3638: aload 15
    //   3640: aload_0
    //   3641: getfield 594	com/tencent/component/network/downloader/impl/h:d	J
    //   3644: putfield 596	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   3647: aload 15
    //   3649: aload_0
    //   3650: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   3653: putfield 598	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   3656: aload 15
    //   3658: iload_3
    //   3659: putfield 600	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   3662: aload 15
    //   3664: aconst_null
    //   3665: putfield 603	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   3668: aload 14
    //   3670: ifnonnull +2229 -> 5899
    //   3673: aconst_null
    //   3674: astore 13
    //   3676: aload 15
    //   3678: aload 13
    //   3680: putfield 606	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   3683: aload_0
    //   3684: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3687: ifnull +2222 -> 5909
    //   3690: aload_0
    //   3691: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3694: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3697: ifnull +2212 -> 5909
    //   3700: aload_0
    //   3701: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3704: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3707: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   3710: astore 13
    //   3712: aload 15
    //   3714: aload 13
    //   3716: putfield 610	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   3719: aload 15
    //   3721: aload_2
    //   3722: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3725: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3728: putfield 612	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   3731: aload_2
    //   3732: aload 15
    //   3734: invokevirtual 616	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   3737: aload_0
    //   3738: aload_2
    //   3739: aload 15
    //   3741: invokevirtual 619	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   3744: aload_0
    //   3745: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   3748: ifnull +10 -> 3758
    //   3751: aload_0
    //   3752: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   3755: invokevirtual 624	org/apache/http/client/methods/HttpGet:abort	()V
    //   3758: iload 5
    //   3760: istore_3
    //   3761: goto -3599 -> 162
    //   3764: aload_2
    //   3765: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3768: iconst_3
    //   3769: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3772: iconst_0
    //   3773: istore_3
    //   3774: goto -797 -> 2977
    //   3777: ldc_w 524
    //   3780: astore 14
    //   3782: goto -3336 -> 446
    //   3785: ldc_w 706
    //   3788: astore 12
    //   3790: goto -3335 -> 455
    //   3793: aconst_null
    //   3794: astore 14
    //   3796: goto -3123 -> 673
    //   3799: iconst_0
    //   3800: istore 5
    //   3802: goto -2909 -> 893
    //   3805: new 151	java/lang/StringBuilder
    //   3808: dup
    //   3809: ldc_w 708
    //   3812: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3815: aload_0
    //   3816: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3819: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3822: ldc_w 515
    //   3825: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3828: aload 16
    //   3830: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3833: ldc_w 520
    //   3836: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: aload 14
    //   3841: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3844: ldc_w 522
    //   3847: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: ldc_w 524
    //   3853: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3856: ldc_w 526
    //   3859: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3865: invokevirtual 199	java/lang/Thread:getId	()J
    //   3868: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3871: ldc_w 528
    //   3874: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3880: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3883: ldc_w 530
    //   3886: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3889: aload_0
    //   3890: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   3893: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3896: ldc_w 532
    //   3899: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: aload_0
    //   3903: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   3906: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3909: ldc_w 534
    //   3912: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3915: astore 17
    //   3917: aload_0
    //   3918: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   3921: ifeq +257 -> 4178
    //   3924: aload_0
    //   3925: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3928: aload_0
    //   3929: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   3932: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3935: astore 14
    //   3937: aload 17
    //   3939: aload 14
    //   3941: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3944: ldc_w 540
    //   3947: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3950: aload_2
    //   3951: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3954: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3957: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3960: ldc_w 545
    //   3963: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3966: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   3969: aload_0
    //   3970: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   3973: lsub
    //   3974: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3977: ldc_w 547
    //   3980: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3983: aload_2
    //   3984: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3987: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3990: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3993: ldc_w 459
    //   3996: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3999: aload_2
    //   4000: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4003: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4006: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4009: ldc_w 555
    //   4012: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: aload_2
    //   4016: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4019: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4022: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4025: ldc_w 560
    //   4028: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4031: aload_0
    //   4032: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   4035: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4038: ldc_w 459
    //   4041: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4044: aload_0
    //   4045: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   4048: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4051: ldc_w 564
    //   4054: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4057: iload 4
    //   4059: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4062: ldc_w 710
    //   4065: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: iload_3
    //   4069: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4072: ldc_w 538
    //   4075: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4078: aload_2
    //   4079: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4082: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4085: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4088: ldc_w 570
    //   4091: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4094: aload_0
    //   4095: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   4098: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: ldc_w 574
    //   4104: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4107: astore 14
    //   4109: aload_0
    //   4110: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4113: ifnull +71 -> 4184
    //   4116: aload_0
    //   4117: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4120: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4123: istore 5
    //   4125: ldc 149
    //   4127: aload 14
    //   4129: iload 5
    //   4131: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4134: ldc_w 576
    //   4137: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4140: aload_2
    //   4141: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4144: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4147: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4150: ldc_w 581
    //   4153: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4156: aload_0
    //   4157: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   4160: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4163: ldc_w 585
    //   4166: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4169: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4172: invokestatic 209	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   4175: goto -3230 -> 945
    //   4178: aconst_null
    //   4179: astore 14
    //   4181: goto -244 -> 3937
    //   4184: iconst_0
    //   4185: istore 5
    //   4187: goto -62 -> 4125
    //   4190: astore 14
    //   4192: ldc 149
    //   4194: ldc_w 382
    //   4197: aload 14
    //   4199: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4202: goto -3209 -> 993
    //   4205: astore 14
    //   4207: ldc 149
    //   4209: ldc_w 382
    //   4212: aload 14
    //   4214: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4217: goto -3176 -> 1041
    //   4220: aload 16
    //   4222: invokevirtual 715	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4225: astore 13
    //   4227: goto -3139 -> 1088
    //   4230: ldc_w 717
    //   4233: astore 13
    //   4235: goto -3111 -> 1124
    //   4238: astore 12
    //   4240: iconst_0
    //   4241: istore_3
    //   4242: aload 14
    //   4244: astore 13
    //   4246: iload 4
    //   4248: iconst_1
    //   4249: iadd
    //   4250: istore 4
    //   4252: aload_2
    //   4253: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4256: lload 9
    //   4258: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   4261: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4264: aload_0
    //   4265: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4268: invokestatic 488	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   4271: invokevirtual 491	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4274: astore 16
    //   4276: aload_0
    //   4277: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4280: ifnull +735 -> 5015
    //   4283: aload_0
    //   4284: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4287: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4290: ifnull +725 -> 5015
    //   4293: aload_0
    //   4294: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4297: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4300: invokevirtual 496	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4303: astore 14
    //   4305: aload_2
    //   4306: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4309: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4312: ifne +60 -> 4372
    //   4315: aload_0
    //   4316: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4319: ifnull +24 -> 4343
    //   4322: aload_0
    //   4323: getfield 502	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4326: aload_0
    //   4327: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   4330: aload_2
    //   4331: invokevirtual 505	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4334: aload_0
    //   4335: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   4338: invokeinterface 511 4 0
    //   4343: aload_0
    //   4344: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4347: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4350: ifne +22 -> 4372
    //   4353: aload_0
    //   4354: aload_0
    //   4355: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   4358: iconst_1
    //   4359: isub
    //   4360: putfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   4363: aload_2
    //   4364: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4367: bipush 6
    //   4369: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4372: aload_1
    //   4373: invokeinterface 393 1 0
    //   4378: ifne +620 -> 4998
    //   4381: aload_2
    //   4382: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4385: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4388: ifne +646 -> 5034
    //   4391: new 151	java/lang/StringBuilder
    //   4394: dup
    //   4395: ldc_w 513
    //   4398: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4401: aload_0
    //   4402: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   4405: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4408: ldc_w 515
    //   4411: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4414: aload 16
    //   4416: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4419: ldc_w 520
    //   4422: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4425: aload 14
    //   4427: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4430: ldc_w 522
    //   4433: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4436: ldc_w 524
    //   4439: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4442: ldc_w 526
    //   4445: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4448: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4451: invokevirtual 199	java/lang/Thread:getId	()J
    //   4454: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4457: ldc_w 528
    //   4460: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4463: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4466: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4469: ldc_w 530
    //   4472: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4475: aload_0
    //   4476: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   4479: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4482: ldc_w 532
    //   4485: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4488: aload_0
    //   4489: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   4492: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4495: ldc_w 534
    //   4498: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4501: astore 14
    //   4503: aload_0
    //   4504: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   4507: ifeq +516 -> 5023
    //   4510: aload_0
    //   4511: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4514: aload_0
    //   4515: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   4518: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4521: astore_1
    //   4522: aload 14
    //   4524: aload_1
    //   4525: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4528: ldc_w 536
    //   4531: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4534: aload_0
    //   4535: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4538: invokestatic 403	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4541: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4544: ldc_w 538
    //   4547: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4550: aload_2
    //   4551: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4554: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4557: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4560: ldc_w 540
    //   4563: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4566: aload_2
    //   4567: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4570: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4573: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4576: ldc_w 545
    //   4579: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4582: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   4585: aload_0
    //   4586: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   4589: lsub
    //   4590: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4593: ldc_w 547
    //   4596: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4599: aload_2
    //   4600: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4603: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4606: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4609: ldc_w 459
    //   4612: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: aload_2
    //   4616: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4619: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4622: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4625: ldc_w 555
    //   4628: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4631: aload_2
    //   4632: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4635: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4638: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4641: ldc_w 560
    //   4644: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4647: aload_0
    //   4648: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   4651: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4654: ldc_w 459
    //   4657: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4660: aload_0
    //   4661: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   4664: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4667: ldc_w 564
    //   4670: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4673: iload 4
    //   4675: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4678: ldc_w 566
    //   4681: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4684: aload_2
    //   4685: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4688: invokevirtual 441	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4691: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4694: ldc_w 568
    //   4697: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4700: iload_3
    //   4701: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4704: ldc_w 570
    //   4707: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4710: aload_0
    //   4711: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   4714: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4717: ldc_w 574
    //   4720: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4723: astore_1
    //   4724: aload_0
    //   4725: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4728: ifnull +300 -> 5028
    //   4731: aload_0
    //   4732: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4735: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4738: istore 4
    //   4740: ldc 149
    //   4742: aload_1
    //   4743: iload 4
    //   4745: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4748: ldc_w 576
    //   4751: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4754: aload_2
    //   4755: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4758: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4761: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4764: ldc_w 581
    //   4767: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4770: aload_0
    //   4771: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   4774: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4777: ldc_w 585
    //   4780: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4783: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4786: aload 13
    //   4788: invokestatic 470	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4791: getstatic 231	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4794: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4797: aload_0
    //   4798: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4801: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4804: if_icmpne +35 -> 4839
    //   4807: aload_0
    //   4808: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4811: ifnull +28 -> 4839
    //   4814: aload_0
    //   4815: getfield 260	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4818: aload_0
    //   4819: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   4822: aload_0
    //   4823: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   4826: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4829: aload_2
    //   4830: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4833: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4836: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4839: getstatic 345	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4842: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4845: aload_0
    //   4846: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4849: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4852: if_icmpne +35 -> 4887
    //   4855: aload_0
    //   4856: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4859: ifnull +28 -> 4887
    //   4862: aload_0
    //   4863: getfield 327	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4866: aload_0
    //   4867: invokevirtual 100	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   4870: aload_0
    //   4871: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   4874: invokestatic 587	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4877: aload_2
    //   4878: invokevirtual 433	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4881: invokevirtual 499	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4884: invokevirtual 591	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4887: aload 15
    //   4889: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   4892: putfield 593	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   4895: aload 15
    //   4897: aload_0
    //   4898: getfield 594	com/tencent/component/network/downloader/impl/h:d	J
    //   4901: putfield 596	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   4904: aload 15
    //   4906: aload_0
    //   4907: getfield 53	com/tencent/component/network/downloader/impl/h:z	Lorg/apache/http/HttpResponse;
    //   4910: putfield 598	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   4913: aload 15
    //   4915: iload_3
    //   4916: putfield 600	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   4919: aload 15
    //   4921: aload 13
    //   4923: putfield 603	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   4926: aload 16
    //   4928: ifnonnull +512 -> 5440
    //   4931: aconst_null
    //   4932: astore_1
    //   4933: aload 15
    //   4935: aload_1
    //   4936: putfield 606	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   4939: aload_0
    //   4940: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4943: ifnull +506 -> 5449
    //   4946: aload_0
    //   4947: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4950: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4953: ifnull +496 -> 5449
    //   4956: aload_0
    //   4957: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4960: invokevirtual 495	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4963: getfield 608	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   4966: astore_1
    //   4967: aload 15
    //   4969: aload_1
    //   4970: putfield 610	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   4973: aload 15
    //   4975: aload_2
    //   4976: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4979: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4982: putfield 612	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   4985: aload_2
    //   4986: aload 15
    //   4988: invokevirtual 616	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   4991: aload_0
    //   4992: aload_2
    //   4993: aload 15
    //   4995: invokevirtual 619	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   4998: aload_0
    //   4999: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   5002: ifnull +10 -> 5012
    //   5005: aload_0
    //   5006: getfield 421	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   5009: invokevirtual 624	org/apache/http/client/methods/HttpGet:abort	()V
    //   5012: aload 12
    //   5014: athrow
    //   5015: ldc_w 524
    //   5018: astore 14
    //   5020: goto -715 -> 4305
    //   5023: aconst_null
    //   5024: astore_1
    //   5025: goto -503 -> 4522
    //   5028: iconst_0
    //   5029: istore 4
    //   5031: goto -291 -> 4740
    //   5034: new 151	java/lang/StringBuilder
    //   5037: dup
    //   5038: ldc_w 708
    //   5041: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5044: aload_0
    //   5045: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   5048: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5051: ldc_w 515
    //   5054: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5057: aload 16
    //   5059: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5062: ldc_w 520
    //   5065: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5068: aload 14
    //   5070: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5073: ldc_w 522
    //   5076: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5079: ldc_w 524
    //   5082: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5085: ldc_w 526
    //   5088: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5094: invokevirtual 199	java/lang/Thread:getId	()J
    //   5097: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5100: ldc_w 528
    //   5103: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5106: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5109: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5112: ldc_w 530
    //   5115: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5118: aload_0
    //   5119: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   5122: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5125: ldc_w 532
    //   5128: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5131: aload_0
    //   5132: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   5135: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5138: ldc_w 534
    //   5141: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5144: astore 14
    //   5146: aload_0
    //   5147: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   5150: ifeq +253 -> 5403
    //   5153: aload_0
    //   5154: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   5157: aload_0
    //   5158: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   5161: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5164: astore_1
    //   5165: aload 14
    //   5167: aload_1
    //   5168: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5171: ldc_w 540
    //   5174: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5177: aload_2
    //   5178: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5181: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5184: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5187: ldc_w 545
    //   5190: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5193: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   5196: aload_0
    //   5197: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   5200: lsub
    //   5201: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5204: ldc_w 547
    //   5207: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: aload_2
    //   5211: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5214: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5217: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5220: ldc_w 459
    //   5223: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: aload_2
    //   5227: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5230: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5233: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5236: ldc_w 555
    //   5239: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5242: aload_2
    //   5243: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5246: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5249: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5252: ldc_w 560
    //   5255: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5258: aload_0
    //   5259: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   5262: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5265: ldc_w 459
    //   5268: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5271: aload_0
    //   5272: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   5275: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5278: ldc_w 564
    //   5281: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5284: iload 4
    //   5286: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5289: ldc_w 710
    //   5292: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5295: iload_3
    //   5296: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5299: ldc_w 538
    //   5302: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5305: aload_2
    //   5306: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5309: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5312: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: ldc_w 570
    //   5318: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5321: aload_0
    //   5322: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   5325: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5328: ldc_w 574
    //   5331: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5334: astore_1
    //   5335: aload_0
    //   5336: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5339: ifnull +69 -> 5408
    //   5342: aload_0
    //   5343: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5346: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5349: istore 4
    //   5351: ldc 149
    //   5353: aload_1
    //   5354: iload 4
    //   5356: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5359: ldc_w 576
    //   5362: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5365: aload_2
    //   5366: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5369: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5372: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5375: ldc_w 581
    //   5378: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: aload_0
    //   5382: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   5385: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5388: ldc_w 585
    //   5391: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5394: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5397: invokestatic 209	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   5400: goto -609 -> 4791
    //   5403: aconst_null
    //   5404: astore_1
    //   5405: goto -240 -> 5165
    //   5408: iconst_0
    //   5409: istore 4
    //   5411: goto -60 -> 5351
    //   5414: astore_1
    //   5415: ldc 149
    //   5417: ldc_w 382
    //   5420: aload_1
    //   5421: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5424: goto -585 -> 4839
    //   5427: astore_1
    //   5428: ldc 149
    //   5430: ldc_w 382
    //   5433: aload_1
    //   5434: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5437: goto -550 -> 4887
    //   5440: aload 16
    //   5442: invokevirtual 715	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5445: astore_1
    //   5446: goto -513 -> 4933
    //   5449: ldc_w 717
    //   5452: astore_1
    //   5453: goto -486 -> 4967
    //   5456: ldc_w 524
    //   5459: astore 13
    //   5461: goto -2425 -> 3036
    //   5464: ldc_w 706
    //   5467: astore 12
    //   5469: goto -2424 -> 3045
    //   5472: aconst_null
    //   5473: astore 13
    //   5475: goto -2212 -> 3263
    //   5478: iconst_0
    //   5479: istore 4
    //   5481: goto -1998 -> 3483
    //   5484: new 151	java/lang/StringBuilder
    //   5487: dup
    //   5488: ldc_w 708
    //   5491: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5494: aload_0
    //   5495: invokevirtual 97	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   5498: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5501: ldc_w 515
    //   5504: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5507: aload 14
    //   5509: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5512: ldc_w 520
    //   5515: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5518: aload 13
    //   5520: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5523: ldc_w 522
    //   5526: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5529: ldc_w 524
    //   5532: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5535: ldc_w 526
    //   5538: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5541: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5544: invokevirtual 199	java/lang/Thread:getId	()J
    //   5547: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5550: ldc_w 528
    //   5553: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5556: invokestatic 183	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5559: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: ldc_w 530
    //   5565: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5568: aload_0
    //   5569: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   5572: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5575: ldc_w 532
    //   5578: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5581: aload_0
    //   5582: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   5585: invokevirtual 462	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5588: ldc_w 534
    //   5591: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5594: astore 16
    //   5596: aload_0
    //   5597: getfield 214	com/tencent/component/network/downloader/impl/h:p	Z
    //   5600: ifeq +257 -> 5857
    //   5603: aload_0
    //   5604: getfield 88	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   5607: aload_0
    //   5608: getfield 219	com/tencent/component/network/downloader/impl/h:q	Z
    //   5611: invokestatic 362	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5614: astore 13
    //   5616: aload 16
    //   5618: aload 13
    //   5620: invokevirtual 518	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5623: ldc_w 540
    //   5626: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5629: aload_2
    //   5630: invokevirtual 477	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5633: getfield 543	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5636: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5639: ldc_w 545
    //   5642: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5645: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   5648: aload_0
    //   5649: getfield 47	com/tencent/component/network/downloader/impl/h:u	J
    //   5652: lsub
    //   5653: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5656: ldc_w 547
    //   5659: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5662: aload_2
    //   5663: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5666: getfield 550	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5669: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5672: ldc_w 459
    //   5675: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5678: aload_2
    //   5679: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5682: getfield 553	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5685: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5688: ldc_w 555
    //   5691: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5694: aload_2
    //   5695: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5698: getfield 558	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5701: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5704: ldc_w 560
    //   5707: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5710: aload_0
    //   5711: getfield 423	com/tencent/component/network/downloader/impl/h:c	I
    //   5714: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5717: ldc_w 459
    //   5720: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5723: aload_0
    //   5724: getfield 562	com/tencent/component/network/downloader/impl/h:b	I
    //   5727: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5730: ldc_w 564
    //   5733: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5736: iload 5
    //   5738: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5741: ldc_w 710
    //   5744: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5747: iload_3
    //   5748: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5751: ldc_w 538
    //   5754: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5757: aload_2
    //   5758: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5761: getfield 453	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5764: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5767: ldc_w 570
    //   5770: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5773: aload_0
    //   5774: getfield 572	com/tencent/component/network/downloader/impl/h:r	Ljava/lang/String;
    //   5777: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5780: ldc_w 574
    //   5783: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5786: astore 13
    //   5788: aload_0
    //   5789: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5792: ifnull +71 -> 5863
    //   5795: aload_0
    //   5796: getfield 140	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5799: getfield 117	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5802: istore 4
    //   5804: ldc 149
    //   5806: aload 13
    //   5808: iload 4
    //   5810: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5813: ldc_w 576
    //   5816: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5819: aload_2
    //   5820: invokevirtual 448	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5823: getfield 579	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5826: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5829: ldc_w 581
    //   5832: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5835: aload_0
    //   5836: invokevirtual 583	com/tencent/component/network/downloader/impl/h:n	()I
    //   5839: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5842: ldc_w 585
    //   5845: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5848: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5851: invokestatic 209	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   5854: goto -2320 -> 3534
    //   5857: aconst_null
    //   5858: astore 13
    //   5860: goto -244 -> 5616
    //   5863: iconst_0
    //   5864: istore 4
    //   5866: goto -62 -> 5804
    //   5869: astore 13
    //   5871: ldc 149
    //   5873: ldc_w 382
    //   5876: aload 13
    //   5878: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5881: goto -2299 -> 3582
    //   5884: astore 13
    //   5886: ldc 149
    //   5888: ldc_w 382
    //   5891: aload 13
    //   5893: invokestatic 712	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5896: goto -2266 -> 3630
    //   5899: aload 14
    //   5901: invokevirtual 715	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5904: astore 13
    //   5906: goto -2230 -> 3676
    //   5909: ldc_w 717
    //   5912: astore 13
    //   5914: goto -2202 -> 3712
    //   5917: astore 13
    //   5919: goto -5870 -> 49
    //   5922: astore 12
    //   5924: aload 14
    //   5926: astore 13
    //   5928: goto -1682 -> 4246
    //   5931: astore 12
    //   5933: goto -1687 -> 4246
    //   5936: astore 13
    //   5938: goto -5560 -> 378
    //   5941: iload 4
    //   5943: istore_3
    //   5944: goto -5775 -> 169
    //   5947: iload_3
    //   5948: istore 4
    //   5950: goto -5917 -> 33
    //   5953: iload 4
    //   5955: istore_3
    //   5956: goto -5794 -> 162
    //   5959: goto -2982 -> 2977
    //   5962: iload 4
    //   5964: istore_3
    //   5965: goto -5796 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5968	0	this	h
    //   0	5968	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	5968	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   161	5804	3	i	int
    //   1	5962	4	j	int
    //   204	5533	5	k	int
    //   26	76	6	m	int
    //   31	45	7	l1	long
    //   88	4169	9	l2	long
    //   152	3	11	bool	boolean
    //   6	3783	12	localObject1	Object
    //   4238	775	12	localObject2	Object
    //   5467	1	12	str1	String
    //   5922	1	12	localObject3	Object
    //   5931	1	12	localObject4	Object
    //   142	155	13	str2	String
    //   364	8	13	localThrowable1	java.lang.Throwable
    //   374	702	13	localThrowable2	java.lang.Throwable
    //   1086	4773	13	localObject5	Object
    //   5869	8	13	localException1	Exception
    //   5884	8	13	localException2	Exception
    //   5904	9	13	str3	String
    //   5917	1	13	localException3	Exception
    //   5926	1	13	localObject6	Object
    //   5936	1	13	localThrowable3	java.lang.Throwable
    //   139	4041	14	localObject7	Object
    //   4190	8	14	localException4	Exception
    //   4205	38	14	localException5	Exception
    //   4303	1622	14	localObject8	Object
    //   97	4897	15	localConst	Const
    //   415	5202	16	localObject9	Object
    //   651	3287	17	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	188	353	java/lang/Throwable
    //   188	352	353	java/lang/Throwable
    //   144	154	364	java/lang/Throwable
    //   371	374	374	java/lang/Throwable
    //   1176	1275	374	java/lang/Throwable
    //   1275	1289	374	java/lang/Throwable
    //   1293	1304	374	java/lang/Throwable
    //   1307	1314	374	java/lang/Throwable
    //   1318	1346	374	java/lang/Throwable
    //   1350	1374	374	java/lang/Throwable
    //   1378	1453	374	java/lang/Throwable
    //   1453	1472	374	java/lang/Throwable
    //   1472	1525	374	java/lang/Throwable
    //   1525	1603	374	java/lang/Throwable
    //   2425	2436	374	java/lang/Throwable
    //   3764	3772	374	java/lang/Throwable
    //   2222	2247	2846	java/lang/Exception
    //   2270	2295	2859	java/lang/Exception
    //   968	993	4190	java/lang/Exception
    //   1016	1041	4205	java/lang/Exception
    //   371	374	4238	finally
    //   1176	1275	4238	finally
    //   1275	1289	4238	finally
    //   1293	1304	4238	finally
    //   1307	1314	4238	finally
    //   1318	1346	4238	finally
    //   1350	1374	4238	finally
    //   1378	1453	4238	finally
    //   1453	1472	4238	finally
    //   1472	1525	4238	finally
    //   1525	1603	4238	finally
    //   2425	2436	4238	finally
    //   3764	3772	4238	finally
    //   4814	4839	5414	java/lang/Exception
    //   4862	4887	5427	java/lang/Exception
    //   3557	3582	5869	java/lang/Exception
    //   3605	3630	5884	java/lang/Exception
    //   43	49	5917	java/lang/Exception
    //   1603	1611	5922	finally
    //   1625	1646	5922	finally
    //   2888	2903	5922	finally
    //   2910	2919	5922	finally
    //   2943	2948	5922	finally
    //   2948	2977	5922	finally
    //   378	387	5931	finally
    //   1603	1611	5936	java/lang/Throwable
    //   1625	1646	5936	java/lang/Throwable
    //   2888	2903	5936	java/lang/Throwable
    //   2910	2919	5936	java/lang/Throwable
    //   2943	2948	5936	java/lang/Throwable
    //   2948	2977	5936	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.h
 * JD-Core Version:    0.7.0.1
 */