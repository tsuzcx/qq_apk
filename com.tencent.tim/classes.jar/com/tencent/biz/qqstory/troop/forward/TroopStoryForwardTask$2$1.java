package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import rnx;
import rny;

public class TroopStoryForwardTask$2$1
  implements Runnable
{
  public TroopStoryForwardTask$2$1(rny paramrny, String paramString) {}
  
  public void run()
  {
    this.a.this$0.a.storyId = this.aBv;
    this.a.this$0.a.serial();
    this.a.this$0.mApp.b().c(this.a.this$0.a.frienduin, this.a.this$0.a.istroop, this.a.this$0.a.uniseq, this.a.this$0.a.msgData);
    this.a.this$0.mHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.2.1
 * JD-Core Version:    0.7.0.1
 */