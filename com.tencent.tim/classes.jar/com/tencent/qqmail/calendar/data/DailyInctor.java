package com.tencent.qqmail.calendar.data;

import java.util.Calendar;

class DailyInctor
  extends RecurrenceInctor
{
  DailyInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    paramCalendar.add(5, this.mInterval);
    return true;
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.DailyInctor
 * JD-Core Version:    0.7.0.1
 */