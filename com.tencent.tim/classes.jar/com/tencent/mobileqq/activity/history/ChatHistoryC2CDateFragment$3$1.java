package com.tencent.mobileqq.activity.history;

import achs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;
import zfh;

public class ChatHistoryC2CDateFragment$3$1
  implements Runnable
{
  public ChatHistoryC2CDateFragment$3$1(zfh paramzfh) {}
  
  public void run()
  {
    if ((ChatHistoryC2CDateFragment.a(this.a.this$0) != null) && (this.a.this$0.mApp != null))
    {
      this.a.this$0.mApp.a().transSaveToDatabase();
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(ChatHistoryC2CDateFragment.a(this.a.this$0).getTimeInMillis());
      ((Calendar)localObject).add(5, 1);
      long l1 = ChatHistoryC2CDateFragment.a(this.a.this$0).getTimeInMillis() / 1000L;
      long l2 = ((Calendar)localObject).getTimeInMillis() / 1000L;
      localObject = ChatHistoryC2CDateFragment.a(this.a.this$0).a(ChatHistoryC2CDateFragment.a(this.a.this$0), l1, l2);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (MessageRecord)((List)localObject).get(0);
        if (this.a.this$0.getActivity() != null) {
          ChatHistoryActivity.a(this.a.this$0.getActivity(), ChatHistoryC2CDateFragment.a(this.a.this$0), ChatHistoryC2CDateFragment.a(this.a.this$0), ChatHistoryC2CDateFragment.b(this.a.this$0), ((MessageRecord)localObject).time, ((MessageRecord)localObject).shmsgseq, 0);
        }
      }
      for (;;)
      {
        ChatHistoryC2CDateFragment.a(this.a.this$0, null);
        return;
        QLog.e(ChatHistoryC2CDateFragment.access$100(), 2, "msgList is empty");
        ThreadManager.getUIHandler().post(new ChatHistoryC2CDateFragment.3.1.1(this));
      }
    }
    QLog.e(ChatHistoryC2CDateFragment.access$100(), 2, "click day is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.3.1
 * JD-Core Version:    0.7.0.1
 */