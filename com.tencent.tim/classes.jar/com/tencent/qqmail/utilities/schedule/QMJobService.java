package com.tencent.qqmail.utilities.schedule;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

@TargetApi(21)
public class QMJobService
  extends JobService
{
  private static final String TAG = "QMJobService";
  private String mHashCode = Integer.toHexString(hashCode());
  
  public void onCreate()
  {
    QMLog.log(4, "QMJobService", "onCreate@" + this.mHashCode);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMJobService", "onDestroy@" + this.mHashCode);
    super.onDestroy();
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    QMLog.log(4, "QMJobService", "onStartJob, id: " + paramJobParameters.getJobId() + ", extras: " + paramJobParameters.getExtras());
    KvHelper.jobScheduler(new double[0]);
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramJobParameters.getExtras());
    localBundle.putSerializable("from", QMScheduledJobs.FromType.JOB_SCHEDULER);
    localBundle.putBoolean("exclude_from_limit_interval", true);
    QMScheduledJobs.doJobs(localBundle);
    jobFinished(paramJobParameters, false);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    QMLog.log(5, "QMJobService", "onStopJob");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.schedule.QMJobService
 * JD-Core Version:    0.7.0.1
 */