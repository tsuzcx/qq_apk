package com.qzone.download;

import android.text.TextUtils;
import com.qzone.utils.AssertUtil;

public final class DownloadResult
{
  private final Content mContent = new Content();
  private String mDescInfo;
  private String mDetailDownloadInfo;
  private String mPath;
  private final Process mProcess = new Process();
  private DownloadReport mReport;
  private final Status mStatus = new Status();
  private final String mUrl;
  
  public DownloadResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      AssertUtil.assertTrue(bool);
      this.mUrl = paramString;
      return;
    }
  }
  
  public Content getContent()
  {
    return this.mContent;
  }
  
  public String getDescInfo()
  {
    return this.mDescInfo;
  }
  
  public String getDetailDownloadInfo()
  {
    return this.mDetailDownloadInfo;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public Process getProcess()
  {
    return this.mProcess;
  }
  
  public DownloadReport getReport()
  {
    return this.mReport;
  }
  
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  public final String getUrl()
  {
    return this.mUrl;
  }
  
  public void reset()
  {
    this.mStatus.reset();
    this.mProcess.reset();
    this.mContent.reset();
  }
  
  public final void setDescInfo(String paramString)
  {
    this.mDescInfo = paramString;
  }
  
  public final void setDetailDownloadInfo(String paramString)
  {
    this.mDetailDownloadInfo = paramString;
  }
  
  public final void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public final void setReport(DownloadReport paramDownloadReport)
  {
    this.mReport = paramDownloadReport;
  }
  
  public static final class Content
  {
    public String clientip;
    public Object content;
    public String encoding;
    public long length;
    public boolean noCache;
    public long size;
    public String type;
    
    public void reset()
    {
      this.type = null;
      this.encoding = null;
      this.length = 0L;
      this.size = 0L;
      this.noCache = false;
      this.content = null;
      this.clientip = null;
    }
  }
  
  public static final class Process
  {
    public long duration;
    public long endTime;
    public long startTime;
    
    public void reset()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.duration = 0L;
    }
    
    public void setDuration(long paramLong1, long paramLong2)
    {
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      this.duration = (paramLong2 - paramLong1);
    }
  }
  
  public static final class Status
  {
    public static final int REASON_FAIL_CONTENT = 5;
    public static final int REASON_FAIL_EXCEPTION = 4;
    public static final int REASON_FAIL_NETWORK = 3;
    public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
    public static final int REASON_FAIL_NONE = 0;
    public static final int REASON_FAIL_STORAGE = 2;
    public static final int REASON_FAIL_UNKNOWN = 1;
    private static final int STATE_FAILED = 2;
    private static final int STATE_RETRYING = 3;
    private static final int STATE_SUCCEED = 1;
    private Throwable failException = null;
    private int failReason = 1;
    public int httpStatus;
    private int state = 2;
    
    public Throwable getFailException()
    {
      if (isFailed()) {
        return this.failException;
      }
      return null;
    }
    
    public int getFailReason()
    {
      if (isFailed()) {
        return this.failReason;
      }
      return 0;
    }
    
    public boolean isFailed()
    {
      return this.state == 2;
    }
    
    public final boolean isRetrying()
    {
      return this.state == 3;
    }
    
    public boolean isSucceed()
    {
      return this.state == 1;
    }
    
    public final void reset()
    {
      this.state = 2;
      this.failReason = 1;
      this.failException = null;
      this.httpStatus = 0;
    }
    
    public final void setFailed(int paramInt)
    {
      this.state = 2;
      this.failReason = paramInt;
    }
    
    public final void setFailed(Throwable paramThrowable)
    {
      this.state = 2;
      this.failReason = 4;
      this.failException = paramThrowable;
    }
    
    final void setRetrying()
    {
      this.state = 3;
    }
    
    public final void setSucceed()
    {
      this.state = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.DownloadResult
 * JD-Core Version:    0.7.0.1
 */