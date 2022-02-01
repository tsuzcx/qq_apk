package com.tencent.qqmail.utilities.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qqmail.utilities.log.QMLog;

public class QMSyncService
  extends Service
{
  private static final String TAG = "QMSyncService";
  private final String mHashCode = Integer.toHexString(hashCode());
  
  public IBinder onBind(Intent paramIntent)
  {
    return QMSyncAdapter.getInstance().getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    QMLog.log(4, "QMSyncService", "onCreate@" + this.mHashCode);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMSyncService", "onDestroy@" + this.mHashCode);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncService
 * JD-Core Version:    0.7.0.1
 */