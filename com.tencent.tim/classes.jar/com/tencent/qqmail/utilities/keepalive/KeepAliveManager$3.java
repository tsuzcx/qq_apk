package com.tencent.qqmail.utilities.keepalive;

import android.app.Activity;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import moai.daemon.DaemonActivityInterceptor.IDaemonActivityInterceptor;
import moai.oss.KvHelper;

final class KeepAliveManager$3
  implements DaemonActivityInterceptor.IDaemonActivityInterceptor
{
  public void onCreate(Activity paramActivity) {}
  
  public void onDestroy(long paramLong)
  {
    KvHelper.invisibleActivityExistTime(new double[] { Math.round(paramLong / 60.0D / 60.0D / 1000.0D * 100.0D) / 100.0D });
  }
  
  public boolean onPermit()
  {
    return (KeepAliveManager.sShowInvisible) && (QMServiceManager.isPushEnable()) && (QMServiceManager.isUMAPushEnable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.3
 * JD-Core Version:    0.7.0.1
 */