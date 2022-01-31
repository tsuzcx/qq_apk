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
import com.qzone.utils.thread.ThreadPool.JobContext;
import com.qzone.utils.thread.ThreadPool.Priority;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

public class DownloadStrictTask
  extends DownloadTask
{
  private static final int BYTESBUFFER_POOL_SIZE = 4;
  private static final int BYTESBUFFER_SIZE = 8192;
  private static final Object Extra_Lock = new Object();
  private static final int TIMEOUT_NO_NETWORK = 480000;
  private static List<DownloadGlobalStrategy.StrategyInfo> extraStrategys;
  private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(4, 8192);
  private static ImageDownloadReporter sImageDownloadReporter = new ImageDownloadReporter();
  private int ISP_COUNT = 4;
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
  private DownloadTask.DownloadTaskHandler mDownloadTaskHandler;
  private HttpClient mHttpClient;
  private PortConfigStrategy mPortConfig;
  private ThreadPool.Priority mPriority;
  private String mRealUrl;
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
  private int[] triedIsp = new int[this.ISP_COUNT];
  
  public DownloadStrictTask(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean, Map<String, Object> paramMap, DownloadTask.DownloadTaskHandler paramDownloadTaskHandler, FileCacheService paramFileCacheService)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean, paramMap, paramDownloadTaskHandler, paramFileCacheService);
    AssertUtil.assertTrue(DownloadRequest.checkUrl(paramString1));
    this.mContext = paramContext;
    this.mHttpClient = paramHttpClient;
    this.mUrl = paramString1;
    this.mRealUrl = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mUrlKey = paramString2;
      if (!paramBoolean) {
        break label188;
      }
    }
    label188:
    for (paramContext = ThreadPool.Priority.HIGH;; paramContext = ThreadPool.Priority.NORMAL)
    {
      setPriority(paramContext);
      this.mDownloadTaskHandler = paramDownloadTaskHandler;
      this.mDownloadParams = paramMap;
      this.mDomain = Utils.getDomin(this.mRealUrl);
      this.mTmpFileCache = paramFileCacheService;
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  private void addTriedIsp(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.ISP_COUNT)) {
      return;
    }
    this.triedIsp[(paramInt - 1)] = 1;
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
        if (DownloadTask.TaskHelper.ensureFile(paramString, true))
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
    return "{" + "1.1" + "," + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + NetworkManager.getIspType() + "," + NetworkUtil.isNetworkAvailable(this.mContext) + "}";
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
  
  private int getXErrorCode(HttpResponse paramHttpResponse)
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
      Object localObject2 = null;
      String str = null;
      BytesBufferPool.BytesBuffer localBytesBuffer = sBytesBufferPool.get();
      long l2 = 0L;
      long l5 = this.mContentLength;
      long l4 = System.currentTimeMillis();
      Object localObject1 = localObject2;
      try
      {
        File localFile = new File(paramDownloadResult.getPath());
        localObject1 = localObject2;
        DownloadTask.TaskHelper.ensureFile(localFile, false);
        localObject1 = localObject2;
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
          localObject1 = generateStoragePath(str);
          str = generateStoragePath(str, false);
          if (ensureStorageSpace((String)localObject1, this.mContentLength)) {
            paramDownloadResult.setPath((String)localObject1);
          }
          for (;;)
          {
            if (paramInt == 200) {
              FileUtil.delete(new File(paramDownloadResult.getPath()));
            }
            break;
            if ((TextUtils.equals((CharSequence)localObject1, str)) || (!ensureStorageSpace(str, this.mContentLength))) {
              break label354;
            }
            paramDownloadResult.setPath(str);
          }
          label354:
          paramDownloadResult.getStatus().setFailed(2);
          return false;
        }
        localObject1 = localObject2;
        paramHttpResponse = paramHttpResponse.getEntity().getContent();
        localObject1 = paramHttpResponse;
        paramJobContext = new FileOutputStream(localFile, true);
        l1 = l2;
        try
        {
          new ArrayList();
          l1 = l2;
          long l6 = localFile.length();
          for (;;)
          {
            l1 = l2;
            paramInt = paramHttpResponse.read(localBytesBuffer.data, 0, localBytesBuffer.data.length);
            if (paramInt <= 0)
            {
              if (l5 <= 0L)
              {
                l1 = l2;
                notifyDownloadProgress(this.mUrlKey, l5 + l6, 1.0F);
              }
              l1 = l2;
              paramDownloadResult.getContent().size = (l2 + l6);
              if (paramHttpResponse != null) {
                paramHttpResponse.close();
              }
              if (paramJobContext != null) {
                paramJobContext.close();
              }
              sBytesBufferPool.recycle(localBytesBuffer);
              if (this.pNetworkFlowStatistics != null) {
                this.pNetworkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), l2, System.currentTimeMillis() - l4);
              }
              return true;
            }
            l1 = l2;
            paramJobContext.write(localBytesBuffer.data, 0, paramInt);
            long l3 = l2 + paramInt;
            l1 = l3;
            paramDownloadResult.getContent().size = l3;
            l2 = l3;
            if (l5 > 0L)
            {
              l1 = l3;
              notifyDownloadProgress(this.mUrlKey, l5 + l6, (float)(l3 + l6) / (float)(l5 + l6));
              l2 = l3;
            }
          }
          if (paramHttpResponse == null) {
            break label632;
          }
        }
        finally {}
      }
      finally
      {
        for (;;)
        {
          long l1 = l2;
          paramHttpResponse = (HttpResponse)localObject1;
          paramJobContext = str;
        }
      }
    }
    paramHttpResponse.close();
    label632:
    if (paramJobContext != null) {
      paramJobContext.close();
    }
    sBytesBufferPool.recycle(localBytesBuffer);
    if (this.pNetworkFlowStatistics != null) {
      this.pNetworkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), l1, System.currentTimeMillis() - l4);
    }
    throw paramDownloadResult;
  }
  
  private void initExtraStrategy()
  {
    if (extraStrategys == null) {
      synchronized (Extra_Lock)
      {
        if (extraStrategys == null)
        {
          extraStrategys = new ArrayList();
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
          localStrategyInfo1.id = 6;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
          localStrategyInfo2.id = 7;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
          localStrategyInfo3.id = 8;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo4 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
          localStrategyInfo4.id = 9;
          extraStrategys.add(localStrategyInfo1);
          extraStrategys.add(localStrategyInfo2);
          extraStrategys.add(localStrategyInfo3);
          extraStrategys.add(localStrategyInfo4);
        }
        return;
      }
    }
  }
  
  private void notifyDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.mDownloadTaskHandler == null) {
      return;
    }
    this.mDownloadTaskHandler.handleDownloadProgress(paramString, paramLong, paramFloat);
  }
  
  private int obtainUntriedIsp()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.ISP_COUNT) {
        return 0;
      }
      if (this.triedIsp[i] == 0)
      {
        this.triedIsp[i] = 1;
        return i + 1;
      }
      i += 1;
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
    throws Exception
  {
    if (this.downloadStrategyLib == null)
    {
      this.downloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(this.mUrl);
      initExtraStrategy();
      this.downloadStrategyLib.copyStrageList();
      this.downloadStrategyLib.enableUpdate(false);
      this.downloadStrategyLib.addStrategy(extraStrategys);
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
    String str = this.mDomain;
    int i = this.downloadStrategyLib.getPort();
    paramInt = i;
    if (!Utils.isPortValid(i))
    {
      this.downloadStrategyLib.setPort(80);
      paramInt = 80;
    }
    Object localObject2;
    Object localObject1;
    if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.currStrategyInfo.id)
    {
      i = paramInt;
      if (this.oldStrategyInfo != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.oldStrategyInfo.id)
        {
          if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str))) {
            break label575;
          }
          i = this.mPortConfig.changePort(str, paramInt);
          if ((i == paramInt) || (!Utils.isPortValid(i)))
          {
            QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            return false;
          }
        }
      }
      localObject2 = this.downloadStrategyLib.getBackupIP();
      localObject1 = localObject2;
      if (this.mBackupIPConfig != null)
      {
        localObject1 = localObject2;
        if (!this.mBackupIPConfig.isIPValid((String)localObject2, this.mUrl))
        {
          this.downloadStrategyLib.setBackupIP(null);
          localObject1 = this.mBackupIPConfig.resolve(this.mDomain);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label605;
          }
          this.downloadStrategyLib.setBackupIP((String)localObject1);
        }
      }
      if ((localObject1 == null) || (((String)localObject1).equals(this.downloadStrategyLib.getDirectIP())) || (((String)localObject1).equals(this.downloadStrategyLib.getDnsIP())))
      {
        QDLog.i("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
        return false;
        label575:
        QDLog.v("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
        label605:
        QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
      }
      this.currStrategyInfo = this.currStrategyInfo.clone();
      this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
    }
    for (;;)
    {
      addTriedIsp(NetworkManager.getIspType());
      return true;
      if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.currStrategyInfo.id)
      {
        i = paramInt;
        if (this.oldStrategyInfo != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.oldStrategyInfo.id)
          {
            if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str))) {
              break label890;
            }
            i = this.mPortConfig.changePort(str, paramInt);
            if ((i == paramInt) || (!Utils.isPortValid(i)))
            {
              QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              return false;
            }
          }
        }
        localObject1 = DnsService.getInstance().getDomainIP(str);
        if ((localObject1 == null) || (((String)localObject1).equals(this.downloadStrategyLib.getBackupIP())) || (((String)localObject1).equals(this.downloadStrategyLib.getDirectIP())))
        {
          this.downloadStrategyLib.setDnsIP(null);
          QDLog.i("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          label890:
          QDLog.v("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.downloadStrategyLib.setDnsIP((String)localObject1);
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
      }
      else if (6 == this.currStrategyInfo.id)
      {
        localObject1 = null;
        if (this.mDirectIPConfig != null)
        {
          localObject2 = this.mDirectIPConfig.resolve(this.mDomain);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = DnsService.getInstance().getDomainIP(str);
          }
        }
        if (localObject1 == null)
        {
          QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject1, 80));
      }
      else if (7 == this.currStrategyInfo.id)
      {
        localObject1 = null;
        if (this.mBackupIPConfig != null)
        {
          localObject2 = this.mBackupIPConfig.resolve(this.mDomain);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = DnsService.getInstance().getDomainIP(str);
          }
        }
        if (localObject1 == null)
        {
          QDLog.i("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject1, 80));
      }
      else if (8 == this.currStrategyInfo.id)
      {
        localObject1 = null;
        paramInt = obtainUntriedIsp();
        if (paramInt == 0) {}
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = DnsService.getInstance().getDomainIP(str);
          }
          if (localObject2 != null) {
            break label1330;
          }
          QDLog.i("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
          return false;
          localObject2 = localObject1;
          if (this.mDirectIPConfig != null) {
            localObject2 = this.mDirectIPConfig.resolve(this.mDomain, paramInt);
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = localObject2;
        }
        label1330:
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject2, 80));
      }
      else if (9 == this.currStrategyInfo.id)
      {
        localObject1 = null;
        paramInt = obtainUntriedIsp();
        if (paramInt == 0) {}
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = DnsService.getInstance().getDomainIP(str);
          }
          if (localObject2 != null) {
            break label1484;
          }
          QDLog.i("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
          return false;
          localObject2 = localObject1;
          if (this.mDirectIPConfig != null) {
            localObject2 = this.mDirectIPConfig.resolve(this.mDomain, paramInt);
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = localObject2;
        }
        label1484:
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject2, 80));
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
              if ((this.mPortConfig == null) || (!this.mPortConfig.supportExtraPort(str))) {
                break label1790;
              }
              i = this.mPortConfig.changePort(str, paramInt);
              if ((i == paramInt) || (!Utils.isPortValid(i)))
              {
                QDLog.v("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1790:
        do
        {
          localObject2 = this.downloadStrategyLib.getDirectIP();
          localObject1 = localObject2;
          if (this.mDirectIPConfig != null)
          {
            localObject1 = localObject2;
            if (!this.mDirectIPConfig.isIPValid((String)localObject2, str))
            {
              this.downloadStrategyLib.setDirectIP(null);
              localObject1 = this.mDirectIPConfig.resolve(str);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1924;
              }
              this.downloadStrategyLib.setDirectIP((String)localObject1);
            }
          }
          if ((localObject1 != null) && (!((String)localObject1).equals(this.downloadStrategyLib.getBackupIP())) && (!((String)localObject1).equals(this.downloadStrategyLib.getDnsIP()))) {
            break label1954;
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
        localObject1 = this.mContext;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.currStrategyInfo.id) {}
        for (boolean bool = true; NetworkUtil.getProxy((Context)localObject1, bool) == null; bool = false)
        {
          QDLog.i("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        return true;
        label1924:
        QDLog.i("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1954:
        this.currStrategyInfo = this.currStrategyInfo.clone();
        this.currStrategyInfo.setIPInfo(new IPInfo((String)localObject1, i));
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
    DownloadResult localDownloadResult = new DownloadResult(this.mUrl);
    if (paramJobContext.isCancelled()) {}
    int k;
    Object localObject3;
    Object localObject1;
    int i4;
    long l1;
    do
    {
      return localDownloadResult;
      paramJobContext.setMode(2);
      NetworkManager.registNetStatusListener(this);
      k = 0;
      localObject3 = "";
      localObject1 = "";
      i4 = DownloadTask.TaskHelper.generateRandomId(new Object[] { this.mUrl, localDownloadResult });
      l1 = SystemClock.uptimeMillis();
    } while (paramJobContext.isCancelled());
    label85:
    Object localObject6;
    int i;
    Object localObject8;
    if ((NetworkUtil.isNetworkAvailable(this.mContext)) || (SystemClock.uptimeMillis() - l1 > 480000L))
    {
      if (SystemClock.uptimeMillis() - l1 <= 480000L) {
        break label323;
      }
      localObject6 = localObject3;
      i = k;
      localObject8 = localObject1;
    }
    for (;;)
    {
      label323:
      long l2;
      DownloadReport localDownloadReport;
      int i2;
      int i3;
      int i1;
      StringBuilder localStringBuilder;
      Object localObject7;
      for (;;)
      {
        for (;;)
        {
          try
          {
            flushDownloadReport();
            if (!localDownloadResult.getStatus().isSucceed()) {
              break label6600;
            }
            if ((this.currStrategyInfo != null) && (this.currStrategyInfo.id >= 1) && (this.currStrategyInfo.id <= 5)) {
              DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.currStrategyInfo, localDownloadResult.getStatus().isSucceed());
            }
            if (!localDownloadResult.getStatus().isSucceed()) {
              break label6653;
            }
            SpeedStatistics.getInstance().report(localDownloadResult.getContent().size, localDownloadResult.getProcess().startTime, localDownloadResult.getProcess().endTime);
            NetworkManager.unregistNetStatusListener(this);
            localDownloadResult.setDescInfo(generateDownloadDescInfo(localDownloadResult.getStatus().getFailReason(), localDownloadResult.getStatus().httpStatus, i, NetworkManager.getApnValue(), localObject6, localDownloadResult.getContent().type, localObject8));
            return localDownloadResult;
          }
          catch (Throwable paramJobContext)
          {
            QDLog.e("downloader", "", paramJobContext);
            return localDownloadResult;
          }
          try
          {
            Thread.sleep(2000L);
          }
          catch (Exception localException3) {}
        }
        break label85;
        l2 = SystemClock.uptimeMillis();
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
        localObject8 = null;
        try
        {
          boolean bool = setStrategy(this.mAttemptCurrCount);
          if (!bool)
          {
            localObject7 = localObject3;
            i = k;
            localObject8 = localObject1;
            label412:
            localObject1 = localObject8;
            k = i;
            localObject3 = localObject7;
            if (canAttempt()) {
              break;
            }
          }
        }
        catch (Throwable localThrowable2) {}
      }
      Object localObject10;
      int j;
      if (localThrowable2 != null)
      {
        i = i1;
        localObject10 = localObject3;
        localObject7 = localStringBuilder;
        j = i3;
      }
      try
      {
        throw localThrowable2;
      }
      catch (Throwable localThrowable1)
      {
        localObject9 = localThrowable1;
        localObject7 = localObject9;
        j = i;
        localDownloadResult.getStatus().setFailed(localThrowable1);
        k += 1;
        localDownloadResult.getProcess().setDuration(l2, SystemClock.uptimeMillis());
        localObject7 = NetworkStatus.getInstance(this.mContext).getDNS();
        if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
        {
          localObject3 = this.currStrategyInfo.getIPInfo().toString();
          if (localObject3 == null) {
            break label5345;
          }
          localObject2 = localObject3;
          if (!localDownloadResult.getStatus().isSucceed())
          {
            if (this.mResumeDownloadProcessor != null) {
              this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
            }
            if (!NetworkUtil.isNetworkAvailable(this.mContext))
            {
              this.mAttemptCurrCount -= 1;
              localDownloadResult.getStatus().setFailed(6);
            }
          }
          if (!paramJobContext.isCancelled())
          {
            if (localDownloadResult.getStatus().isSucceed()) {
              break label5364;
            }
            localStringBuilder = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject7).append(", remoteAddress=").append((String)localObject3).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
            if (!this.mAllowProxy) {
              break label5353;
            }
            localObject3 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
            localObject3 = localStringBuilder.append(localObject3).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(k).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(i).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
            if (this.currStrategyInfo == null) {
              break label5359;
            }
            j = this.currStrategyInfo.id;
            QDLog.e("downloader", j, (Throwable)localObject9);
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
            this.mDirectIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
            localDownloadReport.endTime = System.currentTimeMillis();
            localDownloadReport.fileSize = this.mContentLength;
            localDownloadReport.response = this.response;
            localDownloadReport.httpStatus = i;
            localDownloadReport.exception = ((Throwable)localObject9);
            if (localObject7 == null)
            {
              localObject3 = null;
              localDownloadReport.dns = ((String)localObject3);
              if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                break label5756;
              }
              localObject3 = this.currStrategyInfo.getIPInfo().ip;
              localDownloadReport.remoteAddress = ((String)localObject3);
              localDownloadReport.localAddress = "null:0";
              localDownloadReport.clientip = localDownloadResult.getContent().clientip;
              localDownloadResult.setReport(localDownloadReport);
              handleDownloadReportForTask(localDownloadResult, localDownloadReport);
              localObject9 = localObject2;
              i = k;
              localObject7 = localObject10;
              if (this.request == null) {
                break label412;
              }
              this.request.abort();
              localObject9 = localObject2;
              i = k;
              localObject7 = localObject10;
              break label412;
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              HttpUtil.RequestOptions localRequestOptions = (HttpUtil.RequestOptions)this.mRequestOptions.get();
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              localRequestOptions.allowProxy = this.mAllowProxy;
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              localRequestOptions.apnProxy = this.mAPNProxy;
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              localDownloadReport.currAttempCount = k;
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              localDownloadResult.reset();
              i = i1;
              localObject10 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              this.mRealUrl = this.mUrl;
              i = i1;
              localObject10 = localObject3;
              localObject2 = localObject3;
              localObject7 = localStringBuilder;
              j = i3;
              int m;
              if (this.currStrategyInfo != null)
              {
                i = i1;
                localObject10 = localObject3;
                localObject2 = localObject3;
                localObject7 = localStringBuilder;
                j = i3;
                if (this.currStrategyInfo.getIPInfo() != null)
                {
                  i = i1;
                  localObject10 = localObject3;
                  localObject2 = localObject3;
                  localObject7 = localStringBuilder;
                  j = i3;
                  if (!TextUtils.isEmpty(this.currStrategyInfo.getIPInfo().ip))
                  {
                    i = i1;
                    localObject10 = localObject3;
                    localObject7 = localStringBuilder;
                    j = i3;
                    String str3 = this.currStrategyInfo.getIPInfo().ip;
                    i = i1;
                    localObject10 = localObject3;
                    localObject7 = localStringBuilder;
                    j = i3;
                    localObject9 = Utils.getDominWithPort(this.mRealUrl);
                    localObject2 = localObject9;
                    i = i1;
                    localObject10 = localObject3;
                    localObject7 = localStringBuilder;
                    j = i3;
                    if (Utils.count(str3, ':') < 2)
                    {
                      i = i1;
                      localObject10 = localObject3;
                      localObject7 = localStringBuilder;
                      j = i3;
                      m = Utils.getPort(this.mUrl);
                      if (m <= 0) {
                        break label3111;
                      }
                      i = i1;
                      localObject10 = localObject3;
                      localObject7 = localStringBuilder;
                      j = i3;
                      this.currStrategyInfo.getIPInfo().port = m;
                      label1647:
                      i = i1;
                      localObject10 = localObject3;
                      n = m;
                      localObject7 = localStringBuilder;
                      j = i3;
                      if (!Utils.isPortValid(m)) {
                        n = 80;
                      }
                      i = i1;
                      localObject10 = localObject3;
                      localObject7 = localStringBuilder;
                      j = i3;
                      localObject2 = str3 + ":" + n;
                      i = i1;
                      localObject10 = localObject3;
                      localObject7 = localStringBuilder;
                      j = i3;
                      this.mRealUrl = this.mRealUrl.replaceFirst((String)localObject9, (String)localObject2);
                    }
                    i = i1;
                    localObject10 = localObject3;
                    localObject7 = localStringBuilder;
                    j = i3;
                    QDLog.i("downloader", "downloader strategy run: " + this.currStrategyInfo.toString() + " domain:" + (String)localObject2 + " url:" + this.mUrl + " threadId:" + Thread.currentThread().getId());
                    i = i1;
                    localObject10 = localObject3;
                    localObject7 = localStringBuilder;
                    j = i3;
                    localObject2 = localObject3 + "-" + this.currStrategyInfo.id;
                  }
                }
              }
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              if (this.currStrategyInfo != null)
              {
                i = i1;
                localObject10 = localObject2;
                localObject7 = localStringBuilder;
                j = i3;
                localDownloadReport.strategyInfo = this.currStrategyInfo.toString();
              }
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              localDownloadReport.url = this.mUrl;
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              localDownloadReport.domain = this.mDomain;
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              this.request = HttpUtil.createHttpGet(this.mContext, this.mUrl, this.mRealUrl, localRequestOptions);
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              if (this.mResumeDownloadProcessor != null)
              {
                i = i1;
                localObject10 = localObject2;
                localObject7 = localStringBuilder;
                j = i3;
                this.mResumeDownloadProcessor.prepareRequest(this.request, this.mUrl);
              }
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              prepareRequest(this.mUrl, this.request);
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              applyKeepAliveStrategy(this.mUrl, this.request);
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              localObject3 = HttpUtil.createHttpContext();
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              this.response = this.mHttpClient.execute(this.request, (HttpContext)localObject3);
              i = i1;
              localObject10 = localObject2;
              localObject7 = localStringBuilder;
              j = i3;
              if (this.response != null)
              {
                i = i1;
                localObject10 = localObject2;
                localObject7 = localStringBuilder;
                j = i3;
                m = this.response.getStatusLine().getStatusCode();
                i = m;
                localObject10 = localObject2;
                localObject7 = localStringBuilder;
                j = m;
                localDownloadResult.getStatus().httpStatus = m;
                if ((200 == m) || (206 == m))
                {
                  i = m;
                  localObject10 = localObject2;
                  n = m;
                  localObject7 = localStringBuilder;
                  j = m;
                  if (handleResponse(this.response, localDownloadResult, paramJobContext, m))
                  {
                    i = m;
                    localObject10 = localObject2;
                    localObject7 = localStringBuilder;
                    j = m;
                    localDownloadResult.getStatus().setSucceed();
                    j = k + 1;
                    localDownloadResult.getProcess().setDuration(l2, SystemClock.uptimeMillis());
                    localObject9 = NetworkStatus.getInstance(this.mContext).getDNS();
                    if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
                    {
                      localObject7 = this.currStrategyInfo.getIPInfo().toString();
                      label2367:
                      if (localObject7 == null) {
                        break label3148;
                      }
                      localObject3 = localObject7;
                      label2376:
                      if (!localDownloadResult.getStatus().isSucceed())
                      {
                        if (this.mResumeDownloadProcessor != null) {
                          this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                        }
                        if (!NetworkUtil.isNetworkAvailable(this.mContext))
                        {
                          this.mAttemptCurrCount -= 1;
                          localDownloadResult.getStatus().setFailed(6);
                        }
                      }
                      if (!paramJobContext.isCancelled())
                      {
                        if (localDownloadResult.getStatus().isSucceed()) {
                          break label3166;
                        }
                        localObject7 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject7).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                        if (!this.mAllowProxy) {
                          break label3156;
                        }
                        paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                        label2597:
                        paramJobContext = ((StringBuilder)localObject7).append(paramJobContext).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(j).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(m).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                        if (this.currStrategyInfo == null) {
                          break label3161;
                        }
                        i = this.currStrategyInfo.id;
                        label2834:
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
                        localDownloadReport.httpStatus = m;
                        localDownloadReport.exception = null;
                        if (localObject9 == null)
                        {
                          paramJobContext = null;
                          localDownloadReport.dns = paramJobContext;
                          if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                            break label3548;
                          }
                          paramJobContext = this.currStrategyInfo.getIPInfo().ip;
                          localDownloadReport.remoteAddress = paramJobContext;
                          localDownloadReport.localAddress = "null:0";
                          localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                          localDownloadResult.setReport(localDownloadReport);
                          handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                          localObject9 = localObject3;
                          i = j;
                          localObject7 = localObject2;
                          if (this.request == null) {
                            continue;
                          }
                          this.request.abort();
                          localObject9 = localObject3;
                          i = j;
                          localObject7 = localObject2;
                          continue;
                          label3111:
                          i = i1;
                          localObject10 = localObject3;
                          localObject7 = localStringBuilder;
                          j = i3;
                          m = this.currStrategyInfo.getIPInfo().port;
                          break label1647;
                          localObject7 = "null:0";
                          break label2367;
                          label3148:
                          localObject3 = "N/A";
                          break label2376;
                          label3156:
                          paramJobContext = null;
                          break label2597;
                          label3161:
                          i = 0;
                          break label2834;
                          label3166:
                          localObject7 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject7).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                          if (this.mAllowProxy)
                          {
                            paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                            label3297:
                            paramJobContext = ((StringBuilder)localObject7).append(paramJobContext).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(j).append(")").append(", httpStatus=").append(m).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                            if (this.currStrategyInfo == null) {
                              break label3506;
                            }
                          }
                          label3506:
                          for (i = this.currStrategyInfo.id;; i = 0)
                          {
                            QDLog.i("downloader", i);
                            break;
                            paramJobContext = null;
                            break label3297;
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
                          paramJobContext = ((NetworkUtil.DNS)localObject9).toString();
                          continue;
                          label3548:
                          paramJobContext = "null";
                        }
                      }
                    }
                  }
                }
                else
                {
                  if (404 == m)
                  {
                    i = m;
                    localObject10 = localObject2;
                    localObject7 = localStringBuilder;
                    j = m;
                    n = getXErrorCode(this.response);
                    if ((n == 0) || (n == -6101) || (n == -5062) || (n == -5023))
                    {
                      i = m;
                      localObject10 = localObject2;
                      localObject7 = localStringBuilder;
                      j = m;
                      setAttemptCount(0);
                    }
                  }
                  i = m;
                  localObject10 = localObject2;
                  localObject7 = localStringBuilder;
                  j = m;
                  localDownloadResult.getStatus().setFailed(3);
                  i = m;
                  localObject10 = localObject2;
                  n = m;
                  localObject7 = localStringBuilder;
                  j = m;
                  if (this.mResumeDownloadProcessor != null)
                  {
                    i = m;
                    localObject10 = localObject2;
                    localObject7 = localStringBuilder;
                    j = m;
                    this.mResumeDownloadProcessor.onDownloadResult(this.mUrl, true);
                    n = m;
                  }
                }
                j = k + 1;
                localDownloadResult.getProcess().setDuration(l2, SystemClock.uptimeMillis());
                localObject9 = NetworkStatus.getInstance(this.mContext).getDNS();
                if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                  break label6173;
                }
                localObject7 = this.currStrategyInfo.getIPInfo().toString();
                if (localObject7 == null) {
                  break label6181;
                }
                localObject3 = localObject7;
                if (!localDownloadResult.getStatus().isSucceed())
                {
                  if (this.mResumeDownloadProcessor != null) {
                    this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                  }
                  if (!NetworkUtil.isNetworkAvailable(this.mContext))
                  {
                    this.mAttemptCurrCount -= 1;
                    localDownloadResult.getStatus().setFailed(6);
                  }
                }
                if (!paramJobContext.isCancelled())
                {
                  if (localDownloadResult.getStatus().isSucceed()) {
                    break label6200;
                  }
                  localObject10 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject7).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                  if (!this.mAllowProxy) {
                    break label6189;
                  }
                  localObject7 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                  localObject7 = ((StringBuilder)localObject10).append(localObject7).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(j).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(n).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                  if (this.currStrategyInfo == null) {
                    break label6195;
                  }
                  i = this.currStrategyInfo.id;
                  QDLog.e("downloader", i, null);
                  if ((DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.currStrategyInfo.id) || (this.mBackupIPConfig == null)) {}
                }
              }
            }
          }
          catch (Exception localException4)
          {
            try
            {
              this.mBackupIPConfig.onDownloadResult(this.mUrl, Utils.getDomin(this.mRealUrl), localDownloadResult.getStatus().isSucceed());
              if ((this.mDirectIPConfig == null) || (this.mAllowBackupIP) || (this.mUrl.equals(this.mRealUrl))) {}
            }
            catch (Exception localException4)
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
                  if (localObject9 != null) {
                    break label6582;
                  }
                  localObject7 = null;
                  localDownloadReport.dns = ((String)localObject7);
                  if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                    break label6592;
                  }
                  localObject7 = this.currStrategyInfo.getIPInfo().ip;
                  localDownloadReport.remoteAddress = ((String)localObject7);
                  localDownloadReport.localAddress = "null:0";
                  localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                  localDownloadResult.setReport(localDownloadReport);
                  handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                  localObject9 = localObject3;
                  i = j;
                  localObject7 = localObject2;
                  if (this.request == null) {
                    break;
                  }
                  this.request.abort();
                  localObject9 = localObject3;
                  i = j;
                  localObject7 = localObject2;
                  break;
                  i = i1;
                  localObject10 = localObject2;
                  localObject7 = localStringBuilder;
                  j = i3;
                  localDownloadResult.getStatus().setFailed(3);
                  n = i2;
                  continue;
                  localObject4 = finally;
                  i = k + 1;
                  localDownloadResult.getProcess().setDuration(l2, SystemClock.uptimeMillis());
                  localObject9 = NetworkStatus.getInstance(this.mContext).getDNS();
                  if ((this.currStrategyInfo != null) && (this.currStrategyInfo.getIPInfo() != null))
                  {
                    localObject2 = this.currStrategyInfo.getIPInfo().toString();
                    label4617:
                    if (localObject2 == null) {
                      break label5772;
                    }
                    label4622:
                    if (!localDownloadResult.getStatus().isSucceed())
                    {
                      if (this.mResumeDownloadProcessor != null) {
                        this.mResumeDownloadProcessor.addCacheTmpFile(this.mUrl, localDownloadResult.getPath(), this.response);
                      }
                      if (!NetworkUtil.isNetworkAvailable(this.mContext))
                      {
                        this.mAttemptCurrCount -= 1;
                        localDownloadResult.getStatus().setFailed(6);
                      }
                    }
                    if (!paramJobContext.isCancelled())
                    {
                      if (localDownloadResult.getStatus().isSucceed()) {
                        break label5785;
                      }
                      localObject2 = new StringBuilder("Downloader, fail to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject2).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                      if (!this.mAllowProxy) {
                        break label5775;
                      }
                      paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                      label4843:
                      paramJobContext = ((StringBuilder)localObject2).append(paramJobContext).append(", netAvailable=").append(NetworkUtil.isNetworkAvailable(this.mContext)).append(", contentType=").append(localDownloadResult.getContent().type).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(i).append(")").append(", reason=").append(localDownloadResult.getStatus().getFailReason()).append(", httpStatus=").append(j).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                      if (this.currStrategyInfo == null) {
                        break label5780;
                      }
                      i = this.currStrategyInfo.id;
                      label5079:
                      QDLog.e("downloader", i, (Throwable)localObject7);
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
                      localDownloadReport.exception = ((Throwable)localObject7);
                      if (localObject9 == null)
                      {
                        paramJobContext = null;
                        localDownloadReport.dns = paramJobContext;
                        if ((this.currStrategyInfo == null) || (this.currStrategyInfo.getIPInfo() == null)) {
                          break label6166;
                        }
                        paramJobContext = this.currStrategyInfo.getIPInfo().ip;
                        localDownloadReport.remoteAddress = paramJobContext;
                        localDownloadReport.localAddress = "null:0";
                        localDownloadReport.clientip = localDownloadResult.getContent().clientip;
                        localDownloadResult.setReport(localDownloadReport);
                        handleDownloadReportForTask(localDownloadResult, localDownloadReport);
                        if (this.request != null) {
                          this.request.abort();
                        }
                        throw localObject4;
                        Object localObject5 = "null:0";
                        continue;
                        label5345:
                        localObject2 = "N/A";
                        continue;
                        label5353:
                        localObject5 = null;
                        continue;
                        label5359:
                        j = 0;
                        continue;
                        label5364:
                        localStringBuilder = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject7).append(", remoteAddress=").append((String)localObject5).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                        if (this.mAllowProxy)
                        {
                          localObject5 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                          label5496:
                          localObject5 = localStringBuilder.append(localObject5).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(k).append(")").append(", httpStatus=").append(i).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                          if (this.currStrategyInfo == null) {
                            break label5709;
                          }
                        }
                        label5709:
                        for (j = this.currStrategyInfo.id;; j = 0)
                        {
                          QDLog.i("downloader", j);
                          break;
                          localObject5 = null;
                          break label5496;
                        }
                        localException1 = localException1;
                        QDLog.i("downloader", "", localException1);
                        continue;
                        localException2 = localException2;
                        QDLog.i("downloader", "", localException2);
                        continue;
                        str1 = ((NetworkUtil.DNS)localObject7).toString();
                        continue;
                        label5756:
                        str1 = "null";
                        continue;
                        localObject2 = "null:0";
                        break label4617;
                        label5772:
                        break label4622;
                        label5775:
                        paramJobContext = null;
                        break label4843;
                        label5780:
                        i = 0;
                        break label5079;
                        label5785:
                        localObject2 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject2).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                        if (this.mAllowProxy)
                        {
                          paramJobContext = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                          label5916:
                          paramJobContext = ((StringBuilder)localObject2).append(paramJobContext).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(i).append(")").append(", httpStatus=").append(j).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                          if (this.currStrategyInfo == null) {
                            break label6124;
                          }
                        }
                        label6124:
                        for (i = this.currStrategyInfo.id;; i = 0)
                        {
                          QDLog.i("downloader", i);
                          break;
                          paramJobContext = null;
                          break label5916;
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
                        paramJobContext = ((NetworkUtil.DNS)localObject9).toString();
                        continue;
                        label6166:
                        paramJobContext = "null";
                      }
                    }
                  }
                  label6173:
                  localObject7 = "null:0";
                  continue;
                  label6181:
                  String str1 = "N/A";
                  continue;
                  label6189:
                  localObject7 = null;
                  continue;
                  label6195:
                  i = 0;
                }
                label6200:
                localObject10 = new StringBuilder("Downloader, succeed to download:").append(this.mUrl).append(", dns=").append(localObject9).append(", remoteAddress=").append((String)localObject7).append(", localAddress=").append("null:0").append(", thread=").append(Thread.currentThread().getId()).append(", apn=").append(NetworkManager.getApnValue()).append(", allowProxy=").append(this.mAllowProxy).append(", apnProxy=").append(this.mAPNProxy).append(", useProxy=");
                if (this.mAllowProxy)
                {
                  localObject7 = NetworkUtil.getProxy(this.mContext, this.mAPNProxy);
                  label6332:
                  localObject7 = ((StringBuilder)localObject10).append(localObject7).append(", duration=").append(localDownloadResult.getProcess().duration).append(", totalDuration=").append(SystemClock.uptimeMillis() - this.mTimeStamp).append(", size=(").append(localDownloadResult.getContent().length).append(",").append(localDownloadResult.getContent().size).append(")").append(", retry=(").append(this.mAttemptCurrCount).append(",").append(this.mAttemptTotalCount).append(")").append(", realretry=(").append(j).append(")").append(", httpStatus=").append(n).append(", enableIP=").append(this.mAllowBackupIP).append(" ipUrl:").append(this.mRealUrl).append(", strategyId=");
                  if (this.currStrategyInfo == null) {
                    break label6545;
                  }
                }
                label6545:
                for (i = this.currStrategyInfo.id;; i = 0)
                {
                  QDLog.i("downloader", i);
                  break;
                  localObject7 = null;
                  break label6332;
                }
                localException4 = localException4;
                QDLog.i("downloader", "", localException4);
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  Object localObject9;
                  QDLog.i("downloader", "", localException5);
                  continue;
                  label6582:
                  String str2 = ((NetworkUtil.DNS)localObject9).toString();
                  continue;
                  label6592:
                  str2 = "null";
                }
              }
            }
          }
        }
      }
      label6600:
      if ((this.downloadStrategyLib != null) && (this.downloadStrategyLib.getBestStrategy() != null))
      {
        DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.downloadStrategyLib.getBestStrategy(), localDownloadResult.getStatus().isSucceed());
        continue;
        label6653:
        if (!NetworkUtil.isNetworkAvailable(this.mContext)) {
          localDownloadResult.getStatus().setFailed(6);
        }
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.DownloadStrictTask
 * JD-Core Version:    0.7.0.1
 */