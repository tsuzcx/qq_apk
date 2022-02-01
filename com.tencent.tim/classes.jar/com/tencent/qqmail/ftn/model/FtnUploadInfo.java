package com.tencent.qqmail.ftn.model;

import com.tencent.qqmail.animation.ProgressBarCallback;
import com.tencent.qqmail.animation.ProgressBarCallback.IBeforeCallback;
import com.tencent.qqmail.animation.ProgressBarCallback.ICompleteCallback;
import com.tencent.qqmail.animation.ProgressBarCallback.IProgressCallback;
import com.tencent.qqmail.animation.ProgressBarCallback.IScheduleCallback;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FtnUploadInfo
  extends ProgressBarCallback
{
  public static final int ANIM = 5;
  public static final int BREAK = 9;
  public static final int ERROR = 4;
  public static final int FINISH = 8;
  public static final int PAUSE = 3;
  public static final int RUNANIM = 6;
  public static final int RUNNOANIM = 7;
  public static final int SCANNING = 1;
  public static final int UPLOADING = 2;
  private boolean aborted = false;
  private String absolutePath;
  private ProgressBarCallback.IBeforeCallback beforeCallback = new FtnUploadInfo.1(this);
  private ProgressBarCallback.ICompleteCallback completeCallback = new FtnUploadInfo.4(this);
  private long createTime;
  private int errRetryCount = 1;
  private String fid;
  private long fileSize;
  private String ip;
  private boolean isCreateFile = false;
  private String key;
  private WeakReference<FtnListActivity> mListActivityRef;
  private String md5;
  private String name;
  public AtomicBoolean needFlushProgress = new AtomicBoolean(true);
  private String originalPath;
  private int port;
  private ProgressBarCallback.IProgressCallback progressCallback = new FtnUploadInfo.2(this);
  private String rid;
  private ProgressBarCallback.IScheduleCallback scheduleCallback = new FtnUploadInfo.3(this);
  private String sha;
  private String shakey;
  private int stage = 0;
  private int state;
  private long uploadedSize = 0L;
  
  public FtnUploadInfo()
  {
    initPbCallback();
  }
  
  public FtnUploadInfo(FtnListActivity paramFtnListActivity, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("cannot be not null or empty");
    }
    File localFile = new File(paramString);
    if (!localFile.isFile()) {
      throw new IllegalArgumentException("no file");
    }
    String str = "";
    if (paramInt2 != -1)
    {
      str = FtnCommonUtils.autoGenerateUploadFileName(paramInt2, FtnCommonUtils.getImageRotateAngle(paramFtnListActivity, paramString));
      int i = paramString.lastIndexOf("/");
      if ((paramInt2 == -1) || (i < 0)) {
        break label358;
      }
      paramString = paramString.substring(i + 1);
      paramInt2 = paramString.lastIndexOf(".");
      if (paramInt2 <= 0) {
        break label342;
      }
      paramString = paramString.substring(paramInt2);
      str = str + paramString;
    }
    label342:
    label358:
    for (;;)
    {
      this.createTime = (new Date().getTime() / 1000L);
      this.rid = String.format("rid%x%x", new Object[] { Long.valueOf(this.createTime), Integer.valueOf((int)(Math.random() * 2147483647.0D)) });
      this.absolutePath = localFile.getAbsolutePath();
      if (!str.equals("")) {}
      for (;;)
      {
        this.name = str;
        this.fileSize = localFile.length();
        this.state = paramInt1;
        this.mListActivityRef = new WeakReference(paramFtnListActivity);
        initPbCallback();
        return;
        paramString = ".jpg";
        break;
        str = localFile.getName();
      }
    }
  }
  
  private void initPbCallback()
  {
    setTag(this.name);
    setBeforeCallback(this.beforeCallback);
    setProgressCallback(this.progressCallback);
    setScheduleCallback(this.scheduleCallback);
    setCompleteCallback(this.completeCallback);
  }
  
  public String getAbsolutePath()
  {
    return this.absolutePath;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getErrRetryCount()
  {
    return this.errRetryCount;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getOriginalPath()
  {
    return this.originalPath;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public String getRid()
  {
    return this.rid;
  }
  
  public String getSha()
  {
    return this.sha;
  }
  
  public String getShakey()
  {
    return this.shakey;
  }
  
  public int getStage()
  {
    return this.stage;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public long getUploadedSize()
  {
    return this.uploadedSize;
  }
  
  public boolean isAborted()
  {
    return this.aborted;
  }
  
  public boolean isCreateFile()
  {
    return this.isCreateFile;
  }
  
  public void setAborted(boolean paramBoolean)
  {
    this.aborted = paramBoolean;
  }
  
  public void setAbsolutePath(String paramString)
  {
    this.absolutePath = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setErrRetryCount(int paramInt)
  {
    this.errRetryCount = paramInt;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setIsCreateFile(boolean paramBoolean)
  {
    this.isCreateFile = paramBoolean;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setListActivity(FtnListActivity paramFtnListActivity)
  {
    this.mListActivityRef = new WeakReference(paramFtnListActivity);
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOriginalPath(String paramString)
  {
    this.originalPath = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setRid(String paramString)
  {
    this.rid = paramString;
  }
  
  public void setSha(String paramString)
  {
    this.sha = paramString;
  }
  
  public void setShakey(String paramString)
  {
    this.shakey = paramString;
  }
  
  public void setStage(int paramInt)
  {
    this.stage = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setUploadedSize(long paramLong)
  {
    this.uploadedSize = paramLong;
  }
  
  public String toString()
  {
    return "[" + this.absolutePath + ", " + this.uploadedSize + "/" + this.fileSize + ", " + this.stage + ", " + this.state + ", " + getSchedule() + "/" + getProgress() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnUploadInfo
 * JD-Core Version:    0.7.0.1
 */