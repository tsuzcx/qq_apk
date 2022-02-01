package com.tencent.imcore.message;

import android.os.Handler;
import tnt;

public class BaseMessageManager$1
  implements Runnable
{
  public BaseMessageManager$1(tnt paramtnt, String paramString1, int paramInt1, int paramInt2, QQMessageFacade.b paramb, String paramString2) {}
  
  public void run()
  {
    this.this$0.b.df("refreshMessageListHead uin = " + this.val$uin + ", type = " + this.val$type + ", count = " + this.val$count + ", context = " + this.a, ", timestamp = " + System.currentTimeMillis());
    this.this$0.b(this.val$uin, this.val$type, this.val$count, this.a);
    this.this$0.a(this.a);
    this.this$0.b.mUIHandler.post(new BaseMessageManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.1
 * JD-Core Version:    0.7.0.1
 */