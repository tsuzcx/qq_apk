package com.tencent.mobileqq.app.utils;

import achs;
import aczx;
import aczx.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class MessageRoamHandler$ChatHistoryMessageObserver$1
  implements Runnable
{
  public MessageRoamHandler$ChatHistoryMessageObserver$1(aczx.a parama, long paramLong, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.val$beginTime * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.cAS);
    }
    if (this.a.b.a(this.Mu, (Calendar)localObject, this.bKE, this.cAS)) {
      return;
    }
    localObject = (achs)this.a.b.app.getManager(92);
    if (this.bKE) {}
    for (int i = 1;; i = 0)
    {
      ((achs)localObject).l(0, i, Long.valueOf(this.val$beginTime));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver.1
 * JD-Core Version:    0.7.0.1
 */