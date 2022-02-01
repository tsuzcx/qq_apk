package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$1(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    if (this.this$0.mUinType == 1) {}
    for (Object localObject = this.this$0.mTroopUin;; localObject = this.this$0.mFriendUin)
    {
      localObject = this.this$0.mApp.b().e((String)localObject, this.this$0.mUinType, 9223372036854775807L, 20);
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.1.1(this, (List)localObject));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.1
 * JD-Core Version:    0.7.0.1
 */