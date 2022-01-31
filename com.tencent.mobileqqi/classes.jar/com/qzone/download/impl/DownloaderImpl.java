package com.qzone.download.impl;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.cache.CacheManager;
import com.qzone.cache.file.FileCacheService;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloadListener;
import com.qzone.download.DownloadRequest;
import com.qzone.download.DownloadResult;
import com.qzone.download.DownloadResult.Status;
import com.qzone.download.Downloader;
import com.qzone.download.Downloader.DownloadMode;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.strategy.ConfigKeepAliveStrategy;
import com.qzone.download.strategy.DownloadProcessStrategy;
import com.qzone.download.strategy.DownloadProcessStrategy.DownloadPool;
import com.qzone.download.strategy.KeepAliveStrategy;
import com.qzone.download.strategy.global.DownloadConnectionReuseStrategy;
import com.qzone.download.strategy.global.ReportHandler;
import com.qzone.utils.AssertUtil;
import com.qzone.utils.FileUtil;
import com.qzone.utils.MultiHashMap;
import com.qzone.utils.Utils;
import com.qzone.utils.http.HttpUtil;
import com.qzone.utils.http.HttpUtil.ClientOptions;
import com.qzone.utils.thread.Future;
import com.qzone.utils.thread.FutureListener;
import com.qzone.utils.thread.ThreadPool;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;

