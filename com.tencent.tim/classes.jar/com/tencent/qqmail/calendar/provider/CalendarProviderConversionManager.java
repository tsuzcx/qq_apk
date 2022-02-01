package com.tencent.qqmail.calendar.provider;

import com.tencent.moai.downloader.util.StringUtil;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.Attendee;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.model.CPAttendee;
import com.tencent.qqmail.calendar.provider.model.CPCalendar;
import com.tencent.qqmail.calendar.provider.model.CPEvent;
import com.tencent.qqmail.calendar.provider.model.CPReminder;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

public class CalendarProviderConversionManager
{
  private static final int ATTENDEE_STATUS_ACCEPTED = 1;
  private static final int ATTENDEE_STATUS_DECLINED = 2;
  private static final int ATTENDEE_STATUS_INVITED = 3;
  private static final int ATTENDEE_STATUS_NONE = 0;
  private static final int ATTENDEE_STATUS_TENTATIVE = 4;
  private static final long DURATION = 31536000000L;
  private static final int STATUS_CANCELED = 2;
  private static final int STATUS_CONFIRMED = 1;
  private static final int STATUS_TENTATIVE = 0;
  private static final String SYNC_TAG = "CalendarProviderManager_Sync";
  private static final String TAG = "CalendarProviderConversionManager";
  private static final int TYPE_NONE = 0;
  private static final int TYPE_OPTIONAL = 2;
  private static final int TYPE_REQUIRED = 1;
  private static final int TYPE_RESOURCE = 3;
  private static CalendarProviderConversionManager instance;
  private ArrayList<String> accounts = new ArrayList();
  private Object calendarDisplayChangedLock = new Object();
  private QMCalendarManager mCalendarManager = null;
  private CalendarProviderDataManager mDataManager = null;
  private boolean removing = false;
  
