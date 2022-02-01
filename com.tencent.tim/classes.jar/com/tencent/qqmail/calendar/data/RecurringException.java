package com.tencent.qqmail.calendar.data;

import org.apache.commons.lang3.StringUtils;

public class RecurringException
{
  private String body;
  private long endTime;
  private long eventId;
  private long exceptionStartTime;
  private String id;
  private boolean isAllDay;
  private boolean isDelete;
  private String location;
  private int reminder;
  private long startTime;
  private String subject;
  
  public static String generateId(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1).append("_").append(paramLong2);
    return localStringBuilder.toString();
  }
  
  public static String generateId(RecurringException paramRecurringException)
  {
    return generateId(paramRecurringException.getEventId(), paramRecurringException.getExceptionStartTime());
  }
  
  public static long getExceptionStartTimeFromId(String paramString)
  {
    long l2 = 0L;
    try
    {
      paramString = paramString.split("_");
      long l1 = l2;
      if (paramString != null)
      {
        l1 = l2;
        if (paramString.length > 1)
        {
          l1 = l2;
          if (!StringUtils.isBlank(paramString[1])) {
            l1 = Long.valueOf(paramString[1]).longValue();
          }
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public String getBody()
  {
    return this.body;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public long getEventId()
  {
    return this.eventId;
  }
  
  public long getExceptionStartTime()
  {
    return this.exceptionStartTime;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public int getReminder()
  {
    return this.reminder;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public boolean isAllDay()
  {
    return this.isAllDay;
  }
  
  public boolean isDelete()
  {
    return this.isDelete;
  }
  
  public void setBody(String paramString)
  {
    this.body = paramString;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setEventId(long paramLong)
  {
    this.eventId = paramLong;
  }
  
  public void setExceptionStartTime(long paramLong)
  {
    this.exceptionStartTime = paramLong;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsAllDay(boolean paramBoolean)
  {
    this.isAllDay = paramBoolean;
  }
  
  public void setIsDelete(boolean paramBoolean)
  {
    this.isDelete = paramBoolean;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setReminder(int paramInt)
  {
    this.reminder = paramInt;
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
 * Qualified Name:     com.tencent.qqmail.calendar.data.RecurringException
 * JD-Core Version:    0.7.0.1
 */