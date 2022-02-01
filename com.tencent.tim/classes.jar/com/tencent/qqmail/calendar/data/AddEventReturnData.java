package com.tencent.qqmail.calendar.data;

public class AddEventReturnData
{
  private String eTag;
  private String eventPath;
  private String eventSvrId;
  private String eventUid;
  private String folderSyncKey;
  
  public String getEventPath()
  {
    return this.eventPath;
  }
  
  public String getEventSvrId()
  {
    return this.eventSvrId;
  }
  
  public String getEventUid()
  {
    return this.eventUid;
  }
  
  public String getFolderSyncKey()
  {
    return this.folderSyncKey;
  }
  
  public String geteTag()
  {
    return this.eTag;
  }
  
  public void setEventPath(String paramString)
  {
    this.eventPath = paramString;
  }
  
  public void setEventSvrId(String paramString)
  {
    this.eventSvrId = paramString;
  }
  
  public void setEventUid(String paramString)
  {
    this.eventUid = paramString;
  }
  
  public void setFolderSyncKey(String paramString)
  {
    this.folderSyncKey = paramString;
  }
  
  public void seteTag(String paramString)
  {
    this.eTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.AddEventReturnData
 * JD-Core Version:    0.7.0.1
 */