package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import pvz;
import ush;

public class Conversation$26$1
  implements Runnable
{
  public Conversation$26$1(ush paramush) {}
  
  public void run()
  {
    if (this.a.this$0.b != null)
    {
      this.a.this$0.b.bnj();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Conversation onUpdateFriendList");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26.1
 * JD-Core Version:    0.7.0.1
 */