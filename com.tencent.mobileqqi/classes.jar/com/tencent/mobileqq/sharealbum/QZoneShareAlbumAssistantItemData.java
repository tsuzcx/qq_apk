package com.tencent.mobileqq.sharealbum;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QZoneShareAlbumAssistantItemData
  extends Entity
{
  @unique
  public String albumID;
  public String albumName;
  public String desc;
  public boolean isUnread;
  public long lastmsgtime;
  public long unreadCount = 0L;
  public String url;
  public int userCount;
  public String users;
  
  public int compareTo(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    return this.albumID.compareTo(paramQZoneShareAlbumAssistantItemData.albumID);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof QZoneShareAlbumAssistantItemData))) {
        return false;
      }
    } while (compareTo((QZoneShareAlbumAssistantItemData)paramObject) == 0);
    return false;
  }
  
  public String toString()
  {
    return "ShareAlbumAssistantItemData [albumID=" + this.albumID + ", albumName=" + this.albumName + ", lastmsgtime=" + this.lastmsgtime + ", unreadCount=" + this.unreadCount + ", desc=" + this.desc + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantItemData
 * JD-Core Version:    0.7.0.1
 */