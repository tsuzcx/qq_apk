package com.weiyun.sdk.impl;

import android.util.Log;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.IWyFileSystem.WyCommand;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.job.pb.OfflineFileThumbnailDownloadJob;
import com.weiyun.sdk.job.pb.ThumbnailDownloadJob;
import com.weiyun.sdk.job.pb.ThumbnailDownloadJob.ThumbnailDownloadAddress;
import com.weiyun.sdk.job.pb.ThumbnailDownloadJob2;
import com.weiyun.sdk.job.schedule.JobListenerForLog;
import com.weiyun.sdk.job.schedule.WyTaskManager.DefaultThreadFactory;
import com.weiyun.sdk.util.HashSumCalc;
import com.weiyun.sdk.util.LruCache;
import com.weiyun.sdk.util.ThumbnailUtils;
import com.weiyun.sdk.util.Utils;
import com.weiyun.sdk.util.UtilsMisc;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultThumbnailLoader
{
  private static final long KEEP_ALIVE_TIME = 30L;
  private static final int MAX_CACHE_SIZE = 52428800;
  private static final int MAX_THREAD_SIZE = 2147483647;
  private static final int MAX_THUMBNAIL_SIZE = 512000;
  private static final String TAG = "DefaultThumbnailLoader";
  private static final String THREAD_NAME = "wy-thumbnail-loader";
  public static final String THUMBNAILS_CACHE_NAME = ".thumbnails/";
  private volatile boolean mCacheInit = false;
  private String mCachePath = "";
  private final DiskCache<String> mDiskCache = new DiskCache(52428800);
  private final ConcurrentHashMap<String, ThumbnailJobProxy> mJobs = new ConcurrentHashMap();
  private Lock mLock = new ReentrantLock();
  private BuildCacheRunnable mRunnable = null;
  private final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(0, 2147483647, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(2), new WyTaskManager.DefaultThreadFactory("wy-thumbnail-loader"));
  
  private void onCacheLoaded()
  {
    try
    {
      this.mCacheInit = true;
      this.mRunnable = null;
      return;
    }
    finally {}
  }
  
  public void cancelAllThumbnailTask()
  {
    Enumeration localEnumeration = this.mJobs.elements();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        return;
      }
      try
      {
        ((ThumbnailJobProxy)localEnumeration.nextElement()).cancel();
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        Log.w("DefaultThumbnailLoader", localNoSuchElementException);
      }
    }
  }
  
  public void cancelThumbnailJob(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong)
  {
    paramString1 = generateKey(paramString1, paramThumbnailType, paramString2, paramLong);
    paramThumbnailType = (ThumbnailJobProxy)this.mJobs.get(paramString1);
    if (paramThumbnailType != null)
    {
      paramThumbnailType.cancel();
      this.mJobs.remove(paramString1);
    }
  }
  
  protected BaseDownloadJob createDownloadJob(String paramString1, String paramString2, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    DownloadJobContext localDownloadJobContext = new DownloadJobContext(SdkContext.getInstance().getUin(), this.mCachePath);
    localDownloadJobContext.setFileId(paramString2);
    localDownloadJobContext.setFileName(paramString1);
    localDownloadJobContext.setTotalSize(0L);
    localDownloadJobContext.setDestFileName(paramString1);
    return new OfflineFileThumbnailDownloadJob(paramString1.hashCode(), localDownloadJobContext, paramInt, paramThumbnailType);
  }
  
  protected BaseDownloadJob createDownloadJob(String paramString1, String paramString2, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString3, long paramLong)
  {
    DownloadJobContext localDownloadJobContext = new DownloadJobContext(paramString1.hashCode(), this.mCachePath);
    localDownloadJobContext.setFileId(paramString2);
    localDownloadJobContext.setFileName(paramString3);
    localDownloadJobContext.setTotalSize(0L);
    localDownloadJobContext.setDestFileName(paramString1);
    return new ThumbnailDownloadJob2(paramString1.hashCode(), localDownloadJobContext, paramThumbnailType);
  }
  
  protected BaseDownloadJob createDownloadJob(String paramString1, String paramString2, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString3, long paramLong, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7)
  {
    DownloadJobContext localDownloadJobContext = new DownloadJobContext(paramString1.hashCode(), this.mCachePath);
    localDownloadJobContext.setFileId(paramString2);
    localDownloadJobContext.setFileName(paramString3);
    localDownloadJobContext.setTotalSize(0L);
    localDownloadJobContext.setDestFileName(paramString1);
    paramString2 = new ThumbnailDownloadJob.ThumbnailDownloadAddress(paramString4, paramInt, paramString5, paramString6, paramString7);
    return new ThumbnailDownloadJob(paramString1.hashCode(), localDownloadJobContext, paramString2, paramThumbnailType);
  }
  
  protected String generateKey(String paramString, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    try
    {
      String str = HashSumCalc.getStringHash(paramString, "MD5");
      paramString = str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
        paramString = UtilsMisc.byteArrayToHexString(paramString, paramString.length);
      }
    }
    return String.format("%s-%s", new Object[] { ThumbnailUtils.getThumbnailName(paramThumbnailType), paramString });
  }
  
  protected String generateKey(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong)
  {
    return String.format("%s-%d%d-%d", new Object[] { ThumbnailUtils.getThumbnailName(paramThumbnailType), Integer.valueOf(Math.abs(paramString1.hashCode())), Integer.valueOf(Math.abs(paramString2.hashCode())), Long.valueOf(paramLong) });
  }
  
  public IWyFileSystem.WyCommand getOfflineThumbnail(String paramString, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    String str = generateKey(paramString, paramThumbnailType);
    ThumbnailJobProxy localThumbnailJobProxy = (ThumbnailJobProxy)this.mJobs.get(str);
    if (localThumbnailJobProxy != null)
    {
      resetJobContext(localThumbnailJobProxy, paramObject, paramIWyCallback);
      return localThumbnailJobProxy;
    }
    if (!submitThumbnailJob(str, createDownloadJob(str, paramString, paramInt, paramThumbnailType), new IWyFileSystem.Thumbnail(paramString, paramThumbnailType, paramObject), paramIWyCallback)) {
      Log.w("DefaultThumbnailLoader", "submit job twice. key=" + paramString);
    }
    return (IWyFileSystem.WyCommand)this.mJobs.get(str);
  }
  
  public String getOfflineThumbnail(String paramString, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    paramString = generateKey(paramString, paramThumbnailType);
    if (this.mCacheInit) {
      return (String)this.mDiskCache.get(paramString);
    }
    paramString = this.mCachePath + paramString;
    if (Utils.getFileSize(paramString) > 0L) {
      return paramString;
    }
    return null;
  }
  
  public IWyFileSystem.WyCommand getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    if (((Utils.isEmptyString(paramString1)) || (Utils.isEmptyString(paramString2))) && (paramIWyCallback != null)) {
      paramIWyCallback.onSucceed(new IWyFileSystem.Thumbnail(paramString1, paramThumbnailType, paramObject));
    }
    String str = generateKey(paramString1, paramThumbnailType, paramString2, paramLong);
    ThumbnailJobProxy localThumbnailJobProxy = (ThumbnailJobProxy)this.mJobs.get(str);
    if (localThumbnailJobProxy != null)
    {
      resetJobContext(localThumbnailJobProxy, paramObject, paramIWyCallback);
      return localThumbnailJobProxy;
    }
    if (!submitThumbnailJob(str, createDownloadJob(str, paramString1, paramThumbnailType, paramString2, paramLong), new IWyFileSystem.Thumbnail(paramString1, paramThumbnailType, paramObject), paramIWyCallback)) {
      Log.w("DefaultThumbnailLoader", "submit job twice. file id=" + paramString1);
    }
    return (IWyFileSystem.WyCommand)this.mJobs.get(str);
  }
  
  public IWyFileSystem.WyCommand getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    String str = generateKey(paramString1, paramThumbnailType, paramString2, paramLong);
    ThumbnailJobProxy localThumbnailJobProxy = (ThumbnailJobProxy)this.mJobs.get(str);
    if (localThumbnailJobProxy != null)
    {
      resetJobContext(localThumbnailJobProxy, paramObject, paramIWyCallback);
      return localThumbnailJobProxy;
    }
    if ((paramString3 == null) || (paramString3.equals("")) || (paramString4 == null) || (paramString4.equals("")) || (paramString5 == null) || (paramString5.equals("")) || (paramString6 == null) || (paramString6.equals("")))
    {
      if (paramIWyCallback != null) {
        paramIWyCallback.onSucceed(new IWyFileSystem.Thumbnail(paramString1, paramThumbnailType, paramObject));
      }
      return null;
    }
    if (!submitThumbnailJob(str, createDownloadJob(str, paramString1, paramThumbnailType, paramString2, paramLong, paramString3, paramInt, paramString4, paramString5, paramString6), new IWyFileSystem.Thumbnail(paramString1, paramThumbnailType, paramObject), paramIWyCallback)) {
      Log.w("DefaultThumbnailLoader", "submit job twice. file id=" + paramString1);
    }
    return (IWyFileSystem.WyCommand)this.mJobs.get(str);
  }
  
  public String getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong)
  {
    paramString1 = generateKey(paramString1, paramThumbnailType, paramString2, paramLong);
    if (this.mCacheInit) {
      return (String)this.mDiskCache.get(paramString1);
    }
    paramString1 = this.mCachePath + paramString1;
    if (Utils.getFileSize(paramString1) > 0L) {
      return paramString1;
    }
    return null;
  }
  
  public void init(String paramString)
  {
    setParentPath(paramString);
    paramString = null;
    try
    {
      if (!this.mCacheInit) {
        paramString = new BuildCacheRunnable(this.mCachePath);
      }
    }
    finally
    {
      try
      {
        this.mRunnable = paramString;
        if (paramString != null) {
          this.mThreadPool.submit(paramString);
        }
        return;
      }
      finally {}
      paramString = finally;
    }
    throw paramString;
  }
  
  protected void resetJobContext(ThumbnailJobProxy paramThumbnailJobProxy, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    paramThumbnailJobProxy.setContext(paramObject);
    paramThumbnailJobProxy.setCallback(paramIWyCallback);
  }
  
  public void setParentPath(String paramString)
  {
    String str = paramString;
    if (paramString.lastIndexOf('/') != paramString.length() - 1) {
      str = paramString + "/";
    }
    this.mCachePath = (str + ".thumbnails/");
  }
  
  protected boolean submitThumbnailJob(String paramString, BaseDownloadJob paramBaseDownloadJob, IWyFileSystem.Thumbnail paramThumbnail, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    paramBaseDownloadJob = new ThumbnailJobProxy(this.mJobs, this.mDiskCache, paramThumbnail, paramBaseDownloadJob, paramString, paramIWyCallback);
    if ((ThumbnailJobProxy)this.mJobs.putIfAbsent(paramString, paramBaseDownloadJob) == null) {
      return paramBaseDownloadJob.submit(this.mThreadPool);
    }
    return false;
  }
  
  public void unInit()
  {
    BuildCacheRunnable localBuildCacheRunnable = null;
    try
    {
      if (this.mRunnable != null)
      {
        localBuildCacheRunnable = this.mRunnable;
        this.mRunnable = null;
      }
      this.mCacheInit = false;
      if (localBuildCacheRunnable != null) {
        localBuildCacheRunnable.cancel();
      }
      cancelAllThumbnailTask();
      this.mDiskCache.clearMemory();
      return;
    }
    finally {}
  }
  
  private class BuildCacheRunnable
    implements Runnable
  {
    private volatile boolean mCanceled = false;
    private final String mParentPath;
    
    public BuildCacheRunnable(String paramString)
    {
      this.mParentPath = paramString;
    }
    
    private void buildCache(String paramString)
    {
      paramString = new File(paramString).listFiles();
      int i = 0;
      for (;;)
      {
        if ((i >= paramString.length) || (this.mCanceled)) {
          return;
        }
        Object localObject = paramString[i];
        if ((localObject.isFile()) && (localObject.length() < 512000L)) {
          DefaultThumbnailLoader.this.mDiskCache.put(localObject.getName(), localObject.getPath());
        }
        i += 1;
      }
    }
    
    public void cancel()
    {
      this.mCanceled = true;
    }
    
    public void run()
    {
      if ((!this.mCanceled) && (DefaultThumbnailLoader.this.mLock.tryLock())) {}
      try
      {
        buildCache(this.mParentPath);
        DefaultThumbnailLoader.this.mLock.unlock();
        if (!this.mCanceled) {
          DefaultThumbnailLoader.this.onCacheLoaded();
        }
        return;
      }
      finally
      {
        DefaultThumbnailLoader.this.mLock.unlock();
      }
    }
  }
  
  private static class DiskCache<K>
    extends LruCache<K, String>
  {
    public DiskCache(int paramInt)
    {
      super();
    }
    
    public void clearMemory()
    {
      Iterator localIterator = super.snapshot().keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        super.remove((Object)localIterator.next());
      }
    }
    
    protected void entryRemoved(boolean paramBoolean, K paramK, String paramString1, String paramString2)
    {
      if (paramBoolean)
      {
        Log.d("DefaultThumbnailLoader", "evict thumbnail:" + paramString1);
        Utils.removeFile(paramString1);
      }
    }
    
    protected int sizeOf(K paramK, String paramString)
    {
      return Math.max(0, (int)Utils.getFileSize(paramString));
    }
  }
  
  public static class ThumbnailJobProxy
    implements Job.JobListener, IWyFileSystem.WyCommand
  {
    private final DefaultThumbnailLoader.DiskCache<String> mCache;
    private IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> mCallback;
    private final BaseDownloadJob mJob;
    private final String mJobKey;
    private final ConcurrentHashMap<String, ThumbnailJobProxy> mJobs;
    private IWyFileSystem.Thumbnail mThumbnail;
    
    public ThumbnailJobProxy(ConcurrentHashMap<String, ThumbnailJobProxy> paramConcurrentHashMap, DefaultThumbnailLoader.DiskCache<String> paramDiskCache, IWyFileSystem.Thumbnail paramThumbnail, BaseDownloadJob paramBaseDownloadJob, String paramString, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
    {
      this.mJobs = paramConcurrentHashMap;
      this.mCache = paramDiskCache;
      this.mJob = paramBaseDownloadJob;
      this.mJobKey = paramString;
      this.mThumbnail = paramThumbnail;
      this.mCallback = paramIWyCallback;
    }
    
    private void onFailed()
    {
      Utils.removeFile(this.mJob.getDownloadJobContext().getDataFilePath());
      IWyFileSystem.IWyCallback localIWyCallback = this.mCallback;
      if (localIWyCallback != null) {}
      try
      {
        this.mThumbnail.filePath = null;
        localIWyCallback.onSucceed(this.mThumbnail);
        return;
      }
      finally {}
    }
    
    private void onSuccess()
    {
      String str = this.mJob.getDownloadJobContext().getDestFilePath();
      this.mCache.put(this.mJobKey, str);
      IWyFileSystem.IWyCallback localIWyCallback = this.mCallback;
      if (localIWyCallback != null) {}
      try
      {
        this.mThumbnail.filePath = str;
        localIWyCallback.onSucceed(this.mThumbnail);
        return;
      }
      finally {}
    }
    
    public void cancel()
    {
      this.mJob.cancel();
    }
    
    public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
    
    public void notifyStateChanged(int paramInt, Job paramJob)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 6: 
      case 7: 
      case 8: 
        onFailed();
        this.mJobs.remove(this.mJobKey);
        return;
      }
      onSuccess();
      this.mJobs.remove(this.mJobKey);
    }
    
    public void setCallback(IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
    {
      this.mCallback = paramIWyCallback;
    }
    
    public void setContext(Object paramObject)
    {
      this.mThumbnail.context = paramObject;
    }
    
    public boolean submit(ThreadPoolExecutor paramThreadPoolExecutor)
    {
      this.mJob.addListener(this);
      this.mJob.addListener(new JobListenerForLog("FM-DownThumb", 3));
      this.mJob.bindThreadPool(paramThreadPoolExecutor);
      return this.mJob.start();
    }
    
    public boolean suspend()
    {
      return this.mJob.suspend();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultThumbnailLoader
 * JD-Core Version:    0.7.0.1
 */