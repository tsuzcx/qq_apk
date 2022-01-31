package com.qzone.download.impl;

import android.content.Context;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qzone.cache.file.FileCacheService;
import com.qzone.common.DnsService;
import com.qzone.common.IPInfo;
import com.qzone.common.NetworkStatus;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloadReport;
import com.qzone.download.DownloadRequest;
import com.qzone.download.DownloadResult;
import com.qzone.download.DownloadResult.Content;
import com.qzone.download.DownloadResult.Process;
import com.qzone.download.DownloadResult.Status;
import com.qzone.download.Downloader.NetworkFlowStatistics;
import com.qzone.download.NetworkManager;
import com.qzone.download.NetworkManager.NetStatusListener;
import com.qzone.download.strategy.IPConfigStrategy;
import com.qzone.download.strategy.PortConfigStrategy;
import com.qzone.download.strategy.global.DownloadGlobalStrategy;
import com.qzone.download.strategy.global.DownloadGlobalStrategy.StrategyInfo;
import com.qzone.download.strategy.global.DownloadGlobalStrategy.StrategyLib;
import com.qzone.download.strategy.global.ReportHandler;
import com.qzone.report.DownloadImageReport.DownloadReportObject;
import com.qzone.report.ImageDownloadReporter;
import com.qzone.statistics.SpeedStatistics;
import com.qzone.utils.AssertUtil;
import com.qzone.utils.BytesBufferPool;
import com.qzone.utils.BytesBufferPool.BytesBuffer;
import com.qzone.utils.FileUtil;
import com.qzone.utils.NetworkUtil;
import com.qzone.utils.NetworkUtil.DNS;
import com.qzone.utils.Utils;
import com.qzone.utils.http.HttpUtil;
import com.qzone.utils.http.HttpUtil.RequestOptions;
import com.qzone.utils.thread.ThreadPool.Job;
import com.qzone.utils.thread.ThreadPool.JobContext;
import com.qzone.utils.thread.ThreadPool.Priority;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

