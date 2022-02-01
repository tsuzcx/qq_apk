package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;
import umt;

public class ChatHistory$16$1
  implements Runnable
{
  public ChatHistory$16$1(umt paramumt) {}
  
  public void run()
  {
    int i = this.a.this$0.app.b().N(this.a.this$0.mUin, this.a.this$0.mType);
    Message localMessage = this.a.this$0.o.obtainMessage(13);
    localMessage.arg1 = i;
    this.a.this$0.o.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.16.1
 * JD-Core Version:    0.7.0.1
 */