package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.IWyTaskManager.UploadTask;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.UploadJobContext;

public class UploadJobProxy
  extends JobProxy
  implements IWyTaskManager.UploadTask
{
  public volatile String mFileId = null;
  
  public UploadJobProxy(BaseUploadJob paramBaseUploadJob, Object paramObject, JobManager paramJobManager)
  {
    super(paramBaseUploadJob, paramObject, paramJobManager);
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    if (paramInt == 5) {
      this.mFileId = ((BaseUploadJob)paramJob).getUploadJobContext().getFileId();
    }
    super.notifyStateChanged(paramInt, paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.UploadJobProxy
 * JD-Core Version:    0.7.0.1
 */