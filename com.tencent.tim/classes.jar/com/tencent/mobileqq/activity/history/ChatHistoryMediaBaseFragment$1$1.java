package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;
import zgi;

public class ChatHistoryMediaBaseFragment$1$1
  implements Runnable
{
  public ChatHistoryMediaBaseFragment$1$1(zgi paramzgi, List paramList) {}
  
  public void run()
  {
    if (this.qw.size() == 1) {
      this.a.a.mApp.b().b((MessageRecord)this.qw.get(0), false);
    }
    for (;;)
    {
      this.a.a.uiHandler.sendEmptyMessage(2);
      return;
      if (this.qw.size() > 1) {
        this.a.a.mApp.b().V(this.qw, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.1.1
 * JD-Core Version:    0.7.0.1
 */