package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class BaseChatPie$41$1
  implements Runnable
{
  BaseChatPie$41$1(BaseChatPie.41 param41) {}
  
  public void run()
  {
    CharSequence localCharSequence = this.a.this$0.a.a(this.a.val$intent, this.a.a);
    this.a.this$0.uiHandler.obtainMessage(95, localCharSequence).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.41.1
 * JD-Core Version:    0.7.0.1
 */