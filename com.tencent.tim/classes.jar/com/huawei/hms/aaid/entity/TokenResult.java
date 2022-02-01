package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

public class TokenResult
  extends Result
{
  @Packed
  private String belongId;
  @Packed
  private int retCode = 0;
  @Packed
  private String token = "";
  
  public String getBelongId()
  {
    return this.belongId;
  }
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setBelongId(String paramString)
  {
    this.belongId = paramString;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.entity.TokenResult
 * JD-Core Version:    0.7.0.1
 */