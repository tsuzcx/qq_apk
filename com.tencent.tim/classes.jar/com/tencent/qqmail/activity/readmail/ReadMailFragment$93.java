package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.view.ClockedMailHelper;
import java.util.Calendar;
import moai.oss.KvHelper;

class ReadMailFragment$93
  implements DataPickerViewGroup.DatePickerListener
{
  ReadMailFragment$93(ReadMailFragment paramReadMailFragment) {}
  
  public void onPickCancel(Calendar paramCalendar) {}
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    if ((ReadMailFragment.access$000(this.this$0) != null) && (ReadMailFragment.access$000(this.this$0).getInformation() != null))
    {
      KvHelper.calendarRemindConfirm(new double[0]);
      MailInformation localMailInformation = ReadMailFragment.access$000(this.this$0).getInformation();
      paramCalendar = QMCalendarManager.getInstance().createRelatedEvent(paramCalendar.getTimeInMillis(), 1, localMailInformation.getRemoteId(), ReadMailFragment.access$000(this.this$0).getInformation().getAccountId(), localMailInformation.getSubject());
      if (paramCalendar.getCategory() == 1) {
        break label113;
      }
      QMCalendarManager.getInstance().createEvent(paramCalendar);
    }
    for (;;)
    {
      Toast.makeText(this.this$0.getActivity(), this.this$0.getString(2131719978), 0).show();
      return true;
      label113:
      CalendarProviderManager.sharedInstance().createLocalEvent(paramCalendar);
    }
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar)
  {
    KvHelper.calendarRemindDate(new double[0]);
    ClockedMailHelper.backToRightTime(ReadMailFragment.access$16200(this.this$0), paramCalendar.getTimeInMillis(), true);
  }
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar)
  {
    ClockedMailHelper.backToRightTime(ReadMailFragment.access$16200(this.this$0), paramCalendar.getTimeInMillis(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.93
 * JD-Core Version:    0.7.0.1
 */