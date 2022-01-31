package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.IWyTaskManager;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.pb.PbZeroSizeDownloadJob;
import com.weiyun.sdk.job.pb.DownloadJob;
import com.weiyun.sdk.job.pb.UploadJob;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.store.TaskDBHelper;
import com.weiyun.sdk.util.NetworkUtils;
import java.io.File;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WyTaskManager
  implements IWyTaskManager
{
  private static final String DATA_TMP_PATH_NAME = ".tmp/";
  private static final long KEEP_ALIVE_TIME = 30L;
  private static final String TAG = "WyTaskManager";
  private static final String THREAD_NAME = "weiyun-sdk";
  protected final String mDataPath;
  protected final String mDestPath;
  protected final Job.JobListener mDownloadListener;
  protected final JobManager mJobManager;
  protected final ThreadPoolExecutor mThreadPool;
  protected final Job.JobListener mUploadListener;
  
  public WyTaskManager(int paramInt, String paramString)
  {
    this.mThreadPool = new ThreadPoolExecutor(0, paramInt * 2, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("weiyun-sdk"));
    this.mJobManager = new DefaultJobManager(this.mThreadPool, false, paramInt);
    this.mUploadListener = new UploadJobListener();
    this.mDownloadListener = new DownloadJobListener();
    this.mDestPath = paramString;
    this.mDataPath = (paramString + ".tmp/");
  }
  
  public void cancelAllTask()
  {
    this.mJobManager.cancelTasks();
  }
  
  protected DownloadJobProxy createDownloadJobProxy(DownloadJobContext paramDownloadJobContext, Object paramObject)
  {
    if (paramDownloadJobContext == null)
    {
      Log.e("WyTaskManager", "job context is null");
      return null;
    }
    if (paramDownloadJobContext.getTotalSize() > 0L) {}
    for (paramDownloadJobContext = new DownloadJob(paramDownloadJobContext.getId(), paramDownloadJobContext);; paramDownloadJobContext = new PbZeroSizeDownloadJob(paramDownloadJobContext.getId(), paramDownloadJobContext))
    {
      paramDownloadJobContext.addListener(this.mDownloadListener);
      paramDownloadJobContext.addListener(new JobListenerForLog("FM-TransferFile", 2));
      return new DownloadJobProxy(paramDownloadJobContext, paramObject, this.mJobManager);
    }
  }
  
  public IWyTaskManager.Task createDownloadTask(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject)
  {
    String str = SdkContext.getInstance().getAccount();
    TaskDBHelper localTaskDBHelper = TaskDBHelper.newDBHelper();
    long l = localTaskDBHelper.getDownloadTaskId(paramString1, str);
    Object localObject1 = null;
    if (l != 0L)
    {
      localObject1 = this.mJobManager.findTask(l);
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = localTaskDBHelper.getDownloadJobContext(paramString1, str, this.mDestPath, this.mDataPath);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = initDownloadJobContext(localTaskDBHelper, paramString1, str, localTaskDBHelper.getDownloadNewFileName(paramString2), paramLong1, paramLong2);
    }
    if ((localObject2 != null) && (((DownloadJobContext)localObject2).getTotalSize() != paramLong1) && (paramLong2 != ((DownloadJobContext)localObject2).getModifyTime()))
    {
      downloadFileChanged(localTaskDBHelper, ((DownloadJobContext)localObject2).getId(), paramLong1, paramLong2, ((DownloadJobContext)localObject2).getDataFilePath());
      ((DownloadJobContext)localObject2).setCurSize(0L);
      ((DownloadJobContext)localObject2).setTotalSize(paramLong1);
      ((DownloadJobContext)localObject2).setModifyTime(paramLong2);
    }
    return createDownloadJobProxy((DownloadJobContext)localObject2, paramObject);
  }
  
  protected UploadJobProxy createUploadJobProxy(UploadJobContext paramUploadJobContext, Object paramObject)
  {
    if (paramUploadJobContext == null)
    {
      Log.e("WyTaskManager", "job context is null");
      return null;
    }
    paramUploadJobContext = new UploadJob(paramUploadJobContext.getId(), paramUploadJobContext);
    paramUploadJobContext.addListener(this.mUploadListener);
    paramUploadJobContext.addListener(new JobListenerForLog("FM-TransferFile", 1));
    return new UploadJobProxy(paramUploadJobContext, paramObject, this.mJobManager);
  }
  
  public IWyTaskManager.Task createUploadTask(String paramString, Object paramObject)
  {
    String str = SdkContext.getInstance().getAccount();
    TaskDBHelper localTaskDBHelper = TaskDBHelper.newDBHelper();
    long l = localTaskDBHelper.getUploadTaskId(paramString, str);
    Object localObject1 = null;
    if (l != 0L)
    {
      localObject1 = this.mJobManager.findTask(l);
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = localTaskDBHelper.getUploadJobContext(paramString, str);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = initUploadJobContext(localTaskDBHelper, paramString, str);
    }
    return createUploadJobProxy((UploadJobContext)localObject2, paramObject);
  }
  
  protected void downloadFileChanged(TaskDBHelper paramTaskDBHelper, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    paramTaskDBHelper.updateDownloadFileSizeAndModifyTime(paramLong1, paramLong2, paramLong3);
    if (!new File(paramString).delete()) {
      Log.w("WyTaskManager", "delete file failed. path=" + paramString);
    }
  }
  
  public IWyTaskManager.Task findDownloadTask(String paramString)
  {
    String str = SdkContext.getInstance().getAccount();
    long l = TaskDBHelper.newDBHelper().getDownloadTaskId(paramString, str);
    if (l != 0L) {
      return this.mJobManager.findTask(l);
    }
    return null;
  }
  
  public IWyTaskManager.Task findUploadTask(String paramString)
  {
    String str = SdkContext.getInstance().getAccount();
    long l = TaskDBHelper.newDBHelper().getUploadTaskId(paramString, str);
    if (l != 0L) {
      return this.mJobManager.findTask(l);
    }
    return null;
  }
  
  protected DownloadJobContext initDownloadJobContext(TaskDBHelper paramTaskDBHelper, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    long l = paramTaskDBHelper.initDownloadTask(paramString1, paramString2, paramString3, paramLong1, paramLong2);
    if (l > 0L)
    {
      paramTaskDBHelper = new DownloadJobContext(Long.parseLong(paramString2), l, this.mDestPath, this.mDataPath);
      paramTaskDBHelper.setCurSize(0L);
      paramTaskDBHelper.setTotalSize(paramLong1);
      paramTaskDBHelper.setModifyTime(paramLong2);
      paramTaskDBHelper.setFileId(paramString1);
      paramTaskDBHelper.setFileName(paramString3);
      paramTaskDBHelper.setDestFileName(paramString3);
      return paramTaskDBHelper;
    }
    return null;
  }
  
  protected UploadJobContext initUploadJobContext(TaskDBHelper paramTaskDBHelper, String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1);
    long l1 = ((File)localObject).length();
    long l2 = ((File)localObject).lastModified();
    localObject = ((File)localObject).getName();
    long l3 = paramTaskDBHelper.initUploadTask(paramString1, paramString2, l1, l2);
    if (l3 > 0L)
    {
      paramTaskDBHelper = new UploadJobContext(Long.parseLong(paramString2), l3, paramString1);
      paramTaskDBHelper.setCurSize(0L);
      paramTaskDBHelper.setTotalSize(l1);
      paramTaskDBHelper.setFileName((String)localObject);
      paramTaskDBHelper.setModifyTime(l2);
      return paramTaskDBHelper;
    }
    return null;
  }
  
  public void shutdown()
  {
    cancelAllTask();
    this.mThreadPool.shutdown();
  }
  
  public boolean submitTask(IWyTaskManager.Task paramTask)
  {
    return this.mJobManager.addTask((JobProxy)paramTask);
  }
  
  public static class DefaultJobManager
    extends JobManager
  {
    public DefaultJobManager(ThreadPoolExecutor paramThreadPoolExecutor)
    {
      super();
    }
    
    public DefaultJobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public DefaultJobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt);
    }
    
    protected boolean checkCondition()
    {
      if (!NetworkUtils.hasInternet(SdkContext.getInstance().getContext()))
      {
        Log.w("WyTaskManager", "no internet!");
        return false;
      }
      return true;
    }
  }
  
  public static class DefaultThreadFactory
    implements ThreadFactory
  {
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    public DefaultThreadFactory(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.group = ((ThreadGroup)localObject);
        this.namePrefix = (paramString + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.WyTaskManager
 * JD-Core Version:    0.7.0.1
 */