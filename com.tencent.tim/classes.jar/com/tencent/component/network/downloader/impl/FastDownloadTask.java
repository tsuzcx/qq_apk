package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.OkHttpClient;

public class FastDownloadTask
  extends DownloadTask
{
  int connect_retry = 0;
  long connect_time = 0L;
  int exe_retry = 0;
  long exe_time = 0L;
  private boolean mAPNProxy;
  private boolean mAllowProxy;
  private String mDomainWithPort;
  private int mOrigPort = 0;
  private String mRealUrl;
  private String mRefer;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  long send_req_time = 0L;
  private Proxy triedNetworkProxy;
  
  public FastDownloadTask(Context paramContext, OkHttpClient paramOkHttpClient, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramOkHttpClient, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private boolean setStrategy(int paramInt)
    throws UnknownHostException
  {
    int j = 80;
    String str2 = getDomain();
    if (this.pDownloadStrategyLib == null) {
      this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
    }
    this.pOldStrategyInfo = this.pCurrStrategyInfo;
    if (this.pDownloadStrategyLib.getStrategyList() != null) {}
    for (int i = this.pDownloadStrategyLib.getStrategyList().size();; i = 0)
    {
      if (i == 0) {}
      do
      {
        return false;
        for (this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i); (this.mIsHttp2) && (this.pCurrStrategyInfo != null) && (this.pOldStrategyInfo != null) && (this.pCurrStrategyInfo.id == this.pOldStrategyInfo.id); this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i)) {
          this.attemptStrategyCount += 1;
        }
        this.attemptStrategyCount += 1;
        if ((this.mIsHttp2) && (this.attemptStrategyCount > i))
        {
          this.mIsHttp2 = false;
          this.pDownloadStrategyLib.setPort(80);
        }
        i = j;
        if (this.mIsHttp2) {
          i = 443;
        }
        this.mStandardPort = i;
        if (QDLog.isInfoEnable()) {
          QDLog.i("downloader_strategy", "downloader strategy: " + this.pCurrStrategyInfo.toString() + " currAttempCount:" + paramInt + " attemptStrategyCount:" + this.attemptStrategyCount + " ,best:" + this.pDownloadStrategyLib.getBestId() + " url:" + getUrl() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
        }
        this.mAllowProxy = this.pCurrStrategyInfo.allowProxy;
        this.mAPNProxy = this.pCurrStrategyInfo.useConfigApn;
        i = this.pDownloadStrategyLib.getPort();
        paramInt = i;
        if (!Utils.isPortValid(i))
        {
          this.pDownloadStrategyLib.setPort(this.mStandardPort);
          paramInt = this.mStandardPort;
        }
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pCurrStrategyInfo.id) {
          break label720;
        }
        i = paramInt;
        if (this.pOldStrategyInfo == null) {
          break;
        }
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.pOldStrategyInfo.id) {
          break;
        }
        if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
          break label644;
        }
        i = this.pPortConfigStrategy.changePort(str2, paramInt);
        if ((i != paramInt) && (Utils.isPortValid(i))) {
          break;
        }
      } while (!QDLog.isInfoEnable());
      QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
      return false;
      String str1 = this.pDownloadStrategyLib.getBackupIP();
      Object localObject = str1;
      if (this.pBackupIPConfigStrategy != null)
      {
        localObject = str1;
        if (!this.pBackupIPConfigStrategy.isIPValid(str2, str1))
        {
          this.pDownloadStrategyLib.setBackupIP(null);
          localObject = this.pBackupIPConfigStrategy.resolveIP(str2);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label682;
          }
          this.pDownloadStrategyLib.setBackupIP((String)localObject);
        }
      }
      this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
      this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      for (;;)
      {
        return true;
        label644:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
        label682:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label720:
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pCurrStrategyInfo.id)
        {
          i = paramInt;
          if (this.pOldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.pOldStrategyInfo.id)
            {
              if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
                break label973;
              }
              i = this.pPortConfigStrategy.changePort(str2, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (!QDLog.isInfoEnable()) {
                  break;
                }
                QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
          str1 = DnsService.getInstance().getDomainIP(str2);
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = DnsService.getInstance().getDomainIP(str2);
          }
          if ((localObject == null) || (((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) || (((String)localObject).equals(this.pDownloadStrategyLib.getDirectIP())))
          {
            this.pDownloadStrategyLib.setDnsIP(null);
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            if (!QDLog.isInfoEnable()) {
              break;
            }
            QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.pDownloadStrategyLib.setDnsIP((String)localObject);
          this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
          this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
          continue;
        }
        label973:
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pCurrStrategyInfo.id)
        {
          i = paramInt;
          if (this.pOldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.pOldStrategyInfo.id)
            {
              if ((this.pPortConfigStrategy == null) || (!this.pPortConfigStrategy.supportExtraPort(str2))) {
                break label1342;
              }
              i = this.pPortConfigStrategy.changePort(str2, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                if (!QDLog.isInfoEnable()) {
                  break;
                }
                QDLog.i("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1342:
        do
        {
          str1 = this.pDownloadStrategyLib.getDirectIP();
          localObject = str1;
          if (this.pDirectIPConfigStrategy != null)
          {
            localObject = str1;
            if (!this.pDirectIPConfigStrategy.isIPValid(str2, str1))
            {
              this.pDownloadStrategyLib.setDirectIP(null);
              localObject = this.pDirectIPConfigStrategy.resolveIP(str2);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1573;
              }
              this.pDownloadStrategyLib.setDirectIP((String)localObject);
            }
          }
          if ((localObject != null) && (!((String)localObject).equals(this.pDownloadStrategyLib.getBackupIP())) && (!((String)localObject).equals(this.pDownloadStrategyLib.getDnsIP()))) {
            break label1611;
          }
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
          return false;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.pCurrStrategyInfo.id) {
            break label1427;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.pCurrStrategyInfo.id);
        label1427:
        localObject = this.mContext;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.pCurrStrategyInfo.id) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = NetworkUtils.getProxy((Context)localObject, bool);
          if (localObject != null) {
            break label1510;
          }
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        label1510:
        if (((Proxy)localObject).equals(this.triedNetworkProxy))
        {
          if (!QDLog.isInfoEnable()) {
            break;
          }
          QDLog.i("downloader", "downloader strategy: proxy 重复. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.triedNetworkProxy = ((Proxy)localObject);
        paramInt = this.mStandardPort;
        return true;
        label1573:
        if (!QDLog.isInfoEnable()) {
          break;
        }
        QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1611:
        this.pCurrStrategyInfo = this.pCurrStrategyInfo.clone();
        this.pCurrStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      }
    }
  }
  
  /* Error */
  public void execute(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 344	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 350	com/tencent/component/network/downloader/impl/DownloadTask$TaskHelper:generateRandomId	([Ljava/lang/Object;)I
    //   18: istore 9
    //   20: invokestatic 355	com/tencent/component/network/utils/SDCardUtil:isSdCardHasEnoughCapability	()Z
    //   23: istore 11
    //   25: lconst_0
    //   26: lstore 12
    //   28: iconst_0
    //   29: istore_3
    //   30: aload_1
    //   31: invokeinterface 360 1 0
    //   36: ifeq +11 -> 47
    //   39: aload_0
    //   40: aload_1
    //   41: aload_2
    //   42: aconst_null
    //   43: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   46: return
    //   47: aload_0
    //   48: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   51: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   54: ifne +29 -> 83
    //   57: iload_3
    //   58: aload_0
    //   59: getfield 371	com/tencent/component/network/downloader/impl/FastDownloadTask:mAttemptTotalCount	I
    //   62: iconst_1
    //   63: isub
    //   64: if_icmpne +13 -> 77
    //   67: aload_2
    //   68: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   71: bipush 6
    //   73: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   76: return
    //   77: ldc2_w 383
    //   80: invokestatic 388	java/lang/Thread:sleep	(J)V
    //   83: iload 11
    //   85: ifne +25 -> 110
    //   88: aload_2
    //   89: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   92: iconst_2
    //   93: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   96: return
    //   97: astore 22
    //   99: ldc 221
    //   101: ldc_w 390
    //   104: invokestatic 393	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -24 -> 83
    //   110: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   113: lstore 18
    //   115: new 395	com/tencent/component/network/downloader/DownloadReport
    //   118: dup
    //   119: invokespecial 396	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   122: astore 29
    //   124: aload 29
    //   126: iload 9
    //   128: putfield 397	com/tencent/component/network/downloader/DownloadReport:id	I
    //   131: aload 29
    //   133: aload_0
    //   134: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   137: putfield 400	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   140: aload 29
    //   142: aload_0
    //   143: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   146: putfield 403	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   149: aload 29
    //   151: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   154: putfield 411	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   162: aconst_null
    //   163: astore 26
    //   165: aconst_null
    //   166: astore 24
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   173: aconst_null
    //   174: astore 25
    //   176: iconst_0
    //   177: istore 7
    //   179: iconst_0
    //   180: istore 8
    //   182: aconst_null
    //   183: astore 22
    //   185: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   188: lstore 20
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   195: invokespecial 424	com/tencent/component/network/downloader/impl/FastDownloadTask:setStrategy	(I)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifne +15 -> 217
    //   205: aload_0
    //   206: invokevirtual 427	com/tencent/component/network/downloader/impl/FastDownloadTask:canAttempt	()Z
    //   209: ifeq -163 -> 46
    //   212: goto -182 -> 30
    //   215: astore 22
    //   217: aload 22
    //   219: ifnull +1745 -> 1964
    //   222: lload 12
    //   224: lstore 14
    //   226: lload 12
    //   228: lstore 16
    //   230: aload 22
    //   232: athrow
    //   233: astore 25
    //   235: aconst_null
    //   236: astore 22
    //   238: aconst_null
    //   239: astore 24
    //   241: aconst_null
    //   242: astore 23
    //   244: iload 8
    //   246: istore 4
    //   248: lload 14
    //   250: lstore 12
    //   252: ldc 221
    //   254: ldc_w 429
    //   257: aload 25
    //   259: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: iload_3
    //   263: istore 5
    //   265: aload_2
    //   266: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   269: aload 25
    //   271: invokevirtual 436	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   274: iload_3
    //   275: istore 6
    //   277: iload_3
    //   278: istore 5
    //   280: aload_0
    //   281: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   284: ifnull +48 -> 332
    //   287: iload_3
    //   288: istore 6
    //   290: iload_3
    //   291: istore 5
    //   293: aload_0
    //   294: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   297: ldc_w 440
    //   300: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   303: ifeq +29 -> 332
    //   306: iload_3
    //   307: istore 5
    //   309: aload_0
    //   310: iconst_1
    //   311: putfield 446	com/tencent/component/network/downloader/impl/FastDownloadTask:disableHttps	Z
    //   314: iload_3
    //   315: iconst_1
    //   316: isub
    //   317: istore 6
    //   319: iload 6
    //   321: istore 5
    //   323: ldc_w 448
    //   326: ldc_w 450
    //   329: invokestatic 452	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_2
    //   333: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   336: lload 18
    //   338: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   341: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   344: aload_2
    //   345: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   348: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   351: aload_0
    //   352: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   355: lsub
    //   356: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   359: aload_2
    //   360: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   363: aload_0
    //   364: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   367: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   370: aload_0
    //   371: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   374: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   377: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   380: astore 28
    //   382: aload_0
    //   383: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   386: ifnull +14974 -> 15360
    //   389: aload_0
    //   390: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   393: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   396: ifnull +14964 -> 15360
    //   399: aload_0
    //   400: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   403: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   406: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   409: astore 26
    //   411: aload_0
    //   412: aload_0
    //   413: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   416: aload 23
    //   418: aload 22
    //   420: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   423: astore 30
    //   425: aload 24
    //   427: ifnull +16665 -> 17092
    //   430: aload 24
    //   432: ldc_w 493
    //   435: invokeinterface 499 2 0
    //   440: checkcast 284	java/lang/String
    //   443: astore 24
    //   445: aload_2
    //   446: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   449: aload 24
    //   451: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   454: aload_0
    //   455: lconst_0
    //   456: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   459: aload_0
    //   460: iconst_0
    //   461: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   464: aload_0
    //   465: lconst_0
    //   466: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   474: aload_2
    //   475: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   478: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   481: ifeq +12 -> 493
    //   484: aload_1
    //   485: invokeinterface 360 1 0
    //   490: ifeq +31 -> 521
    //   493: aload_0
    //   494: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   497: ifnull +24 -> 521
    //   500: aload_0
    //   501: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   504: aload_0
    //   505: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   508: aload_2
    //   509: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   512: aload 23
    //   514: aload 22
    //   516: invokeinterface 524 5 0
    //   521: aload_1
    //   522: invokeinterface 360 1 0
    //   527: ifne +1401 -> 1928
    //   530: aload_0
    //   531: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   534: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   537: istore 10
    //   539: aload_2
    //   540: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   543: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   546: ifne +14864 -> 15410
    //   549: new 127	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 526
    //   559: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_0
    //   563: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   566: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 528
    //   572: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_0
    //   576: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   579: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   582: ldc_w 533
    //   585: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: astore 31
    //   590: aload_0
    //   591: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   594: ifeq +14782 -> 15376
    //   597: aload 22
    //   599: ifnull +14777 -> 15376
    //   602: aload 22
    //   604: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   607: ifnull +14769 -> 15376
    //   610: aload 22
    //   612: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   615: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   618: astore 27
    //   620: aload 31
    //   622: aload 27
    //   624: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc_w 544
    //   630: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 28
    //   635: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   638: ldc_w 549
    //   641: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 26
    //   646: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 551
    //   652: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aconst_null
    //   656: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: ldc_w 553
    //   662: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   668: invokevirtual 176	java/lang/Thread:getId	()J
    //   671: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: ldc_w 555
    //   677: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   683: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc_w 557
    //   689: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_0
    //   693: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   696: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   699: ldc_w 559
    //   702: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload_0
    //   706: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   709: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: ldc_w 561
    //   715: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: astore 31
    //   720: aload_0
    //   721: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   724: ifeq +14660 -> 15384
    //   727: aload_0
    //   728: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   731: aload_0
    //   732: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   735: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   738: astore 27
    //   740: aload 31
    //   742: aload 27
    //   744: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   747: ldc_w 563
    //   750: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: iload 10
    //   755: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   758: ldc_w 565
    //   761: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   767: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   770: ldc_w 572
    //   773: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_2
    //   777: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   780: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   783: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc_w 577
    //   789: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_2
    //   793: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   796: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   799: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: ldc_w 582
    //   805: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   811: aload_0
    //   812: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   815: lsub
    //   816: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: ldc_w 584
    //   822: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload_2
    //   826: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   829: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   832: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   835: ldc_w 589
    //   838: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload_2
    //   842: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   845: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   848: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   851: ldc_w 593
    //   854: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_2
    //   858: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   861: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   864: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   867: ldc_w 598
    //   870: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_0
    //   874: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   877: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: ldc_w 600
    //   883: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_0
    //   887: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   890: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: ldc_w 605
    //   896: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_2
    //   900: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   903: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   906: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   909: ldc_w 610
    //   912: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: iload 4
    //   917: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 612
    //   923: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload 30
    //   928: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc_w 614
    //   934: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: aload 24
    //   939: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 616
    //   945: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: astore 31
    //   950: aload_0
    //   951: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   954: ifnull +14436 -> 15390
    //   957: aload_0
    //   958: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   961: iconst_0
    //   962: bipush 30
    //   964: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   967: astore 27
    //   969: aload 31
    //   971: aload 27
    //   973: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: ldc_w 622
    //   979: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: astore 27
    //   984: aload_0
    //   985: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   988: ifnull +14411 -> 15399
    //   991: aload_0
    //   992: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   995: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   998: istore_3
    //   999: aload 27
    //   1001: iload_3
    //   1002: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: ldc_w 624
    //   1008: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_2
    //   1012: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1015: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1018: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 629
    //   1024: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: lload 12
    //   1029: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: ldc_w 631
    //   1035: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1042: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1045: ldc_w 600
    //   1048: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_0
    //   1052: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   1055: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: ldc_w 633
    //   1061: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   1068: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1071: ldc_w 600
    //   1074: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_0
    //   1078: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   1081: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1084: ldc_w 635
    //   1087: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload_0
    //   1091: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1094: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1097: ldc_w 637
    //   1100: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_0
    //   1104: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1107: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1110: ldc_w 642
    //   1113: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: aload_0
    //   1117: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1120: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1123: ldc_w 647
    //   1126: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: astore 31
    //   1131: aload_0
    //   1132: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1135: ifnull +14269 -> 15404
    //   1138: aload_0
    //   1139: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1142: invokeinterface 657 1 0
    //   1147: astore 27
    //   1149: aload 29
    //   1151: aload 31
    //   1153: aload 27
    //   1155: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1164: ldc_w 448
    //   1167: aload 29
    //   1169: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1172: aload 25
    //   1174: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1177: aload_0
    //   1178: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1181: ifnull +24 -> 1205
    //   1184: aload_0
    //   1185: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1188: ldc_w 440
    //   1191: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1194: ifeq +11 -> 1205
    //   1197: aload_0
    //   1198: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1201: iconst_0
    //   1202: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   1205: iload 10
    //   1207: ifne +8 -> 1215
    //   1210: aload_0
    //   1211: iconst_0
    //   1212: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   1215: aload_2
    //   1216: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1219: astore 27
    //   1221: new 127	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1228: aload_0
    //   1229: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   1232: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: ldc_w 671
    //   1238: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload 26
    //   1243: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: ldc_w 673
    //   1249: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload_2
    //   1253: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1256: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1259: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: ldc_w 675
    //   1265: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: astore 26
    //   1270: aload_0
    //   1271: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1274: ifnull +14773 -> 16047
    //   1277: aload_0
    //   1278: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1281: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1284: istore_3
    //   1285: aload 26
    //   1287: iload_3
    //   1288: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: ldc_w 610
    //   1294: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: iload 4
    //   1299: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1302: ldc_w 572
    //   1305: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: aload_2
    //   1309: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1312: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1315: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc_w 584
    //   1321: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: aload_2
    //   1325: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1328: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1331: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1334: ldc_w 589
    //   1337: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: aload_2
    //   1341: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1344: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1347: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1350: ldc_w 577
    //   1353: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: aload_2
    //   1357: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1360: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1363: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1366: ldc_w 582
    //   1369: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1375: aload_0
    //   1376: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1379: lsub
    //   1380: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1383: astore 26
    //   1385: aload 24
    //   1387: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1390: ifne +14662 -> 16052
    //   1393: new 127	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 614
    //   1403: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 24
    //   1408: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1414: astore 24
    //   1416: aload 27
    //   1418: aload 26
    //   1420: aload 24
    //   1422: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: ldc_w 612
    //   1428: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload 30
    //   1433: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1442: aload_0
    //   1443: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1446: ifnull +53 -> 1499
    //   1449: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1452: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1455: aload_0
    //   1456: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1459: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1462: if_icmpne +37 -> 1499
    //   1465: aload_0
    //   1466: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1469: ifnull +30 -> 1499
    //   1472: aload_0
    //   1473: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1476: aload_0
    //   1477: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1480: aload_0
    //   1481: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1484: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1487: aload_2
    //   1488: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1491: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1494: invokeinterface 685 4 0
    //   1499: aload_0
    //   1500: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1503: ifnull +53 -> 1556
    //   1506: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1509: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1512: aload_0
    //   1513: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1516: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1519: if_icmpne +37 -> 1556
    //   1522: aload_0
    //   1523: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1526: ifnull +30 -> 1556
    //   1529: aload_0
    //   1530: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1533: aload_0
    //   1534: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1537: aload_0
    //   1538: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1541: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1544: aload_2
    //   1545: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1548: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1551: invokeinterface 685 4 0
    //   1556: iload 10
    //   1558: ifeq +64 -> 1622
    //   1561: aload_0
    //   1562: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   1565: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1568: astore 24
    //   1570: aload_0
    //   1571: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1574: astore 26
    //   1576: aload_0
    //   1577: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1580: ifeq +14510 -> 16090
    //   1583: aload_0
    //   1584: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1587: ifnull +14503 -> 16090
    //   1590: aload_0
    //   1591: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1594: ldc_w 687
    //   1597: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1600: ifeq +14490 -> 16090
    //   1603: iconst_1
    //   1604: istore 10
    //   1606: aload 24
    //   1608: aload 26
    //   1610: iload 10
    //   1612: aload_2
    //   1613: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1616: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1619: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   1622: aload 29
    //   1624: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   1627: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1630: aload 29
    //   1632: aload_0
    //   1633: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   1636: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1639: aload 29
    //   1641: aload 23
    //   1643: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1646: aload 29
    //   1648: aload 22
    //   1650: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   1653: aload 29
    //   1655: iload 4
    //   1657: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1660: aload 29
    //   1662: aload 25
    //   1664: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1667: aload 28
    //   1669: ifnonnull +14427 -> 16096
    //   1672: aconst_null
    //   1673: astore 23
    //   1675: aload 29
    //   1677: aload 23
    //   1679: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1682: aload 29
    //   1684: aconst_null
    //   1685: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1688: aload 29
    //   1690: aload_2
    //   1691: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1694: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1697: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1700: aload 29
    //   1702: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   1705: aload_0
    //   1706: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   1709: lsub
    //   1710: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1713: aload 29
    //   1715: aload_2
    //   1716: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1719: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1722: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1725: aload 29
    //   1727: aload 29
    //   1729: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1732: aload_2
    //   1733: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1736: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1739: lsub
    //   1740: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1743: aload 29
    //   1745: lload 12
    //   1747: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1750: aload 29
    //   1752: aload_0
    //   1753: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   1756: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1759: aload 29
    //   1761: aload_0
    //   1762: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   1765: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1768: aload 29
    //   1770: aload_0
    //   1771: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   1774: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1777: aload 29
    //   1779: lconst_0
    //   1780: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1783: aload 29
    //   1785: aload_0
    //   1786: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   1789: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1792: aload 29
    //   1794: aload_2
    //   1795: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1798: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1801: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1804: aload 29
    //   1806: aload_0
    //   1807: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   1810: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   1813: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1816: aload 29
    //   1818: aload_0
    //   1819: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1822: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1825: aload_0
    //   1826: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1829: ifnull +14277 -> 16106
    //   1832: aload_0
    //   1833: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   1836: ldc_w 687
    //   1839: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1842: ifeq +14264 -> 16106
    //   1845: iconst_1
    //   1846: istore 10
    //   1848: aload 29
    //   1850: iload 10
    //   1852: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   1855: aload 29
    //   1857: aload_2
    //   1858: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1861: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1864: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1867: aload 29
    //   1869: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   1872: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   1875: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   1878: aload 22
    //   1880: ifnull +24 -> 1904
    //   1883: aload 22
    //   1885: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1888: ifnull +16 -> 1904
    //   1891: aload 29
    //   1893: aload 22
    //   1895: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   1898: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   1901: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   1904: aload_2
    //   1905: aload 29
    //   1907: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1910: aload_2
    //   1911: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1914: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1917: ifeq +11 -> 1928
    //   1920: aload_0
    //   1921: aload_1
    //   1922: aload_2
    //   1923: aload 29
    //   1925: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1928: aload_0
    //   1929: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   1932: ifeq +14180 -> 16112
    //   1935: aload_0
    //   1936: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1939: ifnull +12 -> 1951
    //   1942: aload_0
    //   1943: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   1946: invokeinterface 792 1 0
    //   1951: aload_0
    //   1952: aconst_null
    //   1953: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   1956: iload 6
    //   1958: iconst_1
    //   1959: iadd
    //   1960: istore_3
    //   1961: goto -1756 -> 205
    //   1964: lload 12
    //   1966: lstore 14
    //   1968: lload 12
    //   1970: lstore 16
    //   1972: aload_2
    //   1973: invokevirtual 795	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1976: lload 12
    //   1978: lstore 14
    //   1980: lload 12
    //   1982: lstore 16
    //   1984: getstatic 799	com/tencent/component/network/downloader/impl/FastDownloadTask:sRequestOptions	Ljava/lang/ThreadLocal;
    //   1987: invokevirtual 805	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1990: checkcast 807	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1993: astore 30
    //   1995: lload 12
    //   1997: lstore 14
    //   1999: lload 12
    //   2001: lstore 16
    //   2003: aload 30
    //   2005: aload_0
    //   2006: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   2009: putfield 808	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:allowProxy	Z
    //   2012: lload 12
    //   2014: lstore 14
    //   2016: lload 12
    //   2018: lstore 16
    //   2020: aload 30
    //   2022: aload_0
    //   2023: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   2026: putfield 811	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:apnProxy	Z
    //   2029: lload 12
    //   2031: lstore 14
    //   2033: lload 12
    //   2035: lstore 16
    //   2037: aload_0
    //   2038: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2041: ifnull +2681 -> 4722
    //   2044: lload 12
    //   2046: lstore 14
    //   2048: lload 12
    //   2050: lstore 16
    //   2052: aload_0
    //   2053: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   2056: invokeinterface 657 1 0
    //   2061: astore 22
    //   2063: lload 12
    //   2065: lstore 14
    //   2067: lload 12
    //   2069: lstore 16
    //   2071: aload 30
    //   2073: aload 22
    //   2075: putfield 814	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2078: lload 12
    //   2080: lstore 14
    //   2082: lload 12
    //   2084: lstore 16
    //   2086: aload 29
    //   2088: iload_3
    //   2089: putfield 817	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   2092: lload 12
    //   2094: lstore 14
    //   2096: lload 12
    //   2098: lstore 16
    //   2100: aload 29
    //   2102: aload_0
    //   2103: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2106: putfield 822	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   2109: lload 12
    //   2111: lstore 14
    //   2113: lload 12
    //   2115: lstore 16
    //   2117: aload_0
    //   2118: aload_0
    //   2119: aload_0
    //   2120: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2123: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   2126: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2129: lload 12
    //   2131: lstore 14
    //   2133: lload 12
    //   2135: lstore 16
    //   2137: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2140: iconst_2
    //   2141: if_icmpeq +15009 -> 17150
    //   2144: lload 12
    //   2146: lstore 14
    //   2148: lload 12
    //   2150: lstore 16
    //   2152: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   2155: iconst_3
    //   2156: if_icmpne +2572 -> 4728
    //   2159: goto +14991 -> 17150
    //   2162: lload 12
    //   2164: lstore 14
    //   2166: lload 12
    //   2168: lstore 16
    //   2170: aload_0
    //   2171: invokevirtual 828	com/tencent/component/network/downloader/impl/FastDownloadTask:enableIpv6Debug	()Z
    //   2174: istore 10
    //   2176: lload 12
    //   2178: lstore 14
    //   2180: lload 12
    //   2182: lstore 16
    //   2184: aload 30
    //   2186: getfield 814	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:mobileProxy	Ljava/net/Proxy;
    //   2189: ifnonnull +4626 -> 6815
    //   2192: lload 12
    //   2194: lstore 14
    //   2196: lload 12
    //   2198: lstore 16
    //   2200: aload_0
    //   2201: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2204: ldc_w 687
    //   2207: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2210: ifeq +18 -> 2228
    //   2213: lload 12
    //   2215: lstore 14
    //   2217: lload 12
    //   2219: lstore 16
    //   2221: aload_0
    //   2222: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2225: ifeq +4590 -> 6815
    //   2228: lload 12
    //   2230: lstore 14
    //   2232: lload 12
    //   2234: lstore 16
    //   2236: aload_0
    //   2237: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2240: ifnull +4575 -> 6815
    //   2243: lload 12
    //   2245: lstore 14
    //   2247: lload 12
    //   2249: lstore 16
    //   2251: aload_0
    //   2252: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2255: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2258: ifnull +4557 -> 6815
    //   2261: lload 12
    //   2263: lstore 14
    //   2265: lload 12
    //   2267: lstore 16
    //   2269: aload_0
    //   2270: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2273: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2276: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2279: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2282: ifne +4533 -> 6815
    //   2285: lload 12
    //   2287: lstore 14
    //   2289: lload 12
    //   2291: lstore 16
    //   2293: aload_0
    //   2294: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2297: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2300: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2303: astore 28
    //   2305: lload 12
    //   2307: lstore 14
    //   2309: lload 12
    //   2311: lstore 16
    //   2313: aload_0
    //   2314: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2317: astore 27
    //   2319: lload 12
    //   2321: lstore 14
    //   2323: lload 12
    //   2325: lstore 16
    //   2327: aload 28
    //   2329: bipush 58
    //   2331: invokestatic 832	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2334: istore 4
    //   2336: iload 5
    //   2338: ifne +14818 -> 17156
    //   2341: aload 27
    //   2343: astore 22
    //   2345: iload 4
    //   2347: iconst_2
    //   2348: if_icmpge +150 -> 2498
    //   2351: lload 12
    //   2353: lstore 14
    //   2355: lload 12
    //   2357: lstore 16
    //   2359: aload_0
    //   2360: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   2363: istore 4
    //   2365: iload 4
    //   2367: ifle +2367 -> 4734
    //   2370: lload 12
    //   2372: lstore 14
    //   2374: lload 12
    //   2376: lstore 16
    //   2378: aload_0
    //   2379: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2382: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2385: iload 4
    //   2387: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2390: lload 12
    //   2392: lstore 14
    //   2394: iload 4
    //   2396: istore 6
    //   2398: lload 12
    //   2400: lstore 16
    //   2402: iload 4
    //   2404: invokestatic 202	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2407: ifne +7 -> 2414
    //   2410: bipush 80
    //   2412: istore 6
    //   2414: lload 12
    //   2416: lstore 14
    //   2418: lload 12
    //   2420: lstore 16
    //   2422: new 127	java/lang/StringBuilder
    //   2425: dup
    //   2426: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2429: aload 28
    //   2431: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: ldc_w 837
    //   2437: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: iload 6
    //   2442: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2445: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2448: astore 23
    //   2450: lload 12
    //   2452: lstore 14
    //   2454: aload 23
    //   2456: astore 22
    //   2458: lload 12
    //   2460: lstore 16
    //   2462: aload_0
    //   2463: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2466: ifnull +32 -> 2498
    //   2469: lload 12
    //   2471: lstore 14
    //   2473: lload 12
    //   2475: lstore 16
    //   2477: aload_0
    //   2478: aload_0
    //   2479: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2482: aload_0
    //   2483: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   2486: aload 23
    //   2488: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2491: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2494: aload 23
    //   2496: astore 22
    //   2498: lload 12
    //   2500: lstore 14
    //   2502: lload 12
    //   2504: lstore 16
    //   2506: aload 29
    //   2508: aload_0
    //   2509: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2512: invokevirtual 139	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2515: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2518: lload 12
    //   2520: lstore 14
    //   2522: lload 12
    //   2524: lstore 16
    //   2526: invokestatic 849	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   2529: ifeq +77 -> 2606
    //   2532: lload 12
    //   2534: lstore 14
    //   2536: lload 12
    //   2538: lstore 16
    //   2540: ldc 221
    //   2542: new 127	java/lang/StringBuilder
    //   2545: dup
    //   2546: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2549: ldc_w 851
    //   2552: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: aload 29
    //   2557: getfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2560: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: ldc_w 853
    //   2566: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: aload 22
    //   2571: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: ldc 153
    //   2576: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: aload_0
    //   2580: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2583: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2586: ldc 227
    //   2588: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2594: invokevirtual 176	java/lang/Thread:getId	()J
    //   2597: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2600: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2603: invokestatic 393	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2606: lload 12
    //   2608: lstore 14
    //   2610: lload 12
    //   2612: lstore 16
    //   2614: aload_0
    //   2615: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2618: ifnull +43 -> 2661
    //   2621: lload 12
    //   2623: lstore 14
    //   2625: lload 12
    //   2627: lstore 16
    //   2629: aload 29
    //   2631: aload_0
    //   2632: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2635: invokevirtual 139	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2638: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2641: lload 12
    //   2643: lstore 14
    //   2645: lload 12
    //   2647: lstore 16
    //   2649: aload 29
    //   2651: aload_0
    //   2652: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2655: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2658: putfield 856	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2661: lload 12
    //   2663: lstore 14
    //   2665: lload 12
    //   2667: lstore 16
    //   2669: aload_0
    //   2670: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   2673: ifeq +4483 -> 7156
    //   2676: iload 5
    //   2678: ifne +4478 -> 7156
    //   2681: lload 12
    //   2683: lstore 14
    //   2685: lload 12
    //   2687: lstore 16
    //   2689: aload_0
    //   2690: aload_0
    //   2691: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   2694: aload_0
    //   2695: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2698: aload_0
    //   2699: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2702: aload_0
    //   2703: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   2706: aload_0
    //   2707: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   2710: invokestatic 862	com/tencent/component/network/utils/http/HttpUtil:createOkHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   2713: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2716: lload 12
    //   2718: lstore 14
    //   2720: lload 12
    //   2722: lstore 16
    //   2724: aload_0
    //   2725: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2728: ifnull +36 -> 2764
    //   2731: lload 12
    //   2733: lstore 14
    //   2735: lload 12
    //   2737: lstore 16
    //   2739: aload_0
    //   2740: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2743: aload_0
    //   2744: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2747: aload_0
    //   2748: getfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2751: aload_0
    //   2752: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2755: aload_0
    //   2756: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2759: invokeinterface 866 5 0
    //   2764: lload 12
    //   2766: lstore 14
    //   2768: lload 12
    //   2770: lstore 16
    //   2772: aload_0
    //   2773: aload_0
    //   2774: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2777: aload_0
    //   2778: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2781: aload_0
    //   2782: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2785: aload_0
    //   2786: getfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2789: invokevirtual 869	com/tencent/component/network/downloader/impl/FastDownloadTask:prepareRequest	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;)V
    //   2792: lload 12
    //   2794: lstore 14
    //   2796: lload 12
    //   2798: lstore 16
    //   2800: aload_0
    //   2801: aload_0
    //   2802: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   2805: aload_0
    //   2806: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   2809: aload_0
    //   2810: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2813: aload_0
    //   2814: getfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   2817: aload 30
    //   2819: invokevirtual 873	com/tencent/component/network/downloader/impl/FastDownloadTask:applyKeepAliveStrategy	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lokhttp3/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2822: lload 12
    //   2824: lstore 14
    //   2826: lload 12
    //   2828: lstore 16
    //   2830: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   2833: lload 20
    //   2835: lsub
    //   2836: lstore 12
    //   2838: lload 12
    //   2840: lstore 14
    //   2842: lload 12
    //   2844: lstore 16
    //   2846: aload_0
    //   2847: lconst_0
    //   2848: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2851: lload 12
    //   2853: lstore 14
    //   2855: lload 12
    //   2857: lstore 16
    //   2859: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2862: lstore 20
    //   2864: lload 12
    //   2866: lstore 14
    //   2868: lload 12
    //   2870: lstore 16
    //   2872: aload_0
    //   2873: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2876: ifnull +4320 -> 7196
    //   2879: lload 12
    //   2881: lstore 14
    //   2883: lload 12
    //   2885: lstore 16
    //   2887: aload_0
    //   2888: getfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2891: ifnonnull +18 -> 2909
    //   2894: lload 12
    //   2896: lstore 14
    //   2898: lload 12
    //   2900: lstore 16
    //   2902: aload_0
    //   2903: invokestatic 881	com/tencent/component/network/utils/http/HttpUtil:CreateDefaultHttpClient	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2906: putfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2909: lload 12
    //   2911: lstore 14
    //   2913: lload 12
    //   2915: lstore 16
    //   2917: invokestatic 885	com/tencent/component/network/utils/http/HttpUtil:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   2920: astore 22
    //   2922: aload_0
    //   2923: getfield 877	com/tencent/component/network/downloader/impl/FastDownloadTask:pHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2926: aload_0
    //   2927: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   2930: aload 22
    //   2932: invokevirtual 890	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2935: astore 23
    //   2937: aconst_null
    //   2938: astore 25
    //   2940: aload 22
    //   2942: astore 24
    //   2944: aload 25
    //   2946: astore 22
    //   2948: aload_0
    //   2949: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   2952: lload 20
    //   2954: lsub
    //   2955: putfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   2958: aload 23
    //   2960: ifnonnull +8 -> 2968
    //   2963: aload 22
    //   2965: ifnull +11598 -> 14563
    //   2968: aload 23
    //   2970: ifnull +4295 -> 7265
    //   2973: aload 23
    //   2975: invokeinterface 896 1 0
    //   2980: ifnull +4285 -> 7265
    //   2983: aload 23
    //   2985: invokeinterface 896 1 0
    //   2990: invokeinterface 901 1 0
    //   2995: istore 4
    //   2997: aload_2
    //   2998: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3001: iload 4
    //   3003: putfield 902	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   3006: sipush 200
    //   3009: iload 4
    //   3011: if_icmpeq +11 -> 3022
    //   3014: sipush 206
    //   3017: iload 4
    //   3019: if_icmpne +9842 -> 12861
    //   3022: iload 4
    //   3024: istore 5
    //   3026: aload_0
    //   3027: aload 23
    //   3029: aload 22
    //   3031: aload_2
    //   3032: aload_1
    //   3033: iload 4
    //   3035: invokevirtual 906	com/tencent/component/network/downloader/impl/FastDownloadTask:handleResponse	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   3038: ifeq +9876 -> 12914
    //   3041: aload_2
    //   3042: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3045: invokevirtual 909	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   3048: aload_2
    //   3049: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3052: getfield 912	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   3055: ifeq +7407 -> 10462
    //   3058: aload_0
    //   3059: aload 23
    //   3061: aload 22
    //   3063: invokevirtual 916	com/tencent/component/network/downloader/impl/FastDownloadTask:getRetcode	(Lorg/apache/http/HttpResponse;Lokhttp3/Response;)I
    //   3066: istore 5
    //   3068: aload_2
    //   3069: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3072: iload 5
    //   3074: putfield 919	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   3077: iload 5
    //   3079: invokestatic 922	com/tencent/component/network/module/base/Config:canRetCodeRetry	(I)Z
    //   3082: istore 10
    //   3084: iload 10
    //   3086: ifeq +4977 -> 8063
    //   3089: aload_2
    //   3090: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3093: lload 18
    //   3095: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3098: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3101: aload_2
    //   3102: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3105: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3108: aload_0
    //   3109: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3112: lsub
    //   3113: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   3116: aload_2
    //   3117: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3120: aload_0
    //   3121: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   3124: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   3127: aload_0
    //   3128: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3131: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   3134: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3137: astore 27
    //   3139: aload_0
    //   3140: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3143: ifnull +4137 -> 7280
    //   3146: aload_0
    //   3147: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3150: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3153: ifnull +4127 -> 7280
    //   3156: aload_0
    //   3157: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3160: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3163: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   3166: astore 25
    //   3168: aload_0
    //   3169: aload_0
    //   3170: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   3173: aload 23
    //   3175: aload 22
    //   3177: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   3180: astore 28
    //   3182: aload 24
    //   3184: ifnull +13940 -> 17124
    //   3187: aload 24
    //   3189: ldc_w 493
    //   3192: invokeinterface 499 2 0
    //   3197: checkcast 284	java/lang/String
    //   3200: astore 24
    //   3202: aload_2
    //   3203: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3206: aload 24
    //   3208: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   3211: aload_0
    //   3212: lconst_0
    //   3213: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3216: aload_0
    //   3217: iconst_0
    //   3218: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3221: aload_0
    //   3222: lconst_0
    //   3223: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3226: aload_0
    //   3227: iconst_0
    //   3228: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3231: aload_2
    //   3232: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3235: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3238: ifeq +12 -> 3250
    //   3241: aload_1
    //   3242: invokeinterface 360 1 0
    //   3247: ifeq +31 -> 3278
    //   3250: aload_0
    //   3251: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3254: ifnull +24 -> 3278
    //   3257: aload_0
    //   3258: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3261: aload_0
    //   3262: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3265: aload_2
    //   3266: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3269: aload 23
    //   3271: aload 22
    //   3273: invokeinterface 524 5 0
    //   3278: aload_1
    //   3279: invokeinterface 360 1 0
    //   3284: ifne +1403 -> 4687
    //   3287: aload_0
    //   3288: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3291: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3294: istore 10
    //   3296: aload_2
    //   3297: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3300: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3303: ifne +4028 -> 7331
    //   3306: new 127	java/lang/StringBuilder
    //   3309: dup
    //   3310: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   3313: ldc_w 526
    //   3316: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: aload_0
    //   3320: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3323: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: ldc_w 528
    //   3329: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3332: aload_0
    //   3333: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3336: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3339: ldc_w 533
    //   3342: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3345: astore 30
    //   3347: aload_0
    //   3348: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   3351: ifeq +3945 -> 7296
    //   3354: aload 22
    //   3356: ifnull +3940 -> 7296
    //   3359: aload 22
    //   3361: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3364: ifnull +3932 -> 7296
    //   3367: aload 22
    //   3369: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   3372: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   3375: astore 26
    //   3377: aload 30
    //   3379: aload 26
    //   3381: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3384: ldc_w 544
    //   3387: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3390: aload 27
    //   3392: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3395: ldc_w 549
    //   3398: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: aload 25
    //   3403: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3406: ldc_w 551
    //   3409: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: aconst_null
    //   3413: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3416: ldc_w 553
    //   3419: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3422: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3425: invokevirtual 176	java/lang/Thread:getId	()J
    //   3428: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3431: ldc_w 555
    //   3434: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3437: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3440: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3443: ldc_w 557
    //   3446: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3449: aload_0
    //   3450: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3453: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3456: ldc_w 559
    //   3459: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: aload_0
    //   3463: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3466: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3469: ldc_w 561
    //   3472: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3475: astore 30
    //   3477: aload_0
    //   3478: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   3481: ifeq +3823 -> 7304
    //   3484: aload_0
    //   3485: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   3488: aload_0
    //   3489: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   3492: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3495: astore 26
    //   3497: aload 30
    //   3499: aload 26
    //   3501: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3504: ldc_w 563
    //   3507: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3510: iload 10
    //   3512: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3515: ldc_w 565
    //   3518: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   3524: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3527: ldc_w 572
    //   3530: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3533: aload_2
    //   3534: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3537: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3540: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3543: ldc_w 577
    //   3546: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3549: aload_2
    //   3550: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3553: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3556: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3559: ldc_w 582
    //   3562: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   3568: aload_0
    //   3569: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   3572: lsub
    //   3573: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3576: ldc_w 584
    //   3579: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3582: aload_2
    //   3583: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3586: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3589: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3592: ldc_w 589
    //   3595: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: aload_2
    //   3599: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3602: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3605: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3608: ldc_w 593
    //   3611: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: aload_2
    //   3615: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3618: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3621: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3624: ldc_w 598
    //   3627: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: aload_0
    //   3631: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   3634: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3637: ldc_w 600
    //   3640: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: aload_0
    //   3644: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   3647: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3650: ldc_w 605
    //   3653: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3656: aload_2
    //   3657: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3660: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3663: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3666: ldc_w 610
    //   3669: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3672: iload 4
    //   3674: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3677: ldc_w 612
    //   3680: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3683: aload 28
    //   3685: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3688: ldc_w 614
    //   3691: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3694: aload 24
    //   3696: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3699: ldc_w 616
    //   3702: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3705: astore 30
    //   3707: aload_0
    //   3708: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3711: ifnull +3599 -> 7310
    //   3714: aload_0
    //   3715: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3718: iconst_0
    //   3719: bipush 30
    //   3721: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   3724: astore 26
    //   3726: aload 30
    //   3728: aload 26
    //   3730: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3733: ldc_w 622
    //   3736: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3739: astore 26
    //   3741: aload_0
    //   3742: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3745: ifnull +3574 -> 7319
    //   3748: aload_0
    //   3749: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3752: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3755: istore 5
    //   3757: aload 26
    //   3759: iload 5
    //   3761: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3764: ldc_w 624
    //   3767: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: aload_2
    //   3771: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3774: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3777: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3780: ldc_w 629
    //   3783: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3786: lload 12
    //   3788: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3791: ldc_w 631
    //   3794: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3797: aload_0
    //   3798: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   3801: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3804: ldc_w 600
    //   3807: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3810: aload_0
    //   3811: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   3814: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3817: ldc_w 633
    //   3820: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3823: aload_0
    //   3824: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   3827: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3830: ldc_w 600
    //   3833: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3836: aload_0
    //   3837: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   3840: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3843: ldc_w 635
    //   3846: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3849: aload_0
    //   3850: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   3853: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3856: ldc_w 637
    //   3859: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: aload_0
    //   3863: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   3866: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3869: ldc_w 642
    //   3872: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3875: aload_0
    //   3876: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   3879: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3882: ldc_w 647
    //   3885: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: astore 30
    //   3890: aload_0
    //   3891: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3894: ifnull +3431 -> 7325
    //   3897: aload_0
    //   3898: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3901: invokeinterface 657 1 0
    //   3906: astore 26
    //   3908: aload 29
    //   3910: aload 30
    //   3912: aload 26
    //   3914: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3917: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3920: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3923: ldc_w 448
    //   3926: aload 29
    //   3928: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3931: aconst_null
    //   3932: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3935: aload_0
    //   3936: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3939: ifnull +24 -> 3963
    //   3942: aload_0
    //   3943: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   3946: ldc_w 440
    //   3949: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3952: ifeq +11 -> 3963
    //   3955: aload_0
    //   3956: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   3959: iconst_0
    //   3960: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   3963: iload 10
    //   3965: ifne +8 -> 3973
    //   3968: aload_0
    //   3969: iconst_0
    //   3970: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   3973: aload_2
    //   3974: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3977: astore 26
    //   3979: new 127	java/lang/StringBuilder
    //   3982: dup
    //   3983: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   3986: aload_0
    //   3987: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   3990: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3993: ldc_w 671
    //   3996: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3999: aload 25
    //   4001: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4004: ldc_w 673
    //   4007: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4010: aload_2
    //   4011: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4014: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4017: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4020: ldc_w 675
    //   4023: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4026: astore 25
    //   4028: aload_0
    //   4029: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4032: ifnull +3939 -> 7971
    //   4035: aload_0
    //   4036: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4039: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4042: istore 5
    //   4044: aload 25
    //   4046: iload 5
    //   4048: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4051: ldc_w 610
    //   4054: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4057: iload 4
    //   4059: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4062: ldc_w 572
    //   4065: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4068: aload_2
    //   4069: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4072: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4075: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4078: ldc_w 584
    //   4081: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: aload_2
    //   4085: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4088: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4091: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4094: ldc_w 589
    //   4097: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4100: aload_2
    //   4101: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4104: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4107: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4110: ldc_w 577
    //   4113: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4116: aload_2
    //   4117: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4120: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4123: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4126: ldc_w 582
    //   4129: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4135: aload_0
    //   4136: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4139: lsub
    //   4140: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4143: astore 25
    //   4145: aload 24
    //   4147: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4150: ifne +3827 -> 7977
    //   4153: new 127	java/lang/StringBuilder
    //   4156: dup
    //   4157: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   4160: ldc_w 614
    //   4163: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4166: aload 24
    //   4168: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4171: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4174: astore 24
    //   4176: aload 26
    //   4178: aload 25
    //   4180: aload 24
    //   4182: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: ldc_w 612
    //   4188: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4191: aload 28
    //   4193: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4196: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4199: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   4202: aload_0
    //   4203: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4206: ifnull +53 -> 4259
    //   4209: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4212: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4215: aload_0
    //   4216: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4219: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4222: if_icmpne +37 -> 4259
    //   4225: aload_0
    //   4226: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4229: ifnull +30 -> 4259
    //   4232: aload_0
    //   4233: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4236: aload_0
    //   4237: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4240: aload_0
    //   4241: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4244: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4247: aload_2
    //   4248: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4251: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4254: invokeinterface 685 4 0
    //   4259: aload_0
    //   4260: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4263: ifnull +53 -> 4316
    //   4266: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4269: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4272: aload_0
    //   4273: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4276: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4279: if_icmpne +37 -> 4316
    //   4282: aload_0
    //   4283: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4286: ifnull +30 -> 4316
    //   4289: aload_0
    //   4290: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4293: aload_0
    //   4294: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4297: aload_0
    //   4298: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4301: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4304: aload_2
    //   4305: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4308: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4311: invokeinterface 685 4 0
    //   4316: iload 10
    //   4318: ifeq +64 -> 4382
    //   4321: aload_0
    //   4322: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4325: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   4328: astore 24
    //   4330: aload_0
    //   4331: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4334: astore 25
    //   4336: aload_0
    //   4337: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4340: ifeq +3675 -> 8015
    //   4343: aload_0
    //   4344: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4347: ifnull +3668 -> 8015
    //   4350: aload_0
    //   4351: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4354: ldc_w 687
    //   4357: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4360: ifeq +3655 -> 8015
    //   4363: iconst_1
    //   4364: istore 10
    //   4366: aload 24
    //   4368: aload 25
    //   4370: iload 10
    //   4372: aload_2
    //   4373: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4376: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4379: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   4382: aload 29
    //   4384: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   4387: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4390: aload 29
    //   4392: aload_0
    //   4393: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   4396: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4399: aload 29
    //   4401: aload 23
    //   4403: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4406: aload 29
    //   4408: aload 22
    //   4410: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   4413: aload 29
    //   4415: iload 4
    //   4417: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4420: aload 29
    //   4422: aconst_null
    //   4423: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4426: aload 27
    //   4428: ifnonnull +3593 -> 8021
    //   4431: aconst_null
    //   4432: astore 23
    //   4434: aload 29
    //   4436: aload 23
    //   4438: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4441: aload 29
    //   4443: aconst_null
    //   4444: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4447: aload 29
    //   4449: aload_2
    //   4450: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4453: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4456: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4459: aload 29
    //   4461: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4464: aload_0
    //   4465: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4468: lsub
    //   4469: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4472: aload 29
    //   4474: aload_2
    //   4475: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4478: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4481: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4484: aload 29
    //   4486: aload 29
    //   4488: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4491: aload_2
    //   4492: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4495: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4498: lsub
    //   4499: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4502: aload 29
    //   4504: lload 12
    //   4506: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4509: aload 29
    //   4511: aload_0
    //   4512: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   4515: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4518: aload 29
    //   4520: aload_0
    //   4521: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   4524: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4527: aload 29
    //   4529: aload_0
    //   4530: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   4533: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4536: aload 29
    //   4538: lconst_0
    //   4539: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4542: aload 29
    //   4544: aload_0
    //   4545: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   4548: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4551: aload 29
    //   4553: aload_2
    //   4554: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4557: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4560: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4563: aload 29
    //   4565: aload_0
    //   4566: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   4569: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   4572: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4575: aload 29
    //   4577: aload_0
    //   4578: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4581: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4584: aload_0
    //   4585: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4588: ifnull +3443 -> 8031
    //   4591: aload_0
    //   4592: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4595: ldc_w 687
    //   4598: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4601: ifeq +3430 -> 8031
    //   4604: iconst_1
    //   4605: istore 10
    //   4607: aload 29
    //   4609: iload 10
    //   4611: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   4614: aload 29
    //   4616: aload_2
    //   4617: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4620: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4623: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4626: aload 29
    //   4628: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   4631: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   4634: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   4637: aload 22
    //   4639: ifnull +24 -> 4663
    //   4642: aload 22
    //   4644: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4647: ifnull +16 -> 4663
    //   4650: aload 29
    //   4652: aload 22
    //   4654: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   4657: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   4660: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   4663: aload_2
    //   4664: aload 29
    //   4666: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4669: aload_2
    //   4670: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4673: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4676: ifeq +11 -> 4687
    //   4679: aload_0
    //   4680: aload_1
    //   4681: aload_2
    //   4682: aload 29
    //   4684: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4687: aload_0
    //   4688: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   4691: ifeq +3346 -> 8037
    //   4694: aload_0
    //   4695: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4698: ifnull +12 -> 4710
    //   4701: aload_0
    //   4702: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   4705: invokeinterface 792 1 0
    //   4710: aload_0
    //   4711: aconst_null
    //   4712: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   4715: iload_3
    //   4716: iconst_1
    //   4717: iadd
    //   4718: istore_3
    //   4719: goto -4514 -> 205
    //   4722: aconst_null
    //   4723: astore 22
    //   4725: goto -2662 -> 2063
    //   4728: iconst_0
    //   4729: istore 5
    //   4731: goto -2569 -> 2162
    //   4734: lload 12
    //   4736: lstore 14
    //   4738: lload 12
    //   4740: lstore 16
    //   4742: aload_0
    //   4743: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4746: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4749: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4752: istore 4
    //   4754: goto -2364 -> 2390
    //   4757: lload 12
    //   4759: lstore 14
    //   4761: lload 12
    //   4763: lstore 16
    //   4765: aload 23
    //   4767: bipush 58
    //   4769: invokestatic 832	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   4772: iconst_2
    //   4773: if_icmplt +1822 -> 6595
    //   4776: lload 12
    //   4778: lstore 14
    //   4780: lload 12
    //   4782: lstore 16
    //   4784: aload_0
    //   4785: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   4788: istore 4
    //   4790: iload 4
    //   4792: ifle +1780 -> 6572
    //   4795: lload 12
    //   4797: lstore 14
    //   4799: lload 12
    //   4801: lstore 16
    //   4803: aload_0
    //   4804: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4807: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4810: iload 4
    //   4812: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   4815: lload 12
    //   4817: lstore 14
    //   4819: iload 4
    //   4821: istore 6
    //   4823: lload 12
    //   4825: lstore 16
    //   4827: iload 4
    //   4829: invokestatic 202	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   4832: ifne +7 -> 4839
    //   4835: bipush 80
    //   4837: istore 6
    //   4839: lload 12
    //   4841: lstore 14
    //   4843: lload 12
    //   4845: lstore 16
    //   4847: new 127	java/lang/StringBuilder
    //   4850: dup
    //   4851: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   4854: ldc_w 924
    //   4857: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4860: aload 23
    //   4862: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4865: ldc_w 926
    //   4868: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4871: iload 6
    //   4873: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4876: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4879: astore 23
    //   4881: lload 12
    //   4883: lstore 14
    //   4885: aload 23
    //   4887: astore 22
    //   4889: lload 12
    //   4891: lstore 16
    //   4893: aload_0
    //   4894: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4897: ifnull -2399 -> 2498
    //   4900: lload 12
    //   4902: lstore 14
    //   4904: lload 12
    //   4906: lstore 16
    //   4908: aload_0
    //   4909: aload_0
    //   4910: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4913: aload_0
    //   4914: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   4917: aload 23
    //   4919: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4922: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   4925: aload 23
    //   4927: astore 22
    //   4929: goto -2431 -> 2498
    //   4932: astore 22
    //   4934: aconst_null
    //   4935: astore 23
    //   4937: iload 7
    //   4939: istore 4
    //   4941: lload 16
    //   4943: lstore 12
    //   4945: aload_2
    //   4946: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4949: lload 18
    //   4951: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4954: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4957: aload_2
    //   4958: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4961: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   4964: aload_0
    //   4965: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   4968: lsub
    //   4969: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   4972: aload_2
    //   4973: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4976: aload_0
    //   4977: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   4980: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   4983: aload_0
    //   4984: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   4987: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4990: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4993: astore 30
    //   4995: aload_0
    //   4996: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4999: ifnull +11139 -> 16138
    //   5002: aload_0
    //   5003: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5006: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5009: ifnull +11129 -> 16138
    //   5012: aload_0
    //   5013: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5016: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5019: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5022: astore 27
    //   5024: aload_0
    //   5025: aload_0
    //   5026: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   5029: aload 26
    //   5031: aload 25
    //   5033: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   5036: astore 31
    //   5038: aload 24
    //   5040: ifnull +12044 -> 17084
    //   5043: aload 24
    //   5045: ldc_w 493
    //   5048: invokeinterface 499 2 0
    //   5053: checkcast 284	java/lang/String
    //   5056: astore 24
    //   5058: aload_2
    //   5059: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5062: aload 24
    //   5064: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   5067: aload_0
    //   5068: lconst_0
    //   5069: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5072: aload_0
    //   5073: iconst_0
    //   5074: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5077: aload_0
    //   5078: lconst_0
    //   5079: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5082: aload_0
    //   5083: iconst_0
    //   5084: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5087: aload_2
    //   5088: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5091: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5094: ifeq +12 -> 5106
    //   5097: aload_1
    //   5098: invokeinterface 360 1 0
    //   5103: ifeq +31 -> 5134
    //   5106: aload_0
    //   5107: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5110: ifnull +24 -> 5134
    //   5113: aload_0
    //   5114: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5117: aload_0
    //   5118: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5121: aload_2
    //   5122: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5125: aload 26
    //   5127: aload 25
    //   5129: invokeinterface 524 5 0
    //   5134: aload_1
    //   5135: invokeinterface 360 1 0
    //   5140: ifne +1401 -> 6541
    //   5143: aload_0
    //   5144: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5147: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5150: istore 10
    //   5152: aload_2
    //   5153: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5156: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5159: ifne +11029 -> 16188
    //   5162: new 127	java/lang/StringBuilder
    //   5165: dup
    //   5166: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   5169: ldc_w 526
    //   5172: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5175: aload_0
    //   5176: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5179: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5182: ldc_w 528
    //   5185: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5188: aload_0
    //   5189: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5192: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5195: ldc_w 533
    //   5198: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5201: astore 32
    //   5203: aload_0
    //   5204: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   5207: ifeq +10947 -> 16154
    //   5210: aload 25
    //   5212: ifnull +10942 -> 16154
    //   5215: aload 25
    //   5217: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5220: ifnull +10934 -> 16154
    //   5223: aload 25
    //   5225: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   5228: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   5231: astore 28
    //   5233: aload 32
    //   5235: aload 28
    //   5237: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5240: ldc_w 544
    //   5243: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5246: aload 30
    //   5248: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5251: ldc_w 549
    //   5254: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5257: aload 27
    //   5259: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: ldc_w 551
    //   5265: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5268: aconst_null
    //   5269: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5272: ldc_w 553
    //   5275: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5278: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5281: invokevirtual 176	java/lang/Thread:getId	()J
    //   5284: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5287: ldc_w 555
    //   5290: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5293: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5296: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: ldc_w 557
    //   5302: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5305: aload_0
    //   5306: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5309: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5312: ldc_w 559
    //   5315: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5318: aload_0
    //   5319: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5322: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5325: ldc_w 561
    //   5328: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5331: astore 32
    //   5333: aload_0
    //   5334: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   5337: ifeq +10825 -> 16162
    //   5340: aload_0
    //   5341: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   5344: aload_0
    //   5345: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   5348: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5351: astore 28
    //   5353: aload 32
    //   5355: aload 28
    //   5357: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5360: ldc_w 563
    //   5363: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: iload 10
    //   5368: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5371: ldc_w 565
    //   5374: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5377: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   5380: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5383: ldc_w 572
    //   5386: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5389: aload_2
    //   5390: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5393: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5396: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5399: ldc_w 577
    //   5402: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5405: aload_2
    //   5406: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5409: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5412: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5415: ldc_w 582
    //   5418: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5424: aload_0
    //   5425: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5428: lsub
    //   5429: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5432: ldc_w 584
    //   5435: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5438: aload_2
    //   5439: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5442: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5445: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5448: ldc_w 589
    //   5451: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5454: aload_2
    //   5455: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5458: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5461: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5464: ldc_w 593
    //   5467: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5470: aload_2
    //   5471: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5474: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5477: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5480: ldc_w 598
    //   5483: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5486: aload_0
    //   5487: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   5490: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5493: ldc_w 600
    //   5496: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5499: aload_0
    //   5500: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   5503: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5506: ldc_w 605
    //   5509: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5512: aload_2
    //   5513: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5516: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5519: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5522: ldc_w 610
    //   5525: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5528: iload 4
    //   5530: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5533: ldc_w 612
    //   5536: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5539: aload 31
    //   5541: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5544: ldc_w 614
    //   5547: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: aload 24
    //   5552: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5555: ldc_w 616
    //   5558: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5561: astore 32
    //   5563: aload_0
    //   5564: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5567: ifnull +10601 -> 16168
    //   5570: aload_0
    //   5571: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5574: iconst_0
    //   5575: bipush 30
    //   5577: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   5580: astore 28
    //   5582: aload 32
    //   5584: aload 28
    //   5586: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5589: ldc_w 622
    //   5592: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5595: astore 28
    //   5597: aload_0
    //   5598: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5601: ifnull +10576 -> 16177
    //   5604: aload_0
    //   5605: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5608: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5611: istore_3
    //   5612: aload 28
    //   5614: iload_3
    //   5615: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5618: ldc_w 624
    //   5621: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5624: aload_2
    //   5625: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5628: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5631: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5634: ldc_w 629
    //   5637: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5640: lload 12
    //   5642: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5645: ldc_w 631
    //   5648: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5651: aload_0
    //   5652: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   5655: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5658: ldc_w 600
    //   5661: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5664: aload_0
    //   5665: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   5668: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5671: ldc_w 633
    //   5674: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5677: aload_0
    //   5678: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   5681: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5684: ldc_w 600
    //   5687: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5690: aload_0
    //   5691: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   5694: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5697: ldc_w 635
    //   5700: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5703: aload_0
    //   5704: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   5707: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5710: ldc_w 637
    //   5713: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5716: aload_0
    //   5717: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   5720: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5723: ldc_w 642
    //   5726: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5729: aload_0
    //   5730: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   5733: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5736: ldc_w 647
    //   5739: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5742: astore 32
    //   5744: aload_0
    //   5745: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5748: ifnull +10434 -> 16182
    //   5751: aload_0
    //   5752: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5755: invokeinterface 657 1 0
    //   5760: astore 28
    //   5762: aload 29
    //   5764: aload 32
    //   5766: aload 28
    //   5768: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5771: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5774: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5777: ldc_w 448
    //   5780: aload 29
    //   5782: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5785: aload 23
    //   5787: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5790: aload_0
    //   5791: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5794: ifnull +24 -> 5818
    //   5797: aload_0
    //   5798: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   5801: ldc_w 440
    //   5804: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5807: ifeq +11 -> 5818
    //   5810: aload_0
    //   5811: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   5814: iconst_0
    //   5815: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   5818: iload 10
    //   5820: ifne +8 -> 5828
    //   5823: aload_0
    //   5824: iconst_0
    //   5825: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   5828: aload_2
    //   5829: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5832: astore 28
    //   5834: new 127	java/lang/StringBuilder
    //   5837: dup
    //   5838: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   5841: aload_0
    //   5842: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   5845: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5848: ldc_w 671
    //   5851: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5854: aload 27
    //   5856: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5859: ldc_w 673
    //   5862: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5865: aload_2
    //   5866: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5869: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5872: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5875: ldc_w 675
    //   5878: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5881: astore 27
    //   5883: aload_0
    //   5884: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5887: ifnull +10938 -> 16825
    //   5890: aload_0
    //   5891: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5894: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5897: istore_3
    //   5898: aload 27
    //   5900: iload_3
    //   5901: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5904: ldc_w 610
    //   5907: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5910: iload 4
    //   5912: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5915: ldc_w 572
    //   5918: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5921: aload_2
    //   5922: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5925: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5928: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5931: ldc_w 584
    //   5934: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5937: aload_2
    //   5938: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5941: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5944: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5947: ldc_w 589
    //   5950: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5953: aload_2
    //   5954: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5957: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5960: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5963: ldc_w 577
    //   5966: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5969: aload_2
    //   5970: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5973: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5976: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5979: ldc_w 582
    //   5982: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5985: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   5988: aload_0
    //   5989: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   5992: lsub
    //   5993: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5996: astore 27
    //   5998: aload 24
    //   6000: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6003: ifne +10827 -> 16830
    //   6006: new 127	java/lang/StringBuilder
    //   6009: dup
    //   6010: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   6013: ldc_w 614
    //   6016: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6019: aload 24
    //   6021: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6024: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6027: astore 24
    //   6029: aload 28
    //   6031: aload 27
    //   6033: aload 24
    //   6035: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6038: ldc_w 612
    //   6041: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6044: aload 31
    //   6046: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6049: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6052: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   6055: aload_0
    //   6056: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6059: ifnull +53 -> 6112
    //   6062: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6065: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6068: aload_0
    //   6069: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6072: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6075: if_icmpne +37 -> 6112
    //   6078: aload_0
    //   6079: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6082: ifnull +30 -> 6112
    //   6085: aload_0
    //   6086: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6089: aload_0
    //   6090: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6093: aload_0
    //   6094: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6097: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6100: aload_2
    //   6101: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6104: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6107: invokeinterface 685 4 0
    //   6112: aload_0
    //   6113: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6116: ifnull +53 -> 6169
    //   6119: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6122: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6125: aload_0
    //   6126: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6129: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6132: if_icmpne +37 -> 6169
    //   6135: aload_0
    //   6136: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6139: ifnull +30 -> 6169
    //   6142: aload_0
    //   6143: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6146: aload_0
    //   6147: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6150: aload_0
    //   6151: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6154: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6157: aload_2
    //   6158: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6161: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6164: invokeinterface 685 4 0
    //   6169: iload 10
    //   6171: ifeq +64 -> 6235
    //   6174: aload_0
    //   6175: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   6178: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   6181: astore 24
    //   6183: aload_0
    //   6184: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6187: astore 27
    //   6189: aload_0
    //   6190: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6193: ifeq +10675 -> 16868
    //   6196: aload_0
    //   6197: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6200: ifnull +10668 -> 16868
    //   6203: aload_0
    //   6204: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6207: ldc_w 687
    //   6210: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6213: ifeq +10655 -> 16868
    //   6216: iconst_1
    //   6217: istore 10
    //   6219: aload 24
    //   6221: aload 27
    //   6223: iload 10
    //   6225: aload_2
    //   6226: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6229: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6232: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   6235: aload 29
    //   6237: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   6240: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6243: aload 29
    //   6245: aload_0
    //   6246: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   6249: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6252: aload 29
    //   6254: aload 26
    //   6256: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   6259: aload 29
    //   6261: aload 25
    //   6263: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   6266: aload 29
    //   6268: iload 4
    //   6270: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6273: aload 29
    //   6275: aload 23
    //   6277: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6280: aload 30
    //   6282: ifnonnull +10592 -> 16874
    //   6285: aconst_null
    //   6286: astore 23
    //   6288: aload 29
    //   6290: aload 23
    //   6292: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6295: aload 29
    //   6297: aconst_null
    //   6298: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6301: aload 29
    //   6303: aload_2
    //   6304: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6307: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6310: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6313: aload 29
    //   6315: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   6318: aload_0
    //   6319: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   6322: lsub
    //   6323: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6326: aload 29
    //   6328: aload_2
    //   6329: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6332: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6335: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6338: aload 29
    //   6340: aload 29
    //   6342: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6345: aload_2
    //   6346: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6349: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6352: lsub
    //   6353: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6356: aload 29
    //   6358: lload 12
    //   6360: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6363: aload 29
    //   6365: aload_0
    //   6366: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   6369: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6372: aload 29
    //   6374: aload_0
    //   6375: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   6378: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6381: aload 29
    //   6383: aload_0
    //   6384: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   6387: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6390: aload 29
    //   6392: lconst_0
    //   6393: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6396: aload 29
    //   6398: aload_0
    //   6399: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   6402: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6405: aload 29
    //   6407: aload_2
    //   6408: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6411: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6414: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6417: aload 29
    //   6419: aload_0
    //   6420: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   6423: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   6426: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6429: aload 29
    //   6431: aload_0
    //   6432: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6435: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6438: aload_0
    //   6439: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6442: ifnull +10442 -> 16884
    //   6445: aload_0
    //   6446: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6449: ldc_w 687
    //   6452: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6455: ifeq +10429 -> 16884
    //   6458: iconst_1
    //   6459: istore 10
    //   6461: aload 29
    //   6463: iload 10
    //   6465: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   6468: aload 29
    //   6470: aload_2
    //   6471: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6474: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6477: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6480: aload 29
    //   6482: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   6485: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   6488: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   6491: aload 25
    //   6493: ifnull +24 -> 6517
    //   6496: aload 25
    //   6498: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6501: ifnull +16 -> 6517
    //   6504: aload 29
    //   6506: aload 25
    //   6508: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   6511: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   6514: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   6517: aload_2
    //   6518: aload 29
    //   6520: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6523: aload_2
    //   6524: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6527: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6530: ifeq +11 -> 6541
    //   6533: aload_0
    //   6534: aload_1
    //   6535: aload_2
    //   6536: aload 29
    //   6538: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6541: aload_0
    //   6542: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   6545: ifeq +10345 -> 16890
    //   6548: aload_0
    //   6549: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6552: ifnull +12 -> 6564
    //   6555: aload_0
    //   6556: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   6559: invokeinterface 792 1 0
    //   6564: aload_0
    //   6565: aconst_null
    //   6566: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   6569: aload 22
    //   6571: athrow
    //   6572: lload 12
    //   6574: lstore 14
    //   6576: lload 12
    //   6578: lstore 16
    //   6580: aload_0
    //   6581: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6584: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6587: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6590: istore 4
    //   6592: goto -1777 -> 4815
    //   6595: lload 12
    //   6597: lstore 14
    //   6599: aload 27
    //   6601: astore 22
    //   6603: lload 12
    //   6605: lstore 16
    //   6607: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   6610: iconst_3
    //   6611: if_icmpne -4113 -> 2498
    //   6614: lload 12
    //   6616: lstore 14
    //   6618: aload 27
    //   6620: astore 22
    //   6622: lload 12
    //   6624: lstore 16
    //   6626: aload_0
    //   6627: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6630: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6633: getstatic 274	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DOMAIN_FORCE	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6636: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6639: if_icmpeq -4141 -> 2498
    //   6642: lload 12
    //   6644: lstore 14
    //   6646: lload 12
    //   6648: lstore 16
    //   6650: aload_0
    //   6651: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6654: istore 4
    //   6656: iload 4
    //   6658: ifle +134 -> 6792
    //   6661: lload 12
    //   6663: lstore 14
    //   6665: lload 12
    //   6667: lstore 16
    //   6669: aload_0
    //   6670: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6673: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6676: iload 4
    //   6678: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6681: lload 12
    //   6683: lstore 14
    //   6685: lload 12
    //   6687: lstore 16
    //   6689: iload 4
    //   6691: istore 6
    //   6693: iload 4
    //   6695: invokestatic 202	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6698: ifne +7 -> 6705
    //   6701: bipush 80
    //   6703: istore 6
    //   6705: lload 12
    //   6707: lstore 14
    //   6709: lload 12
    //   6711: lstore 16
    //   6713: new 127	java/lang/StringBuilder
    //   6716: dup
    //   6717: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   6720: aload 23
    //   6722: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6725: ldc_w 837
    //   6728: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6731: iload 6
    //   6733: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6736: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6739: astore 23
    //   6741: lload 12
    //   6743: lstore 14
    //   6745: aload 23
    //   6747: astore 22
    //   6749: lload 12
    //   6751: lstore 16
    //   6753: aload_0
    //   6754: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6757: ifnull -4259 -> 2498
    //   6760: lload 12
    //   6762: lstore 14
    //   6764: lload 12
    //   6766: lstore 16
    //   6768: aload_0
    //   6769: aload_0
    //   6770: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6773: aload_0
    //   6774: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   6777: aload 23
    //   6779: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6782: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6785: aload 23
    //   6787: astore 22
    //   6789: goto -4291 -> 2498
    //   6792: lload 12
    //   6794: lstore 14
    //   6796: lload 12
    //   6798: lstore 16
    //   6800: aload_0
    //   6801: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6804: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6807: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6810: istore 4
    //   6812: goto -131 -> 6681
    //   6815: lload 12
    //   6817: lstore 14
    //   6819: lload 12
    //   6821: lstore 16
    //   6823: aload_0
    //   6824: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6827: ifnull -4221 -> 2606
    //   6830: lload 12
    //   6832: lstore 14
    //   6834: lload 12
    //   6836: lstore 16
    //   6838: aload_0
    //   6839: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6842: ldc_w 687
    //   6845: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6848: ifeq -4242 -> 2606
    //   6851: iload 5
    //   6853: ifeq -4247 -> 2606
    //   6856: iload 10
    //   6858: ifeq -4252 -> 2606
    //   6861: lload 12
    //   6863: lstore 14
    //   6865: lload 12
    //   6867: lstore 16
    //   6869: aload_0
    //   6870: aload_0
    //   6871: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6874: ldc_w 928
    //   6877: ldc_w 930
    //   6880: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6883: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   6886: lload 12
    //   6888: lstore 14
    //   6890: lload 12
    //   6892: lstore 16
    //   6894: aload_0
    //   6895: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:mOrigPort	I
    //   6898: istore 4
    //   6900: iload 4
    //   6902: ifle +231 -> 7133
    //   6905: lload 12
    //   6907: lstore 14
    //   6909: lload 12
    //   6911: lstore 16
    //   6913: aload_0
    //   6914: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6917: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6920: iload 4
    //   6922: putfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   6925: lload 12
    //   6927: lstore 14
    //   6929: lload 12
    //   6931: lstore 16
    //   6933: iload 4
    //   6935: istore 6
    //   6937: iload 4
    //   6939: invokestatic 202	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   6942: ifne +7 -> 6949
    //   6945: bipush 80
    //   6947: istore 6
    //   6949: lload 12
    //   6951: lstore 14
    //   6953: lload 12
    //   6955: lstore 16
    //   6957: new 127	java/lang/StringBuilder
    //   6960: dup
    //   6961: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   6964: ldc_w 924
    //   6967: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6970: ldc_w 932
    //   6973: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6976: ldc_w 926
    //   6979: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6982: iload 6
    //   6984: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6987: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6990: astore 22
    //   6992: lload 12
    //   6994: lstore 14
    //   6996: lload 12
    //   6998: lstore 16
    //   7000: aload_0
    //   7001: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   7004: ifnull +28 -> 7032
    //   7007: lload 12
    //   7009: lstore 14
    //   7011: lload 12
    //   7013: lstore 16
    //   7015: aload_0
    //   7016: aload_0
    //   7017: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7020: aload_0
    //   7021: getfield 839	com/tencent/component/network/downloader/impl/FastDownloadTask:mDomainWithPort	Ljava/lang/String;
    //   7024: aload 22
    //   7026: invokevirtual 843	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7029: putfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7032: lload 12
    //   7034: lstore 14
    //   7036: lload 12
    //   7038: lstore 16
    //   7040: aload 29
    //   7042: aload_0
    //   7043: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7046: invokevirtual 139	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   7049: putfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   7052: lload 12
    //   7054: lstore 14
    //   7056: lload 12
    //   7058: lstore 16
    //   7060: invokestatic 849	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   7063: ifeq -4457 -> 2606
    //   7066: lload 12
    //   7068: lstore 14
    //   7070: lload 12
    //   7072: lstore 16
    //   7074: ldc 221
    //   7076: new 127	java/lang/StringBuilder
    //   7079: dup
    //   7080: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   7083: ldc_w 851
    //   7086: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7089: aload 29
    //   7091: getfield 846	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   7094: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7097: ldc_w 934
    //   7100: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7103: aload_0
    //   7104: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7107: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7110: ldc 227
    //   7112: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7115: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7118: invokevirtual 176	java/lang/Thread:getId	()J
    //   7121: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7124: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7127: invokestatic 393	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   7130: goto -4524 -> 2606
    //   7133: lload 12
    //   7135: lstore 14
    //   7137: lload 12
    //   7139: lstore 16
    //   7141: aload_0
    //   7142: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7145: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   7148: getfield 835	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   7151: istore 4
    //   7153: goto -228 -> 6925
    //   7156: lload 12
    //   7158: lstore 14
    //   7160: lload 12
    //   7162: lstore 16
    //   7164: aload_0
    //   7165: aload_0
    //   7166: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7169: aload_0
    //   7170: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7173: aload_0
    //   7174: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   7177: aload_0
    //   7178: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7181: aload_0
    //   7182: getfield 819	com/tencent/component/network/downloader/impl/FastDownloadTask:mRefer	Ljava/lang/String;
    //   7185: aload 30
    //   7187: invokestatic 938	com/tencent/component/network/utils/http/HttpUtil:createHttpGet	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   7190: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   7193: goto -4477 -> 2716
    //   7196: lload 12
    //   7198: lstore 14
    //   7200: lload 12
    //   7202: lstore 16
    //   7204: aload_0
    //   7205: getfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7208: ifnull +9930 -> 17138
    //   7211: lload 12
    //   7213: lstore 14
    //   7215: lload 12
    //   7217: lstore 16
    //   7219: aload_0
    //   7220: aload_0
    //   7221: getfield 942	com/tencent/component/network/downloader/impl/FastDownloadTask:pokHttpClient	Lokhttp3/OkHttpClient;
    //   7224: aload_0
    //   7225: getfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   7228: invokevirtual 948	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   7231: invokevirtual 954	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   7234: putfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7237: lload 12
    //   7239: lstore 14
    //   7241: lload 12
    //   7243: lstore 16
    //   7245: aload_0
    //   7246: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   7249: invokeinterface 957 1 0
    //   7254: astore 22
    //   7256: aconst_null
    //   7257: astore 23
    //   7259: aconst_null
    //   7260: astore 24
    //   7262: goto -4314 -> 2948
    //   7265: aload 22
    //   7267: ifnull +9865 -> 17132
    //   7270: aload 22
    //   7272: invokevirtual 960	okhttp3/Response:code	()I
    //   7275: istore 4
    //   7277: goto -4280 -> 2997
    //   7280: aconst_null
    //   7281: astore 25
    //   7283: goto -4115 -> 3168
    //   7286: astore 24
    //   7288: ldc_w 429
    //   7291: astore 24
    //   7293: goto -4091 -> 3202
    //   7296: ldc_w 962
    //   7299: astore 26
    //   7301: goto -3924 -> 3377
    //   7304: aconst_null
    //   7305: astore 26
    //   7307: goto -3810 -> 3497
    //   7310: aload_0
    //   7311: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7314: astore 26
    //   7316: goto -3590 -> 3726
    //   7319: iconst_0
    //   7320: istore 5
    //   7322: goto -3565 -> 3757
    //   7325: aconst_null
    //   7326: astore 26
    //   7328: goto -3420 -> 3908
    //   7331: new 127	java/lang/StringBuilder
    //   7334: dup
    //   7335: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   7338: ldc_w 964
    //   7341: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7344: aload_0
    //   7345: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   7348: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7351: ldc_w 528
    //   7354: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7357: aload_0
    //   7358: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7361: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7364: ldc_w 533
    //   7367: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7370: astore 30
    //   7372: aload_0
    //   7373: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   7376: ifeq +560 -> 7936
    //   7379: aload 22
    //   7381: ifnull +555 -> 7936
    //   7384: aload 22
    //   7386: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7389: ifnull +547 -> 7936
    //   7392: aload 22
    //   7394: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   7397: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   7400: astore 26
    //   7402: aload 30
    //   7404: aload 26
    //   7406: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7409: ldc_w 544
    //   7412: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7415: aload 27
    //   7417: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7420: ldc_w 549
    //   7423: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7426: aload 25
    //   7428: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7431: ldc_w 551
    //   7434: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7437: aconst_null
    //   7438: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7441: ldc_w 553
    //   7444: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7447: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7450: invokevirtual 176	java/lang/Thread:getId	()J
    //   7453: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7456: ldc_w 555
    //   7459: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7462: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7465: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7468: ldc_w 557
    //   7471: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7474: aload_0
    //   7475: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7478: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7481: ldc_w 559
    //   7484: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7487: aload_0
    //   7488: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7491: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7494: ldc_w 561
    //   7497: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7500: astore 30
    //   7502: aload_0
    //   7503: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   7506: ifeq +438 -> 7944
    //   7509: aload_0
    //   7510: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   7513: aload_0
    //   7514: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   7517: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7520: astore 26
    //   7522: aload 30
    //   7524: aload 26
    //   7526: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7529: ldc_w 565
    //   7532: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7535: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   7538: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7541: ldc_w 577
    //   7544: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7547: aload_2
    //   7548: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7551: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   7554: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7557: ldc_w 582
    //   7560: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7563: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   7566: aload_0
    //   7567: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   7570: lsub
    //   7571: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7574: ldc_w 584
    //   7577: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7580: aload_2
    //   7581: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7584: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7587: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7590: ldc_w 589
    //   7593: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7596: aload_2
    //   7597: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7600: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7603: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7606: ldc_w 593
    //   7609: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7612: aload_2
    //   7613: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7616: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7619: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7622: ldc_w 598
    //   7625: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7628: aload_0
    //   7629: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   7632: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7635: ldc_w 600
    //   7638: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7641: aload_0
    //   7642: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   7645: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7648: ldc_w 966
    //   7651: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7654: iload 4
    //   7656: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7659: ldc_w 612
    //   7662: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7665: aload 28
    //   7667: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7670: ldc_w 572
    //   7673: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7676: aload_2
    //   7677: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7680: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7683: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7686: ldc_w 614
    //   7689: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7692: aload 24
    //   7694: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7697: ldc_w 616
    //   7700: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7703: astore 30
    //   7705: aload_0
    //   7706: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7709: ifnull +241 -> 7950
    //   7712: aload_0
    //   7713: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7716: iconst_0
    //   7717: bipush 30
    //   7719: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   7722: astore 26
    //   7724: aload 30
    //   7726: aload 26
    //   7728: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7731: ldc_w 622
    //   7734: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7737: astore 26
    //   7739: aload_0
    //   7740: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7743: ifnull +216 -> 7959
    //   7746: aload_0
    //   7747: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7750: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   7753: istore 5
    //   7755: aload 26
    //   7757: iload 5
    //   7759: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7762: ldc_w 624
    //   7765: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7768: aload_2
    //   7769: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7772: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7775: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7778: ldc_w 629
    //   7781: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7784: lload 12
    //   7786: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7789: ldc_w 631
    //   7792: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7795: aload_0
    //   7796: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   7799: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7802: ldc_w 600
    //   7805: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7808: aload_0
    //   7809: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   7812: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7815: ldc_w 633
    //   7818: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7821: aload_0
    //   7822: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   7825: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7828: ldc_w 600
    //   7831: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7834: aload_0
    //   7835: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   7838: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7841: ldc_w 635
    //   7844: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7847: aload_0
    //   7848: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   7851: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7854: ldc_w 637
    //   7857: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7860: aload_0
    //   7861: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   7864: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7867: ldc_w 642
    //   7870: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7873: aload_0
    //   7874: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   7877: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7880: ldc_w 647
    //   7883: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7886: astore 30
    //   7888: aload_0
    //   7889: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7892: ifnull +73 -> 7965
    //   7895: aload_0
    //   7896: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7899: invokeinterface 657 1 0
    //   7904: astore 26
    //   7906: aload 29
    //   7908: aload 30
    //   7910: aload 26
    //   7912: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7915: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7918: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7921: ldc_w 448
    //   7924: aload 29
    //   7926: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   7929: aconst_null
    //   7930: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7933: goto -3970 -> 3963
    //   7936: ldc_w 962
    //   7939: astore 26
    //   7941: goto -539 -> 7402
    //   7944: aconst_null
    //   7945: astore 26
    //   7947: goto -425 -> 7522
    //   7950: aload_0
    //   7951: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   7954: astore 26
    //   7956: goto -232 -> 7724
    //   7959: iconst_0
    //   7960: istore 5
    //   7962: goto -207 -> 7755
    //   7965: aconst_null
    //   7966: astore 26
    //   7968: goto -62 -> 7906
    //   7971: iconst_0
    //   7972: istore 5
    //   7974: goto -3930 -> 4044
    //   7977: ldc_w 429
    //   7980: astore 24
    //   7982: goto -3806 -> 4176
    //   7985: astore 24
    //   7987: ldc 221
    //   7989: ldc_w 971
    //   7992: aload 24
    //   7994: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7997: goto -3738 -> 4259
    //   8000: astore 24
    //   8002: ldc 221
    //   8004: ldc_w 973
    //   8007: aload 24
    //   8009: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8012: goto -3696 -> 4316
    //   8015: iconst_0
    //   8016: istore 10
    //   8018: goto -3652 -> 4366
    //   8021: aload 27
    //   8023: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8026: astore 23
    //   8028: goto -3594 -> 4434
    //   8031: iconst_0
    //   8032: istore 10
    //   8034: goto -3427 -> 4607
    //   8037: aload_0
    //   8038: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8041: ifnull +15 -> 8056
    //   8044: aload_0
    //   8045: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8048: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   8051: aload_0
    //   8052: aconst_null
    //   8053: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8056: aload_0
    //   8057: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   8060: goto -3345 -> 4715
    //   8063: aload_2
    //   8064: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8067: lload 18
    //   8069: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8072: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   8075: aload_2
    //   8076: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8079: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8082: aload_0
    //   8083: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8086: lsub
    //   8087: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   8090: aload_2
    //   8091: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8094: aload_0
    //   8095: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   8098: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   8101: aload_0
    //   8102: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8105: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   8108: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   8111: astore 27
    //   8113: aload_0
    //   8114: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8117: ifnull +1569 -> 9686
    //   8120: aload_0
    //   8121: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8124: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8127: ifnull +1559 -> 9686
    //   8130: aload_0
    //   8131: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8134: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   8137: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   8140: astore 25
    //   8142: aload_0
    //   8143: aload_0
    //   8144: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   8147: aload 23
    //   8149: aload 22
    //   8151: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   8154: astore 28
    //   8156: aload 24
    //   8158: ifnull +8958 -> 17116
    //   8161: aload 24
    //   8163: ldc_w 493
    //   8166: invokeinterface 499 2 0
    //   8171: checkcast 284	java/lang/String
    //   8174: astore 24
    //   8176: aload_2
    //   8177: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8180: aload 24
    //   8182: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   8185: aload_0
    //   8186: lconst_0
    //   8187: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8190: aload_0
    //   8191: iconst_0
    //   8192: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8195: aload_0
    //   8196: lconst_0
    //   8197: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8200: aload_0
    //   8201: iconst_0
    //   8202: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8205: aload_2
    //   8206: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8209: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8212: ifeq +12 -> 8224
    //   8215: aload_1
    //   8216: invokeinterface 360 1 0
    //   8221: ifeq +31 -> 8252
    //   8224: aload_0
    //   8225: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8228: ifnull +24 -> 8252
    //   8231: aload_0
    //   8232: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   8235: aload_0
    //   8236: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8239: aload_2
    //   8240: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   8243: aload 23
    //   8245: aload 22
    //   8247: invokeinterface 524 5 0
    //   8252: aload_1
    //   8253: invokeinterface 360 1 0
    //   8258: ifne +1399 -> 9657
    //   8261: aload_0
    //   8262: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8265: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   8268: istore 10
    //   8270: aload_2
    //   8271: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8274: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   8277: ifne +1459 -> 9736
    //   8280: new 127	java/lang/StringBuilder
    //   8283: dup
    //   8284: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   8287: ldc_w 526
    //   8290: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8293: aload_0
    //   8294: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8297: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8300: ldc_w 528
    //   8303: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8306: aload_0
    //   8307: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8310: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8313: ldc_w 533
    //   8316: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8319: astore 30
    //   8321: aload_0
    //   8322: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   8325: ifeq +1377 -> 9702
    //   8328: aload 22
    //   8330: ifnull +1372 -> 9702
    //   8333: aload 22
    //   8335: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8338: ifnull +1364 -> 9702
    //   8341: aload 22
    //   8343: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   8346: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   8349: astore 26
    //   8351: aload 30
    //   8353: aload 26
    //   8355: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8358: ldc_w 544
    //   8361: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8364: aload 27
    //   8366: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8369: ldc_w 549
    //   8372: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8375: aload 25
    //   8377: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8380: ldc_w 551
    //   8383: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8386: aconst_null
    //   8387: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8390: ldc_w 553
    //   8393: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8396: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8399: invokevirtual 176	java/lang/Thread:getId	()J
    //   8402: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8405: ldc_w 555
    //   8408: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8411: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8414: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8417: ldc_w 557
    //   8420: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8423: aload_0
    //   8424: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8427: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8430: ldc_w 559
    //   8433: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8436: aload_0
    //   8437: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8440: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8443: ldc_w 561
    //   8446: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8449: astore 30
    //   8451: aload_0
    //   8452: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   8455: ifeq +1255 -> 9710
    //   8458: aload_0
    //   8459: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   8462: aload_0
    //   8463: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   8466: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8469: astore 26
    //   8471: aload 30
    //   8473: aload 26
    //   8475: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8478: ldc_w 563
    //   8481: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8484: iload 10
    //   8486: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8489: ldc_w 565
    //   8492: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8495: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   8498: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8501: ldc_w 572
    //   8504: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8507: aload_2
    //   8508: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8511: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8514: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8517: ldc_w 577
    //   8520: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8523: aload_2
    //   8524: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8527: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   8530: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8533: ldc_w 582
    //   8536: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8539: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   8542: aload_0
    //   8543: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   8546: lsub
    //   8547: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8550: ldc_w 584
    //   8553: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8556: aload_2
    //   8557: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8560: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8563: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8566: ldc_w 589
    //   8569: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8572: aload_2
    //   8573: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8576: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8579: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8582: ldc_w 593
    //   8585: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8588: aload_2
    //   8589: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8592: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8595: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8598: ldc_w 598
    //   8601: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8604: aload_0
    //   8605: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   8608: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8611: ldc_w 600
    //   8614: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8617: aload_0
    //   8618: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   8621: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8624: ldc_w 605
    //   8627: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8630: aload_2
    //   8631: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8634: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   8637: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8640: ldc_w 610
    //   8643: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8646: iload 4
    //   8648: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8651: ldc_w 612
    //   8654: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8657: aload 28
    //   8659: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8662: ldc_w 614
    //   8665: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8668: aload 24
    //   8670: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8673: ldc_w 616
    //   8676: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8679: astore 30
    //   8681: aload_0
    //   8682: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8685: ifnull +1031 -> 9716
    //   8688: aload_0
    //   8689: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8692: iconst_0
    //   8693: bipush 30
    //   8695: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   8698: astore 26
    //   8700: aload 30
    //   8702: aload 26
    //   8704: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8707: ldc_w 622
    //   8710: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8713: astore 26
    //   8715: aload_0
    //   8716: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8719: ifnull +1006 -> 9725
    //   8722: aload_0
    //   8723: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8726: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   8729: istore_3
    //   8730: aload 26
    //   8732: iload_3
    //   8733: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8736: ldc_w 624
    //   8739: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8742: aload_2
    //   8743: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8746: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8749: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8752: ldc_w 629
    //   8755: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8758: lload 12
    //   8760: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8763: ldc_w 631
    //   8766: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8769: aload_0
    //   8770: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   8773: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8776: ldc_w 600
    //   8779: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8782: aload_0
    //   8783: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   8786: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8789: ldc_w 633
    //   8792: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8795: aload_0
    //   8796: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   8799: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8802: ldc_w 600
    //   8805: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8808: aload_0
    //   8809: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   8812: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8815: ldc_w 635
    //   8818: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8821: aload_0
    //   8822: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   8825: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8828: ldc_w 637
    //   8831: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8834: aload_0
    //   8835: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   8838: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8841: ldc_w 642
    //   8844: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8847: aload_0
    //   8848: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   8851: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8854: ldc_w 647
    //   8857: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8860: astore 30
    //   8862: aload_0
    //   8863: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8866: ifnull +864 -> 9730
    //   8869: aload_0
    //   8870: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8873: invokeinterface 657 1 0
    //   8878: astore 26
    //   8880: aload 29
    //   8882: aload 30
    //   8884: aload 26
    //   8886: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8889: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8892: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8895: ldc_w 448
    //   8898: aload 29
    //   8900: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8903: aconst_null
    //   8904: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8907: aload_0
    //   8908: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8911: ifnull +24 -> 8935
    //   8914: aload_0
    //   8915: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   8918: ldc_w 440
    //   8921: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8924: ifeq +11 -> 8935
    //   8927: aload_0
    //   8928: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   8931: iconst_0
    //   8932: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   8935: iload 10
    //   8937: ifne +8 -> 8945
    //   8940: aload_0
    //   8941: iconst_0
    //   8942: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   8945: aload_2
    //   8946: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   8949: astore 26
    //   8951: new 127	java/lang/StringBuilder
    //   8954: dup
    //   8955: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   8958: aload_0
    //   8959: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   8962: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8965: ldc_w 671
    //   8968: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8971: aload 25
    //   8973: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8976: ldc_w 673
    //   8979: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8982: aload_2
    //   8983: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8986: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8989: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8992: ldc_w 675
    //   8995: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8998: astore 25
    //   9000: aload_0
    //   9001: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9004: ifnull +1369 -> 10373
    //   9007: aload_0
    //   9008: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9011: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9014: istore_3
    //   9015: aload 25
    //   9017: iload_3
    //   9018: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9021: ldc_w 610
    //   9024: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9027: iload 4
    //   9029: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9032: ldc_w 572
    //   9035: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9038: aload_2
    //   9039: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9042: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9045: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9048: ldc_w 584
    //   9051: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9054: aload_2
    //   9055: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9058: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9061: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9064: ldc_w 589
    //   9067: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9070: aload_2
    //   9071: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9074: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9077: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9080: ldc_w 577
    //   9083: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9086: aload_2
    //   9087: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9090: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9093: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9096: ldc_w 582
    //   9099: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9102: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9105: aload_0
    //   9106: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9109: lsub
    //   9110: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9113: astore 25
    //   9115: aload 24
    //   9117: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9120: ifne +1258 -> 10378
    //   9123: new 127	java/lang/StringBuilder
    //   9126: dup
    //   9127: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   9130: ldc_w 614
    //   9133: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9136: aload 24
    //   9138: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9141: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9144: astore 24
    //   9146: aload 26
    //   9148: aload 25
    //   9150: aload 24
    //   9152: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9155: ldc_w 612
    //   9158: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9161: aload 28
    //   9163: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9166: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9169: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   9172: aload_0
    //   9173: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9176: ifnull +53 -> 9229
    //   9179: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9182: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9185: aload_0
    //   9186: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9189: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9192: if_icmpne +37 -> 9229
    //   9195: aload_0
    //   9196: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9199: ifnull +30 -> 9229
    //   9202: aload_0
    //   9203: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9206: aload_0
    //   9207: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9210: aload_0
    //   9211: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9214: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9217: aload_2
    //   9218: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9221: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9224: invokeinterface 685 4 0
    //   9229: aload_0
    //   9230: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9233: ifnull +53 -> 9286
    //   9236: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9239: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9242: aload_0
    //   9243: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9246: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   9249: if_icmpne +37 -> 9286
    //   9252: aload_0
    //   9253: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9256: ifnull +30 -> 9286
    //   9259: aload_0
    //   9260: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   9263: aload_0
    //   9264: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9267: aload_0
    //   9268: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9271: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   9274: aload_2
    //   9275: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9278: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9281: invokeinterface 685 4 0
    //   9286: iload 10
    //   9288: ifeq +64 -> 9352
    //   9291: aload_0
    //   9292: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9295: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   9298: astore 24
    //   9300: aload_0
    //   9301: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9304: astore 25
    //   9306: aload_0
    //   9307: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9310: ifeq +1106 -> 10416
    //   9313: aload_0
    //   9314: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9317: ifnull +1099 -> 10416
    //   9320: aload_0
    //   9321: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9324: ldc_w 687
    //   9327: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9330: ifeq +1086 -> 10416
    //   9333: iconst_1
    //   9334: istore 10
    //   9336: aload 24
    //   9338: aload 25
    //   9340: iload 10
    //   9342: aload_2
    //   9343: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9346: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9349: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   9352: aload 29
    //   9354: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   9357: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   9360: aload 29
    //   9362: aload_0
    //   9363: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   9366: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   9369: aload 29
    //   9371: aload 23
    //   9373: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   9376: aload 29
    //   9378: aload 22
    //   9380: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   9383: aload 29
    //   9385: iload 4
    //   9387: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   9390: aload 29
    //   9392: aconst_null
    //   9393: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   9396: aload 27
    //   9398: ifnonnull +1024 -> 10422
    //   9401: aconst_null
    //   9402: astore 23
    //   9404: aload 29
    //   9406: aload 23
    //   9408: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   9411: aload 29
    //   9413: aconst_null
    //   9414: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   9417: aload 29
    //   9419: aload_2
    //   9420: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9423: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9426: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   9429: aload 29
    //   9431: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9434: aload_0
    //   9435: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9438: lsub
    //   9439: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9442: aload 29
    //   9444: aload_2
    //   9445: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9448: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9451: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   9454: aload 29
    //   9456: aload 29
    //   9458: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   9461: aload_2
    //   9462: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9465: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9468: lsub
    //   9469: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   9472: aload 29
    //   9474: lload 12
    //   9476: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   9479: aload 29
    //   9481: aload_0
    //   9482: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   9485: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   9488: aload 29
    //   9490: aload_0
    //   9491: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   9494: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   9497: aload 29
    //   9499: aload_0
    //   9500: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   9503: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   9506: aload 29
    //   9508: lconst_0
    //   9509: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   9512: aload 29
    //   9514: aload_0
    //   9515: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   9518: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   9521: aload 29
    //   9523: aload_2
    //   9524: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9527: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9530: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   9533: aload 29
    //   9535: aload_0
    //   9536: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   9539: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   9542: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   9545: aload 29
    //   9547: aload_0
    //   9548: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9551: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   9554: aload_0
    //   9555: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9558: ifnull +874 -> 10432
    //   9561: aload_0
    //   9562: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9565: ldc_w 687
    //   9568: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9571: ifeq +861 -> 10432
    //   9574: iconst_1
    //   9575: istore 10
    //   9577: aload 29
    //   9579: iload 10
    //   9581: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   9584: aload 29
    //   9586: aload_2
    //   9587: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9590: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9593: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   9596: aload 29
    //   9598: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   9601: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   9604: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   9607: aload 22
    //   9609: ifnull +24 -> 9633
    //   9612: aload 22
    //   9614: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9617: ifnull +16 -> 9633
    //   9620: aload 29
    //   9622: aload 22
    //   9624: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9627: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9630: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   9633: aload_2
    //   9634: aload 29
    //   9636: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9639: aload_2
    //   9640: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9643: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9646: ifeq +11 -> 9657
    //   9649: aload_0
    //   9650: aload_1
    //   9651: aload_2
    //   9652: aload 29
    //   9654: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   9657: aload_0
    //   9658: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9661: ifeq +777 -> 10438
    //   9664: aload_0
    //   9665: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9668: ifnull +12 -> 9680
    //   9671: aload_0
    //   9672: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   9675: invokeinterface 792 1 0
    //   9680: aload_0
    //   9681: aconst_null
    //   9682: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   9685: return
    //   9686: aconst_null
    //   9687: astore 25
    //   9689: goto -1547 -> 8142
    //   9692: astore 24
    //   9694: ldc_w 429
    //   9697: astore 24
    //   9699: goto -1523 -> 8176
    //   9702: ldc_w 962
    //   9705: astore 26
    //   9707: goto -1356 -> 8351
    //   9710: aconst_null
    //   9711: astore 26
    //   9713: goto -1242 -> 8471
    //   9716: aload_0
    //   9717: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   9720: astore 26
    //   9722: goto -1022 -> 8700
    //   9725: iconst_0
    //   9726: istore_3
    //   9727: goto -997 -> 8730
    //   9730: aconst_null
    //   9731: astore 26
    //   9733: goto -853 -> 8880
    //   9736: new 127	java/lang/StringBuilder
    //   9739: dup
    //   9740: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   9743: ldc_w 964
    //   9746: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9749: aload_0
    //   9750: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   9753: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9756: ldc_w 528
    //   9759: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9762: aload_0
    //   9763: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9766: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9769: ldc_w 533
    //   9772: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9775: astore 30
    //   9777: aload_0
    //   9778: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   9781: ifeq +558 -> 10339
    //   9784: aload 22
    //   9786: ifnull +553 -> 10339
    //   9789: aload 22
    //   9791: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9794: ifnull +545 -> 10339
    //   9797: aload 22
    //   9799: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   9802: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   9805: astore 26
    //   9807: aload 30
    //   9809: aload 26
    //   9811: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9814: ldc_w 544
    //   9817: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9820: aload 27
    //   9822: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9825: ldc_w 549
    //   9828: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9831: aload 25
    //   9833: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9836: ldc_w 551
    //   9839: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9842: aconst_null
    //   9843: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9846: ldc_w 553
    //   9849: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9852: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9855: invokevirtual 176	java/lang/Thread:getId	()J
    //   9858: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9861: ldc_w 555
    //   9864: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9867: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9870: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9873: ldc_w 557
    //   9876: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9879: aload_0
    //   9880: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9883: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9886: ldc_w 559
    //   9889: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9892: aload_0
    //   9893: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9896: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9899: ldc_w 561
    //   9902: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9905: astore 30
    //   9907: aload_0
    //   9908: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   9911: ifeq +436 -> 10347
    //   9914: aload_0
    //   9915: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   9918: aload_0
    //   9919: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   9922: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9925: astore 26
    //   9927: aload 30
    //   9929: aload 26
    //   9931: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9934: ldc_w 565
    //   9937: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9940: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   9943: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9946: ldc_w 577
    //   9949: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9952: aload_2
    //   9953: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9956: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   9959: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9962: ldc_w 582
    //   9965: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9968: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   9971: aload_0
    //   9972: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   9975: lsub
    //   9976: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9979: ldc_w 584
    //   9982: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9985: aload_2
    //   9986: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9989: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9992: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9995: ldc_w 589
    //   9998: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10001: aload_2
    //   10002: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10005: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10008: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10011: ldc_w 593
    //   10014: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10017: aload_2
    //   10018: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10021: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10024: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10027: ldc_w 598
    //   10030: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10033: aload_0
    //   10034: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   10037: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10040: ldc_w 600
    //   10043: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10046: aload_0
    //   10047: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   10050: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10053: ldc_w 966
    //   10056: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10059: iload 4
    //   10061: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10064: ldc_w 612
    //   10067: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10070: aload 28
    //   10072: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10075: ldc_w 572
    //   10078: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10081: aload_2
    //   10082: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10085: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10088: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10091: ldc_w 614
    //   10094: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10097: aload 24
    //   10099: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10102: ldc_w 616
    //   10105: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10108: astore 30
    //   10110: aload_0
    //   10111: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10114: ifnull +239 -> 10353
    //   10117: aload_0
    //   10118: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10121: iconst_0
    //   10122: bipush 30
    //   10124: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   10127: astore 26
    //   10129: aload 30
    //   10131: aload 26
    //   10133: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10136: ldc_w 622
    //   10139: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10142: astore 26
    //   10144: aload_0
    //   10145: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10148: ifnull +214 -> 10362
    //   10151: aload_0
    //   10152: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10155: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   10158: istore_3
    //   10159: aload 26
    //   10161: iload_3
    //   10162: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10165: ldc_w 624
    //   10168: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10171: aload_2
    //   10172: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10175: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10178: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10181: ldc_w 629
    //   10184: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10187: lload 12
    //   10189: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10192: ldc_w 631
    //   10195: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10198: aload_0
    //   10199: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10202: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10205: ldc_w 600
    //   10208: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10211: aload_0
    //   10212: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10215: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10218: ldc_w 633
    //   10221: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10224: aload_0
    //   10225: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10228: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10231: ldc_w 600
    //   10234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10237: aload_0
    //   10238: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10241: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10244: ldc_w 635
    //   10247: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10250: aload_0
    //   10251: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   10254: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10257: ldc_w 637
    //   10260: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10263: aload_0
    //   10264: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   10267: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10270: ldc_w 642
    //   10273: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10276: aload_0
    //   10277: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   10280: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10283: ldc_w 647
    //   10286: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10289: astore 30
    //   10291: aload_0
    //   10292: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10295: ifnull +72 -> 10367
    //   10298: aload_0
    //   10299: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10302: invokeinterface 657 1 0
    //   10307: astore 26
    //   10309: aload 29
    //   10311: aload 30
    //   10313: aload 26
    //   10315: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10318: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10321: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10324: ldc_w 448
    //   10327: aload 29
    //   10329: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10332: aconst_null
    //   10333: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10336: goto -1401 -> 8935
    //   10339: ldc_w 962
    //   10342: astore 26
    //   10344: goto -537 -> 9807
    //   10347: aconst_null
    //   10348: astore 26
    //   10350: goto -423 -> 9927
    //   10353: aload_0
    //   10354: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   10357: astore 26
    //   10359: goto -230 -> 10129
    //   10362: iconst_0
    //   10363: istore_3
    //   10364: goto -205 -> 10159
    //   10367: aconst_null
    //   10368: astore 26
    //   10370: goto -61 -> 10309
    //   10373: iconst_0
    //   10374: istore_3
    //   10375: goto -1360 -> 9015
    //   10378: ldc_w 429
    //   10381: astore 24
    //   10383: goto -1237 -> 9146
    //   10386: astore 24
    //   10388: ldc 221
    //   10390: ldc_w 971
    //   10393: aload 24
    //   10395: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10398: goto -1169 -> 9229
    //   10401: astore 24
    //   10403: ldc 221
    //   10405: ldc_w 973
    //   10408: aload 24
    //   10410: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10413: goto -1127 -> 9286
    //   10416: iconst_0
    //   10417: istore 10
    //   10419: goto -1083 -> 9336
    //   10422: aload 27
    //   10424: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   10427: astore 23
    //   10429: goto -1025 -> 9404
    //   10432: iconst_0
    //   10433: istore 10
    //   10435: goto -858 -> 9577
    //   10438: aload_0
    //   10439: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10442: ifnull +15 -> 10457
    //   10445: aload_0
    //   10446: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10449: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   10452: aload_0
    //   10453: aconst_null
    //   10454: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10457: aload_0
    //   10458: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   10461: return
    //   10462: aload_2
    //   10463: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10466: lload 18
    //   10468: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10471: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   10474: aload_2
    //   10475: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10478: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10481: aload_0
    //   10482: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10485: lsub
    //   10486: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   10489: aload_2
    //   10490: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10493: aload_0
    //   10494: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   10497: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   10500: aload_0
    //   10501: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10504: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   10507: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   10510: astore 27
    //   10512: aload_0
    //   10513: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10516: ifnull +1569 -> 12085
    //   10519: aload_0
    //   10520: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10523: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10526: ifnull +1559 -> 12085
    //   10529: aload_0
    //   10530: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10533: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   10536: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   10539: astore 25
    //   10541: aload_0
    //   10542: aload_0
    //   10543: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   10546: aload 23
    //   10548: aload 22
    //   10550: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   10553: astore 28
    //   10555: aload 24
    //   10557: ifnull +6551 -> 17108
    //   10560: aload 24
    //   10562: ldc_w 493
    //   10565: invokeinterface 499 2 0
    //   10570: checkcast 284	java/lang/String
    //   10573: astore 24
    //   10575: aload_2
    //   10576: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10579: aload 24
    //   10581: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   10584: aload_0
    //   10585: lconst_0
    //   10586: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   10589: aload_0
    //   10590: iconst_0
    //   10591: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   10594: aload_0
    //   10595: lconst_0
    //   10596: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   10599: aload_0
    //   10600: iconst_0
    //   10601: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   10604: aload_2
    //   10605: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10608: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10611: ifeq +12 -> 10623
    //   10614: aload_1
    //   10615: invokeinterface 360 1 0
    //   10620: ifeq +31 -> 10651
    //   10623: aload_0
    //   10624: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10627: ifnull +24 -> 10651
    //   10630: aload_0
    //   10631: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10634: aload_0
    //   10635: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10638: aload_2
    //   10639: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10642: aload 23
    //   10644: aload 22
    //   10646: invokeinterface 524 5 0
    //   10651: aload_1
    //   10652: invokeinterface 360 1 0
    //   10657: ifne +1399 -> 12056
    //   10660: aload_0
    //   10661: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10664: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10667: istore 10
    //   10669: aload_2
    //   10670: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10673: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10676: ifne +1459 -> 12135
    //   10679: new 127	java/lang/StringBuilder
    //   10682: dup
    //   10683: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   10686: ldc_w 526
    //   10689: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10692: aload_0
    //   10693: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   10696: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10699: ldc_w 528
    //   10702: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: aload_0
    //   10706: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10709: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10712: ldc_w 533
    //   10715: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10718: astore 30
    //   10720: aload_0
    //   10721: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   10724: ifeq +1377 -> 12101
    //   10727: aload 22
    //   10729: ifnull +1372 -> 12101
    //   10732: aload 22
    //   10734: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10737: ifnull +1364 -> 12101
    //   10740: aload 22
    //   10742: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   10745: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   10748: astore 26
    //   10750: aload 30
    //   10752: aload 26
    //   10754: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10757: ldc_w 544
    //   10760: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10763: aload 27
    //   10765: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10768: ldc_w 549
    //   10771: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10774: aload 25
    //   10776: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10779: ldc_w 551
    //   10782: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10785: aconst_null
    //   10786: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10789: ldc_w 553
    //   10792: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10795: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10798: invokevirtual 176	java/lang/Thread:getId	()J
    //   10801: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10804: ldc_w 555
    //   10807: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10810: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10813: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10816: ldc_w 557
    //   10819: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10822: aload_0
    //   10823: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10826: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10829: ldc_w 559
    //   10832: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10835: aload_0
    //   10836: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10839: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10842: ldc_w 561
    //   10845: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10848: astore 30
    //   10850: aload_0
    //   10851: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   10854: ifeq +1255 -> 12109
    //   10857: aload_0
    //   10858: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   10861: aload_0
    //   10862: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   10865: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10868: astore 26
    //   10870: aload 30
    //   10872: aload 26
    //   10874: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10877: ldc_w 563
    //   10880: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10883: iload 10
    //   10885: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10888: ldc_w 565
    //   10891: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10894: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   10897: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10900: ldc_w 572
    //   10903: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10906: aload_2
    //   10907: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10910: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10913: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10916: ldc_w 577
    //   10919: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10922: aload_2
    //   10923: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10926: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   10929: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10932: ldc_w 582
    //   10935: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10938: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   10941: aload_0
    //   10942: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   10945: lsub
    //   10946: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10949: ldc_w 584
    //   10952: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10955: aload_2
    //   10956: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10959: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10962: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10965: ldc_w 589
    //   10968: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10971: aload_2
    //   10972: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10975: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10978: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10981: ldc_w 593
    //   10984: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10987: aload_2
    //   10988: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10991: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10994: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10997: ldc_w 598
    //   11000: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11003: aload_0
    //   11004: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   11007: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11010: ldc_w 600
    //   11013: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11016: aload_0
    //   11017: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   11020: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11023: ldc_w 605
    //   11026: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11029: aload_2
    //   11030: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11033: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   11036: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11039: ldc_w 610
    //   11042: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11045: iload 4
    //   11047: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11050: ldc_w 612
    //   11053: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11056: aload 28
    //   11058: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11061: ldc_w 614
    //   11064: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11067: aload 24
    //   11069: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11072: ldc_w 616
    //   11075: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11078: astore 30
    //   11080: aload_0
    //   11081: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11084: ifnull +1031 -> 12115
    //   11087: aload_0
    //   11088: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11091: iconst_0
    //   11092: bipush 30
    //   11094: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   11097: astore 26
    //   11099: aload 30
    //   11101: aload 26
    //   11103: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11106: ldc_w 622
    //   11109: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11112: astore 26
    //   11114: aload_0
    //   11115: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11118: ifnull +1006 -> 12124
    //   11121: aload_0
    //   11122: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11125: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11128: istore_3
    //   11129: aload 26
    //   11131: iload_3
    //   11132: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11135: ldc_w 624
    //   11138: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11141: aload_2
    //   11142: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11145: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11148: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11151: ldc_w 629
    //   11154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11157: lload 12
    //   11159: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11162: ldc_w 631
    //   11165: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11168: aload_0
    //   11169: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11172: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11175: ldc_w 600
    //   11178: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11181: aload_0
    //   11182: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   11185: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11188: ldc_w 633
    //   11191: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11194: aload_0
    //   11195: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   11198: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11201: ldc_w 600
    //   11204: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11207: aload_0
    //   11208: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   11211: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11214: ldc_w 635
    //   11217: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11220: aload_0
    //   11221: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11224: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11227: ldc_w 637
    //   11230: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11233: aload_0
    //   11234: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11237: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11240: ldc_w 642
    //   11243: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11246: aload_0
    //   11247: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11250: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11253: ldc_w 647
    //   11256: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11259: astore 30
    //   11261: aload_0
    //   11262: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11265: ifnull +864 -> 12129
    //   11268: aload_0
    //   11269: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11272: invokeinterface 657 1 0
    //   11277: astore 26
    //   11279: aload 29
    //   11281: aload 30
    //   11283: aload 26
    //   11285: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11288: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11291: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11294: ldc_w 448
    //   11297: aload 29
    //   11299: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11302: aconst_null
    //   11303: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11306: aload_0
    //   11307: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11310: ifnull +24 -> 11334
    //   11313: aload_0
    //   11314: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11317: ldc_w 440
    //   11320: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11323: ifeq +11 -> 11334
    //   11326: aload_0
    //   11327: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11330: iconst_0
    //   11331: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   11334: iload 10
    //   11336: ifne +8 -> 11344
    //   11339: aload_0
    //   11340: iconst_0
    //   11341: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   11344: aload_2
    //   11345: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11348: astore 26
    //   11350: new 127	java/lang/StringBuilder
    //   11353: dup
    //   11354: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   11357: aload_0
    //   11358: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   11361: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11364: ldc_w 671
    //   11367: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11370: aload 25
    //   11372: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11375: ldc_w 673
    //   11378: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11381: aload_2
    //   11382: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11385: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11388: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11391: ldc_w 675
    //   11394: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11397: astore 25
    //   11399: aload_0
    //   11400: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11403: ifnull +1369 -> 12772
    //   11406: aload_0
    //   11407: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11410: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11413: istore_3
    //   11414: aload 25
    //   11416: iload_3
    //   11417: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11420: ldc_w 610
    //   11423: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11426: iload 4
    //   11428: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11431: ldc_w 572
    //   11434: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11437: aload_2
    //   11438: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11441: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11444: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11447: ldc_w 584
    //   11450: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11453: aload_2
    //   11454: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11457: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11460: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11463: ldc_w 589
    //   11466: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11469: aload_2
    //   11470: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11473: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11476: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11479: ldc_w 577
    //   11482: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11485: aload_2
    //   11486: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11489: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11492: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11495: ldc_w 582
    //   11498: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11501: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11504: aload_0
    //   11505: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11508: lsub
    //   11509: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11512: astore 25
    //   11514: aload 24
    //   11516: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11519: ifne +1258 -> 12777
    //   11522: new 127	java/lang/StringBuilder
    //   11525: dup
    //   11526: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   11529: ldc_w 614
    //   11532: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11535: aload 24
    //   11537: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11540: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11543: astore 24
    //   11545: aload 26
    //   11547: aload 25
    //   11549: aload 24
    //   11551: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11554: ldc_w 612
    //   11557: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11560: aload 28
    //   11562: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11565: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11568: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   11571: aload_0
    //   11572: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11575: ifnull +53 -> 11628
    //   11578: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11581: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11584: aload_0
    //   11585: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11588: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11591: if_icmpne +37 -> 11628
    //   11594: aload_0
    //   11595: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11598: ifnull +30 -> 11628
    //   11601: aload_0
    //   11602: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11605: aload_0
    //   11606: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11609: aload_0
    //   11610: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11613: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11616: aload_2
    //   11617: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11620: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11623: invokeinterface 685 4 0
    //   11628: aload_0
    //   11629: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11632: ifnull +53 -> 11685
    //   11635: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11638: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11641: aload_0
    //   11642: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11645: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   11648: if_icmpne +37 -> 11685
    //   11651: aload_0
    //   11652: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11655: ifnull +30 -> 11685
    //   11658: aload_0
    //   11659: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11662: aload_0
    //   11663: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11666: aload_0
    //   11667: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11670: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11673: aload_2
    //   11674: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11677: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11680: invokeinterface 685 4 0
    //   11685: iload 10
    //   11687: ifeq +64 -> 11751
    //   11690: aload_0
    //   11691: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   11694: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11697: astore 24
    //   11699: aload_0
    //   11700: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11703: astore 25
    //   11705: aload_0
    //   11706: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11709: ifeq +1106 -> 12815
    //   11712: aload_0
    //   11713: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11716: ifnull +1099 -> 12815
    //   11719: aload_0
    //   11720: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11723: ldc_w 687
    //   11726: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11729: ifeq +1086 -> 12815
    //   11732: iconst_1
    //   11733: istore 10
    //   11735: aload 24
    //   11737: aload 25
    //   11739: iload 10
    //   11741: aload_2
    //   11742: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11745: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11748: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   11751: aload 29
    //   11753: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   11756: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11759: aload 29
    //   11761: aload_0
    //   11762: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   11765: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11768: aload 29
    //   11770: aload 23
    //   11772: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11775: aload 29
    //   11777: aload 22
    //   11779: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   11782: aload 29
    //   11784: iload 4
    //   11786: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11789: aload 29
    //   11791: aconst_null
    //   11792: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11795: aload 27
    //   11797: ifnonnull +1024 -> 12821
    //   11800: aconst_null
    //   11801: astore 23
    //   11803: aload 29
    //   11805: aload 23
    //   11807: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11810: aload 29
    //   11812: aconst_null
    //   11813: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11816: aload 29
    //   11818: aload_2
    //   11819: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11822: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11825: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11828: aload 29
    //   11830: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   11833: aload_0
    //   11834: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   11837: lsub
    //   11838: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11841: aload 29
    //   11843: aload_2
    //   11844: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11847: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11850: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11853: aload 29
    //   11855: aload 29
    //   11857: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11860: aload_2
    //   11861: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11864: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   11867: lsub
    //   11868: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11871: aload 29
    //   11873: lload 12
    //   11875: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11878: aload 29
    //   11880: aload_0
    //   11881: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   11884: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11887: aload 29
    //   11889: aload_0
    //   11890: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   11893: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11896: aload 29
    //   11898: aload_0
    //   11899: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   11902: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11905: aload 29
    //   11907: lconst_0
    //   11908: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11911: aload 29
    //   11913: aload_0
    //   11914: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   11917: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11920: aload 29
    //   11922: aload_2
    //   11923: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11926: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11929: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11932: aload 29
    //   11934: aload_0
    //   11935: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   11938: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   11941: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11944: aload 29
    //   11946: aload_0
    //   11947: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   11950: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11953: aload_0
    //   11954: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11957: ifnull +874 -> 12831
    //   11960: aload_0
    //   11961: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   11964: ldc_w 687
    //   11967: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11970: ifeq +861 -> 12831
    //   11973: iconst_1
    //   11974: istore 10
    //   11976: aload 29
    //   11978: iload 10
    //   11980: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   11983: aload 29
    //   11985: aload_2
    //   11986: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11989: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11992: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11995: aload 29
    //   11997: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   12000: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   12003: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   12006: aload 22
    //   12008: ifnull +24 -> 12032
    //   12011: aload 22
    //   12013: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12016: ifnull +16 -> 12032
    //   12019: aload 29
    //   12021: aload 22
    //   12023: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12026: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12029: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   12032: aload_2
    //   12033: aload 29
    //   12035: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   12038: aload_2
    //   12039: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12042: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12045: ifeq +11 -> 12056
    //   12048: aload_0
    //   12049: aload_1
    //   12050: aload_2
    //   12051: aload 29
    //   12053: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   12056: aload_0
    //   12057: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12060: ifeq +777 -> 12837
    //   12063: aload_0
    //   12064: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   12067: ifnull +12 -> 12079
    //   12070: aload_0
    //   12071: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   12074: invokeinterface 792 1 0
    //   12079: aload_0
    //   12080: aconst_null
    //   12081: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   12084: return
    //   12085: aconst_null
    //   12086: astore 25
    //   12088: goto -1547 -> 10541
    //   12091: astore 24
    //   12093: ldc_w 429
    //   12096: astore 24
    //   12098: goto -1523 -> 10575
    //   12101: ldc_w 962
    //   12104: astore 26
    //   12106: goto -1356 -> 10750
    //   12109: aconst_null
    //   12110: astore 26
    //   12112: goto -1242 -> 10870
    //   12115: aload_0
    //   12116: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12119: astore 26
    //   12121: goto -1022 -> 11099
    //   12124: iconst_0
    //   12125: istore_3
    //   12126: goto -997 -> 11129
    //   12129: aconst_null
    //   12130: astore 26
    //   12132: goto -853 -> 11279
    //   12135: new 127	java/lang/StringBuilder
    //   12138: dup
    //   12139: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   12142: ldc_w 964
    //   12145: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12148: aload_0
    //   12149: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12152: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12155: ldc_w 528
    //   12158: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12161: aload_0
    //   12162: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12165: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12168: ldc_w 533
    //   12171: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12174: astore 30
    //   12176: aload_0
    //   12177: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   12180: ifeq +558 -> 12738
    //   12183: aload 22
    //   12185: ifnull +553 -> 12738
    //   12188: aload 22
    //   12190: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12193: ifnull +545 -> 12738
    //   12196: aload 22
    //   12198: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   12201: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   12204: astore 26
    //   12206: aload 30
    //   12208: aload 26
    //   12210: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12213: ldc_w 544
    //   12216: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: aload 27
    //   12221: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12224: ldc_w 549
    //   12227: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12230: aload 25
    //   12232: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12235: ldc_w 551
    //   12238: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12241: aconst_null
    //   12242: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12245: ldc_w 553
    //   12248: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12251: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12254: invokevirtual 176	java/lang/Thread:getId	()J
    //   12257: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12260: ldc_w 555
    //   12263: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12266: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12269: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12272: ldc_w 557
    //   12275: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12278: aload_0
    //   12279: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12282: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12285: ldc_w 559
    //   12288: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12291: aload_0
    //   12292: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12295: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12298: ldc_w 561
    //   12301: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12304: astore 30
    //   12306: aload_0
    //   12307: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   12310: ifeq +436 -> 12746
    //   12313: aload_0
    //   12314: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12317: aload_0
    //   12318: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   12321: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12324: astore 26
    //   12326: aload 30
    //   12328: aload 26
    //   12330: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12333: ldc_w 565
    //   12336: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12339: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   12342: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12345: ldc_w 577
    //   12348: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12351: aload_2
    //   12352: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12355: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   12358: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12361: ldc_w 582
    //   12364: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12367: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12370: aload_0
    //   12371: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12374: lsub
    //   12375: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12378: ldc_w 584
    //   12381: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12384: aload_2
    //   12385: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12388: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12391: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12394: ldc_w 589
    //   12397: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12400: aload_2
    //   12401: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12404: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12407: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12410: ldc_w 593
    //   12413: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12416: aload_2
    //   12417: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12420: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12423: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12426: ldc_w 598
    //   12429: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12432: aload_0
    //   12433: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   12436: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12439: ldc_w 600
    //   12442: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12445: aload_0
    //   12446: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   12449: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12452: ldc_w 966
    //   12455: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12458: iload 4
    //   12460: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12463: ldc_w 612
    //   12466: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12469: aload 28
    //   12471: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12474: ldc_w 572
    //   12477: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12480: aload_2
    //   12481: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12484: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12487: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12490: ldc_w 614
    //   12493: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12496: aload 24
    //   12498: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12501: ldc_w 616
    //   12504: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12507: astore 30
    //   12509: aload_0
    //   12510: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12513: ifnull +239 -> 12752
    //   12516: aload_0
    //   12517: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12520: iconst_0
    //   12521: bipush 30
    //   12523: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   12526: astore 26
    //   12528: aload 30
    //   12530: aload 26
    //   12532: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12535: ldc_w 622
    //   12538: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12541: astore 26
    //   12543: aload_0
    //   12544: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12547: ifnull +214 -> 12761
    //   12550: aload_0
    //   12551: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12554: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   12557: istore_3
    //   12558: aload 26
    //   12560: iload_3
    //   12561: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12564: ldc_w 624
    //   12567: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12570: aload_2
    //   12571: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12574: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12577: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12580: ldc_w 629
    //   12583: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12586: lload 12
    //   12588: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12591: ldc_w 631
    //   12594: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12597: aload_0
    //   12598: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   12601: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12604: ldc_w 600
    //   12607: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12610: aload_0
    //   12611: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   12614: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12617: ldc_w 633
    //   12620: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12623: aload_0
    //   12624: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   12627: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12630: ldc_w 600
    //   12633: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12636: aload_0
    //   12637: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   12640: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12643: ldc_w 635
    //   12646: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12649: aload_0
    //   12650: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   12653: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12656: ldc_w 637
    //   12659: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12662: aload_0
    //   12663: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   12666: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12669: ldc_w 642
    //   12672: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12675: aload_0
    //   12676: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   12679: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12682: ldc_w 647
    //   12685: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12688: astore 30
    //   12690: aload_0
    //   12691: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12694: ifnull +72 -> 12766
    //   12697: aload_0
    //   12698: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12701: invokeinterface 657 1 0
    //   12706: astore 26
    //   12708: aload 29
    //   12710: aload 30
    //   12712: aload 26
    //   12714: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12717: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12720: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12723: ldc_w 448
    //   12726: aload 29
    //   12728: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12731: aconst_null
    //   12732: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12735: goto -1401 -> 11334
    //   12738: ldc_w 962
    //   12741: astore 26
    //   12743: goto -537 -> 12206
    //   12746: aconst_null
    //   12747: astore 26
    //   12749: goto -423 -> 12326
    //   12752: aload_0
    //   12753: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   12756: astore 26
    //   12758: goto -230 -> 12528
    //   12761: iconst_0
    //   12762: istore_3
    //   12763: goto -205 -> 12558
    //   12766: aconst_null
    //   12767: astore 26
    //   12769: goto -61 -> 12708
    //   12772: iconst_0
    //   12773: istore_3
    //   12774: goto -1360 -> 11414
    //   12777: ldc_w 429
    //   12780: astore 24
    //   12782: goto -1237 -> 11545
    //   12785: astore 24
    //   12787: ldc 221
    //   12789: ldc_w 971
    //   12792: aload 24
    //   12794: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12797: goto -1169 -> 11628
    //   12800: astore 24
    //   12802: ldc 221
    //   12804: ldc_w 973
    //   12807: aload 24
    //   12809: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12812: goto -1127 -> 11685
    //   12815: iconst_0
    //   12816: istore 10
    //   12818: goto -1083 -> 11735
    //   12821: aload 27
    //   12823: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12826: astore 23
    //   12828: goto -1025 -> 11803
    //   12831: iconst_0
    //   12832: istore 10
    //   12834: goto -858 -> 11976
    //   12837: aload_0
    //   12838: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12841: ifnull +15 -> 12856
    //   12844: aload_0
    //   12845: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12848: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   12851: aload_0
    //   12852: aconst_null
    //   12853: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12856: aload_0
    //   12857: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   12860: return
    //   12861: sipush 416
    //   12864: iload 4
    //   12866: if_icmpne +1681 -> 14547
    //   12869: aload_0
    //   12870: ldc_w 986
    //   12873: invokevirtual 989	com/tencent/component/network/downloader/impl/FastDownloadTask:removeHttpParam	(Ljava/lang/String;)V
    //   12876: aload_2
    //   12877: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12880: bipush 7
    //   12882: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   12885: iload 4
    //   12887: istore 5
    //   12889: aload_0
    //   12890: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12893: ifnull +21 -> 12914
    //   12896: aload_0
    //   12897: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12900: aload_0
    //   12901: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   12904: iconst_1
    //   12905: invokeinterface 992 3 0
    //   12910: iload 4
    //   12912: istore 5
    //   12914: aload_2
    //   12915: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12918: lload 18
    //   12920: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12923: invokevirtual 462	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   12926: aload_2
    //   12927: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12930: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   12933: aload_0
    //   12934: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   12937: lsub
    //   12938: putfield 465	com/tencent/component/network/downloader/DownloadResult$Process:totalDuration	J
    //   12941: aload_2
    //   12942: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12945: aload_0
    //   12946: getfield 468	com/tencent/component/network/downloader/impl/FastDownloadTask:mTaskStartTimeStamp	J
    //   12949: putfield 471	com/tencent/component/network/downloader/DownloadResult$Process:startTimestamp	J
    //   12952: aload_0
    //   12953: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   12956: invokestatic 476	com/tencent/component/network/module/common/NetworkStatus:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12959: invokevirtual 480	com/tencent/component/network/module/common/NetworkStatus:getDNS	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12962: astore 27
    //   12964: aload_0
    //   12965: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12968: ifnull +1609 -> 14577
    //   12971: aload_0
    //   12972: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12975: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12978: ifnull +1599 -> 14577
    //   12981: aload_0
    //   12982: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12985: invokevirtual 484	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12988: getfield 487	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   12991: astore 25
    //   12993: aload_0
    //   12994: aload_0
    //   12995: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   12998: aload 23
    //   13000: aload 22
    //   13002: invokevirtual 491	com/tencent/component/network/downloader/impl/FastDownloadTask:parserHttpHeaderInfo	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lokhttp3/Response;)Ljava/lang/String;
    //   13005: astore 28
    //   13007: aload 24
    //   13009: ifnull +4091 -> 17100
    //   13012: aload 24
    //   13014: ldc_w 493
    //   13017: invokeinterface 499 2 0
    //   13022: checkcast 284	java/lang/String
    //   13025: astore 24
    //   13027: aload_2
    //   13028: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13031: aload 24
    //   13033: putfield 508	com/tencent/component/network/downloader/DownloadResult$Content:redirectUrl	Ljava/lang/String;
    //   13036: aload_0
    //   13037: lconst_0
    //   13038: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13041: aload_0
    //   13042: iconst_0
    //   13043: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13046: aload_0
    //   13047: lconst_0
    //   13048: putfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13051: aload_0
    //   13052: iconst_0
    //   13053: putfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13056: aload_2
    //   13057: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13060: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13063: ifeq +12 -> 13075
    //   13066: aload_1
    //   13067: invokeinterface 360 1 0
    //   13072: ifeq +31 -> 13103
    //   13075: aload_0
    //   13076: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   13079: ifnull +24 -> 13103
    //   13082: aload_0
    //   13083: getfield 515	com/tencent/component/network/downloader/impl/FastDownloadTask:pResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   13086: aload_0
    //   13087: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13090: aload_2
    //   13091: invokevirtual 518	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   13094: aload 23
    //   13096: aload 22
    //   13098: invokeinterface 524 5 0
    //   13103: aload_1
    //   13104: invokeinterface 360 1 0
    //   13109: ifne +1403 -> 14512
    //   13112: aload_0
    //   13113: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13116: invokestatic 368	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   13119: istore 10
    //   13121: aload_2
    //   13122: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13125: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13128: ifne +1500 -> 14628
    //   13131: new 127	java/lang/StringBuilder
    //   13134: dup
    //   13135: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   13138: ldc_w 526
    //   13141: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13144: aload_0
    //   13145: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13148: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13151: ldc_w 528
    //   13154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13157: aload_0
    //   13158: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13161: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13164: ldc_w 533
    //   13167: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13170: astore 30
    //   13172: aload_0
    //   13173: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   13176: ifeq +1417 -> 14593
    //   13179: aload 22
    //   13181: ifnull +1412 -> 14593
    //   13184: aload 22
    //   13186: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13189: ifnull +1404 -> 14593
    //   13192: aload 22
    //   13194: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   13197: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   13200: astore 26
    //   13202: aload 30
    //   13204: aload 26
    //   13206: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13209: ldc_w 544
    //   13212: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13215: aload 27
    //   13217: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13220: ldc_w 549
    //   13223: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13226: aload 25
    //   13228: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13231: ldc_w 551
    //   13234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13237: aconst_null
    //   13238: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13241: ldc_w 553
    //   13244: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13247: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13250: invokevirtual 176	java/lang/Thread:getId	()J
    //   13253: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13256: ldc_w 555
    //   13259: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13262: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   13265: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13268: ldc_w 557
    //   13271: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13274: aload_0
    //   13275: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13278: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13281: ldc_w 559
    //   13284: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13287: aload_0
    //   13288: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13291: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13294: ldc_w 561
    //   13297: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13300: astore 30
    //   13302: aload_0
    //   13303: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   13306: ifeq +1295 -> 14601
    //   13309: aload_0
    //   13310: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   13313: aload_0
    //   13314: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   13317: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13320: astore 26
    //   13322: aload 30
    //   13324: aload 26
    //   13326: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13329: ldc_w 563
    //   13332: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13335: iload 10
    //   13337: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13340: ldc_w 565
    //   13343: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13346: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   13349: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13352: ldc_w 572
    //   13355: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13358: aload_2
    //   13359: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13362: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13365: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13368: ldc_w 577
    //   13371: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13374: aload_2
    //   13375: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13378: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13381: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13384: ldc_w 582
    //   13387: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13390: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13393: aload_0
    //   13394: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13397: lsub
    //   13398: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13401: ldc_w 584
    //   13404: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13407: aload_2
    //   13408: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13411: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13414: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13417: ldc_w 589
    //   13420: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13423: aload_2
    //   13424: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13427: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13430: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13433: ldc_w 593
    //   13436: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13439: aload_2
    //   13440: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13443: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13446: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13449: ldc_w 598
    //   13452: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13455: aload_0
    //   13456: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   13459: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13462: ldc_w 600
    //   13465: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13468: aload_0
    //   13469: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   13472: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13475: ldc_w 605
    //   13478: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13481: aload_2
    //   13482: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13485: invokevirtual 608	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   13488: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13491: ldc_w 610
    //   13494: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13497: iload 5
    //   13499: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13502: ldc_w 612
    //   13505: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13508: aload 28
    //   13510: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13513: ldc_w 614
    //   13516: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13519: aload 24
    //   13521: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13524: ldc_w 616
    //   13527: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13530: astore 30
    //   13532: aload_0
    //   13533: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13536: ifnull +1071 -> 14607
    //   13539: aload_0
    //   13540: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13543: iconst_0
    //   13544: bipush 30
    //   13546: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   13549: astore 26
    //   13551: aload 30
    //   13553: aload 26
    //   13555: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13558: ldc_w 622
    //   13561: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13564: astore 26
    //   13566: aload_0
    //   13567: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13570: ifnull +1046 -> 14616
    //   13573: aload_0
    //   13574: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13577: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13580: istore 4
    //   13582: aload 26
    //   13584: iload 4
    //   13586: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13589: ldc_w 624
    //   13592: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13595: aload_2
    //   13596: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13599: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13602: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13605: ldc_w 629
    //   13608: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13611: lload 12
    //   13613: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13616: ldc_w 631
    //   13619: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13622: aload_0
    //   13623: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   13626: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13629: ldc_w 600
    //   13632: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13635: aload_0
    //   13636: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   13639: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13642: ldc_w 633
    //   13645: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13648: aload_0
    //   13649: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   13652: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13655: ldc_w 600
    //   13658: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13661: aload_0
    //   13662: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   13665: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13668: ldc_w 635
    //   13671: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13674: aload_0
    //   13675: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   13678: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13681: ldc_w 637
    //   13684: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13687: aload_0
    //   13688: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   13691: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13694: ldc_w 642
    //   13697: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13700: aload_0
    //   13701: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   13704: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13707: ldc_w 647
    //   13710: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13713: astore 30
    //   13715: aload_0
    //   13716: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13719: ifnull +903 -> 14622
    //   13722: aload_0
    //   13723: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   13726: invokeinterface 657 1 0
    //   13731: astore 26
    //   13733: aload 29
    //   13735: aload 30
    //   13737: aload 26
    //   13739: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13742: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13745: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13748: ldc_w 448
    //   13751: aload 29
    //   13753: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   13756: aconst_null
    //   13757: invokestatic 433	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   13760: aload_0
    //   13761: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13764: ifnull +24 -> 13788
    //   13767: aload_0
    //   13768: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   13771: ldc_w 440
    //   13774: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13777: ifeq +11 -> 13788
    //   13780: aload_0
    //   13781: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   13784: iconst_0
    //   13785: invokestatic 666	com/tencent/component/network/utils/http/pool/CustomDnsResolve:setIPDirectEnable	(Ljava/lang/String;Z)V
    //   13788: iload 10
    //   13790: ifne +8 -> 13798
    //   13793: aload_0
    //   13794: iconst_0
    //   13795: putfield 669	com/tencent/component/network/downloader/impl/FastDownloadTask:mShouldReport	Z
    //   13798: aload_2
    //   13799: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13802: astore 26
    //   13804: new 127	java/lang/StringBuilder
    //   13807: dup
    //   13808: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   13811: aload_0
    //   13812: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   13815: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13818: ldc_w 671
    //   13821: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13824: aload 25
    //   13826: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13829: ldc_w 673
    //   13832: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13835: aload_2
    //   13836: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13839: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13842: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13845: ldc_w 675
    //   13848: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13851: astore 25
    //   13853: aload_0
    //   13854: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13857: ifnull +1411 -> 15268
    //   13860: aload_0
    //   13861: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13864: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   13867: istore 4
    //   13869: aload 25
    //   13871: iload 4
    //   13873: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13876: ldc_w 610
    //   13879: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13882: iload 5
    //   13884: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13887: ldc_w 572
    //   13890: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13893: aload_2
    //   13894: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13897: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13900: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13903: ldc_w 584
    //   13906: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13909: aload_2
    //   13910: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13913: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13916: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13919: ldc_w 589
    //   13922: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13925: aload_2
    //   13926: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13929: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13932: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13935: ldc_w 577
    //   13938: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13941: aload_2
    //   13942: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13945: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   13948: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13951: ldc_w 582
    //   13954: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13957: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   13960: aload_0
    //   13961: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   13964: lsub
    //   13965: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13968: astore 25
    //   13970: aload 24
    //   13972: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13975: ifne +1299 -> 15274
    //   13978: new 127	java/lang/StringBuilder
    //   13981: dup
    //   13982: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   13985: ldc_w 614
    //   13988: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13991: aload 24
    //   13993: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13996: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13999: astore 24
    //   14001: aload 26
    //   14003: aload 25
    //   14005: aload 24
    //   14007: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14010: ldc_w 612
    //   14013: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14016: aload 28
    //   14018: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14021: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14024: putfield 678	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   14027: aload_0
    //   14028: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14031: ifnull +53 -> 14084
    //   14034: getstatic 205	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14037: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14040: aload_0
    //   14041: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14044: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14047: if_icmpne +37 -> 14084
    //   14050: aload_0
    //   14051: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14054: ifnull +30 -> 14084
    //   14057: aload_0
    //   14058: getfield 234	com/tencent/component/network/downloader/impl/FastDownloadTask:pBackupIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14061: aload_0
    //   14062: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14065: aload_0
    //   14066: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14069: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14072: aload_2
    //   14073: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14076: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14079: invokeinterface 685 4 0
    //   14084: aload_0
    //   14085: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14088: ifnull +53 -> 14141
    //   14091: getstatic 299	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14094: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14097: aload_0
    //   14098: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14101: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   14104: if_icmpne +37 -> 14141
    //   14107: aload_0
    //   14108: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14111: ifnull +30 -> 14141
    //   14114: aload_0
    //   14115: getfield 302	com/tencent/component/network/downloader/impl/FastDownloadTask:pDirectIPConfigStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   14118: aload_0
    //   14119: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14122: aload_0
    //   14123: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14126: invokestatic 681	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   14129: aload_2
    //   14130: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14133: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14136: invokeinterface 685 4 0
    //   14141: iload 10
    //   14143: ifeq +64 -> 14207
    //   14146: aload_0
    //   14147: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14150: invokestatic 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   14153: astore 24
    //   14155: aload_0
    //   14156: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14159: astore 25
    //   14161: aload_0
    //   14162: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14165: ifeq +1147 -> 15312
    //   14168: aload_0
    //   14169: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14172: ifnull +1140 -> 15312
    //   14175: aload_0
    //   14176: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14179: ldc_w 687
    //   14182: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14185: ifeq +1127 -> 15312
    //   14188: iconst_1
    //   14189: istore 10
    //   14191: aload 24
    //   14193: aload 25
    //   14195: iload 10
    //   14197: aload_2
    //   14198: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14201: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14204: invokevirtual 691	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:reportHttps	(Ljava/lang/String;ZZ)V
    //   14207: aload 29
    //   14209: invokestatic 408	java/lang/System:currentTimeMillis	()J
    //   14212: putfield 694	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   14215: aload 29
    //   14217: aload_0
    //   14218: invokevirtual 697	com/tencent/component/network/downloader/impl/FastDownloadTask:getContentLength	()J
    //   14221: putfield 700	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   14224: aload 29
    //   14226: aload 23
    //   14228: putfield 704	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   14231: aload 29
    //   14233: aload 22
    //   14235: putfield 708	com/tencent/component/network/downloader/DownloadReport:okResponse	Lokhttp3/Response;
    //   14238: aload 29
    //   14240: iload 5
    //   14242: putfield 711	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   14245: aload 29
    //   14247: aconst_null
    //   14248: putfield 715	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   14251: aload 27
    //   14253: ifnonnull +1065 -> 15318
    //   14256: aconst_null
    //   14257: astore 23
    //   14259: aload 29
    //   14261: aload 23
    //   14263: putfield 718	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   14266: aload 29
    //   14268: aconst_null
    //   14269: putfield 721	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   14272: aload 29
    //   14274: aload_2
    //   14275: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14278: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14281: putfield 722	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   14284: aload 29
    //   14286: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14289: aload_0
    //   14290: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14293: lsub
    //   14294: putfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14297: aload 29
    //   14299: aload_2
    //   14300: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14303: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14306: putfield 728	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   14309: aload 29
    //   14311: aload 29
    //   14313: getfield 725	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   14316: aload_2
    //   14317: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14320: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14323: lsub
    //   14324: putfield 731	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   14327: aload 29
    //   14329: lload 12
    //   14331: putfield 734	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   14334: aload 29
    //   14336: aload_0
    //   14337: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   14340: putfield 737	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   14343: aload 29
    //   14345: aload_0
    //   14346: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   14349: putfield 740	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   14352: aload 29
    //   14354: aload_0
    //   14355: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   14358: putfield 743	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   14361: aload 29
    //   14363: lconst_0
    //   14364: putfield 746	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   14367: aload 29
    //   14369: aload_0
    //   14370: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   14373: putfield 749	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   14376: aload 29
    //   14378: aload_2
    //   14379: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14382: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14385: putfield 752	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   14388: aload 29
    //   14390: aload_0
    //   14391: invokevirtual 55	com/tencent/component/network/downloader/impl/FastDownloadTask:getDomain	()Ljava/lang/String;
    //   14394: invokestatic 755	com/tencent/component/network/module/base/Config:isFromQzoneAlbum	(Ljava/lang/String;)Z
    //   14397: putfield 757	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   14400: aload 29
    //   14402: aload_0
    //   14403: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14406: putfield 760	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   14409: aload_0
    //   14410: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14413: ifnull +915 -> 15328
    //   14416: aload_0
    //   14417: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14420: ldc_w 687
    //   14423: invokevirtual 443	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14426: ifeq +902 -> 15328
    //   14429: iconst_1
    //   14430: istore 10
    //   14432: aload 29
    //   14434: iload 10
    //   14436: putfield 763	com/tencent/component/network/downloader/DownloadReport:isHttps	Z
    //   14439: aload 29
    //   14441: aload_2
    //   14442: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14445: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14448: putfield 765	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   14451: aload 29
    //   14453: getstatic 771	com/tencent/component/network/downloader/Downloader$DownloadMode:FastMode	Lcom/tencent/component/network/downloader/Downloader$DownloadMode;
    //   14456: invokevirtual 774	com/tencent/component/network/downloader/Downloader$DownloadMode:ordinal	()I
    //   14459: putfield 777	com/tencent/component/network/downloader/DownloadReport:downloadMode	I
    //   14462: aload 22
    //   14464: ifnull +24 -> 14488
    //   14467: aload 22
    //   14469: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14472: ifnull +16 -> 14488
    //   14475: aload 29
    //   14477: aload 22
    //   14479: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14482: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14485: putfield 779	com/tencent/component/network/downloader/DownloadReport:protocol	Ljava/lang/String;
    //   14488: aload_2
    //   14489: aload 29
    //   14491: invokevirtual 783	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14494: aload_2
    //   14495: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14498: invokevirtual 511	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   14501: ifeq +11 -> 14512
    //   14504: aload_0
    //   14505: aload_1
    //   14506: aload_2
    //   14507: aload 29
    //   14509: invokevirtual 364	com/tencent/component/network/downloader/impl/FastDownloadTask:handleDownloadReportForTask	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   14512: aload_0
    //   14513: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14516: ifeq +818 -> 15334
    //   14519: aload_0
    //   14520: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14523: ifnull +12 -> 14535
    //   14526: aload_0
    //   14527: getfield 787	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestCall	Lokhttp3/Call;
    //   14530: invokeinterface 792 1 0
    //   14535: aload_0
    //   14536: aconst_null
    //   14537: putfield 419	com/tencent/component/network/downloader/impl/FastDownloadTask:okRequestBuilder	Lokhttp3/Request$Builder;
    //   14540: iload_3
    //   14541: iconst_1
    //   14542: iadd
    //   14543: istore_3
    //   14544: goto -14339 -> 205
    //   14547: aload_2
    //   14548: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14551: iconst_3
    //   14552: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14555: goto -1670 -> 12885
    //   14558: astore 25
    //   14560: goto -14308 -> 252
    //   14563: aload_2
    //   14564: invokevirtual 377	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   14567: iconst_3
    //   14568: invokevirtual 382	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   14571: iconst_0
    //   14572: istore 5
    //   14574: goto -1660 -> 12914
    //   14577: aconst_null
    //   14578: astore 25
    //   14580: goto -1587 -> 12993
    //   14583: astore 24
    //   14585: ldc_w 429
    //   14588: astore 24
    //   14590: goto -1563 -> 13027
    //   14593: ldc_w 962
    //   14596: astore 26
    //   14598: goto -1396 -> 13202
    //   14601: aconst_null
    //   14602: astore 26
    //   14604: goto -1282 -> 13322
    //   14607: aload_0
    //   14608: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   14611: astore 26
    //   14613: goto -1062 -> 13551
    //   14616: iconst_0
    //   14617: istore 4
    //   14619: goto -1037 -> 13582
    //   14622: aconst_null
    //   14623: astore 26
    //   14625: goto -892 -> 13733
    //   14628: new 127	java/lang/StringBuilder
    //   14631: dup
    //   14632: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   14635: ldc_w 964
    //   14638: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14641: aload_0
    //   14642: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   14645: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14648: ldc_w 528
    //   14651: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14654: aload_0
    //   14655: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14658: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14661: ldc_w 533
    //   14664: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14667: astore 30
    //   14669: aload_0
    //   14670: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   14673: ifeq +560 -> 15233
    //   14676: aload 22
    //   14678: ifnull +555 -> 15233
    //   14681: aload 22
    //   14683: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14686: ifnull +547 -> 15233
    //   14689: aload 22
    //   14691: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   14694: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   14697: astore 26
    //   14699: aload 30
    //   14701: aload 26
    //   14703: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14706: ldc_w 544
    //   14709: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14712: aload 27
    //   14714: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14717: ldc_w 549
    //   14720: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14723: aload 25
    //   14725: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14728: ldc_w 551
    //   14731: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14734: aconst_null
    //   14735: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14738: ldc_w 553
    //   14741: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14744: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14747: invokevirtual 176	java/lang/Thread:getId	()J
    //   14750: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14753: ldc_w 555
    //   14756: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14759: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14762: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14765: ldc_w 557
    //   14768: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14771: aload_0
    //   14772: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14775: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14778: ldc_w 559
    //   14781: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14784: aload_0
    //   14785: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14788: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14791: ldc_w 561
    //   14794: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14797: astore 30
    //   14799: aload_0
    //   14800: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   14803: ifeq +438 -> 15241
    //   14806: aload_0
    //   14807: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   14810: aload_0
    //   14811: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   14814: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14817: astore 26
    //   14819: aload 30
    //   14821: aload 26
    //   14823: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14826: ldc_w 565
    //   14829: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14832: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   14835: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14838: ldc_w 577
    //   14841: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14844: aload_2
    //   14845: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14848: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   14851: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14854: ldc_w 582
    //   14857: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14860: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   14863: aload_0
    //   14864: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   14867: lsub
    //   14868: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14871: ldc_w 584
    //   14874: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14877: aload_2
    //   14878: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14881: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14884: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14887: ldc_w 589
    //   14890: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14893: aload_2
    //   14894: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14897: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14900: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14903: ldc_w 593
    //   14906: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14909: aload_2
    //   14910: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14913: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14916: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14919: ldc_w 598
    //   14922: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14925: aload_0
    //   14926: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   14929: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14932: ldc_w 600
    //   14935: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14938: aload_0
    //   14939: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   14942: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14945: ldc_w 966
    //   14948: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14951: iload 5
    //   14953: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14956: ldc_w 612
    //   14959: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14962: aload 28
    //   14964: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14967: ldc_w 572
    //   14970: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14973: aload_2
    //   14974: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14977: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14980: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14983: ldc_w 614
    //   14986: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14989: aload 24
    //   14991: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14994: ldc_w 616
    //   14997: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15000: astore 30
    //   15002: aload_0
    //   15003: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15006: ifnull +241 -> 15247
    //   15009: aload_0
    //   15010: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15013: iconst_0
    //   15014: bipush 30
    //   15016: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   15019: astore 26
    //   15021: aload 30
    //   15023: aload 26
    //   15025: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15028: ldc_w 622
    //   15031: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15034: astore 26
    //   15036: aload_0
    //   15037: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15040: ifnull +216 -> 15256
    //   15043: aload_0
    //   15044: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15047: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15050: istore 4
    //   15052: aload 26
    //   15054: iload 4
    //   15056: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15059: ldc_w 624
    //   15062: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15065: aload_2
    //   15066: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15069: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15072: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15075: ldc_w 629
    //   15078: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15081: lload 12
    //   15083: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15086: ldc_w 631
    //   15089: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15092: aload_0
    //   15093: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15096: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15099: ldc_w 600
    //   15102: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15105: aload_0
    //   15106: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15109: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15112: ldc_w 633
    //   15115: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15118: aload_0
    //   15119: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15122: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15125: ldc_w 600
    //   15128: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15131: aload_0
    //   15132: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15135: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15138: ldc_w 635
    //   15141: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15144: aload_0
    //   15145: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15148: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15151: ldc_w 637
    //   15154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15157: aload_0
    //   15158: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15161: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15164: ldc_w 642
    //   15167: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15170: aload_0
    //   15171: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15174: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15177: ldc_w 647
    //   15180: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15183: astore 30
    //   15185: aload_0
    //   15186: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15189: ifnull +73 -> 15262
    //   15192: aload_0
    //   15193: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15196: invokeinterface 657 1 0
    //   15201: astore 26
    //   15203: aload 29
    //   15205: aload 30
    //   15207: aload 26
    //   15209: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15212: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15215: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15218: ldc_w 448
    //   15221: aload 29
    //   15223: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15226: aconst_null
    //   15227: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15230: goto -1442 -> 13788
    //   15233: ldc_w 962
    //   15236: astore 26
    //   15238: goto -539 -> 14699
    //   15241: aconst_null
    //   15242: astore 26
    //   15244: goto -425 -> 14819
    //   15247: aload_0
    //   15248: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15251: astore 26
    //   15253: goto -232 -> 15021
    //   15256: iconst_0
    //   15257: istore 4
    //   15259: goto -207 -> 15052
    //   15262: aconst_null
    //   15263: astore 26
    //   15265: goto -62 -> 15203
    //   15268: iconst_0
    //   15269: istore 4
    //   15271: goto -1402 -> 13869
    //   15274: ldc_w 429
    //   15277: astore 24
    //   15279: goto -1278 -> 14001
    //   15282: astore 24
    //   15284: ldc 221
    //   15286: ldc_w 971
    //   15289: aload 24
    //   15291: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15294: goto -1210 -> 14084
    //   15297: astore 24
    //   15299: ldc 221
    //   15301: ldc_w 973
    //   15304: aload 24
    //   15306: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15309: goto -1168 -> 14141
    //   15312: iconst_0
    //   15313: istore 10
    //   15315: goto -1124 -> 14191
    //   15318: aload 27
    //   15320: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15323: astore 23
    //   15325: goto -1066 -> 14259
    //   15328: iconst_0
    //   15329: istore 10
    //   15331: goto -899 -> 14432
    //   15334: aload_0
    //   15335: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15338: ifnull +15 -> 15353
    //   15341: aload_0
    //   15342: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15345: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   15348: aload_0
    //   15349: aconst_null
    //   15350: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   15353: aload_0
    //   15354: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   15357: goto -817 -> 14540
    //   15360: aconst_null
    //   15361: astore 26
    //   15363: goto -14952 -> 411
    //   15366: astore 24
    //   15368: ldc_w 429
    //   15371: astore 24
    //   15373: goto -14928 -> 445
    //   15376: ldc_w 962
    //   15379: astore 27
    //   15381: goto -14761 -> 620
    //   15384: aconst_null
    //   15385: astore 27
    //   15387: goto -14647 -> 740
    //   15390: aload_0
    //   15391: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15394: astore 27
    //   15396: goto -14427 -> 969
    //   15399: iconst_0
    //   15400: istore_3
    //   15401: goto -14402 -> 999
    //   15404: aconst_null
    //   15405: astore 27
    //   15407: goto -14258 -> 1149
    //   15410: new 127	java/lang/StringBuilder
    //   15413: dup
    //   15414: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   15417: ldc_w 964
    //   15420: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15423: aload_0
    //   15424: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   15427: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15430: ldc_w 528
    //   15433: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15436: aload_0
    //   15437: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15440: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15443: ldc_w 533
    //   15446: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15449: astore 31
    //   15451: aload_0
    //   15452: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   15455: ifeq +558 -> 16013
    //   15458: aload 22
    //   15460: ifnull +553 -> 16013
    //   15463: aload 22
    //   15465: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15468: ifnull +545 -> 16013
    //   15471: aload 22
    //   15473: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   15476: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   15479: astore 27
    //   15481: aload 31
    //   15483: aload 27
    //   15485: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15488: ldc_w 544
    //   15491: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15494: aload 28
    //   15496: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15499: ldc_w 549
    //   15502: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15505: aload 26
    //   15507: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15510: ldc_w 551
    //   15513: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15516: aconst_null
    //   15517: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15520: ldc_w 553
    //   15523: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15526: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15529: invokevirtual 176	java/lang/Thread:getId	()J
    //   15532: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15535: ldc_w 555
    //   15538: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15541: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   15544: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15547: ldc_w 557
    //   15550: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15553: aload_0
    //   15554: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15557: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15560: ldc_w 559
    //   15563: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15566: aload_0
    //   15567: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15570: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15573: ldc_w 561
    //   15576: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15579: astore 31
    //   15581: aload_0
    //   15582: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   15585: ifeq +436 -> 16021
    //   15588: aload_0
    //   15589: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   15592: aload_0
    //   15593: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   15596: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   15599: astore 27
    //   15601: aload 31
    //   15603: aload 27
    //   15605: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15608: ldc_w 565
    //   15611: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15614: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   15617: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15620: ldc_w 577
    //   15623: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15626: aload_2
    //   15627: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   15630: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   15633: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15636: ldc_w 582
    //   15639: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15642: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   15645: aload_0
    //   15646: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   15649: lsub
    //   15650: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15653: ldc_w 584
    //   15656: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15659: aload_2
    //   15660: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15663: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   15666: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15669: ldc_w 589
    //   15672: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15675: aload_2
    //   15676: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15679: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   15682: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15685: ldc_w 593
    //   15688: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15691: aload_2
    //   15692: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15695: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   15698: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15701: ldc_w 598
    //   15704: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15707: aload_0
    //   15708: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   15711: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15714: ldc_w 600
    //   15717: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15720: aload_0
    //   15721: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   15724: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15727: ldc_w 966
    //   15730: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15733: iload 4
    //   15735: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15738: ldc_w 612
    //   15741: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15744: aload 30
    //   15746: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15749: ldc_w 572
    //   15752: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15755: aload_2
    //   15756: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15759: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   15762: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15765: ldc_w 614
    //   15768: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15771: aload 24
    //   15773: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15776: ldc_w 616
    //   15779: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15782: astore 31
    //   15784: aload_0
    //   15785: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15788: ifnull +239 -> 16027
    //   15791: aload_0
    //   15792: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   15795: iconst_0
    //   15796: bipush 30
    //   15798: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   15801: astore 27
    //   15803: aload 31
    //   15805: aload 27
    //   15807: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15810: ldc_w 622
    //   15813: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15816: astore 27
    //   15818: aload_0
    //   15819: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15822: ifnull +214 -> 16036
    //   15825: aload_0
    //   15826: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   15829: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   15832: istore_3
    //   15833: aload 27
    //   15835: iload_3
    //   15836: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15839: ldc_w 624
    //   15842: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15845: aload_2
    //   15846: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   15849: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   15852: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15855: ldc_w 629
    //   15858: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15861: lload 12
    //   15863: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15866: ldc_w 631
    //   15869: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15872: aload_0
    //   15873: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   15876: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15879: ldc_w 600
    //   15882: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15885: aload_0
    //   15886: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   15889: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15892: ldc_w 633
    //   15895: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15898: aload_0
    //   15899: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   15902: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15905: ldc_w 600
    //   15908: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15911: aload_0
    //   15912: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   15915: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15918: ldc_w 635
    //   15921: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15924: aload_0
    //   15925: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   15928: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15931: ldc_w 637
    //   15934: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15937: aload_0
    //   15938: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   15941: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15944: ldc_w 642
    //   15947: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15950: aload_0
    //   15951: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   15954: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15957: ldc_w 647
    //   15960: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15963: astore 31
    //   15965: aload_0
    //   15966: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15969: ifnull +72 -> 16041
    //   15972: aload_0
    //   15973: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   15976: invokeinterface 657 1 0
    //   15981: astore 27
    //   15983: aload 29
    //   15985: aload 31
    //   15987: aload 27
    //   15989: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15992: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15995: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15998: ldc_w 448
    //   16001: aload 29
    //   16003: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16006: aconst_null
    //   16007: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16010: goto -14805 -> 1205
    //   16013: ldc_w 962
    //   16016: astore 27
    //   16018: goto -537 -> 15481
    //   16021: aconst_null
    //   16022: astore 27
    //   16024: goto -423 -> 15601
    //   16027: aload_0
    //   16028: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16031: astore 27
    //   16033: goto -230 -> 15803
    //   16036: iconst_0
    //   16037: istore_3
    //   16038: goto -205 -> 15833
    //   16041: aconst_null
    //   16042: astore 27
    //   16044: goto -61 -> 15983
    //   16047: iconst_0
    //   16048: istore_3
    //   16049: goto -14764 -> 1285
    //   16052: ldc_w 429
    //   16055: astore 24
    //   16057: goto -14641 -> 1416
    //   16060: astore 24
    //   16062: ldc 221
    //   16064: ldc_w 971
    //   16067: aload 24
    //   16069: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16072: goto -14573 -> 1499
    //   16075: astore 24
    //   16077: ldc 221
    //   16079: ldc_w 973
    //   16082: aload 24
    //   16084: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16087: goto -14531 -> 1556
    //   16090: iconst_0
    //   16091: istore 10
    //   16093: goto -14487 -> 1606
    //   16096: aload 28
    //   16098: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16101: astore 23
    //   16103: goto -14428 -> 1675
    //   16106: iconst_0
    //   16107: istore 10
    //   16109: goto -14261 -> 1848
    //   16112: aload_0
    //   16113: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16116: ifnull +15 -> 16131
    //   16119: aload_0
    //   16120: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16123: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   16126: aload_0
    //   16127: aconst_null
    //   16128: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16131: aload_0
    //   16132: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16135: goto -14179 -> 1956
    //   16138: aconst_null
    //   16139: astore 27
    //   16141: goto -11117 -> 5024
    //   16144: astore 24
    //   16146: ldc_w 429
    //   16149: astore 24
    //   16151: goto -11093 -> 5058
    //   16154: ldc_w 962
    //   16157: astore 28
    //   16159: goto -10926 -> 5233
    //   16162: aconst_null
    //   16163: astore 28
    //   16165: goto -10812 -> 5353
    //   16168: aload_0
    //   16169: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16172: astore 28
    //   16174: goto -10592 -> 5582
    //   16177: iconst_0
    //   16178: istore_3
    //   16179: goto -10567 -> 5612
    //   16182: aconst_null
    //   16183: astore 28
    //   16185: goto -10423 -> 5762
    //   16188: new 127	java/lang/StringBuilder
    //   16191: dup
    //   16192: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   16195: ldc_w 964
    //   16198: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16201: aload_0
    //   16202: invokevirtual 72	com/tencent/component/network/downloader/impl/FastDownloadTask:getUrl	()Ljava/lang/String;
    //   16205: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16208: ldc_w 528
    //   16211: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16214: aload_0
    //   16215: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16218: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16221: ldc_w 533
    //   16224: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16227: astore 32
    //   16229: aload_0
    //   16230: getfield 75	com/tencent/component/network/downloader/impl/FastDownloadTask:mIsHttp2	Z
    //   16233: ifeq +558 -> 16791
    //   16236: aload 25
    //   16238: ifnull +553 -> 16791
    //   16241: aload 25
    //   16243: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16246: ifnull +545 -> 16791
    //   16249: aload 25
    //   16251: invokevirtual 539	okhttp3/Response:protocol	()Lokhttp3/Protocol;
    //   16254: invokevirtual 542	okhttp3/Protocol:toString	()Ljava/lang/String;
    //   16257: astore 28
    //   16259: aload 32
    //   16261: aload 28
    //   16263: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16266: ldc_w 544
    //   16269: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16272: aload 30
    //   16274: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16277: ldc_w 549
    //   16280: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16283: aload 27
    //   16285: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16288: ldc_w 551
    //   16291: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16294: aconst_null
    //   16295: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16298: ldc_w 553
    //   16301: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16304: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16307: invokevirtual 176	java/lang/Thread:getId	()J
    //   16310: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16313: ldc_w 555
    //   16316: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16319: invokestatic 160	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   16322: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16325: ldc_w 557
    //   16328: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16331: aload_0
    //   16332: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16335: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16338: ldc_w 559
    //   16341: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16344: aload_0
    //   16345: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16348: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16351: ldc_w 561
    //   16354: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16357: astore 32
    //   16359: aload_0
    //   16360: getfield 189	com/tencent/component/network/downloader/impl/FastDownloadTask:mAllowProxy	Z
    //   16363: ifeq +436 -> 16799
    //   16366: aload_0
    //   16367: getfield 63	com/tencent/component/network/downloader/impl/FastDownloadTask:mContext	Landroid/content/Context;
    //   16370: aload_0
    //   16371: getfield 194	com/tencent/component/network/downloader/impl/FastDownloadTask:mAPNProxy	Z
    //   16374: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   16377: astore 28
    //   16379: aload 32
    //   16381: aload 28
    //   16383: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16386: ldc_w 565
    //   16389: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16392: invokestatic 570	com/tencent/component/network/module/base/Config:getNetworkStackType	()I
    //   16395: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16398: ldc_w 577
    //   16401: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16404: aload_2
    //   16405: invokevirtual 456	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   16408: getfield 580	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   16411: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16414: ldc_w 582
    //   16417: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16420: invokestatic 32	android/os/SystemClock:uptimeMillis	()J
    //   16423: aload_0
    //   16424: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:mTimeStamp	J
    //   16427: lsub
    //   16428: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16431: ldc_w 584
    //   16434: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16437: aload_2
    //   16438: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16441: getfield 587	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   16444: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16447: ldc_w 589
    //   16450: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16453: aload_2
    //   16454: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16457: getfield 591	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   16460: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16463: ldc_w 593
    //   16466: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16469: aload_2
    //   16470: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16473: getfield 596	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   16476: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16479: ldc_w 598
    //   16482: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16485: aload_0
    //   16486: invokevirtual 422	com/tencent/component/network/downloader/impl/FastDownloadTask:getCurrAttemptCount	()I
    //   16489: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16492: ldc_w 600
    //   16495: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16498: aload_0
    //   16499: invokevirtual 603	com/tencent/component/network/downloader/impl/FastDownloadTask:getTotalAttemptCount	()I
    //   16502: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16505: ldc_w 966
    //   16508: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16511: iload 4
    //   16513: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16516: ldc_w 612
    //   16519: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16522: aload 31
    //   16524: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16527: ldc_w 572
    //   16530: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16533: aload_2
    //   16534: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16537: getfield 575	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   16540: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16543: ldc_w 614
    //   16546: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16549: aload 24
    //   16551: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16554: ldc_w 616
    //   16557: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16560: astore 32
    //   16562: aload_0
    //   16563: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16566: ifnull +239 -> 16805
    //   16569: aload_0
    //   16570: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16573: iconst_0
    //   16574: bipush 30
    //   16576: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   16579: astore 28
    //   16581: aload 32
    //   16583: aload 28
    //   16585: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16588: ldc_w 622
    //   16591: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16594: astore 28
    //   16596: aload_0
    //   16597: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16600: ifnull +214 -> 16814
    //   16603: aload_0
    //   16604: getfield 83	com/tencent/component/network/downloader/impl/FastDownloadTask:pCurrStrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   16607: getfield 110	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   16610: istore_3
    //   16611: aload 28
    //   16613: iload_3
    //   16614: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16617: ldc_w 624
    //   16620: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16623: aload_2
    //   16624: invokevirtual 503	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   16627: getfield 627	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   16630: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16633: ldc_w 629
    //   16636: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16639: lload 12
    //   16641: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16644: ldc_w 631
    //   16647: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16650: aload_0
    //   16651: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_time	J
    //   16654: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16657: ldc_w 600
    //   16660: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16663: aload_0
    //   16664: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:connect_retry	I
    //   16667: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16670: ldc_w 633
    //   16673: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16676: aload_0
    //   16677: getfield 42	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_time	J
    //   16680: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16683: ldc_w 600
    //   16686: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16689: aload_0
    //   16690: getfield 44	com/tencent/component/network/downloader/impl/FastDownloadTask:exe_retry	I
    //   16693: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16696: ldc_w 635
    //   16699: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16702: aload_0
    //   16703: getfield 46	com/tencent/component/network/downloader/impl/FastDownloadTask:send_req_time	J
    //   16706: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16709: ldc_w 637
    //   16712: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16715: aload_0
    //   16716: getfield 640	com/tencent/component/network/downloader/impl/FastDownloadTask:t_recv_data	J
    //   16719: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16722: ldc_w 642
    //   16725: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16728: aload_0
    //   16729: invokevirtual 645	com/tencent/component/network/downloader/impl/FastDownloadTask:getTaskConcurrentCount	()I
    //   16732: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16735: ldc_w 647
    //   16738: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16741: astore 32
    //   16743: aload_0
    //   16744: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16747: ifnull +72 -> 16819
    //   16750: aload_0
    //   16751: getfield 651	com/tencent/component/network/downloader/impl/FastDownloadTask:mDownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   16754: invokeinterface 657 1 0
    //   16759: astore 28
    //   16761: aload 29
    //   16763: aload 32
    //   16765: aload 28
    //   16767: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16770: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16773: putfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16776: ldc_w 448
    //   16779: aload 29
    //   16781: getfield 660	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   16784: aconst_null
    //   16785: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16788: goto -10970 -> 5818
    //   16791: ldc_w 962
    //   16794: astore 28
    //   16796: goto -537 -> 16259
    //   16799: aconst_null
    //   16800: astore 28
    //   16802: goto -423 -> 16379
    //   16805: aload_0
    //   16806: getfield 438	com/tencent/component/network/downloader/impl/FastDownloadTask:mRealUrl	Ljava/lang/String;
    //   16809: astore 28
    //   16811: goto -230 -> 16581
    //   16814: iconst_0
    //   16815: istore_3
    //   16816: goto -205 -> 16611
    //   16819: aconst_null
    //   16820: astore 28
    //   16822: goto -61 -> 16761
    //   16825: iconst_0
    //   16826: istore_3
    //   16827: goto -10929 -> 5898
    //   16830: ldc_w 429
    //   16833: astore 24
    //   16835: goto -10806 -> 6029
    //   16838: astore 24
    //   16840: ldc 221
    //   16842: ldc_w 971
    //   16845: aload 24
    //   16847: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16850: goto -10738 -> 6112
    //   16853: astore 24
    //   16855: ldc 221
    //   16857: ldc_w 973
    //   16860: aload 24
    //   16862: invokestatic 969	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   16865: goto -10696 -> 6169
    //   16868: iconst_0
    //   16869: istore 10
    //   16871: goto -10652 -> 6219
    //   16874: aload 30
    //   16876: invokevirtual 976	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   16879: astore 23
    //   16881: goto -10593 -> 6288
    //   16884: iconst_0
    //   16885: istore 10
    //   16887: goto -10426 -> 6461
    //   16890: aload_0
    //   16891: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16894: ifnull +15 -> 16909
    //   16897: aload_0
    //   16898: getfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16901: invokevirtual 981	org/apache/http/client/methods/HttpGet:abort	()V
    //   16904: aload_0
    //   16905: aconst_null
    //   16906: putfield 415	com/tencent/component/network/downloader/impl/FastDownloadTask:request	Lorg/apache/http/client/methods/HttpGet;
    //   16909: aload_0
    //   16910: invokevirtual 984	com/tencent/component/network/downloader/impl/FastDownloadTask:cleanExpireConnection	()V
    //   16913: goto -10344 -> 6569
    //   16916: astore 23
    //   16918: aconst_null
    //   16919: astore 27
    //   16921: aload 22
    //   16923: astore 24
    //   16925: aload 23
    //   16927: astore 22
    //   16929: aload 27
    //   16931: astore 23
    //   16933: iload 7
    //   16935: istore 4
    //   16937: goto -11992 -> 4945
    //   16940: astore 25
    //   16942: aconst_null
    //   16943: astore 28
    //   16945: aload 23
    //   16947: astore 26
    //   16949: aload 22
    //   16951: astore 27
    //   16953: aload 25
    //   16955: astore 22
    //   16957: aload 28
    //   16959: astore 23
    //   16961: iload 7
    //   16963: istore 4
    //   16965: aload 27
    //   16967: astore 25
    //   16969: goto -12024 -> 4945
    //   16972: astore 25
    //   16974: aconst_null
    //   16975: astore 28
    //   16977: aload 23
    //   16979: astore 26
    //   16981: aload 22
    //   16983: astore 27
    //   16985: aload 25
    //   16987: astore 22
    //   16989: aload 28
    //   16991: astore 23
    //   16993: aload 27
    //   16995: astore 25
    //   16997: goto -12052 -> 4945
    //   17000: astore 25
    //   17002: aload 23
    //   17004: astore 26
    //   17006: aload 22
    //   17008: astore 27
    //   17010: aconst_null
    //   17011: astore 23
    //   17013: aload 25
    //   17015: astore 22
    //   17017: aload 27
    //   17019: astore 25
    //   17021: goto -12076 -> 4945
    //   17024: astore 28
    //   17026: aload 23
    //   17028: astore 26
    //   17030: aload 22
    //   17032: astore 27
    //   17034: aload 25
    //   17036: astore 23
    //   17038: aload 28
    //   17040: astore 22
    //   17042: iload 5
    //   17044: istore_3
    //   17045: aload 27
    //   17047: astore 25
    //   17049: goto -12104 -> 4945
    //   17052: astore 25
    //   17054: aconst_null
    //   17055: astore 26
    //   17057: aload 22
    //   17059: astore 24
    //   17061: aconst_null
    //   17062: astore 23
    //   17064: aload 26
    //   17066: astore 22
    //   17068: iload 8
    //   17070: istore 4
    //   17072: goto -16820 -> 252
    //   17075: astore 25
    //   17077: iload 8
    //   17079: istore 4
    //   17081: goto -16829 -> 252
    //   17084: ldc_w 429
    //   17087: astore 24
    //   17089: goto -12031 -> 5058
    //   17092: ldc_w 429
    //   17095: astore 24
    //   17097: goto -16652 -> 445
    //   17100: ldc_w 429
    //   17103: astore 24
    //   17105: goto -4078 -> 13027
    //   17108: ldc_w 429
    //   17111: astore 24
    //   17113: goto -6538 -> 10575
    //   17116: ldc_w 429
    //   17119: astore 24
    //   17121: goto -8945 -> 8176
    //   17124: ldc_w 429
    //   17127: astore 24
    //   17129: goto -13927 -> 3202
    //   17132: iconst_0
    //   17133: istore 4
    //   17135: goto -14138 -> 2997
    //   17138: aconst_null
    //   17139: astore 22
    //   17141: aconst_null
    //   17142: astore 23
    //   17144: aconst_null
    //   17145: astore 24
    //   17147: goto -14199 -> 2948
    //   17150: iconst_1
    //   17151: istore 5
    //   17153: goto -14991 -> 2162
    //   17156: aload 28
    //   17158: astore 23
    //   17160: iload 4
    //   17162: iconst_2
    //   17163: if_icmpge -12406 -> 4757
    //   17166: aload 28
    //   17168: astore 23
    //   17170: iload 10
    //   17172: ifeq -12415 -> 4757
    //   17175: ldc_w 932
    //   17178: astore 23
    //   17180: goto -12423 -> 4757
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17183	0	this	FastDownloadTask
    //   0	17183	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	17183	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   29	17016	3	i	int
    //   246	16918	4	j	int
    //   263	16889	5	k	int
    //   275	6708	6	m	int
    //   177	16785	7	n	int
    //   180	16898	8	i1	int
    //   18	109	9	i2	int
    //   198	16973	10	bool1	boolean
    //   23	61	11	bool2	boolean
    //   26	16614	12	l1	long
    //   224	7016	14	l2	long
    //   228	7016	16	l3	long
    //   113	12806	18	l4	long
    //   188	2765	20	l5	long
    //   97	1	22	localException1	java.lang.Exception
    //   183	1	22	localObject1	Object
    //   215	16	22	localUnknownHostException	UnknownHostException
    //   236	4692	22	localObject2	Object
    //   4932	1638	22	localObject3	Object
    //   6601	10539	22	localObject4	Object
    //   242	16638	23	localObject5	Object
    //   16916	10	23	localObject6	Object
    //   16931	248	23	localObject7	Object
    //   166	7095	24	localObject8	Object
    //   7286	1	24	localException2	java.lang.Exception
    //   7291	690	24	str1	String
    //   7985	8	24	localException3	java.lang.Exception
    //   8000	162	24	localException4	java.lang.Exception
    //   8174	1163	24	localObject9	Object
    //   9692	1	24	localException5	java.lang.Exception
    //   9697	685	24	str2	String
    //   10386	8	24	localException6	java.lang.Exception
    //   10401	160	24	localException7	java.lang.Exception
    //   10573	1163	24	localObject10	Object
    //   12091	1	24	localException8	java.lang.Exception
    //   12096	685	24	str3	String
    //   12785	8	24	localException9	java.lang.Exception
    //   12800	213	24	localException10	java.lang.Exception
    //   13025	1167	24	localObject11	Object
    //   14583	1	24	localException11	java.lang.Exception
    //   14588	690	24	str4	String
    //   15282	8	24	localException12	java.lang.Exception
    //   15297	8	24	localException13	java.lang.Exception
    //   15366	1	24	localException14	java.lang.Exception
    //   15371	685	24	str5	String
    //   16060	8	24	localException15	java.lang.Exception
    //   16075	8	24	localException16	java.lang.Exception
    //   16144	1	24	localException17	java.lang.Exception
    //   16149	685	24	str6	String
    //   16838	8	24	localException18	java.lang.Exception
    //   16853	8	24	localException19	java.lang.Exception
    //   16923	223	24	localObject12	Object
    //   174	1	25	localObject13	Object
    //   233	1430	25	localThrowable1	java.lang.Throwable
    //   2938	11256	25	localObject14	Object
    //   14558	1	25	localThrowable2	java.lang.Throwable
    //   14578	1672	25	str7	String
    //   16940	14	25	localObject15	Object
    //   16967	1	25	localObject16	Object
    //   16972	14	25	localObject17	Object
    //   16995	1	25	localObject18	Object
    //   17000	14	25	localObject19	Object
    //   17019	29	25	localObject20	Object
    //   17052	1	25	localThrowable3	java.lang.Throwable
    //   17075	1	25	localThrowable4	java.lang.Throwable
    //   163	16902	26	localObject21	Object
    //   618	16428	27	localObject22	Object
    //   380	16610	28	localObject23	Object
    //   17024	143	28	localObject24	Object
    //   122	16658	29	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   423	16452	30	localObject25	Object
    //   588	15935	31	localObject26	Object
    //   5201	11563	32	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   77	83	97	java/lang/Exception
    //   190	200	215	java/net/UnknownHostException
    //   230	233	233	java/lang/Throwable
    //   1972	1976	233	java/lang/Throwable
    //   1984	1995	233	java/lang/Throwable
    //   2003	2012	233	java/lang/Throwable
    //   2020	2029	233	java/lang/Throwable
    //   2037	2044	233	java/lang/Throwable
    //   2052	2063	233	java/lang/Throwable
    //   2071	2078	233	java/lang/Throwable
    //   2086	2092	233	java/lang/Throwable
    //   2100	2109	233	java/lang/Throwable
    //   2117	2129	233	java/lang/Throwable
    //   2137	2144	233	java/lang/Throwable
    //   2152	2159	233	java/lang/Throwable
    //   2170	2176	233	java/lang/Throwable
    //   2184	2192	233	java/lang/Throwable
    //   2200	2213	233	java/lang/Throwable
    //   2221	2228	233	java/lang/Throwable
    //   2236	2243	233	java/lang/Throwable
    //   2251	2261	233	java/lang/Throwable
    //   2269	2285	233	java/lang/Throwable
    //   2293	2305	233	java/lang/Throwable
    //   2313	2319	233	java/lang/Throwable
    //   2327	2336	233	java/lang/Throwable
    //   2359	2365	233	java/lang/Throwable
    //   2378	2390	233	java/lang/Throwable
    //   2402	2410	233	java/lang/Throwable
    //   2422	2450	233	java/lang/Throwable
    //   2462	2469	233	java/lang/Throwable
    //   2477	2494	233	java/lang/Throwable
    //   2506	2518	233	java/lang/Throwable
    //   2526	2532	233	java/lang/Throwable
    //   2540	2606	233	java/lang/Throwable
    //   2614	2621	233	java/lang/Throwable
    //   2629	2641	233	java/lang/Throwable
    //   2649	2661	233	java/lang/Throwable
    //   2669	2676	233	java/lang/Throwable
    //   2689	2716	233	java/lang/Throwable
    //   2724	2731	233	java/lang/Throwable
    //   2739	2764	233	java/lang/Throwable
    //   2772	2792	233	java/lang/Throwable
    //   2800	2822	233	java/lang/Throwable
    //   2830	2838	233	java/lang/Throwable
    //   2846	2851	233	java/lang/Throwable
    //   2859	2864	233	java/lang/Throwable
    //   2872	2879	233	java/lang/Throwable
    //   2887	2894	233	java/lang/Throwable
    //   2902	2909	233	java/lang/Throwable
    //   2917	2922	233	java/lang/Throwable
    //   4742	4754	233	java/lang/Throwable
    //   4765	4776	233	java/lang/Throwable
    //   4784	4790	233	java/lang/Throwable
    //   4803	4815	233	java/lang/Throwable
    //   4827	4835	233	java/lang/Throwable
    //   4847	4881	233	java/lang/Throwable
    //   4893	4900	233	java/lang/Throwable
    //   4908	4925	233	java/lang/Throwable
    //   6580	6592	233	java/lang/Throwable
    //   6607	6614	233	java/lang/Throwable
    //   6626	6642	233	java/lang/Throwable
    //   6650	6656	233	java/lang/Throwable
    //   6669	6681	233	java/lang/Throwable
    //   6693	6701	233	java/lang/Throwable
    //   6713	6741	233	java/lang/Throwable
    //   6753	6760	233	java/lang/Throwable
    //   6768	6785	233	java/lang/Throwable
    //   6800	6812	233	java/lang/Throwable
    //   6823	6830	233	java/lang/Throwable
    //   6838	6851	233	java/lang/Throwable
    //   6869	6886	233	java/lang/Throwable
    //   6894	6900	233	java/lang/Throwable
    //   6913	6925	233	java/lang/Throwable
    //   6937	6945	233	java/lang/Throwable
    //   6957	6992	233	java/lang/Throwable
    //   7000	7007	233	java/lang/Throwable
    //   7015	7032	233	java/lang/Throwable
    //   7040	7052	233	java/lang/Throwable
    //   7060	7066	233	java/lang/Throwable
    //   7074	7130	233	java/lang/Throwable
    //   7141	7153	233	java/lang/Throwable
    //   7164	7193	233	java/lang/Throwable
    //   7204	7211	233	java/lang/Throwable
    //   7219	7237	233	java/lang/Throwable
    //   7245	7256	233	java/lang/Throwable
    //   230	233	4932	finally
    //   1972	1976	4932	finally
    //   1984	1995	4932	finally
    //   2003	2012	4932	finally
    //   2020	2029	4932	finally
    //   2037	2044	4932	finally
    //   2052	2063	4932	finally
    //   2071	2078	4932	finally
    //   2086	2092	4932	finally
    //   2100	2109	4932	finally
    //   2117	2129	4932	finally
    //   2137	2144	4932	finally
    //   2152	2159	4932	finally
    //   2170	2176	4932	finally
    //   2184	2192	4932	finally
    //   2200	2213	4932	finally
    //   2221	2228	4932	finally
    //   2236	2243	4932	finally
    //   2251	2261	4932	finally
    //   2269	2285	4932	finally
    //   2293	2305	4932	finally
    //   2313	2319	4932	finally
    //   2327	2336	4932	finally
    //   2359	2365	4932	finally
    //   2378	2390	4932	finally
    //   2402	2410	4932	finally
    //   2422	2450	4932	finally
    //   2462	2469	4932	finally
    //   2477	2494	4932	finally
    //   2506	2518	4932	finally
    //   2526	2532	4932	finally
    //   2540	2606	4932	finally
    //   2614	2621	4932	finally
    //   2629	2641	4932	finally
    //   2649	2661	4932	finally
    //   2669	2676	4932	finally
    //   2689	2716	4932	finally
    //   2724	2731	4932	finally
    //   2739	2764	4932	finally
    //   2772	2792	4932	finally
    //   2800	2822	4932	finally
    //   2830	2838	4932	finally
    //   2846	2851	4932	finally
    //   2859	2864	4932	finally
    //   2872	2879	4932	finally
    //   2887	2894	4932	finally
    //   2902	2909	4932	finally
    //   2917	2922	4932	finally
    //   4742	4754	4932	finally
    //   4765	4776	4932	finally
    //   4784	4790	4932	finally
    //   4803	4815	4932	finally
    //   4827	4835	4932	finally
    //   4847	4881	4932	finally
    //   4893	4900	4932	finally
    //   4908	4925	4932	finally
    //   6580	6592	4932	finally
    //   6607	6614	4932	finally
    //   6626	6642	4932	finally
    //   6650	6656	4932	finally
    //   6669	6681	4932	finally
    //   6693	6701	4932	finally
    //   6713	6741	4932	finally
    //   6753	6760	4932	finally
    //   6768	6785	4932	finally
    //   6800	6812	4932	finally
    //   6823	6830	4932	finally
    //   6838	6851	4932	finally
    //   6869	6886	4932	finally
    //   6894	6900	4932	finally
    //   6913	6925	4932	finally
    //   6937	6945	4932	finally
    //   6957	6992	4932	finally
    //   7000	7007	4932	finally
    //   7015	7032	4932	finally
    //   7040	7052	4932	finally
    //   7060	7066	4932	finally
    //   7074	7130	4932	finally
    //   7141	7153	4932	finally
    //   7164	7193	4932	finally
    //   7204	7211	4932	finally
    //   7219	7237	4932	finally
    //   7245	7256	4932	finally
    //   3187	3202	7286	java/lang/Exception
    //   4232	4259	7985	java/lang/Exception
    //   4289	4316	8000	java/lang/Exception
    //   8161	8176	9692	java/lang/Exception
    //   9202	9229	10386	java/lang/Exception
    //   9259	9286	10401	java/lang/Exception
    //   10560	10575	12091	java/lang/Exception
    //   11601	11628	12785	java/lang/Exception
    //   11658	11685	12800	java/lang/Exception
    //   2997	3006	14558	java/lang/Throwable
    //   3026	3084	14558	java/lang/Throwable
    //   12869	12885	14558	java/lang/Throwable
    //   12889	12910	14558	java/lang/Throwable
    //   14547	14555	14558	java/lang/Throwable
    //   13012	13027	14583	java/lang/Exception
    //   14057	14084	15282	java/lang/Exception
    //   14114	14141	15297	java/lang/Exception
    //   430	445	15366	java/lang/Exception
    //   1472	1499	16060	java/lang/Exception
    //   1529	1556	16075	java/lang/Exception
    //   5043	5058	16144	java/lang/Exception
    //   6085	6112	16838	java/lang/Exception
    //   6142	6169	16853	java/lang/Exception
    //   2922	2937	16916	finally
    //   2948	2958	16940	finally
    //   2973	2997	16940	finally
    //   7270	7277	16940	finally
    //   14563	14571	16940	finally
    //   2997	3006	16972	finally
    //   3026	3084	16972	finally
    //   12869	12885	16972	finally
    //   12889	12910	16972	finally
    //   14547	14555	16972	finally
    //   252	262	17000	finally
    //   265	274	17024	finally
    //   280	287	17024	finally
    //   293	306	17024	finally
    //   309	314	17024	finally
    //   323	332	17024	finally
    //   2922	2937	17052	java/lang/Throwable
    //   2948	2958	17075	java/lang/Throwable
    //   2973	2997	17075	java/lang/Throwable
    //   7270	7277	17075	java/lang/Throwable
    //   14563	14571	17075	java/lang/Throwable
  }
  
  protected void initTask()
  {
    super.initTask();
    this.mDomainWithPort = Utils.getDominWithPort(getUrl());
    this.mOrigPort = Utils.getPort(getUrl());
    this.mRefer = HttpUtil.prepareRefer(getUrl());
    if (!DownloadGlobalStrategy.getInstance(this.mContext).supportHttps())
    {
      this.mIsHttp2 = false;
      this.mOriginalIsHttp2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.FastDownloadTask
 * JD-Core Version:    0.7.0.1
 */