package com.tencent.mobileqq.activity.chathistory;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListForTroopFragment$4
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$4(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.mApp.b().f(this.this$0.mTroopUin, 1, this.this$0.Ks, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListForTroopFragment.4.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.4
 * JD-Core Version:    0.7.0.1
 */