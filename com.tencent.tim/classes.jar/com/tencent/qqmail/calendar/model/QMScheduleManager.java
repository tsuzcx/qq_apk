package com.tencent.qqmail.calendar.model;

import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMHolidayCalendar;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.data.RecurrenceInctor;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.data.ScheduleCache;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.util.CalendarUtils;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.widget.model.CalendarWidgetItemInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class QMScheduleManager
{
  private static final String TAG = QMScheduleManager.class.getSimpleName();
  private static TLCalendar endStepTLCalendar = new TLCalendar();
  private static TLCalendar eventEndTLCalendar;
  private static TLCalendar eventStartTLCalendar = new TLCalendar();
  private static final long miliSecondsPerDay = 86400000L;
  private static final long miliSecondsPerYEAR = 31536000000L;
  private static TLCalendar startStepTLCalendar;
  private static TLCalendar tempTLCalendar = new TLCalendar();
  private long[] mCacheRange = new long[2];
  private long mCurrentStartMiliSeconds = 0L;
  private int mCurrentYear = 0;
  private ScheduleCache mScheduleCache;
  private QMCalendarSQLiteHelper mSqLiteHelper;
  private int mStartMonth = 1;
  private TimeZone mTimeZone = TimeZone.getDefault();
  
  static
  {
    eventEndTLCalendar = new TLCalendar();
    startStepTLCalendar = new TLCalendar();
  }
  
  public QMScheduleManager(QMCalendarSQLiteHelper paramQMCalendarSQLiteHelper)
  {
    this.mSqLiteHelper = paramQMCalendarSQLiteHelper;
    this.mScheduleCache = new ScheduleCache();
    this.mCacheRange = this.mSqLiteHelper.getScheduleCache(this.mSqLiteHelper.getReadableDatabase());
  }
  
  private long correctTimeToSecond(long paramLong)
  {
    return paramLong / 1000L * 1000L;
  }
  
  private ArrayList<QMSchedule> createAndSaveSchedules(long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = getSchedules(getCalendarEvents(paramLong1, paramLong2), paramLong1, paramLong2);
    saveSchedulesAndUpdateCache(localArrayList, paramLong1, paramLong2);
    return localArrayList;
  }
  
  private ArrayList<QMSchedule> createSchedule(QMCalendarEvent paramQMCalendarEvent, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQMCalendarEvent.isRecurring()) {
      if (paramQMCalendarEvent.getStartTime() <= paramLong2) {
        createScheduleForRecurrentEvent(localArrayList, paramQMCalendarEvent, paramLong1, paramLong2);
      }
    }
    while (((paramQMCalendarEvent.getStartTime() > paramLong1) || (paramQMCalendarEvent.getEndTime() < paramLong1)) && ((paramQMCalendarEvent.getStartTime() < paramLong1) || (paramQMCalendarEvent.getStartTime() > paramLong2))) {
      return localArrayList;
    }
    createScheduleForEvent(localArrayList, paramQMCalendarEvent, null, QMUIHelper.getCalendarColor(QMApplicationContext.sharedInstance(), QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId())));
    return localArrayList;
  }
  
  private void createScheduleForEvent(ArrayList<QMSchedule> paramArrayList, QMCalendarEvent paramQMCalendarEvent, String paramString, int paramInt)
  {
    Calendar localCalendar1 = eventStartTLCalendar.get(this.mTimeZone);
    Calendar localCalendar2 = eventEndTLCalendar.get(this.mTimeZone);
    Object localObject = startStepTLCalendar.get(this.mTimeZone);
    Calendar localCalendar3 = endStepTLCalendar.get(this.mTimeZone);
    long l1 = paramQMCalendarEvent.getStartTime();
    long l2 = paramQMCalendarEvent.getEndTime();
    localCalendar1.setTimeInMillis(l1);
    localCalendar2.setTimeInMillis(l2);
    if (paramQMCalendarEvent.isAllDay())
    {
      long l3 = localCalendar1.getTimeInMillis();
      localCalendar1.set(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5), 0, 0, 0);
      localCalendar2.add(14, (int)(localCalendar1.getTimeInMillis() - l3));
      if ((l1 != l2) && (localCalendar2.get(11) == 0) && (localCalendar2.get(12) == 0) && (localCalendar2.get(13) == 0)) {
        localCalendar2.add(13, -1);
      }
    }
    if (!QMCalendarUtil.isSameDate(localCalendar1, localCalendar2))
    {
      ((Calendar)localObject).setTimeInMillis(localCalendar1.getTimeInMillis());
      localCalendar3.set(1, localCalendar1.get(1));
      localCalendar3.set(2, localCalendar1.get(2));
      localCalendar3.set(5, localCalendar1.get(5));
      localCalendar3.set(11, 23);
      localCalendar3.set(12, 59);
      localCalendar3.set(13, 59);
      localCalendar3.setTimeInMillis(correctTimeToSecond(localCalendar3.getTimeInMillis()));
      QMSchedule localQMSchedule = new QMSchedule();
      paramArrayList.add(localQMSchedule);
      localQMSchedule.setEid(paramQMCalendarEvent.getId());
      localQMSchedule.setExceptionId(paramString);
      localQMSchedule.setStartTime(((Calendar)localObject).getTimeInMillis());
      localQMSchedule.setEndTime(localCalendar3.getTimeInMillis());
      localQMSchedule.setEventStartTime(localCalendar1.getTimeInMillis());
      localQMSchedule.setEventEndTime(localCalendar2.getTimeInMillis());
      localQMSchedule.setSubject(paramQMCalendarEvent.getSubject());
      localQMSchedule.setLocation(paramQMCalendarEvent.getLocation());
      localQMSchedule.setRelatedType(paramQMCalendarEvent.getRelateType());
      localQMSchedule.setCategory(paramQMCalendarEvent.getCategory());
      localQMSchedule.setColor(paramInt);
      localQMSchedule.setId(QMSchedule.generateId(localQMSchedule));
      i = CalendarUtils.computeDate((Calendar)localObject);
      localQMSchedule.setScheduleDate(i);
      updateScheduleCache(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId(), i);
      if ((localCalendar1.getTimeInMillis() == ((Calendar)localObject).getTimeInMillis()) || (localCalendar2.getTimeInMillis() == localCalendar3.getTimeInMillis())) {
        localQMSchedule.setIsAllDay(paramQMCalendarEvent.isAllDay());
      }
      for (;;)
      {
        ((Calendar)localObject).setTimeInMillis(localCalendar3.getTimeInMillis());
        ((Calendar)localObject).add(13, 1);
        localCalendar3.add(5, 1);
        if (localCalendar3.getTimeInMillis() > localCalendar2.getTimeInMillis()) {
          localCalendar3.setTimeInMillis(localCalendar2.getTimeInMillis());
        }
        if (QMCalendarUtil.compareMiliInMinute(((Calendar)localObject).getTimeInMillis(), localCalendar2.getTimeInMillis()) < 0) {
          break;
        }
        return;
        localQMSchedule.setIsAllDay(true);
      }
    }
    localObject = new QMSchedule();
    paramArrayList.add(localObject);
    ((QMSchedule)localObject).setEid(paramQMCalendarEvent.getId());
    ((QMSchedule)localObject).setExceptionId(paramString);
    ((QMSchedule)localObject).setStartTime(localCalendar1.getTimeInMillis());
    ((QMSchedule)localObject).setEndTime(localCalendar2.getTimeInMillis());
    ((QMSchedule)localObject).setEventStartTime(localCalendar1.getTimeInMillis());
    ((QMSchedule)localObject).setEventEndTime(localCalendar2.getTimeInMillis());
    ((QMSchedule)localObject).setCategory(paramQMCalendarEvent.getCategory());
    int i = CalendarUtils.computeDate(localCalendar1);
    ((QMSchedule)localObject).setScheduleDate(i);
    updateScheduleCache(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId(), i);
    ((QMSchedule)localObject).setIsAllDay(paramQMCalendarEvent.isAllDay());
    ((QMSchedule)localObject).setRelatedType(paramQMCalendarEvent.getRelateType());
    ((QMSchedule)localObject).setColor(paramInt);
    ((QMSchedule)localObject).setSubject(paramQMCalendarEvent.getSubject());
    ((QMSchedule)localObject).setLocation(paramQMCalendarEvent.getLocation());
    ((QMSchedule)localObject).setId(QMSchedule.generateId((QMSchedule)localObject));
  }
  
  private void createScheduleForRecurrentEvent(ArrayList<QMSchedule> paramArrayList, QMCalendarEvent paramQMCalendarEvent, long paramLong1, long paramLong2)
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
    int i;
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
      localQMCalendarEvent.setLocation(paramQMCalendarEvent.getLocation());
      localRecurrenceInctor = RecurrenceInctor.createInstance(paramQMCalendarEvent);
      if (paramQMCalendarEvent.isLunarCalendar()) {
        RecurrenceInctor.correctStartTimeForLunarCalendar(localCalendar, paramQMCalendarEvent);
      }
      i = QMUIHelper.getCalendarColor(QMApplicationContext.sharedInstance(), QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId()));
    }
    label176:
    label240:
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
          break label309;
        }
        localQMCalendarEvent.setStartTime(l2 + paramLong2);
        localQMCalendarEvent.setEndTime(paramLong2 + l4);
        localRecurringException = QMCalendarManager.getExceptionFromEvent(paramQMCalendarEvent, localCalendar);
        if (localRecurringException != null) {
          break label326;
        }
        localQMCalendarEvent.setIsAllDay(paramQMCalendarEvent.isAllDay());
        localQMCalendarEvent.setRecurrenceType(-1);
        localQMCalendarEvent.setSubject(paramQMCalendarEvent.getSubject());
        createScheduleForEvent(paramArrayList, localQMCalendarEvent, null, i);
      }
      for (;;)
      {
        if (!paramQMCalendarEvent.isLunarCalendar()) {
          break label361;
        }
        RecurrenceInctor.increaseForLunarCalendar(localCalendar, paramQMCalendarEvent);
        break label176;
        paramLong1 = l3;
        break;
        localQMCalendarEvent.setStartTime(l2);
        localQMCalendarEvent.setEndTime(l4);
        break label240;
        if ((localRecurringException != null) && (!localRecurringException.isDelete())) {
          createScheduleForEvent(paramArrayList, QMCalendarManager.generateEventByException(localQMCalendarEvent, localRecurringException), localRecurringException.getId(), i);
        }
      }
    } while (localRecurrenceInctor.increment(localCalendar));
    label309:
    label326:
    label361:
    return;
  }
  
  private void dropAllSchedule()
  {
    SQLiteDatabase localSQLiteDatabase = this.mSqLiteHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      this.mSqLiteHelper.deleteAllSchedule(localSQLiteDatabase);
      this.mCacheRange[0] = 0L;
      this.mCacheRange[1] = 0L;
      this.mSqLiteHelper.updateScheduleCache(localSQLiteDatabase, this.mCacheRange[0], this.mCacheRange[1]);
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      dropAllScheduleCache();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private void dropAllScheduleCache()
  {
    this.mScheduleCache.clear();
  }
  
  private void generateHolidayScheduleCacheByDates(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.mSqLiteHelper.getHolidayScheduleDates(paramLong1, paramLong2).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.mScheduleCache.updateHolidayCache(CalendarUtils.computeDate(((Long)localEntry.getKey()).longValue()), ((Integer)localEntry.getValue()).intValue());
    }
  }
  
  private void generateScheduleCacheByDates(ArrayList<Integer> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      updateScheduleCache(((Integer)paramArrayList.next()).intValue());
    }
  }
  
  private ArrayList<QMCalendarEvent> getCalendarEvents(long paramLong1, long paramLong2)
  {
    return this.mSqLiteHelper.getCalendarEvents(this.mSqLiteHelper.getReadableDatabase(), paramLong1, paramLong2);
  }
  
  private ArrayList<Integer> getScheduleDates(long paramLong1, long paramLong2)
  {
    return this.mSqLiteHelper.getScheduleDates(paramLong1, paramLong2);
  }
  
  private long[] getScheduleRangeTime(QMCalendarEvent paramQMCalendarEvent)
  {
    long l2 = this.mCacheRange[0];
    long l3 = this.mCacheRange[1];
    long l1;
    if (l2 != 0L)
    {
      l1 = l3;
      if (l3 != 0L) {}
    }
    else
    {
      l3 = this.mCurrentStartMiliSeconds;
      l4 = 31536000000L + l3;
      if ((this.mStartMonth >= 2) || (!QMCalendarManager.isLeapYear(this.mCurrentYear)))
      {
        l1 = l4;
        l2 = l3;
        if (!QMCalendarManager.isLeapYear(this.mCurrentYear + 1)) {}
      }
      else
      {
        l1 = l4 + 86400000L;
        l2 = l3;
      }
    }
    long l4 = paramQMCalendarEvent.getStartTime();
    l3 = l1;
    if (l4 >= l1)
    {
      paramQMCalendarEvent = new GregorianCalendar();
      paramQMCalendarEvent.setTimeInMillis(l4);
      paramQMCalendarEvent.set(10, 0);
      paramQMCalendarEvent.set(12, 0);
      paramQMCalendarEvent.set(13, 0);
      l2 = paramQMCalendarEvent.getTimeInMillis();
      paramQMCalendarEvent.add(2, 1);
      l3 = paramQMCalendarEvent.getTimeInMillis();
    }
    return new long[] { l2, l3 };
  }
  
  private ArrayList<QMSchedule> getSchedules(ArrayList<QMCalendarEvent> paramArrayList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ArrayList localArrayList2 = createSchedule((QMCalendarEvent)paramArrayList.get(i), paramLong1, paramLong2);
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        localArrayList1.addAll(localArrayList2);
      }
      i += 1;
    }
    return localArrayList1;
  }
  
  private void prepareScheduleCache(int paramInt1, int paramInt2)
  {
    int j = paramInt1;
    int i = 1;
    if (j <= paramInt2)
    {
      boolean bool = this.mScheduleCache.cacheYear(j);
      if ((i != 0) && (bool)) {}
      for (i = 1;; i = 0)
      {
        j += 1;
        break;
      }
    }
    long l1;
    long l2;
    if (i == 0)
    {
      l1 = new GregorianCalendar(paramInt1, this.mStartMonth, 1, 0, 0, 0).getTimeInMillis();
      l2 = new GregorianCalendar(paramInt2, this.mStartMonth, 1, 0, 0, 0).getTimeInMillis();
      if ((this.mCacheRange[0] == 0L) || (this.mCacheRange[1] == 0L) || (this.mCacheRange[0] > l1) || (this.mCacheRange[1] < l2))
      {
        if ((l1 <= this.mCacheRange[1]) && (l2 >= this.mCacheRange[0])) {
          break label193;
        }
        createAndSaveSchedules(l1, l2);
      }
    }
    for (;;)
    {
      generateScheduleCacheByDates(getScheduleDates(l1, l2));
      generateHolidayScheduleCacheByDates(l1, l2);
      return;
      label193:
      if ((l1 < this.mCacheRange[0]) && (l2 >= this.mCacheRange[0]) && (l2 <= this.mCacheRange[1]))
      {
        createAndSaveSchedules(l1, this.mCacheRange[0]);
      }
      else if ((l2 > this.mCacheRange[1]) && (l1 >= this.mCacheRange[0]) && (l1 <= this.mCacheRange[1]))
      {
        createAndSaveSchedules(this.mCacheRange[1], l2);
      }
      else if ((l1 < this.mCacheRange[0]) && (l2 > this.mCacheRange[1]))
      {
        createAndSaveSchedules(l1, this.mCacheRange[0]);
        createAndSaveSchedules(this.mCacheRange[1], l2);
      }
    }
  }
  
  private void saveCacheRange()
  {
    this.mSqLiteHelper.updateScheduleCache(this.mSqLiteHelper.getWritableDatabase(), this.mCacheRange[0], this.mCacheRange[1]);
  }
  
  private void saveSchedules(ArrayList<QMSchedule> paramArrayList)
  {
    SQLiteDatabase localSQLiteDatabase;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localSQLiteDatabase = this.mSqLiteHelper.getWritableDatabase();
      localSQLiteDatabase.beginTransactionNonExclusive();
      i = 0;
    }
    try
    {
      while (i < paramArrayList.size())
      {
        this.mSqLiteHelper.insertSchedule(localSQLiteDatabase, (QMSchedule)paramArrayList.get(i));
        i += 1;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramArrayList)
    {
      QMLog.log(6, TAG, "saveSchedules exception: " + Log.getStackTraceString(paramArrayList));
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private void saveSchedulesAndUpdateCache(ArrayList<QMSchedule> paramArrayList, long paramLong1, long paramLong2)
  {
    if ((this.mCacheRange[0] == 0L) || (this.mCacheRange[0] > paramLong1)) {
      this.mCacheRange[0] = paramLong1;
    }
    if ((this.mCacheRange[1] == 0L) || (this.mCacheRange[1] < paramLong2)) {
      this.mCacheRange[1] = paramLong2;
    }
    saveCacheRange();
    saveSchedules(paramArrayList);
  }
  
  private void updateScheduleCache(int paramInt)
  {
    this.mScheduleCache.updateCache(paramInt);
  }
  
  private void updateScheduleCache(int paramInt1, int paramInt2, int paramInt3)
  {
    QMCalendarFolder localQMCalendarFolder = QMCalendarManager.getInstance().getCalendarFolder(paramInt1, paramInt2);
    if ((localQMCalendarFolder != null) && (localQMCalendarFolder.isShow())) {
      updateScheduleCache(paramInt3);
    }
  }
  
  public ArrayList<QMSchedule> createAndSaveSchedule(QMCalendarEvent paramQMCalendarEvent)
  {
    long l2 = this.mCacheRange[0];
    long l3 = this.mCacheRange[1];
    long l1;
    if (l2 != 0L)
    {
      l1 = l3;
      if (l3 != 0L) {}
    }
    else
    {
      l3 = this.mCurrentStartMiliSeconds;
      long l4 = l3 + 31536000000L;
      if ((this.mStartMonth >= 2) || (!QMCalendarManager.isLeapYear(this.mCurrentYear)))
      {
        l2 = l3;
        l1 = l4;
        if (!QMCalendarManager.isLeapYear(this.mCurrentYear + 1)) {}
      }
      else
      {
        l1 = l4 + 86400000L;
        l2 = l3;
      }
    }
    paramQMCalendarEvent = createSchedule(paramQMCalendarEvent, l2, l1);
    if ((paramQMCalendarEvent != null) && (paramQMCalendarEvent.size() > 0)) {
      saveSchedules(paramQMCalendarEvent);
    }
    return paramQMCalendarEvent;
  }
  
  public void createScheduleWithException(QMCalendarEvent paramQMCalendarEvent, RecurringException paramRecurringException)
  {
    long l1 = this.mCacheRange[0];
    long l2 = this.mCacheRange[1];
    if ((l1 == 0L) || (l2 == 0L))
    {
      l1 = this.mCurrentStartMiliSeconds;
      if (((this.mStartMonth < 2) && (QMCalendarManager.isLeapYear(this.mCurrentYear))) || (!QMCalendarManager.isLeapYear(this.mCurrentYear + 1))) {}
    }
    paramQMCalendarEvent = QMCalendarManager.generateEventByException(paramQMCalendarEvent, paramRecurringException);
    ArrayList localArrayList = new ArrayList();
    createScheduleForEvent(localArrayList, paramQMCalendarEvent, paramRecurringException.getId(), QMUIHelper.getCalendarColor(QMApplicationContext.sharedInstance(), QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId())));
    if (localArrayList.size() > 0) {
      saveSchedules(localArrayList);
    }
  }
  
  public void deleteScheduleAfterTime(long paramLong1, long paramLong2)
  {
    this.mSqLiteHelper.deleteScheduleAfterTime(this.mSqLiteHelper.getWritableDatabase(), paramLong1, paramLong2);
  }
  
  public void deleteScheduleByEventId(long paramLong)
  {
    this.mSqLiteHelper.deleteSchedulesByEventId(this.mSqLiteHelper.getWritableDatabase(), paramLong);
  }
  
  public void deleteScheduleByStartTime(long paramLong1, long paramLong2)
  {
    this.mSqLiteHelper.deleteScheduleByStartTime(this.mSqLiteHelper.getWritableDatabase(), paramLong1, paramLong2);
  }
  
  public void deleteScheduleForTime(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mSqLiteHelper.deleteScheduleForTime(this.mSqLiteHelper.getWritableDatabase(), paramLong1, paramLong2, paramLong3);
  }
  
  public void forceCreateSchedule(QMCalendarEvent paramQMCalendarEvent)
  {
    long[] arrayOfLong = getScheduleRangeTime(paramQMCalendarEvent);
    paramQMCalendarEvent = createSchedule(paramQMCalendarEvent, arrayOfLong[0], arrayOfLong[1]);
    if ((paramQMCalendarEvent != null) && (paramQMCalendarEvent.size() > 0)) {
      saveSchedules(paramQMCalendarEvent);
    }
  }
  
  public void forceCreateSchedule(ArrayList<QMCalendarEvent> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QMCalendarEvent localQMCalendarEvent = (QMCalendarEvent)paramArrayList.next();
      long[] arrayOfLong = getScheduleRangeTime(localQMCalendarEvent);
      localArrayList.addAll(createSchedule(localQMCalendarEvent, arrayOfLong[0], arrayOfLong[1]));
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      saveSchedules(localArrayList);
    }
  }
  
  public QMHolidayCalendar getHolidayCalendar(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    int i = this.mScheduleCache.getHolidayType(paramInt1, paramInt2, paramInt3);
    if (i == -1) {
      return null;
    }
    if (i == 1) {}
    for (;;)
    {
      return new QMHolidayCalendar(paramInt1, paramInt2, paramInt3, bool);
      bool = false;
    }
  }
  
  public Cursor getScheduleListCursor(Calendar paramCalendar)
  {
    return getScheduleListCursorForTime(paramCalendar, 1);
  }
  
  public Cursor getScheduleListCursorForTime(Calendar paramCalendar, int paramInt)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    paramCalendar = new GregorianCalendar();
    paramCalendar.set(i, j, k - 1, 23, 59, 59);
    long l1 = paramCalendar.getTimeInMillis();
    paramCalendar.set(i, j, k + paramInt - 1, 23, 59, 59);
    long l2 = paramCalendar.getTimeInMillis();
    return this.mSqLiteHelper.getScheduleListCursor(this.mSqLiteHelper.getReadableDatabase(), l1, l2);
  }
  
  public ArrayList<CalendarWidgetItemInfo> getScheduleListInThisYear(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    paramCalendar = new GregorianCalendar();
    paramCalendar.set(i, j, k - 1, 23, 59, 59);
    long l1 = paramCalendar.getTimeInMillis();
    paramCalendar.set(i + 1, 0, 1, 0, 0, 0);
    long l2 = paramCalendar.getTimeInMillis();
    return this.mSqLiteHelper.getScheduleListForTime(this.mSqLiteHelper.getReadableDatabase(), l1, l2);
  }
  
  public void handleTimeZoneChange()
  {
    this.mTimeZone = TimeZone.getDefault();
    dropAllSchedule();
    QMCalendarManager.getInstance().triggerUpdateSchedule(null, 0L);
    prepareScheduleCache(Calendar.getInstance());
    QMCalendarManager.getInstance().triggerUpdateSchedule(null, 0L);
  }
  
  public boolean hasSchedule(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mScheduleCache.hasSchedule(paramInt1, paramInt2, paramInt3);
  }
  
  public void prepareScheduleCache(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    if (!this.mScheduleCache.isInited())
    {
      this.mCurrentYear = i;
      this.mCurrentStartMiliSeconds = correctTimeToSecond(new GregorianCalendar(this.mCurrentYear - 1, this.mStartMonth, 1, 0, 0, 0).getTimeInMillis());
      prepareScheduleCache(this.mCurrentYear - 1, this.mCurrentYear + 2);
    }
    do
    {
      return;
      if (j == this.mStartMonth)
      {
        this.mCurrentYear = i;
        return;
      }
      if ((i > this.mCurrentYear) || ((i == this.mCurrentYear) && (j > this.mStartMonth)))
      {
        j = this.mCurrentYear + 1;
        if (i == this.mCurrentYear) {
          i = j + 1;
        }
        for (;;)
        {
          prepareScheduleCache(j, i);
          return;
          i += 1;
        }
      }
    } while ((i >= this.mCurrentYear) && ((i != this.mCurrentYear) || (j >= this.mStartMonth)));
    j = this.mCurrentYear;
    if (i == this.mCurrentYear) {
      i = j - 1;
    }
    for (;;)
    {
      prepareScheduleCache(i, j);
      return;
      i -= 1;
    }
  }
  
  public void resetScheduleCache()
  {
    this.mScheduleCache.clear();
    if ((this.mCacheRange[0] > 0L) && (this.mCacheRange[1] > 0L))
    {
      generateScheduleCacheByDates(getScheduleDates(this.mCacheRange[0], this.mCacheRange[1]));
      generateHolidayScheduleCacheByDates(this.mCacheRange[0], this.mCacheRange[1]);
      return;
    }
    prepareScheduleCache(Calendar.getInstance());
  }
  
  public void setStartMonth(int paramInt)
  {
    this.mStartMonth = ((paramInt - 6 + 12) % 12);
  }
  
  public static class TLCalendar
    extends ThreadLocal<Calendar>
  {
    public Calendar get(TimeZone paramTimeZone)
    {
      Calendar localCalendar = (Calendar)super.get();
      if (!localCalendar.getTimeZone().hasSameRules(paramTimeZone)) {
        localCalendar.setTimeZone(paramTimeZone);
      }
      return localCalendar;
    }
    
    protected Calendar initialValue()
    {
      return new GregorianCalendar();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMScheduleManager
 * JD-Core Version:    0.7.0.1
 */