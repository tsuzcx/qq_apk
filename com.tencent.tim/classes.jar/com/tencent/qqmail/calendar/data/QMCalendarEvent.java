package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class QMCalendarEvent
  extends QMCalendarBase
  implements Serializable
{
  public static final int APPOINTMENT_TYPE_ACCEPTED = 3;
  public static final int APPOINTMENT_TYPE_DECLINED = 4;
  public static final int APPOINTMENT_TYPE_NOT_MEETING = 0;
  public static final int APPOINTMENT_TYPE_ORGANIZER = 1;
  public static final int APPOINTMENT_TYPE_TENTATIVE = 2;
  public static final int APPOINTMENT_TYPE_UNRESPONSE = 5;
  public static final int EVENT_ATTR_IS_LUNAR_CALENDAR = 1;
  public static final int EVENT_ATTR_IS_LUNAR_LEAP_MONTH = 2;
  public static final int EVENT_DURATION_ONEHOUR = 60;
  public static final int EVENT_DURATION_THIRTYMIN = 30;
  public static final int EVENT_DURATION_THREEHOUR = 180;
  public static final int EVENT_DURATION_TWOHOUR = 120;
  public static final String EVENT_RELATE_PREFIX_MAIL = "mailid:";
  public static final String EVENT_RELATE_PREFIX_NOTE = "noteid:";
  public static final int RECURRENCE_TYPE_DAILY = 0;
  public static final int RECURRENCE_TYPE_MONTHLY = 2;
  public static final int RECURRENCE_TYPE_MONTHLY_NTH_DAY = 3;
  public static final int RECURRENCE_TYPE_NONE = -1;
  public static final int RECURRENCE_TYPE_WEEKLY = 1;
  public static final int RECURRENCE_TYPE_WORK_DAY = 7;
  public static final int RECURRENCE_TYPE_YEARLY = 5;
  public static final int RECURRENCE_TYPE_YEARLY_NTH_DAY = 6;
  public static final int RELATE_TYPE_MAIL = 1;
  public static final int RELATE_TYPE_NONE = 0;
  public static final int RELATE_TYPE_NOTE = 2;
  public static final int REMIND_ALLDAY_TIME_NONE = -1;
  public static final int REMIND_ALLDAY_TIME_ONEDAY = 900;
  public static final int REMIND_ALLDAY_TIME_ONEWEEK = 9540;
  public static final int REMIND_ALLDAY_TIME_THATDAY = 0;
  public static final int REMIND_ALLDAY_TIME_TWODAY = 2340;
  public static final int REMIND_TIME_FIFTENMIN = 15;
  public static final int REMIND_TIME_FIVEMIN = 5;
  public static final int REMIND_TIME_HAPPEN = 0;
  public static final int REMIND_TIME_NONE = -1;
  public static final int REMIND_TIME_ONEDAY = 1440;
  public static final int REMIND_TIME_ONEHOUR = 60;
  public static final int SENSIVITY_CONFIDENTIAL = 0;
  public static final int SENSIVITY_NORMAIL = 0;
  public static final int SENSIVITY_PERSONAL = 1;
  public static final int SENSIVITY_PRIVATE = 2;
  public static final int SYNC_TIME_ALL = 4;
  public static final int SYNC_TIME_LAST_TWO_WEEK = 0;
  public static final int SYNC_TIME_ONE_MONTH = 1;
  public static final int SYNC_TIME_SIX_MONTH = 3;
  public static final int SYNC_TIME_THREE_MONTH = 2;
  private static final long serialVersionUID = -1161358192569393303L;
  private int accountId = -1;
  private String accountName;
  private String accountType;
  private int appointmentType = 0;
  private ArrayList<Attendee> attendees;
  private int attribute = 0;
  private String body;
  private int calderFolderId = -1;
  private int calendarType = 0;
  private int category = 0;
  private long cid = 0L;
  private long createTime;
  private int dayOfMonth = 0;
  private int dayOfWeek = 0;
  private ArrayList<Integer> daysOfMonth;
  private String eTag;
  private long endTime;
  private HashMap<Integer, RecurringException> exceptionHashMap;
  private ArrayList<RecurringException> exceptions;
  private long id;
  private int interval = 0;
  private boolean isAllDay = false;
  private boolean isDecline;
  private String location;
  private int meetingStatus;
  private long modifyTime;
  private int monthOfYear = 0;
  private int offLineOptType = 0;
  private String organizerEmail;
  private String organizerName;
  private String path = "";
  private int recurrenceType = -1;
  private int relateAccountId;
  private int relateType = 0;
  private String relatedId = "";
  private int reminder = -1;
  private int reminderId = -1;
  private int responseType;
  private int sensivity = 0;
  private long startTime;
  private String subject;
  private String svrId;
  private String timezone;
  private String uid = "";
  private long until = 0L;
  private int weekOfMonth = 0;
  
  public QMCalendarEvent() {}
  
  public QMCalendarEvent(long paramLong1, long paramLong2)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public static long generateId(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("^");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("^");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("^");
    localStringBuilder.append(paramString2);
    return QMMath.hashLong(localStringBuilder.toString());
  }
  
  public static long generateId(QMCalendarEvent paramQMCalendarEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMCalendarEvent.getAccountId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarEvent.getCalderFolderId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarEvent.getUid());
    if (StringUtils.isBlank(paramQMCalendarEvent.getUid()))
    {
      localStringBuilder.append("^");
      localStringBuilder.append(paramQMCalendarEvent.getSvrId());
      localStringBuilder.append("^");
      localStringBuilder.append(paramQMCalendarEvent.getPath());
    }
    return QMMath.hashLong(localStringBuilder.toString());
  }
  
  public static String generateUid(QMCalendarEvent paramQMCalendarEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMCalendarEvent.getAccountId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarEvent.getCalderFolderId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarEvent.getCreateTime());
    return "qqmail_" + QMMath.hashInt(localStringBuilder.toString());
  }
  
  public Object clone()
  {
    QMCalendarEvent localQMCalendarEvent = new QMCalendarEvent();
    localQMCalendarEvent.setAccountId(this.accountId);
    localQMCalendarEvent.setAttribute(this.attribute);
    localQMCalendarEvent.setIsAllDay(this.isAllDay);
    localQMCalendarEvent.setAppointmentType(this.appointmentType);
    localQMCalendarEvent.setAttendees(this.attendees);
    localQMCalendarEvent.setBody(this.body);
    localQMCalendarEvent.setCalderFolderId(this.calderFolderId);
    localQMCalendarEvent.setCategory(this.category);
    localQMCalendarEvent.setAccountName(this.accountName);
    localQMCalendarEvent.setAccountType(this.accountType);
    localQMCalendarEvent.setCid(this.cid);
    localQMCalendarEvent.setCreateTime(this.createTime);
    localQMCalendarEvent.setDayOfMonth(this.dayOfMonth);
    localQMCalendarEvent.setDayOfWeek(this.dayOfWeek);
    localQMCalendarEvent.setEndTime(this.endTime);
    localQMCalendarEvent.seteTag(this.eTag);
    localQMCalendarEvent.setExceptionHashMap(this.exceptionHashMap);
    localQMCalendarEvent.setExceptions(this.exceptions);
    localQMCalendarEvent.setId(this.id);
    localQMCalendarEvent.setInterval(this.interval);
    localQMCalendarEvent.setLocation(this.location);
    localQMCalendarEvent.setModifyTime(this.modifyTime);
    localQMCalendarEvent.setMonthOfYear(this.monthOfYear);
    localQMCalendarEvent.setOffLineOptType(this.offLineOptType);
    localQMCalendarEvent.setOrganizerEmail(this.organizerEmail);
    localQMCalendarEvent.setOrganizerName(this.organizerName);
    localQMCalendarEvent.setPath(this.path);
    localQMCalendarEvent.setRecurrenceType(this.recurrenceType);
    localQMCalendarEvent.setRelatedId(this.relatedId);
    localQMCalendarEvent.setRelateType(this.relateType);
    localQMCalendarEvent.setRelateAccountId(this.relateAccountId);
    localQMCalendarEvent.setReminder(this.reminder);
    localQMCalendarEvent.setReminderId(this.reminderId);
    localQMCalendarEvent.setResponseType(this.responseType);
    localQMCalendarEvent.setSensivity(this.sensivity);
    localQMCalendarEvent.setStartTime(this.startTime);
    localQMCalendarEvent.setSubject(this.subject);
    localQMCalendarEvent.setSvrId(this.svrId);
    localQMCalendarEvent.setTimezone(this.timezone);
    localQMCalendarEvent.setUid(this.uid);
    localQMCalendarEvent.setUntil(this.until);
    localQMCalendarEvent.setWeekOfMonth(this.weekOfMonth);
    if (this.daysOfMonth != null) {
      localQMCalendarEvent.setDaysOfMonth((ArrayList)this.daysOfMonth.clone());
    }
    return localQMCalendarEvent;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getAccountType()
  {
    return this.accountType;
  }
  
  public int getAppointmentType()
  {
    return this.appointmentType;
  }
  
  public ArrayList<Attendee> getAttendees()
  {
    return this.attendees;
  }
  
  public int getAttribute()
  {
    return this.attribute;
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public int getCalderFolderId()
  {
    return this.calderFolderId;
  }
  
  public int getCalendarType()
  {
    return this.calendarType;
  }
  
  public int getCategory()
  {
    return this.category;
  }
  
  public long getCid()
  {
    return this.cid;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getDayOfMonth()
  {
    return this.dayOfMonth;
  }
  
  public int getDayOfWeek()
  {
    return this.dayOfWeek;
  }
  
  public ArrayList<Integer> getDaysOfMonth()
  {
    return this.daysOfMonth;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public HashMap<Integer, RecurringException> getExceptionHashMap()
  {
    return this.exceptionHashMap;
  }
  
  public ArrayList<RecurringException> getExceptions()
  {
    return this.exceptions;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getInterval()
  {
    return this.interval;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public int getMeetingStatus()
  {
    return this.meetingStatus;
  }
  
  public long getModifyTime()
  {
    return this.modifyTime;
  }
  
  public int getMonthOfYear()
  {
    return this.monthOfYear;
  }
  
  public int getOffLineOptType()
  {
    return this.offLineOptType;
  }
  
  public String getOrganizerEmail()
  {
    return this.organizerEmail;
  }
  
  public String getOrganizerName()
  {
    return this.organizerName;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getRecurrenceType()
  {
    return this.recurrenceType;
  }
  
  public int getRelateAccountId()
  {
    return this.relateAccountId;
  }
  
  public int getRelateType()
  {
    return this.relateType;
  }
  
  public String getRelatedId()
  {
    return this.relatedId;
  }
  
  public int getReminder()
  {
    return this.reminder;
  }
  
  public int getReminderId()
  {
    return this.reminderId;
  }
  
  public int getResponseType()
  {
    return this.responseType;
  }
  
  public int getSensivity()
  {
    return this.sensivity;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getSvrId()
  {
    return this.svrId;
  }
  
  public String getTimezone()
  {
    return this.timezone;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public long getUntil()
  {
    return this.until;
  }
  
  public int getWeekOfMonth()
  {
    return this.weekOfMonth;
  }
  
  public String geteTag()
  {
    return this.eTag;
  }
  
  public boolean isAllDay()
  {
    return this.isAllDay;
  }
  
  public boolean isDecline()
  {
    return this.isDecline;
  }
  
  public boolean isDiffer(QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent == null) {}
    do
    {
      return false;
      if ((paramQMCalendarEvent.getSubject() != null) && (!getSubject().equals(paramQMCalendarEvent.getSubject()))) {
        return true;
      }
      if (getReminder() != paramQMCalendarEvent.getReminder()) {
        return true;
      }
      if (getRecurrenceType() != paramQMCalendarEvent.getRecurrenceType()) {
        return true;
      }
      if (getCalderFolderId() != paramQMCalendarEvent.getCalderFolderId()) {
        return true;
      }
      if ((paramQMCalendarEvent.getBody() != null) && (!paramQMCalendarEvent.getBody().equals(getBody()))) {
        return true;
      }
      if ((paramQMCalendarEvent.getLocation() != null) && (!paramQMCalendarEvent.getLocation().equals(getLocation()))) {
        return true;
      }
      if ((isAllDay() ^ paramQMCalendarEvent.isAllDay())) {
        return true;
      }
      if (getStartTime() != paramQMCalendarEvent.getStartTime()) {
        return true;
      }
    } while (getEndTime() == paramQMCalendarEvent.getEndTime());
    return true;
  }
  
  public boolean isICSEvent()
  {
    return (this.attendees != null) && (this.attendees.size() > 0);
  }
  
  public boolean isLeapMonth()
  {
    return (this.attribute & 0x2) != 0;
  }
  
  public boolean isLunarCalendar()
  {
    return (this.attribute & 0x1) != 0;
  }
  
  public boolean isRecurring()
  {
    return this.recurrenceType != -1;
  }
  
  public void resetRecurrenceEelement()
  {
    this.recurrenceType = -1;
    this.interval = 0;
    this.dayOfWeek = 0;
    this.dayOfMonth = 0;
    this.weekOfMonth = 0;
    this.monthOfYear = 0;
  }
  
  public void set(QMCalendarEvent paramQMCalendarEvent)
  {
    setAccountId(paramQMCalendarEvent.getAccountId());
    setAttribute(paramQMCalendarEvent.getAttribute());
    setIsAllDay(paramQMCalendarEvent.isAllDay());
    setAttendees(paramQMCalendarEvent.getAttendees());
    setBody(paramQMCalendarEvent.getBody());
    setCalderFolderId(paramQMCalendarEvent.getCalderFolderId());
    setCategory(paramQMCalendarEvent.getCategory());
    setAccountName(paramQMCalendarEvent.getAccountName());
    setAccountType(paramQMCalendarEvent.getAccountType());
    setCid(paramQMCalendarEvent.getCid());
    setCreateTime(paramQMCalendarEvent.getCreateTime());
    setDayOfMonth(paramQMCalendarEvent.getDayOfMonth());
    setDayOfWeek(paramQMCalendarEvent.getDayOfWeek());
    setEndTime(paramQMCalendarEvent.getEndTime());
    seteTag(paramQMCalendarEvent.geteTag());
    setExceptionHashMap(paramQMCalendarEvent.getExceptionHashMap());
    setExceptions(paramQMCalendarEvent.getExceptions());
    setId(paramQMCalendarEvent.getId());
    setInterval(paramQMCalendarEvent.getInterval());
    setLocation(paramQMCalendarEvent.getLocation());
    setModifyTime(paramQMCalendarEvent.getModifyTime());
    setMonthOfYear(paramQMCalendarEvent.getMonthOfYear());
    setOffLineOptType(paramQMCalendarEvent.getOffLineOptType());
    setOrganizerEmail(paramQMCalendarEvent.getOrganizerEmail());
    setOrganizerName(paramQMCalendarEvent.getOrganizerName());
    setPath(paramQMCalendarEvent.getPath());
    setRecurrenceType(paramQMCalendarEvent.getRecurrenceType());
    setRelatedId(paramQMCalendarEvent.getRelatedId());
    setRelateType(paramQMCalendarEvent.getRelateType());
    setRelateAccountId(paramQMCalendarEvent.getRelateAccountId());
    setReminder(paramQMCalendarEvent.getReminder());
    setReminderId(paramQMCalendarEvent.getReminderId());
    setResponseType(paramQMCalendarEvent.getResponseType());
    setSensivity(paramQMCalendarEvent.getSensivity());
    setStartTime(paramQMCalendarEvent.getStartTime());
    setSubject(paramQMCalendarEvent.getSubject());
    setSvrId(paramQMCalendarEvent.getSvrId());
    setTimezone(paramQMCalendarEvent.getTimezone());
    setUid(paramQMCalendarEvent.getUid());
    setUntil(paramQMCalendarEvent.getUntil());
    setWeekOfMonth(paramQMCalendarEvent.getWeekOfMonth());
    if (paramQMCalendarEvent.getDaysOfMonth() != null) {
      setDaysOfMonth((ArrayList)paramQMCalendarEvent.getDaysOfMonth().clone());
    }
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAccountName(String paramString)
  {
    this.accountName = paramString;
  }
  
  public void setAccountType(String paramString)
  {
    this.accountType = paramString;
  }
  
  public void setAppointmentType(int paramInt)
  {
    this.appointmentType = paramInt;
  }
  
  public void setAttendees(ArrayList<Attendee> paramArrayList)
  {
    this.attendees = paramArrayList;
  }
  
  public void setAttribute(int paramInt)
  {
    this.attribute = paramInt;
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setCalderFolderId(int paramInt)
  {
    this.calderFolderId = paramInt;
  }
  
  public void setCalendarType(int paramInt)
  {
    this.calendarType = paramInt;
  }
  
  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }
  
  public void setCid(long paramLong)
  {
    this.cid = paramLong;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setDayOfMonth(int paramInt)
  {
    this.dayOfMonth = paramInt;
  }
  
  public void setDayOfWeek(int paramInt)
  {
    this.dayOfWeek = paramInt;
  }
  
  public void setDaysOfMonth(ArrayList<Integer> paramArrayList)
  {
    this.daysOfMonth = paramArrayList;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setExceptionHashMap(HashMap<Integer, RecurringException> paramHashMap)
  {
    this.exceptionHashMap = paramHashMap;
  }
  
  public void setExceptions(ArrayList<RecurringException> paramArrayList)
  {
    this.exceptions = paramArrayList;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public void setIsAllDay(boolean paramBoolean)
  {
    this.isAllDay = paramBoolean;
  }
  
  public void setIsDecline(boolean paramBoolean)
  {
    this.isDecline = paramBoolean;
  }
  
  public void setIsLunarCalendar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.attribute |= 0x1;
      return;
    }
    this.attribute &= 0xFFFFFFFE;
  }
  
  public void setLeapMonth(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.attribute |= 0x2;
      return;
    }
    this.attribute &= 0xFFFFFFFD;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setMeetingStatus(int paramInt)
  {
    this.meetingStatus = paramInt;
  }
  
  public void setModifyTime(long paramLong)
  {
    this.modifyTime = paramLong;
  }
  
  public void setMonthOfYear(int paramInt)
  {
    this.monthOfYear = paramInt;
  }
  
  public void setOffLineOptType(int paramInt)
  {
    if (paramInt > this.offLineOptType) {
      this.offLineOptType = paramInt;
    }
  }
  
  public void setOrganizerEmail(String paramString)
  {
    this.organizerEmail = paramString;
  }
  
  public void setOrganizerName(String paramString)
  {
    this.organizerName = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setRecurrenceType(int paramInt)
  {
    this.recurrenceType = paramInt;
  }
  
  public void setRelateAccountId(int paramInt)
  {
    this.relateAccountId = paramInt;
  }
  
  public void setRelateType(int paramInt)
  {
    this.relateType = paramInt;
  }
  
  public void setRelatedId(String paramString)
  {
    this.relatedId = paramString;
  }
  
  public void setReminder(int paramInt)
  {
    this.reminder = paramInt;
  }
  
  public void setReminderId(int paramInt)
  {
    this.reminderId = paramInt;
  }
  
  public void setResponseType(int paramInt)
  {
    this.responseType = paramInt;
  }
  
  public void setSensivity(int paramInt)
  {
    this.sensivity = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setSvrId(String paramString)
  {
    this.svrId = paramString;
  }
  
  public void setTimezone(String paramString)
  {
    this.timezone = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setUntil(long paramLong)
  {
    this.until = paramLong;
  }
  
  public void setWeekOfMonth(int paramInt)
  {
    this.weekOfMonth = paramInt;
  }
  
  public void seteTag(String paramString)
  {
    this.eTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMCalendarEvent
 * JD-Core Version:    0.7.0.1
 */