package com.tencent.qqmail.calendar.provider.model;

public class CPEvent
{
  private String accountName;
  private String accountType;
  private int allDay;
  private long calendarId;
  private String description;
  private long dtEnd;
  private long dtStart;
  private String duration;
  private String eventEndTimezone;
  private String eventLocation;
  private String eventTimezone;
  private String exdate;
  private String exrule;
  private int hasAttendeeData;
  private long id;
  private int isOrganizer;
  private String organizer;
  private int originalAllDay;
  private long originalId;
  private String originalInstanceTime;
  private String originalSyncId;
  private String rdate;
  private String rrule;
  private int status;
  private String syncId;
  private String title;
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getAccountType()
  {
    return this.accountType;
  }
  
  public int getAllDay()
  {
    return this.allDay;
  }
  
  public long getCalendarId()
  {
    return this.calendarId;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public long getDtEnd()
  {
    return this.dtEnd;
  }
  
  public long getDtStart()
  {
    return this.dtStart;
  }
  
  public String getDuration()
  {
    return this.duration;
  }
  
  public String getEventEndTimezone()
  {
    return this.eventEndTimezone;
  }
  
  public String getEventLocation()
  {
    return this.eventLocation;
  }
  
  public String getEventTimezone()
  {
    return this.eventTimezone;
  }
  
  public String getExdate()
  {
    return this.exdate;
  }
  
  public String getExrule()
  {
    return this.exrule;
  }
  
  public int getHasAttendeeData()
  {
    return this.hasAttendeeData;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getIsOrganizer()
  {
    return this.isOrganizer;
  }
  
  public String getOrganizer()
  {
    return this.organizer;
  }
  
  public int getOriginalAllDay()
  {
    return this.originalAllDay;
  }
  
  public long getOriginalId()
  {
    return this.originalId;
  }
  
  public String getOriginalInstanceTime()
  {
    return this.originalInstanceTime;
  }
  
  public String getOriginalSyncId()
  {
    return this.originalSyncId;
  }
  
  public String getRdate()
  {
    return this.rdate;
  }
  
  public String getRrule()
  {
    return this.rrule;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getSyncId()
  {
    return this.syncId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setAccountName(String paramString)
  {
    this.accountName = paramString;
  }
  
  public void setAccountType(String paramString)
  {
    this.accountType = paramString;
  }
  
  public void setAllDay(int paramInt)
  {
    this.allDay = paramInt;
  }
  
  public void setCalendarId(long paramLong)
  {
    this.calendarId = paramLong;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setDtEnd(long paramLong)
  {
    this.dtEnd = paramLong;
  }
  
  public void setDtStart(long paramLong)
  {
    this.dtStart = paramLong;
  }
  
  public void setDuration(String paramString)
  {
    this.duration = paramString;
  }
  
  public void setEventEndTimezone(String paramString)
  {
    this.eventEndTimezone = paramString;
  }
  
  public void setEventLocation(String paramString)
  {
    this.eventLocation = paramString;
  }
  
  public void setEventTimezone(String paramString)
  {
    this.eventTimezone = paramString;
  }
  
  public void setExdate(String paramString)
  {
    this.exdate = paramString;
  }
  
  public void setExrule(String paramString)
  {
    this.exrule = paramString;
  }
  
  public void setHasAttendeeData(int paramInt)
  {
    this.hasAttendeeData = paramInt;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIsOrganizer(int paramInt)
  {
    this.isOrganizer = paramInt;
  }
  
  public void setOrganizer(String paramString)
  {
    this.organizer = paramString;
  }
  
  public void setOriginalAllDay(int paramInt)
  {
    this.originalAllDay = paramInt;
  }
  
  public void setOriginalId(long paramLong)
  {
    this.originalId = paramLong;
  }
  
  public void setOriginalInstanceTime(String paramString)
  {
    this.originalInstanceTime = paramString;
  }
  
  public void setOriginalSyncId(String paramString)
  {
    this.originalSyncId = paramString;
  }
  
  public void setRdate(String paramString)
  {
    this.rdate = paramString;
  }
  
  public void setRrule(String paramString)
  {
    this.rrule = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setSyncId(String paramString)
  {
    this.syncId = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "CPEvent{id=" + this.id + ", calendarId=" + this.calendarId + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", eventLocation='" + this.eventLocation + '\'' + ", status=" + this.status + ", dtStart=" + this.dtStart + ", dtEnd=" + this.dtEnd + ", duration='" + this.duration + '\'' + ", eventTimezone='" + this.eventTimezone + '\'' + ", eventEndTimezone='" + this.eventEndTimezone + '\'' + ", allDay=" + this.allDay + ", rrule='" + this.rrule + '\'' + ", rdate='" + this.rdate + '\'' + ", exrule='" + this.exrule + '\'' + ", exdate='" + this.exdate + '\'' + ", originalId=" + this.originalId + ", originalSyncId='" + this.originalSyncId + '\'' + ", originalInstanceTime='" + this.originalInstanceTime + '\'' + ", originalAllDay=" + this.originalAllDay + ", hasAttendeeData=" + this.hasAttendeeData + ", organizer='" + this.organizer + '\'' + ", isOrganizer=" + this.isOrganizer + ", accountName='" + this.accountName + '\'' + ", accountType='" + this.accountType + '\'' + ", syncId='" + this.syncId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.model.CPEvent
 * JD-Core Version:    0.7.0.1
 */