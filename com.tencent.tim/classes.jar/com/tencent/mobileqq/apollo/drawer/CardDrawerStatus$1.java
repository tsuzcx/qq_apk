package com.tencent.mobileqq.apollo.drawer;

import abky;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class CardDrawerStatus$1
  implements Runnable
{
  public CardDrawerStatus$1(abky paramabky, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.val$app != null) && (MediaPlayerManager.a(this.val$app) == null)) {
      QLog.w("CardDrawerStatus", 1, "MediaPlayerManager is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.CardDrawerStatus.1
 * JD-Core Version:    0.7.0.1
 */