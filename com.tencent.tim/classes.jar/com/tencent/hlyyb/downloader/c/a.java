package com.tencent.hlyyb.downloader.c;

import android.text.TextUtils;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.e.d.c;
import com.tencent.hlyyb.downloader.e.i;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Downloader
{
  private static a a = new a();
  
  private a()
  {
    b.a();
  }
  
  public static a a()
  {
    return a;
  }
  
  public final void addNewTask(DownloaderTask paramDownloaderTask)
  {
    if (!(paramDownloaderTask instanceof i)) {
      throw new RuntimeException("DownloaderTask should be created by Downloader.createNewTask");
    }
    b.a().a(paramDownloaderTask);
  }
  
  public final DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener)
  {
    return createNewTask(paramInt, paramString1, paramString2, paramString3, paramString4, paramDownloaderTaskListener, -1L, "");
  }
  
  public final DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener, long paramLong)
  {
    return createNewTask(paramInt, paramString1, paramString2, paramString3, paramString4, paramDownloaderTaskListener, paramLong, "");
  }
  
  public final DownloaderTask createNewTask(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString5)
  {
    paramString2 = createNewTask(paramString2, paramString3, paramString4, paramDownloaderTaskListener, paramLong, paramString5);
    paramString2.setType(paramInt);
    paramString2.setId(paramString1);
    return paramString2;
  }
  
  public final DownloaderTask createNewTask(String paramString1, String paramString2, String paramString3, DownloaderTaskListener paramDownloaderTaskListener)
  {
    return createNewTask(paramString1, paramString2, paramString3, paramDownloaderTaskListener, -1L, "");
  }
  
  public final DownloaderTask createNewTask(String paramString1, String paramString2, String paramString3, DownloaderTaskListener paramDownloaderTaskListener, long paramLong, String paramString4)
  {
    String str = "";
    if (TextUtils.isEmpty(paramString1))
    {
      str = "url is empty.";
      if (!com.tencent.hlyyb.common.b.b.a(paramString2)) {
        break label84;
      }
      paramString2 = com.tencent.hlyyb.downloader.a.a.b();
    }
    label84:
    for (;;)
    {
      if (!"".equals(str))
      {
        throw new HalleyException(str);
        if (paramDownloaderTaskListener != null) {
          break;
        }
        str = "listener is null.";
        break;
      }
      return new i(new c(paramString1, paramLong), paramString2, paramString3, paramDownloaderTaskListener, paramLong, paramString4);
    }
  }
  
  public final void deleteTask(DownloaderTask paramDownloaderTask, boolean paramBoolean)
  {
    b.a().a(paramDownloaderTask, paramBoolean);
  }
  
  public final void deleteTaskByKey(String paramString, boolean paramBoolean)
  {
    b.a().a(paramString, paramBoolean);
  }
  
  public final void enableUserAction(boolean paramBoolean) {}
  
  public final List<DownloaderTask> getAllTasks()
  {
    return b.a().c();
  }
  
  public final List<DownloaderTask> getCancelledTasks()
  {
    return b.a().a(true, true, false, false, true, false, false);
  }
  
  public final List<DownloaderTask> getCompletedTasks()
  {
    return b.a().a(true, true, false, false, false, false, true);
  }
  
  public final List<DownloaderTask> getFailedTasks()
  {
    return b.a().a(true, true, false, false, false, true, false);
  }
  
  public final List<DownloaderTask> getIncompleteTasks()
  {
    return b.a().a(true, true, true, true, true, true, false);
  }
  
  public final List<DownloaderTask> getRunningTasks()
  {
    return b.a().d();
  }
  
  public final String getVersion()
  {
    return com.tencent.hlyyb.common.a.e();
  }
  
  public final List<DownloaderTask> getWaitingTasks()
  {
    return b.a().a(true, true, false, true, false, false, false);
  }
  
  public final void pauseTasks(boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = b.a().a(true, true, paramBoolean1, paramBoolean2, false, false, false).iterator();
    while (localIterator.hasNext()) {
      ((DownloaderTask)localIterator.next()).pause();
    }
  }
  
  public final void resumeTasks(boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = b.a().a(true, true, false, false, paramBoolean1, paramBoolean2, false).iterator();
    while (localIterator.hasNext())
    {
      DownloaderTask localDownloaderTask = (DownloaderTask)localIterator.next();
      try
      {
        localDownloaderTask.resume();
      }
      catch (HalleyException localHalleyException)
      {
        localHalleyException.printStackTrace();
      }
    }
  }
  
  public final void setNotNetworkWaitMillis(int paramInt)
  {
    com.tencent.hlyyb.downloader.a.a.b(paramInt);
  }
  
  public final void setPhoneGuid(String paramString)
  {
    com.tencent.hlyyb.downloader.a.a.c(paramString);
  }
  
  public final void setProgressInterval(int paramInt)
  {
    com.tencent.hlyyb.downloader.a.a.a(paramInt);
  }
  
  public final void setQua1(String paramString)
  {
    com.tencent.hlyyb.downloader.a.a.a(paramString);
  }
  
  public final void setQua2(String paramString)
  {
    com.tencent.hlyyb.downloader.a.a.b(paramString);
  }
  
  public final void setTaskNumForCategory(DownloaderTaskCategory paramDownloaderTaskCategory, int paramInt)
  {
    com.tencent.hlyyb.downloader.f.a.a().a(paramDownloaderTaskCategory, paramInt);
  }
  
  public final void setTempFileSubfix(String paramString)
  {
    com.tencent.hlyyb.downloader.a.a.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.c.a
 * JD-Core Version:    0.7.0.1
 */