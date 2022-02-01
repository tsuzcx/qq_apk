package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.view.ClockedMailHelper;
import java.util.Calendar;

class ReadMailFragment$92
  implements DataPickerViewGroup.DatePickerListener
{
  ReadMailFragment$92(ReadMailFragment paramReadMailFragment) {}
  
  public void onPickCancel(Calendar paramCalendar) {}
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null))
    {
      long l1 = ReadMailFragment.access$000(this.this$0).getInformation().getId();
      String str = ReadMailFragment.access$000(this.this$0).getInformation().getRemoteId();
      long l2 = paramCalendar.getTimeInMillis();
      QMMailManager.sharedInstance().modifySendUtc(ReadMailFragment.access$200(this.this$0), l1, str, l2);
    }
    return true;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(ReadMailFragment.access$16200(this.this$0), paramCalendar.getTimeInMillis(), true);
  }
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(ReadMailFragment.access$16200(this.this$0), paramCalendar.getTimeInMillis(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.92
 * JD-Core Version:    0.7.0.1
 */