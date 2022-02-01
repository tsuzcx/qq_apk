package com.tencent.qqmail.activity.readmail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadIcsFragment$3
  implements View.OnClickListener
{
  ReadIcsFragment$3(ReadIcsFragment paramReadIcsFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadIcsFragment.access$700(this.this$0))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      localObject = CalendarFragmentActivity.createIntentToCheckSchedule(ReadIcsFragment.access$000(this.this$0).getStartTime());
      this.this$0.startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    ReadIcsFragment.access$702(this.this$0, true);
    Object localObject = ReadIcsFragment.access$800(this.this$0).getDefaultFolderByAccountId(ReadIcsFragment.access$000(this.this$0).getAccountId());
    if (localObject != null) {}
    for (int i = ((QMCalendarFolder)localObject).getId();; i = -1)
    {
      localObject = new QMCalendarEvent();
      ((QMCalendarEvent)localObject).setAccountId(ReadIcsFragment.access$000(this.this$0).getAccountId());
      ((QMCalendarEvent)localObject).setIsAllDay(ReadIcsFragment.access$000(this.this$0).isAllDay());
      ((QMCalendarEvent)localObject).setBody(ReadIcsFragment.access$000(this.this$0).getBody());
      ((QMCalendarEvent)localObject).setCalderFolderId(i);
      ((QMCalendarEvent)localObject).setCategory(ReadIcsFragment.access$000(this.this$0).getCategory());
      ((QMCalendarEvent)localObject).setCreateTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
      ((QMCalendarEvent)localObject).setEndTime(ReadIcsFragment.access$000(this.this$0).getEndTime());
      ((QMCalendarEvent)localObject).seteTag("");
      ((QMCalendarEvent)localObject).setExceptionHashMap(ReadIcsFragment.access$000(this.this$0).getExceptionHashMap());
      ((QMCalendarEvent)localObject).setInterval(ReadIcsFragment.access$000(this.this$0).getInterval());
      ((QMCalendarEvent)localObject).setLocation(ReadIcsFragment.access$000(this.this$0).getLocation());
      ((QMCalendarEvent)localObject).setModifyTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
      ((QMCalendarEvent)localObject).setOffLineOptType(0);
      ((QMCalendarEvent)localObject).setOrganizerEmail("");
      ((QMCalendarEvent)localObject).setOrganizerName("");
      ((QMCalendarEvent)localObject).setPath("");
      ((QMCalendarEvent)localObject).setRecurrenceType(ReadIcsFragment.access$000(this.this$0).getRecurrenceType());
      if (((QMCalendarEvent)localObject).getRecurrenceType() != -1)
      {
        ((QMCalendarEvent)localObject).setDayOfMonth(ReadIcsFragment.access$000(this.this$0).getDayOfMonth());
        ((QMCalendarEvent)localObject).setDayOfWeek(ReadIcsFragment.access$000(this.this$0).getDayOfWeek());
        ((QMCalendarEvent)localObject).setMonthOfYear(ReadIcsFragment.access$000(this.this$0).getMonthOfYear());
        ((QMCalendarEvent)localObject).setWeekOfMonth(ReadIcsFragment.access$000(this.this$0).getWeekOfMonth());
      }
      ((QMCalendarEvent)localObject).setRelateAccountId(ReadIcsFragment.access$000(this.this$0).getRelateAccountId());
      ((QMCalendarEvent)localObject).setRelatedId(ReadIcsFragment.access$000(this.this$0).getRelatedId());
      ((QMCalendarEvent)localObject).setRelateType(ReadIcsFragment.access$000(this.this$0).getResponseType());
      ((QMCalendarEvent)localObject).setReminder(ReadIcsFragment.access$000(this.this$0).getReminder());
      ((QMCalendarEvent)localObject).setReminderId(ReadIcsFragment.access$000(this.this$0).getReminderId());
      ((QMCalendarEvent)localObject).setSensivity(0);
      ((QMCalendarEvent)localObject).setStartTime(ReadIcsFragment.access$000(this.this$0).getStartTime());
      ((QMCalendarEvent)localObject).setSubject(ReadIcsFragment.access$000(this.this$0).getSubject());
      ((QMCalendarEvent)localObject).setSvrId("");
      ((QMCalendarEvent)localObject).setTimezone(String.valueOf(QMCalendarManager.timeZone));
      ((QMCalendarEvent)localObject).setUntil(ReadIcsFragment.access$000(this.this$0).getUntil());
      ((QMCalendarEvent)localObject).setUid(ReadIcsFragment.access$000(this.this$0).getUid());
      ((QMCalendarEvent)localObject).setId(QMCalendarEvent.generateId((QMCalendarEvent)localObject));
      QMCalendarManager.logEvent("Event_Calender_Ics_Create_Event");
      QMCalendarManager.getInstance().createEvent((QMCalendarEvent)localObject);
      this.this$0.getTips().showSuccess(2131694731);
      this.this$0.refreshData();
      this.this$0.render(0);
      break;
      QMLog.log(6, "ReadIcsFragment", "account:" + ReadIcsFragment.access$000(this.this$0).getAccountId() + "'s default folder is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadIcsFragment.3
 * JD-Core Version:    0.7.0.1
 */