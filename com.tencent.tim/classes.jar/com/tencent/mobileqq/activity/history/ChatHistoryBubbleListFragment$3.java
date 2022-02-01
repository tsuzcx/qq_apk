package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$3
  implements Runnable
{
  ChatHistoryBubbleListFragment$3(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mUinType == 1) {}
    for (Object localObject = this.this$0.mTroopUin;; localObject = this.this$0.mFriendUin)
    {
      localObject = this.this$0.mApp.b().f((String)localObject, this.this$0.mUinType, this.this$0.Ks, 20);
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.3.1(this, (List)localObject));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.3
 * JD-Core Version:    0.7.0.1
 */