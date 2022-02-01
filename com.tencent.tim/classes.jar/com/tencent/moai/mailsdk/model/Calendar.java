package com.tencent.moai.mailsdk.model;

public class Calendar
{
  private int busyStatus;
  private int calendarType;
  private long dtStamp;
  private long endTime;
  private boolean isAllDayEvent;
  private String location;
  private String organizer;
  private Recurrence recurrence;
  private int reminder;
  private boolean responseRequested;
  private int sensitivity;
  private long startTime;
  private String subject;
  private String subscribe;
  private String timeZone;
  private String uid;
  
  public int getBusyStatus()
  {
    return this.busyStatus;
  }
  
  public int getCalendarType()
  {
    return this.calendarType;
  }
  
  public long getDtStamp()
  {
    return this.dtStamp;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getOrganizer()
  {
    return this.organizer;
  }
  
  public Recurrence getRecurrence()
  {
    return this.recurrence;
  }
  
  public int getReminder()
  {
    return this.reminder;
  }
  
  public int getSensitivity()
  {
    return this.sensitivity;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getSubscribe()
  {
    return this.subscribe;
  }
  
  public String getTimeZone()
  {
    return this.timeZone;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public boolean isAllDayEvent()
  {
    return this.isAllDayEvent;
  }
  
  public boolean isResponseRequested()
  {
    return this.responseRequested;
  }
  
  public void setAllDayEvent(boolean paramBoolean)
  {
    this.isAllDayEvent = paramBoolean;
  }
  
  public void setBusyStatus(int paramInt)
  {
    this.busyStatus = paramInt;
  }
  
  public void setCalendarType(int paramInt)
  {
    this.calendarType = paramInt;
  }
  
  public void setDtStamp(long paramLong)
  {
    this.dtStamp = paramLong;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setOrganizer(String paramString)
  {
    this.organizer = paramString;
  }
  
  public void setRecurrence(Recurrence paramRecurrence)
  {
    this.recurrence = paramRecurrence;
  }
  
  public void setReminder(int paramInt)
  {
    this.reminder = paramInt;
  }
  
  public void setResponseRequested(boolean paramBoolean)
  {
    this.responseRequested = paramBoolean;
  }
  
  public void setSensitivity(int paramInt)
  {
    this.sensitivity = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setSubscribe(String paramString)
  {
    this.subscribe = paramString;
  }
  
  public void setTimeZone(String paramString)
  {
    this.timeZone = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Calendar
 * JD-Core Version:    0.7.0.1
 */