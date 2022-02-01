package com.tencent.mobileqq.activity;

import afrn;
import android.os.Message;
import auru;
import unt;

public class ChatHistoryEmotionView$2
  implements Runnable
{
  public ChatHistoryEmotionView$2(unt paramunt) {}
  
  public void run()
  {
    Object localObject = unt.a(this.this$0).c(unt.a(this.this$0), unt.a(this.this$0), true);
    localObject = unt.a(this.this$0).obtainMessage(1, localObject);
    unt.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.2
 * JD-Core Version:    0.7.0.1
 */