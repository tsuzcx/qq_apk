package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class AuthClearInfo
  implements IMessageEntity
{
  public static final int TYPE_CLEAR_ALL = 1;
  public static final int TYPE_CLEAR_APP = 0;
  @Packed
  private String appID;
  @Packed
  private int type = 0;
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.AuthClearInfo
 * JD-Core Version:    0.7.0.1
 */