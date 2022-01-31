package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ExtensionInfo
  extends Entity
{
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public long pendantId;
  public long timestamp = 0L;
  public long uVipFont;
  @unique
  public String uin;
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */