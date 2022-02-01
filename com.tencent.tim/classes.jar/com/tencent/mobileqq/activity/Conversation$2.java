package com.tencent.mobileqq.activity;

import aqiw;
import com.tencent.qphone.base.util.BaseApplication;

class Conversation$2
  implements Runnable
{
  Conversation$2(Conversation paramConversation, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = aqiw.bW(BaseApplication.getContext());
    this.this$0.runOnUiThread(new Conversation.2.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.2
 * JD-Core Version:    0.7.0.1
 */