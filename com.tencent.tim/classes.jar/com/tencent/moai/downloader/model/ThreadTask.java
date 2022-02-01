package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.algorithm.Hash;
import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.delegate.RequestDelegate;
import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.listener.ThreadTaskListener;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.moai.downloader.thread.ThreadManager;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadTask
  implements DownloadInterface, Runnable
{
  private static final String TAG = "ThreadTask";
  private boolean acceptRange;
  private boolean checkHeaderCorrect;
  private long downloadSize;
  private DownloadStatus downloadStatus = new DownloadStatus();
  private long end;
  private HandleErrorDelegate handleErrorDelegate;
  private long id;
  private ThreadTaskListener listener;
  private OutputStream outputStream;
  private String path;
  private int priority = 5;
  private HttpRequest request;
  private RequestDelegate requestDelegate;
  private RequestInterceptor requestInterceptor;
  private boolean singleTaskDownload;
  private long start;
  private long taskId;
  private String url;
  
  public static int generateHashId(long paramLong1, long paramLong2, long paramLong3)
  {
    return Hash.hashInt(paramLong1 + "_" + paramLong2 + "_" + paramLong3);
  }
  
  private boolean getAccessRange(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("Accept-Ranges");
    if ((paramMap != null) && (paramMap.size() > 0)) {
      return ((String)paramMap.get(0)).equalsIgnoreCase("bytes");
    }
    return false;
  }
  
  private String getContentDisposition(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("Content-Disposition");
    if ((paramMap != null) && (paramMap.size() > 0)) {
      return (String)paramMap.get(0);
    }
    return "";
  }
  
  private long getContentLength(Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get("Content-Length");
    if ((localList != null) && (localList.size() > 0)) {
      return Long.parseLong((String)((List)paramMap.get("Content-Length")).get(0));
    }
    return 0L;
  }
  
  private Map<String, String> getRangeHeader()
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder;
    if (isAcceptRange())
    {
      localStringBuilder = new StringBuilder().append("bytes=").append(this.start).append("-");
      if (this.end != 0L) {
        break label69;
      }
    }
    label69:
    for (Object localObject = "";; localObject = Long.valueOf(this.end))
    {
      localHashMap.put("Range", localObject);
      return localHashMap;
    }
  }
  
  public void abort()
  {
    this.downloadStatus.setStatus(6);
    this.listener.onAbort(this.id, this.taskId, this.url);
    if (this.request != null) {
      this.requestDelegate.abort(this.request);
    }
  }
  
  public long getDownloadSize()
  {
    return this.downloadSize;
  }
  
  public DownloadStatus getDownloadStatus()
  {
    return this.downloadStatus;
  }
  
  public long getEnd()
  {
    return this.end;
  }
  
  public HandleErrorDelegate getHandleErrorDelegate()
  {
    return this.handleErrorDelegate;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public ThreadTaskListener getListener()
  {
    return this.listener;
  }
  
  public OutputStream getOutputStream()
  {
    return this.outputStream;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public RequestDelegate getRequestDelegate()
  {
    return this.requestDelegate;
  }
  
  public RequestInterceptor getRequestInterceptor()
  {
    return this.requestInterceptor;
  }
  
  public long getStart()
  {
    return this.start;
  }
  
  public long getTaskId()
  {
    return this.taskId;
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
  
  public void run()
  {
    Thread.currentThread().setPriority(this.priority);
    this.request = new HttpRequest(this.url);
    this.request.setRequestHeader(getRangeHeader());
    this.request.setId(HttpRequest.generateId(this.request.getRequestUrl(), this.request.getRequestHeader(), this.request.getRequestMethod(), this.request.getRequestParam()));
    this.request.setRequestListener(new ThreadTask.1(this));
    if (this.requestInterceptor != null) {
      this.request = this.requestInterceptor.intercept(this.request);
    }
    if (this.requestDelegate != null) {
      this.requestDelegate.start(this.request);
    }
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
  
  public void setEnd(long paramLong)
  {
    this.end = paramLong;
  }
  
  public void setHandleErrorDelegate(HandleErrorDelegate paramHandleErrorDelegate)
  {
    this.handleErrorDelegate = paramHandleErrorDelegate;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setListener(ThreadTaskListener paramThreadTaskListener)
  {
    this.listener = paramThreadTaskListener;
  }
  
  public void setOutputStream(OutputStream paramOutputStream)
  {
    this.outputStream = paramOutputStream;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
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
  
  public void setStart(long paramLong)
  {
    this.start = paramLong;
  }
  
  public void setTaskId(long paramLong)
  {
    this.taskId = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void start()
  {
    this.downloadStatus.setStatus(1);
    this.listener.onStart(this.id, this.taskId, this.url);
    ThreadManager.shareInstance().start(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.ThreadTask
 * JD-Core Version:    0.7.0.1
 */