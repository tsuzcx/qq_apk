package com.tencent.mobileqq.app;

import aizd;
import auqe;
import ausb;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;

class QQAppInterface$10
  implements Runnable
{
  QQAppInterface$10(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 265);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 267);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 274);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 236);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 268);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 272);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 271);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 273);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 239);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 266);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 524);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 527);
      localQQNotificationManager.cancel("QQAppInterface_removeNotification", 3000529);
      ausb localausb = (ausb)this.this$0.getManager(313);
      if (localausb != null) {
        localausb.ewB();
      }
      ((aizd)this.this$0.getManager(284)).a(localQQNotificationManager, -1);
      auqe.gh(this.this$0.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "removeNotification");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("notification", 2, "removeNotification", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.10
 * JD-Core Version:    0.7.0.1
 */