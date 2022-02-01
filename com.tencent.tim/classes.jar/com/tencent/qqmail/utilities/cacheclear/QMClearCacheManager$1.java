package com.tencent.qqmail.utilities.cacheclear;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QMClearCacheManager$1
  implements ServiceConnection
{
  QMClearCacheManager$1(QMClearCacheManager paramQMClearCacheManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QMLog.log(4, "QMClearCacheManager", "clearCacheService connected, elapse: " + (SystemClock.elapsedRealtime() - QMClearCacheManager.access$300(this.this$0)) + "ms");
    QMClearCacheManager.access$102(this.this$0, true);
    QMClearCacheManager.access$400(this.this$0).getAndSet(false);
    QMClearCacheManager.access$202(this.this$0, new Messenger(paramIBinder));
    QMClearCacheManager.access$500(this.this$0);
    QMClearCacheManager.access$600(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QMLog.log(4, "QMClearCacheManager", " disconnected");
    QMClearCacheManager.access$102(this.this$0, false);
    QMClearCacheManager.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager.1
 * JD-Core Version:    0.7.0.1
 */