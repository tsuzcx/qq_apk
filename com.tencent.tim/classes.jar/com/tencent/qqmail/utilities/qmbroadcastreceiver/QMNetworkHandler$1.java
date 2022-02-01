package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.os.Bundle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.Set;

class QMNetworkHandler$1
  implements Runnable
{
  QMNetworkHandler$1(QMNetworkHandler paramQMNetworkHandler) {}
  
  public void run()
  {
    Threads.removeCallbackInBackground(this);
    if (QMServiceManager.isPushEnable()) {
      QMNetworkHandler.access$000(this.this$0);
    }
    if (QMNetworkHandler.access$100(this.this$0) != null)
    {
      localObject = QMNetworkHandler.access$100(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QMNetworkHandler.NetworkListener)((Iterator)localObject).next()).onNetworkChanged(QMNetworkUtils.isNetworkConnected());
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("from", QMScheduledJobs.FromType.NETWORK_CHANGE);
    QMScheduledJobs.doJobs((Bundle)localObject);
    if ((QMApplicationContext.sharedInstance().isMainProcess()) && (QMNetworkUtils.isNetworkAvailable())) {
      QMMailManager.sharedInstance().notifyIdle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler.1
 * JD-Core Version:    0.7.0.1
 */