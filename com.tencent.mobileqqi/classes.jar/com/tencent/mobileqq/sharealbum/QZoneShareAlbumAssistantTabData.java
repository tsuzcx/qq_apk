package com.tencent.mobileqq.sharealbum;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class QZoneShareAlbumAssistantTabData
  extends Entity
{
  @unique
  public String account = "";
  public long albumNum = 0L;
  public long lastmsgtime = 0L;
  public String msg = "";
  public int unread = 0;
  
  public QZoneShareAlbumAssistantTabData() {}
  
  public QZoneShareAlbumAssistantTabData(String paramString)
  {
    this.account = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantTabData
 * JD-Core Version:    0.7.0.1
 */