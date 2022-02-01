package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryTroopAllFragment$5
  implements Runnable
{
  ChatHistoryTroopAllFragment$5(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.mApp.b().e(this.this$0.mTroopUin, 1, this.this$0.Kr, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopAllFragment.5.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.5
 * JD-Core Version:    0.7.0.1
 */