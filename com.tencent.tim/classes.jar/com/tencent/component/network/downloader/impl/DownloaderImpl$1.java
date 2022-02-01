package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DownloaderImpl$1
  implements FutureListener<DownloadResult>
{
  DownloaderImpl$1(DownloaderImpl paramDownloaderImpl, DownloadTask paramDownloadTask) {}
  
  public void onFutureBegin(Future<DownloadResult> arg1)
  {
    if (this.val$task.mOriginalIsHttp2) {
      DownloaderImpl.access$108();
    }
    for (;;)
    {
      synchronized (DownloaderImpl.access$300(this.this$0).obtaionLock(this.val$task.getUrl()))
      {
        synchronized (DownloaderImpl.access$400(this.this$0))
        {
          WeakReference localWeakReference1 = new WeakReference(this.val$task);
          Object localObject4;
          if (localWeakReference1 != null)
          {
            localObject4 = (List)DownloaderImpl.access$500(this.this$0).get(this.val$task.getUrl());
            if (localObject4 == null)
            {
              localObject4 = new ArrayList();
              ((List)localObject4).add(localWeakReference1);
              DownloaderImpl.access$500(this.this$0).put(this.val$task.getUrl(), localObject4);
            }
          }
          else
          {
            return;
            DownloaderImpl.access$208();
            continue;
          }
          Iterator localIterator = ((List)localObject4).iterator();
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference2 = (WeakReference)localIterator.next();
            if ((localWeakReference2 == null) || ((DownloadTask)localWeakReference2.get() != this.val$task)) {
              continue;
            }
            i = 0;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference1);
          }
        }
      }
      int i = 1;
    }
  }
  
  public void onFutureDone(Future<DownloadResult> paramFuture)
  {
    if (QDLog.isDebugEnable()) {
      QDLog.d("Downloader", "download onFutureDone " + this.val$task.getUrl());
    }
    if (this.val$task.mOriginalIsHttp2) {
      DownloaderImpl.access$110();
    }
    Object localObject5;
    DownloadResult localDownloadResult;
    long l1;
    Object localObject11;
    Object localObject9;
    for (;;)
    {
      localObject5 = this.val$task.getUrlKey();
      synchronized (DownloaderImpl.access$600(this.this$0))
      {
        DownloaderImpl.access$600(this.this$0).remove(localObject5);
        localDownloadResult = (DownloadResult)paramFuture.get();
        if (QDLog.isDebugEnable())
        {
          if (localDownloadResult != null)
          {
            l1 = -1L;
            if (localDownloadResult.getPath() != null) {
              l1 = new File(localDownloadResult.getPath()).length();
            }
            QDLog.d("Downloader", "download result: " + localDownloadResult.getStatus().isSucceed() + " path:" + localDownloadResult.getPath() + " length:" + l1);
          }
        }
        else
        {
          if (localDownloadResult != null)
          {
            ??? = localDownloadResult.getReport();
            ??? = localDownloadResult.getStatus();
            if ((??? != null) && (??? != null)) {
              DownloaderImpl.access$700((DownloadReport)???, (DownloadResult.Status)???, this.val$task.mOriginalIsHttp2);
            }
          }
          System.currentTimeMillis();
          localObject11 = DownloaderImpl.access$300(this.this$0).obtaionLock(this.val$task.getUrl());
        }
      }
      try
      {
        Object localObject10;
        synchronized (DownloaderImpl.access$400(this.this$0))
        {
          if (DownloaderImpl.access$500(this.this$0).containsKey(this.val$task.getUrl()))
          {
            localObject9 = (List)DownloaderImpl.access$500(this.this$0).get(this.val$task.getUrl());
            if (localObject9 != null)
            {
              localObject10 = ((List)localObject9).iterator();
              do
              {
                if (!((Iterator)localObject10).hasNext()) {
                  break;
                }
                ??? = (WeakReference)((Iterator)localObject10).next();
              } while ((??? == null) || ((DownloadTask)((WeakReference)???).get() != this.val$task));
              if (??? != null)
              {
                ((List)localObject9).remove(???);
                if (((List)localObject9).size() <= 0) {
                  DownloaderImpl.access$500(this.this$0).remove(this.val$task.getUrl());
                }
              }
            }
          }
          if ((localDownloadResult != null) && (localDownloadResult.getStatus().isRetrying()))
          {
            if (QDLog.isDebugEnable()) {
              QDLog.d("Downloader", "download result: " + this.val$task.getUrl() + " isRetrying");
            }
            if (localDownloadResult != null) {}
            for (;;)
            {
              try
              {
                if (!paramFuture.isCancelled())
                {
                  if (DownloaderImpl.access$1300(this.this$0) != null) {
                    DownloaderImpl.access$1400(this.this$0).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
                  }
                  if (((localDownloadResult.getStatus().isSucceed()) || (DownloaderImpl.access$1500(this.this$0) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
                    FileUtils.delete(new File(localDownloadResult.getPath()));
                  }
                }
              }
              catch (Throwable paramFuture)
              {
                DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
                continue;
              }
              finally
              {
                DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
              }
              try
              {
                DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
                return;
              }
              finally {}
            }
            DownloaderImpl.access$210();
            continue;
            paramFuture = finally;
            throw paramFuture;
            QDLog.d("Downloader", "download result: null");
          }
        }
        try
        {
          if (!paramFuture.isCancelled())
          {
            if (DownloaderImpl.access$1300(this.this$0) != null) {
              DownloaderImpl.access$1400(this.this$0).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
            }
            if (((localDownloadResult.getStatus().isSucceed()) || (DownloaderImpl.access$1500(this.this$0) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
              FileUtils.delete(new File(localDownloadResult.getPath()));
            }
          }
        }
        catch (Throwable paramFuture)
        {
          for (;;)
          {
            Collection localCollection;
            int i;
            ArrayList localArrayList;
            Iterator localIterator;
            DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
          }
        }
        finally
        {
          DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
        }
      }
      finally
      {
        if (localDownloadResult == null) {}
      }
    }
    throw localObject3;
    localCollection = DownloaderImpl.access$800(this.this$0, (String)localObject5, true, null);
    if ((localDownloadResult == null) || (!localDownloadResult.getStatus().isSucceed()))
    {
      if (!DownloaderImpl.access$900(this.this$0, this.val$task)) {
        DownloaderImpl.access$1000(this.this$0, localCollection, localDownloadResult);
      }
      label848:
      if (localDownloadResult == null) {}
    }
    Object localObject4;
    int m;
    try
    {
      if (!paramFuture.isCancelled())
      {
        if (DownloaderImpl.access$1300(this.this$0) != null) {
          DownloaderImpl.access$1400(this.this$0).onDownloadResult(localDownloadResult.getUrl(), localDownloadResult.getStatus().isSucceed());
        }
        if (((localDownloadResult.getStatus().isSucceed()) || (DownloaderImpl.access$1500(this.this$0) == null)) && (!TextUtils.isEmpty(localDownloadResult.getPath()))) {
          FileUtils.delete(new File(localDownloadResult.getPath()));
        }
      }
    }
    catch (Throwable paramFuture)
    {
      for (;;)
      {
        DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
      }
    }
    finally
    {
      DownloaderImpl.access$300(this.this$0).releaseLock(this.val$task.getUrl());
    }
    return;
    i = 0;
    label1016:
    int n;
    label1061:
    int j;
    label1083:
    int k;
    label1113:
    label1121:
    label1268:
    Object localObject6;
    if (localCollection != null)
    {
      localArrayList = new ArrayList();
      localObject9 = new File(localDownloadResult.getPath());
      localObject4 = null;
      l1 = ((File)localObject9).length();
      localIterator = localCollection.iterator();
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          DownloadRequest localDownloadRequest = (DownloadRequest)localIterator.next();
          if ((localDownloadRequest != null) && (!localDownloadRequest.isCanceled())) {
            if (localDownloadRequest.shouldCacheEntry())
            {
              i = 1;
              String[] arrayOfString = localDownloadRequest.getPaths();
              if (arrayOfString != null)
              {
                m = 0;
                n = arrayOfString.length;
                j = 0;
                k = m;
                if (j >= n) {
                  break label1820;
                }
                if (!localArrayList.contains(arrayOfString[j])) {
                  break label1828;
                }
                k = 1;
                break label1820;
                int i1 = arrayOfString.length;
                m = 0;
                localObject5 = localObject4;
                if (m >= i1) {
                  break label1858;
                }
                String str = arrayOfString[m];
                if (TextUtils.isEmpty(str))
                {
                  localObject5 = localObject4;
                  break label1835;
                }
                localObject5 = localObject4;
                if (DownloaderImpl.access$1100(this.this$0, localDownloadResult, localDownloadRequest)) {
                  break label1835;
                }
                localObject5 = localObject4;
                if (localDownloadResult.getPath() == null) {
                  break label1835;
                }
                boolean bool = localArrayList.contains(str);
                localObject5 = localObject4;
                if (bool) {
                  break label1835;
                }
                k = 1;
                j = 0;
                label1209:
                if ((k >= 0) && (j == 0)) {
                  n = k - 1;
                }
                try
                {
                  localObject10 = new File(str);
                  if ((localObject4 != null) && (localObject4.exists())) {
                    break label1804;
                  }
                  bool = FileUtils.rename((File)localObject9, (File)localObject10);
                  if (!bool) {
                    break label1801;
                  }
                  j = 1;
                  localObject4 = localObject10;
                  localObject5 = localObject4;
                  try
                  {
                    QDLog.i("Downloader", "download file rename from " + ((File)localObject9).getPath() + " to:" + str + " " + this.val$task.getUrl() + " result:" + bool + " src-length:" + l1 + " dst-length:" + ((File)localObject10).length());
                    label1364:
                    k = j;
                    if (j != 0) {
                      break label1848;
                    }
                    if (localObject4 == null) {
                      break label1807;
                    }
                    localObject5 = localObject4;
                    if (!localObject4.exists()) {
                      break label1807;
                    }
                    ??? = localObject4;
                    label1392:
                    localObject5 = localObject4;
                    bool = FileUtils.copyFiles((File)???, (File)localObject10);
                    localObject5 = localObject4;
                    long l2 = ((File)localObject10).length();
                    localObject5 = localObject4;
                    QDLog.i("Downloader", "download file copy from " + ((File)???).getPath() + " to:" + str + " " + this.val$task.getUrl() + " result:" + bool + " src-length:" + l1 + " dst-length:" + l2 + " retry:" + n);
                    if ((bool) && (l1 == l2))
                    {
                      k = 1;
                    }
                    else
                    {
                      localObject5 = localObject4;
                      FileUtils.delete((File)localObject10);
                      k = j;
                    }
                  }
                  catch (Throwable localThrowable2)
                  {
                    localObject4 = localObject5;
                    localObject5 = localThrowable2;
                  }
                }
                catch (Throwable localThrowable1)
                {
                  label1564:
                  break label1564;
                }
                QDLog.w("Downloader", "download ------- copy exception!!! " + this.val$task.getUrl(), (Throwable)localObject5);
                localObject5 = localObject4;
                break label1835;
                if (j != 0)
                {
                  localArrayList.add(str);
                  localObject5 = localObject4;
                  break label1858;
                }
                FileUtils.delete(new File(str));
                localObject5 = localObject4;
                break label1835;
              }
              localObject6 = localObject4;
              if (localDownloadRequest.outputStream == null) {
                break label1858;
              }
              FileUtils.copyFile(localDownloadResult.getPath(), localDownloadRequest.outputStream);
              localObject6 = localObject4;
              break label1858;
            }
          }
        }
      }
    }
    for (;;)
    {
      DownloaderImpl.access$1200(this.this$0, localCollection, localDownloadResult);
      if (i == 0) {
        break label848;
      }
      this.this$0.addCacheEntry(this.val$task.getUrl(), localDownloadResult);
      break label848;
      break label1061;
      label1801:
      break label1268;
      label1804:
      break label1364;
      label1807:
      Object localObject8 = localObject9;
      break label1392;
      localObject4 = null;
      break;
      label1820:
      if (k == 0) {
        break label1113;
      }
      break label1016;
      label1828:
      j += 1;
      break label1083;
      label1835:
      m += 1;
      localObject4 = localObject6;
      break label1121;
      label1848:
      j = k;
      k = n;
      break label1209;
      label1858:
      localObject4 = localObject6;
      break label1016;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */