package com.tencent.weiyun.transmission.upload;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus.StatusChangeListener;
import com.tencent.weiyun.transmission.upload.processor.InfoRecorder;
import com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback;
import com.tencent.weiyun.transmission.upload.processor.LocalProcessor;
import com.tencent.weiyun.transmission.upload.processor.LocalProcessor.LocalProcessorCallback;
import com.tencent.weiyun.transmission.upload.processor.UrlFetcher;
import com.tencent.weiyun.transmission.upload.processor.UrlFetcher.UrlFetcherCallback;
import com.tencent.weiyun.transmission.upload.uploader.UploaderAgent;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class UploadManager
  implements Handler.Callback, WeiyunTransmissionStatus.StatusChangeListener, InfoRecorder.InfoRecorderCallback, LocalProcessor.LocalProcessorCallback, UrlFetcher.UrlFetcherCallback, IUploader.IUploadListener
{
  private static final AtomicInteger FLOW_ID = new AtomicInteger(0);
  private static final int MSG_NOTIFY_JOB_ADDED = 1;
  private static final int MSG_NOTIFY_STATUS_CHANGED = 2;
  private static final String TAG = "UploadManager";
  private static final AtomicLong WORKING_ID = new AtomicLong(-1L);
  private static Singleton<UploadManager, Void> sInstance = new UploadManager.1();
  private final UploadJobCounter mCounter;
  private UploadJobCounter mCustomCounter;
  private final HashSet<Long> mFailedJobs = new HashSet();
  private final DualHashMap<Long, String> mFlowIds = new DualHashMap();
  private final HashSet<IUploadStatusListener> mGlobalObservers = new HashSet();
  private final InfoRecorder mInfoRecorder;
  private final HashMap<Long, UploadJobContext> mJobs = new HashMap();
  private final LocalProcessor mLocalProcessor;
  private final ReleaseLooperHandler mNotifyHandler;
  private final ThreadPoolWrapper mThreadPool;
  private final UploaderAgent mUploaderAgent;
  private final UrlFetcher mUrlFetcher;
  private final HashSet<Long> mWaitNetJobs = new HashSet();
  
  private UploadManager()
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    ReleaseLooperHandler localReleaseLooperHandler = new ReleaseLooperHandler("weiyun_upload_work_thread");
    this.mInfoRecorder = new InfoRecorder(this, localReleaseLooperHandler);
    this.mLocalProcessor = new LocalProcessor(localContext, this, localReleaseLooperHandler);
    this.mUrlFetcher = new UrlFetcher(this, localReleaseLooperHandler);
    this.mUploaderAgent = new UploaderAgent(localContext, localReleaseLooperHandler);
    this.mUploaderAgent.setNetType(NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext()));
    this.mCounter = new UploadJobCounter();
    this.mThreadPool = new ThreadPoolWrapper("UploadManager");
    this.mNotifyHandler = new ReleaseLooperHandler("weiyun_upload_notifier");
    this.mNotifyHandler.addCallback(this);
  }
  
  private void changeStatus(UploadJobContext paramUploadJobContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramUploadJobContext == null) {}
    boolean bool1;
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        bool1 = true;
        i = paramInt1;
      }
    } while (!bool1);
    paramInt1 = paramUploadJobContext.statusInfo().state;
    paramUploadJobContext.statusInfo().state = i;
    paramUploadJobContext.statusInfo().errorCode = paramInt2;
    paramUploadJobContext.statusInfo().errorMsg = UploadHelper.convertErrorMessage(paramInt2, paramString);
    this.mInfoRecorder.updateInfo(paramUploadJobContext, true);
    updateCounter(paramUploadJobContext, paramInt1, i);
    TsLog.d("UploadManager", "changeStatus: id=" + paramUploadJobContext.dbId() + ", fileName=" + paramUploadJobContext.file().fileName + ", oldState=" + paramInt1 + ", newState=" + i + ", errorCode=" + paramInt2 + ", canceled=" + paramUploadJobContext.isCanceled());
    return;
    int i = 1;
    paramInt1 = 1;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  if ((i != 0) || (paramUploadJobContext.statusInfo().canRestart()))
                  {
                    bool2 = true;
                    label225:
                    bool1 = bool2;
                    i = paramInt1;
                    if (!bool2) {
                      break;
                    }
                    synchronized (this.mWaitNetJobs)
                    {
                      this.mWaitNetJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                    }
                  }
                  synchronized (this.mFailedJobs)
                  {
                    this.mFailedJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                    paramUploadJobContext.setCanceled(false);
                    bool1 = bool2;
                    i = paramInt1;
                    break;
                    bool2 = false;
                    break label225;
                    paramUploadJobContext = finally;
                    throw paramUploadJobContext;
                  }
                }
                bool1 = paramUploadJobContext.statusInfo().canRunning();
                i = paramInt1;
                break;
                bool1 = paramUploadJobContext.statusInfo().canRunning();
                i = paramInt1;
                break;
                boolean bool2 = paramUploadJobContext.statusInfo().canSuspend();
                bool1 = bool2;
                i = paramInt1;
                if (!bool2) {
                  break;
                }
                synchronized (this.mWaitNetJobs)
                {
                  this.mWaitNetJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                  paramUploadJobContext.resetRank();
                  paramUploadJobContext.setIgnoreNetLimit(false);
                  paramUploadJobContext.setCanceled(true);
                  this.mUploaderAgent.cancel(paramUploadJobContext.uploadRequest());
                  bool1 = bool2;
                  i = paramInt1;
                }
              }
              if (paramInt2 == 1810002)
              {
                synchronized (this.mJobs)
                {
                  this.mJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                  synchronized (this.mFlowIds)
                  {
                    this.mFlowIds.removeByKey(Long.valueOf(paramUploadJobContext.dbId()));
                    synchronized (this.mWaitNetJobs)
                    {
                      this.mWaitNetJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                    }
                  }
                }
                synchronized (this.mFailedJobs)
                {
                  this.mFailedJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
                  paramUploadJobContext.resetRank();
                  paramUploadJobContext.setCanceled(true);
                  this.mUploaderAgent.cancel(paramUploadJobContext.uploadRequest());
                  bool1 = true;
                  i = 0;
                  break;
                  paramUploadJobContext = finally;
                  throw paramUploadJobContext;
                  paramUploadJobContext = finally;
                  throw paramUploadJobContext;
                  paramUploadJobContext = finally;
                  throw paramUploadJobContext;
                }
              }
            }
            if ((paramInt2 == 1810003) || (paramInt2 == 1810004))
            {
              paramUploadJobContext.resetRank();
              synchronized (this.mWaitNetJobs)
              {
                this.mWaitNetJobs.add(Long.valueOf(paramUploadJobContext.dbId()));
                bool1 = true;
                i = 1;
              }
            }
          }
          synchronized (this.mFailedJobs)
          {
            this.mFailedJobs.add(Long.valueOf(paramUploadJobContext.dbId()));
            bool1 = true;
            i = paramInt1;
          }
        }
        synchronized (this.mJobs)
        {
          this.mJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
          synchronized (this.mFlowIds)
          {
            this.mFlowIds.removeByKey(Long.valueOf(paramUploadJobContext.dbId()));
            synchronized (this.mWaitNetJobs)
            {
              this.mWaitNetJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
            }
          }
        }
        synchronized (this.mFailedJobs)
        {
          this.mFailedJobs.remove(Long.valueOf(paramUploadJobContext.dbId()));
          paramUploadJobContext.statusInfo().currSize = paramUploadJobContext.statusInfo().totalSize;
          paramUploadJobContext.statusInfo().jobContext = paramUploadJobContext;
          break;
          paramUploadJobContext = finally;
          throw paramUploadJobContext;
          paramUploadJobContext = finally;
          throw paramUploadJobContext;
          paramUploadJobContext = finally;
          throw paramUploadJobContext;
        }
      }
      i = 0;
    }
  }
  
  private void dispatch(long paramLong, boolean paramBoolean)
  {
    WORKING_ID.compareAndSet(paramLong, -1L);
    if (paramBoolean) {
      this.mThreadPool.submit(new UploadManager.6(this));
    }
  }
  
  public static UploadManager getInstance()
  {
    return (UploadManager)sInstance.get(null);
  }
  
  private void handleFinished(UploadJobContext paramUploadJobContext, int paramInt1, int paramInt2, String paramString)
  {
    changeStatus(paramUploadJobContext, paramInt1, paramInt2, paramString);
    dispatch(paramUploadJobContext.dbId(), true);
  }
  
  private boolean isNetAvailable(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((paramBoolean) || (!bool)) {
      return NetworkUtils.isNetworkAvailable(localContext);
    }
    return NetworkUtils.isWifiAvailable(localContext);
  }
  
  private void notifyFlowId(int paramInt, UploadJobContext paramUploadJobContext)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    synchronized (this.mFlowIds)
    {
      this.mFlowIds.put(Long.valueOf(paramUploadJobContext.dbId()), Integer.toString(paramInt));
      paramUploadJobContext = Message.obtain(null, 1, new Object[] { paramUploadJobContext.listeners(), Integer.toString(paramInt), Long.valueOf(paramUploadJobContext.dbId()) });
      this.mNotifyHandler.sendMessage(paramUploadJobContext);
      return;
    }
  }
  
  private void notifyProgress(UploadJobContext paramUploadJobContext, boolean paramBoolean)
  {
    int i = 1;
    if (paramUploadJobContext == null) {
      return;
    }
    Set localSet = paramUploadJobContext.listeners();
    String str = paramUploadJobContext.uid();
    long l = paramUploadJobContext.dbId();
    paramUploadJobContext = paramUploadJobContext.cloneStatusInfo();
    if (paramBoolean) {}
    for (;;)
    {
      paramUploadJobContext = Message.obtain(null, 2, i, 0, new Object[] { localSet, str, Long.valueOf(l), paramUploadJobContext });
      this.mNotifyHandler.sendMessage(paramUploadJobContext);
      return;
      i = 0;
    }
  }
  
  private boolean removeJobInner(long paramLong)
  {
    this.mInfoRecorder.removeInfo(paramLong, true);
    return true;
  }
  
  private boolean restartJobInner(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext1 = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext1 == null) {
        return false;
      }
    }
    if (paramBoolean1) {
      localUploadJobContext2.setPriority(paramBoolean2);
    }
    if (paramBoolean3) {
      localUploadJobContext2.setIgnoreNetLimit(paramBoolean4);
    }
    changeStatus(localUploadJobContext2, 1, 0, null);
    return true;
  }
  
  private void startManager(String paramString)
  {
    try
    {
      this.mInfoRecorder.restoreInfo(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private void stopManager()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	com/tencent/weiyun/transmission/upload/UploadManager:mLocalProcessor	Lcom/tencent/weiyun/transmission/upload/processor/LocalProcessor;
    //   6: invokevirtual 451	com/tencent/weiyun/transmission/upload/processor/LocalProcessor:cancelAll	()V
    //   9: aload_0
    //   10: getfield 146	com/tencent/weiyun/transmission/upload/UploadManager:mUrlFetcher	Lcom/tencent/weiyun/transmission/upload/processor/UrlFetcher;
    //   13: invokevirtual 452	com/tencent/weiyun/transmission/upload/processor/UrlFetcher:cancelAll	()V
    //   16: aload_0
    //   17: getfield 153	com/tencent/weiyun/transmission/upload/UploadManager:mUploaderAgent	Lcom/tencent/weiyun/transmission/upload/uploader/UploaderAgent;
    //   20: invokevirtual 453	com/tencent/weiyun/transmission/upload/uploader/UploaderAgent:cancelAll	()V
    //   23: aload_0
    //   24: getfield 153	com/tencent/weiyun/transmission/upload/UploadManager:mUploaderAgent	Lcom/tencent/weiyun/transmission/upload/uploader/UploaderAgent;
    //   27: invokevirtual 456	com/tencent/weiyun/transmission/upload/uploader/UploaderAgent:speedDown	()V
    //   30: aload_0
    //   31: getfield 99	com/tencent/weiyun/transmission/upload/UploadManager:mJobs	Ljava/util/HashMap;
    //   34: astore_1
    //   35: aload_1
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 99	com/tencent/weiyun/transmission/upload/UploadManager:mJobs	Ljava/util/HashMap;
    //   41: invokevirtual 459	java/util/HashMap:clear	()V
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 104	com/tencent/weiyun/transmission/upload/UploadManager:mFlowIds	Lcom/tencent/weiyun/utils/DualHashMap;
    //   50: astore_1
    //   51: aload_1
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 104	com/tencent/weiyun/transmission/upload/UploadManager:mFlowIds	Lcom/tencent/weiyun/utils/DualHashMap;
    //   57: invokevirtual 460	com/tencent/weiyun/utils/DualHashMap:clear	()V
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_0
    //   63: getfield 106	com/tencent/weiyun/transmission/upload/UploadManager:mWaitNetJobs	Ljava/util/HashSet;
    //   66: astore_1
    //   67: aload_1
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 106	com/tencent/weiyun/transmission/upload/UploadManager:mWaitNetJobs	Ljava/util/HashSet;
    //   73: invokevirtual 461	java/util/HashSet:clear	()V
    //   76: aload_1
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 108	com/tencent/weiyun/transmission/upload/UploadManager:mFailedJobs	Ljava/util/HashSet;
    //   82: astore_1
    //   83: aload_1
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 108	com/tencent/weiyun/transmission/upload/UploadManager:mFailedJobs	Ljava/util/HashSet;
    //   89: invokevirtual 461	java/util/HashSet:clear	()V
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 167	com/tencent/weiyun/transmission/upload/UploadManager:mCounter	Lcom/tencent/weiyun/transmission/upload/UploadJobCounter;
    //   98: invokevirtual 464	com/tencent/weiyun/transmission/upload/UploadJobCounter:reset	()V
    //   101: aload_0
    //   102: getfield 466	com/tencent/weiyun/transmission/upload/UploadManager:mCustomCounter	Lcom/tencent/weiyun/transmission/upload/UploadJobCounter;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 466	com/tencent/weiyun/transmission/upload/UploadManager:mCustomCounter	Lcom/tencent/weiyun/transmission/upload/UploadJobCounter;
    //   112: invokevirtual 464	com/tencent/weiyun/transmission/upload/UploadJobCounter:reset	()V
    //   115: getstatic 72	com/tencent/weiyun/transmission/upload/UploadManager:FLOW_ID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   118: iconst_0
    //   119: invokevirtual 469	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   122: getstatic 81	com/tencent/weiyun/transmission/upload/UploadManager:WORKING_ID	Ljava/util/concurrent/atomic/AtomicLong;
    //   125: ldc2_w 75
    //   128: invokevirtual 471	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   131: aload_0
    //   132: monitorexit
    //   133: return
    //   134: astore_2
    //   135: aload_1
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: astore_2
    //   145: aload_1
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_1
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    //   154: astore_2
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	UploadManager
    //   139	17	1	localObject2	Object
    //   134	4	2	localObject3	Object
    //   144	4	2	localObject4	Object
    //   149	4	2	localObject5	Object
    //   154	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   37	46	134	finally
    //   135	137	134	finally
    //   2	37	139	finally
    //   46	53	139	finally
    //   62	69	139	finally
    //   78	85	139	finally
    //   94	115	139	finally
    //   115	131	139	finally
    //   137	139	139	finally
    //   147	149	139	finally
    //   152	154	139	finally
    //   157	159	139	finally
    //   53	62	144	finally
    //   145	147	144	finally
    //   69	78	149	finally
    //   150	152	149	finally
    //   85	94	154	finally
    //   155	157	154	finally
  }
  
  private boolean suspendJobInner(long paramLong)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext1 = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext1 == null) {
        return false;
      }
    }
    changeStatus(localUploadJobContext2, 4, 0, null);
    return true;
  }
  
  private void updateCounter(UploadJobContext paramUploadJobContext, int paramInt1, int paramInt2)
  {
    UploadJobCounter localUploadJobCounter1 = this.mCounter.clone();
    UploadJobCounter localUploadJobCounter2 = this.mCounter.update(paramUploadJobContext, paramInt1, paramInt2);
    int i = localUploadJobCounter1.wait;
    int j = localUploadJobCounter1.compressing;
    int k = localUploadJobCounter1.running;
    i = localUploadJobCounter1.autoBackup + (i + j + k);
    j = localUploadJobCounter2.wait;
    k = localUploadJobCounter2.compressing;
    int m = localUploadJobCounter2.running;
    j = localUploadJobCounter2.autoBackup + (j + k + m);
    if ((i <= 0) && (j > 0)) {
      UploadHelper.acquireWakeLockIfNot();
    }
    for (;;)
    {
      if (this.mCustomCounter != null) {
        this.mCustomCounter.update(paramUploadJobContext, paramInt1, paramInt2);
      }
      return;
      if ((i > 0) && (j <= 0)) {
        UploadHelper.releaseWakeLockIfExist();
      }
    }
  }
  
  private void updateWaitNetJobs()
  {
    ??? = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool1 = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    boolean bool2 = NetworkUtils.isNetworkAvailable((Context)???);
    if ((NetworkUtils.isWifiAvailable((Context)???)) || ((!bool1) && (bool2)))
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.mWaitNetJobs)
      {
        localArrayList.addAll(this.mWaitNetJobs);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          break label278;
        }
        restartJobInner(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    Iterator localIterator;
    for (;;)
    {
      UploadJobContext localUploadJobContext;
      synchronized (this.mJobs)
      {
        localIterator = this.mJobs.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label276;
        }
        localUploadJobContext = (UploadJobContext)((Map.Entry)localIterator.next()).getValue();
        if ((localUploadJobContext.isIgnoreNetLimit()) || (!bool1)) {
          break label287;
        }
        if (!localUploadJobContext.statusInfo().canSuspend()) {
          continue;
        }
        localUploadJobContext.setCanceled(true);
        this.mUploaderAgent.cancel(localUploadJobContext.uploadRequest());
        changeStatus(localUploadJobContext, 6, 1810004, null);
        dispatch(localUploadJobContext.dbId(), false);
      }
      if ((localUploadJobContext.isIgnoreNetLimit()) && (localUploadJobContext.statusInfo().waitingNet()))
      {
        restartJobInner(localUploadJobContext.dbId(), false, false, false, false);
        continue;
        label276:
        label278:
        dispatch(-1L, true);
        return;
        label287:
        if (bool2) {
          break;
        }
      }
    }
  }
  
  public void addGlobalObserver(IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mGlobalObservers)
      {
        this.mGlobalObservers.add(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public boolean addJobListener(long paramLong, IUploadStatusListener paramIUploadStatusListener)
  {
    UploadJobContext localUploadJobContext;
    synchronized (this.mJobs)
    {
      localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return false;
      }
    }
    localUploadJobContext.addListener(paramIUploadStatusListener);
    return true;
  }
  
  String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return this.mUploaderAgent.calSliceSha1(paramString, paramCanceledFlag);
  }
  
  public boolean canRestartAll()
  {
    UploadJobCounter localUploadJobCounter = this.mCounter.clone();
    int i = localUploadJobCounter.failed;
    return localUploadJobCounter.suspend + i > 0;
  }
  
  public boolean canSuspendAll()
  {
    UploadJobCounter localUploadJobCounter = this.mCounter.clone();
    int i = localUploadJobCounter.wait;
    int j = localUploadJobCounter.compressing;
    return localUploadJobCounter.running + (i + j) > 0;
  }
  
  public UploadJobContext getJobContext(long paramLong)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return null;
      }
    }
    return UploadJobContext.createInstance(localObject.uid(), localObject.file().clone(), localObject.statusInfo().clone());
  }
  
  public UploadJobContext.StatusInfo getJobStatus(long paramLong)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return null;
      }
    }
    return localObject.cloneStatusInfo();
  }
  
  public UploadJobCounter getJobsCounter()
  {
    return this.mCounter.clone();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (Object[])paramMessage.obj;
      ??? = (Set)paramMessage[0];
      synchronized (this.mGlobalObservers)
      {
        ((Set)???).addAll(this.mGlobalObservers);
        ??? = ((Set)???).iterator();
        do
        {
          if (!((Iterator)???).hasNext()) {
            break;
          }
          ??? = (IUploadStatusListener)((Iterator)???).next();
        } while (??? == null);
        ((IUploadStatusListener)???).onUploadJobAdded((String)paramMessage[1], ((Long)paramMessage[2]).longValue());
      }
    }
    if (paramMessage.what == 2)
    {
      ??? = (Object[])paramMessage.obj;
      Object localObject3 = (Set)???[0];
      for (;;)
      {
        synchronized (this.mGlobalObservers)
        {
          ((Set)localObject3).addAll(this.mGlobalObservers);
          ??? = ((Set)localObject3).iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject3 = (IUploadStatusListener)((Iterator)???).next();
          if (localObject3 == null) {
            continue;
          }
          String str = (String)???[1];
          long l = ((Long)???[2]).longValue();
          UploadJobContext.StatusInfo localStatusInfo = (UploadJobContext.StatusInfo)???[3];
          if (paramMessage.arg1 == 1)
          {
            bool = true;
            ((IUploadStatusListener)localObject3).onUploadStatusChanged(str, l, localStatusInfo, bool);
          }
        }
        boolean bool = false;
      }
    }
    return true;
  }
  
  public void init()
  {
    WeiyunTransmissionStatus.getInstance().addListener(5, this);
    WeiyunTransmissionStatus.getInstance().addListener(4, this);
    WeiyunTransmissionStatus.getInstance().addListener(3, this);
  }
  
  public void loadLibFromPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mUploaderAgent.loadLibFromPath(paramString);
    }
  }
  
  public void onFetchError(long paramLong, int paramInt, String paramString)
  {
    UploadJobContext localUploadJobContext;
    synchronized (this.mJobs)
    {
      localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return;
      }
    }
    if (!localUploadJobContext.isCanceled())
    {
      if (!TextUtils.isEmpty(localUploadJobContext.file().coverFileId)) {
        localUploadJobContext.statusInfo().fileId = localUploadJobContext.file().coverFileId;
      }
      if (!NetworkUtils.isNetworkAvailable(WeiyunTransmissionGlobal.getInstance().getContext()))
      {
        handleFinished(localUploadJobContext, 6, 1810004, null);
        return;
      }
      handleFinished(localUploadJobContext, 6, paramInt, paramString);
    }
  }
  
  public void onFetchSuccess(long paramLong, UploadFile paramUploadFile)
  {
    UploadJobContext localUploadJobContext;
    synchronized (this.mJobs)
    {
      localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return;
      }
    }
    if (!localUploadJobContext.isCanceled())
    {
      ??? = paramUploadFile.serverInfo;
      if (??? == null)
      {
        handleFinished(localUploadJobContext, 6, 1810024, null);
        return;
      }
      if ((!((UploadFile.UploadServerInfo)???).fileExist) && (TextUtils.isEmpty(((UploadFile.UploadServerInfo)???).serverIp)) && (TextUtils.isEmpty(((UploadFile.UploadServerInfo)???).serverName)))
      {
        handleFinished(localUploadJobContext, 6, 1810040, null);
        return;
      }
      if (!isNetAvailable(localUploadJobContext.isIgnoreNetLimit()))
      {
        handleFinished(localUploadJobContext, 6, 1810004, null);
        return;
      }
      localUploadJobContext.statisticsTimes().onFetchUrlEnd();
      if (!TextUtils.equals(localUploadJobContext.file().pDirKey, paramUploadFile.pDirKey))
      {
        localUploadJobContext.file().pDirKey = paramUploadFile.pDirKey;
        localUploadJobContext.file().pPDirKey = paramUploadFile.pPDirKey;
        localUploadJobContext.file().pDirName = paramUploadFile.pDirName;
        this.mInfoRecorder.updateInfo(paramLong, localUploadJobContext.file());
      }
      localUploadJobContext.createUploadRequest((UploadFile.UploadServerInfo)???, this);
      localUploadJobContext.setFileVersion(((UploadFile.UploadServerInfo)???).fileVersion);
      localUploadJobContext.statusInfo().fileVersion = ((UploadFile.UploadServerInfo)???).fileVersion;
      if (((UploadFile.UploadServerInfo)???).fileExist)
      {
        this.mUploaderAgent.secondUpload(localUploadJobContext.uploadRequest());
        return;
      }
      if (IOUtils.isFileModified(localUploadJobContext.file().localPath, localUploadJobContext.file().lastModified))
      {
        this.mLocalProcessor.processor(localUploadJobContext);
        return;
      }
      this.mUploaderAgent.upload(localUploadJobContext.uploadRequest());
    }
  }
  
  public void onInfoAdded(int paramInt, UploadJobContext paramUploadJobContext)
  {
    for (;;)
    {
      UploadJobContext localUploadJobContext;
      synchronized (this.mJobs)
      {
        long l = paramUploadJobContext.dbId();
        localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(l));
        if (localUploadJobContext == null)
        {
          this.mJobs.put(Long.valueOf(l), paramUploadJobContext);
          i = 1;
          notifyFlowId(paramInt, paramUploadJobContext);
          if (i == 0)
          {
            localUploadJobContext.increaseRank();
            localUploadJobContext.setBirthTime(paramUploadJobContext.birthTime());
            localUploadJobContext.setPriority(paramUploadJobContext.isPriority());
            localUploadJobContext.setIgnoreNetLimit(paramUploadJobContext.isIgnoreNetLimit());
            localUploadJobContext.addListeners(paramUploadJobContext.listeners());
          }
          if (i != 0)
          {
            changeStatus(paramUploadJobContext, 1, 0, null);
            dispatch(-1L, true);
          }
        }
        else
        {
          if (!localUploadJobContext.statusInfo().canRestart()) {
            break label200;
          }
          paramUploadJobContext.statusInfo().state = localUploadJobContext.statusInfo().state;
          paramUploadJobContext.statusInfo().errorCode = localUploadJobContext.statusInfo().errorCode;
          this.mJobs.put(Long.valueOf(l), paramUploadJobContext);
          i = 1;
        }
      }
      paramUploadJobContext = localUploadJobContext;
      continue;
      label200:
      int i = 0;
    }
  }
  
  public void onInfoRemoved(long paramLong, boolean paramBoolean, UploadJobContext paramUploadJobContext)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext != null) {
        handleFinished(localUploadJobContext, 6, 1810002, null);
      }
      if (paramUploadJobContext != null)
      {
        paramUploadJobContext.statusInfo().state = 0;
        paramUploadJobContext.statusInfo().errorCode = 1810002;
        notifyProgress(paramUploadJobContext, true);
      }
      return;
    }
  }
  
  public void onInfoRestored(String arg1, List<UploadJobContext> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      UploadJobContext localUploadJobContext;
      synchronized (this.mJobs)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label204;
        }
        localUploadJobContext = (UploadJobContext)paramList.next();
        long l = localUploadJobContext.dbId();
        int i = localUploadJobContext.statusInfo().state;
        localUploadJobContext.statusInfo().state = 0;
        this.mJobs.put(Long.valueOf(l), localUploadJobContext);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          changeStatus(localUploadJobContext, 1, 0, null);
        }
      }
      changeStatus(localUploadJobContext, 4, 0, null);
      continue;
      changeStatus(localUploadJobContext, 6, localUploadJobContext.statusInfo().errorCode, localUploadJobContext.statusInfo().errorMsg);
      continue;
      label204:
      dispatch(-1L, true);
      return;
    }
  }
  
  public void onInfoUpdated(long paramLong, boolean paramBoolean1, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean2)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      ??? = localUploadJobContext;
      if (localUploadJobContext != null) {
        break label66;
      }
      if (paramStatusInfo == null) {
        paramStatusInfo = null;
      }
    }
    paramStatusInfo = paramStatusInfo.jobContext;
    label66:
    do
    {
      notifyProgress((UploadJobContext)???, paramBoolean2);
      return;
      ??? = paramStatusInfo;
    } while (paramStatusInfo != null);
  }
  
  public void onLocalResult(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext1 = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext1 == null) {
        return;
      }
    }
    if (!localUploadJobContext2.isCanceled())
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        this.mInfoRecorder.updateInfo(paramLong, localUploadJobContext2.file());
      }
      if (!paramBoolean1)
      {
        handleFinished(localUploadJobContext2, 6, 1810006, null);
        return;
      }
      if (!paramBoolean2)
      {
        handleFinished(localUploadJobContext2, 6, 1810030, null);
        return;
      }
      if (!isNetAvailable(localUploadJobContext2.isIgnoreNetLimit()))
      {
        handleFinished(localUploadJobContext2, 6, 1810004, null);
        return;
      }
      ??? = this.mUrlFetcher;
      if (localUploadJobContext2.file().uploadType == null) {}
      for (int i = UploadType.EXIST_RESUME_RENAME.ordinal();; i = localUploadJobContext2.file().uploadType.ordinal())
      {
        ((UrlFetcher)???).fetchUrl(localUploadJobContext2, i);
        return;
      }
    }
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
    case 4: 
      do
      {
        return;
        if (paramInt3 == 1)
        {
          stopManager();
          return;
        }
      } while (paramInt3 != 0);
      startManager(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
      return;
    case 5: 
      UploadHelper.updateNetworkChange();
      this.mUploaderAgent.setNetType(NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext()));
    }
    this.mThreadPool.submit(new UploadManager.7(this));
  }
  
  public void onUploadCanceled(UploadRequest paramUploadRequest) {}
  
  public void onUploadFinished(UploadRequest paramUploadRequest, boolean paramBoolean, UploadResponse paramUploadResponse)
  {
    long l = Long.parseLong((String)((HashMap)paramUploadRequest.businessData()).get("db_id"));
    UploadJobContext localUploadJobContext;
    synchronized (this.mJobs)
    {
      localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(l));
      if (localUploadJobContext == null) {
        return;
      }
    }
    if (!localUploadJobContext.isCanceled())
    {
      if (paramBoolean)
      {
        localUploadJobContext.statusInfo().fileId = ((String)((HashMap)paramUploadRequest.businessData()).get("file_id"));
        paramUploadRequest = localUploadJobContext.file().compressedPath;
        if (!TextUtils.isEmpty(paramUploadRequest)) {
          IOUtils.deleteFile(new File(paramUploadRequest), true);
        }
        handleFinished(localUploadJobContext, 5, 0, null);
        return;
      }
      int i = UploadHelper.parseUploadResponse(paramUploadResponse);
      if (!localUploadJobContext.isCanceled())
      {
        if (UploadHelper.shouldRetry(i))
        {
          handleFinished(localUploadJobContext, 0, i, null);
          return;
        }
        handleFinished(localUploadJobContext, 6, i, null);
      }
    }
  }
  
  public void onUploadProgress(UploadRequest arg1, long paramLong1, float paramFloat, long paramLong2, long paramLong3, long paramLong4)
  {
    long l1 = Long.parseLong((String)((HashMap)???.businessData()).get("db_id"));
    synchronized (this.mJobs)
    {
      UploadJobContext localUploadJobContext1 = (UploadJobContext)this.mJobs.get(Long.valueOf(l1));
      if (localUploadJobContext1 == null) {
        return;
      }
    }
    if (!localUploadJobContext2.isCanceled())
    {
      long l2 = ((float)paramLong1 * paramFloat);
      localUploadJobContext2.statusInfo().totalSize = paramLong1;
      ??? = localUploadJobContext2.statusInfo();
      l1 = paramLong1;
      if (l2 < paramLong1) {
        l1 = l2;
      }
      ???.currSize = l1;
      localUploadJobContext2.statusInfo().speed = paramLong2;
      localUploadJobContext2.statusInfo().exSpeed = paramLong3;
      localUploadJobContext2.statusInfo().adSpeed = paramLong4;
      if (localUploadJobContext2.statusInfo().canRunning()) {
        changeStatus(localUploadJobContext2, 3, 0, null);
      }
      notifyProgress(localUploadJobContext2, false);
    }
  }
  
  public void removeAll(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      synchronized (this.mJobs)
      {
        Iterator localIterator = this.mJobs.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (TextUtils.equals(paramString, ((UploadJobContext)localEntry.getValue()).statusInfo().fileId)) {
            localArrayList.add(localEntry.getKey());
          }
        }
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        removeJob(((Long)paramString.next()).longValue());
      }
    }
  }
  
  public int removeAllFailed()
  {
    HashSet localHashSet2 = new HashSet();
    synchronized (this.mFailedJobs)
    {
      int i = this.mFailedJobs.size();
      localHashSet2.addAll(this.mFailedJobs);
      if (!localHashSet2.isEmpty()) {
        this.mThreadPool.submit(new UploadManager.4(this, localHashSet2));
      }
      return i;
    }
  }
  
  public void removeGlobalObserver(IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mGlobalObservers)
      {
        this.mGlobalObservers.remove(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public boolean removeJob(long paramLong)
  {
    return removeJobInner(paramLong);
  }
  
  public boolean removeJob(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.mFlowIds)
      {
        paramString = (Long)this.mFlowIds.getByValue(paramString);
        if ((paramString != null) && (removeJobInner(paramString.longValue())))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean removeJobListener(long paramLong, IUploadStatusListener paramIUploadStatusListener)
  {
    UploadJobContext localUploadJobContext;
    synchronized (this.mJobs)
    {
      localUploadJobContext = (UploadJobContext)this.mJobs.get(Long.valueOf(paramLong));
      if (localUploadJobContext == null) {
        return false;
      }
    }
    localUploadJobContext.removeListener(paramIUploadStatusListener);
    return true;
  }
  
  public int restartAll(boolean paramBoolean)
  {
    ??? = this.mCounter.clone();
    int i = ((UploadJobCounter)???).failed;
    int j = ((UploadJobCounter)???).suspend;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mJobs)
    {
      localArrayList.addAll(this.mJobs.keySet());
      if (!localArrayList.isEmpty()) {
        this.mThreadPool.submit(new UploadManager.2(this, localArrayList, paramBoolean));
      }
      return j + i;
    }
  }
  
  public int restartAllFailed()
  {
    HashSet localHashSet2 = new HashSet();
    synchronized (this.mFailedJobs)
    {
      int i = this.mFailedJobs.size();
      localHashSet2.addAll(this.mFailedJobs);
      if (!localHashSet2.isEmpty()) {
        this.mThreadPool.submit(new UploadManager.5(this, localHashSet2));
      }
      return i;
    }
  }
  
  public boolean restartJob(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (restartJobInner(paramLong, paramBoolean1, paramBoolean2, paramBoolean1, paramBoolean3))
    {
      dispatch(-1L, true);
      return true;
    }
    return false;
  }
  
  public void setJobCounter(UploadJobCounter paramUploadJobCounter)
  {
    if (paramUploadJobCounter != null) {
      this.mCustomCounter = paramUploadJobCounter;
    }
  }
  
  public void setSpareUploader(IUploader paramIUploader)
  {
    if (paramIUploader != null) {
      this.mUploaderAgent.setSpareUploader(paramIUploader);
    }
  }
  
  public int suspendAll()
  {
    ??? = this.mCounter.clone();
    int i = ((UploadJobCounter)???).failed;
    int j = ((UploadJobCounter)???).wait;
    int k = ((UploadJobCounter)???).compressing;
    int m = ((UploadJobCounter)???).running;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mJobs)
    {
      localArrayList.addAll(this.mJobs.keySet());
      if (!localArrayList.isEmpty()) {
        this.mThreadPool.submit(new UploadManager.3(this, localArrayList));
      }
      return m + (i + j + k);
    }
  }
  
  public boolean suspendJob(long paramLong)
  {
    if (suspendJobInner(paramLong))
    {
      dispatch(paramLong, true);
      return true;
    }
    return false;
  }
  
  public void trialSpeedUp(int paramInt)
  {
    if (paramInt >= 0) {
      this.mUploaderAgent.trialSpeedUp(paramInt);
    }
  }
  
  public void updateIpConfig(Map<String, Map<String, Object>> paramMap)
  {
    this.mUploaderAgent.saveDirectIpFromWns(paramMap);
  }
  
  public String upload(UploadFile paramUploadFile, boolean paramBoolean1, boolean paramBoolean2, IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramUploadFile == null)
    {
      TsLog.w("UploadManager", "upload: The param file should be valid.");
      return null;
    }
    int i = FLOW_ID.getAndIncrement();
    if (TextUtils.isEmpty(paramUploadFile.fileName)) {
      paramUploadFile.fileName = IOUtils.getFileName(paramUploadFile.localPath);
    }
    UploadJobContext localUploadJobContext = UploadJobContext.createInstance(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), paramUploadFile, new UploadJobContext.StatusInfo());
    localUploadJobContext.setPriority(paramBoolean1);
    localUploadJobContext.setIgnoreNetLimit(paramBoolean2);
    localUploadJobContext.addListener(paramIUploadStatusListener);
    localUploadJobContext.statusInfo().filePath = paramUploadFile.localPath;
    localUploadJobContext.statusInfo().autoBackupFlag = paramUploadFile.autoBackupFlag;
    this.mInfoRecorder.addInfo(i, localUploadJobContext);
    return Integer.toString(i);
  }
  
  public void vipSpeedUp()
  {
    this.mUploaderAgent.vipSpeedUp();
  }
  
  public static abstract interface IUploadStatusListener
  {
    public abstract void onUploadJobAdded(String paramString, long paramLong);
    
    public abstract void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager
 * JD-Core Version:    0.7.0.1
 */