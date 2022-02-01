package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.utilities.QMMath;

public class QMCalendarShare
{
  public static final int STATE_ACCEPT = 1;
  public static final int STATE_DECLINE = 2;
  public static final int STATE_TENTATIVE = 0;
  private int calendarFolderId;
  private String email;
  private long id;
  private String name;
  private int state;
  
  public static long generateId(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("^");
    localStringBuilder.append(paramString);
    return QMMath.hashLong(localStringBuilder.toString());
  }
  
  public int getCalendarFolderId()
  {
    return this.calendarFolderId;
  }
  
  public String getDisplayName()
  {
    String str2 = getName();
    String str3 = getEmail();
    String str1;
    if ((str2 != null) && (!str2.equals("")))
    {
      str1 = str2;
      if (!str2.equals("null")) {}
    }
    else
    {
      str1 = str3;
    }
    return str1;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setCalendarFolderId(int paramInt)
  {
    this.calendarFolderId = paramInt;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMCalendarShare
 * JD-Core Version:    0.7.0.1
 */