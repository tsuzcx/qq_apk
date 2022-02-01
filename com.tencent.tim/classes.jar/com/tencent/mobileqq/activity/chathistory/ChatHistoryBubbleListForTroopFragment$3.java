package com.tencent.mobileqq.activity.chathistory;

import apue;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListForTroopFragment$3
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$3(ChatHistoryBubbleListForTroopFragment paramChatHistoryBubbleListForTroopFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.mApp.b().m(this.this$0.mTroopUin, 1, this.this$0.Kt);
    if (localMessageRecord != null)
    {
      List localList = this.this$0.mApp.b().f(this.this$0.mTroopUin, 1, localMessageRecord.shmsgseq, 20);
      localList.add(0, localMessageRecord);
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListForTroopFragment.3.1(this, localList));
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
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.3
 * JD-Core Version:    0.7.0.1
 */