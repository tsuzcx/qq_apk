package com.tencent.qqmail.utilities.keepalive;

import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;

final class KeepAliveManager$Hints$1
  implements Runnable
{
  public void run()
  {
    QMSyncAdapterManager.setMasterSync(true);
    QMSyncAdapterManager.setAutoSync(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.Hints.1
 * JD-Core Version:    0.7.0.1
 */