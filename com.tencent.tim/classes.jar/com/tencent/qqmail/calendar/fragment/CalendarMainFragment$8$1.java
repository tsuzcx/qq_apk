package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderConversionManager;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class CalendarMainFragment$8$1
  implements Action1<Boolean>
{
  CalendarMainFragment$8$1(CalendarMainFragment.8 param8) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventCalendarOpenSystemCalendar(new double[0]);
      QMCalendarManager.getInstance().setShowSystemCalendar(true);
      CalendarProviderConversionManager.sharedInstance().onSystemCalendarDisplayChanged(true);
      return;
    }
    PermissionUtils.permissionWarn(this.this$1.this$0.getActivity(), 2131718902, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.8.1
 * JD-Core Version:    0.7.0.1
 */