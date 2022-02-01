package com.tencent.qqmail.utilities.syncadapter;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

public class QMSyncAdapter
  extends AbstractThreadedSyncAdapter
{
  private static final String TAG = "QMSyncAdapter";
  private static QMSyncAdapter sInstance = new QMSyncAdapter(QMApplicationContext.sharedInstance(), true);
  
  public QMSyncAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  public QMSyncAdapter(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static QMSyncAdapter getInstance()
  {
    return sInstance;
  }
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    QMLog.log(4, "QMSyncAdapter", "onPerformSync, account: " + paramAccount + ", extras: " + paramBundle + ", " + paramSyncResult);
    paramBundle.putSerializable("from", QMScheduledJobs.FromType.SYNC_ADAPTER);
    paramBundle.putBoolean("exclude_from_limit_interval", true);
    QMScheduledJobs.doJobs(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapter
 * JD-Core Version:    0.7.0.1
 */