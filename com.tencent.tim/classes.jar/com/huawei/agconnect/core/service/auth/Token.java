package com.huawei.agconnect.core.service.auth;

public abstract interface Token
{
  public abstract long getExpiration();
  
  public abstract long getIssuedAt();
  
  public abstract long getNotBefore();
  
  public abstract String getTokenString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.core.service.auth.Token
 * JD-Core Version:    0.7.0.1
 */