  private void addAllCalendarProviderData()
  {
    long l = System.currentTimeMillis();
    QMLog.log(4, "CalendarProviderConversionManager", "Start Add Calendar Data");
    updateAccountMap();
    Object localObject1 = this.mDataManager.queryAllCalendar();
    Object localObject2 = this.mCalendarManager.getRemoteSvrIds();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (CPCalendar)((Iterator)localObject1).next();
      if (!this.accounts.contains(((CPCalendar)localObject3).getAccountName()))
      {
        if (this.removing) {
          return;
        }
        this.mCalendarManager.insertCalendarFolder(getQMCalendarFolderFromCPCalendar((CPCalendar)localObject3));
        QMLog.log(4, "CalendarProviderConversionManager", "add calendar id:" + ((CPCalendar)localObject3).getId() + " name:" + ((CPCalendar)localObject3).getName());
      }
    }
    localObject1 = new HashSet();
    Object localObject4 = this.mDataManager.queryAllEvent();
    QMLog.log(4, "CalendarProviderConversionManager", "add calendar event size:" + ((ArrayList)localObject4).size());
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = this.mDataManager.queryAllReminder();
    Iterator localIterator = ((ArrayList)localObject4).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label375;
      }
      CPEvent localCPEvent = (CPEvent)localIterator.next();
      if (this.removing) {
        break;
      }
      if ((localCPEvent.getOriginalId() == 0L) && (!this.accounts.contains(localCPEvent.getAccountName())) && ((localCPEvent.getSyncId() == null) || (((HashMap)localObject2).get(localCPEvent.getSyncId()) == null)))
      {
        ((Set)localObject1).add(Long.valueOf(localCPEvent.getId()));
        localArrayList.add(getQMCalendarEventFromCPEvent(localCPEvent, (HashMap)localObject3));
      }
      else
      {
        QMLog.log(4, "CalendarProviderConversionManager", "filter svrId=" + localCPEvent.getSyncId() + " title=" + localCPEvent.getTitle() + " accountName=" + localCPEvent.getAccountName());
      }
    }
    label375:
    this.mCalendarManager.createEventLocal(localArrayList);
    localObject2 = ((ArrayList)localObject4).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label492;
      }
      localObject4 = (CPEvent)((Iterator)localObject2).next();
      if (this.removing) {
        break;
      }
      if ((((CPEvent)localObject4).getOriginalId() != 0L) && (((CPEvent)localObject4).getOriginalInstanceTime() != null) && (!this.accounts.contains(((CPEvent)localObject4).getAccountName())))
      {
        ((Set)localObject1).add(Long.valueOf(((CPEvent)localObject4).getId()));
        this.mCalendarManager.createExceptionLocal(getQMCalendarEventFromCPEvent((CPEvent)localObject4, (HashMap)localObject3), getRecurringExceptionFromCPEvent((CPEvent)localObject4));
      }
    }
    label492:
    localObject2 = this.mDataManager.queryAllAttendee();
    QMLog.log(4, "CalendarProviderConversionManager", "add calendar attendee size:" + ((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label604;
      }
      localObject3 = (CPAttendee)((Iterator)localObject2).next();
      if (this.removing) {
        break;
      }
      if (((Set)localObject1).contains(Long.valueOf(((CPAttendee)localObject3).getEventId()))) {
        this.mCalendarManager.createAttendeeLocal(getAttendeeFromCPAttendee((CPAttendee)localObject3), ((CPAttendee)localObject3).getEventId());
      }
    }
    label604:
    this.mCalendarManager.resetScheduleCache();
    this.mCalendarManager.triggerUpdateSchedule(null, 0L);
    QMLog.log(4, "CalendarProviderConversionManager", "All Calendar Data Add Finish In " + (System.currentTimeMillis() - l) + " ms");
  }
  
  private void removeAllCalendarProviderData()
  {
    long l = System.currentTimeMillis();
    QMLog.log(4, "CalendarProviderConversionManager", "Start Remove Calendar Data");
    this.mCalendarManager.deleteCalendarFolderByAccountId(0);
    this.mCalendarManager.resetScheduleCache();
    this.mCalendarManager.triggerUpdateSchedule(null, 0L);
    this.removing = false;
    QMLog.log(4, "CalendarProviderConversionManager", "All Calendar Data Were Removed Finish In " + (System.currentTimeMillis() - l) + " ms");
  }
  
  public static CalendarProviderConversionManager sharedInstance()
  {
    if (instance == null) {
      instance = new CalendarProviderConversionManager();
    }
    return instance;
  }
  
  private int transferStatusFromCPAttendee(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 4;
    case 3: 
      return 5;
    }
    return 2;
  }
  
  private int transferStatusFromCPMeetingStatus(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 5;
    }
    return 3;
  }
  
  private int transferTypeFromCPAttendee(int paramInt)
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
  
  private void updateAccountMap()
  {
    this.accounts.clear();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      this.accounts.add(localAccount.getEmail());
    }
  }
  
  public void dumgLog()
  {
    Threads.runInBackground(new CalendarProviderConversionManager.3(this));
  }
  
  public void dumpLocal()
  {
    QMLog.log(4, "CalendarProviderManager_Sync", "Local-------------------------------------------------------------------------------------------------------");
    Iterator localIterator = this.mDataManager.queryCalendarLocal().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (CPCalendar)localIterator.next();
      QMLog.log(4, "CalendarProviderManager_Sync", "calendar:" + ((CPCalendar)localObject1).toString());
    }
    localIterator = this.mDataManager.queryEventLocal(System.currentTimeMillis() - 31536000000L, System.currentTimeMillis() + 31536000000L).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (CPEvent)localIterator.next();
      QMLog.log(4, "CalendarProviderManager_Sync", "event:" + ((CPEvent)localObject1).toString());
      Object localObject2 = this.mDataManager.queryReminderByEventId(((CPEvent)localObject1).getId()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CPReminder localCPReminder = (CPReminder)((Iterator)localObject2).next();
        QMLog.log(4, "CalendarProviderManager_Sync", "reminder:" + localCPReminder.toString());
      }
      localObject1 = this.mDataManager.queryAttendeeByEventId(((CPEvent)localObject1).getId()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CPAttendee)((Iterator)localObject1).next();
        QMLog.log(4, "CalendarProviderManager_Sync", "attendee:" + ((CPAttendee)localObject2).toString());
      }
    }
  }
  
  public void dumpLog(boolean paramBoolean)
  {
    QMLog.log(4, "CalendarProviderManager_Sync", "-------------------------------------------------------------------------------------------------------");
    Object localObject1 = this.mDataManager.queryAllCalendar().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CPCalendar)((Iterator)localObject1).next();
      QMLog.log(4, "CalendarProviderManager_Sync", "calendar:" + ((CPCalendar)localObject2).toString());
    }
    if (paramBoolean)
    {
      localObject1 = this.mDataManager.queryAllEvent();
      localObject1 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (CPEvent)((Iterator)localObject1).next();
      QMLog.log(4, "CalendarProviderManager_Sync", "event:" + ((CPEvent)localObject2).toString());
      Object localObject3 = this.mDataManager.queryReminderByEventId(((CPEvent)localObject2).getId()).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          CPReminder localCPReminder = (CPReminder)((Iterator)localObject3).next();
          QMLog.log(4, "CalendarProviderManager_Sync", "reminder:" + localCPReminder.toString());
          continue;
          localObject1 = this.mDataManager.queryAllEvent(System.currentTimeMillis() - 31536000000L, System.currentTimeMillis() + 31536000000L);
          break;
        }
      }
      localObject2 = this.mDataManager.queryAttendeeByEventId(((CPEvent)localObject2).getId()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (CPAttendee)((Iterator)localObject2).next();
        QMLog.log(4, "CalendarProviderManager_Sync", "attendee:" + ((CPAttendee)localObject3).toString());
      }
    }
  }
  
  public Attendee getAttendeeFromCPAttendee(CPAttendee paramCPAttendee)
  {
    Attendee localAttendee = new Attendee();
    localAttendee.setName(paramCPAttendee.getAttendeeName());
    localAttendee.setEmail(paramCPAttendee.getAttendeeEmail());
    localAttendee.setType(transferTypeFromCPAttendee(paramCPAttendee.getAttendeeType()));
    localAttendee.setStatus(transferStatusFromCPAttendee(paramCPAttendee.getAttendeeStatus()));
    return localAttendee;
  }
  
  public QMCalendarEvent getQMCalendarEventFromCPEvent(CPEvent paramCPEvent, HashMap<Long, ArrayList<CPReminder>> paramHashMap)
  {
    boolean bool2 = true;
    QMCalendarEvent localQMCalendarEvent = new QMCalendarEvent();
    localQMCalendarEvent.setId(paramCPEvent.getId());
    localQMCalendarEvent.setUid(QMCalendarEvent.generateUid(localQMCalendarEvent));
    localQMCalendarEvent.setAccountId(0);
    localQMCalendarEvent.setAccountName(paramCPEvent.getAccountName());
    localQMCalendarEvent.setAccountType(paramCPEvent.getAccountType());
    localQMCalendarEvent.setCalderFolderId((int)paramCPEvent.getCalendarId());
    localQMCalendarEvent.setReminderId(0);
    label116:
    long l1;
    if (paramCPEvent.getAllDay() == 1)
    {
      bool1 = true;
      localQMCalendarEvent.setReminder(CalendarProviderUtil.getSupportReminder(bool1, (ArrayList)paramHashMap.get(Long.valueOf(paramCPEvent.getId()))));
      if (paramCPEvent.getTitle() == null) {
        break label631;
      }
      paramHashMap = paramCPEvent.getTitle();
      localQMCalendarEvent.setSubject(paramHashMap);
      if (paramCPEvent.getDescription() == null) {
        break label638;
      }
      paramHashMap = paramCPEvent.getDescription();
      label134:
      localQMCalendarEvent.setBody(paramHashMap);
      if (paramCPEvent.getEventLocation() == null) {
        break label645;
      }
      paramHashMap = paramCPEvent.getEventLocation();
      label152:
      localQMCalendarEvent.setLocation(paramHashMap);
      if (paramCPEvent.getAllDay() != 1) {
        break label652;
      }
      bool1 = true;
      label168:
      localQMCalendarEvent.setIsAllDay(bool1);
      localQMCalendarEvent.setSensivity(0);
      localQMCalendarEvent.setAttribute(0);
      localQMCalendarEvent.setCategory(1);
      localQMCalendarEvent.setCid(0L);
      localQMCalendarEvent.setTimezone(String.valueOf(QMCalendarManager.timeZone));
      if (paramCPEvent.getAllDay() != 1) {
        break label657;
      }
      l1 = paramCPEvent.getDtStart() - TimeZone.getDefault().getRawOffset();
      label231:
      localQMCalendarEvent.setStartTime(l1);
      if (paramCPEvent.getAllDay() != 1) {
        break label666;
      }
      l1 = paramCPEvent.getDtEnd() - TimeZone.getDefault().getRawOffset();
      label260:
      localQMCalendarEvent.setEndTime(l1);
      if ((paramCPEvent.getRrule() != null) && (!paramCPEvent.getRrule().equals("")))
      {
        long l2 = paramCPEvent.getDtStart() + CalendarProviderUtil.parseCPEventDuration(paramCPEvent).longValue();
        l1 = l2;
        if (paramCPEvent.getAllDay() == 1) {
          l1 = l2 - TimeZone.getDefault().getRawOffset();
        }
        localQMCalendarEvent.setEndTime(l1);
      }
      localQMCalendarEvent.setCreateTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
      localQMCalendarEvent.setModifyTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
      localQMCalendarEvent.setPath("");
      localQMCalendarEvent.seteTag("");
      if (paramCPEvent.getSyncId() != null) {
        break label675;
      }
      paramHashMap = "";
      label381:
      localQMCalendarEvent.setSvrId(paramHashMap);
      localQMCalendarEvent.setRecurrenceType(CalendarProviderUtil.parseCPEventRecurrenceType(paramCPEvent.getRrule()));
      localQMCalendarEvent.setInterval(CalendarProviderUtil.parseCPEventInterval(paramCPEvent));
      localQMCalendarEvent.setWeekOfMonth(CalendarProviderUtil.parseCPEventWeekOfMonth(paramCPEvent.getRrule()));
      localQMCalendarEvent.setDayOfWeek(CalendarProviderUtil.parseCPEventDayOfWeek(paramCPEvent.getRrule(), paramCPEvent.getDtStart()));
      if (paramCPEvent.getAllDay() != 1) {
        break label683;
      }
      bool1 = true;
      label446:
      localQMCalendarEvent.setMonthOfYear(CalendarProviderUtil.parseMonthOfYear(bool1, paramCPEvent.getDtStart(), paramCPEvent.getRrule()));
      if (paramCPEvent.getAllDay() != 1) {
        break label688;
      }
    }
    label645:
    label652:
    label657:
    label666:
    label675:
    label683:
    label688:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQMCalendarEvent.setDaysOfMonth(CalendarProviderUtil.parseCPEventDayOfMonth(bool1, paramCPEvent.getDtStart(), paramCPEvent.getRrule()));
      if (localQMCalendarEvent.getDaysOfMonth().size() > 0) {
        localQMCalendarEvent.setDayOfMonth(((Integer)localQMCalendarEvent.getDaysOfMonth().get(0)).intValue());
      }
      localQMCalendarEvent.setUntil(CalendarProviderUtil.parseCPEventUntil(paramCPEvent, localQMCalendarEvent).longValue());
      localQMCalendarEvent.setRelateType(0);
      localQMCalendarEvent.setRelatedId("");
      localQMCalendarEvent.setRelateAccountId(0);
      localQMCalendarEvent.setAppointmentType(0);
      localQMCalendarEvent.setOrganizerName(paramCPEvent.getOrganizer());
      localQMCalendarEvent.setOrganizerEmail(paramCPEvent.getOrganizer());
      localQMCalendarEvent.setAttendees(null);
      localQMCalendarEvent.setResponseType(0);
      localQMCalendarEvent.setMeetingStatus(transferStatusFromCPMeetingStatus(paramCPEvent.getStatus()));
      localQMCalendarEvent.setIsDecline(false);
      localQMCalendarEvent.setExceptions(null);
      localQMCalendarEvent.setExceptionHashMap(null);
      return localQMCalendarEvent;
      bool1 = false;
      break;
      label631:
      paramHashMap = "";
      break label116;
      label638:
      paramHashMap = "";
      break label134;
      paramHashMap = "";
      break label152;
      bool1 = false;
      break label168;
      l1 = paramCPEvent.getDtStart();
      break label231;
      l1 = paramCPEvent.getDtEnd();
      break label260;
      paramHashMap = paramCPEvent.getSyncId();
      break label381;
      bool1 = false;
      break label446;
    }
  }
  
  public QMCalendarFolder getQMCalendarFolderFromCPCalendar(CPCalendar paramCPCalendar)
  {
    QMCalendarFolder localQMCalendarFolder = new QMCalendarFolder();
    localQMCalendarFolder.setId((int)paramCPCalendar.getId());
    localQMCalendarFolder.setCollectionId("");
    localQMCalendarFolder.setParentId("");
    localQMCalendarFolder.setAccountId(0);
    localQMCalendarFolder.setAccountName(paramCPCalendar.getAccountName());
    localQMCalendarFolder.setAccountType(paramCPCalendar.getAccountType());
    localQMCalendarFolder.setOwnerAccount(paramCPCalendar.getOwnerAccount());
    String str;
    boolean bool;
    if (StringUtil.isNullOrEmpty(paramCPCalendar.getName()))
    {
      str = paramCPCalendar.getCalendarDisplayName();
      localQMCalendarFolder.setName(str);
      localQMCalendarFolder.setPath("");
      localQMCalendarFolder.setcTag("");
      localQMCalendarFolder.setSyncKey("");
      localQMCalendarFolder.setSyncToken("");
      localQMCalendarFolder.setType(0);
      localQMCalendarFolder.setCategory(1);
      localQMCalendarFolder.setIsShow(this.mCalendarManager.getSystemCalendarVisible(paramCPCalendar.getId()));
      if (paramCPCalendar.getCalendarAccessLevel() != 700) {
        break label272;
      }
      bool = true;
      label163:
      localQMCalendarFolder.setIsEditable(bool);
      if (paramCPCalendar.getCalendarColor() != 0) {
        break label277;
      }
    }
    label272:
    label277:
    for (int i = this.mCalendarManager.getColorForNewCalendar(0);; i = paramCPCalendar.getCalendarColor())
    {
      localQMCalendarFolder.setColor(i);
      if (("" + paramCPCalendar.getOwnerAccount() + paramCPCalendar.getAccountType() + "" + paramCPCalendar.getAccountName()).toLowerCase().contains("birthday")) {
        localQMCalendarFolder.setIsEditable(false);
      }
      localQMCalendarFolder.setCreateTime(System.currentTimeMillis());
      return localQMCalendarFolder;
      str = paramCPCalendar.getName();
      break;
      bool = false;
      break label163;
    }
  }
  
  public RecurringException getRecurringExceptionFromCPEvent(CPEvent paramCPEvent)
  {
    boolean bool2 = false;
    RecurringException localRecurringException = new RecurringException();
    localRecurringException.setId(String.valueOf(paramCPEvent.getId()) + "_" + paramCPEvent.getDtStart());
    boolean bool1;
    label84:
    long l;
    label150:
    label179:
    label208:
    String str;
    if (paramCPEvent.getStatus() == 2)
    {
      bool1 = true;
      localRecurringException.setIsDelete(bool1);
      localRecurringException.setEventId(paramCPEvent.getOriginalId());
      if (paramCPEvent.getAllDay() != 1) {
        break label281;
      }
      bool1 = true;
      localRecurringException.setIsAllDay(bool1);
      bool1 = bool2;
      if (paramCPEvent.getAllDay() == 1) {
        bool1 = true;
      }
      localRecurringException.setReminder(CalendarProviderUtil.getSupportReminder(bool1, this.mDataManager.queryReminderByEventId(paramCPEvent.getId())));
      if (paramCPEvent.getOriginalAllDay() != 1) {
        break label286;
      }
      l = Long.valueOf(paramCPEvent.getOriginalInstanceTime()).longValue() - TimeZone.getDefault().getRawOffset();
      localRecurringException.setExceptionStartTime(l);
      if (paramCPEvent.getAllDay() != 1) {
        break label301;
      }
      l = paramCPEvent.getDtStart() - TimeZone.getDefault().getRawOffset();
      localRecurringException.setStartTime(l);
      if (paramCPEvent.getAllDay() != 1) {
        break label310;
      }
      l = paramCPEvent.getDtEnd() - TimeZone.getDefault().getRawOffset();
      localRecurringException.setEndTime(l);
      if (paramCPEvent.getTitle() == null) {
        break label319;
      }
      str = paramCPEvent.getTitle();
      label228:
      localRecurringException.setSubject(str);
      if (paramCPEvent.getEventLocation() == null) {
        break label327;
      }
      str = paramCPEvent.getEventLocation();
      label248:
      localRecurringException.setLocation(str);
      if (paramCPEvent.getDescription() == null) {
        break label335;
      }
    }
    label281:
    label286:
    label301:
    label310:
    label319:
    label327:
    label335:
    for (paramCPEvent = paramCPEvent.getDescription();; paramCPEvent = "")
    {
      localRecurringException.setBody(paramCPEvent);
      return localRecurringException;
      bool1 = false;
      break;
      bool1 = false;
      break label84;
      l = Long.valueOf(paramCPEvent.getOriginalInstanceTime()).longValue();
      break label150;
      l = paramCPEvent.getDtStart();
      break label179;
      l = paramCPEvent.getDtEnd();
      break label208;
      str = "";
      break label228;
      str = "";
      break label248;
    }
  }
  
  public void onSystemCalendarDisplayChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.removing = true;
    }
    Threads.runInBackground(new CalendarProviderConversionManager.2(this, paramBoolean));
  }
  
  public void synQMCalendarDataWithCPCalendar()
  {
    Threads.runInBackground(new CalendarProviderConversionManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.CalendarProviderConversionManager
 * JD-Core Version:    0.7.0.1
 */