public class DownloaderImpl
  extends Downloader
  implements DownloadTask.DownloadTaskHandler
{
  public static final int MAX_CONNECTION = DownloadProcessStrategy.DownloadPool.size() * 2 * 5;
  public static final int MAX_CONNECTION_PER_ROUTE = 2;
  private static final int THREAD_POOL_SIZE = 2;
  public static final long TIME_TO_LIVE = 120L;
  public static final TimeUnit TIME_TO_LIVE_UNIT = TimeUnit.SECONDS;
  public static final ThreadPoolCache sThreadPoolCache = new ThreadPoolCache("download", 2);
  private Object ExecutingTaskListRock = new Object();
  private Context mContext;
  private Map<String, WeakReference<DownloadTask>> mExecutingTaskList = new HashMap();
  private ThreadPool mExternalThreadPool;
  private final HashMap<String, Future<DownloadResult>> mFutures = new HashMap();
  private HttpClient mHttpClient;
  private String mName;
  private boolean mPaused = false;
  private final MultiHashMap<String, DownloadRequest> mPendingRequests = new MultiHashMap();
  private ResumeDownloadProcessor mResumeDownloadProcessor;
  private final ThreadPoolCache mThreadPoolCache;
  private final FileCacheService mTmpFileCache;
  
  public DownloaderImpl(Context paramContext, String paramString)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mName = paramString;
    this.mThreadPoolCache = sThreadPoolCache;
    this.mTmpFileCache = CacheManager.getTmpFileCacheService(paramContext, "tmp_" + this.mName);
  }
  
  private boolean abortExecutingTask(String arg1)
  {
    if (!DownloadRequest.checkParameter(???)) {
      return false;
    }
    Object localObject2 = generateUrlKey(???);
    Object localObject4;
    synchronized (this.ExecutingTaskListRock)
    {
      if (this.mExecutingTaskList.containsKey(???))
      {
        localObject4 = (DownloadTask)((WeakReference)this.mExecutingTaskList.get(???)).get();
        if ((localObject4 != null) && (???.equals(((DownloadTask)localObject4).getUrl())))
        {
          this.mExecutingTaskList.remove(???);
          ((DownloadTask)localObject4).abort();
          localObject4 = new ArrayList();
          collectPendingRequest((String)localObject2, true, (Collection)localObject4);
        }
      }
    }
    synchronized (this.mFutures)
    {
      localObject2 = (Future)this.mFutures.remove(localObject2);
      if (localObject2 != null) {
        ((Future)localObject2).cancel();
      }
      notifyDownloadCanceled((Collection)localObject4);
      return true;
      ??? = finally;
      throw ???;
    }
  }
  
  private boolean addPendingRequest(String paramString, DownloadRequest paramDownloadRequest)
  {
    boolean bool = false;
    if (paramDownloadRequest == null) {
      return false;
    }
    synchronized (this.mPendingRequests)
    {
      int i = this.mPendingRequests.sizeOf(paramString);
      this.mPendingRequests.add(paramString, paramDownloadRequest);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  private MultiHashMap<String, DownloadRequest> collectAllPendingRequest(boolean paramBoolean, MultiHashMap<String, DownloadRequest> paramMultiHashMap)
  {
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramMultiHashMap != null) {}
    try
    {
      paramMultiHashMap.clear();
      if (this.mPendingRequests.isEmpty()) {
        return paramMultiHashMap;
      }
      Object localObject = paramMultiHashMap;
      if (paramMultiHashMap == null) {
        localObject = new MultiHashMap();
      }
      ((MultiHashMap)localObject).putAll(this.mPendingRequests);
      if (paramBoolean) {
        this.mPendingRequests.clear();
      }
      return localObject;
    }
    finally {}
  }
  
  private Collection<DownloadRequest> collectPendingRequest(String paramString, boolean paramBoolean, Collection<DownloadRequest> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.mPendingRequests.remove(paramString); paramCollection != null; paramString = (HashSet)this.mPendingRequests.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  private void enqueueTask(final DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    while (this.mPaused) {
      return;
    }
    Future localFuture = getDownloadThreadPool(paramDownloadTask.getUrl()).submit(paramDownloadTask, new FutureListener()
    {
      public void onFutureBegin(Future<DownloadResult> arg1)
      {
        synchronized (DownloaderImpl.this.ExecutingTaskListRock)
        {
          WeakReference localWeakReference = new WeakReference(paramDownloadTask);
          if (paramDownloadTask != null) {
            DownloaderImpl.this.mExecutingTaskList.put(paramDownloadTask.getUrl(), localWeakReference);
          }
          return;
        }
      }
      
      public void onFutureDone(Future<DownloadResult> paramAnonymousFuture)
      {
        Object localObject2;
        synchronized (DownloaderImpl.this.ExecutingTaskListRock)
        {
          if (DownloaderImpl.this.mExecutingTaskList.containsKey(paramDownloadTask.getUrl())) {
            DownloaderImpl.this.mExecutingTaskList.remove(paramDownloadTask.getUrl());
          }
          localObject2 = paramDownloadTask.getUrlKey();
          synchronized (DownloaderImpl.this.mFutures)
          {
            DownloaderImpl.this.mFutures.remove(localObject2);
            ??? = (DownloadResult)paramAnonymousFuture.get();
            if (??? == null) {}
          }
        }
        for (;;)
        {
          try
          {
            boolean bool = ((DownloadResult)???).getStatus().isRetrying();
            if (bool)
            {
              return;
              paramAnonymousFuture = finally;
              throw paramAnonymousFuture;
              paramAnonymousFuture = finally;
              throw paramAnonymousFuture;
            }
            if (paramAnonymousFuture.isCancelled()) {
              continue;
            }
            paramAnonymousFuture = DownloaderImpl.this.collectPendingRequest((String)localObject2, true, null);
            if ((??? == null) || (!((DownloadResult)???).getStatus().isSucceed()))
            {
              DownloaderImpl.this.notifyDownloadFailed(paramAnonymousFuture, (DownloadResult)???);
              return;
            }
            if (paramAnonymousFuture != null)
            {
              localObject2 = paramAnonymousFuture.iterator();
              if (((Iterator)localObject2).hasNext()) {}
            }
            else
            {
              DownloaderImpl.this.notifyDownloadSucceed(paramAnonymousFuture, (DownloadResult)???);
              continue;
            }
            localDownloadRequest = (DownloadRequest)((Iterator)localObject2).next();
          }
          finally
          {
            if (??? != null)
            {
              if (DownloaderImpl.this.mResumeDownloadProcessor != null) {
                DownloaderImpl.this.mResumeDownloadProcessor.onDownloadResult(((DownloadResult)???).getUrl(), ((DownloadResult)???).getStatus().isSucceed());
              }
              if (((((DownloadResult)???).getStatus().isSucceed()) || (DownloaderImpl.this.mResumeDownloadProcessor == null)) && (!TextUtils.isEmpty(((DownloadResult)???).getPath()))) {
                FileUtil.delete(new File(((DownloadResult)???).getPath()));
              }
            }
          }
          DownloadRequest localDownloadRequest;
          if (localDownloadRequest != null) {
            if (!TextUtils.isEmpty(localDownloadRequest.getPath()))
            {
              FileUtil.copyFiles(((DownloadResult)???).getPath(), localDownloadRequest.getPath());
              QDLog.v("downloader", "download file copy from " + ((DownloadResult)???).getPath() + " to:" + localDownloadRequest.getPath());
            }
            else if (localDownloadRequest.outputStream != null)
            {
              FileUtil.copyFile(((DownloadResult)???).getPath(), localDownloadRequest.outputStream);
            }
          }
        }
      }
    }, paramDownloadTask.getPriority());
    synchronized (this.mFutures)
    {
      this.mFutures.put(paramDownloadTask.getUrlKey(), localFuture);
      return;
    }
  }
  
  private static DownloadRequest generateRequest(String paramString1, String paramString2, DownloadListener paramDownloadListener)
  {
    return new DownloadRequest(paramString1, paramString2, paramDownloadListener);
  }
  
  private ThreadPool getDownloadThreadPool(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      if (this.mExternalThreadPool == null) {
        break;
      }
      return this.mExternalThreadPool;
    }
    Object localObject = this.pProcessStrategy;
    if (localObject != null) {}
    for (paramString = ((DownloadProcessStrategy)localObject).getDownloadPool(paramString);; paramString = null)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = DownloadProcessStrategy.DownloadPool.COMMON;
      }
      return this.mThreadPoolCache.get(((DownloadProcessStrategy.DownloadPool)localObject).getName());
    }
  }
  
  private boolean isDownloading(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (this.ExecutingTaskListRock)
    {
      boolean bool = this.mExecutingTaskList.containsKey(paramString);
      return bool;
    }
  }
  
  private void notifyDownloadCanceled(Collection<DownloadRequest> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if (localDownloadRequest != null)
        {
          DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadCanceled(localDownloadRequest.getUrl());
          }
        }
      }
    }
  }
  
  private void notifyDownloadFailed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if (localDownloadRequest != null)
        {
          DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadFailed(localDownloadRequest.getUrl(), paramDownloadResult);
          }
        }
      }
    }
  }
  
  private void notifyDownloadProgress(Collection<DownloadRequest> paramCollection, long paramLong, float paramFloat)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if (localDownloadRequest != null)
        {
          DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadProgress(localDownloadRequest.getUrl(), paramLong, paramFloat);
          }
        }
      }
    }
  }
  
  private void notifyDownloadSucceed(Collection<DownloadRequest> paramCollection, DownloadResult paramDownloadResult)
  {
    QDLog.v("downloader", "notifyDownloadSucceed");
    if (paramCollection == null) {
      QDLog.v("downloader", "notifyDownloadSucceed none");
    }
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DownloadRequest localDownloadRequest = (DownloadRequest)paramCollection.next();
        if (localDownloadRequest != null)
        {
          DownloadListener localDownloadListener = localDownloadRequest.getListener();
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadSucceed(localDownloadRequest.getUrl(), paramDownloadResult);
          }
        }
      }
    }
  }
  
  private boolean removePendingRequest(String paramString, DownloadRequest paramDownloadRequest, Collection<DownloadRequest> paramCollection)
  {
    boolean bool2 = false;
    if (paramDownloadRequest == null) {
      return false;
    }
    synchronized (this.mPendingRequests)
    {
      int i = this.mPendingRequests.sizeOf(paramString);
      if (paramCollection != null) {
        paramCollection.clear();
      }
      if ((this.mPendingRequests.remove(paramString, paramDownloadRequest)) && (paramCollection != null)) {
        paramCollection.add(paramDownloadRequest);
      }
      boolean bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (this.mPendingRequests.sizeOf(paramString) == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public void abort(String paramString, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (!abortExecutingTask(paramString)) {
      cancel(paramString, null, paramDownloadListener);
    }
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: aconst_null
    //   3: invokespecial 402	com/qzone/download/impl/DownloaderImpl:collectAllPendingRequest	(ZLcom/qzone/utils/MultiHashMap;)Lcom/qzone/utils/MultiHashMap;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 121	com/qzone/download/impl/DownloaderImpl:mFutures	Ljava/util/HashMap;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 121	com/qzone/download/impl/DownloaderImpl:mFutures	Ljava/util/HashMap;
    //   20: invokevirtual 403	java/util/HashMap:isEmpty	()Z
    //   23: ifne +25 -> 48
    //   26: new 201	java/util/ArrayList
    //   29: dup
    //   30: aload_0
    //   31: getfield 121	com/qzone/download/impl/DownloaderImpl:mFutures	Ljava/util/HashMap;
    //   34: invokevirtual 406	java/util/HashMap:values	()Ljava/util/Collection;
    //   37: invokespecial 408	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 121	com/qzone/download/impl/DownloaderImpl:mFutures	Ljava/util/HashMap;
    //   45: invokevirtual 409	java/util/HashMap:clear	()V
    //   48: aload_3
    //   49: monitorexit
    //   50: aload_1
    //   51: ifnull +17 -> 68
    //   54: aload_1
    //   55: invokevirtual 410	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 348 1 0
    //   65: ifne +32 -> 97
    //   68: aload_2
    //   69: ifnull +22 -> 91
    //   72: aload_2
    //   73: invokevirtual 414	com/qzone/utils/MultiHashMap:keySet	()Ljava/util/Set;
    //   76: invokeinterface 417 1 0
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 348 1 0
    //   88: ifne +32 -> 120
    //   91: return
    //   92: astore_1
    //   93: aload_3
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: aload_1
    //   98: invokeinterface 351 1 0
    //   103: checkcast 209	com/qzone/utils/thread/Future
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull -49 -> 59
    //   111: aload_3
    //   112: invokeinterface 212 1 0
    //   117: goto -58 -> 59
    //   120: aload_1
    //   121: invokeinterface 351 1 0
    //   126: checkcast 190	java/lang/String
    //   129: astore_3
    //   130: aload_3
    //   131: ifnull -49 -> 82
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 274	com/qzone/utils/MultiHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 268	java/util/Collection
    //   143: invokespecial 216	com/qzone/download/impl/DownloaderImpl:notifyDownloadCanceled	(Ljava/util/Collection;)V
    //   146: goto -64 -> 82
    //   149: astore_1
    //   150: goto -57 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	DownloaderImpl
    //   8	75	1	localObject1	Object
    //   92	29	1	localObject2	Object
    //   149	1	1	localObject3	Object
    //   6	130	2	localMultiHashMap	MultiHashMap
    //   13	124	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	41	92	finally
    //   48	50	92	finally
    //   93	95	92	finally
    //   41	48	149	finally
  }
  
  public void cancel(String paramString1, String arg2, DownloadListener paramDownloadListener)
  {
    if (!DownloadRequest.checkParameter(paramString1)) {
      return;
    }
    String str = generateUrlKey(paramString1);
    ??? = generateRequest(paramString1, ???, paramDownloadListener);
    paramString1 = new ArrayList();
    if (removePendingRequest(str, ???, paramString1)) {}
    synchronized (this.mFutures)
    {
      paramDownloadListener = (Future)this.mFutures.remove(str);
      if (paramDownloadListener != null) {
        paramDownloadListener.cancel();
      }
      notifyDownloadCanceled(paramString1);
      return;
    }
  }
  
  public boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    if (paramDownloadRequest == null) {
      return false;
    }
    String str1 = paramDownloadRequest.getUrl();
    String str2 = generateUrlKey(str1);
    QDLog.v("downloader", "download:" + str1);
    if ((addPendingRequest(str2, paramDownloadRequest)) && (!isDownloading(str1)))
    {
      if (paramDownloadRequest.range > 0L) {
        paramDownloadRequest.addParam("range", "bytes=" + paramDownloadRequest.range);
      }
      if (this.pDownloadMode != Downloader.DownloadMode.StrictMode) {
        break label179;
      }
      paramDownloadRequest = new DownloadStrictTask(this.mContext, obtainHttpClient(), str1, str2, paramBoolean, paramDownloadRequest.params, this, this.mTmpFileCache);
      paramDownloadRequest.setAttemptCount(12);
    }
    for (;;)
    {
      paramDownloadRequest.setTaskHandler(this.pReportHandler, this.pDirectIPConfigStrategy, this.pBackupIPConfigStrategy, this.pPortConfigStrategy, this.mResumeDownloadProcessor);
      paramDownloadRequest.pNetworkFlowStatistics = this.pNetworkFlowStatistics;
      enqueueTask(paramDownloadRequest);
      return true;
      label179:
      paramDownloadRequest = new DownloadTask(this.mContext, obtainHttpClient(), str1, str2, paramBoolean, paramDownloadRequest.params, this, this.mTmpFileCache);
      paramDownloadRequest.setAttemptCount(8);
    }
  }
  
  public boolean download(String paramString1, String paramString2, boolean paramBoolean, Map<String, Object> paramMap, DownloadListener paramDownloadListener)
  {
    if (!DownloadRequest.checkParameter(paramString1)) {
      return false;
    }
    paramString1 = generateRequest(paramString1, paramString2, paramDownloadListener);
    paramString1.params = paramMap;
    return download(paramString1, paramBoolean);
  }
  
  public void enableResumeDownload()
  {
    ImageResumeDownloadProcessor localImageResumeDownloadProcessor = new ImageResumeDownloadProcessor(this.mContext, "tmp_" + Utils.getCurrentProcessName(this.mContext) + "_" + this.mName, this.mTmpFileCache, true);
    localImageResumeDownloadProcessor.mForceEnable = true;
    this.mResumeDownloadProcessor = localImageResumeDownloadProcessor;
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    boolean bool1 = true;
    if (this.pProcessStrategy != null)
    {
      boolean bool2 = this.pProcessStrategy.handleContentType(paramDownloadResult, paramHttpResponse);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (this.pReportHandler != null)
        {
          this.pReportHandler.handleContentType(paramDownloadResult, paramHttpResponse);
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  public void handleDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    notifyDownloadProgress(collectPendingRequest(paramString, false, new ArrayList()), paramLong, paramFloat);
  }
  
  public void handleKeepAliveStrategy(String paramString, HttpRequest paramHttpRequest)
  {
    boolean bool;
    if ((paramString != null) && (paramHttpRequest != null))
    {
      bool = true;
      label10:
      AssertUtil.assertTrue(bool);
      localObject = DownloaderFactory.getKeepAliveStrategy();
      if (localObject == null) {
        break label94;
      }
      paramString = ((KeepAliveStrategy)localObject).keepAlive(Utils.getDomin(paramString), paramHttpRequest);
      label37:
      localObject = paramString;
      if (paramString == null) {
        if (!HttpUtil.containsProxy(paramHttpRequest)) {
          break label99;
        }
      }
    }
    label94:
    label99:
    for (Object localObject = ConfigKeepAliveStrategy.DEFAULT_KEEP_ALIVE_PROXY;; localObject = ConfigKeepAliveStrategy.DEFAULT_KEEP_ALIVE) {
      switch (localObject)
      {
      default: 
        return;
        bool = false;
        break label10;
        paramString = null;
        break label37;
      }
    }
    HttpUtil.setKeepAliveEnabled(paramHttpRequest, true);
    return;
    HttpUtil.setKeepAliveEnabled(paramHttpRequest, false);
  }
  
  public void handlePrepareRequest(String paramString, HttpRequest paramHttpRequest)
  {
    if (this.pProcessStrategy != null) {
      this.pProcessStrategy.prepareRequest(paramString, paramHttpRequest);
    }
  }
  
  public void handleTaskAbort(String paramString) {}
  
  protected HttpClient obtainHttpClient()
  {
    if (this.mHttpClient != null) {
      return this.mHttpClient;
    }
    try
    {
      if (this.mHttpClient != null)
      {
        HttpClient localHttpClient = this.mHttpClient;
        return localHttpClient;
      }
    }
    finally {}
    Object localObject2 = new HttpUtil.ClientOptions();
    ((HttpUtil.ClientOptions)localObject2).multiConnection = true;
    ((HttpUtil.ClientOptions)localObject2).maxConnection = MAX_CONNECTION;
    ((HttpUtil.ClientOptions)localObject2).maxConnectionPerRoute = 2;
    ((HttpUtil.ClientOptions)localObject2).timeToLive = 120L;
    ((HttpUtil.ClientOptions)localObject2).timeToLiveUnit = TIME_TO_LIVE_UNIT;
    this.mHttpClient = HttpUtil.createHttpClient((HttpUtil.ClientOptions)localObject2);
    if ((this.mHttpClient instanceof AbstractHttpClient)) {
      ((AbstractHttpClient)this.mHttpClient).setReuseStrategy(new DownloadConnectionReuseStrategy());
    }
    localObject2 = this.mHttpClient;
    return localObject2;
  }
  
  public void pause()
  {
    this.mPaused = true;
  }
  
  public void resume()
  {
    this.mPaused = false;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    if (paramExecutor == null)
    {
      this.mExternalThreadPool = null;
      return;
    }
    this.mExternalThreadPool = new ThreadPool(paramExecutor);
  }
  
  public static abstract interface ResumeDownloadProcessor
  {
    public abstract void addCacheTmpFile(String paramString1, String paramString2, HttpResponse paramHttpResponse);
    
    public abstract String getResumeTmpFile(String paramString);
    
    public abstract boolean handleResponse(String paramString, HttpResponse paramHttpResponse);
    
    public abstract void onDownloadResult(String paramString, boolean paramBoolean);
    
    public abstract void prepareRequest(HttpGet paramHttpGet, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.DownloaderImpl
 * JD-Core Version:    0.7.0.1
 */