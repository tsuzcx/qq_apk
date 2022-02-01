package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.ClockedMailHelper;
import java.util.Calendar;

class ComposeMailActivity$89
  implements DataPickerViewGroup.DatePickerListener
{
  ComposeMailActivity$89(ComposeMailActivity paramComposeMailActivity, boolean paramBoolean) {}
  
  public void onPickCancel(Calendar paramCalendar)
  {
    ComposeMailActivity.access$5500(this.this$0);
  }
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    this.this$0.composeMail.setClockSendTime(paramCalendar.getTimeInMillis());
    ComposeMailActivity.access$11102(this.this$0, true);
    if (this.val$needSaveCard)
    {
      ComposeMailActivity.access$3800(this.this$0);
      DataCollector.logEvent("Event_Card_Mail_Timer_Send");
      return true;
    }
    ComposeMailActivity.access$8100(this.this$0);
    return true;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(ComposeMailActivity.access$11000(this.this$0), paramCalendar.getTimeInMillis(), true);
  }
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(ComposeMailActivity.access$11000(this.this$0), paramCalendar.getTimeInMillis(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.89
 * JD-Core Version:    0.7.0.1
 */