package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.store.TaskDBHelper;

public class UploadJobListener
  implements Job.JobListener
{
  private static final String TAG = "UploadJobListener";
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
      onMidway(paramInt, paramJob);
      return;
    }
    onSuccess(paramJob);
  }
  
  protected void onMidway(int paramInt, Job paramJob)
  {
    UploadJobContext localUploadJobContext = ((BaseUploadJob)paramJob).getUploadJobContext();
    TaskDBHelper localTaskDBHelper = TaskDBHelper.newDBHelper();
    localTaskDBHelper.updateUploadContext(localUploadJobContext.getId(), localUploadJobContext.getCurSize(), localUploadJobContext.getTotalSize(), localUploadJobContext.getModifyTime(), localUploadJobContext.getFileId());
    localTaskDBHelper.updateUploadFileMd5(localUploadJobContext.getId(), localUploadJobContext.getMd5(), localUploadJobContext.getSha());
    Log.i("UploadJobListener", "task " + paramJob.getId() + " new state:" + paramInt);
  }
  
  protected void onSuccess(Job paramJob)
  {
    paramJob = ((BaseUploadJob)paramJob).getUploadJobContext();
    TaskDBHelper.newDBHelper().deleteItem(paramJob.getId());
    Log.i("UploadJobListener", "file upload successful. path=" + paramJob.getSrcPath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.UploadJobListener
 * JD-Core Version:    0.7.0.1
 */