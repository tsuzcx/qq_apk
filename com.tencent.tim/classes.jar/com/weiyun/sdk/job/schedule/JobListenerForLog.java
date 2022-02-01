package com.weiyun.sdk.job.schedule;

import android.net.NetworkInfo;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.job.JobContext;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import com.weiyun.sdk.util.NetworkUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobListenerForLog
  implements Job.JobListener
{
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
  public static final int JOB_TYPE_DOWNLOAD = 2;
  public static final int JOB_TYPE_THUMBNAIL = 3;
  public static final int JOB_TYPE_UPLOAD = 1;
  private final int mJobType;
  private long mStartSize;
  private long mStartTime;
  private long mStartTransferTime;
  private final String mTag;
  
  public JobListenerForLog(String paramString, int paramInt)
  {
    this.mTag = paramString;
    this.mJobType = paramInt;
  }
  
  private String formatTime(long paramLong)
  {
    return DATE_FORMAT.format(new Date(paramLong));
  }
  
  private String getNetworkType()
  {
    NetworkInfo localNetworkInfo = NetworkUtils.getNetworkInfo(SdkContext.getInstance().getContext());
    if (localNetworkInfo != null) {
      return localNetworkInfo.getTypeName() + "[ " + localNetworkInfo.getSubtypeName() + " ]";
    }
    return "";
  }
  
  private void onEnd(boolean paramBoolean, Job paramJob)
  {
    if (LogTag.NeedSpecialLog())
    {
      long l1 = System.currentTimeMillis();
      Log.i(this.mTag, "job " + paramJob.getId() + " end time:" + formatTime(l1));
      Log.i(this.mTag, "job " + paramJob.getId() + " use time[ms]:" + (l1 - this.mStartTime));
      if (l1 > this.mStartTransferTime)
      {
        long l2 = ((BaseJob)paramJob).getJobContext().getTotalSize();
        Log.i(this.mTag, "job " + paramJob.getId() + " transfer speed[byte/s]:" + (l2 - this.mStartSize) * 1000L / (l1 - this.mStartTransferTime));
      }
      if (!paramBoolean) {
        Log.w(this.mTag, "job " + paramJob.getId() + " failed, error code:" + paramJob.getLastErrorNo());
      }
    }
  }
  
  private void onStart(Job paramJob)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (LogTag.NeedSpecialLog())
    {
      this.mStartTime = System.currentTimeMillis();
      this.mStartTransferTime = this.mStartTime;
      this.mStartSize = ((BaseJob)paramJob).getJobContext().getCurSize();
      if (this.mJobType != 1) {
        break label274;
      }
      localObject = ((BaseUploadJob)paramJob).getUploadJobContext();
      localStringBuilder = new StringBuilder("upload file. ");
      localStringBuilder.append("file path:").append(((UploadJobContext)localObject).getSrcPath());
      localStringBuilder.append(", file name:").append(((UploadJobContext)localObject).getFileName());
      localStringBuilder.append(", file size:").append(((UploadJobContext)localObject).getTotalSize());
      localStringBuilder.append(", job id:").append(paramJob.getId());
      Log.i(this.mTag, localStringBuilder.toString());
    }
    for (;;)
    {
      Log.i(this.mTag, "job " + paramJob.getId() + " start time:" + formatTime(this.mStartTime));
      Log.i(this.mTag, "job " + paramJob.getId() + " network type:" + getNetworkType());
      long l = NetworkUtils.getPacketSize(SdkContext.getInstance().getContext());
      Log.i(this.mTag, "job " + paramJob.getId() + " packet size:" + l);
      return;
      label274:
      if (this.mJobType == 2)
      {
        localObject = ((BaseDownloadJob)paramJob).getDownloadJobContext();
        localStringBuilder = new StringBuilder("download file. ");
        localStringBuilder.append("file id:").append(((DownloadJobContext)localObject).getFileId());
        localStringBuilder.append(", file name:").append(((DownloadJobContext)localObject).getFileName());
        localStringBuilder.append(", file size:").append(((DownloadJobContext)localObject).getTotalSize());
        localStringBuilder.append(", job id:").append(paramJob.getId());
        if (((DownloadJobContext)localObject).getServerIp() != null) {
          localStringBuilder.append(", server ip:").append(((DownloadJobContext)localObject).getServerIp());
        }
        Log.i(this.mTag, localStringBuilder.toString());
      }
      else
      {
        localObject = ((BaseDownloadJob)paramJob).getDownloadJobContext();
        localStringBuilder = new StringBuilder("download thumbnail. ");
        localStringBuilder.append("file id:").append(((DownloadJobContext)localObject).getFileId());
        localStringBuilder.append(", file name:").append(((DownloadJobContext)localObject).getFileName());
        localStringBuilder.append(", job id:").append(paramJob.getId());
        Log.i(this.mTag, localStringBuilder.toString());
      }
    }
  }
  
  private void onTransfer(Job paramJob)
  {
    this.mStartSize = ((BaseJob)paramJob).getJobContext().getCurSize();
    this.mStartTransferTime = System.currentTimeMillis();
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      onStart(paramJob);
      return;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      if (paramInt == 5) {}
      for (boolean bool = true;; bool = false)
      {
        onEnd(bool, paramJob);
        return;
      }
    }
    onTransfer(paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.JobListenerForLog
 * JD-Core Version:    0.7.0.1
 */