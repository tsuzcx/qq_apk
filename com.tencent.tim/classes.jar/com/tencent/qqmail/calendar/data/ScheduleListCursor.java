package com.tencent.qqmail.calendar.data;

import android.database.Cursor;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Calendar;

public class ScheduleListCursor
{
  private Cursor mCursor = null;
  private int mPosition = -1;
  
  public ScheduleListCursor(Calendar paramCalendar)
  {
    this.mCursor = QMCalendarManager.getInstance().getScheduleListCursor(paramCalendar);
    this.mCursor.getCount();
  }
  
  public void close()
  {
    if (this.mCursor != null)
    {
      this.mCursor.close();
      this.mCursor = null;
    }
  }
  
  public int getCount()
  {
    if (this.mCursor != null) {
      return this.mCursor.getCount();
    }
    return -1;
  }
  
  public QMSchedule getItem(int paramInt)
  {
    if (this.mCursor != null)
    {
      Cursor localCursor = this.mCursor;
      this.mPosition = paramInt;
      localCursor.moveToPosition(paramInt);
      return QMCalendarManager.getInstance().getScheduleFromCursor(this.mCursor);
    }
    return null;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public void update(Calendar paramCalendar)
  {
    close();
    this.mCursor = QMCalendarManager.getInstance().getScheduleListCursor(paramCalendar);
  }
  
  public void updateAsync(Calendar paramCalendar, ScheduleLoadWatcher paramScheduleLoadWatcher)
  {
    Threads.runInBackground(new ScheduleListCursor.1(this, paramCalendar, paramScheduleLoadWatcher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.ScheduleListCursor
 * JD-Core Version:    0.7.0.1
 */