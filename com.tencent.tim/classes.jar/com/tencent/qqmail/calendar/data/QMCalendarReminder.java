package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;

public class QMCalendarReminder
{
  private int accountId;
  private long eventId;
  private long eventStartTime;
  private int folderId;
  private int id;
  private long remindTime;
  private long startTime;
  private String subject;
  
  public static int generateId(QMCalendarReminder paramQMCalendarReminder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMCalendarReminder.getAccountId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarReminder.getEventId());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMCalendarReminder.getRemindTime());
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public long getEventId()
  {
    return this.eventId;
  }
  
  public long getEventStartTime()
  {
    return this.eventStartTime;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public long getRemindTime()
  {
    return this.remindTime;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setEventId(long paramLong)
  {
    this.eventId = paramLong;
  }
  
  public void setEventStartTime(long paramLong)
  {
    this.eventStartTime = paramLong;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setRemindTime(long paramLong)
  {
    this.remindTime = paramLong;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMCalendarReminder
 * JD-Core Version:    0.7.0.1
 */