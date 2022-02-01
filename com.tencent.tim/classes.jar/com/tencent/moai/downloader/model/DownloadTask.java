package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.algorithm.Hash;
import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.delegate.RenameDelegate;
import com.tencent.moai.downloader.delegate.RequestDelegate;
import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.listener.ThreadTaskListener;
import com.tencent.moai.downloader.network.DefaultHttpClient;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadTask
  implements DownloadInterface
{
  private static final String TAG = "DownloadTask";
  private boolean acceptRange;
  private boolean checkHeaderCorrect = false;
  private long downloadSize;
  private DownloadStatus downloadStatus = new DownloadStatus();
  private String fileName;
  private String filePath;
  private long fileSize;
  private HandleErrorDelegate handleErrorDelegate;
  private long id;
  private DownloadTaskListener listener;
  private int priority = 5;
  private RenameDelegate renameDelegate;
  private RequestDelegate requestDelegate;
  private RequestInterceptor requestInterceptor;
  private boolean singleTaskDownload;
  private ArrayList<ThreadTask> threadTaskList = new ArrayList();
  private String url;
  
  private void abortThreadTaskList()
  {
    Logger.i("DownloadTask", "abortThreadTaskList id:" + this.id + "url:" + this.url);
    this.downloadStatus.setStatus(6);
    this.listener.onAbort(this.id, this.url);
    synchronized (this.threadTaskList)
    {
      Iterator localIterator = this.threadTaskList.iterator();
      while (localIterator.hasNext())
      {
        ThreadTask localThreadTask = (ThreadTask)localIterator.next();
        if ((localThreadTask.getDownloadStatus().getStatus() == 0) || (localThreadTask.getDownloadStatus().getStatus() == 1) || (localThreadTask.getDownloadStatus().getStatus() == 2) || (localThreadTask.getDownloadStatus().getStatus() == 4) || (localThreadTask.getDownloadStatus().getStatus() == 5)) {
          localThreadTask.abort();
        }
      }
    }
  }
  
  private void checkParams()
  {
    if (StringUtil.isNullOrEmpty(this.url)) {
      throw new IllegalStateException("url should not be null");
    }
    if (StringUtil.isNullOrEmpty(this.filePath)) {
      throw new IllegalStateException("file path should not be null");
    }
    if (StringUtil.isNullOrEmpty(this.fileName)) {
      this.fileName = this.filePath.substring(this.filePath.lastIndexOf('/') + 1);
    }
    if (this.requestInterceptor == null) {
      this.requestInterceptor = new DownloadTask.1(this);
    }
    if (this.requestDelegate == null) {
      this.requestDelegate = DefaultHttpClient.shareInstance();
    }
    if (this.renameDelegate == null) {
      this.renameDelegate = new DownloadTask.2(this);
    }
  }
  
  private void connect()
  {
    ConnectTask localConnectTask = new ConnectTask(this.url);
    localConnectTask.setConnectStatus(new ConnectStatus());
    localConnectTask.setListener(new DownloadTask.3(this));
    localConnectTask.connect();
  }
  
  private ThreadTask createPartialThreadTask(int paramInt, long paramLong1, long paramLong2)
  {
    String str = DownloadFileUtil.getTmpFile(this.id, paramInt);
    long l = DownloadFileUtil.getFileSize(str);
    ThreadTask localThreadTask = new ThreadTask();
    localThreadTask.setTaskId(this.id);
    localThreadTask.setPath(str);
    localThreadTask.setUrl(this.url);
    localThreadTask.setPriority(this.priority);
    localThreadTask.setDownloadSize(l);
    localThreadTask.setAcceptRange(true);
    localThreadTask.setSingleTaskDownload(false);
    localThreadTask.setCheckHeaderCorrect(this.checkHeaderCorrect);
    localThreadTask.setStart(paramLong1 + l);
    localThreadTask.setEnd(paramLong1 + paramLong2);
    localThreadTask.setListener(createThreadTaskListener());
    localThreadTask.setRequestDelegate(this.requestDelegate);
    localThreadTask.setRequestInterceptor(this.requestInterceptor);
    localThreadTask.setHandleErrorDelegate(this.handleErrorDelegate);
    localThreadTask.setId(ThreadTask.generateHashId(localThreadTask.getTaskId(), localThreadTask.getStart(), localThreadTask.getEnd()));
    return localThreadTask;
  }
  
  private ThreadTask createSingleThreadTask()
  {
    String str = DownloadFileUtil.getTmpFile(this.id, 0);
    long l = DownloadFileUtil.getFileSize(str);
    ThreadTask localThreadTask = new ThreadTask();
    localThreadTask.setTaskId(this.id);
    localThreadTask.setPath(str);
    localThreadTask.setUrl(this.url);
    localThreadTask.setPriority(this.priority);
    localThreadTask.setDownloadSize(DownloadFileUtil.getFileSize(str));
    localThreadTask.setAcceptRange(true);
    localThreadTask.setSingleTaskDownload(true);
    localThreadTask.setCheckHeaderCorrect(this.checkHeaderCorrect);
    localThreadTask.setStart(l);
    localThreadTask.setEnd(0L);
    localThreadTask.setListener(createThreadTaskListener());
    localThreadTask.setRequestDelegate(this.requestDelegate);
    localThreadTask.setRequestInterceptor(this.requestInterceptor);
    localThreadTask.setHandleErrorDelegate(this.handleErrorDelegate);
    localThreadTask.setId(ThreadTask.generateHashId(localThreadTask.getTaskId(), localThreadTask.getStart(), localThreadTask.getEnd()));
    return localThreadTask;
  }
  
  private ThreadTaskListener createThreadTaskListener()
  {
    return new DownloadTask.4(this);
  }
  
  private boolean directCombineFile()
  {
    if ((this.threadTaskList == null) || (this.threadTaskList.size() == 0)) {
      return false;
    }
    Object localObject = this.threadTaskList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ThreadTask localThreadTask = (ThreadTask)((Iterator)localObject).next();
      File localFile = new File(localThreadTask.getPath());
      if (!localFile.exists())
      {
        Logger.i("DownloadTask", "direct combine fail with tmp file not exist:" + localThreadTask.getPath());
        return false;
      }
      Logger.i("DownloadTask", "direct combine tmp file exist:" + localThreadTask.getPath() + ", size:" + localFile.length());
      localThreadTask.setDownloadStatus(new DownloadStatus(4));
    }
    localObject = (ThreadTask)this.threadTaskList.get(0);
    if ((localObject != null) && (((ThreadTask)localObject).getListener() != null))
    {
      Logger.i("DownloadTask", "go to combine downloaded tmp files");
      ((ThreadTask)localObject).getListener().onSuccess(((ThreadTask)localObject).getId(), ((ThreadTask)localObject).getTaskId(), ((ThreadTask)localObject).getUrl(), ((ThreadTask)localObject).getPath());
    }
    return true;
  }
  
  public static int generateHashId(String paramString1, String paramString2)
  {
    return Hash.hashInt(paramString1 + "_" + paramString2);
  }
  
  private ArrayList<String> getTmpFilePathList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.threadTaskList != null) && (this.threadTaskList.size() > 0))
    {
      Iterator localIterator = this.threadTaskList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ThreadTask)localIterator.next()).getPath());
      }
    }
    return localArrayList;
  }
  
  private void initMultiThreadTask()
  {
    if ((this.threadTaskList != null) && (this.threadTaskList.size() > 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = DownloadFileUtil.getThreadTaskFileSizeList(this.fileSize);
      long l1 = 0L;
      int i = 0;
      while (i < localArrayList.size())
      {
        long l2 = ((Long)localArrayList.get(i)).longValue();
        this.threadTaskList.add(createPartialThreadTask(i, l1, l2));
        l1 += ((Long)localArrayList.get(i)).longValue() + 1L;
        i += 1;
      }
    }
  }
  
  private void initSingleThreadTask()
  {
    if ((this.threadTaskList != null) && (this.threadTaskList.size() > 0)) {
      return;
    }
    this.threadTaskList.add(createSingleThreadTask());
  }
  
  private boolean isAllFail()
  {
    Iterator localIterator = this.threadTaskList.iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      if (((ThreadTask)localIterator.next()).getDownloadStatus().getStatus() == 5) {
        break label45;
      }
      bool = false;
    }
    label45:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private boolean isAllSuccess()
  {
    Iterator localIterator = this.threadTaskList.iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      if (((ThreadTask)localIterator.next()).getDownloadStatus().getStatus() == 4) {
        break label45;
      }
      bool = false;
    }
    label45:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private boolean isAllSuccessOrFail()
  {
    Iterator localIterator = this.threadTaskList.iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      ThreadTask localThreadTask = (ThreadTask)localIterator.next();
      if ((localThreadTask.getDownloadStatus().getStatus() == 4) || (localThreadTask.getDownloadStatus().getStatus() == 5)) {
        break label58;
      }
      bool = false;
    }
    label58:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private void startThreadTaskList()
  {
    Logger.i("DownloadTask", "startThreadTaskList id:" + this.id + "url:" + this.url);
    this.downloadStatus.setStatus(1);
    this.listener.onStart(this.id, this.url);
    synchronized (this.threadTaskList)
    {
      Iterator localIterator = this.threadTaskList.iterator();
      while (localIterator.hasNext())
      {
        ThreadTask localThreadTask = (ThreadTask)localIterator.next();
        if (localThreadTask.getDownloadStatus().getStatus() == 0) {
          localThreadTask.start();
        }
      }
    }
  }
  
  public void abort()
  {
    abortThreadTaskList();
  }
  
  public long getDownloadSize()
  {
    return this.downloadSize;
  }
  
  public DownloadStatus getDownloadStatus()
  {
    return this.downloadStatus;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public HandleErrorDelegate getHandleErrorDelegate()
  {
    return this.handleErrorDelegate;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public DownloadTaskListener getListener()
  {
    return this.listener;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public RenameDelegate getRenameDelegate()
  {
    return this.renameDelegate;
  }
  
  public RequestDelegate getRequestDelegate()
  {
    return this.requestDelegate;
  }
  
  public RequestInterceptor getRequestInterceptor()
  {
    return this.requestInterceptor;
  }
  
  public ArrayList<ThreadTask> getThreadTaskList()
  {
    return this.threadTaskList;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isAcceptRange()
  {
    return this.acceptRange;
  }
  
  public boolean isCheckHeaderCorrect()
  {
    return this.checkHeaderCorrect;
  }
  
  public boolean isSingleTaskDownload()
  {
    return this.singleTaskDownload;
  }
  
  public void setAcceptRange(boolean paramBoolean)
  {
    this.acceptRange = paramBoolean;
  }
  
  public void setCheckHeaderCorrect(boolean paramBoolean)
  {
    this.checkHeaderCorrect = paramBoolean;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.downloadSize = paramLong;
  }
  
  public void setDownloadStatus(DownloadStatus paramDownloadStatus)
  {
    this.downloadStatus = paramDownloadStatus;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setHandleErrorDelegate(HandleErrorDelegate paramHandleErrorDelegate)
  {
    this.handleErrorDelegate = paramHandleErrorDelegate;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setListener(DownloadTaskListener paramDownloadTaskListener)
  {
    this.listener = paramDownloadTaskListener;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public void setRenameDelegate(RenameDelegate paramRenameDelegate)
  {
    this.renameDelegate = paramRenameDelegate;
  }
  
  public void setRequestDelegate(RequestDelegate paramRequestDelegate)
  {
    this.requestDelegate = paramRequestDelegate;
  }
  
  public void setRequestInterceptor(RequestInterceptor paramRequestInterceptor)
  {
    this.requestInterceptor = paramRequestInterceptor;
  }
  
  public void setSingleTaskDownload(boolean paramBoolean)
  {
    this.singleTaskDownload = paramBoolean;
  }
  
  public void setThreadTaskList(ArrayList<ThreadTask> paramArrayList)
  {
    this.threadTaskList = paramArrayList;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void start()
  {
    checkParams();
    boolean bool = false;
    if (this.downloadStatus.getStatus() == 3)
    {
      if (!isSingleTaskDownload()) {
        break label60;
      }
      initSingleThreadTask();
    }
    for (;;)
    {
      bool = directCombineFile();
      if (!bool)
      {
        this.threadTaskList.clear();
        if (!isSingleTaskDownload()) {
          break;
        }
        initSingleThreadTask();
        startThreadTaskList();
      }
      return;
      label60:
      initMultiThreadTask();
    }
    connect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.DownloadTask
 * JD-Core Version:    0.7.0.1
 */