package com.tencent.mobileqq.activity;

import android.os.Message;
import mqq.os.MqqHandler;

class ChatSettingActivity$7
  implements Runnable
{
  ChatSettingActivity$7(ChatSettingActivity paramChatSettingActivity, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    Message localMessage = null;
    Object localObject = localMessage;
    if (this.C != null)
    {
      localObject = localMessage;
      if (this.C.length() > 0) {
        localObject = this.C.toString();
      }
    }
    if (ChatSettingActivity.a(this.this$0, ChatSettingActivity.b(this.this$0), ChatSettingActivity.a(this.this$0), this.C) > 0)
    {
      localMessage = this.this$0.b.obtainMessage();
      localMessage.what = 18;
      localMessage.obj = localObject;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */