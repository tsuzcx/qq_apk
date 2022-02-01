package com.tencent.qqmail.calendar.data;

public class CalendarFolderChangeSyncData
{
  private int accountId;
  private ActiveSyncData activeSyncData;
  private QMCalendarFolder folder;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ActiveSyncData getActiveSyncData()
  {
    return this.activeSyncData;
  }
  
  public QMCalendarFolder getFolder()
  {
    return this.folder;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setActiveSyncData(ActiveSyncData paramActiveSyncData)
  {
    this.activeSyncData = paramActiveSyncData;
  }
  
  public void setFolder(QMCalendarFolder paramQMCalendarFolder)
  {
    this.folder = paramQMCalendarFolder;
  }
  
  public static class ActiveSyncData
  {
    private String syncKey;
    
    public String getSyncKey()
    {
      return this.syncKey;
    }
    
    public void setSyncKey(String paramString)
    {
      this.syncKey = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarFolderChangeSyncData
 * JD-Core Version:    0.7.0.1
 */