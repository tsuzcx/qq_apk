package com.tencent.mobileqq.matchchat;

import aizy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class MatchChatMsgUtil$1
  implements Runnable
{
  public MatchChatMsgUtil$1(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch) {}
  
  public void run()
  {
    int i = aizy.Q(this.val$app);
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgUtil", 2, "updateExtendFriendRedTouch() : " + i);
    }
    if (this.N != null) {
      ThreadManager.getUIHandler().post(new MatchChatMsgUtil.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */