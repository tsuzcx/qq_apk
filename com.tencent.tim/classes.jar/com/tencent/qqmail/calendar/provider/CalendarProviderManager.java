package com.tencent.qqmail.calendar.provider;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.calendar.data.Attendee;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.model.CPAttendee;
import com.tencent.qqmail.calendar.provider.model.CPCalendar;
import com.tencent.qqmail.calendar.provider.model.CPEvent;
import com.tencent.qqmail.calendar.provider.model.CPReminder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class CalendarProviderManager
{
  private static final String TAG = "CalendarProviderManager";
  private static CalendarProviderManager mInstance;
  private QMCalendarManager mCalendarManager = QMCalendarManager.getInstance();
  private CalendarProviderDataManager mDataManager = CalendarProviderDataManager.sharedInstance();
  
  private void addAttendee(QMCalendarEvent paramQMCalendarEvent)
  {
    CPEvent localCPEvent = this.mDataManager.queryEventById(paramQMCalendarEvent.getId());
    if (localCPEvent != null)
    {
      ArrayList localArrayList = this.mDataManager.queryAttendeeByEventId(localCPEvent.getId());
      if (localArrayList != null)
      {
        this.mDataManager.deleteAttendee(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
        QMLog.log(4, "CalendarProviderManager", "sync attendee delete old event id :" + localCPEvent.getId() + " size:" + localArrayList.size());
      }
      paramQMCalendarEvent = getSyncAttendeeFromCalendarAttendee(localCPEvent.getId(), paramQMCalendarEvent.getAttendees());
      this.mDataManager.insertAttendee(paramQMCalendarEvent, localCPEvent.getAccountName(), localCPEvent.getAccountType());
      QMLog.log(4, "CalendarProviderManager", "sync attendee event id :" + localCPEvent.getId() + " size:" + paramQMCalendarEvent.size());
      return;
    }
    QMLog.log(4, "CalendarProviderManager", "sync attendee event none");
  }
  
  private void addAttendee(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addAttendee((QMCalendarEvent)paramList.next());
      }
    }
  }
  
  private void addCalendar(QMCalendarFolder paramQMCalendarFolder)
  {
    CPCalendar localCPCalendar = getSyncCalendarFromCalendarFolder(paramQMCalendarFolder);
    paramQMCalendarFolder = this.mDataManager.queryCalendarById(paramQMCalendarFolder.getId());
    if (paramQMCalendarFolder != null)
    {
      localCPCalendar.setId(paramQMCalendarFolder.getId());
      this.mDataManager.updateCalendar(localCPCalendar);
      QMLog.log(4, "CalendarProviderManager", "add calendar id:" + paramQMCalendarFolder.getId());
      return;
    }
    this.mDataManager.insertCalendar(localCPCalendar);
    QMLog.log(4, "CalendarProviderManager", "add calendar id:" + localCPCalendar.getId());
  }
  
  private void addCalendar(List<QMCalendarFolder> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (QMCalendarFolder)localIterator.next();
        CPCalendar localCPCalendar = getSyncCalendarFromCalendarFolder((QMCalendarFolder)localObject);
        localObject = this.mDataManager.queryCalendarById(((QMCalendarFolder)localObject).getId());
        if (localObject != null)
        {
          localCPCalendar.setId(((CPCalendar)localObject).getId());
          localArrayList2.add(localCPCalendar);
          QMLog.log(4, "CalendarProviderManager", "add calendar id:" + ((CPCalendar)localObject).getId());
        }
        else
        {
          localArrayList1.add(localCPCalendar);
          QMLog.log(4, "CalendarProviderManager", "add calendar id:" + localCPCalendar.getId());
        }
      }
      if (!paramList.isEmpty()) {
        this.mDataManager.insertCalendar(localArrayList1);
      }
      if (!localArrayList2.isEmpty()) {
        this.mDataManager.updateCalendar(localArrayList2);
      }
    }
  }
  
  private void addEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    CPEvent localCPEvent1 = getSyncEventFromCalendarEvent(paramQMCalendarEvent);
    CPEvent localCPEvent2 = this.mDataManager.queryEventById(paramQMCalendarEvent.getId());
    if (localCPEvent2 != null)
    {
      localCPEvent1.setId(localCPEvent2.getId());
      this.mDataManager.updateEvent(localCPEvent1);
      QMLog.log(4, "CalendarProviderManager", "add event id:" + localCPEvent2.getId());
    }
    for (;;)
    {
      addAttendee(paramQMCalendarEvent);
      addReminder(paramQMCalendarEvent);
      addException(paramQMCalendarEvent);
      addExceptionAttendee(paramQMCalendarEvent);
      addExceptionReminder(paramQMCalendarEvent);
      return;
      this.mDataManager.insertEvent(localCPEvent1);
      QMLog.log(4, "CalendarProviderManager", "add event id:" + localCPEvent1.getId());
    }
  }
  
  private void addEvent(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (QMCalendarEvent)localIterator.next();
        CPEvent localCPEvent = getSyncEventFromCalendarEvent((QMCalendarEvent)localObject);
        localObject = this.mDataManager.queryEventById(((QMCalendarEvent)localObject).getId());
        if (localObject != null)
        {
          localCPEvent.setId(((CPEvent)localObject).getId());
          localArrayList2.add(localCPEvent);
          QMLog.log(4, "CalendarProviderManager", "add event id:" + ((CPEvent)localObject).getId());
        }
        else
        {
          localArrayList1.add(localCPEvent);
          QMLog.log(4, "CalendarProviderManager", "add event id:" + localCPEvent.getId());
        }
      }
      if (!localArrayList1.isEmpty()) {
        this.mDataManager.insertEvent(localArrayList1);
      }
      if (!localArrayList2.isEmpty()) {
        this.mDataManager.updateEvent(localArrayList2);
      }
      addAttendee(paramList);
      addReminder(paramList);
      addException(paramList);
      addExceptionAttendee(paramList);
      addExceptionReminder(paramList);
    }
  }
  
  private void addException(QMCalendarEvent paramQMCalendarEvent)
  {
    Object localObject1 = this.mDataManager.queryEventById(paramQMCalendarEvent.getId());
    if (localObject1 != null)
    {
      localObject1 = this.mDataManager.queryExceptionEventByOriginalId(((CPEvent)localObject1).getId());
      this.mDataManager.deleteEvent((ArrayList)localObject1);
      localObject1 = new ArrayList();
      Object localObject2 = paramQMCalendarEvent.getExceptions();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (RecurringException)((Iterator)localObject2).next();
          if (!((RecurringException)localObject3).isDelete())
          {
            localObject3 = getSyncEventFromCalendarEventException(paramQMCalendarEvent, (RecurringException)localObject3);
            if (localObject3 != null)
            {
              ((ArrayList)localObject1).add(localObject3);
              QMLog.log(4, "CalendarProviderManager", "sync event exception id:" + paramQMCalendarEvent.getId());
            }
          }
        }
      }
      if (!((ArrayList)localObject1).isEmpty()) {
        this.mDataManager.insertException((ArrayList)localObject1);
      }
      return;
    }
    QMLog.log(4, "CalendarProviderManager", "sync exception event none");
  }
  
  private void addException(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addException((QMCalendarEvent)paramList.next());
      }
    }
  }
  
  private void addExceptionAttendee(QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent != null)
    {
      Iterator localIterator = this.mDataManager.queryExceptionEventByOriginalId(paramQMCalendarEvent.getId()).iterator();
      while (localIterator.hasNext())
      {
        CPEvent localCPEvent = (CPEvent)localIterator.next();
        ArrayList localArrayList = this.mDataManager.queryAttendeeByEventId(localCPEvent.getId());
        if (localArrayList != null)
        {
          this.mDataManager.deleteAttendee(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
          QMLog.log(4, "CalendarProviderManager", "sync exception attendee delete old event id :" + localCPEvent.getId() + " size:" + localArrayList.size());
        }
        localArrayList = getSyncAttendeeFromCalendarAttendee(localCPEvent.getId(), paramQMCalendarEvent.getAttendees());
        this.mDataManager.insertAttendee(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
        QMLog.log(4, "CalendarProviderManager", "sync exception attendee event id :" + localCPEvent.getId() + " size:" + localArrayList.size());
      }
    }
  }
  
  private void addExceptionAttendee(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addExceptionAttendee((QMCalendarEvent)paramList.next());
      }
    }
  }
  
  private void addExceptionReminder(QMCalendarEvent paramQMCalendarEvent)
  {
    if ((paramQMCalendarEvent != null) && (paramQMCalendarEvent.getExceptions() != null))
    {
      Iterator localIterator = this.mDataManager.queryExceptionEventByOriginalId(paramQMCalendarEvent.getId()).iterator();
      while (localIterator.hasNext())
      {
        CPEvent localCPEvent = (CPEvent)localIterator.next();
        if (localCPEvent != null)
        {
          Object localObject1 = this.mDataManager.queryReminderByEventId(localCPEvent.getId());
          if (localObject1 != null)
          {
            this.mDataManager.deleteReminder((ArrayList)localObject1, localCPEvent.getAccountName(), localCPEvent.getAccountType());
            QMLog.log(4, "CalendarProviderManager", "sync exception reminder delete old event id : " + localCPEvent.getId() + " size:");
          }
          localObject1 = paramQMCalendarEvent.getExceptions().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (RecurringException)((Iterator)localObject1).next();
            if (((RecurringException)localObject2).getId().equals(String.valueOf(localCPEvent.getId())))
            {
              localObject2 = getSyncReminderByCalendarReminder(localCPEvent.getId(), ((RecurringException)localObject2).getReminder());
              if (localObject2 != null)
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localObject2);
                this.mDataManager.insertReminder(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
                QMLog.log(4, "CalendarProviderManager", "sync exception reminder event id :" + localCPEvent.getId());
              }
            }
          }
        }
      }
    }
  }
  
  private void addExceptionReminder(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addExceptionReminder((QMCalendarEvent)paramList.next());
      }
    }
  }
  
  private void addReminder(QMCalendarEvent paramQMCalendarEvent)
  {
    CPEvent localCPEvent = this.mDataManager.queryEventById(paramQMCalendarEvent.getId());
    if (localCPEvent != null)
    {
      ArrayList localArrayList = this.mDataManager.queryReminderByEventId(localCPEvent.getId());
      if (localArrayList != null)
      {
        this.mDataManager.deleteReminder(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
        QMLog.log(4, "CalendarProviderManager", "sync reminder delete old event id : " + localCPEvent.getId() + " size:");
      }
      paramQMCalendarEvent = getSyncReminderByCalendarReminder(localCPEvent.getId(), paramQMCalendarEvent.getReminder());
      if (paramQMCalendarEvent != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramQMCalendarEvent);
        this.mDataManager.insertReminder(localArrayList, localCPEvent.getAccountName(), localCPEvent.getAccountType());
        QMLog.log(4, "CalendarProviderManager", "sync reminder event id :" + localCPEvent.getId());
      }
      return;
    }
    QMLog.log(4, "CalendarProviderManager", "sync reminder event none");
  }
  
  private void addReminder(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addReminder((QMCalendarEvent)paramList.next());
      }
    }
  }
  
  private void deleteCalendar(long paramLong)
  {
    CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(paramLong);
    if (localCPCalendar != null)
    {
      this.mDataManager.deleteCalendar(localCPCalendar);
      QMLog.log(4, "CalendarProviderManager", "delete calendar id:" + localCPCalendar.getId());
      return;
    }
    QMLog.log(4, "CalendarProviderManager", "delete calendar none id:" + paramLong);
  }
  
  private void deleteCalendar(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(localLong.longValue());
        if (localCPCalendar != null)
        {
          localArrayList.add(localCPCalendar);
          QMLog.log(4, "CalendarProviderManager", "delete calendar id:" + localCPCalendar.getId());
        }
        else
        {
          QMLog.log(4, "CalendarProviderManager", "delete calendar none id:" + localLong);
        }
      }
      if (!localArrayList.isEmpty()) {
        this.mDataManager.deleteCalendar(localArrayList);
      }
    }
  }
  
  private void deleteEvent(long paramLong)
  {
    Object localObject = this.mDataManager.queryEventById(paramLong);
    if (localObject != null)
    {
      int i = this.mDataManager.deleteEvent((CPEvent)localObject);
      QMLog.log(4, "CalendarProviderManager", "delete event id:" + ((CPEvent)localObject).getId() + " deleteCnt " + i);
      localObject = this.mDataManager.queryExceptionEventByOriginalId(paramLong).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CPEvent localCPEvent = (CPEvent)((Iterator)localObject).next();
        this.mDataManager.deleteEvent(localCPEvent);
        QMLog.log(4, "CalendarProviderManager", "delete event id:" + localCPEvent.getId());
      }
    }
    QMLog.log(4, "CalendarProviderManager", "delete event none id:" + paramLong);
  }
  
  private void deleteEvent(ArrayList<Long> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l = ((Long)paramArrayList.next()).longValue();
        Object localObject = this.mDataManager.queryEventById(l);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          QMLog.log(4, "CalendarProviderManager", "delete event id:" + ((CPEvent)localObject).getId());
          localObject = this.mDataManager.queryExceptionEventByOriginalId(l).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CPEvent localCPEvent = (CPEvent)((Iterator)localObject).next();
            localArrayList.add(localCPEvent);
            QMLog.log(4, "CalendarProviderManager", "delete event id:" + localCPEvent.getId());
          }
        }
        else
        {
          QMLog.log(4, "CalendarProviderManager", "delete event none id:" + l);
        }
      }
      if (!localArrayList.isEmpty()) {
        this.mDataManager.deleteEvent(localArrayList);
      }
    }
  }
  
  private ArrayList<CPAttendee> getSyncAttendeeFromCalendarAttendee(long paramLong, ArrayList<Attendee> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Attendee localAttendee = (Attendee)paramArrayList.next();
        CPAttendee localCPAttendee = new CPAttendee();
        localCPAttendee.setEventId(paramLong);
        localCPAttendee.setAttendeeEmail(localAttendee.getEmail());
        localCPAttendee.setAttendeeStatus(transferStatusFromAttendee(localAttendee.getStatus()));
        localCPAttendee.setAttendeeType(transferTypeFromAttendee(localAttendee.getType()));
        localArrayList.add(localCPAttendee);
      }
    }
    return localArrayList;
  }
  
  private CPCalendar getSyncCalendarFromCalendarFolder(QMCalendarFolder paramQMCalendarFolder)
  {
    AccountManager.shareInstance().getAccountList().getAccountById(paramQMCalendarFolder.getAccountId());
    CPCalendar localCPCalendar = new CPCalendar();
    localCPCalendar.setId(paramQMCalendarFolder.getId());
    localCPCalendar.setName(paramQMCalendarFolder.getName());
    localCPCalendar.setCalendarDisplayName(paramQMCalendarFolder.getName());
    if (paramQMCalendarFolder.isShow()) {}
    for (int i = 1;; i = 0)
    {
      localCPCalendar.setVisible(i);
      localCPCalendar.setOwnerAccount(paramQMCalendarFolder.getOwnerAccount());
      localCPCalendar.setAccountName(paramQMCalendarFolder.getAccountName());
      localCPCalendar.setAccountType(paramQMCalendarFolder.getAccountType());
      return localCPCalendar;
    }
  }
  
  private CPEvent getSyncEventFromCalendarEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    CPEvent localCPEvent = new CPEvent();
    localCPEvent.setId(paramQMCalendarEvent.getId());
    localCPEvent.setCalendarId(paramQMCalendarEvent.getCalderFolderId());
    localCPEvent.setTitle(paramQMCalendarEvent.getSubject());
    localCPEvent.setDescription(paramQMCalendarEvent.getBody());
    localCPEvent.setEventLocation(paramQMCalendarEvent.getLocation());
    localCPEvent.setStatus(transferStatusFromMeetingStatus(paramQMCalendarEvent.getMeetingStatus()));
    localCPEvent.setDtStart(paramQMCalendarEvent.getStartTime());
    localCPEvent.setDtEnd(paramQMCalendarEvent.getEndTime());
    if (paramQMCalendarEvent.isAllDay())
    {
      localCPEvent.setDtStart(paramQMCalendarEvent.getStartTime() + CalendarProviderUtil.getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
      localCPEvent.setDtEnd(paramQMCalendarEvent.getEndTime() + CalendarProviderUtil.getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
    }
    if (paramQMCalendarEvent.isRecurring())
    {
      localCPEvent.setDtEnd(0L);
      localCPEvent.setDuration(CalendarProviderUtil.parseQMEventToDuration(paramQMCalendarEvent));
    }
    localCPEvent.setEventTimezone(TimeZone.getDefault().getID());
    localCPEvent.setEventEndTimezone(TimeZone.getDefault().getID());
    if (paramQMCalendarEvent.isAllDay()) {}
    for (int i = 1;; i = 0)
    {
      localCPEvent.setAllDay(i);
      localCPEvent.setRrule(CalendarProviderUtil.parseQMEventToRRule(paramQMCalendarEvent));
      localCPEvent.setRdate("");
      localCPEvent.setExrule("");
      localCPEvent.setExdate(CalendarProviderUtil.parseQMEventToExdate(paramQMCalendarEvent));
      localCPEvent.setOriginalId(0L);
      localCPEvent.setOriginalSyncId(null);
      localCPEvent.setOriginalInstanceTime(null);
      localCPEvent.setOriginalAllDay(0);
      localCPEvent.setHasAttendeeData(1);
      localCPEvent.setOrganizer(paramQMCalendarEvent.getOrganizerName());
      localCPEvent.setAccountName(paramQMCalendarEvent.getAccountName());
      localCPEvent.setAccountType(paramQMCalendarEvent.getAccountType());
      return localCPEvent;
    }
  }
  
  private CPEvent getSyncEventFromCalendarEventException(QMCalendarEvent paramQMCalendarEvent, RecurringException paramRecurringException)
  {
    int j = 1;
    CPEvent localCPEvent = getSyncEventFromCalendarEvent(paramQMCalendarEvent);
    localCPEvent.setId(Long.valueOf(paramRecurringException.getId().substring(0, paramRecurringException.getId().indexOf("_"))).longValue());
    localCPEvent.setTitle(paramRecurringException.getSubject());
    localCPEvent.setOriginalId(paramRecurringException.getEventId());
    localCPEvent.setDescription(paramRecurringException.getBody());
    localCPEvent.setEventLocation(paramRecurringException.getLocation());
    localCPEvent.setDtStart(paramRecurringException.getStartTime());
    localCPEvent.setDtEnd(paramRecurringException.getEndTime());
    localCPEvent.setOriginalInstanceTime(String.valueOf(paramRecurringException.getExceptionStartTime()));
    if (paramRecurringException.isDelete())
    {
      i = 2;
      localCPEvent.setStatus(i);
      if (!paramRecurringException.isAllDay()) {
        break label232;
      }
    }
    label232:
    for (int i = j;; i = 0)
    {
      localCPEvent.setAllDay(i);
      if (paramRecurringException.isAllDay())
      {
        localCPEvent.setDtStart(paramRecurringException.getStartTime() + CalendarProviderUtil.getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
        localCPEvent.setDtEnd(paramRecurringException.getEndTime() + CalendarProviderUtil.getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
      }
      if (paramQMCalendarEvent.isAllDay()) {
        localCPEvent.setOriginalInstanceTime(String.valueOf(paramRecurringException.getExceptionStartTime() + CalendarProviderUtil.getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L));
      }
      localCPEvent.setRrule("");
      return localCPEvent;
      i = 1;
      break;
    }
  }
  
  private CPReminder getSyncReminderByCalendarReminder(long paramLong, int paramInt)
  {
    CPReminder localCPReminder = null;
    if (paramInt != -1)
    {
      localCPReminder = new CPReminder();
      localCPReminder.setEventId(paramLong);
      localCPReminder.setMinutes(paramInt);
      localCPReminder.setMethod(1);
    }
    return localCPReminder;
  }
  
  public static CalendarProviderManager sharedInstance()
  {
    if (mInstance == null) {
      mInstance = new CalendarProviderManager();
    }
    return mInstance;
  }
  
  private int transferStatusFromAttendee(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    case 3: 
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 3;
    }
    return 4;
  }
  
  private int transferStatusFromMeetingStatus(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    default: 
      return 0;
    case 5: 
    case 7: 
    case 13: 
    case 15: 
      return 2;
    }
    return 1;
  }
  
  private int transferTypeFromAttendee(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  private void updateCalendar(QMCalendarFolder paramQMCalendarFolder)
  {
    paramQMCalendarFolder = getSyncCalendarFromCalendarFolder(paramQMCalendarFolder);
    this.mDataManager.updateCalendar(paramQMCalendarFolder);
    QMLog.log(4, "CalendarProviderManager", "update calendar id:" + paramQMCalendarFolder.getId());
  }
  
  private void updateCalendar(List<QMCalendarFolder> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (QMCalendarFolder)paramList.next();
        CPCalendar localCPCalendar = getSyncCalendarFromCalendarFolder((QMCalendarFolder)localObject);
        localObject = this.mDataManager.queryCalendarById(((QMCalendarFolder)localObject).getId());
        if (localObject != null)
        {
          localCPCalendar.setId(((CPCalendar)localObject).getId());
          localArrayList.add(localCPCalendar);
          QMLog.log(4, "CalendarProviderManager", "update calendar id:" + ((CPCalendar)localObject).getId());
        }
        else
        {
          QMLog.log(4, "CalendarProviderManager", "update calendar none id" + localCPCalendar.getId());
        }
      }
      if (!localArrayList.isEmpty()) {
        this.mDataManager.updateCalendar(localArrayList);
      }
    }
  }
  
  private void updateEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    CPEvent localCPEvent1 = getSyncEventFromCalendarEvent(paramQMCalendarEvent);
    CPEvent localCPEvent2 = this.mDataManager.queryEventById(paramQMCalendarEvent.getId());
    if (localCPEvent2 != null)
    {
      localCPEvent1.setId(localCPEvent2.getId());
      this.mDataManager.updateEvent(localCPEvent1);
      QMLog.log(4, "CalendarProviderManager", "update event id:" + localCPEvent2.getId());
    }
    for (;;)
    {
      addAttendee(paramQMCalendarEvent);
      addReminder(paramQMCalendarEvent);
      addException(paramQMCalendarEvent);
      addExceptionAttendee(paramQMCalendarEvent);
      addExceptionReminder(paramQMCalendarEvent);
      return;
      QMLog.log(4, "CalendarProviderManager", "update event none id:" + localCPEvent1.getId());
    }
  }
  
  private void updateEvent(List<QMCalendarEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (QMCalendarEvent)localIterator.next();
        CPEvent localCPEvent = getSyncEventFromCalendarEvent((QMCalendarEvent)localObject);
        localObject = this.mDataManager.queryEventById(((QMCalendarEvent)localObject).getId());
        if (localObject != null)
        {
          localCPEvent.setId(((CPEvent)localObject).getId());
          localArrayList.add(localCPEvent);
          QMLog.log(4, "CalendarProviderManager", "update event id:" + ((CPEvent)localObject).getId());
        }
        else
        {
          QMLog.log(4, "CalendarProviderManager", "update event none id:" + localCPEvent.getId());
        }
      }
      if (!localArrayList.isEmpty()) {
        this.mDataManager.updateEvent(localArrayList);
      }
      addAttendee(paramList);
      addReminder(paramList);
      addException(paramList);
      addExceptionAttendee(paramList);
      addExceptionReminder(paramList);
    }
  }
  
  private void updateException(QMCalendarEvent paramQMCalendarEvent, RecurringException paramRecurringException)
  {
    this.mDataManager.updateException(getSyncEventFromCalendarEventException(paramQMCalendarEvent, paramRecurringException));
  }
  
  private void updateException(QMCalendarEvent paramQMCalendarEvent, List<RecurringException> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        updateException(paramQMCalendarEvent, (RecurringException)paramList.next());
      }
    }
  }
  
  public void createLocalEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    this.mCalendarManager.paddingNewEvent(paramQMCalendarEvent);
    CPEvent localCPEvent = getSyncEventFromCalendarEvent(paramQMCalendarEvent);
    long l = this.mDataManager.insertEvent(localCPEvent);
    if (l != -1L)
    {
      paramQMCalendarEvent.setId(l);
      this.mCalendarManager.createEventLocal(paramQMCalendarEvent);
      createLocalReminder(paramQMCalendarEvent);
      QMLog.log(4, "CalendarProviderManager", "createEvent id:" + l + " subject:" + paramQMCalendarEvent.getSubject());
      return;
    }
    QMLog.log(4, "CalendarProviderManager", "createEvent fail:" + paramQMCalendarEvent.getId() + " subject:" + paramQMCalendarEvent.getSubject());
  }
  
  public void createLocalReminder(QMCalendarEvent paramQMCalendarEvent)
  {
    CPReminder localCPReminder = getSyncReminderByCalendarReminder(paramQMCalendarEvent.getId(), paramQMCalendarEvent.getReminder());
    if (localCPReminder != null)
    {
      ArrayList localArrayList = Lists.newArrayList();
      localArrayList.add(localCPReminder);
      this.mDataManager.insertReminder(localArrayList, paramQMCalendarEvent.getAccountName(), paramQMCalendarEvent.getAccountType());
    }
  }
  
  public void deleteCalendarFolder(QMCalendarFolder paramQMCalendarFolder)
  {
    CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(paramQMCalendarFolder.getId());
    if (localCPCalendar != null)
    {
      this.mDataManager.deleteCalendar(localCPCalendar);
      this.mCalendarManager.deleteCalendarLocal(paramQMCalendarFolder.getAccountId(), paramQMCalendarFolder.getId());
    }
  }
  
  public void deleteLocalEvent(long paramLong, int paramInt, QMSchedule paramQMSchedule)
  {
    QMCalendarSQLiteHelper localQMCalendarSQLiteHelper = this.mCalendarManager.getCalendarSQLiteHelper();
    SQLiteDatabase localSQLiteDatabase = localQMCalendarSQLiteHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransactionNonExclusive();
    QMCalendarEvent localQMCalendarEvent;
    Object localObject;
    try
    {
      localQMCalendarEvent = localQMCalendarSQLiteHelper.getCalendarEventWithAllException(localQMCalendarSQLiteHelper.getReadableDatabase(), paramLong);
      QMLog.log(4, "CalendarProviderManager", "deleteLocalEvent id:" + localQMCalendarEvent.getId() + " subject:" + localQMCalendarEvent.getSubject() + " modifyType: " + paramInt);
      if (!localQMCalendarEvent.isRecurring()) {
        break label507;
      }
      if (paramInt != 0) {
        break label341;
      }
      if ((localQMCalendarEvent.getExceptions() != null) && (localQMCalendarEvent.getExceptions().size() != 0)) {
        break label220;
      }
      localObject = this.mCalendarManager.createDeleteExceptionForEvent(localQMCalendarEvent, paramQMSchedule.getEventStartTime());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localQMCalendarEvent.setExceptions(localArrayList);
      localQMCalendarSQLiteHelper.insertException(localSQLiteDatabase, (RecurringException)localObject);
    }
    catch (Exception paramQMSchedule)
    {
      for (;;)
      {
        QMLog.log(6, "CalendarProviderManager", "deleteSchedules exception: " + Log.getStackTraceString(paramQMSchedule));
        localSQLiteDatabase.endTransaction();
        continue;
        localQMCalendarSQLiteHelper.insertException(localSQLiteDatabase, this.mCalendarManager.createDeleteExceptionForEvent(localQMCalendarEvent, paramQMSchedule.getEventStartTime()));
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    this.mCalendarManager.deleteScheduleByStartTime(localQMCalendarEvent.getId(), paramQMSchedule.getEventStartTime());
    this.mCalendarManager.deleteEventRemindersByStartTime(localQMCalendarEvent.getId(), paramQMSchedule.getEventStartTime());
    for (;;)
    {
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      this.mCalendarManager.resetScheduleCache();
      return;
      label220:
      localObject = QMCalendarManager.getExceptionFromEvent(localQMCalendarEvent, RecurringException.getExceptionStartTimeFromId(paramQMSchedule.getExceptionId()));
      if (localObject != null)
      {
        ((RecurringException)localObject).setIsDelete(true);
        updateException(localQMCalendarEvent, (RecurringException)localObject);
        localQMCalendarSQLiteHelper.updateException(localSQLiteDatabase, (RecurringException)localObject);
        break;
      }
      label341:
      if (paramInt == 1)
      {
        if (QMCalendarUtil.isFirstScheduleInstance(localQMCalendarEvent, paramQMSchedule))
        {
          deleteEvent(localQMCalendarEvent.getId());
          localQMCalendarSQLiteHelper.deleteEvent(localSQLiteDatabase, localQMCalendarEvent.getId());
        }
        for (;;)
        {
          this.mCalendarManager.deleteScheduleAfterTime(paramLong, paramQMSchedule.getEventStartTime());
          this.mCalendarManager.deleteEventRemindersAfterTime(paramLong, paramQMSchedule.getEventStartTime());
          break;
          long l = QMCalendarUtil.computeUntilTime(localQMCalendarEvent, paramQMSchedule);
          localQMCalendarEvent.setUntil(l);
          this.mCalendarManager.modifyEventExceptionsByUntil(localQMCalendarEvent, l);
          localObject = CalendarProviderDataManager.sharedInstance().queryEventById(localQMCalendarEvent.getId());
          ((CPEvent)localObject).setRrule(CalendarProviderUtil.parseQMEventToRRule(localQMCalendarEvent));
          this.mDataManager.updateEvent((CPEvent)localObject);
          localQMCalendarSQLiteHelper.updateEventUntilTime(localSQLiteDatabase, paramLong, l);
        }
      }
      if (paramInt == 2)
      {
        deleteEvent(localQMCalendarEvent.getId());
        localQMCalendarSQLiteHelper.deleteEvent(localSQLiteDatabase, localQMCalendarEvent.getId());
        continue;
        label507:
        deleteEvent(localQMCalendarEvent.getId());
        localQMCalendarSQLiteHelper.deleteEvent(localSQLiteDatabase, localQMCalendarEvent.getId());
      }
    }
  }
  
  public void modifyLocalEvent(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, QMSchedule paramQMSchedule, int paramInt)
  {
    QMLog.log(4, "CalendarProviderManager", "modifyLocalEvent id:" + paramQMCalendarEvent1.getId() + " subject:" + paramQMCalendarEvent1.getSubject() + " modifyType: " + paramInt);
    if ((!paramQMCalendarEvent1.isRecurring()) && (paramQMCalendarEvent2.isRecurring()))
    {
      deleteLocalEvent(paramQMCalendarEvent1.getId(), paramInt, paramQMSchedule);
      QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
      createLocalEvent(paramQMCalendarEvent2);
    }
    QMCalendarEvent localQMCalendarEvent;
    do
    {
      return;
      if ((paramQMCalendarEvent1.isRecurring()) && (!paramQMCalendarEvent2.isRecurring()))
      {
        deleteLocalEvent(paramQMCalendarEvent1.getId(), paramInt, paramQMSchedule);
        createLocalEvent(paramQMCalendarEvent2);
        return;
      }
      if (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())
      {
        deleteLocalEvent(paramQMCalendarEvent1.getId(), paramInt, paramQMSchedule);
        QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
        this.mCalendarManager.changeExceptionsForEvent(paramQMCalendarEvent2, paramQMSchedule.getEventStartTime());
        this.mCalendarManager.deleteExceptionsForEvent(paramQMCalendarEvent1.getId(), paramQMSchedule.getEventStartTime());
        createLocalEvent(paramQMCalendarEvent2);
        return;
      }
      if ((!paramQMCalendarEvent1.isRecurring()) || (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())) {
        break;
      }
      localQMCalendarEvent = this.mCalendarManager.getCalendarEventById(paramQMCalendarEvent1.getId());
      if (paramInt == 0)
      {
        paramQMCalendarEvent1 = QMCalendarManager.getExceptionFromEvent(paramQMCalendarEvent2, RecurringException.getExceptionStartTimeFromId(paramQMSchedule.getExceptionId()));
        if (paramQMCalendarEvent1 != null)
        {
          this.mCalendarManager.fillExceptionWithEvent(paramQMCalendarEvent1, paramQMCalendarEvent2);
          updateException(paramQMCalendarEvent2, paramQMCalendarEvent1);
          return;
        }
        updateLocalEvent(paramQMCalendarEvent2);
        this.mCalendarManager.updateLocalCalenderEvent(paramQMCalendarEvent2);
        return;
      }
      if (paramInt == 1)
      {
        deleteLocalEvent(paramQMCalendarEvent1.getId(), paramInt, paramQMSchedule);
        if (this.mCalendarManager.isStartDateChange(paramQMCalendarEvent1, paramQMCalendarEvent2)) {
          QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
        }
        this.mCalendarManager.changeExceptionsForEvent(paramQMCalendarEvent2, paramQMSchedule.getEventStartTime());
        this.mCalendarManager.deleteExceptionsForEvent(paramQMCalendarEvent1.getId(), paramQMSchedule.getEventStartTime());
        createLocalEvent(paramQMCalendarEvent2);
        return;
      }
    } while (paramInt != 2);
    paramQMCalendarEvent2.setStartTime(localQMCalendarEvent.getStartTime() + paramQMCalendarEvent2.getStartTime() - paramQMSchedule.getEventStartTime());
    paramQMCalendarEvent2.setEndTime(localQMCalendarEvent.getEndTime() + paramQMCalendarEvent2.getEndTime() - paramQMSchedule.getEventEndTime());
    QMCalendarUtil.setRecurrenceElementForEvent(paramQMCalendarEvent2);
    updateLocalEvent(paramQMCalendarEvent2);
    this.mCalendarManager.updateLocalCalenderEvent(paramQMCalendarEvent2);
    return;
    updateLocalEvent(paramQMCalendarEvent2);
    this.mCalendarManager.updateLocalCalenderEvent(paramQMCalendarEvent2);
  }
  
  public void updateCalendarFolderColor(QMCalendarFolder paramQMCalendarFolder, int paramInt)
  {
    CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(paramQMCalendarFolder.getId());
    if (localCPCalendar != null)
    {
      localCPCalendar.setName(paramQMCalendarFolder.getName());
      localCPCalendar.setCalendarDisplayName(paramQMCalendarFolder.getName());
      localCPCalendar.setCalendarColor(paramInt);
      this.mDataManager.updateCalendar(localCPCalendar);
      this.mCalendarManager.updateCalendarFolderColor(paramQMCalendarFolder, paramInt);
    }
  }
  
  public void updateCalendarFolderIsShow(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ArrayList<Boolean> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(((Integer)paramArrayList1.get(i)).intValue());
      if (localCPCalendar != null)
      {
        localArrayList1.add(Long.valueOf(localCPCalendar.getId()));
        localArrayList2.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.mCalendarManager.setSystemCalendarVisible(localArrayList1, localArrayList2);
    this.mCalendarManager.updateCalendarFolderIsShow(paramArrayList1, paramArrayList2, paramArrayList);
  }
  
  public void updateCalendarFolderName(QMCalendarFolder paramQMCalendarFolder, String paramString)
  {
    CPCalendar localCPCalendar = this.mDataManager.queryCalendarById(paramQMCalendarFolder.getId());
    if (localCPCalendar != null)
    {
      localCPCalendar.setName(paramString);
      localCPCalendar.setCalendarDisplayName(paramString);
      localCPCalendar.setCalendarColor(paramQMCalendarFolder.getColor());
      this.mDataManager.updateCalendar(localCPCalendar);
      this.mCalendarManager.updateCalendarFolderName(paramQMCalendarFolder, paramString);
    }
  }
  
  public void updateLocalEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    Object localObject = getSyncEventFromCalendarEvent(paramQMCalendarEvent);
    this.mDataManager.updateEvent((CPEvent)localObject);
    ArrayList localArrayList = this.mDataManager.queryReminderByEventId(((CPEvent)localObject).getId());
    if (localArrayList.size() > 0)
    {
      localObject = (CPReminder)localArrayList.get(0);
      if (paramQMCalendarEvent.getReminder() == -1)
      {
        localArrayList = Lists.newArrayList();
        localArrayList.add(localObject);
        this.mDataManager.deleteReminder(localArrayList, paramQMCalendarEvent.getAccountName(), paramQMCalendarEvent.getAccountType());
        return;
      }
      ((CPReminder)localObject).setMinutes(paramQMCalendarEvent.getReminder());
      this.mDataManager.updateReminder(localArrayList, paramQMCalendarEvent.getAccountName(), paramQMCalendarEvent.getAccountType());
      return;
    }
    createLocalReminder(paramQMCalendarEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.CalendarProviderManager
 * JD-Core Version:    0.7.0.1
 */