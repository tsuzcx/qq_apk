package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.network.filter.RequestFilter;

class QMMailProtocolManager$16
  implements Runnable
{
  QMMailProtocolManager$16(QMMailProtocolManager paramQMMailProtocolManager, String paramString) {}
  
  public void run()
  {
    RequestFilter.resetRequestRunningState(this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.16
 * JD-Core Version:    0.7.0.1
 */