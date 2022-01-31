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
import com.tencent.component.network.utils.NetworkUtils.NetworkProxy;
import java.net.UnknownHostException;
import org.apache.http.client.HttpClient;

public final class e
  extends a
{
  private boolean p;
  private boolean q;
  private final long r = SystemClock.uptimeMillis();
  private String s;
  private String t;
  private int u = 0;
  private String v;
  private NetworkUtils.NetworkProxy w;
  private String x = "";
  
  public e(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean);
  }
  
  private boolean b(int paramInt)
    throws UnknownHostException
  {
    int i = 80;
    String str2 = k();
    if (this.e == null) {
      this.e = DownloadGlobalStrategy.getInstance(this.a).getStrategyLib(j(), k());
    }
    this.f = this.g;
    this.g = this.e.getStrategyInfo(paramInt);
    Const.c("downloader", "downloader strategy: " + this.g.toString() + " currAttempCount:" + paramInt + " best:" + this.e.getBestId() + " url:" + j() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    this.p = this.g.allowProxy;
    this.q = this.g.useConfigApn;
    paramInt = this.e.getPort();
    if (!Const.a(paramInt))
    {
      this.e.setPort(80);
      paramInt = i;
    }
    for (;;)
    {
      String str1;
      Object localObject;
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.f.id)
          {
            if ((this.n == null) || (!this.n.supportExtraPort(str2))) {
              break label473;
            }
            i = this.n.changePort(str2, paramInt);
            if ((i == paramInt) || (!Const.a(i)))
            {
              Const.c("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
        str1 = this.e.getBackupIP();
        localObject = str1;
        if (this.m != null)
        {
          localObject = str1;
          if (!this.m.isIPValid(str2, str1))
          {
            this.e.setBackupIP(null);
            localObject = this.m.resolveIP(str2);
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label501;
            }
            this.e.setBackupIP((String)localObject);
          }
        }
        if ((localObject == null) || (((String)localObject).equals(this.e.getDirectIP())) || (((String)localObject).equals(this.e.getDnsIP())))
        {
          Const.c("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          label473:
          Const.c("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
          label501:
          Const.c("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)localObject, i));
      }
      for (;;)
      {
        return true;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.g.id)
        {
          i = paramInt;
          if (this.f != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.f.id)
            {
              if ((this.n == null) || (!this.n.supportExtraPort(str2))) {
                break label771;
              }
              i = this.n.changePort(str2, paramInt);
              if ((i == paramInt) || (!Const.a(i)))
              {
                Const.c("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
          localObject = com.tencent.component.network.module.common.a.a().a(str2);
          if ((localObject == null) || (((String)localObject).equals(this.e.getBackupIP())) || (((String)localObject).equals(this.e.getDirectIP())))
          {
            this.e.setDnsIP(null);
            Const.c("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            label771:
            Const.c("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.e.setDnsIP((String)localObject);
          this.g = this.g.clone();
          this.g.setIPInfo(new IPInfo((String)localObject, i));
        }
        else
        {
          if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.g.id)
          {
            i = paramInt;
            if (this.f != null)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.f.id)
              {
                if ((this.n == null) || (!this.n.supportExtraPort(str2))) {
                  break label1107;
                }
                i = this.n.changePort(str2, paramInt);
                if ((i == paramInt) || (!Const.a(i)))
                {
                  Const.c("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                  return false;
                }
              }
            }
          }
          label1107:
          do
          {
            str1 = this.e.getDirectIP();
            localObject = str1;
            if (this.l != null)
            {
              localObject = str1;
              if (!this.l.isIPValid(str2, str1))
              {
                this.e.setDirectIP(null);
                localObject = this.l.resolveIP(str2);
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  break label1289;
                }
                this.e.setDirectIP((String)localObject);
              }
            }
            if ((localObject != null) && (!((String)localObject).equals(this.e.getBackupIP())) && (!((String)localObject).equals(this.e.getDnsIP()))) {
              break label1318;
            }
            Const.c("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            Const.c("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.g.id) {
              break;
            }
            i = paramInt;
          } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.g.id);
          localObject = this.a;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.g.id) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = NetworkUtils.getProxy((Context)localObject, bool);
            if (localObject != null) {
              break;
            }
            Const.c("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
            return false;
          }
          if (((NetworkUtils.NetworkProxy)localObject).equals(this.w))
          {
            Const.c("downloader", "downloader strategy: proxy 重复. Pass! threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.w = ((NetworkUtils.NetworkProxy)localObject);
          return true;
          label1289:
          Const.c("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
          label1318:
          this.g = this.g.clone();
          this.g.setIPInfo(new IPInfo((String)localObject, i));
        }
      }
    }
  }
  
  protected final void a()
  {
    super.a();
    this.t = Const.c(j());
    this.u = Const.d(j());
    this.v = com.tencent.component.network.utils.a.e.a(j());
  }
  
  /* Error */
  public final void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 314	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 319	com/tencent/component/network/downloader/impl/a$b:a	([Ljava/lang/Object;)I
    //   18: istore 6
    //   20: iconst_0
    //   21: istore 4
    //   23: lconst_0
    //   24: lstore 7
    //   26: aload_1
    //   27: invokeinterface 325 1 0
    //   32: ifeq +4 -> 36
    //   35: return
    //   36: aload_0
    //   37: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   40: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   43: ifne +13 -> 56
    //   46: aload_2
    //   47: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   50: bipush 6
    //   52: invokevirtual 340	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   55: return
    //   56: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   59: lstore 9
    //   61: new 139	com/tencent/component/network/downloader/impl/ipc/Const
    //   64: dup
    //   65: invokespecial 342	com/tencent/component/network/downloader/impl/ipc/Const:<init>	()V
    //   68: astore 20
    //   70: aload 20
    //   72: iload 6
    //   74: putfield 344	com/tencent/component/network/downloader/impl/ipc/Const:a	I
    //   77: aload 20
    //   79: aload_0
    //   80: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   83: putfield 346	com/tencent/component/network/downloader/impl/ipc/Const:b	Ljava/lang/String;
    //   86: aload_0
    //   87: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   90: pop
    //   91: aload 20
    //   93: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   96: putfield 353	com/tencent/component/network/downloader/impl/ipc/Const:c	J
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   104: aconst_null
    //   105: astore 19
    //   107: aconst_null
    //   108: astore 18
    //   110: aconst_null
    //   111: astore 16
    //   113: aload_0
    //   114: ldc 34
    //   116: putfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   119: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   122: lstore 11
    //   124: aload_0
    //   125: aload_0
    //   126: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   129: invokespecial 361	com/tencent/component/network/downloader/impl/e:b	(I)Z
    //   132: istore 15
    //   134: iload 15
    //   136: ifne +21 -> 157
    //   139: iload 4
    //   141: istore_3
    //   142: aload_0
    //   143: invokevirtual 363	com/tencent/component/network/downloader/impl/e:d	()Z
    //   146: ifeq -111 -> 35
    //   149: iload_3
    //   150: istore 4
    //   152: goto -126 -> 26
    //   155: astore 16
    //   157: aload 16
    //   159: ifnull +875 -> 1034
    //   162: aload 16
    //   164: athrow
    //   165: astore 18
    //   167: iconst_0
    //   168: istore_3
    //   169: aconst_null
    //   170: astore 16
    //   172: ldc 81
    //   174: ldc 34
    //   176: aload 18
    //   178: invokestatic 366	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_2
    //   182: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   185: aload 18
    //   187: invokevirtual 369	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   190: aload_2
    //   191: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   194: lload 9
    //   196: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   199: invokevirtual 379	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   202: aload_0
    //   203: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   206: invokestatic 384	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   209: invokevirtual 387	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   212: astore 19
    //   214: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   217: pop
    //   218: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   221: pop
    //   222: aload_2
    //   223: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   226: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   229: ifne +29 -> 258
    //   232: aload_0
    //   233: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   236: ifnull +22 -> 258
    //   239: aload_0
    //   240: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   243: aload_0
    //   244: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   247: aload_2
    //   248: invokevirtual 398	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   251: aload 16
    //   253: invokeinterface 404 4 0
    //   258: aload_1
    //   259: invokeinterface 325 1 0
    //   264: ifne +732 -> 996
    //   267: aload_0
    //   268: new 83	java/lang/StringBuilder
    //   271: dup
    //   272: aload_0
    //   273: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   276: invokestatic 408	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: ldc_w 410
    //   285: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_2
    //   289: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   292: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   295: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: ldc_w 421
    //   301: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   308: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: ldc_w 426
    //   314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: putfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   323: aload_2
    //   324: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   327: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   330: ifne +3374 -> 3704
    //   333: new 83	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 428
    //   340: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: aload_0
    //   344: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   347: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 430
    //   353: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 19
    //   358: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: ldc_w 435
    //   364: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aconst_null
    //   368: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc_w 437
    //   374: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aconst_null
    //   378: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc_w 439
    //   384: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   390: invokevirtual 133	java/lang/Thread:getId	()J
    //   393: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   396: ldc_w 441
    //   399: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   405: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 443
    //   411: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   418: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   421: ldc_w 448
    //   424: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   431: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: ldc_w 450
    //   437: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: astore 21
    //   442: aload_0
    //   443: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   446: ifeq +3246 -> 3692
    //   449: aload_0
    //   450: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   453: aload_0
    //   454: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   457: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   460: astore 17
    //   462: aload 21
    //   464: aload 17
    //   466: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: ldc_w 452
    //   472: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_0
    //   476: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   479: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   482: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   485: ldc_w 454
    //   488: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_2
    //   492: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   495: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   498: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc_w 459
    //   504: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_2
    //   508: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   511: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   514: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   517: ldc_w 464
    //   520: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   526: aload_0
    //   527: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   530: lsub
    //   531: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   534: ldc_w 466
    //   537: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_2
    //   541: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   544: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   547: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   550: ldc_w 421
    //   553: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_2
    //   557: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   560: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   563: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   566: ldc_w 471
    //   569: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_2
    //   573: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   576: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   579: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   582: ldc_w 476
    //   585: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_0
    //   589: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   592: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: ldc_w 421
    //   598: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_0
    //   602: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   605: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: ldc_w 480
    //   611: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_2
    //   615: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   618: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   621: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: ldc_w 485
    //   627: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload_3
    //   631: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 487
    //   637: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload_0
    //   641: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   644: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: ldc_w 491
    //   650: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: astore 17
    //   655: aload_0
    //   656: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   659: ifnull +3039 -> 3698
    //   662: aload_0
    //   663: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   666: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   669: istore 5
    //   671: ldc 81
    //   673: aload 17
    //   675: iload 5
    //   677: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 493
    //   683: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_2
    //   687: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   690: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   693: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 498
    //   699: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: lload 7
    //   704: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   707: ldc_w 500
    //   710: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: lconst_0
    //   714: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   717: ldc_w 502
    //   720: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: ldc_w 504
    //   726: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_0
    //   730: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   733: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 506
    //   739: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_0
    //   743: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   746: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   749: ldc_w 510
    //   752: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: aload 18
    //   760: invokestatic 366	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   763: getstatic 165	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   766: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   769: aload_0
    //   770: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   773: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   776: if_icmpne +35 -> 811
    //   779: aload_0
    //   780: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   783: ifnull +28 -> 811
    //   786: aload_0
    //   787: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   790: aload_0
    //   791: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   794: aload_0
    //   795: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   798: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   801: aload_2
    //   802: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   805: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   808: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   811: getstatic 261	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   814: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   817: aload_0
    //   818: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   821: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   824: if_icmpne +35 -> 859
    //   827: aload_0
    //   828: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   831: ifnull +28 -> 859
    //   834: aload_0
    //   835: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   838: aload_0
    //   839: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   842: aload_0
    //   843: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   846: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   849: aload_2
    //   850: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   853: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   856: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   859: aload 20
    //   861: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   864: putfield 518	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   867: aload 20
    //   869: aload_0
    //   870: invokevirtual 520	com/tencent/component/network/downloader/impl/e:g	()J
    //   873: putfield 522	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   876: aload 20
    //   878: aload 16
    //   880: putfield 525	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   883: aload 20
    //   885: iload_3
    //   886: putfield 527	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   889: aload 20
    //   891: aload 18
    //   893: putfield 530	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   896: aload 19
    //   898: ifnonnull +3245 -> 4143
    //   901: aconst_null
    //   902: astore 16
    //   904: aload 20
    //   906: aload 16
    //   908: putfield 533	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   911: aload 20
    //   913: invokestatic 535	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   916: putfield 537	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   919: aload 20
    //   921: aload_2
    //   922: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   925: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   928: putfield 539	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   931: aload 20
    //   933: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   936: aload_0
    //   937: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   940: lsub
    //   941: putfield 541	com/tencent/component/network/downloader/impl/ipc/Const:n	J
    //   944: aload 20
    //   946: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   949: aload_0
    //   950: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   953: lsub
    //   954: aload_2
    //   955: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   958: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   961: lsub
    //   962: putfield 542	com/tencent/component/network/downloader/impl/ipc/Const:o	J
    //   965: aload 20
    //   967: lload 7
    //   969: putfield 544	com/tencent/component/network/downloader/impl/ipc/Const:p	J
    //   972: aload 20
    //   974: aload_0
    //   975: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   978: putfield 546	com/tencent/component/network/downloader/impl/ipc/Const:q	J
    //   981: aload 20
    //   983: aload_0
    //   984: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   987: putfield 548	com/tencent/component/network/downloader/impl/ipc/Const:r	I
    //   990: aload_2
    //   991: aload 20
    //   993: invokevirtual 552	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   996: aload_0
    //   997: aload_2
    //   998: aload 20
    //   1000: invokevirtual 555	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   1003: aload_0
    //   1004: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1007: ifnull +15 -> 1022
    //   1010: aload_0
    //   1011: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1014: invokevirtual 560	org/apache/http/client/methods/HttpGet:abort	()V
    //   1017: aload_0
    //   1018: aconst_null
    //   1019: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1022: aload_0
    //   1023: invokevirtual 562	com/tencent/component/network/downloader/impl/e:m	()V
    //   1026: iload 4
    //   1028: iconst_1
    //   1029: iadd
    //   1030: istore_3
    //   1031: goto -889 -> 142
    //   1034: getstatic 565	com/tencent/component/network/downloader/impl/e:i	Ljava/lang/ThreadLocal;
    //   1037: invokevirtual 571	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1040: checkcast 573	com/tencent/component/network/utils/a/e$b
    //   1043: astore 21
    //   1045: aload 21
    //   1047: aload_0
    //   1048: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   1051: putfield 575	com/tencent/component/network/utils/a/e$b:a	Z
    //   1054: aload 21
    //   1056: aload_0
    //   1057: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   1060: putfield 577	com/tencent/component/network/utils/a/e$b:b	Z
    //   1063: aload 20
    //   1065: iload 4
    //   1067: putfield 579	com/tencent/component/network/downloader/impl/ipc/Const:k	I
    //   1070: aload 20
    //   1072: aload_0
    //   1073: getfield 307	com/tencent/component/network/downloader/impl/e:v	Ljava/lang/String;
    //   1076: putfield 580	com/tencent/component/network/downloader/impl/ipc/Const:s	Ljava/lang/String;
    //   1079: aload_0
    //   1080: aload_0
    //   1081: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1084: putfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   1087: aload_0
    //   1088: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1091: ifnull +225 -> 1316
    //   1094: aload_0
    //   1095: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1098: invokevirtual 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1101: ifnull +215 -> 1316
    //   1104: aload_0
    //   1105: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1108: invokevirtual 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1111: getfield 586	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   1114: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1117: ifne +199 -> 1316
    //   1120: aload_0
    //   1121: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1124: invokevirtual 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1127: getfield 586	com/tencent/component/network/downloader/common/IPInfo:a	Ljava/lang/String;
    //   1130: astore 17
    //   1132: aload_0
    //   1133: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1136: astore 16
    //   1138: aload 17
    //   1140: invokestatic 588	com/tencent/component/network/downloader/impl/ipc/Const:e	(Ljava/lang/String;)I
    //   1143: iconst_2
    //   1144: if_icmpge +97 -> 1241
    //   1147: aload_0
    //   1148: getfield 32	com/tencent/component/network/downloader/impl/e:u	I
    //   1151: istore_3
    //   1152: iload_3
    //   1153: ifle +1183 -> 2336
    //   1156: aload_0
    //   1157: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1160: invokevirtual 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1163: iload_3
    //   1164: putfield 590	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   1167: iload_3
    //   1168: istore 5
    //   1170: iload_3
    //   1171: invokestatic 158	com/tencent/component/network/downloader/impl/ipc/Const:a	(I)Z
    //   1174: ifne +7 -> 1181
    //   1177: bipush 80
    //   1179: istore 5
    //   1181: new 83	java/lang/StringBuilder
    //   1184: dup
    //   1185: aload 17
    //   1187: invokestatic 408	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1190: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1193: ldc_w 592
    //   1196: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: iload 5
    //   1201: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: astore 17
    //   1209: aload 17
    //   1211: astore 16
    //   1213: aload_0
    //   1214: getfield 298	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1217: ifnull +24 -> 1241
    //   1220: aload_0
    //   1221: aload_0
    //   1222: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   1225: aload_0
    //   1226: getfield 298	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1229: aload 17
    //   1231: invokevirtual 596	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1234: putfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   1237: aload 17
    //   1239: astore 16
    //   1241: aload 20
    //   1243: aload_0
    //   1244: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1247: invokevirtual 93	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1250: putfield 598	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   1253: ldc 81
    //   1255: new 83	java/lang/StringBuilder
    //   1258: dup
    //   1259: ldc_w 600
    //   1262: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1265: aload 20
    //   1267: getfield 598	com/tencent/component/network/downloader/impl/ipc/Const:l	Ljava/lang/String;
    //   1270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: ldc_w 602
    //   1276: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: aload 16
    //   1281: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: ldc 110
    //   1286: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_0
    //   1290: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1293: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: ldc 188
    //   1298: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1304: invokevirtual 133	java/lang/Thread:getId	()J
    //   1307: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 604	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1316: aload_0
    //   1317: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1320: astore 16
    //   1322: aload_0
    //   1323: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1326: pop
    //   1327: aload_0
    //   1328: aload 16
    //   1330: aload_0
    //   1331: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1334: aload_0
    //   1335: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   1338: aload_0
    //   1339: getfield 307	com/tencent/component/network/downloader/impl/e:v	Ljava/lang/String;
    //   1342: aload 21
    //   1344: invokestatic 607	com/tencent/component/network/utils/a/e:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   1347: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1350: aload_0
    //   1351: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1354: ifnull +24 -> 1378
    //   1357: aload_0
    //   1358: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1361: aload_0
    //   1362: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1365: aload_0
    //   1366: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1369: aload_0
    //   1370: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1373: invokeinterface 611 4 0
    //   1378: aload_0
    //   1379: aload_0
    //   1380: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1383: aload_0
    //   1384: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1387: aload_0
    //   1388: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1391: invokevirtual 614	com/tencent/component/network/downloader/impl/e:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1394: aload_0
    //   1395: aload_0
    //   1396: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1399: aload_0
    //   1400: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1403: aload_0
    //   1404: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1407: invokevirtual 616	com/tencent/component/network/downloader/impl/e:b	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1410: invokestatic 619	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   1413: astore 16
    //   1415: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   1418: lstore 13
    //   1420: lload 13
    //   1422: lload 11
    //   1424: lsub
    //   1425: lstore 7
    //   1427: aload_0
    //   1428: getfield 622	com/tencent/component/network/downloader/impl/e:j	Lorg/apache/http/client/HttpClient;
    //   1431: aload_0
    //   1432: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1435: aload 16
    //   1437: invokeinterface 628 3 0
    //   1442: astore 16
    //   1444: aload 16
    //   1446: ifnull +2229 -> 3675
    //   1449: aload 16
    //   1451: astore 19
    //   1453: aload 16
    //   1455: invokeinterface 634 1 0
    //   1460: invokeinterface 639 1 0
    //   1465: istore_3
    //   1466: aload_2
    //   1467: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1470: iload_3
    //   1471: putfield 642	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   1474: sipush 200
    //   1477: iload_3
    //   1478: if_icmpeq +10 -> 1488
    //   1481: sipush 206
    //   1484: iload_3
    //   1485: if_icmpne +1315 -> 2800
    //   1488: aload_0
    //   1489: aload 16
    //   1491: aload_2
    //   1492: aload_1
    //   1493: iload_3
    //   1494: invokevirtual 645	com/tencent/component/network/downloader/impl/e:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   1497: ifeq +4472 -> 5969
    //   1500: aload_2
    //   1501: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1504: invokevirtual 648	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   1507: aload_2
    //   1508: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1511: lload 9
    //   1513: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1516: invokevirtual 379	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1519: aload_0
    //   1520: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1523: invokestatic 384	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   1526: invokevirtual 387	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1529: astore 17
    //   1531: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   1534: pop
    //   1535: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   1538: pop
    //   1539: aload_2
    //   1540: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1543: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1546: ifne +29 -> 1575
    //   1549: aload_0
    //   1550: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1553: ifnull +22 -> 1575
    //   1556: aload_0
    //   1557: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1560: aload_0
    //   1561: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1564: aload_2
    //   1565: invokevirtual 398	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1568: aload 16
    //   1570: invokeinterface 404 4 0
    //   1575: aload_1
    //   1576: invokeinterface 325 1 0
    //   1581: ifne +724 -> 2305
    //   1584: aload_0
    //   1585: new 83	java/lang/StringBuilder
    //   1588: dup
    //   1589: aload_0
    //   1590: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   1593: invokestatic 408	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1596: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1599: ldc_w 410
    //   1602: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: aload_2
    //   1606: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1609: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1612: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1615: ldc_w 421
    //   1618: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: aload_0
    //   1622: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   1625: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1628: ldc_w 426
    //   1631: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1637: putfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   1640: aload_2
    //   1641: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1644: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1647: ifne +714 -> 2361
    //   1650: new 83	java/lang/StringBuilder
    //   1653: dup
    //   1654: ldc_w 428
    //   1657: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1660: aload_0
    //   1661: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1664: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: ldc_w 430
    //   1670: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: aload 17
    //   1675: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1678: ldc_w 435
    //   1681: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: aconst_null
    //   1685: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: ldc_w 437
    //   1691: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aconst_null
    //   1695: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: ldc_w 439
    //   1701: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1707: invokevirtual 133	java/lang/Thread:getId	()J
    //   1710: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1713: ldc_w 441
    //   1716: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1722: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: ldc_w 443
    //   1728: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: aload_0
    //   1732: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   1735: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1738: ldc_w 448
    //   1741: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload_0
    //   1745: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   1748: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1751: ldc_w 450
    //   1754: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: astore 18
    //   1759: aload_0
    //   1760: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   1763: ifeq +587 -> 2350
    //   1766: aload_0
    //   1767: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1770: aload_0
    //   1771: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   1774: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   1777: astore_1
    //   1778: aload 18
    //   1780: aload_1
    //   1781: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1784: ldc_w 452
    //   1787: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: aload_0
    //   1791: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1794: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1797: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1800: ldc_w 454
    //   1803: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: aload_2
    //   1807: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1810: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1813: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: ldc_w 459
    //   1819: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: aload_2
    //   1823: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1826: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1829: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1832: ldc_w 464
    //   1835: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1841: aload_0
    //   1842: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   1845: lsub
    //   1846: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1849: ldc_w 466
    //   1852: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_2
    //   1856: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1859: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1862: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1865: ldc_w 421
    //   1868: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: aload_2
    //   1872: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1875: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1878: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1881: ldc_w 471
    //   1884: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1887: aload_2
    //   1888: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1891: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   1894: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1897: ldc_w 476
    //   1900: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: aload_0
    //   1904: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   1907: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1910: ldc_w 421
    //   1913: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_0
    //   1917: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   1920: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1923: ldc_w 480
    //   1926: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_2
    //   1930: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1933: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   1936: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1939: ldc_w 485
    //   1942: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: iload_3
    //   1946: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1949: ldc_w 487
    //   1952: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: aload_0
    //   1956: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   1959: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: ldc_w 491
    //   1965: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: astore_1
    //   1969: aload_0
    //   1970: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1973: ifnull +382 -> 2355
    //   1976: aload_0
    //   1977: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1980: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1983: istore 4
    //   1985: ldc 81
    //   1987: aload_1
    //   1988: iload 4
    //   1990: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1993: ldc_w 493
    //   1996: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: aload_2
    //   2000: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2003: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2006: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: ldc_w 498
    //   2012: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: lload 7
    //   2017: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2020: ldc_w 500
    //   2023: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: lconst_0
    //   2027: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2030: ldc_w 502
    //   2033: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: ldc_w 504
    //   2039: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2042: aload_0
    //   2043: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   2046: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: ldc_w 506
    //   2052: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: aload_0
    //   2056: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   2059: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2062: ldc_w 510
    //   2065: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2071: aconst_null
    //   2072: invokestatic 366	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2075: getstatic 165	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2078: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2081: aload_0
    //   2082: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2085: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2088: if_icmpne +35 -> 2123
    //   2091: aload_0
    //   2092: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2095: ifnull +28 -> 2123
    //   2098: aload_0
    //   2099: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2102: aload_0
    //   2103: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   2106: aload_0
    //   2107: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   2110: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2113: aload_2
    //   2114: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2117: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2120: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2123: getstatic 261	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2126: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2129: aload_0
    //   2130: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2133: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2136: if_icmpne +35 -> 2171
    //   2139: aload_0
    //   2140: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2143: ifnull +28 -> 2171
    //   2146: aload_0
    //   2147: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   2150: aload_0
    //   2151: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   2154: aload_0
    //   2155: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   2158: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2161: aload_2
    //   2162: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2165: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2168: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2171: aload 20
    //   2173: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   2176: putfield 518	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   2179: aload 20
    //   2181: aload_0
    //   2182: invokevirtual 520	com/tencent/component/network/downloader/impl/e:g	()J
    //   2185: putfield 522	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   2188: aload 20
    //   2190: aload 16
    //   2192: putfield 525	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   2195: aload 20
    //   2197: iload_3
    //   2198: putfield 527	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   2201: aload 20
    //   2203: aconst_null
    //   2204: putfield 530	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   2207: aload 17
    //   2209: ifnonnull +582 -> 2791
    //   2212: aconst_null
    //   2213: astore_1
    //   2214: aload 20
    //   2216: aload_1
    //   2217: putfield 533	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   2220: aload 20
    //   2222: invokestatic 535	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   2225: putfield 537	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   2228: aload 20
    //   2230: aload_2
    //   2231: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2234: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2237: putfield 539	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   2240: aload 20
    //   2242: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2245: aload_0
    //   2246: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   2249: lsub
    //   2250: putfield 541	com/tencent/component/network/downloader/impl/ipc/Const:n	J
    //   2253: aload 20
    //   2255: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2258: aload_0
    //   2259: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   2262: lsub
    //   2263: aload_2
    //   2264: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2267: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2270: lsub
    //   2271: putfield 542	com/tencent/component/network/downloader/impl/ipc/Const:o	J
    //   2274: aload 20
    //   2276: lload 7
    //   2278: putfield 544	com/tencent/component/network/downloader/impl/ipc/Const:p	J
    //   2281: aload 20
    //   2283: aload_0
    //   2284: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   2287: putfield 546	com/tencent/component/network/downloader/impl/ipc/Const:q	J
    //   2290: aload 20
    //   2292: aload_0
    //   2293: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   2296: putfield 548	com/tencent/component/network/downloader/impl/ipc/Const:r	I
    //   2299: aload_2
    //   2300: aload 20
    //   2302: invokevirtual 552	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   2305: aload_0
    //   2306: aload_2
    //   2307: aload 20
    //   2309: invokevirtual 555	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   2312: aload_0
    //   2313: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2316: ifnull +15 -> 2331
    //   2319: aload_0
    //   2320: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2323: invokevirtual 560	org/apache/http/client/methods/HttpGet:abort	()V
    //   2326: aload_0
    //   2327: aconst_null
    //   2328: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2331: aload_0
    //   2332: invokevirtual 562	com/tencent/component/network/downloader/impl/e:m	()V
    //   2335: return
    //   2336: aload_0
    //   2337: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2340: invokevirtual 584	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2343: getfield 590	com/tencent/component/network/downloader/common/IPInfo:b	I
    //   2346: istore_3
    //   2347: goto -1180 -> 1167
    //   2350: aconst_null
    //   2351: astore_1
    //   2352: goto -574 -> 1778
    //   2355: iconst_0
    //   2356: istore 4
    //   2358: goto -373 -> 1985
    //   2361: new 83	java/lang/StringBuilder
    //   2364: dup
    //   2365: ldc_w 650
    //   2368: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2371: aload_0
    //   2372: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   2375: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: ldc_w 430
    //   2381: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: aload 17
    //   2386: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2389: ldc_w 435
    //   2392: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aconst_null
    //   2396: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: ldc_w 437
    //   2402: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: aconst_null
    //   2406: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2409: ldc_w 439
    //   2412: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2418: invokevirtual 133	java/lang/Thread:getId	()J
    //   2421: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2424: ldc_w 441
    //   2427: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2430: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2433: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: ldc_w 443
    //   2439: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: aload_0
    //   2443: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   2446: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2449: ldc_w 448
    //   2452: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: aload_0
    //   2456: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   2459: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2462: ldc_w 450
    //   2465: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: astore 18
    //   2470: aload_0
    //   2471: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   2474: ifeq +282 -> 2756
    //   2477: aload_0
    //   2478: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   2481: aload_0
    //   2482: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   2485: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2488: astore_1
    //   2489: aload 18
    //   2491: aload_1
    //   2492: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2495: ldc_w 459
    //   2498: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2501: aload_2
    //   2502: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2505: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2508: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2511: ldc_w 464
    //   2514: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2520: aload_0
    //   2521: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   2524: lsub
    //   2525: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2528: ldc_w 466
    //   2531: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: aload_2
    //   2535: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2538: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2541: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2544: ldc_w 421
    //   2547: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: aload_2
    //   2551: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2554: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2557: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2560: ldc_w 471
    //   2563: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: aload_2
    //   2567: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2570: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2573: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2576: ldc_w 476
    //   2579: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2582: aload_0
    //   2583: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   2586: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2589: ldc_w 421
    //   2592: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2595: aload_0
    //   2596: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   2599: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2602: ldc_w 652
    //   2605: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: iload_3
    //   2609: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2612: ldc_w 454
    //   2615: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2618: aload_2
    //   2619: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2622: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2625: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2628: ldc_w 487
    //   2631: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: aload_0
    //   2635: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   2638: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2641: ldc_w 491
    //   2644: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2647: astore_1
    //   2648: aload_0
    //   2649: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2652: ifnull +109 -> 2761
    //   2655: aload_0
    //   2656: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2659: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2662: istore 4
    //   2664: ldc 81
    //   2666: aload_1
    //   2667: iload 4
    //   2669: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2672: ldc_w 493
    //   2675: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: aload_2
    //   2679: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2682: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2685: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2688: ldc_w 498
    //   2691: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: lload 7
    //   2696: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2699: ldc_w 500
    //   2702: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2705: lconst_0
    //   2706: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2709: ldc_w 502
    //   2712: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: ldc_w 504
    //   2718: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2721: aload_0
    //   2722: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   2725: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: ldc_w 506
    //   2731: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2734: aload_0
    //   2735: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   2738: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2741: ldc_w 510
    //   2744: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2750: invokestatic 143	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   2753: goto -678 -> 2075
    //   2756: aconst_null
    //   2757: astore_1
    //   2758: goto -269 -> 2489
    //   2761: iconst_0
    //   2762: istore 4
    //   2764: goto -100 -> 2664
    //   2767: astore_1
    //   2768: ldc 81
    //   2770: ldc 34
    //   2772: aload_1
    //   2773: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2776: goto -653 -> 2123
    //   2779: astore_1
    //   2780: ldc 81
    //   2782: ldc 34
    //   2784: aload_1
    //   2785: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2788: goto -617 -> 2171
    //   2791: aload 17
    //   2793: invokevirtual 657	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   2796: astore_1
    //   2797: goto -583 -> 2214
    //   2800: aload_2
    //   2801: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2804: iconst_3
    //   2805: invokevirtual 340	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2808: aload_0
    //   2809: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2812: ifnull +3157 -> 5969
    //   2815: aload_0
    //   2816: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2819: aload_0
    //   2820: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   2823: iconst_1
    //   2824: invokeinterface 661 3 0
    //   2829: iload 4
    //   2831: iconst_1
    //   2832: iadd
    //   2833: istore 5
    //   2835: aload_2
    //   2836: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2839: lload 9
    //   2841: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2844: invokevirtual 379	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   2847: aload_0
    //   2848: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   2851: invokestatic 384	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   2854: invokevirtual 387	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2857: astore 18
    //   2859: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   2862: pop
    //   2863: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   2866: pop
    //   2867: aload_2
    //   2868: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2871: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2874: ifne +29 -> 2903
    //   2877: aload_0
    //   2878: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2881: ifnull +22 -> 2903
    //   2884: aload_0
    //   2885: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2888: aload_0
    //   2889: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   2892: aload_2
    //   2893: invokevirtual 398	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2896: aload 16
    //   2898: invokeinterface 404 4 0
    //   2903: aload_1
    //   2904: invokeinterface 325 1 0
    //   2909: ifne +730 -> 3639
    //   2912: aload_0
    //   2913: new 83	java/lang/StringBuilder
    //   2916: dup
    //   2917: aload_0
    //   2918: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   2921: invokestatic 408	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2924: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2927: ldc_w 410
    //   2930: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2933: aload_2
    //   2934: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2937: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2940: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2943: ldc_w 421
    //   2946: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2949: aload_0
    //   2950: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   2953: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2956: ldc_w 426
    //   2959: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2962: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2965: putfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   2968: aload_2
    //   2969: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2972: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2975: ifne +2488 -> 5463
    //   2978: new 83	java/lang/StringBuilder
    //   2981: dup
    //   2982: ldc_w 428
    //   2985: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2988: aload_0
    //   2989: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   2992: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2995: ldc_w 430
    //   2998: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3001: aload 18
    //   3003: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3006: ldc_w 435
    //   3009: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3012: aconst_null
    //   3013: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: ldc_w 437
    //   3019: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3022: aconst_null
    //   3023: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3026: ldc_w 439
    //   3029: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3032: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3035: invokevirtual 133	java/lang/Thread:getId	()J
    //   3038: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3041: ldc_w 441
    //   3044: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3047: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3050: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3053: ldc_w 443
    //   3056: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: aload_0
    //   3060: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   3063: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3066: ldc_w 448
    //   3069: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3072: aload_0
    //   3073: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   3076: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3079: ldc_w 450
    //   3082: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3085: astore 19
    //   3087: aload_0
    //   3088: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   3091: ifeq +2360 -> 5451
    //   3094: aload_0
    //   3095: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3098: aload_0
    //   3099: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   3102: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3105: astore 17
    //   3107: aload 19
    //   3109: aload 17
    //   3111: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3114: ldc_w 452
    //   3117: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3120: aload_0
    //   3121: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3124: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3127: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3130: ldc_w 454
    //   3133: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: aload_2
    //   3137: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3140: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3146: ldc_w 459
    //   3149: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3152: aload_2
    //   3153: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3156: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3159: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3162: ldc_w 464
    //   3165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3171: aload_0
    //   3172: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   3175: lsub
    //   3176: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3179: ldc_w 466
    //   3182: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: aload_2
    //   3186: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3189: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3192: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3195: ldc_w 421
    //   3198: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3201: aload_2
    //   3202: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3205: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3208: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3211: ldc_w 471
    //   3214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3217: aload_2
    //   3218: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3221: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3224: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3227: ldc_w 476
    //   3230: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3233: aload_0
    //   3234: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   3237: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3240: ldc_w 421
    //   3243: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3246: aload_0
    //   3247: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   3250: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3253: ldc_w 480
    //   3256: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: aload_2
    //   3260: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3263: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3266: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3269: ldc_w 485
    //   3272: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3275: iload_3
    //   3276: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3279: ldc_w 487
    //   3282: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3285: aload_0
    //   3286: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   3289: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: ldc_w 491
    //   3295: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: astore 17
    //   3300: aload_0
    //   3301: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3304: ifnull +2153 -> 5457
    //   3307: aload_0
    //   3308: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3311: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3314: istore 4
    //   3316: ldc 81
    //   3318: aload 17
    //   3320: iload 4
    //   3322: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3325: ldc_w 493
    //   3328: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: aload_2
    //   3332: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3335: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3338: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: ldc_w 498
    //   3344: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: lload 7
    //   3349: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3352: ldc_w 500
    //   3355: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3358: lconst_0
    //   3359: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3362: ldc_w 502
    //   3365: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3368: ldc_w 504
    //   3371: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: aload_0
    //   3375: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   3378: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: ldc_w 506
    //   3384: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: aload_0
    //   3388: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   3391: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3394: ldc_w 510
    //   3397: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3403: aconst_null
    //   3404: invokestatic 366	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3407: getstatic 165	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3410: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3413: aload_0
    //   3414: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3417: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3420: if_icmpne +35 -> 3455
    //   3423: aload_0
    //   3424: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3427: ifnull +28 -> 3455
    //   3430: aload_0
    //   3431: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3434: aload_0
    //   3435: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   3438: aload_0
    //   3439: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   3442: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3445: aload_2
    //   3446: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3449: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3452: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3455: getstatic 261	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3458: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3461: aload_0
    //   3462: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3465: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3468: if_icmpne +35 -> 3503
    //   3471: aload_0
    //   3472: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3475: ifnull +28 -> 3503
    //   3478: aload_0
    //   3479: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   3482: aload_0
    //   3483: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   3486: aload_0
    //   3487: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   3490: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3493: aload_2
    //   3494: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3497: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3500: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3503: aload 20
    //   3505: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   3508: putfield 518	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   3511: aload 20
    //   3513: aload_0
    //   3514: invokevirtual 520	com/tencent/component/network/downloader/impl/e:g	()J
    //   3517: putfield 522	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   3520: aload 20
    //   3522: aload 16
    //   3524: putfield 525	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   3527: aload 20
    //   3529: iload_3
    //   3530: putfield 527	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   3533: aload 20
    //   3535: aconst_null
    //   3536: putfield 530	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   3539: aload 18
    //   3541: ifnonnull +2361 -> 5902
    //   3544: aconst_null
    //   3545: astore 16
    //   3547: aload 20
    //   3549: aload 16
    //   3551: putfield 533	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   3554: aload 20
    //   3556: invokestatic 535	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   3559: putfield 537	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   3562: aload 20
    //   3564: aload_2
    //   3565: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3568: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3571: putfield 539	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   3574: aload 20
    //   3576: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3579: aload_0
    //   3580: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   3583: lsub
    //   3584: putfield 541	com/tencent/component/network/downloader/impl/ipc/Const:n	J
    //   3587: aload 20
    //   3589: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3592: aload_0
    //   3593: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   3596: lsub
    //   3597: aload_2
    //   3598: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3601: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3604: lsub
    //   3605: putfield 542	com/tencent/component/network/downloader/impl/ipc/Const:o	J
    //   3608: aload 20
    //   3610: lload 7
    //   3612: putfield 544	com/tencent/component/network/downloader/impl/ipc/Const:p	J
    //   3615: aload 20
    //   3617: aload_0
    //   3618: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   3621: putfield 546	com/tencent/component/network/downloader/impl/ipc/Const:q	J
    //   3624: aload 20
    //   3626: aload_0
    //   3627: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   3630: putfield 548	com/tencent/component/network/downloader/impl/ipc/Const:r	I
    //   3633: aload_2
    //   3634: aload 20
    //   3636: invokevirtual 552	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   3639: aload_0
    //   3640: aload_2
    //   3641: aload 20
    //   3643: invokevirtual 555	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   3646: aload_0
    //   3647: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   3650: ifnull +15 -> 3665
    //   3653: aload_0
    //   3654: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   3657: invokevirtual 560	org/apache/http/client/methods/HttpGet:abort	()V
    //   3660: aload_0
    //   3661: aconst_null
    //   3662: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   3665: aload_0
    //   3666: invokevirtual 562	com/tencent/component/network/downloader/impl/e:m	()V
    //   3669: iload 5
    //   3671: istore_3
    //   3672: goto -3530 -> 142
    //   3675: aload 16
    //   3677: astore 19
    //   3679: aload_2
    //   3680: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3683: iconst_3
    //   3684: invokevirtual 340	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3687: iconst_0
    //   3688: istore_3
    //   3689: goto -860 -> 2829
    //   3692: aconst_null
    //   3693: astore 17
    //   3695: goto -3233 -> 462
    //   3698: iconst_0
    //   3699: istore 5
    //   3701: goto -3030 -> 671
    //   3704: new 83	java/lang/StringBuilder
    //   3707: dup
    //   3708: ldc_w 650
    //   3711: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3714: aload_0
    //   3715: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   3718: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3721: ldc_w 430
    //   3724: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: aload 19
    //   3729: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3732: ldc_w 435
    //   3735: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3738: aconst_null
    //   3739: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3742: ldc_w 437
    //   3745: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3748: aconst_null
    //   3749: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3752: ldc_w 439
    //   3755: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3761: invokevirtual 133	java/lang/Thread:getId	()J
    //   3764: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3767: ldc_w 441
    //   3770: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3773: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3776: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3779: ldc_w 443
    //   3782: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3785: aload_0
    //   3786: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   3789: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3792: ldc_w 448
    //   3795: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3798: aload_0
    //   3799: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   3802: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3805: ldc_w 450
    //   3808: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: astore 21
    //   3813: aload_0
    //   3814: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   3817: ifeq +286 -> 4103
    //   3820: aload_0
    //   3821: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3824: aload_0
    //   3825: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   3828: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3831: astore 17
    //   3833: aload 21
    //   3835: aload 17
    //   3837: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3840: ldc_w 459
    //   3843: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3846: aload_2
    //   3847: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3850: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3853: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3856: ldc_w 464
    //   3859: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3865: aload_0
    //   3866: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   3869: lsub
    //   3870: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3873: ldc_w 466
    //   3876: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3879: aload_2
    //   3880: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3883: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3886: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3889: ldc_w 421
    //   3892: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3895: aload_2
    //   3896: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3899: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3902: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3905: ldc_w 471
    //   3908: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3911: aload_2
    //   3912: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3915: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3918: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3921: ldc_w 476
    //   3924: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3927: aload_0
    //   3928: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   3931: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3934: ldc_w 421
    //   3937: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3940: aload_0
    //   3941: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   3944: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3947: ldc_w 652
    //   3950: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3953: iload_3
    //   3954: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3957: ldc_w 454
    //   3960: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3963: aload_2
    //   3964: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3967: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3970: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3973: ldc_w 487
    //   3976: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3979: aload_0
    //   3980: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   3983: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3986: ldc_w 491
    //   3989: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: astore 17
    //   3994: aload_0
    //   3995: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3998: ifnull +111 -> 4109
    //   4001: aload_0
    //   4002: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4005: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4008: istore 5
    //   4010: ldc 81
    //   4012: aload 17
    //   4014: iload 5
    //   4016: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4019: ldc_w 493
    //   4022: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4025: aload_2
    //   4026: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4029: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4032: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4035: ldc_w 498
    //   4038: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4041: lload 7
    //   4043: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4046: ldc_w 500
    //   4049: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4052: lconst_0
    //   4053: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4056: ldc_w 502
    //   4059: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4062: ldc_w 504
    //   4065: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: aload_0
    //   4069: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   4072: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: ldc_w 506
    //   4078: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4081: aload_0
    //   4082: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   4085: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4088: ldc_w 510
    //   4091: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4094: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4097: invokestatic 143	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   4100: goto -3337 -> 763
    //   4103: aconst_null
    //   4104: astore 17
    //   4106: goto -273 -> 3833
    //   4109: iconst_0
    //   4110: istore 5
    //   4112: goto -102 -> 4010
    //   4115: astore 17
    //   4117: ldc 81
    //   4119: ldc 34
    //   4121: aload 17
    //   4123: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4126: goto -3315 -> 811
    //   4129: astore 17
    //   4131: ldc 81
    //   4133: ldc 34
    //   4135: aload 17
    //   4137: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4140: goto -3281 -> 859
    //   4143: aload 19
    //   4145: invokevirtual 657	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4148: astore 16
    //   4150: goto -3246 -> 904
    //   4153: astore 17
    //   4155: iconst_0
    //   4156: istore_3
    //   4157: aconst_null
    //   4158: astore 19
    //   4160: aload 18
    //   4162: astore 16
    //   4164: aload 19
    //   4166: astore 18
    //   4168: aload_2
    //   4169: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4172: lload 9
    //   4174: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4177: invokevirtual 379	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4180: aload_0
    //   4181: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4184: invokestatic 384	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   4187: invokevirtual 387	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4190: astore 19
    //   4192: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   4195: pop
    //   4196: invokestatic 389	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   4199: pop
    //   4200: aload_2
    //   4201: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4204: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4207: ifne +29 -> 4236
    //   4210: aload_0
    //   4211: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4214: ifnull +22 -> 4236
    //   4217: aload_0
    //   4218: getfield 395	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4221: aload_0
    //   4222: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   4225: aload_2
    //   4226: invokevirtual 398	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4229: aload 16
    //   4231: invokeinterface 404 4 0
    //   4236: aload_1
    //   4237: invokeinterface 325 1 0
    //   4242: ifne +726 -> 4968
    //   4245: aload_0
    //   4246: new 83	java/lang/StringBuilder
    //   4249: dup
    //   4250: aload_0
    //   4251: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   4254: invokestatic 408	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4257: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4260: ldc_w 410
    //   4263: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4266: aload_2
    //   4267: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4270: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4273: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4276: ldc_w 421
    //   4279: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4282: aload_0
    //   4283: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   4286: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4289: ldc_w 426
    //   4292: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4295: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4298: putfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   4301: aload_2
    //   4302: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4305: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4308: ifne +704 -> 5012
    //   4311: new 83	java/lang/StringBuilder
    //   4314: dup
    //   4315: ldc_w 428
    //   4318: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4321: aload_0
    //   4322: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   4325: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4328: ldc_w 430
    //   4331: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4334: aload 19
    //   4336: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4339: ldc_w 435
    //   4342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4345: aconst_null
    //   4346: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: ldc_w 437
    //   4352: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4355: aconst_null
    //   4356: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: ldc_w 439
    //   4362: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4365: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4368: invokevirtual 133	java/lang/Thread:getId	()J
    //   4371: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4374: ldc_w 441
    //   4377: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4380: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4383: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4386: ldc_w 443
    //   4389: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4392: aload_0
    //   4393: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   4396: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4399: ldc_w 448
    //   4402: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4405: aload_0
    //   4406: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   4409: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4412: ldc_w 450
    //   4415: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4418: astore 21
    //   4420: aload_0
    //   4421: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   4424: ifeq +577 -> 5001
    //   4427: aload_0
    //   4428: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4431: aload_0
    //   4432: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   4435: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4438: astore_1
    //   4439: aload 21
    //   4441: aload_1
    //   4442: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4445: ldc_w 452
    //   4448: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4451: aload_0
    //   4452: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4455: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4458: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4461: ldc_w 454
    //   4464: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4467: aload_2
    //   4468: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4471: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4474: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4477: ldc_w 459
    //   4480: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4483: aload_2
    //   4484: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4487: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4490: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4493: ldc_w 464
    //   4496: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4499: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4502: aload_0
    //   4503: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   4506: lsub
    //   4507: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4510: ldc_w 466
    //   4513: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4516: aload_2
    //   4517: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4520: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4523: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4526: ldc_w 421
    //   4529: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4532: aload_2
    //   4533: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4536: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4539: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4542: ldc_w 471
    //   4545: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4548: aload_2
    //   4549: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4552: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4555: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4558: ldc_w 476
    //   4561: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4564: aload_0
    //   4565: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   4568: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4571: ldc_w 421
    //   4574: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4577: aload_0
    //   4578: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   4581: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4584: ldc_w 480
    //   4587: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4590: aload_2
    //   4591: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4594: invokevirtual 483	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4597: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4600: ldc_w 485
    //   4603: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4606: iload_3
    //   4607: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4610: ldc_w 487
    //   4613: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4616: aload_0
    //   4617: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   4620: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4623: ldc_w 491
    //   4626: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4629: astore_1
    //   4630: aload_0
    //   4631: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4634: ifnull +372 -> 5006
    //   4637: aload_0
    //   4638: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4641: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4644: istore 4
    //   4646: ldc 81
    //   4648: aload_1
    //   4649: iload 4
    //   4651: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4654: ldc_w 493
    //   4657: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4660: aload_2
    //   4661: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4664: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4667: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4670: ldc_w 498
    //   4673: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4676: lload 7
    //   4678: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4681: ldc_w 500
    //   4684: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4687: lconst_0
    //   4688: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4691: ldc_w 502
    //   4694: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4697: ldc_w 504
    //   4700: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4703: aload_0
    //   4704: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   4707: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4710: ldc_w 506
    //   4713: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4716: aload_0
    //   4717: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   4720: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4723: ldc_w 510
    //   4726: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4729: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4732: aload 18
    //   4734: invokestatic 366	com/tencent/component/network/downloader/impl/ipc/Const:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4737: getstatic 165	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4740: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4743: aload_0
    //   4744: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4747: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4750: if_icmpne +35 -> 4785
    //   4753: aload_0
    //   4754: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4757: ifnull +28 -> 4785
    //   4760: aload_0
    //   4761: getfield 195	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4764: aload_0
    //   4765: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   4768: aload_0
    //   4769: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   4772: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4775: aload_2
    //   4776: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4779: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4782: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4785: getstatic 261	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4788: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4791: aload_0
    //   4792: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4795: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4798: if_icmpne +35 -> 4833
    //   4801: aload_0
    //   4802: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4805: ifnull +28 -> 4833
    //   4808: aload_0
    //   4809: getfield 264	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/IPConfigStrategy;
    //   4812: aload_0
    //   4813: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   4816: aload_0
    //   4817: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   4820: invokestatic 512	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4823: aload_2
    //   4824: invokevirtual 335	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4827: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4830: invokevirtual 516	com/tencent/component/network/downloader/strategy/IPConfigStrategy:onIPAccessResult	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4833: aload 20
    //   4835: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   4838: putfield 518	com/tencent/component/network/downloader/impl/ipc/Const:d	J
    //   4841: aload 20
    //   4843: aload_0
    //   4844: invokevirtual 520	com/tencent/component/network/downloader/impl/e:g	()J
    //   4847: putfield 522	com/tencent/component/network/downloader/impl/ipc/Const:e	J
    //   4850: aload 20
    //   4852: aload 16
    //   4854: putfield 525	com/tencent/component/network/downloader/impl/ipc/Const:g	Lorg/apache/http/HttpResponse;
    //   4857: aload 20
    //   4859: iload_3
    //   4860: putfield 527	com/tencent/component/network/downloader/impl/ipc/Const:f	I
    //   4863: aload 20
    //   4865: aload 18
    //   4867: putfield 530	com/tencent/component/network/downloader/impl/ipc/Const:h	Ljava/lang/Throwable;
    //   4870: aload 19
    //   4872: ifnonnull +570 -> 5442
    //   4875: aconst_null
    //   4876: astore_1
    //   4877: aload 20
    //   4879: aload_1
    //   4880: putfield 533	com/tencent/component/network/downloader/impl/ipc/Const:i	Ljava/lang/String;
    //   4883: aload 20
    //   4885: invokestatic 535	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   4888: putfield 537	com/tencent/component/network/downloader/impl/ipc/Const:j	Ljava/lang/String;
    //   4891: aload 20
    //   4893: aload_2
    //   4894: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4897: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4900: putfield 539	com/tencent/component/network/downloader/impl/ipc/Const:m	Ljava/lang/String;
    //   4903: aload 20
    //   4905: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4908: aload_0
    //   4909: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   4912: lsub
    //   4913: putfield 541	com/tencent/component/network/downloader/impl/ipc/Const:n	J
    //   4916: aload 20
    //   4918: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4921: aload_0
    //   4922: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   4925: lsub
    //   4926: aload_2
    //   4927: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4930: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4933: lsub
    //   4934: putfield 542	com/tencent/component/network/downloader/impl/ipc/Const:o	J
    //   4937: aload 20
    //   4939: lload 7
    //   4941: putfield 544	com/tencent/component/network/downloader/impl/ipc/Const:p	J
    //   4944: aload 20
    //   4946: aload_0
    //   4947: getfield 424	com/tencent/component/network/downloader/impl/e:o	J
    //   4950: putfield 546	com/tencent/component/network/downloader/impl/ipc/Const:q	J
    //   4953: aload 20
    //   4955: aload_0
    //   4956: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   4959: putfield 548	com/tencent/component/network/downloader/impl/ipc/Const:r	I
    //   4962: aload_2
    //   4963: aload 20
    //   4965: invokevirtual 552	com/tencent/component/network/downloader/DownloadResult:setReport$695ff381	(Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   4968: aload_0
    //   4969: aload_2
    //   4970: aload 20
    //   4972: invokevirtual 555	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/impl/ipc/Const;)V
    //   4975: aload_0
    //   4976: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4979: ifnull +15 -> 4994
    //   4982: aload_0
    //   4983: getfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4986: invokevirtual 560	org/apache/http/client/methods/HttpGet:abort	()V
    //   4989: aload_0
    //   4990: aconst_null
    //   4991: putfield 357	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4994: aload_0
    //   4995: invokevirtual 562	com/tencent/component/network/downloader/impl/e:m	()V
    //   4998: aload 17
    //   5000: athrow
    //   5001: aconst_null
    //   5002: astore_1
    //   5003: goto -564 -> 4439
    //   5006: iconst_0
    //   5007: istore 4
    //   5009: goto -363 -> 4646
    //   5012: new 83	java/lang/StringBuilder
    //   5015: dup
    //   5016: ldc_w 650
    //   5019: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5022: aload_0
    //   5023: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   5026: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5029: ldc_w 430
    //   5032: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5035: aload 19
    //   5037: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5040: ldc_w 435
    //   5043: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5046: aconst_null
    //   5047: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5050: ldc_w 437
    //   5053: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5056: aconst_null
    //   5057: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5060: ldc_w 439
    //   5063: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5066: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5069: invokevirtual 133	java/lang/Thread:getId	()J
    //   5072: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5075: ldc_w 441
    //   5078: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5084: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5087: ldc_w 443
    //   5090: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5093: aload_0
    //   5094: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   5097: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5100: ldc_w 448
    //   5103: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5106: aload_0
    //   5107: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   5110: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5113: ldc_w 450
    //   5116: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5119: astore 21
    //   5121: aload_0
    //   5122: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   5125: ifeq +282 -> 5407
    //   5128: aload_0
    //   5129: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   5132: aload_0
    //   5133: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   5136: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5139: astore_1
    //   5140: aload 21
    //   5142: aload_1
    //   5143: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5146: ldc_w 459
    //   5149: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5152: aload_2
    //   5153: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5156: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5159: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5162: ldc_w 464
    //   5165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5168: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5171: aload_0
    //   5172: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   5175: lsub
    //   5176: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5179: ldc_w 466
    //   5182: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5185: aload_2
    //   5186: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5189: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5192: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5195: ldc_w 421
    //   5198: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5201: aload_2
    //   5202: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5205: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5208: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5211: ldc_w 471
    //   5214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5217: aload_2
    //   5218: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5221: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5224: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5227: ldc_w 476
    //   5230: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5233: aload_0
    //   5234: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   5237: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5240: ldc_w 421
    //   5243: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5246: aload_0
    //   5247: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   5250: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5253: ldc_w 652
    //   5256: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5259: iload_3
    //   5260: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5263: ldc_w 454
    //   5266: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5269: aload_2
    //   5270: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5273: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5276: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5279: ldc_w 487
    //   5282: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5285: aload_0
    //   5286: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   5289: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5292: ldc_w 491
    //   5295: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5298: astore_1
    //   5299: aload_0
    //   5300: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5303: ifnull +109 -> 5412
    //   5306: aload_0
    //   5307: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5310: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5313: istore 4
    //   5315: ldc 81
    //   5317: aload_1
    //   5318: iload 4
    //   5320: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5323: ldc_w 493
    //   5326: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5329: aload_2
    //   5330: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5333: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5336: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5339: ldc_w 498
    //   5342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5345: lload 7
    //   5347: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5350: ldc_w 500
    //   5353: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5356: lconst_0
    //   5357: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5360: ldc_w 502
    //   5363: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: ldc_w 504
    //   5369: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5372: aload_0
    //   5373: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   5376: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5379: ldc_w 506
    //   5382: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5385: aload_0
    //   5386: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   5389: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5392: ldc_w 510
    //   5395: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5398: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5401: invokestatic 143	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   5404: goto -667 -> 4737
    //   5407: aconst_null
    //   5408: astore_1
    //   5409: goto -269 -> 5140
    //   5412: iconst_0
    //   5413: istore 4
    //   5415: goto -100 -> 5315
    //   5418: astore_1
    //   5419: ldc 81
    //   5421: ldc 34
    //   5423: aload_1
    //   5424: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5427: goto -642 -> 4785
    //   5430: astore_1
    //   5431: ldc 81
    //   5433: ldc 34
    //   5435: aload_1
    //   5436: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5439: goto -606 -> 4833
    //   5442: aload 19
    //   5444: invokevirtual 657	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5447: astore_1
    //   5448: goto -571 -> 4877
    //   5451: aconst_null
    //   5452: astore 17
    //   5454: goto -2347 -> 3107
    //   5457: iconst_0
    //   5458: istore 4
    //   5460: goto -2144 -> 3316
    //   5463: new 83	java/lang/StringBuilder
    //   5466: dup
    //   5467: ldc_w 650
    //   5470: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5473: aload_0
    //   5474: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   5477: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5480: ldc_w 430
    //   5483: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5486: aload 18
    //   5488: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5491: ldc_w 435
    //   5494: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5497: aconst_null
    //   5498: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5501: ldc_w 437
    //   5504: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5507: aconst_null
    //   5508: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5511: ldc_w 439
    //   5514: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5517: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5520: invokevirtual 133	java/lang/Thread:getId	()J
    //   5523: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5526: ldc_w 441
    //   5529: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5532: invokestatic 117	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5535: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5538: ldc_w 443
    //   5541: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5544: aload_0
    //   5545: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   5548: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5551: ldc_w 448
    //   5554: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5557: aload_0
    //   5558: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   5561: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5564: ldc_w 450
    //   5567: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5570: astore 19
    //   5572: aload_0
    //   5573: getfield 148	com/tencent/component/network/downloader/impl/e:p	Z
    //   5576: ifeq +286 -> 5862
    //   5579: aload_0
    //   5580: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   5583: aload_0
    //   5584: getfield 153	com/tencent/component/network/downloader/impl/e:q	Z
    //   5587: invokestatic 279	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5590: astore 17
    //   5592: aload 19
    //   5594: aload 17
    //   5596: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5599: ldc_w 459
    //   5602: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5605: aload_2
    //   5606: invokevirtual 373	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5609: getfield 462	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5612: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5615: ldc_w 464
    //   5618: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5621: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5624: aload_0
    //   5625: getfield 30	com/tencent/component/network/downloader/impl/e:r	J
    //   5628: lsub
    //   5629: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5632: ldc_w 466
    //   5635: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5638: aload_2
    //   5639: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5642: getfield 469	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5645: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5648: ldc_w 421
    //   5651: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5654: aload_2
    //   5655: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5658: getfield 419	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5661: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5664: ldc_w 471
    //   5667: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5670: aload_2
    //   5671: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5674: getfield 474	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5677: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5680: ldc_w 476
    //   5683: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5686: aload_0
    //   5687: invokevirtual 359	com/tencent/component/network/downloader/impl/e:e	()I
    //   5690: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5693: ldc_w 421
    //   5696: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5699: aload_0
    //   5700: invokevirtual 478	com/tencent/component/network/downloader/impl/e:f	()I
    //   5703: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5706: ldc_w 652
    //   5709: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5712: iload_3
    //   5713: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5716: ldc_w 454
    //   5719: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5722: aload_2
    //   5723: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5726: getfield 457	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5729: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5732: ldc_w 487
    //   5735: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5738: aload_0
    //   5739: getfield 489	com/tencent/component/network/downloader/impl/e:s	Ljava/lang/String;
    //   5742: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5745: ldc_w 491
    //   5748: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5751: astore 17
    //   5753: aload_0
    //   5754: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5757: ifnull +111 -> 5868
    //   5760: aload_0
    //   5761: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5764: getfield 168	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5767: istore 4
    //   5769: ldc 81
    //   5771: aload 17
    //   5773: iload 4
    //   5775: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5778: ldc_w 493
    //   5781: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5784: aload_2
    //   5785: invokevirtual 414	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5788: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5791: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5794: ldc_w 498
    //   5797: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5800: lload 7
    //   5802: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5805: ldc_w 500
    //   5808: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5811: lconst_0
    //   5812: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5815: ldc_w 502
    //   5818: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5821: ldc_w 504
    //   5824: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5827: aload_0
    //   5828: getfield 36	com/tencent/component/network/downloader/impl/e:x	Ljava/lang/String;
    //   5831: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5834: ldc_w 506
    //   5837: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5840: aload_0
    //   5841: invokevirtual 508	com/tencent/component/network/downloader/impl/e:n	()I
    //   5844: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5847: ldc_w 510
    //   5850: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5853: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5856: invokestatic 143	com/tencent/component/network/downloader/impl/ipc/Const:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   5859: goto -2452 -> 3407
    //   5862: aconst_null
    //   5863: astore 17
    //   5865: goto -273 -> 5592
    //   5868: iconst_0
    //   5869: istore 4
    //   5871: goto -102 -> 5769
    //   5874: astore 17
    //   5876: ldc 81
    //   5878: ldc 34
    //   5880: aload 17
    //   5882: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5885: goto -2430 -> 3455
    //   5888: astore 17
    //   5890: ldc 81
    //   5892: ldc 34
    //   5894: aload 17
    //   5896: invokestatic 654	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5899: goto -2396 -> 3503
    //   5902: aload 18
    //   5904: invokevirtual 657	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5907: astore 16
    //   5909: goto -2362 -> 3547
    //   5912: astore 17
    //   5914: iconst_0
    //   5915: istore_3
    //   5916: aconst_null
    //   5917: astore 18
    //   5919: aload 19
    //   5921: astore 16
    //   5923: goto -1755 -> 4168
    //   5926: astore 17
    //   5928: aconst_null
    //   5929: astore 18
    //   5931: goto -1763 -> 4168
    //   5934: astore 17
    //   5936: aconst_null
    //   5937: astore 18
    //   5939: goto -1771 -> 4168
    //   5942: astore 17
    //   5944: goto -1776 -> 4168
    //   5947: astore 18
    //   5949: iconst_0
    //   5950: istore_3
    //   5951: aconst_null
    //   5952: astore 16
    //   5954: goto -5782 -> 172
    //   5957: astore 18
    //   5959: iconst_0
    //   5960: istore_3
    //   5961: goto -5789 -> 172
    //   5964: astore 18
    //   5966: goto -5794 -> 172
    //   5969: goto -3140 -> 2829
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5972	0	this	e
    //   0	5972	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	5972	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   141	5820	3	i	int
    //   21	5849	4	j	int
    //   669	3442	5	k	int
    //   18	55	6	m	int
    //   24	5777	7	l1	long
    //   59	4114	9	l2	long
    //   122	1301	11	l3	long
    //   1418	3	13	l4	long
    //   132	3	15	bool	boolean
    //   111	1	16	localObject1	Object
    //   155	8	16	localUnknownHostException	UnknownHostException
    //   170	5783	16	localObject2	Object
    //   460	3645	17	localObject3	Object
    //   4115	7	17	localException1	java.lang.Exception
    //   4129	7	17	localException2	java.lang.Exception
    //   4153	846	17	localObject4	Object
    //   5452	412	17	localObject5	Object
    //   5874	7	17	localException3	java.lang.Exception
    //   5888	7	17	localException4	java.lang.Exception
    //   5912	1	17	localObject6	Object
    //   5926	1	17	localObject7	Object
    //   5934	1	17	localObject8	Object
    //   5942	1	17	localObject9	Object
    //   108	1	18	localObject10	Object
    //   165	727	18	localThrowable1	java.lang.Throwable
    //   1757	4181	18	localObject11	Object
    //   5947	1	18	localThrowable2	java.lang.Throwable
    //   5957	1	18	localThrowable3	java.lang.Throwable
    //   5964	1	18	localThrowable4	java.lang.Throwable
    //   105	5815	19	localObject12	Object
    //   68	4903	20	localConst	Const
    //   440	4701	21	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   124	134	155	java/net/UnknownHostException
    //   162	165	165	java/lang/Throwable
    //   1034	1138	165	java/lang/Throwable
    //   1138	1152	165	java/lang/Throwable
    //   1156	1167	165	java/lang/Throwable
    //   1170	1177	165	java/lang/Throwable
    //   1181	1209	165	java/lang/Throwable
    //   1213	1237	165	java/lang/Throwable
    //   1241	1316	165	java/lang/Throwable
    //   1316	1378	165	java/lang/Throwable
    //   1378	1420	165	java/lang/Throwable
    //   2336	2347	165	java/lang/Throwable
    //   2098	2123	2767	java/lang/Exception
    //   2146	2171	2779	java/lang/Exception
    //   786	811	4115	java/lang/Exception
    //   834	859	4129	java/lang/Exception
    //   162	165	4153	finally
    //   1034	1138	4153	finally
    //   1138	1152	4153	finally
    //   1156	1167	4153	finally
    //   1170	1177	4153	finally
    //   1181	1209	4153	finally
    //   1213	1237	4153	finally
    //   1241	1316	4153	finally
    //   1316	1378	4153	finally
    //   1378	1420	4153	finally
    //   2336	2347	4153	finally
    //   4760	4785	5418	java/lang/Exception
    //   4808	4833	5430	java/lang/Exception
    //   3430	3455	5874	java/lang/Exception
    //   3478	3503	5888	java/lang/Exception
    //   1427	1444	5912	finally
    //   1453	1466	5912	finally
    //   3679	3687	5912	finally
    //   1466	1474	5926	finally
    //   1488	1507	5926	finally
    //   2800	2829	5926	finally
    //   172	181	5934	finally
    //   181	190	5942	finally
    //   1427	1444	5947	java/lang/Throwable
    //   1453	1466	5957	java/lang/Throwable
    //   3679	3687	5957	java/lang/Throwable
    //   1466	1474	5964	java/lang/Throwable
    //   1488	1507	5964	java/lang/Throwable
    //   2800	2829	5964	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.e
 * JD-Core Version:    0.7.0.1
 */