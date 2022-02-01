package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashSet;
import java.util.Set;

public class QMNetworkHandler
{
  private static final long SMOOTH_TIME = 2000L;
  public static final String TAG = "QMNetworkHandler";
  private static QMNetworkHandler sInstance = new QMNetworkHandler();
  private Set<NetworkListener> mNetworkListeners;
  private final Runnable mSmoothConnnectedChange = new QMNetworkHandler.1(this);
  
  public static QMNetworkHandler getInstance()
  {
    return sInstance;
  }
  
  private void startPushService()
  {
    boolean bool = QMNetworkUtils.isNetworkConnected();
    QMApplicationContext.sharedInstance().startService(QMPushService.createNetworkChangedIntent(bool));
  }
  
  void handleNetworkChanged()
  {
    QMNetworkUtils.clearNetworkType();
    QMLog.log(4, "QMNetworkHandler", "Network Changed, network: " + QMNetworkUtils.getActiveNetworkName() + ", operator: " + QMNetworkUtils.getSimOperator());
    Threads.runInBackgroundIfNotExist(this.mSmoothConnnectedChange, 2000L);
    QMWatcherCenter.triggerRenderSyncErrorBar();
  }
  
  public void registerNetworkListener(NetworkListener paramNetworkListener)
  {
    if (this.mNetworkListeners == null) {
      this.mNetworkListeners = new HashSet();
    }
    this.mNetworkListeners.add(paramNetworkListener);
  }
  
  public void unregisterNetworkListener(NetworkListener paramNetworkListener)
  {
    if (this.mNetworkListeners == null) {
      return;
    }
    this.mNetworkListeners.remove(paramNetworkListener);
  }
  
  public static abstract interface NetworkListener
  {
    public abstract void onNetworkChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler
 * JD-Core Version:    0.7.0.1
 */