package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;

public class QMSchedule
{
  private int category;
  private int color = -1;
  private long eid;
  private long endTime;
  private long eventEndTime;
  private long eventStartTime;
  private String exceptionId;
  private int id;
  private boolean isAllDay;
  private String location;
  private int relatedType = 0;
  private int scheduleDate;
  private long startTime;
  private String subject;
  
  public static int generateId(QMSchedule paramQMSchedule)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQMSchedule.getEid());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMSchedule.getStartTime());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMSchedule.getEndTime());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMSchedule.getEventStartTime());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMSchedule.getEventEndTime());
    localStringBuilder.append("^");
    localStringBuilder.append(paramQMSchedule.getExceptionId());
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public int getCategory()
  {
    return this.category;
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public long getEid()
  {
    return this.eid;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public long getEventEndTime()
  {
    return this.eventEndTime;
  }
  
  public long getEventStartTime()
  {
    return this.eventStartTime;
  }
  
  public String getExceptionId()
  {
    return this.exceptionId;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public int getRelatedType()
  {
    return this.relatedType;
  }
  
  public int getScheduleDate()
  {
    return this.scheduleDate;
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
  
  public void setCategory(int paramInt)
  {
    this.category = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public void setEid(long paramLong)
  {
    this.eid = paramLong;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setEventEndTime(long paramLong)
  {
    this.eventEndTime = paramLong;
  }
  
  public void setEventStartTime(long paramLong)
  {
    this.eventStartTime = paramLong;
  }
  
  public void setExceptionId(String paramString)
  {
    this.exceptionId = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsAllDay(boolean paramBoolean)
  {
    this.isAllDay = paramBoolean;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setRelatedType(int paramInt)
  {
    this.relatedType = paramInt;
  }
  
  public void setScheduleDate(int paramInt)
  {
    this.scheduleDate = paramInt;
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
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMSchedule
 * JD-Core Version:    0.7.0.1
 */