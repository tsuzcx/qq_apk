package com.qzone.cache.file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.utils.thread.Future;
import com.qzone.utils.thread.ThreadPool;
import com.qzone.utils.thread.ThreadPool.Job;
import com.qzone.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class FileStorageHandler
  implements FileCacheService.StorageHandler
{
  private static final int COUNT_OF_HALF_INTERVAL = 6;
  private static final int MAX_WARN_INTERVAL = 1800000;
  private static final int MINUTE = 60000;
  private static final float STORAGE_EXIST_PERCENTAGE_OFFSET = 0.02F;
  private static final int STORAGE_OP_INTERVAL = 2;
  private static final float STORAGE_REMAIN_PERCENTAGE = 0.1F;
  private static final float STORAGE_REMAIN_PERCENTAGE_EXTREME = 0.05F;
  private static final float STORAGE_WARNING_PERCENTAGE = 0.1F;
  private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
  private final Collector mCollector;
  private final AtomicInteger mCounter = new AtomicInteger(0);
  private long mLastWarnTime;
  private Future mPendingFuture;
  private int mWarnCount;
  
  public FileStorageHandler(Collector paramCollector)
  {
    this.mCollector = paramCollector;
  }
  
  private int calculateRemainSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    if (paramInt2 / paramInt1 < 0.12F) {}
    for (float f = 0.05F;; f = 0.1F) {
      return (int)(paramInt1 * f);
    }
  }
  
  private void notifyStorageWarning(final Context paramContext)
  {
    if (paramContext == null) {}
    while (!shouldShowWarning()) {
      return;
    }
    sMainHandler.post(new Runnable()
    {
      public void run()
      {
        Toast.makeText(paramContext, "手机（或SD卡）存储空间已满，QQ空间的部分功能可能会无法使用，请及时清理", 1).show();
      }
    });
  }
  
  private boolean shouldShowWarning()
  {
    long l1 = ((1.0F - 1.0F / (this.mWarnCount / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    if (l2 - this.mLastWarnTime >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (this.mWarnCount < 2147483647) {
          this.mWarnCount += 1;
        }
        this.mLastWarnTime = l2;
      }
      return bool;
    }
  }
  
  public void onLowStorage(final FileCacheService paramFileCacheService, long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    if (this.mCounter.getAndIncrement() < 2) {
      return;
    }
    this.mCounter.set(0);
    QDLog.w("downloader", "low storage: totalSize=" + paramLong1 + ", availableSize=" + paramLong2 + ", external=" + paramBoolean);
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
    }
    finally {}
    paramFileCacheService = paramFileCacheService.getContext();
    this.mPendingFuture = DownloaderFactory.getGlobalThreadPool().submit(new ThreadPool.Job()
    {
      public Object run(ThreadPool.JobContext paramAnonymousJobContext)
      {
        paramAnonymousJobContext.setMode(1);
        paramAnonymousJobContext = FileStorageHandler.this.mCollector.collect();
        int j;
        int i;
        if (paramAnonymousJobContext != null)
        {
          j = 0;
          i = 0;
          paramAnonymousJobContext = paramAnonymousJobContext.iterator();
          if (paramAnonymousJobContext.hasNext()) {
            break label73;
          }
          if (i > 0) {
            break label177;
          }
        }
        label177:
        for (float f = 3.4028235E+38F;; f = j / i)
        {
          if (f < 0.1F) {
            FileStorageHandler.this.notifyStorageWarning(paramFileCacheService);
          }
          return null;
          label73:
          FileCacheService localFileCacheService = (FileCacheService)paramAnonymousJobContext.next();
          int k = localFileCacheService.getCapacity(paramBoolean);
          int m = localFileCacheService.getSize(paramBoolean);
          int n = FileStorageHandler.this.calculateRemainSize(k, m);
          localFileCacheService.clear(paramBoolean, n);
          QDLog.i("downloader", "clear cache service:" + localFileCacheService + ": remain=" + n);
          j += m;
          i += k;
          break;
        }
      }
    });
  }
  
  public static abstract interface Collector
  {
    public abstract Collection<FileCacheService> collect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.cache.file.FileStorageHandler
 * JD-Core Version:    0.7.0.1
 */