package com.tencent.moai.mailsdk.model;

public class Folder
{
  public static final int TYPE_ALL_MAIL = 8;
  public static final int TYPE_CALENDAR = 7;
  public static final int TYPE_DRAFT = 2;
  public static final int TYPE_FLAGGED = 9;
  public static final int TYPE_IMPORTANT = 10;
  public static final int TYPE_INBOX = 1;
  public static final int TYPE_SENT = 4;
  public static final int TYPE_SPAM = 5;
  public static final int TYPE_TRASH = 3;
  public static final int TYPE_USER = 6;
  private String distinguishedFolderId;
  private int folderId;
  private boolean isTop;
  private boolean isVirtual;
  private String name;
  private String parentId;
  private String path;
  private String remoteId;
  private String svrKey;
  private String syncState;
  private int totalCount;
  private int type;
  private long uidValidity;
  private int unreadCount;
  
  public String getDistinguishedFolderId()
  {
    return this.distinguishedFolderId;
  }
  
  public int getFolderId()
  {
    return this.folderId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getParentId()
  {
    return this.parentId;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public String getSvrKey()
  {
    return this.svrKey;
  }
  
  public String getSyncState()
  {
    return this.syncState;
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public long getUidValidity()
  {
    return this.uidValidity;
  }
  
  public int getUnreadCount()
  {
    return this.unreadCount;
  }
  
  public boolean isTop()
  {
    return this.isTop;
  }
  
  public boolean isVirtual()
  {
    return this.isVirtual;
  }
  
  public void setDistinguishedFolderId(String paramString)
  {
    this.distinguishedFolderId = paramString;
  }
  
  public void setFolderId(int paramInt)
  {
    this.folderId = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParentId(String paramString)
  {
    this.parentId = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setSvrKey(String paramString)
  {
    this.svrKey = paramString;
  }
  
  public void setSyncState(String paramString)
  {
    this.syncState = paramString;
  }
  
  public void setTop(boolean paramBoolean)
  {
    this.isTop = paramBoolean;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.totalCount = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUidValidity(long paramLong)
  {
    this.uidValidity = paramLong;
  }
  
  public void setUnreadCount(int paramInt)
  {
    this.unreadCount = paramInt;
  }
  
  public void setVirtual(boolean paramBoolean)
  {
    this.isVirtual = paramBoolean;
  }
  
  public String toString()
  {
    return "Folder{remoteId='" + this.remoteId + '\'' + ", path='" + this.path + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", parentId=" + this.parentId + ", totalCount=" + this.totalCount + ", unreadCount=" + this.unreadCount + ", isVirtual=" + this.isVirtual + ", isTop=" + this.isTop + ", uidValidity=" + this.uidValidity + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Folder
 * JD-Core Version:    0.7.0.1
 */