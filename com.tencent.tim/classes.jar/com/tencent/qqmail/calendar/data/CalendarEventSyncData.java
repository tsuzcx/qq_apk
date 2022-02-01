package com.tencent.qqmail.calendar.data;

import java.util.ArrayList;

public class CalendarEventSyncData
{
  private int accountId;
  private ArrayList<QMCalendarEvent> addEventList;
  private int calendarFolderId;
  private String calendarFolderSyncKey = "";
  private String calendarFolderSyncToken = "";
  private ArrayList<QMCalendarEvent> modifyEventList;
  private String[] removeEventList;
  private int returnCode = -1;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ArrayList<QMCalendarEvent> getAddEventList()
  {
    return this.addEventList;
  }
  
  public int getCalendarFolderId()
  {
    return this.calendarFolderId;
  }
  
  public String getCalendarFolderSyncKey()
  {
    return this.calendarFolderSyncKey;
  }
  
  public String getCalendarFolderSyncToken()
  {
    return this.calendarFolderSyncToken;
  }
  
  public ArrayList<QMCalendarEvent> getModifyEventList()
  {
    return this.modifyEventList;
  }
  
  public String[] getRemoveEventList()
  {
    return this.removeEventList;
  }
  
  public int getReturnCode()
  {
    return this.returnCode;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAddEventList(ArrayList<QMCalendarEvent> paramArrayList)
  {
    this.addEventList = paramArrayList;
  }
  
  public void setCalendarFolderId(int paramInt)
  {
    this.calendarFolderId = paramInt;
  }
  
  public void setCalendarFolderSyncKey(String paramString)
  {
    this.calendarFolderSyncKey = paramString;
  }
  
  public void setCalendarFolderSyncToken(String paramString)
  {
    this.calendarFolderSyncToken = paramString;
  }
  
  public void setModifyEventList(ArrayList<QMCalendarEvent> paramArrayList)
  {
    this.modifyEventList = paramArrayList;
  }
  
  public void setRemoveEventList(String[] paramArrayOfString)
  {
    this.removeEventList = paramArrayOfString;
  }
  
  public void setReturnCode(int paramInt)
  {
    this.returnCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarEventSyncData
 * JD-Core Version:    0.7.0.1
 */