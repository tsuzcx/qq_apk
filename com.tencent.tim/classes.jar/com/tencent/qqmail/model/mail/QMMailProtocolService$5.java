package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;

class QMMailProtocolService$5
  implements MailManagerDelegate.DataCallback
{
  QMMailProtocolService$5(QMMailProtocolService paramQMMailProtocolService, Profile paramProfile, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMProxyUtil.noNeedProxy(this.val$profile);
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService.5
 * JD-Core Version:    0.7.0.1
 */