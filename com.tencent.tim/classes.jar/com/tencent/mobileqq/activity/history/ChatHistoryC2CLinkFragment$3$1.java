package com.tencent.mobileqq.activity.history;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;
import zfv;

public class ChatHistoryC2CLinkFragment$3$1
  implements Runnable
{
  public ChatHistoryC2CLinkFragment$3$1(zfv paramzfv, List paramList) {}
  
  public void run()
  {
    if (this.qw.size() == 1) {
      this.a.this$0.mApp.b().b((MessageRecord)this.qw.get(0), false);
    }
    for (;;)
    {
      Message localMessage = this.a.this$0.uiHandler.obtainMessage(2);
      localMessage.obj = this.qw;
      this.a.this$0.uiHandler.sendMessage(localMessage);
      return;
      if (this.qw.size() > 1) {
        this.a.this$0.mApp.b().V(this.qw, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.3.1
 * JD-Core Version:    0.7.0.1
 */