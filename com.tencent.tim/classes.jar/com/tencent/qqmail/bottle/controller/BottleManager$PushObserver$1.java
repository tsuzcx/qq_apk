package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;

class BottleManager$PushObserver$1
  implements Runnable
{
  BottleManager$PushObserver$1(BottleManager.PushObserver paramPushObserver, QMNotificationConstructor paramQMNotificationConstructor, int paramInt) {}
  
  public void run()
  {
    this.val$notificationConstructor.clearPushBottleNotify(this.val$notificationId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.PushObserver.1
 * JD-Core Version:    0.7.0.1
 */