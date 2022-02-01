package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.qphone.base.util.QLog;
import ybl;

public class MultiForwardChatPie$4
  implements Runnable
{
  public MultiForwardChatPie$4(ybl paramybl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "mRunOnShow 800 hasDestory=" + this.this$0.aSY);
    }
    if ((ybl.a(this.this$0)) || (this.this$0.aSY))
    {
      QLog.i(this.this$0.TAG, 1, "onShowFirst return|3 hasDestory:" + this.this$0.aSY);
      return;
    }
    ybl.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */