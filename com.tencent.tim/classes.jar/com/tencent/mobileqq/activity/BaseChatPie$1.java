package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class BaseChatPie$1
  implements Runnable
{
  BaseChatPie$1(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "mRunOnShow 800 hasDestory=" + this.this$0.aSY);
    }
    if ((this.this$0.aSE) || (this.this$0.aSY))
    {
      QLog.i(this.this$0.TAG, 1, "onShowFirst return|3 hasDestory:" + this.this$0.aSY);
      return;
    }
    this.this$0.zZ(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.1
 * JD-Core Version:    0.7.0.1
 */