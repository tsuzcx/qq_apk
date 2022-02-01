package com.tencent.qqmail.calendar.data;

import java.util.ArrayList;

public class CalendarFolderSyncData
{
  private int accountId;
  private ActiveSyncData activeSyncData;
  private ArrayList<CalendarFolderSyncItemData> addFolders = null;
  private CalDavData caldavData;
  private ArrayList<CalendarFolderSyncItemData> modifyFolders = null;
  private String[] removeFolders = null;
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ActiveSyncData getActiveSyncData()
  {
    return this.activeSyncData;
  }
  
  public ArrayList<CalendarFolderSyncItemData> getAddFolders()
  {
    return this.addFolders;
  }
  
  public CalDavData getCaldavData()
  {
    return this.caldavData;
  }
  
  public ArrayList<CalendarFolderSyncItemData> getModifyFolders()
  {
    return this.modifyFolders;
  }
  
  public String[] getRemoveFolders()
  {
    return this.removeFolders;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setActiveSyncData(ActiveSyncData paramActiveSyncData)
  {
    this.activeSyncData = paramActiveSyncData;
  }
  
  public void setAddFolders(ArrayList<CalendarFolderSyncItemData> paramArrayList)
  {
    this.addFolders = paramArrayList;
  }
  
  public void setCaldavData(CalDavData paramCalDavData)
  {
    this.caldavData = paramCalDavData;
  }
  
  public void setModifyFolders(ArrayList<CalendarFolderSyncItemData> paramArrayList)
  {
    this.modifyFolders = paramArrayList;
  }
  
  public void setRemoveFolders(String[] paramArrayOfString)
  {
    this.removeFolders = paramArrayOfString;
  }
  
  public static class ActiveSyncData
  {
    private String serverAddr;
    private String syncKey;
    
    public String getServerAddr()
    {
      return this.serverAddr;
    }
    
    public String getSyncKey()
    {
      return this.syncKey;
    }
    
    public void setServerAddr(String paramString)
    {
      this.serverAddr = paramString;
    }
    
    public void setSyncKey(String paramString)
    {
      this.syncKey = paramString;
    }
  }
  
  public static class CalDavData
  {
    private String homeSetPath;
    
    public String getHomeSetPath()
    {
      return this.homeSetPath;
    }
    
    public void setHomeSetPath(String paramString)
    {
      this.homeSetPath = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarFolderSyncData
 * JD-Core Version:    0.7.0.1
 */