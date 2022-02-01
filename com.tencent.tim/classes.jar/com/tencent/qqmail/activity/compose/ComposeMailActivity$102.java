package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.Queue;
import moai.core.watcher.Watchers;

class ComposeMailActivity$102
  implements Runnable
{
  ComposeMailActivity$102(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    ComposeMailActivity.access$10000(this.this$0).setCanceledWithBackKey(true);
    ComposeMailActivity.access$10000(this.this$0).hideWithoutCallback();
    ComposeMailActivity.access$12300(this.this$0);
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(ComposeMailActivity.access$12400(this.this$0));
    if ((localObject != null) && (((Account)localObject).isQQMail()) && (ComposeMailActivity.access$12500(this.this$0)))
    {
      Watchers.bind(ComposeMailActivity.access$12600(this.this$0), true);
      ComposeMailActivity.access$12700(this.this$0, this.this$0.composeMail, QMTaskManager.sharedInstance(4));
      DataCollector.logEvent("Event_Save_Draft_Under_Diff_QQ_Domain");
    }
    for (;;)
    {
      if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
      {
        localObject = (Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek();
        if (localObject != null)
        {
          QMActivityManager.shareInstance().finishAllActivity();
          localObject = CalendarFragmentActivity.createIntentToReadSchedule(((Integer)localObject).intValue());
          QMRemindererBroadcast.calendarRemindIdQueue.remove();
          QMRemindererBroadcast.calendarSubjectQueue.remove();
          this.this$0.startActivity((Intent)localObject);
        }
      }
      return;
      ComposeMailActivity.access$12800(this.this$0, this.this$0.composeMail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.102
 * JD-Core Version:    0.7.0.1
 */