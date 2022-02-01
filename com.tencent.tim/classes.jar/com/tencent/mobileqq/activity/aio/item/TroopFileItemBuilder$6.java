package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import xpw;

public class TroopFileItemBuilder$6
  implements Runnable
{
  public void run()
  {
    this.this$0.app.b().t(this.b.frienduin, this.b.istroop, this.b.uniseq);
    this.this$0.mUiHandler.post(new TroopFileItemBuilder.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */