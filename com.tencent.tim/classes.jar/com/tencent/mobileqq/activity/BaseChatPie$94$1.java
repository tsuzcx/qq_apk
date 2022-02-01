package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import wki;

class BaseChatPie$94$1
  implements Runnable
{
  BaseChatPie$94$1(BaseChatPie.94 param94) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.i(this.a.this$0.TAG, 1, "ScheduleAccept notify adapter modified schedule message : " + this.a.aLH);
    }
    if (this.a.this$0.a != null) {
      this.a.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.94.1
 * JD-Core Version:    0.7.0.1
 */