public class DownloadTask
  implements ThreadPool.Job<DownloadResult>, NetworkManager.NetStatusListener
{
  private static final int BYTESBUFFER_POOL_SIZE = 4;
  private static final int BYTESBUFFER_SIZE = 8192;
  private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(4, 8192);
  private static ImageDownloadReporter sImageDownloadReporter = new ImageDownloadReporter();
  private DownloadGlobalStrategy.StrategyInfo currStrategyInfo = null;
  private DownloadGlobalStrategy.StrategyLib downloadStrategyLib;
  private boolean mAPNProxy;
  private boolean mAllowBackupIP;
  private boolean mAllowProxy;
  private int mAttemptCurrCount = 0;
  private int mAttemptTotalCount = 1;
  private IPConfigStrategy mBackupIPConfig;
  private long mContentLength;
  private final Context mContext;
  private IPConfigStrategy mDirectIPConfig;
  private String mDomain;
  private Map<String, Object> mDownloadParams;
  private DownloadTaskHandler mDownloadTaskHandler;
  private HttpClient mHttpClient;
  private PortConfigStrategy mPortConfig;
  private ThreadPool.Priority mPriority;
  private String mRealUrl;
  private String mRefer;
  private ReportHandler mReportHandler;
  private final ThreadLocal<HttpUtil.RequestOptions> mRequestOptions = new ThreadLocal()
  {
    protected HttpUtil.RequestOptions initialValue()
    {
      return new HttpUtil.RequestOptions();
    }
  };
  private DownloaderImpl.ResumeDownloadProcessor mResumeDownloadProcessor;
  private final long mTimeStamp = SystemClock.uptimeMillis();
  private FileCacheService mTmpFileCache;
  private final String mUrl;
  private final String mUrlKey;
  private DownloadGlobalStrategy.StrategyInfo oldStrategyInfo = null;
  protected Downloader.NetworkFlowStatistics pNetworkFlowStatistics;
  private List<DownloadImageReport.DownloadReportObject> reportList = new ArrayList();
  HttpGet request = null;
  HttpResponse response = null;
  private volatile boolean shouldReport = true;
  
  public DownloadTask(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean, Map<String, Object> paramMap, DownloadTaskHandler paramDownloadTaskHandler, FileCacheService paramFileCacheService)
  {
    AssertUtil.assertTrue(DownloadRequest.checkUrl(paramString1));
    this.mContext = paramContext;
    this.mHttpClient = paramHttpClient;
    this.mUrl = paramString1;
    this.mRealUrl = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mUrlKey = paramString2;
      if (!paramBoolean) {
        break label211;
      }
    }
    label211:
    for (paramContext = ThreadPool.Priority.HIGH;; paramContext = ThreadPool.Priority.NORMAL)
    {
      setPriority(paramContext);
      this.mDownloadTaskHandler = paramDownloadTaskHandler;
      this.mDownloadParams = paramMap;
      this.mDomain = Utils.getDomin(this.mRealUrl);
      this.mTmpFileCache = paramFileCacheService;
      this.mRefer = HttpUtil.prepareRefer(this.mUrl);
      QDLog.v("downloader", "download task:" + this.mUrl + " params:" + parseParams(this.mDownloadParams));
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  private void applyKeepAliveStrategy(String paramString, HttpRequest paramHttpRequest)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleKeepAliveStrategy(paramString, paramHttpRequest);
  }
  
  private boolean canAttempt()
  {
    int i = this.mAttemptCurrCount + 1;
    this.mAttemptCurrCount = i;
    return i < this.mAttemptTotalCount;
  }
  
  private boolean ensureStorageSpace(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (TaskHelper.ensureFile(paramString, true))
        {
          this.mTmpFileCache.putFile(paramString.getName());
          if (paramLong <= 0L) {
            return true;
          }
          while (!paramString.exists()) {
            paramString = paramString.getParentFile();
          }
          paramString = new StatFs(paramString.getAbsolutePath());
          long l = paramString.getAvailableBlocks();
          int i = paramString.getBlockSize();
          if (l * i > paramLong) {
            return true;
          }
        }
      }
      catch (IOException paramString) {}
    }
    return false;
  }
  
  private void flushDownloadReport()
  {
    if (this.mReportHandler == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.reportList.iterator();
      while (localIterator.hasNext())
      {
        DownloadImageReport.DownloadReportObject localDownloadReportObject = (DownloadImageReport.DownloadReportObject)localIterator.next();
        if (((this.shouldReport) || (localDownloadReportObject.retCode == 0)) && (this.mReportHandler != null)) {
          this.mReportHandler.uploadReport(localDownloadReportObject);
        }
      }
    }
  }
  
  private String generateDownloadDescInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "{" + "1.0" + "," + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + NetworkManager.getIspType() + "}";
  }
  
  private String generateStorageName()
  {
    if (TextUtils.isEmpty(this.mUrl)) {
      return UUID.randomUUID().toString();
    }
    return String.valueOf(this.mUrl.hashCode());
  }
  
  private String generateStoragePath(String paramString)
  {
    return this.mTmpFileCache.getPath(paramString);
  }
  
  private String generateStoragePath(String paramString, boolean paramBoolean)
  {
    return this.mTmpFileCache.getPath(paramString, paramBoolean);
  }
  
  private boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    if (this.mDownloadTaskHandler == null) {
      return true;
    }
    return this.mDownloadTaskHandler.handleContentType(paramDownloadResult, paramHttpResponse);
  }
  
  private void handleDownloadParams(HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest == null) || (this.mDownloadParams == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mDownloadParams.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if ("range".equals((String)((Map.Entry)localObject).getKey()))
        {
          localObject = ((Map.Entry)localObject).getValue();
          if ((localObject != null) && ((localObject instanceof String))) {
            paramHttpRequest.addHeader("Range", "bytes=" + localObject);
          }
        }
      }
    }
  }
  
  private void handleDownloadReportForTask(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    if (this.mReportHandler != null)
    {
      DownloadImageReport.DownloadReportObject localDownloadReportObject = this.mReportHandler.obtainReportObj(paramDownloadResult, paramDownloadReport);
      this.reportList.add(localDownloadReportObject);
    }
    try
    {
      paramDownloadResult.setDetailDownloadInfo(sImageDownloadReporter.obtainReportObj(paramDownloadResult, paramDownloadReport).toJSON().toString());
      return;
    }
    catch (Throwable paramDownloadResult)
    {
      QDLog.e("downloader", "", paramDownloadResult);
    }
  }
  
  private boolean handleHeader(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    Object localObject = paramHttpResponse.getEntity();
    this.mContentLength = ((HttpEntity)localObject).getContentLength();
    paramDownloadResult.getContent().length = this.mContentLength;
    Header localHeader = ((HttpEntity)localObject).getContentType();
    if (localHeader != null) {
      paramDownloadResult.getContent().type = localHeader.getValue();
    }
    localObject = ((HttpEntity)localObject).getContentEncoding();
    if (localObject != null) {
      paramDownloadResult.getContent().encoding = ((Header)localObject).getValue();
    }
    localObject = paramHttpResponse.getAllHeaders();
    int j;
    int i;
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {}
      for (;;)
      {
        if (!paramJobContext.isCancelled()) {
          break label173;
        }
        return false;
        if (!"Client-Ip".equalsIgnoreCase(localObject[i].getName())) {
          break;
        }
        paramDownloadResult.getContent().clientip = localObject[i].getValue();
      }
      i += 1;
    }
    label173:
    localObject = paramHttpResponse.headerIterator("Cache-Control");
    if ((localObject == null) || (!((HeaderIterator)localObject).hasNext())) {}
    for (;;)
    {
      if (!paramJobContext.isCancelled()) {
        break label251;
      }
      return false;
      localHeader = ((HeaderIterator)localObject).nextHeader();
      if ((localHeader == null) || (!"no-cache".equalsIgnoreCase(localHeader.getValue()))) {
        break;
      }
      paramDownloadResult.getContent().noCache = true;
    }
    label251:
    if (!handleContentType(paramDownloadResult, paramHttpResponse))
    {
      paramDownloadResult.getStatus().setFailed(5);
      return false;
    }
    if ((this.mResumeDownloadProcessor != null) && (!this.mResumeDownloadProcessor.handleResponse(this.mUrl, paramHttpResponse)))
    {
      QDLog.i("downloader", "download 断线续传 response not valid.");
      this.mResumeDownloadProcessor.onDownloadResult(this.mUrl, true);
      return false;
    }
    return true;
  }
  
  private boolean handleResponse(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
    throws Exception
  {
    if (!handleHeader(paramHttpResponse, paramDownloadResult, paramJobContext)) {
      return false;
    }
    if (paramInt == 206) {
      if ((this.mResumeDownloadProcessor != null) && (!TextUtils.isEmpty(this.mResumeDownloadProcessor.getResumeTmpFile(this.mUrl)))) {
        paramDownloadResult.setPath(this.mResumeDownloadProcessor.getResumeTmpFile(this.mUrl));
      }
    }
    for (;;)
    {
      FileOutputStream localFileOutputStream = null;
      String str = null;
      BytesBufferPool.BytesBuffer localBytesBuffer = sBytesBufferPool.get();
      long l2 = 0L;
      long l6 = this.mContentLength;
      long l4 = System.currentTimeMillis();
      Object localObject = localFileOutputStream;
      try
      {
        File localFile = new File(paramDownloadResult.getPath());
        localObject = localFileOutputStream;
        TaskHelper.ensureFile(localFile, false);
        localObject = localFileOutputStream;
        boolean bool = paramJobContext.isCancelled();
        if (bool)
        {
          if (0 != 0) {
            throw new NullPointerException();
          }
          if (0 != 0) {
            throw new NullPointerException();
          }
          sBytesBufferPool.recycle(localBytesBuffer);
          if (this.pNetworkFlowStatistics != null) {
            this.pNetworkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), 0L, System.currentTimeMillis() - l4);
          }
          return false;
          QDLog.i("downloader", "download response 206 but tmp file not exist.");
          return false;
          if ((this.mResumeDownloadProcessor != null) && (!TextUtils.isEmpty(this.mResumeDownloadProcessor.getResumeTmpFile(this.mUrl))) && (paramInt == 200)) {
            this.mResumeDownloadProcessor.onDownloadResult(this.mUrl, true);
          }
          str = generateStorageName();
          localObject = generateStoragePath(str);
          str = generateStoragePath(str, false);
          if (ensureStorageSpace((String)localObject, this.mContentLength)) {
            paramDownloadResult.setPath((String)localObject);
          }
          for (;;)
          {
            if (paramInt == 200) {
              FileUtil.delete(new File(paramDownloadResult.getPath()));
            }
            break;
            if ((TextUtils.equals((CharSequence)localObject, str)) || (!ensureStorageSpace(str, this.mContentLength))) {
              break label353;
            }
            paramDownloadResult.setPath(str);
          }
          label353:
          paramDownloadResult.getStatus().setFailed(2);
          return false;
        }
        localObject = localFileOutputStream;
        paramHttpResponse = paramHttpResponse.getEntity().getContent();
        localObject = paramHttpResponse;
        localFileOutputStream = new FileOutputStream(localFile, true);
        l1 = l2;
        try
        {
          new ArrayList();
          l1 = l2;
          long l5 = localFile.length();
          for (;;)
          {
            l1 = l2;
            paramInt = paramHttpResponse.read(localBytesBuffer.data, 0, localBytesBuffer.data.length);
            if (paramInt <= 0)
            {
              if (l6 <= 0L)
              {
                l1 = l2;
                notifyDownloadProgress(this.mUrlKey, l6 + l5, 1.0F);
              }
              l1 = l2;
              paramDownloadResult.getContent().size = (l2 + l5);
              if (paramHttpResponse != null) {
                paramHttpResponse.close();
              }
              if (localFileOutputStream != null) {
                localFileOutputStream.close();
              }
              sBytesBufferPool.recycle(localBytesBuffer);
              if (this.pNetworkFlowStatistics != null) {
                this.pNetworkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), l2, System.currentTimeMillis() - l4);
              }
              return true;
            }
            l1 = l2;
            localFileOutputStream.write(localBytesBuffer.data, 0, paramInt);
            long l3 = l2 + paramInt;
            l1 = l3;
            paramDownloadResult.getContent().size = l3;
            l2 = l3;
            if (l6 > 0L)
            {
              l1 = l3;
              notifyDownloadProgress(this.mUrlKey, l6 + l5, (float)(l3 + l5) / (float)(l6 + l5));
              l2 = l3;
            }
          }
          if (localObject == null) {
            break label643;
          }
        }
        finally
        {
          paramDownloadResult = localFileOutputStream;
          localObject = paramHttpResponse;
        }
      }
      finally
      {
        for (;;)
        {
          long l1 = l2;
          paramDownloadResult = str;
          paramJobContext = paramHttpResponse;
        }
      }
    }
    ((InputStream)localObject).close();
    label643:
    if (paramDownloadResult != null) {
      paramDownloadResult.close();
    }
    sBytesBufferPool.recycle(localBytesBuffer);
    if (this.pNetworkFlowStatistics != null) {
      this.pNetworkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), l1, System.currentTimeMillis() - l4);
    }
    throw paramJobContext;
  }
  
  private void notifyDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
  }
  
  private String parseParams(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return "{}";
    }
    String str = "{";
    Iterator localIterator = paramMap.entrySet().iterator();
    Object localObject;
    for (paramMap = str;; paramMap = paramMap + str + ":" + localObject + ",")
    {
      if (!localIterator.hasNext()) {
        return paramMap + "}";
      }
      localObject = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
    }
  }
  
  private void prepareRequest(String paramString, HttpRequest paramHttpRequest)
  {
    handleDownloadParams(paramHttpRequest);
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handlePrepareRequest(paramString, paramHttpRequest);
  }
  
  private void setPriority(ThreadPool.Priority paramPriority)
  {
    this.mPriority = paramPriority;
  }
  
  private boolean setStrategy(int paramInt)
    throws UnknownHostException
  {
    if (this.downloadStrategyLib == null) {
      this.downloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(this.mUrl);
    }
    this.oldStrategyInfo = this.currStrategyInfo;
    this.currStrategyInfo = this.downloadStrategyLib.getStrategyInfo(paramInt);
    if (((DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.currStrategyInfo.id) && (this.mBackupIPConfig == null)) || ((DownloadGlobalStrategy.Strategy_DomainDirect.id == this.currStrategyInfo.id) && (this.mDirectIPConfig == null))) {
      return false;
    }
    QDLog.i("downloader", "downloader strategy: " + this.currStrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + this.downloadStrategyLib.getBestId() + " url:" + this.mUrl + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    this.mAllowBackupIP = this.currStrategyInfo.enableBackupIP;
    this.mAllowProxy = this.currStrategyInfo.allowProxy;
    this.mAPNProxy = this.currStrategyInfo.useConfigApn;
    String str2 = this.mDomain;
    int i = this.downloadStrategyLib.getPort();
    paramInt = i;
    if (!Utils.isPortValid(i))
    {
      this.downloadStrategyLib.setPort(80);
      paramInt = 80;
    }
    String str1;
    Object localObject;
    if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.currStrategyInfo.id)
    {
      i = paramInt;
      if (this.oldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.oldStrategyInfo.id)
        {
          if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str2))) {
            break label543;
          }
          i = this.mPortConfig.changePort(str2, paramInt);
          if ((i == paramInt) || (!Utils.isPortValid(i)))
          {
            QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            return false;
          }
        }
      }
      str1 = this.downloadStrategyLib.getBackupIP();
      localObject = str1;
      if (this.mBackupIPConfig != null)
      {
        localObject = str1;
        if (!this.mBackupIPConfig.isIPValid(str1, this.mUrl))
        {
          this.downloadStrategyLib.setBackupIP(null);
          localObject = this.mBackupIPConfig.resolve(this.mDomain);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label572;
          }
          this.downloadStrategyLib.setBackupIP((String)localObject);
        }
      }
      if ((localObject == null) || (((String)localObject).equals(this.downloadStrategyLib.getDirectIP())) || (((String)localObject).equals(this.downloadStrategyLib.getDnsIP())))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
        return false;
        label543:
        QDLog.v("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
        label572:
        QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
      }
      this.currStrategyInfo = this.currStrategyInfo.clone();
      this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
    }
    for (;;)
    {
      return true;
      if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.currStrategyInfo.id)
      {
        i = paramInt;
        if (this.oldStrategyInfo != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.oldStrategyInfo.id)
          {
            if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str2))) {
              break label847;
            }
            i = this.mPortConfig.changePort(str2, paramInt);
            if ((i == paramInt) || (!Utils.isPortValid(i)))
            {
              QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
        localObject = DnsService.getInstance().getDomainIP(str2);
        if ((localObject == null) || (((String)localObject).equals(this.downloadStrategyLib.getBackupIP())) || (((String)localObject).equals(this.downloadStrategyLib.getDirectIP())))
        {
          this.downloadStrategyLib.setDnsIP(null);
          QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          label847:
          QDLog.v("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.downloadStrategyLib.setDnsIP((String)localObject);
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      }
      else
      {
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.currStrategyInfo.id)
        {
          i = paramInt;
          if (this.oldStrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.oldStrategyInfo.id)
            {
              if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str2))) {
                break label1188;
              }
              i = this.mPortConfig.changePort(str2, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1188:
        do
        {
          str1 = this.downloadStrategyLib.getDirectIP();
          localObject = str1;
          if (this.mDirectIPConfig != null)
          {
            localObject = str1;
            if (!this.mDirectIPConfig.isIPValid(str1, str2))
            {
              this.downloadStrategyLib.setDirectIP(null);
              localObject = this.mDirectIPConfig.resolve(str2);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1320;
              }
              this.downloadStrategyLib.setDirectIP((String)localObject);
            }
          }
          if ((localObject != null) && (!((String)localObject).equals(this.downloadStrategyLib.getBackupIP())) && (!((String)localObject).equals(this.downloadStrategyLib.getDnsIP()))) {
            break label1349;
          }
          QDLog.i("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          QDLog.v("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.currStrategyInfo.id) {
            break;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.currStrategyInfo.id);
        localObject = this.mContext;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.currStrategyInfo.id) {}
        for (boolean bool = true; NetworkUtil.getProxy((Context)localObject, bool) == null; bool = false)
        {
          QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        return true;
        label1320:
        QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1349:
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject, i));
      }
    }
  }
  
  public void abort()
  {
    QDLog.i("downloader", "abort download:" + this.mUrl);
    this.shouldReport = false;
    if (this.request != null) {
      this.request.abort();
    }
  }
  
  public ThreadPool.Priority getPriority()
  {
    return this.mPriority;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public String getUrlKey()
  {
    return this.mUrlKey;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    this.shouldReport = false;
  }
  
  public DownloadResult run(ThreadPool.JobContext paramJobContext)
  {
    localDownloadResult = new DownloadResult(this.mUrl);
    if (paramJobContext.isCancelled()) {}
    Object localObject7;
    do
    {
      int i4;
      while (paramJobContext.isCancelled())
      {
        return localDownloadResult;
        paramJobContext.setMode(2);
        NetworkManager.registNetStatusListener(this);
        m = 0;
        localObject3 = "";
        localObject1 = "";
        i4 = TaskHelper.generateRandomId(new Object[] { this.mUrl, localDownloadResult });
      }
      if (!NetworkUtil.isNetworkAvailable(this.mContext))
      {
        localDownloadResult.getStatus().setFailed(3);
        localDownloadResult.setDescInfo(generateDownloadDescInfo(3, 0, m, NetworkManager.getApnValue(), (String)localObject3, "N/A", "N/A"));
        NetworkManager.unregistNetStatusListener(this);
        return localDownloadResult;
      }
      l = SystemClock.uptimeMillis();
      localDownloadReport = new DownloadReport();
      localDownloadReport.id = i4;
      localDownloadReport.url = this.mUrl;
      localDownloadReport.startTime = System.currentTimeMillis();
      this.request = null;
      this.response = null;
      i2 = 0;
      i3 = 0;
      i1 = 0;
      localStringBuilder = null;
      localObject7 = null;
      try
      {
        boolean bool = setStrategy(this.mAttemptCurrCount);
        if (bool) {
          break label386;
        }
        localObject7 = localObject1;
        localObject6 = localObject3;
        i = m;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject6;
          int i;
          Object localObject9;
          int j;
          if (localThrowable2 != null)
          {
            localObject9 = localObject3;
            i = i1;
            localObject6 = localStringBuilder;
            j = i3;
          }
          try
          {
            throw localThrowable2;
          }
          catch (Throwable localThrowable1)
          {
            localObject8 = localThrowable1;
            localObject6 = localObject8;
            j = i;
            localDownloadResult.getStatus().setFailed(localThrowable1);
            k = m + 1;
            localDownloadResult.getProcess().setDuration(l, SystemClock.uptimeMillis());
            localObject6 = NetworkStatus.getInstance(this.mContext).getDNS();
            if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
            {
              localObject3 = this.currStrategyInfo.getIPInfo().toString();
              if (localObject3 == null) {
                break label5117;
              }
              localObject2 = localObject3;
              if ((!localDownloadResult.getStatus().isSucceed()) && (this.mResumeDownloadProcessor != null)) {
                this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
              }
              if (!paramJobContext.isCancelled())
              {
                if (localDownloadResult.getStatus().isSucceed()) {
                  break label5136;
                }
                localStringBuilder = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject6).append(", remoteAddress=").append((String)localObject3).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                if (!this.mAllowProxy) {
                  break label5125;
                }
                localObject3 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                localObject3 = localStringBuilder.append(localObject3).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(i).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                if (this.currStrategyInfo == null) {
                  break label5131;
                }
                j = this.currStrategyInfo.id;
                QDLog.e("downloader", j, (Throwable)localObject8);
                if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.currStrategyInfo.id) || (this.mBackupIPConfig == null)) {}
              }
            }
          }
          finally
          {
            try
            {
              this.mBackupIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
              if ((this.mDirectIPConfig == null) || (this.mAllowBackupIP) || (this.mUrl.equals(this.mRealUrl))) {}
            }
            catch (Exception paramJobContext)
            {
              try
              {
                int k;
                this.mDirectIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                localDownloadReport.endTime = System.currentTimeMillis();
                localDownloadReport.fileSize = this.mContentLength;
                localDownloadReport.response = this.response;
                localDownloadReport.httpStatus = i;
                localDownloadReport.exception = ((Throwable)localObject8);
                if (localObject6 == null)
                {
                  localObject3 = null;
                  localDownloadReport.dns = ((String)localObject3);
                  if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                    break label5508;
                  }
                  localObject3 = this.currStrategyInfo.getIPInfo().ip;
                  localDownloadReport.remoteAddress = ((String)localObject3);
                  localDownloadReport.localAddress = "null:0";
                  localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                  localDownloadReport.t_wait = (SystemClock.uptimeMillis() - this.mTimeStamp - localDownloadResult.getProcess().duration);
                  localDownloadResult.setReport(localDownloadReport);
                  handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                  i = k;
                  localObject6 = localObject9;
                  localObject8 = localObject2;
                  if (this.request == null) {
                    continue;
                  }
                  this.request.abort();
                  i = k;
                  localObject6 = localObject9;
                  localObject8 = localObject2;
                  continue;
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  HttpUtil.RequestOptions localRequestOptions = (HttpUtil.RequestOptions)this.mRequestOptions.get();
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localRequestOptions.allowProxy = this.mAllowProxy;
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localRequestOptions.apnProxy = this.mAPNProxy;
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localDownloadReport.currAttempCount = m;
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localDownloadReport.refer = this.mRefer;
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localDownloadResult.reset();
                  localObject9 = localObject3;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  this.mRealUrl = this.mUrl;
                  localObject9 = localObject3;
                  i = i1;
                  localObject2 = localObject3;
                  localObject6 = localStringBuilder;
                  j = i3;
                  if (this.currStrategyInfo != null)
                  {
                    localObject9 = localObject3;
                    i = i1;
                    localObject2 = localObject3;
                    localObject6 = localStringBuilder;
                    j = i3;
                    if (this.currStrategyInfo.getIPInfo() != null)
                    {
                      localObject9 = localObject3;
                      i = i1;
                      localObject2 = localObject3;
                      localObject6 = localStringBuilder;
                      j = i3;
                      if (!TextUtils.isEmpty(this.currStrategyInfo.getIPInfo().ip))
                      {
                        localObject9 = localObject3;
                        i = i1;
                        localObject6 = localStringBuilder;
                        j = i3;
                        String str3 = this.currStrategyInfo.getIPInfo().ip;
                        localObject9 = localObject3;
                        i = i1;
                        localObject6 = localStringBuilder;
                        j = i3;
                        localObject8 = Utils.getDominWithPort(this.mRealUrl);
                        localObject2 = localObject8;
                        localObject9 = localObject3;
                        i = i1;
                        localObject6 = localStringBuilder;
                        j = i3;
                        if (Utils.count(str3, ':') < 2)
                        {
                          localObject9 = localObject3;
                          i = i1;
                          localObject6 = localStringBuilder;
                          j = i3;
                          k = Utils.getPort(this.mUrl);
                          if (k <= 0) {
                            break label3037;
                          }
                          localObject9 = localObject3;
                          i = i1;
                          localObject6 = localStringBuilder;
                          j = i3;
                          this.currStrategyInfo.getIPInfo().port = k;
                          localObject9 = localObject3;
                          i = i1;
                          n = k;
                          localObject6 = localStringBuilder;
                          j = i3;
                          if (!Utils.isPortValid(k)) {
                            n = 80;
                          }
                          localObject9 = localObject3;
                          i = i1;
                          localObject6 = localStringBuilder;
                          j = i3;
                          localObject2 = str3 + ":" + n;
                          localObject9 = localObject3;
                          i = i1;
                          localObject6 = localStringBuilder;
                          j = i3;
                          this.mRealUrl = this.mRealUrl.replaceFirst((String)localObject8, (String)localObject2);
                        }
                        localObject9 = localObject3;
                        i = i1;
                        localObject6 = localStringBuilder;
                        j = i3;
                        QDLog.i("downloader", "downloader strategy run: " + this.currStrategyInfo.toString() + " domain:" + (String)localObject2 + " url:" + this.mUrl + " threadId:" + Thread.currentThread().getId());
                        localObject9 = localObject3;
                        i = i1;
                        localObject6 = localStringBuilder;
                        j = i3;
                        localObject2 = localObject3 + "-" + this.currStrategyInfo.id;
                      }
                    }
                  }
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  if (this.currStrategyInfo != null)
                  {
                    localObject9 = localObject2;
                    i = i1;
                    localObject6 = localStringBuilder;
                    j = i3;
                    localDownloadReport.strategyInfo = this.currStrategyInfo.toString();
                  }
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localDownloadReport.url = this.mUrl;
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localDownloadReport.domain = this.mDomain;
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  this.request = HttpUtil.createHttpGet(this.mContext, this.mUrl, this.mRealUrl, this.mRefer, localRequestOptions);
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  if (this.mResumeDownloadProcessor != null)
                  {
                    localObject9 = localObject2;
                    i = i1;
                    localObject6 = localStringBuilder;
                    j = i3;
                    this.mResumeDownloadProcessor.prepareRequest(this.request, this.mUrl);
                  }
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  prepareRequest(this.mUrl, this.request);
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  applyKeepAliveStrategy(this.mUrl, this.request);
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  localObject3 = HttpUtil.createHttpContext();
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  this.response = this.mHttpClient.execute(this.request, (HttpContext)localObject3);
                  localObject9 = localObject2;
                  i = i1;
                  localObject6 = localStringBuilder;
                  j = i3;
                  if (this.response != null)
                  {
                    localObject9 = localObject2;
                    i = i1;
                    localObject6 = localStringBuilder;
                    j = i3;
                    k = this.response.getStatusLine().getStatusCode();
                    localObject9 = localObject2;
                    i = k;
                    localObject6 = localStringBuilder;
                    j = k;
                    localDownloadResult.getStatus().httpStatus = k;
                    if ((200 == k) || (206 == k))
                    {
                      localObject9 = localObject2;
                      i = k;
                      n = k;
                      localObject6 = localStringBuilder;
                      j = k;
                      if (handleResponse(this.response, localDownloadResult, paramJobContext, k))
                      {
                        localObject9 = localObject2;
                        i = k;
                        localObject6 = localStringBuilder;
                        j = k;
                        localDownloadResult.getStatus().setSucceed();
                        j = m + 1;
                        localDownloadResult.getProcess().setDuration(l, SystemClock.uptimeMillis());
                        localObject8 = NetworkStatus.getInstance(this.mContext).getDNS();
                        if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
                        {
                          localObject6 = this.currStrategyInfo.getIPInfo().toString();
                          if (localObject6 == null) {
                            break label3074;
                          }
                          localObject3 = localObject6;
                          if ((!localDownloadResult.getStatus().isSucceed()) && (this.mResumeDownloadProcessor != null)) {
                            this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                          }
                          if (!paramJobContext.isCancelled())
                          {
                            if (localDownloadResult.getStatus().isSucceed()) {
                              break label3092;
                            }
                            localObject6 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject6).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                            if (!this.mAllowProxy) {
                              break label3082;
                            }
                            paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                            paramJobContext = ((StringBuilder)localObject6).append(paramJobContext).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(k).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                            if (this.currStrategyInfo == null) {
                              break label3087;
                            }
                            i = this.currStrategyInfo.id;
                            QDLog.e("downloader", i, null);
                            if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.currStrategyInfo.id) || (this.mBackupIPConfig == null)) {}
                          }
                        }
                        try
                        {
                          this.mBackupIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                          if ((this.mDirectIPConfig == null) || (this.mAllowBackupIP) || (this.mUrl.equals(this.mRealUrl))) {}
                        }
                        catch (Exception paramJobContext)
                        {
                          try
                          {
                            this.mDirectIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                            localDownloadReport.endTime = System.currentTimeMillis();
                            localDownloadReport.fileSize = this.mContentLength;
                            localDownloadReport.response = this.response;
                            localDownloadReport.httpStatus = k;
                            localDownloadReport.exception = null;
                            if (localObject8 == null)
                            {
                              paramJobContext = null;
                              localDownloadReport.dns = paramJobContext;
                              if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                                break label3455;
                              }
                              paramJobContext = this.currStrategyInfo.getIPInfo().ip;
                              localDownloadReport.remoteAddress = paramJobContext;
                              localDownloadReport.localAddress = "null:0";
                              localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                              localDownloadReport.t_wait = (SystemClock.uptimeMillis() - this.mTimeStamp - localDownloadResult.getProcess().duration);
                              localDownloadResult.setReport(localDownloadReport);
                              handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                              i = j;
                              localObject6 = localObject2;
                              localObject8 = localObject3;
                              if (this.request == null) {
                                continue;
                              }
                              this.request.abort();
                              i = j;
                              localObject6 = localObject2;
                              localObject8 = localObject3;
                              continue;
                              localObject9 = localObject3;
                              i = i1;
                              localObject6 = localStringBuilder;
                              j = i3;
                              k = this.currStrategyInfo.getIPInfo().port;
                              break label1595;
                              localObject6 = "null:0";
                              break label2318;
                              localObject3 = "N/A";
                              break label2327;
                              paramJobContext = null;
                              break label2518;
                              i = 0;
                              break label2739;
                              localObject6 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject6).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                              if (this.mAllowProxy)
                              {
                                paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                                paramJobContext = ((StringBuilder)localObject6).append(paramJobContext).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", httpStatus=").append(k).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                                if (this.currStrategyInfo == null) {
                                  break label3415;
                                }
                              }
                              for (i = this.currStrategyInfo.id;; i = 0)
                              {
                                QDLog.i("downloader", i);
                                break;
                                paramJobContext = null;
                                break label3223;
                              }
                              paramJobContext = paramJobContext;
                              QDLog.i("downloader", "", paramJobContext);
                            }
                          }
                          catch (Exception paramJobContext)
                          {
                            for (;;)
                            {
                              QDLog.i("downloader", "", paramJobContext);
                              continue;
                              paramJobContext = ((NetworkUtil.DNS)localObject8).toString();
                              continue;
                              paramJobContext = "null";
                            }
                          }
                        }
                      }
                    }
                    else
                    {
                      localObject9 = localObject2;
                      i = k;
                      localObject6 = localStringBuilder;
                      j = k;
                      localDownloadResult.getStatus().setFailed(3);
                      localObject9 = localObject2;
                      i = k;
                      n = k;
                      localObject6 = localStringBuilder;
                      j = k;
                      if (this.mResumeDownloadProcessor != null)
                      {
                        localObject9 = localObject2;
                        i = k;
                        localObject6 = localStringBuilder;
                        j = k;
                        this.mResumeDownloadProcessor.onDownloadResult(this.mUrl, true);
                        n = k;
                      }
                    }
                    j = m + 1;
                    localDownloadResult.getProcess().setDuration(l, SystemClock.uptimeMillis());
                    localObject8 = NetworkStatus.getInstance(this.mContext).getDNS();
                    if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                      break label5906;
                    }
                    localObject6 = this.currStrategyInfo.getIPInfo().toString();
                    if (localObject6 == null) {
                      break label5914;
                    }
                    localObject3 = localObject6;
                    if ((!localDownloadResult.getStatus().isSucceed()) && (this.mResumeDownloadProcessor != null)) {
                      this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                    }
                    if (!paramJobContext.isCancelled())
                    {
                      if (localDownloadResult.getStatus().isSucceed()) {
                        break label5933;
                      }
                      localObject9 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject6).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                      if (!this.mAllowProxy) {
                        break label5922;
                      }
                      localObject6 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                      localObject6 = ((StringBuilder)localObject9).append(localObject6).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(n).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                      if (this.currStrategyInfo == null) {
                        break label5928;
                      }
                      i = this.currStrategyInfo.id;
                      QDLog.e("downloader", i, null);
                      if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.currStrategyInfo.id) || (this.mBackupIPConfig == null)) {}
                    }
                  }
                }
              }
              catch (Exception localException3)
              {
                try
                {
                  this.mBackupIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                  if ((this.mDirectIPConfig == null) || (this.mAllowBackupIP) || (this.mUrl.equals(this.mRealUrl))) {}
                }
                catch (Exception localException3)
                {
                  try
                  {
                    int n;
                    for (;;)
                    {
                      Object localObject2;
                      this.mDirectIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                      localDownloadReport.endTime = System.currentTimeMillis();
                      localDownloadReport.fileSize = this.mContentLength;
                      localDownloadReport.response = this.response;
                      localDownloadReport.httpStatus = n;
                      localDownloadReport.exception = null;
                      if (localObject8 != null) {
                        break label6296;
                      }
                      localObject6 = null;
                      localDownloadReport.dns = ((String)localObject6);
                      if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                        break label6306;
                      }
                      localObject6 = this.currStrategyInfo.getIPInfo().ip;
                      localDownloadReport.remoteAddress = ((String)localObject6);
                      localDownloadReport.localAddress = "null:0";
                      localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                      localDownloadReport.t_wait = (SystemClock.uptimeMillis() - this.mTimeStamp - localDownloadResult.getProcess().duration);
                      localDownloadResult.setReport(localDownloadReport);
                      handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                      i = j;
                      localObject6 = localObject2;
                      localObject8 = localObject3;
                      if (this.request == null) {
                        break;
                      }
                      this.request.abort();
                      i = j;
                      localObject6 = localObject2;
                      localObject8 = localObject3;
                      break;
                      localObject9 = localObject2;
                      i = i1;
                      localObject6 = localStringBuilder;
                      j = i3;
                      localDownloadResult.getStatus().setFailed(3);
                      n = i2;
                      continue;
                      localObject4 = finally;
                      localDownloadResult.getProcess().setDuration(l, SystemClock.uptimeMillis());
                      localObject8 = NetworkStatus.getInstance(this.mContext).getDNS();
                      if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
                      {
                        localObject2 = this.currStrategyInfo.getIPInfo().toString();
                        if (localObject2 == null) {
                          break label5524;
                        }
                        if ((!localDownloadResult.getStatus().isSucceed()) && (this.mResumeDownloadProcessor != null)) {
                          this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                        }
                        if (!paramJobContext.isCancelled())
                        {
                          if (localDownloadResult.getStatus().isSucceed()) {
                            break label5537;
                          }
                          localObject2 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject2).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                          if (!this.mAllowProxy) {
                            break label5527;
                          }
                          paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                          paramJobContext = ((StringBuilder)localObject2).append(paramJobContext).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(j).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                          if (this.currStrategyInfo == null) {
                            break label5532;
                          }
                          i = this.currStrategyInfo.id;
                          QDLog.e("downloader", i, (Throwable)localObject6);
                          if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.currStrategyInfo.id) || (this.mBackupIPConfig == null)) {}
                        }
                      }
                      try
                      {
                        this.mBackupIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                        if ((this.mDirectIPConfig == null) || (this.mAllowBackupIP) || (this.mUrl.equals(this.mRealUrl))) {}
                      }
                      catch (Exception paramJobContext)
                      {
                        try
                        {
                          this.mDirectIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
                          localDownloadReport.endTime = System.currentTimeMillis();
                          localDownloadReport.fileSize = this.mContentLength;
                          localDownloadReport.response = this.response;
                          localDownloadReport.httpStatus = j;
                          localDownloadReport.exception = ((Throwable)localObject6);
                          if (localObject8 == null)
                          {
                            paramJobContext = null;
                            localDownloadReport.dns = paramJobContext;
                            if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                              break label5899;
                            }
                            paramJobContext = this.currStrategyInfo.getIPInfo().ip;
                            localDownloadReport.remoteAddress = paramJobContext;
                            localDownloadReport.localAddress = "null:0";
                            localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                            localDownloadReport.t_wait = (SystemClock.uptimeMillis() - this.mTimeStamp - localDownloadResult.getProcess().duration);
                            localDownloadResult.setReport(localDownloadReport);
                            handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                            if (this.request != null) {
                              this.request.abort();
                            }
                            throw localObject4;
                            Object localObject5 = "null:0";
                            continue;
                            localObject2 = "N/A";
                            continue;
                            localObject5 = null;
                            continue;
                            j = 0;
                            continue;
                            localStringBuilder = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject6).append(", remoteAddress=").append((String)localObject5).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                            if (this.mAllowProxy)
                            {
                              localObject5 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                              localObject5 = localStringBuilder.append(localObject5).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", httpStatus=").append(i).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                              if (this.currStrategyInfo == null) {
                                break label5463;
                              }
                            }
                            for (j = this.currStrategyInfo.id;; j = 0)
                            {
                              QDLog.i("downloader", j);
                              break;
                              localObject5 = null;
                              break label5268;
                            }
                            localException1 = localException1;
                            QDLog.i("downloader", "", localException1);
                            continue;
                            localException2 = localException2;
                            QDLog.i("downloader", "", localException2);
                            continue;
                            str1 = ((NetworkUtil.DNS)localObject6).toString();
                            continue;
                            str1 = "null";
                            continue;
                            localObject2 = "null:0";
                            break label4414;
                            break label4419;
                            paramJobContext = null;
                            break label4610;
                            i = 0;
                            break label4830;
                            localObject2 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject2).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                            if (this.mAllowProxy)
                            {
                              paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                              paramJobContext = ((StringBuilder)localObject2).append(paramJobContext).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", httpStatus=").append(j).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                              if (this.currStrategyInfo == null) {
                                break label5859;
                              }
                            }
                            for (i = this.currStrategyInfo.id;; i = 0)
                            {
                              QDLog.i("downloader", i);
                              break;
                              paramJobContext = null;
                              break label5668;
                            }
                            paramJobContext = paramJobContext;
                            QDLog.i("downloader", "", paramJobContext);
                          }
                        }
                        catch (Exception paramJobContext)
                        {
                          for (;;)
                          {
                            QDLog.i("downloader", "", paramJobContext);
                            continue;
                            paramJobContext = ((NetworkUtil.DNS)localObject8).toString();
                            continue;
                            paramJobContext = "null";
                          }
                        }
                      }
                      localObject6 = "null:0";
                      continue;
                      String str1 = "N/A";
                      continue;
                      localObject6 = null;
                      continue;
                      i = 0;
                    }
                    localObject9 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject8).append(", remoteAddress=").append((String)localObject6).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                    if (this.mAllowProxy)
                    {
                      localObject6 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                      localObject6 = ((StringBuilder)localObject9).append(localObject6).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", httpStatus=").append(n).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                      if (this.currStrategyInfo == null) {
                        break label6261;
                      }
                    }
                    for (i = this.currStrategyInfo.id;; i = 0)
                    {
                      QDLog.i("downloader", i);
                      break;
                      localObject6 = null;
                      break label6065;
                    }
                    localException3 = localException3;
                    QDLog.i("downloader", "", localException3);
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Object localObject8;
                      QDLog.i("downloader", "", localException4);
                      continue;
                      String str2 = ((NetworkUtil.DNS)localObject8).toString();
                      continue;
                      str2 = "null";
                    }
                  }
                }
              }
            }
          }
          if ((this.downloadStrategyLib != null) && (this.downloadStrategyLib.getBestStrategy() != null))
          {
            DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.downloadStrategyLib.getBestStrategy(), localDownloadResult.getStatus().isSucceed());
            continue;
            if (!NetworkUtil.isNetworkAvailable(this.mContext)) {
              localDownloadResult.getStatus().setFailed(3);
            }
          }
        }
      }
      m = i;
      localObject3 = localObject6;
      Object localObject1 = localObject7;
    } while (canAttempt());
    try
    {
      flushDownloadReport();
      if (localDownloadResult.getStatus().isSucceed())
      {
        DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.currStrategyInfo, localDownloadResult.getStatus().isSucceed());
        if (!localDownloadResult.getStatus().isSucceed()) {
          break label6367;
        }
        SpeedStatistics.getInstance().report(localDownloadResult.getContent().size, localDownloadResult.getProcess().startTime, localDownloadResult.getProcess().endTime);
        NetworkManager.unregistNetStatusListener(this);
        localDownloadResult.setDescInfo(generateDownloadDescInfo(localDownloadResult.getStatus().getFailReason(), localDownloadResult.getStatus().httpStatus, i, NetworkManager.getApnValue(), (String)localObject6, localDownloadResult.getContent().type, localObject7));
        return localDownloadResult;
      }
    }
    catch (Throwable paramJobContext)
    {
      QDLog.e("downloader", "", paramJobContext);
      return localDownloadResult;
    }
  }
  
  public void setAttemptCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.mAttemptTotalCount = i;
  }
  
  public void setTaskHandler(ReportHandler paramReportHandler, IPConfigStrategy paramIPConfigStrategy1, IPConfigStrategy paramIPConfigStrategy2, PortConfigStrategy paramPortConfigStrategy, DownloaderImpl.ResumeDownloadProcessor paramResumeDownloadProcessor)
  {
    this.mReportHandler = paramReportHandler;
    this.mDirectIPConfig = paramIPConfigStrategy1;
    this.mBackupIPConfig = paramIPConfigStrategy2;
    this.mPortConfig = paramPortConfigStrategy;
    this.mResumeDownloadProcessor = paramResumeDownloadProcessor;
    if ((this.mDownloadParams != null) && (this.mDownloadParams.containsKey("range"))) {
      this.mResumeDownloadProcessor = null;
    }
  }
  
  public static abstract interface DownloadTaskHandler
  {
    public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
    
    public abstract void handleDownloadProgress(String paramString, long paramLong, float paramFloat);
    
    public abstract void handleKeepAliveStrategy(String paramString, HttpRequest paramHttpRequest);
    
    public abstract void handlePrepareRequest(String paramString, HttpRequest paramHttpRequest);
    
    public abstract void handleTaskAbort(String paramString);
  }
  
  static final class TaskHelper
  {
    private static final Random sRandom = new Random();
    
    public static boolean ensureFile(File paramFile, boolean paramBoolean)
      throws IOException
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramFile == null) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        try
        {
          File localFile = paramFile.getParentFile();
          if ((localFile.exists()) && (localFile.isFile())) {
            FileUtil.delete(localFile);
          }
          if (!localFile.exists())
          {
            bool1 = bool2;
            if (!localFile.mkdirs()) {
              continue;
            }
          }
          if ((paramBoolean) && (paramFile.exists())) {
            FileUtil.delete(paramFile);
          }
          if (!paramFile.exists())
          {
            paramBoolean = paramFile.createNewFile();
            bool1 = bool2;
            if (!paramBoolean) {
              continue;
            }
          }
          bool1 = true;
        }
        finally {}
      }
    }
    
    public static String generateAddressIP(HttpContext paramHttpContext, boolean paramBoolean)
    {
      if (paramHttpContext == null) {}
      while (0 == 0) {
        return null;
      }
      throw new NullPointerException();
    }
    
    public static String generateAddressInfo(HttpContext paramHttpContext, boolean paramBoolean)
    {
      if (paramHttpContext == null) {
        return null;
      }
      if (0 == 0) {
        return null + ":" + Integer.valueOf(0);
      }
      throw new NullPointerException();
    }
    
    public static int generateRandomId(Object... paramVarArgs)
    {
      int i = 17;
      int j = i;
      if (paramVarArgs != null)
      {
        int k = paramVarArgs.length;
        j = 0;
        if (j >= k) {
          j = i;
        }
      }
      else
      {
        return j * 31 + sRandom.nextInt();
      }
      Object localObject = paramVarArgs[j];
      if (localObject == null) {}
      for (;;)
      {
        j += 1;
        break;
        i = i * 31 + localObject.hashCode();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.DownloadTask
 * JD-Core Version:    0.7.0.1
 */