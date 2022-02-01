package com.tencent.qqmail.ftn.model;

public class FtnUserProfile
{
  private long preserverDay = 30L;
  private int renewDay = 7;
  private long singleMaxSize = 2147483648L;
  private float storage;
  private String uin;
  private float usage;
  
  public FtnUserProfile(String paramString)
  {
    this.uin = paramString;
  }
  
  public long getPreserverDay()
  {
    return this.preserverDay;
  }
  
  public int getRenewDay()
  {
    return this.renewDay;
  }
  
  public long getSingleMaxSize()
  {
    return this.singleMaxSize;
  }
  
  public float getStorage()
  {
    return this.storage;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public float getUsage()
  {
    return this.usage;
  }
  
  public void setPreserverDay(long paramLong)
  {
    this.preserverDay = paramLong;
  }
  
  public void setRenewDay(int paramInt)
  {
    this.renewDay = paramInt;
  }
  
  public void setSingleMaxSize(long paramLong)
  {
    this.singleMaxSize = paramLong;
  }
  
  public void setStorage(float paramFloat)
  {
    this.storage = paramFloat;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void setUsage(float paramFloat)
  {
    this.usage = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnUserProfile
 * JD-Core Version:    0.7.0.1
 */