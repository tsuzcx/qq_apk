package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class ChatHistory$22$1
  implements Runnable
{
  ChatHistory$22$1(ChatHistory.22 param22) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.shmsgseq = this.a.this$0.FF;
    int i = this.a.this$0.app.b().a(this.a.this$0.mUin, this.a.this$0.mType, localMessageRecord);
    this.a.this$0.runOnUiThread(new ChatHistory.22.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.22.1
 * JD-Core Version:    0.7.0.1
 */