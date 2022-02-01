package com.tencent.qqmail.calendar.provider.model;

public class CPAttendee
{
  private String attendeeEmail;
  private String attendeeName;
  private int attendeeStatus;
  private int attendeeType;
  private long eventId;
  private long id;
  
  public String getAttendeeEmail()
  {
    return this.attendeeEmail;
  }
  
  public String getAttendeeName()
  {
    return this.attendeeName;
  }
  
  public int getAttendeeStatus()
  {
    return this.attendeeStatus;
  }
  
  public int getAttendeeType()
  {
    return this.attendeeType;
  }
  
  public long getEventId()
  {
    return this.eventId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public void setAttendeeEmail(String paramString)
  {
    this.attendeeEmail = paramString;
  }
  
  public void setAttendeeName(String paramString)
  {
    this.attendeeName = paramString;
  }
  
  public void setAttendeeStatus(int paramInt)
  {
    this.attendeeStatus = paramInt;
  }
  
  public void setAttendeeType(int paramInt)
  {
    this.attendeeType = paramInt;
  }
  
  public void setEventId(long paramLong)
  {
    this.eventId = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public String toString()
  {
    return "CPAttendee{id=" + this.id + ", eventId=" + this.eventId + ", attendeeName='" + this.attendeeName + '\'' + ", attendeeEmail='" + this.attendeeEmail + '\'' + ", attendeeType=" + this.attendeeType + ", attendeeStatus=" + this.attendeeStatus + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.model.CPAttendee
 * JD-Core Version:    0.7.0.1
 */