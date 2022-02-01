package com.tencent.qqmail.calendar.data;

import android.util.SparseIntArray;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import java.util.Calendar;

class WeeklyInctor
  extends RecurrenceInctor
{
  private static SparseIntArray sDOWMap = new SparseIntArray();
  protected int mDayOfWeek;
  
  static
  {
    sDOWMap.append(1, 1);
    sDOWMap.append(2, 2);
    sDOWMap.append(4, 3);
    sDOWMap.append(8, 4);
    sDOWMap.append(16, 5);
    sDOWMap.append(32, 6);
    sDOWMap.append(64, 7);
  }
  
  WeeklyInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
    this.mDayOfWeek = paramQMCalendarEvent.getDayOfWeek();
    if (this.mDayOfWeek == 0)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
      this.mDayOfWeek = QMCalendarUtil.getWeekProtocolValue(localCalendar.get(7));
    }
  }
  
  protected int firstDayOfWeek()
  {
    int i = this.mDayOfWeek;
    int j = this.mDayOfWeek;
    int k = this.mDayOfWeek;
    Integer localInteger = Integer.valueOf(sDOWMap.get(i & (j ^ k - 1)));
    if (localInteger == null) {
      return 8;
    }
    return localInteger.intValue();
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    int i = nextDayOfWeek(paramCalendar.get(7));
    if (i <= 7)
    {
      paramCalendar.set(7, i);
      return true;
    }
    i = firstDayOfWeek();
    if (i > 7) {
      return false;
    }
    nextRecurrence(paramCalendar, i);
    return true;
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    if ((1 << paramCalendar.get(7) - 1 & this.mDayOfWeek) > 0) {
      return true;
    }
    return increment(paramCalendar);
  }
  
  protected int nextDayOfWeek(int paramInt)
  {
    int i = paramInt + 1;
    int j = 1 << paramInt;
    paramInt = i;
    i = j;
    for (;;)
    {
      if ((paramInt > 7) || ((this.mDayOfWeek & i) != 0)) {
        return paramInt;
      }
      i <<= 1;
      paramInt += 1;
    }
  }
  
  protected void nextRecurrence(Calendar paramCalendar, int paramInt)
  {
    paramCalendar.add(3, this.mInterval);
    paramCalendar.set(7, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.WeeklyInctor
 * JD-Core Version:    0.7.0.1
 */