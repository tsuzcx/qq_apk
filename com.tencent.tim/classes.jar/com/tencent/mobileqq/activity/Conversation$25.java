package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class Conversation$25
  implements Runnable
{
  Conversation$25(Conversation paramConversation) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "delayUpdateMayKnowRecommendRunnable");
    }
    Conversation.i(this.this$0);
    this.this$0.g.sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.25
 * JD-Core Version:    0.7.0.1
 */