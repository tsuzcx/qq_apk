package com.tencent.biz.qqstory.notification;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import qea;

public class StoryMsgNotification$2
  implements Runnable
{
  public StoryMsgNotification$2(qea paramqea) {}
  
  public void run()
  {
    qea.aJ.clear();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    int j = qea.E.size();
    int i = 0;
    while (i < j)
    {
      localQQNotificationManager.cancel("StoryMsgNotification", qea.E.get(qea.E.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotification.2
 * JD-Core Version:    0.7.0.1
 */