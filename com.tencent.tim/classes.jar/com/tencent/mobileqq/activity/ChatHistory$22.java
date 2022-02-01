package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;

class ChatHistory$22
  implements Runnable
{
  ChatHistory$22(ChatHistory paramChatHistory) {}
  
  public void run()
  {
    if (!this.this$0.isFinishing()) {
      ThreadManager.post(new ChatHistory.22.1(this), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.22
 * JD-Core Version:    0.7.0.1
 */