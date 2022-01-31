package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.AssertUtil;

public final class DownloadResult
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadResult> CREATOR = new DownloadResult.1();
  private String a;
  private String b;
  private Status c = new Status();
  private Process d = new Process();
  private Content e = new Content();
  private Const f;
  private String g;
  private String h;
  
  public DownloadResult(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((Status)Status.CREATOR.createFromParcel(paramParcel));
    this.d = ((Process)Process.CREATOR.createFromParcel(paramParcel));
    this.e = ((Content)Content.CREATOR.createFromParcel(paramParcel));
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public DownloadResult(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      AssertUtil.assertTrue(bool);
      this.a = paramString;
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Content getContent()
  {
    return this.e;
  }
  
  public final String getDescInfo()
  {
    return this.g;
  }
  
  public final String getDetailDownloadInfo()
  {
    return this.h;
  }
  
  public final String getPath()
  {
    return this.b;
  }
  
  public final Process getProcess()
  {
    return this.d;
  }
  
  public final Const getReport$2683007b()
  {
    return this.f;
  }
  
  public final Status getStatus()
  {
    return this.c;
  }
  
  public final String getUrl()
  {
    return this.a;
  }
  
  public final void reset()
  {
    this.c.reset();
    this.d.reset();
    this.e.reset();
  }
  
  public final void setDescInfo(String paramString)
  {
    this.g = paramString;
  }
  
  public final void setDetailDownloadInfo(String paramString)
  {
    this.h = paramString;
  }
  
  public final void setPath(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setReport$695ff381(Const paramConst)
  {
    this.f = paramConst;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeParcelable(this.e, 0);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
  
  public static final class Content
    implements Parcelable
  {
    public static final Parcelable.Creator<Content> CREATOR = new DownloadResult.Content.1();
    public String clientip;
    public Object content;
    public String encoding;
    public long length;
    public boolean noCache;
    public long realsize;
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
        return;
        bool = false;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void reset()
    {
      this.type = null;
      this.encoding = null;
      this.length = 0L;
      this.size = 0L;
      this.realsize = -1L;
      this.noCache = false;
      this.content = null;
      this.clientip = null;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
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
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void reset()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.duration = 0L;
    }
    
    public final void setDuration(long paramLong1, long paramLong2)
    {
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      this.duration = (paramLong2 - paramLong1);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
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
    public static final int REASON_FAIL_NETWORK = 3;
    public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
    public static final int REASON_FAIL_NONE = 0;
    public static final int REASON_FAIL_STORAGE = 2;
    public static final int REASON_FAIL_UNKNOWN = 1;
    private int a = 2;
    private int b = 1;
    private Throwable c = null;
    public int httpStatus;
    
    public Status() {}
    
    public Status(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.httpStatus = paramParcel.readInt();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Throwable getFailException()
    {
      if (isFailed()) {
        return this.c;
      }
      return null;
    }
    
    public final int getFailReason()
    {
      if (isFailed()) {
        return this.b;
      }
      return 0;
    }
    
    public final boolean isFailed()
    {
      return this.a == 2;
    }
    
    public final boolean isRetrying()
    {
      return this.a == 3;
    }
    
    public final boolean isSucceed()
    {
      return this.a == 1;
    }
    
    public final void reset()
    {
      this.a = 2;
      this.b = 1;
      this.c = null;
      this.httpStatus = 0;
    }
    
    public final void setFailed(int paramInt)
    {
      this.a = 2;
      this.b = paramInt;
    }
    
    public final void setFailed(Throwable paramThrowable)
    {
      this.a = 2;
      this.b = 4;
      this.c = paramThrowable;
    }
    
    public final void setSucceed()
    {
      this.a = 1;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.httpStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult
 * JD-Core Version:    0.7.0.1
 */