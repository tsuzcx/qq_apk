package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.LinkedHashMap;

class ChatHistoryC2CFileFragment$1
  implements Runnable
{
  ChatHistoryC2CFileFragment$1(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.brk) {}
    for (LinkedHashMap localLinkedHashMap = ChatHistoryC2CFileFragment.a(this.this$0);; localLinkedHashMap = ChatHistoryC2CFileFragment.b(this.this$0))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryC2CFileFragment.1.1(this, localLinkedHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.1
 * JD-Core Version:    0.7.0.1
 */