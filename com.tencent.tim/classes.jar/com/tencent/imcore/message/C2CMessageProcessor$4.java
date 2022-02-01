package com.tencent.imcore.message;

import asih;
import com.tencent.mobileqq.data.MessageRecord;
import tob;

public class C2CMessageProcessor$4
  implements Runnable
{
  public C2CMessageProcessor$4(tob paramtob, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    asih.a(this.this$0.app, this.g.istroop, this.g.frienduin, String.valueOf(this.g.mQidianMasterUin), String.valueOf(this.g.mQidianTaskId), this.g.mQidianTipText, this.g.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.4
 * JD-Core Version:    0.7.0.1
 */