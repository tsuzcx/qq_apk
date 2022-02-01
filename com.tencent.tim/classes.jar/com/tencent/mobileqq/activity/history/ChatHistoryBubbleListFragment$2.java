package com.tencent.mobileqq.activity.history;

import apue;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$2
  implements Runnable
{
  ChatHistoryBubbleListFragment$2(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    if (this.this$0.mUinType == 1) {}
    for (Object localObject = this.this$0.mTroopUin;; localObject = this.this$0.mFriendUin)
    {
      MessageRecord localMessageRecord = this.this$0.mApp.b().m((String)localObject, this.this$0.mUinType, this.this$0.Kt);
      if (localMessageRecord == null) {
        break;
      }
      localObject = this.this$0.mApp.b().f((String)localObject, this.this$0.mUinType, localMessageRecord.shmsgseq, 20);
      ((List)localObject).add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.2.1(this, (List)localObject));
      return;
    }
    apue.m("chat_history", "target_404", String.valueOf(this.this$0.Kt), String.valueOf(this.this$0.mFrom), "", "");
    if (QLog.isColorLevel()) {
      QLog.e("chatHistory.troop.msgList", 2, "msg not found, fallback to loadData");
    }
    this.this$0.ie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.2
 * JD-Core Version:    0.7.0.1
 */