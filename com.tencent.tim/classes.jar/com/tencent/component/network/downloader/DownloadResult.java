package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.component.network.utils.AssertUtil;

public final class DownloadResult
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadResult> CREATOR = new DownloadResult.1();
  private Content mContent = new Content();
  private String mDescInfo;
  private String mDetailDownloadInfo;
  private String mPath;
  private Process mProcess = new Process();
  private DownloadReport mReport;
  private Status mStatus = new Status();
  private String mUrl;
  
  public DownloadResult(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.mUrl = paramParcel.readString();
    this.mPath = paramParcel.readString();
    this.mStatus = ((Status)paramParcel.readParcelable(Status.class.getClassLoader()));
    this.mProcess = ((Process)paramParcel.readParcelable(Process.class.getClassLoader()));
    this.mContent = ((Content)paramParcel.readParcelable(Content.class.getClassLoader()));
    this.mDescInfo = paramParcel.readString();
    this.mDetailDownloadInfo = paramParcel.readString();
  }
  
  public DownloadResult(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      this.mUrl = paramString;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mPath);
    paramParcel.writeParcelable(this.mStatus, 0);
    paramParcel.writeParcelable(this.mProcess, 0);
    paramParcel.writeParcelable(this.mContent, 0);
    paramParcel.writeString(this.mDescInfo);
    paramParcel.writeString(this.mDetailDownloadInfo);
  }
  
  public static final class Content
    implements Parcelable
  {
    public static final Parcelable.Creator<Content> CREATOR = new DownloadResult.Content.1();
    public String clientip;
    public Object content;
    public String encoding;
    public boolean isGzip;
    public String lastModified;
    public long length;
    public String md5;
    public boolean noCache;
    public long realsize;
    public String redirectUrl;
    public int retCode;
    public long size;
    public String type;
    
    Content() {}
    
    public Content(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.type = paramParcel.readString();
      this.encoding = paramParcel.readString();
      this.length = paramParcel.readLong();
      this.size = paramParcel.readLong();
      this.realsize = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.noCache = bool;
        this.clientip = paramParcel.readString();
        this.lastModified = paramParcel.readString();
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void reset()
    {
      this.type = null;
      this.encoding = null;
      this.length = 0L;
      this.size = 0L;
      this.realsize = -1L;
      this.noCache = false;
      this.content = null;
      this.clientip = null;
      this.lastModified = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.encoding);
      paramParcel.writeLong(this.length);
      paramParcel.writeLong(this.size);
      paramParcel.writeLong(this.realsize);
      if (this.noCache) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.clientip);
        paramParcel.writeString(this.lastModified);
        return;
      }
    }
  }
  
  public static final class Process
    implements Parcelable
  {
    public static final Parcelable.Creator<Process> CREATOR = new DownloadResult.Process.1();
    public long duration;
    public long endTime;
    public long startTime;
    public long startTimestamp;
    public long totalDuration;
    
    Process() {}
    
    public Process(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.startTime = paramParcel.readLong();
      this.endTime = paramParcel.readLong();
      this.duration = paramParcel.readLong();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
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
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeLong(this.startTime);
      paramParcel.writeLong(this.endTime);
      paramParcel.writeLong(this.duration);
    }
  }
  
  public static final class Status
    implements Parcelable
  {
    public static final Parcelable.Creator<Status> CREATOR = new DownloadResult.Status.1();
    public static final int REASON_FAIL_CONTENT = 5;
    public static final int REASON_FAIL_EXCEPTION = 4;
    public static final int REASON_FAIL_META = 7;
    public static final int REASON_FAIL_NETWORK = 3;
    public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
    public static final int REASON_FAIL_NONE = 0;
    public static final int REASON_FAIL_STORAGE = 2;
    public static final int REASON_FAIL_UNKNOWN = 1;
    public static final int STATE_CANCELED = 4;
    public static final int STATE_FAILED = 2;
    public static final int STATE_RETRYING = 3;
    public static final int STATE_SUCCEED = 1;
    public String detailDownloadInfo = "";
    public int exception2Code = 0;
    public Throwable failException = null;
    public int failReason = 1;
    public int httpStatus;
    public int state = 2;
    
    public Status() {}
    
    public Status(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.state = paramParcel.readInt();
      this.failReason = paramParcel.readInt();
      this.httpStatus = paramParcel.readInt();
      this.exception2Code = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getErrorMessage()
    {
      switch (this.failReason)
      {
      default: 
        return "";
      case 2: 
        return "storage limit";
      case 3: 
        return "response error";
      case 4: 
        return "download exception";
      case 5: 
        return "content type error";
      }
      return "network unavailable";
    }
    
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
      this.exception2Code = 0;
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
      this.exception2Code = ImageDownloadReporter.getRetCodeFrom(this.failException, 0);
    }
    
    final void setRetrying()
    {
      this.state = 3;
    }
    
    public final void setSucceed()
    {
      this.state = 1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeInt(this.state);
      paramParcel.writeInt(this.failReason);
      paramParcel.writeInt(this.httpStatus);
      paramParcel.writeInt(this.exception2Code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult
 * JD-Core Version:    0.7.0.1
 */