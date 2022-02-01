package com.tencent.qqmail.calendar.provider.model;

public class CPCalendar
{
  private String accountName;
  private String accountType;
  private int calendarAccessLevel;
  private int calendarColor;
  private String calendarDisplayName;
  private long id;
  private String name;
  private String ownerAccount;
  private int visible;
  
  public String getAccountName()
  {
    return this.accountName;
  }
  
  public String getAccountType()
  {
    return this.accountType;
  }
  
  public int getCalendarAccessLevel()
  {
    return this.calendarAccessLevel;
  }
  
  public int getCalendarColor()
  {
    return this.calendarColor;
  }
  
  public String getCalendarDisplayName()
  {
    return this.calendarDisplayName;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public int getVisible()
  {
    return this.visible;
  }
  
  public void setAccountName(String paramString)
  {
    this.accountName = paramString;
  }
  
  public void setAccountType(String paramString)
  {
    this.accountType = paramString;
  }
  
  public void setCalendarAccessLevel(int paramInt)
  {
    this.calendarAccessLevel = paramInt;
  }
  
  public void setCalendarColor(int paramInt)
  {
    this.calendarColor = paramInt;
  }
  
  public void setCalendarDisplayName(String paramString)
  {
    this.calendarDisplayName = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setVisible(int paramInt)
  {
    this.visible = paramInt;
  }
  
  public String toString()
  {
    return "CPCalendar{id=" + this.id + ", name='" + this.name + '\'' + ", calendarColor=" + this.calendarColor + ", calendarDisplayName='" + this.calendarDisplayName + '\'' + ", calendarAccessLevel=" + this.calendarAccessLevel + ", visible=" + this.visible + ", ownerAccount='" + this.ownerAccount + '\'' + ", accountName='" + this.accountName + '\'' + ", accountType='" + this.accountType + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.model.CPCalendar
 * JD-Core Version:    0.7.0.1
 */