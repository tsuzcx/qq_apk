package com.tencent.qqmail.view;

import com.tencent.qqmail.calendar.view.DataPickerViewGroup;
import java.util.Calendar;

final class ClockedMailHelper$1
  implements Runnable
{
  ClockedMailHelper$1(DataPickerViewGroup paramDataPickerViewGroup) {}
  
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(localCalendar.getTimeInMillis() + ClockedMailHelper.NEXT_ONE_HOUR_AND_FIVE_MINUTE);
    this.val$view.snapToDay(localCalendar);
    this.val$view.snapToTime(localCalendar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ClockedMailHelper.1
 * JD-Core Version:    0.7.0.1
 */