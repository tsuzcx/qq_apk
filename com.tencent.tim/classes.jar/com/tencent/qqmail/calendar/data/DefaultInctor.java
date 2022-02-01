package com.tencent.qqmail.calendar.data;

import java.util.Calendar;

class DefaultInctor
  extends RecurrenceInctor
{
  protected DefaultInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    return false;
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.DefaultInctor
 * JD-Core Version:    0.7.0.1
 */