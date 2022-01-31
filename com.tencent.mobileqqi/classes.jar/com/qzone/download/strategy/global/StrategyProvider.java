package com.qzone.download.strategy.global;

import android.text.TextUtils;
import com.qzone.common.DnsService;
import com.qzone.common.IPInfo;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.NetworkManager;
import com.qzone.download.impl.DownloaderImpl;
import com.qzone.utils.NetworkUtil;
import com.qzone.utils.Utils;
import com.qzone.utils.http.HttpUtil;
import com.qzone.utils.http.HttpUtil.ClientOptions;
import com.qzone.utils.http.HttpUtil.RequestOptions;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public class StrategyProvider
{
  private static HttpClient sHttpClient = HttpUtil.createHttpClient(soptions);
  private static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions = new ThreadLocal()
  {
    protected HttpUtil.RequestOptions initialValue()
    {
      return new HttpUtil.RequestOptions();
    }
  };
  private static HttpUtil.ClientOptions soptions = new HttpUtil.ClientOptions();
  
  public StrategyProvider()
  {
    soptions.multiConnection = true;
    soptions.maxConnection = DownloaderImpl.MAX_CONNECTION;
    soptions.maxConnectionPerRoute = 2;
    soptions.timeToLive = 120L;
    soptions.timeToLiveUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
  }
  
  public static HttpResponse exeHttpRequest(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, RequestProcessor paramRequestProcessor)
  {
    try
    {
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = generateStrategyInfo(paramString, paramStrategyLib, paramInt);
      if (localStrategyInfo == null) {
        return null;
      }
      HttpUtil.RequestOptions localRequestOptions = (HttpUtil.RequestOptions)sRequestOptions.get();
      localRequestOptions.allowProxy = localStrategyInfo.allowProxy;
      localRequestOptions.apnProxy = localStrategyInfo.useConfigApn;
      paramStrategyLib = paramString;
      Object localObject = paramStrategyLib;
      if (localStrategyInfo != null)
      {
        localObject = paramStrategyLib;
        if (localStrategyInfo.getIPInfo() != null)
        {
          localObject = paramStrategyLib;
          if (!TextUtils.isEmpty(localStrategyInfo.getIPInfo().ip))
          {
            localObject = localStrategyInfo.getIPInfo().ip;
            paramInt = Utils.getPort(paramString);
            if (paramInt <= 0) {
              break label262;
            }
            localStrategyInfo.getIPInfo().port = paramInt;
          }
        }
      }
      for (;;)
      {
        int i = paramInt;
        if (!Utils.isPortValid(paramInt)) {
          i = 80;
        }
        String str = localObject + ":" + i;
        localObject = paramStrategyLib.replaceFirst(Utils.getDominWithPort(paramStrategyLib), str);
        QDLog.i("downloader", "downloader strategy run: " + localStrategyInfo.toString() + " domain:" + str + " url:" + paramString + " threadId:" + Thread.currentThread().getId());
        paramStrategyLib = HttpUtil.createHttpGet(DownloaderFactory.getContext(), paramString, (String)localObject, localRequestOptions);
        if (paramRequestProcessor != null) {
          paramRequestProcessor.prepareRequest(paramString, paramStrategyLib);
        }
        paramString = HttpUtil.createHttpContext();
        return sHttpClient.execute(paramStrategyLib, paramString);
        label262:
        paramInt = localStrategyInfo.getIPInfo().port;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QDLog.w("downloader", "", paramString);
    }
  }
  
  public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyLib == null) || (paramInt < 0)) {
      return null;
    }
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = paramStrategyLib.getOldStrategyInfo();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = paramStrategyLib.getStrategyInfo(paramInt);
    paramStrategyLib.setOldStrategyInfo(localStrategyInfo1);
    if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo1.id) || (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo1.id)) {
      return null;
    }
    QDLog.i("downloader", "downloader strategy: " + localStrategyInfo1.toString() + " currAttempCount:" + paramInt + " best:" + paramStrategyLib.getBestId() + " url:" + paramString + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    paramString = Utils.getDomin(paramString);
    int i = paramStrategyLib.getPort();
    paramInt = i;
    if (!Utils.isPortValid(i))
    {
      paramStrategyLib.setPort(80);
      paramInt = 80;
    }
    if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo1.id)
    {
      if ((localStrategyInfo2 != null) && (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo2.id))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return null;
      }
      QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return null;
    }
    if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo1.id)
    {
      if ((localStrategyInfo2 != null) && (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo2.id))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return null;
      }
      paramString = DnsService.getInstance().getDomainIP(paramString);
      if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDirectIP())))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
        return null;
      }
      paramStrategyLib.setDnsIP(paramString);
      paramStrategyLib = localStrategyInfo1.clone();
      paramStrategyLib.setIPInfo(new IPInfo(paramString, paramInt));
      return paramStrategyLib;
    }
    if (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo1.id)
    {
      if ((localStrategyInfo2 != null) && (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo2.id))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return null;
      }
    }
    else if ((DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == localStrategyInfo1.id) || (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo1.id))
    {
      paramString = DownloaderFactory.getContext();
      if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo1.id) {}
      for (boolean bool = true; NetworkUtil.getProxy(paramString, bool) == null; bool = false)
      {
        QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
        return null;
      }
      return localStrategyInfo1;
    }
    paramString = paramStrategyLib.getDirectIP();
    if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
    {
      QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
      return null;
    }
    paramStrategyLib = localStrategyInfo1.clone();
    paramStrategyLib.setIPInfo(new IPInfo(paramString, paramInt));
    return paramStrategyLib;
  }
  
  public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return DownloadGlobalStrategy.getInstance(DownloaderFactory.getContext()).getStrategyLib(paramString);
  }
  
  public static abstract interface RequestProcessor
  {
    public abstract void prepareRequest(String paramString, HttpRequest paramHttpRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.global.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */