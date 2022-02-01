package com.tencent.mobileqq.activity.history;

import abrb;
import akwh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.QLog;
import zes;

public class ChatHistoryBubbleListFragment$5$1
  implements Runnable
{
  public ChatHistoryBubbleListFragment$5$1(zes paramzes) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "do delete uniseq=" + this.a.a.uniseq + ",id=" + this.a.a.getId());
    }
    akwh localakwh = (akwh)this.a.this$0.mApp.getManager(201);
    if (localakwh != null) {
      localakwh.c(this.a.a, false);
    }
    this.a.this$0.mApp.b().b(this.a.a, true);
    if ((this.a.a instanceof MessageForApollo)) {
      abrb.F(this.a.this$0.mApp, "chat_history_start_del_msg");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */