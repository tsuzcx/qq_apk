package com.tencent.qqmail.calendar.provider.model;

public class CPInstance
{
  private long begin;
  private long end;
  private int endDay;
  private int endMinute;
  private long eventId;
  private long id;
  private int startDay;
  private int startMinute;
  
  public long getBegin()
  {
    return this.begin;
  }
  
  public long getEnd()
  {
    return this.end;
  }
  
  public int getEndDay()
  {
    return this.endDay;
  }
  
  public int getEndMinute()
  {
    return this.endMinute;
  }
  
  public long getEventId()
  {
    return this.eventId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getStartDay()
  {
    return this.startDay;
  }
  
  public int getStartMinute()
  {
    return this.startMinute;
  }
  
  public void setBegin(long paramLong)
  {
    this.begin = paramLong;
  }
  
  public void setEnd(long paramLong)
  {
    this.end = paramLong;
  }
  
  public void setEndDay(int paramInt)
  {
    this.endDay = paramInt;
  }
  
  public void setEndMinute(int paramInt)
  {
    this.endMinute = paramInt;
  }
  
  public void setEventId(long paramLong)
  {
    this.eventId = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setStartDay(int paramInt)
  {
    this.startDay = paramInt;
  }
  
  public void setStartMinute(int paramInt)
  {
    this.startMinute = paramInt;
  }
  
  public String toString()
  {
    return "CPInstance{id=" + this.id + ", begin=" + this.begin + ", end=" + this.end + ", eventId=" + this.eventId + ", startDay=" + this.startDay + ", endDay=" + this.endDay + ", startMinute=" + this.startMinute + ", endMinute=" + this.endMinute + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.model.CPInstance
 * JD-Core Version:    0.7.0.1
 */