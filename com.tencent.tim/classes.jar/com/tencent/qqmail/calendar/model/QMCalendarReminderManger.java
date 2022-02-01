package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarReminder;
import com.tencent.qqmail.calendar.data.RecurrenceInctor;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class QMCalendarReminderManger
{
  private static final String TAG = QMCalendarReminderManger.class.getSimpleName();
  private static final long miliSecondsHalfMonth = 1296000000L;
  private static final long miliSecondsPerDay = 86400000L;
  private static final long miliSecondsPerMinute = 60000L;
  private static QMScheduleManager.TLCalendar startStepTLCalendar = new QMScheduleManager.TLCalendar();
  private static QMScheduleManager.TLCalendar tempTLCalendar = new QMScheduleManager.TLCalendar();
  private long cacheEnd = -1L;
  private QMCalendarSQLiteHelper mSqLiteHelper;
  private TimeZone mTimeZone = TimeZone.getDefault();
  
  public QMCalendarReminderManger(QMCalendarSQLiteHelper paramQMCalendarSQLiteHelper)
  {
    this.mSqLiteHelper = paramQMCalendarSQLiteHelper;
    restoreCacheEnd();
  }
  
  private long correctTimeToSecond(long paramLong)
  {
    return paramLong / 1000L * 1000L;
  }
  
  private void createReminderForNormailEvent(ArrayList<QMCalendarReminder> paramArrayList, QMCalendarEvent paramQMCalendarEvent, String paramString)
  {
    paramString = startStepTLCalendar.get(this.mTimeZone);
    paramString.setTimeInMillis(paramQMCalendarEvent.getStartTime());
    paramArrayList.add(getReminder(paramQMCalendarEvent, paramString));
  }
  
  private void createReminderForRecurrentEvent(ArrayList<QMCalendarReminder> paramArrayList, QMCalendarEvent paramQMCalendarEvent, long paramLong1, long paramLong2)
  {
    Calendar localCalendar = tempTLCalendar.get(this.mTimeZone);
    long l2 = paramQMCalendarEvent.getStartTime();
    long l4 = paramQMCalendarEvent.getEndTime();
    long l3 = paramQMCalendarEvent.getUntil();
    long l1 = paramLong1;
    if (l2 > paramLong1) {
      l1 = l2;
    }
    paramLong1 = paramLong2;
    QMCalendarEvent localQMCalendarEvent;
    RecurrenceInctor localRecurrenceInctor;
    if (l3 != 0L)
    {
      if (l3 > paramLong2) {
        paramLong1 = paramLong2;
      }
    }
    else
    {
      localCalendar.setTimeInMillis(l2);
      localQMCalendarEvent = new QMCalendarEvent();
      localQMCalendarEvent.setId(paramQMCalendarEvent.getId());
      localQMCalendarEvent.setAccountId(paramQMCalendarEvent.getAccountId());
      localQMCalendarEvent.setCalderFolderId(paramQMCalendarEvent.getCalderFolderId());
      localQMCalendarEvent.setCategory(paramQMCalendarEvent.getCategory());
      localQMCalendarEvent.setCreateTime(paramQMCalendarEvent.getCreateTime());
      localRecurrenceInctor = RecurrenceInctor.createInstance(paramQMCalendarEvent);
      if (paramQMCalendarEvent.isLunarCalendar()) {
        RecurrenceInctor.correctStartTimeForLunarCalendar(localCalendar, paramQMCalendarEvent);
      }
    }
    label145:
    label209:
    do
    {
      if (localCalendar.getTimeInMillis() > paramLong1) {
        return;
      }
      RecurringException localRecurringException;
      if (localCalendar.getTimeInMillis() >= l1 - (l4 - l2))
      {
        paramLong2 = localCalendar.getTimeInMillis() - l2;
        if (paramLong2 <= 0L) {
          break label285;
        }
        localQMCalendarEvent.setStartTime(l2 + paramLong2);
        localQMCalendarEvent.setEndTime(paramLong2 + l4);
        localRecurringException = QMCalendarManager.getExceptionFromEvent(paramQMCalendarEvent, localCalendar);
        if (localRecurringException != null) {
          break label302;
        }
        localQMCalendarEvent.setIsAllDay(paramQMCalendarEvent.isAllDay());
        localQMCalendarEvent.setRecurrenceType(-1);
        localQMCalendarEvent.setSubject(paramQMCalendarEvent.getSubject());
        localQMCalendarEvent.setReminder(paramQMCalendarEvent.getReminder());
        createReminderForNormailEvent(paramArrayList, localQMCalendarEvent, null);
      }
      for (;;)
      {
        if (!paramQMCalendarEvent.isLunarCalendar()) {
          break label335;
        }
        RecurrenceInctor.increaseForLunarCalendar(localCalendar, paramQMCalendarEvent);
        break label145;
        paramLong1 = l3;
        break;
        localQMCalendarEvent.setStartTime(l2);
        localQMCalendarEvent.setEndTime(l4);
        break label209;
        if ((localRecurringException != null) && (!localRecurringException.isDelete())) {
          createReminderForNormailEvent(paramArrayList, QMCalendarManager.generateEventByException(localQMCalendarEvent, localRecurringException), localRecurringException.getId());
        }
      }
    } while (localRecurrenceInctor.increment(localCalendar));
    label285:
    label302:
    label335:
    return;
  }
  
  private void createReminders(long paramLong1, long paramLong2)
  {
    saveReminders(getReminders(getCalendarEvents(paramLong1, paramLong2), paramLong1, paramLong2));
  }
  
  private QMCalendarReminder getReminder(QMCalendarEvent paramQMCalendarEvent, Calendar paramCalendar)
  {
    QMCalendarReminder localQMCalendarReminder = new QMCalendarReminder();
    localQMCalendarReminder.setAccountId(paramQMCalendarEvent.getAccountId());
    localQMCalendarReminder.setEventId(paramQMCalendarEvent.getId());
    localQMCalendarReminder.setFolderId(paramQMCalendarEvent.getCalderFolderId());
    localQMCalendarReminder.setSubject(paramQMCalendarEvent.getSubject());
    localQMCalendarReminder.setEventStartTime(paramQMCalendarEvent.getStartTime());
    localQMCalendarReminder.setStartTime(paramCalendar.getTimeInMillis());
    if (paramQMCalendarEvent.isAllDay()) {
      if (paramQMCalendarEvent.getReminder() == 0)
      {
        paramCalendar.set(11, 9);
        paramCalendar.set(12, 0);
      }
    }
    for (;;)
    {
      localQMCalendarReminder.setRemindTime(paramCalendar.getTimeInMillis());
      localQMCalendarReminder.setId(QMCalendarReminder.generateId(localQMCalendarReminder));
      return localQMCalendarReminder;
      paramCalendar.set(11, 0);
      paramCalendar.set(12, 0);
      paramCalendar.add(12, paramQMCalendarEvent.getReminder() * -1);
      continue;
      paramCalendar.add(12, paramQMCalendarEvent.getReminder() * -1);
    }
  }
  
  private void restoreCacheEnd()
  {
    this.cacheEnd = this.mSqLiteHelper.getReminderCacheEnd(this.mSqLiteHelper.getReadableDatabase());
  }
  
  private void saveCacheEnd()
  {
    this.mSqLiteHelper.updateReminderCacheEnd(this.mSqLiteHelper.getWritableDatabase(), this.cacheEnd);
  }
  
  public ArrayList<QMCalendarReminder> createReminders(QMCalendarEvent paramQMCalendarEvent, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramQMCalendarEvent != null) && ((paramQMCalendarEvent.getMeetingStatus() == 5) || (paramQMCalendarEvent.getMeetingStatus() == 7) || (paramQMCalendarEvent.getMeetingStatus() == 13) || (paramQMCalendarEvent.getMeetingStatus() == 15) || (paramQMCalendarEvent.getReminder() == -1))) {}
    do
    {
      do
      {
        return localArrayList;
        if (!paramQMCalendarEvent.isRecurring()) {
          break;
        }
      } while (paramQMCalendarEvent.getStartTime() > paramLong2);
      createReminderForRecurrentEvent(localArrayList, paramQMCalendarEvent, paramLong1, paramLong2);
      return localArrayList;
    } while (((paramQMCalendarEvent.getStartTime() > paramLong1) || (paramQMCalendarEvent.getEndTime() < paramLong1)) && ((paramQMCalendarEvent.getStartTime() < paramLong1) || (paramQMCalendarEvent.getStartTime() > paramLong2)));
    createReminderForNormailEvent(localArrayList, paramQMCalendarEvent, null);
    return localArrayList;
  }
  
  public void createRemindersByEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(correctTimeToSecond(localCalendar.getTimeInMillis()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQMCalendarEvent);
    long l2 = localCalendar.getTimeInMillis();
    long l1;
    if (this.cacheEnd > 0L) {
      l1 = this.cacheEnd;
    }
    for (;;)
    {
      saveReminders(getReminders(localArrayList, l2, l1));
      return;
      localCalendar.add(2, 1);
      l1 = localCalendar.getTimeInMillis();
      this.cacheEnd = l1;
      saveCacheEnd();
    }
  }
  
  public void createRemindersByEvents(ArrayList<QMCalendarEvent> paramArrayList)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(correctTimeToSecond(localCalendar.getTimeInMillis()));
    long l2 = localCalendar.getTimeInMillis();
    long l1;
    if (this.cacheEnd > 0L) {
      l1 = this.cacheEnd;
    }
    for (;;)
    {
      saveReminders(getReminders(paramArrayList, l2, l1));
      return;
      localCalendar.add(2, 1);
      l1 = localCalendar.getTimeInMillis();
      this.cacheEnd = l1;
      saveCacheEnd();
    }
  }
  
  public void deleteEventRemindersAfterTime(long paramLong1, long paramLong2)
  {
    this.mSqLiteHelper.deleteEventReminderAfterTime(this.mSqLiteHelper.getWritableDatabase(), paramLong2, paramLong1);
  }
  
  public void deleteEventRemindersByTime(long paramLong1, long paramLong2)
  {
    this.mSqLiteHelper.deleteEventReminderByTime(this.mSqLiteHelper.getWritableDatabase(), paramLong2, paramLong1);
  }
  
  public void deleteRemindersByAccountId(int paramInt)
  {
    this.mSqLiteHelper.deleteRemindersByAccountId(this.mSqLiteHelper.getWritableDatabase(), paramInt);
  }
  
  public void deleteRemindersByEventId(long paramLong)
  {
    this.mSqLiteHelper.deleteRemindersByEventId(this.mSqLiteHelper.getWritableDatabase(), paramLong);
  }
  
  public ArrayList<QMCalendarEvent> getCalendarEvents(long paramLong1, long paramLong2)
  {
    return this.mSqLiteHelper.getCalendarEvents(this.mSqLiteHelper.getReadableDatabase(), paramLong1, paramLong2);
  }
  
  public ArrayList<QMCalendarReminder> getReminders(long paramLong1, long paramLong2)
  {
    return this.mSqLiteHelper.getReminders(this.mSqLiteHelper.getReadableDatabase(), paramLong1, paramLong2);
  }
  
  public ArrayList<QMCalendarReminder> getReminders(ArrayList<QMCalendarEvent> paramArrayList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ArrayList localArrayList2 = createReminders((QMCalendarEvent)paramArrayList.get(i), paramLong1, paramLong2);
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        localArrayList1.addAll(localArrayList2);
      }
      i += 1;
    }
    return localArrayList1;
  }
  
  public void handleTimeZoneChange()
  {
    this.mTimeZone = TimeZone.getDefault();
  }
  
  public void saveReminders(ArrayList<QMCalendarReminder> paramArrayList)
  {
    this.mSqLiteHelper.insertReminders(this.mSqLiteHelper.getWritableDatabase(), paramArrayList);
  }
  
  public void updateReminders()
  {
    QMLog.log(3, TAG, "prepare to update Reminders");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(correctTimeToSecond(localCalendar.getTimeInMillis()));
    if (this.cacheEnd - localCalendar.getTimeInMillis() < 1296000000L)
    {
      QMLog.log(3, TAG, "update Reminders!!!");
      long l1 = localCalendar.getTimeInMillis();
      localCalendar.add(2, 1);
      long l2 = localCalendar.getTimeInMillis();
      this.cacheEnd = l2;
      createReminders(l1, l2);
      saveCacheEnd();
      this.mSqLiteHelper.deleteRemindersBeforeTime(this.mSqLiteHelper.getWritableDatabase(), l1);
    }
  }
  
  public void updateRemindersInBackground()
  {
    Threads.runInBackground(new QMCalendarReminderManger.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarReminderManger
 * JD-Core Version:    0.7.0.1
 */