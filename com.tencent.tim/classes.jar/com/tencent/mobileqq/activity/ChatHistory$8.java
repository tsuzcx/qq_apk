package com.tencent.mobileqq.activity;

import akwh;
import android.os.Message;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

class ChatHistory$8
  implements Runnable
{
  ChatHistory$8(ChatHistory paramChatHistory, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = null;
    if (this.aTR) {
      localStringBuilder = new StringBuilder();
    }
    int i = 0;
    if (this.this$0.b != null) {
      i = this.this$0.b.dG(MessageRecord.getTableName(this.this$0.mUin, this.this$0.mType));
    }
    int j = ChatHistory.a(this.this$0.app, this.this$0.mUin, this.this$0.mType, localStringBuilder);
    Message localMessage = this.this$0.o.obtainMessage(this.bFm);
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      localMessage.obj = localStringBuilder.toString();
    }
    localMessage.arg1 = j;
    localMessage.arg2 = i;
    this.this$0.o.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.8
 * JD-Core Version:    0.7.0.1
 */