package com.tencent.qqmail.view;

import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import java.util.Calendar;

public abstract class DatePickerListenerAdapter
  implements DataPickerViewGroup.DatePickerListener
{
  public void onPickCancel(Calendar paramCalendar) {}
  
  public boolean onPickConfirm(Calendar paramCalendar)
  {
    return false;
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar) {}
  
  public void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar) {}
  
  public void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DatePickerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */