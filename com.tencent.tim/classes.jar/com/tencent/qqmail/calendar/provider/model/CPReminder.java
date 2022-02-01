package com.tencent.qqmail.calendar.provider.model;

public class CPReminder
{
  private long eventId;
  private long id;
  private int method;
  private int minutes;
  
  public long getEventId()
  {
    return this.eventId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getMethod()
  {
    return this.method;
  }
  
  public int getMinutes()
  {
    return this.minutes;
  }
  
  public void setEventId(long paramLong)
  {
    this.eventId = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setMethod(int paramInt)
  {
    this.method = paramInt;
  }
  
  public void setMinutes(int paramInt)
  {
    this.minutes = paramInt;
  }
  
  public String toString()
  {
    return "CPReminder{id=" + this.id + ", eventId=" + this.eventId + ", method=" + this.method + ", minutes=" + this.minutes + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.model.CPReminder
 * JD-Core Version:    0.7.0.1
 */