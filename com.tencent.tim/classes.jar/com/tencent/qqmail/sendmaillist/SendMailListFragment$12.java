package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.view.ClockedMailHelper;
import java.util.Calendar;

class SendMailListFragment$12
  implements DataPickerViewGroup.DatePickerListener
{
  SendMailListFragment$12(SendMailListFragment paramSendMailListFragment, QMSendMailTask paramQMSendMailTask) {}
  
  public void onPickCancel(Calendar paramCalendar) {}
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    this.val$sendMailTask.getMail().setClockSendTime(paramCalendar.getTimeInMillis());
    QMTaskManager.sharedInstance(1).restart(this.val$sendMailTask.getId());
    return true;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(SendMailListFragment.access$1900(this.this$0), paramCalendar.getTimeInMillis(), true);
  }
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(SendMailListFragment.access$1900(this.this$0), paramCalendar.getTimeInMillis(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.12
 * JD-Core Version:    0.7.0.1
 */