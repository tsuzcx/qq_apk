package com.tencent.mobileqq.leba.core.redtouch;

import aimp;
import aizy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LebaSpecificRedTouch$2
  implements Runnable
{
  public LebaSpecificRedTouch$2(aimp paramaimp, QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    int i = aizy.Q(this.val$app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.LebaSpecificRedTouch", 2, "updateExtendFriendRedTouch() : " + i);
    }
    if (this.N != null) {
      ThreadManager.getUIHandler().post(new LebaSpecificRedTouch.2.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.2
 * JD-Core Version:    0.7.0.1
 */